plugins {
  id("openai.kotlin")
  id("openai.publish")
}

repositories {
    mavenCentral()
}

dependencies {
    constraints {
        testImplementation("org.xmlunit:xmlunit-core:2.11.0") {
            because("2.10.0 fixes CVE-2024-31573 in this test-only dependency")
        }
    }

    api(project(":openai-java"))
    implementation("org.springframework.boot:spring-boot-autoconfigure:2.7.18")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor:2.7.18")

    testImplementation("org.springframework.boot:spring-boot-starter-test:2.7.18")
    testImplementation("org.assertj:assertj-core:3.27.7")

    constraints {
        testImplementation("org.yaml:snakeyaml:2.6") {
            because("avoid known vulnerabilities in Spring Boot's test dependency")
        }
    }
}
