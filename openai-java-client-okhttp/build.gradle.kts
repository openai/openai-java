plugins {
    id("openai.kotlin")
    id("openai.publish")
}

dependencies {
    api(project(":openai-java-core"))

    implementation("com.squareup.okhttp3:okhttp:4.12.0")

    testImplementation(kotlin("test"))
    testImplementation("org.assertj:assertj-core:3.27.7")
    testImplementation(platform("org.eclipse.jetty:jetty-bom:9.4.58.v20250814"))
    testImplementation("com.github.tomakehurst:wiremock-jre8:2.35.2")
}
