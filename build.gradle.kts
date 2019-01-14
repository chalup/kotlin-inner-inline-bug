val kotlinVersion = "1.3.11"

plugins {
    id("org.jetbrains.kotlin.jvm") version "1.3.11"
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8", kotlinVersion))
}

application {
    mainClassName = "org.chalup.kotlinbug.MainKt"
}
