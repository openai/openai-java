plugins {
    id("openai.kotlin")
    id("openai.publish")
}

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
            because("2.10.0 fixes CVE-2024-31573 in this test-only dependency")
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

    api(project(":openai-java-client-okhttp"))

    // Keep AWS dependencies isolated to this optional Bedrock artifact.
    api(platform("software.amazon.awssdk:bom:2.46.8"))
    api("software.amazon.awssdk:auth")
    api("software.amazon.awssdk:regions")

    implementation("software.amazon.awssdk:http-client-spi")
    implementation("com.squareup.okhttp3:okhttp:4.12.0")

    // Optional provider-chain branches loaded by the AWS SDK at runtime for web identity,
    // assume-role, console login, and IAM Identity Center profiles.
    runtimeOnly("software.amazon.awssdk:sts") {
        exclude(group = "software.amazon.awssdk", module = "apache5-client")
        exclude(group = "software.amazon.awssdk", module = "netty-nio-client")
    }
    runtimeOnly("software.amazon.awssdk:sso") {
        exclude(group = "software.amazon.awssdk", module = "apache5-client")
        exclude(group = "software.amazon.awssdk", module = "netty-nio-client")
    }
    runtimeOnly("software.amazon.awssdk:ssooidc") {
        exclude(group = "software.amazon.awssdk", module = "apache5-client")
        exclude(group = "software.amazon.awssdk", module = "netty-nio-client")
    }
    runtimeOnly("software.amazon.awssdk:signin") {
        exclude(group = "software.amazon.awssdk", module = "apache5-client")
        exclude(group = "software.amazon.awssdk", module = "netty-nio-client")
    }
    runtimeOnly("software.amazon.awssdk:url-connection-client")

    testImplementation(kotlin("test"))
    testImplementation(platform("org.eclipse.jetty:jetty-bom:12.0.33"))
    testImplementation(platform("org.eclipse.jetty.ee10:jetty-ee10-bom:12.0.33"))
    testImplementation("org.wiremock:wiremock-jetty12:3.13.2")
    testImplementation("org.assertj:assertj-core:3.27.7")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.3")
    testImplementation("org.junit-pioneer:junit-pioneer:1.9.1")
    testImplementation("org.mockito:mockito-core:5.14.2")
    testImplementation("org.mockito.kotlin:mockito-kotlin:4.1.0")
}
