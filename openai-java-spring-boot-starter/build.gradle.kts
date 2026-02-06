plugins {
  id("openai.kotlin")
  id("openai.publish")
}

repositories {
    mavenCentral()
}

dependencies {
    api(project(":openai-java"))
    implementation("org.springframework.boot:spring-boot-autoconfigure:2.7.18")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor:2.7.18")

    testImplementation("org.springframework.boot:spring-boot-starter-test:2.7.18")
    testImplementation("org.assertj:assertj-core:3.27.7")
}
