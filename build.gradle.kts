

group = "me.user"
version = "1.0.0"

allprojects {
    repositories {
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        google()
    }
}

plugins {
    kotlin("jvm") version "1.5.21" apply false
}