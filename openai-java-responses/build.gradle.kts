import org.gradle.process.CommandLineArgumentProvider
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("openai.kotlin")
    id("openai.publish")
}

// Keep the incompatible monolith off the normal test and publication classpaths.
val legacyCore by configurations.creating {
    isCanBeConsumed = false
    isTransitive = false
}

dependencies {
    legacyCore("com.openai:openai-java-core:4.70.0@jar")
    testImplementation(kotlin("test"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.3")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    api(project(":openai-java-responses-api"))
    api(project(":openai-java-http-okhttp"))
}
tasks.withType<KotlinCompile>().configureEach {
    friendPaths.from(
        project(":openai-java-http-okhttp").layout.buildDirectory.dir("classes/kotlin/main"),
        project(":openai-java-responses-api").layout.buildDirectory.dir("classes/kotlin/main"),
    )
}

abstract class FactoryTestClasspath : CommandLineArgumentProvider {
    @get:Classpath abstract val legacyCore: ConfigurableFileCollection
    @get:Classpath abstract val splitSdk: ConfigurableFileCollection

    override fun asArguments() = listOf(
        "-DfactoryTest.legacyCore=${legacyCore.singleFile.absolutePath}",
        "-DfactoryTest.splitSdk=${splitSdk.asPath}",
    )
}

tasks.test {
    val fixtures = objects.newInstance<FactoryTestClasspath>()
    fixtures.legacyCore.from(legacyCore)
    fixtures.splitSdk.from(sourceSets.main.get().runtimeClasspath)
    jvmArgumentProviders.add(fixtures)
}
