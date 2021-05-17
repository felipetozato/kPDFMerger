

group = "me.user"
version = "1.0"

allprojects {
    repositories {
        mavenCentral()
        maven {
            setUrl("http://artifactory.uber.internal:4587/artifactory/repo/")
            isAllowInsecureProtocol = true
        }
    }
}

plugins {
    kotlin("jvm") version "1.4.20"
}