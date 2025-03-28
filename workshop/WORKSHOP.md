# Java セキュリティワークショップ

## 必要なソフトウェア
- Java 11 以上
- Maven インストール済み
- 適切な IDE（できれば最新の IntelliJ Community または Ultimate バージョン）
- 作業マシンへの制限なしのアクセス
- 制限なしのアクセスを持つ Github アカウント
- Docker Desktop インストール済み

## 始める前に

- このリポジトリを自分の GitHub アカウントにフォークする
- フォークしたリポジトリをクローンする
```
git clone https://github.com/<your_username>/<forked-repo>.git 
```
- https://snyk.io/signup で無料の Snyk アカウントにサインアップする（すでに持っている場合は不要）
- フォークしたプロジェクトを Snyk プロジェクトに接続し、そのままにしておく

## アプリケーションの実行
- アプリケーションのルートフォルダに移動し、Maven を使用して実行する

```
mvn spring-boot:run
```
<!-- - IDE から実行する場合は、この JVM パラメータを設定してください: `-Dcom.sun.jndi.ldap.object.trustURLCodebase=true` -->
- アプリケーションは起動時にデータを埋め込むので、コンソールに `READY` と表示されるまで待機してください。
- アプリケーションには http://localhost:8081 でアクセスできます。
- デフォルトでは、以下の2つのユーザーが設定されています。

| ユーザー名 | パスワード | ユーザータイプ |
|------------|------------|----------------|
| Admin      | admin      | ADMIN          |
| User       | user       | CUSTOMER       |

---
# 課題

アプリケーションを悪用したり脆弱性を修正したりする前に、アプリケーションを操作してその機能に慣れてください。
基本的には、アカウントを持っている場合、コーヒーやビールを注文するためのアプリケーションです。

- [課題 - FREELOADER](freeloader/assignment.md)
- [Snyk ツール](tools/snyktools.md)
- [課題 - OVERWRITE](overwrite/assignment.md)
- [課題 - I SPY](ispy/assignment.md)
- [課題 - TAKE A COOKIE](takeacookie/assignment.md)
- [課題 - YAML GADGET](yamlgadget/assignment.md)
<!-- - [課題 - LOG4SHELL](log4shell/assignment.md) -->
- [課題 - SHIP IT](shipit/assignment.md)
- [課題 - BUILD-A-BOM](buildabom/assignment.md)
- [課題 - ACTIONS](actions/assignment.md)
- [課題 - HARDENING](hardening/assignment.md)