# FREELOADER 課題の解決策

`SearchRepository` に SQL インジェクションがあります。
これを修正するには、パラメータ化されたクエリを実装することです。Hibernate の実装は、インジェクションを防ぐために内部で準備されたステートメントを使用します。
可能な解決策は以下の通りです：

```java
    public List<Product> searchProduct (String input) {
        var lowerInput = input.toLowerCase(Locale.ROOT);
        String querytext = "Select * from Product where lower(description) like CONCAT('%', ?1, '%') OR lower(product_name) like CONCAT('%', ?2, '%')";
        var query = em.createNativeQuery(querytext, Product.class);
        query.setParameter(1, lowerInput);
        query.setParameter(2, lowerInput);
        var resultList = (List<Product>) query.getResultList();
        return resultList;
    }
```