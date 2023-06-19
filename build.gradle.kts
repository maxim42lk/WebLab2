plugins {
    kotlin("jvm") version "1.8.0"
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"
group = "org.codehaus.jackson"

repositories {
    mavenCentral()
}

dependencies {
    implementation("junit:junit:4.13.1")
    testImplementation(kotlin("test"))
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.14.+")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(8)
}

application {
    mainClass.set("MainKt")
}
