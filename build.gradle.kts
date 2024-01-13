plugins {
    id("java")
}

group = "nik"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation ("org.junit.jupiter:junit-jupiter:5.10.1")
    testImplementation ("com.codeborne:selenide:7.0.4")
}

tasks.test {
    useJUnitPlatform()
}