plugins {
    id("openai.kotlin")
    id("openai.publish")
}

dependencies {
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
    testImplementation("com.github.tomakehurst:wiremock-jre8:2.35.2")
    testImplementation("org.assertj:assertj-core:3.27.7")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.3")
    testImplementation("org.junit-pioneer:junit-pioneer:1.9.1")
    testImplementation("org.mockito:mockito-core:5.14.2")
    testImplementation("org.mockito.kotlin:mockito-kotlin:4.1.0")
}
