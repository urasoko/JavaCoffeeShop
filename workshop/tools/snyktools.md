# Snyk ツール

Snyk にサインアップすると、開発中に役立つさまざまなツールを利用できます。

Snyk には無料で使用できるいくつかの製品があります。

- [Snyk Code (コード分析または SAST)](https://docs.snyk.io/scan-application-code/snyk-code)
- [Snyk Open-Source (依存関係分析または SCA)](https://docs.snyk.io/scan-application-code/snyk-open-source)
- [Snyk Container (コンテナ分析)](https://docs.snyk.io/scan-application-code)
- [Snyk IAC (Infrastructure as Code 分析)](https://docs.snyk.io/scan-cloud-deployment/snyk-infrastructure-as-code)

これらの製品はさまざまなツールを通じて活用できるため、ワークフローに合わせて統合できます。

---
# Snyk Github 統合 (Web UI)

https://app.snyk.io で Snyk アカウントにサインイン後、GitHub プロジェクトをスキャン用に追加できます。
プロジェクトがインポートされると、以下のようなスキャン結果と共に概要に表示されます。

![Snyk Web UI にインポートされた GitHub プロジェクト](githubproject.png)

アプリケーションのさまざまなセグメントでセキュリティ脆弱性を探してみてください。

[GitHub 統合に関するドキュメント](https://docs.snyk.io/integrations/git-repository-scm-integrations/github-integration)

---
# Snyk CLI

Snyk CLI は、Snyk の機能を開発ワークフローに統合します。CLI はローカルで実行することも、CI/CD パイプライン内でプロジェクトのセキュリティ問題をスキャンするために使用できます。セキュリティ脆弱性やライセンスの問題を含みます。

## インストール

CLI をローカルマシンにインストールする方法は複数あります。

#### [npm](https://docs.snyk.io/snyk-cli/install-the-snyk-cli#install-the-snyk-cli-with-npm-or-yarn)

```npm install snyk -g```

#### [Homebrew](https://docs.snyk.io/snyk-cli/install-the-snyk-cli#install-with-homebrew-macos-linux)
```
brew tap snyk/tap
brew install snyk
```

#### [Scoop (Windows用)](https://docs.snyk.io/snyk-cli/install-the-snyk-cli#install-with-scoop-windows)
```sql
scoop bucket add snyk https://github.com/snyk/scoop-snyk
scoop install snyk
```
#### [バイナリをダウンロード](https://docs.snyk.io/snyk-cli/install-the-snyk-cli#install-with-standalone-executables)
#### [その他のオプション](https://docs.snyk.io/snyk-cli/install-the-snyk-cli)

## 認証

CLI をインストールした後、次のコマンドで認証が必要です:
```
snyk auth
```

## スキャン 
ローカルシステムでスキャンできます

コード分析 - `snyk code test`
依存関係 - `snyk test`
コンテナ - `snyk container test`

他にも多くのコマンドがあります。[サマリー](https://docs.snyk.io/snyk-cli/cli-reference)で詳細情報を確認してください。

---
# IDE 統合

多くの IDE には、IDE 内でスキャンを実行できるプラグインがあります。

例えば：
- [Eclipse](https://docs.snyk.io/ide-tools/eclipse-plugin)
- [IntelliJ IDEA](https://docs.snyk.io/ide-tools/jetbrains-plugins)
- [VS Code](https://docs.snyk.io/ide-tools/visual-studio-code-extension)
- [その他 ...](https://docs.snyk.io/ide-tools)

インストールしたい IDE のマーケットプレイスで確認してください。

### Jetbrains IntelliJ IDEA
![](ij1.png)
![](ij2.png)

[ワークショップ概要](../WORKSHOP.md)