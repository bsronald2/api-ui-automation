# ✨ Automation Demo

Java/Groovy project for test automation, API, UI testing. This framework support development of tests from smoke to E2E test implementation.

 

## Setup Development Environment

- Install [SDKMan](https://sdkman.io/install) development tools.
- Install JDKs & SDKs

```bash
$ sdk install java 8.0.232-open
$ sdk install gradle <version>
$ sdk install groovy <version>
```
- Verify JAVA installation
```bash
$ java -version
openjdk version "1.8.0_232"
OpenJDK Runtime Environment (build 1.8.0_232-b09)
OpenJDK 64-Bit Server VM (build 25.232-b09, mixed mode)
```

```bash
$ echo $JAVA_HOME
<path-to-java-directory>/.sdkman/candidates/java/8.0.232-open
```

- Install Intellij IDEA
```bash
$ sudo snap install intellij-idea-community --classic
```
- Plugins

| Plugin | README |
| ------ | ------ |
| Gherkin| [Gherkin](https://plugins.jetbrains.com/plugin/9164-gherkin) |
| Cucumber for Java| [Cucumber](https://plugins.jetbrains.com/plugin/7212-cucumber-for-java) |

## 🚀 Usage
Run the following commands at the root of your project:

- Clean & Build environment

```sh
$ gradle clean build
```

- Execute API|UI tests by cmd
```sh
$  gradle cucumber -q -PexecType="<api|ui>" -Ptags="<tagName>", -PuserName="<yourName>" -Ppassword="yourPwd" -PrequestType="<json|xml>"
```

## 📝 Reporting
The report `fileName.json` for each execution is persisted into its respective `/report_output` directory after an execution. This file is parsed by the Cucumber report plugin in order to have an HTML report output.

<p align="center">
  <img width="720" src="https://user-images.githubusercontent.com/38532498/82205592-b8564c80-98fe-11ea-910c-4fdb9a785831.gif">
</p>

## 🔨 Build with
- [Gradle](https://gradle.org/) - Dependency Management
