# [:] Example Kotlin Maven Project - scan 1

An example maven project to demonstrate [srcclr](https://www.srcclr.com) scans.

## Try me!

```
brew tap srcclr/srcclr
brew install srcclr
srcclr activate
srcclr scan --url https://github.com/srcclr/example-kotlin-maven
```

## With SourceClear's Maven Plugin
```
git clone https://github.com/srcclr/example-kotlin-maven
cd example-java-kotlin
mvn clean compile com.srcclr:srcclr-maven-plugin:scan -DapiToken=<yourSourceClearToken>
``
