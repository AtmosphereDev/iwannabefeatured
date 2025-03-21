plugins {
    id("java")
}

group = "dev.atmosphere"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.formdev:flatlaf:3.5.4")
    implementation("com.formdev:flatlaf-intellij-themes:3.5.4")
    implementation("com.formdev:flatlaf-extras:3.5.4")

    implementation("com.google.code.gson:gson:2.11.0")
}

tasks.test {
    useJUnitPlatform()
}