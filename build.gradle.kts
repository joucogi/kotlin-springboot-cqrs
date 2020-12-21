import org.gradle.api.tasks.testing.logging.TestLogEvent.*
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    application
    id("java")
    id("org.springframework.boot") version "2.4.0"
    id("io.spring.dependency-management") version "1.0.10.RELEASE"
    kotlin("jvm") version "1.4.10"
    kotlin("plugin.spring") version "1.4.10"
}

allprojects {

    apply {
        plugin("java")
        plugin("org.jetbrains.kotlin.jvm")
        plugin("io.spring.dependency-management")
        plugin("org.springframework.boot")
    }

    version = "0.0.1"
    java.sourceCompatibility = JavaVersion.VERSION_11
    java.targetCompatibility = JavaVersion.VERSION_11

    repositories {
        mavenCentral()
    }

    dependencies {
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
        implementation("org.reflections:reflections:0.9.11")

        implementation("org.hibernate:hibernate-core:5.4.9.Final")
        implementation("org.springframework:spring-orm:5.3.2")
        implementation("org.apache.tomcat:tomcat-dbcp:10.0.0")

        implementation("io.github.cdimascio:dotenv-kotlin:6.2.1")

        testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
        testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.6.0")
        testImplementation("io.mockk:mockk:1.10.3")
    }

    tasks.withType<Test> {
        useJUnitPlatform()

        testLogging {
            events = mutableSetOf(
                    PASSED,
                    FAILED,
                    SKIPPED
            )
        }
    }
}

// All subprojects
subprojects {
    group = "com.prameprimo.${rootProject.name}"

    sourceSets {
        main {
            java.srcDirs("main/kotlin")
            resources.srcDirs("main/resources")
        }

        test {
            java.srcDirs("test/kotlin")
            resources.srcDirs("test/resources")
        }
    }

    dependencies {
        implementation("org.springframework.boot:spring-boot-starter-web")

        testImplementation("org.springframework.boot:spring-boot-starter-test")
        testImplementation(rootProject.sourceSets["main"].output)

        if (project.name != "shared") {
            implementation(project(":shared"))

            testImplementation(project(":shared").dependencyProject.sourceSets["test"].output)
        }
    }

    tasks.getByName<BootJar>("bootJar") {
        enabled = false
    }

    tasks.getByName<Jar>("jar") {
        enabled = true
    }

    tasks.withType<JavaCompile> {
        enabled = false
    }
}

buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath("org.springframework.boot:spring-boot-gradle-plugin:2.4.0")
    }
}

sourceSets {
    main {
        java.srcDirs("apps/main/kotlin")
        resources.srcDirs("apps/main/resources")
    }

    test {
        java.srcDirs("apps/test/kotlin")
        resources.srcDirs("apps/test/resources")
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.withType<JavaCompile> {
    enabled = false
}

application {
    mainClassName = "com.prameprimo.apps.StarterKt"
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")

    implementation(project(":shared"))
//    implementation(project(":backoffice"))
    implementation(project(":shop"))

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation(project(":shared").dependencyProject.sourceSets["test"].output)
}
