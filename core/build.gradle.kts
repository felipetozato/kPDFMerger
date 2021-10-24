import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
}

group = "me.user"
version = "1.0"

repositories {
}

dependencies {
    implementation(Dependencies.Apache.pdfBox)
    implementation(Dependencies.Koin.core)

    testImplementation(platform(Dependencies.Test.JUnit.bom))
    testImplementation(Dependencies.Test.JUnit.jupter)
    testImplementation(Dependencies.Test.CommonsIO.commonsIO)
    testImplementation(Dependencies.Koin.test)
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "11"
}