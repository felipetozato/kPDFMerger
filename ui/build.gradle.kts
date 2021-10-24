import org.jetbrains.compose.compose
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
    id("org.jetbrains.compose") version "1.0.0-alpha3"
}

group = "me.user"
version = "1.0.0"

repositories {
    jcenter()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

dependencies {
    implementation(Dependencies.Kotlin.stdlib)
    implementation(Dependencies.Kotlin.gradlePlugin)
    implementation(Dependencies.Kotlin.Coroutines.core)
    implementation(Dependencies.Koin.core)
    implementation(compose.desktop.currentOs)

    // Testing
    testImplementation(Dependencies.Koin.test)
    implementation(project(":core"))
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "11"
}

tasks.test {
    useJUnitPlatform()
}

compose.desktop {
    application {
        mainClass = "MainKt"
    }
}