import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
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

		implementation("io.github.cdimascio:dotenv-kotlin:6.2.1")
	}
}

// All subprojects
subprojects {
	group = "com.prameprimo.${rootProject.name}"

	sourceSets.main {
		java.srcDirs("main/kotlin")
		resources.srcDirs("main/resources")
	}

	sourceSets.test {
		java.srcDirs("test/kotlin")
		resources.srcDirs("test/resources")
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

	tasks.withType<BootJar> {
		enabled = false
	}

	tasks.withType<Jar> {
		enabled = true
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

sourceSets.main {
	java.srcDirs("apps/main/kotlin")
	resources.srcDirs("apps/main/resources")
}

sourceSets.test {
	java.srcDirs("apps/test/kotlin")
	resources.srcDirs("apps/test/resources")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")

	implementation(project(":shared"))
	implementation(project(":backoffice"))
	implementation(project(":shop"))

	testImplementation("org.springframework.boot:spring-boot-starter-test")
}
