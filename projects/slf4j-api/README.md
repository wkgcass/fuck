# slf4j-api

## Fuck

1. compile with JDK 11
2. place `module-info.class` under the root of the jar
3. add an option `-Dorg.slf4j:slf4j-api::suppress-no-provider-report=true` to suppress reports
4. directly log to stdout when there is no provider available.

## Usage

```groovy
repositories {
    maven {
        url 'https://raw.githubusercontent.com/wkgcass/fuck/m2'
    }
    mavenCentral()
}

dependencies {
    implementation 'org.slf4j:slf4j-api:2.0.9-fuck'
}
```

## Build

```shell
./gradlew -Dmaven.repo.local=$directory clean publishMavenPublicationToMavenLocal
```
