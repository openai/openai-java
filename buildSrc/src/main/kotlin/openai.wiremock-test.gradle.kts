plugins {
    java
}

// WireMock 3 and Jetty 12 require Java 17 at test runtime even though the SDK targets Java 8.
listOf(configurations.testCompileClasspath, configurations.testRuntimeClasspath).forEach {
    it.configure {
        attributes.attribute(
            org.gradle.api.attributes.java.TargetJvmVersion.TARGET_JVM_VERSION_ATTRIBUTE,
            17,
        )
    }
}

dependencies {
    constraints {
        testImplementation("com.google.guava:guava:33.6.0-jre") {
            because("WireMock's transitive Guava 31.1-jre has known temporary-file vulnerabilities")
        }
        testImplementation("commons-fileupload:commons-fileupload:1.6.0") {
            because("WireMock's transitive 1.4 release has known denial-of-service vulnerabilities")
        }
        testImplementation("org.xmlunit:xmlunit-core:2.11.0") {
            because("2.11.0 includes the fix for CVE-2024-31573 in this test-only dependency")
        }
        testImplementation("commons-io:commons-io:2.22.0") {
            because("WireMock's transitive Commons IO version has a resource-exhaustion vulnerability")
        }
        testImplementation("com.jayway.jsonpath:json-path:2.10.0") {
            because("WireMock's transitive JSONPath version has a stack-overflow vulnerability")
        }
        testImplementation("org.apache.commons:commons-lang3:3.18.0") {
            because("WireMock's transitive 3.12.0 release is vulnerable to uncontrolled recursion")
        }
        testImplementation("com.github.jknack:handlebars:4.5.3") {
            because("WireMock's transitive 4.3.1 dependency is affected by CVE-2026-55760")
        }
    }

    testImplementation(platform("org.eclipse.jetty:jetty-bom:12.0.36"))
    testImplementation(platform("org.eclipse.jetty.ee10:jetty-ee10-bom:12.0.36"))
    testImplementation("org.wiremock:wiremock-jetty12:3.13.2")
}
