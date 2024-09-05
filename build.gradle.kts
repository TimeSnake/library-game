plugins {
    id("java")
    id("java-base")
    id("java-library")
    id("maven-publish")
    id("io.papermc.paperweight.userdev") version "1.7.2"
    id("xyz.jpenilla.run-paper") version "2.1.0"
    id("com.github.johnrengelman.shadow") version "8.1.1"
}


group = "de.timesnake"
version = "2.0.0"
var projectId = 15

repositories {
    mavenLocal()
    mavenCentral()
    maven {
        url = uri("https://papermc.io/repo/repository/maven-public/")
    }
    maven {
        url = uri("https://git.timesnake.de/api/v4/groups/7/-/packages/maven")
        name = "timesnake"
        credentials(PasswordCredentials::class)
    }
}

dependencies {
    compileOnly("de.timesnake:database-api:3.+")

    compileOnly("de.timesnake:channel-api:5.+")

    compileOnly("de.timesnake:library-permissions:2.+")
    compileOnly("de.timesnake:library-basic:2.+")
    compileOnly("de.timesnake:library-chat:2.+")

    paperweight.paperDevBundle("1.21-R0.1-SNAPSHOT")
}

configurations.configureEach {
    resolutionStrategy.dependencySubstitution {
        if (project.parent != null) {
            substitute(module("de.timesnake:database-api")).using(project(":database:database-api"))

            substitute(module("de.timesnake:channel-api")).using(project(":channel:channel-api"))

            substitute(module("de.timesnake:library-permissions")).using(project(":libraries:library-permissions"))
            substitute(module("de.timesnake:library-basic")).using(project(":libraries:library-basic"))
            substitute(module("de.timesnake:library-chat")).using(project(":libraries:library-chat"))
        }
    }
}

publishing {
    repositories {
        maven {
            url = uri("https://git.timesnake.de/api/v4/projects/$projectId/packages/maven")
            name = "timesnake"
            credentials(PasswordCredentials::class)
        }
    }

    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
        }
    }
}

tasks {
    compileJava {
        options.encoding = "UTF-8"
        options.release = 21
    }
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
    withSourcesJar()
}