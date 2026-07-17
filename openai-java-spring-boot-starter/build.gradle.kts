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
        testImplementation("com.jayway.jsonpath:json-path:2.10.0") {
            because("Spring Boot's transitive JSONPath version has a stack-overflow vulnerability")
        }
        testImplementation("org.slf4j:slf4j-api") {
            version { strictly("1.7.36") }
            because("Spring Boot 2.7 and Logback 1.2 require SLF4J 1.7 at test runtime")
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
