val ktorVersion: String by project
val kotlinVersion: String by project
val logbackVersion: String by project

plugins {
    kotlin("jvm") version "1.9.22"
    id("io.ktor.plugin") version "2.3.8"
    id("org.jetbrains.kotlin.plugin.serialization") version "1.9.22"
}

group = "com.example"
version = "0.0.1"

application {
    mainClass.set("io.ktor.server.netty.EngineMain")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-server-core-jvm:2.2.4")
    implementation("io.ktor:ktor-server-content-negotiation-jvm:2.2.4")
    implementation("io.ktor:ktor-server-call-logging-jvm:2.2.4")
    implementation("io.ktor:ktor-serialization-kotlinx-json-jvm:2.2.4")
    implementation("io.ktor:ktor-server-netty-jvm:2.2.4")
    implementation("ch.qos.logback:logback-classic:$logbackVersion")
    testImplementation("io.ktor:ktor-server-tests-jvm:2.2.4")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlinVersion")
}
