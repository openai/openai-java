plugins {
    id("openai.kotlin")
    id("openai.publish")
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
            because("2.10.0 fixes CVE-2024-31573 in this test-only dependency")
        }
        testImplementation("commons-io:commons-io:2.22.0") {
            because("WireMock's transitive Commons IO version has a resource-exhaustion vulnerability")
        }
    }

    api(project(":openai-java-core"))

    implementation("com.squareup.okhttp3:okhttp:4.12.0")

    testImplementation(kotlin("test"))
    testImplementation("org.assertj:assertj-core:3.27.7")
    testImplementation(platform("org.eclipse.jetty:jetty-bom:9.4.58.v20250814"))
    testImplementation("com.github.tomakehurst:wiremock-jre8:2.35.2")

    constraints {
        // Keep handlebars-helpers at 4.3.1: WireMock 2 links helper classes moved in 4.5.x.
        testImplementation("com.github.jknack:handlebars:4.5.3") {
            because("WireMock's transitive 4.3.1 dependency is affected by CVE-2026-55760")
        }
    }
}
