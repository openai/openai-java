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
            because("Spring Boot 2.7 requires SLF4J 1.7 at test runtime")
        }
    }

    api(project(":openai-java"))
    implementation("org.springframework.boot:spring-boot-autoconfigure:2.7.18")
    implementation("org.springframework:spring-expression:5.3.39") {
        because("5.3.39 fixes CVE-2024-38808 while preserving Spring Framework 5.3 compatibility")
    }
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor:2.7.18")

    testImplementation("org.springframework.boot:spring-boot-starter-test:2.7.18") {
        exclude(group = "org.springframework.boot", module = "spring-boot-starter-logging")
    }
    testRuntimeOnly("org.slf4j:slf4j-nop:1.7.36") {
        because("keep Boot 2.7 tests on SLF4J 1.7 without adding vulnerable Logback")
    }
    testImplementation("org.assertj:assertj-core:3.27.7")

    constraints {
        testImplementation("org.yaml:snakeyaml:2.6") {
            because("avoid known vulnerabilities in Spring Boot's test dependency")
        }
    }
}
