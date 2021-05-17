import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
}

group = "me.user"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test-junit5"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.6.0")
    testImplementation("commons-io", "commons-io", "2.5")

    implementation("org.apache.pdfbox:pdfbox:2.0.21")
    implementation(kotlin("stdlib"))
    // Koin for Kotlin apps
    implementation("io.insert-koin:koin-core:3.0.1")
    // Testing
    testImplementation("io.insert-koin:koin-test:3.0.1")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}