import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    val verifierVersion: String by extra
    repositories {
        mavenCentral()
        mavenLocal()
    }

    dependencies {
        classpath("org.springframework.cloud:spring-cloud-contract-spec-kotlin:$verifierVersion")
    }
}


plugins {
    id("org.springframework.boot") version "2.3.2.RELEASE"
    id("io.spring.dependency-management") version "1.0.9.RELEASE"
    id("org.springframework.cloud.contract") version "2.2.4.RELEASE"
    id("maven-publish")
    kotlin("jvm") version "1.3.72"
    kotlin("plugin.spring") version "1.3.72"
}

group = "yh.study"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
    mavenCentral()
    mavenLocal()
}

extra["springCloudVersion"] = "Hoxton.SR6"

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
    testImplementation("org.springframework.cloud:spring-cloud-starter-contract-verifier")
    testImplementation("org.springframework.cloud:spring-cloud-contract-spec-kotlin")
}

dependencyManagement {
    val bomVersion: String by project

    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:$bomVersion")
    }
}

contracts {
    baseClassForTests.set("yh.study.producer.ProducerBase")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "1.8"
    }
}
