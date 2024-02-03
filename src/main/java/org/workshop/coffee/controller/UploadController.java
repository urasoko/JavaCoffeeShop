package org.workshop.coffee.controller;

import org.workshop.coffee.domain.Person;
import org.workshop.coffee.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.Principal;

@Controller
public class UploadController {

    @Autowired
    private PersonService personService;

    public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/uploads";

    @GetMapping("/uploadimage")
    public String displayUploadForm() {
        return "person/upload";
    }

    @PostMapping("/uploadimage")
    public String uploadImage(Model model, @RequestParam("image") MultipartFile file, Principal principal) throws IOException {
        //get fileName from file
        var fileName = file.getOriginalFilename();
        //save file to uploads folder
        var filePath = Paths.get(UPLOAD_DIRECTORY, fileName);

        //check if a path traversal exploit exists using normalize and send "msg"
        if (!filePath.normalize().startsWith(Paths.get(UPLOAD_DIRECTORY).normalize())) {
            model.addAttribute("msg", "Path traversal exploit detected");
            return "person/upload";
        }

        Files.write(filePath, file.getBytes());
        //get person
        var person = getPerson(model, principal);
        person.setProfilePicture(fileName);
        //save person
        personService.savePerson(person);
        //send "msg" to user
        model.addAttribute("msg", "Image uploaded successfully");
        model.addAttribute("person", person);
        return "person/upload";
    }

    public Person getPerson(Model model, Principal principal) {
        if (principal == null) {
            model.addAttribute("message", "ERROR");
            return null;
        }

        var user = principal.getName();
        var person = personService.findByUsername(user);
        return person;
    }
}