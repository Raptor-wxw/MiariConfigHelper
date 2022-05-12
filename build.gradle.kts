plugins {
    id("java")
}

group = "cn.hive_net"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.fasterxml.jackson.core:jackson-databind:2.13.2.2")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}