import com.openai.gradle.GenerateVersionSupportMatrixTask
import com.openai.gradle.VersionSupportPolicy
import com.openai.gradle.VerifyVersionSupportPolicyTask
import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.api.tasks.SourceSetContainer
import org.gradle.api.tasks.compile.JavaCompile
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    dependencies {
        constraints {
            classpath("com.fasterxml.jackson.core:jackson-annotations:2.18.9")
            classpath("com.fasterxml.jackson.core:jackson-core:2.18.9")
            classpath("com.fasterxml.jackson.core:jackson-databind:2.18.9")
            classpath("com.fasterxml.jackson.dataformat:jackson-dataformat-xml:2.18.9")
            classpath("com.fasterxml.jackson.module:jackson-module-kotlin:2.18.9")
        }
    }
}

plugins {
    id("org.jetbrains.dokka") version "2.1.0"
}

val dokkaJacksonVersion = "2.18.9"

repositories {
    mavenCentral()
}

allprojects {
    group = "com.openai"
    version = "4.49.0" // x-release-please-version

    // Dokka 2.1.0 depends on Jackson 2.15.3. Keep its isolated build-tool classpaths on a
    // secure, internally aligned Jackson release without changing the SDK's published or
    // compatibility-test dependency versions.
    configurations.matching { it.name.startsWith("dokka") }.configureEach {
        resolutionStrategy.eachDependency {
            if (
                requested.group == "com.fasterxml.jackson" ||
                    requested.group.startsWith("com.fasterxml.jackson.")
            ) {
                useVersion(dokkaJacksonVersion)
                because("Dokka's build-only Jackson classpath must use a secure aligned release")
            }
        }
    }
}

subprojects {
    // These are populated with dependencies by `buildSrc` scripts.
    tasks.register("format") {
        group = "Verification"
        description = "Formats all source files."
    }
    tasks.register("lint") {
        group = "Verification"
        description = "Verifies all source files are formatted."
    }
}

subprojects {
    apply(plugin = "org.jetbrains.dokka")
}

val versionSupportFile = layout.projectDirectory.file("gradle/version-support.properties")
val versionSupport = VersionSupportPolicy.load(versionSupportFile.asFile)

tasks.register<GenerateVersionSupportMatrixTask>("generateVersionSupportMatrix") {
    group = "verification"
    description = "Generates a CI runtime matrix from the version support policy."

    policyFile.set(versionSupportFile)
    mode.set(providers.gradleProperty("versionSupportMatrix"))
    outputFile.set(layout.buildDirectory.file("version-support-matrix.json"))
}

tasks.register("verifyVersionSupportPolicy") {
    group = "verification"
    description = "Verifies published artifact runtime floors and lifecycle declarations."

    inputs.file(versionSupportFile)
    dependsOn(versionSupport.artifacts.keys.map { ":$it:verifyVersionSupportPolicy" })
}

subprojects {
    val artifactName = name
    val artifactSupport = versionSupport.artifacts[artifactName]

    pluginManager.withPlugin("openai.publish") {
        checkNotNull(artifactSupport) {
            "$artifactName is published but missing from ${versionSupportFile.asFile}"
        }
    }

    if (artifactSupport != null) {
        pluginManager.withPlugin("java") {
            val java = extensions.getByType(JavaPluginExtension::class.java)
            val mainSourceSet = extensions.getByType(SourceSetContainer::class.java).getByName("main")
            val compileJava = tasks.named<JavaCompile>("compileJava")

            val verify =
                tasks.register<VerifyVersionSupportPolicyTask>("verifyVersionSupportPolicy") {
                group = "verification"
                description =
                    "Verifies $artifactName against its declared version support policy."

                this.artifactName.set(artifactName)
                runtimeFloor.set(artifactSupport.runtime)
                lifecycle.set(artifactSupport.lifecycle.propertyValue)
                requiredBuildJdk.set(versionSupport.buildJdk)
                configuredBuildJdk.set(java.toolchain.languageVersion.map { it.asInt() })
                sourceCompatibility.set(java.sourceCompatibility.majorVersion.toInt())
                targetCompatibility.set(java.targetCompatibility.majorVersion.toInt())
                javaRelease.set(compileJava.flatMap { it.options.release })
                classFiles.from(mainSourceSet.output.classesDirs)

                dependsOn(tasks.named("classes"))
            }

            pluginManager.withPlugin("org.jetbrains.kotlin.jvm") {
                val compileKotlin = tasks.named<KotlinCompile>("compileKotlin")
                verify.configure {
                    kotlinJvmTarget.set(
                        compileKotlin.flatMap { it.compilerOptions.jvmTarget }.map { it.target }
                    )
                    kotlinFreeCompilerArgs.set(
                        compileKotlin.flatMap { it.compilerOptions.freeCompilerArgs }
                    )
                }
            }
        }
    }
}

// Avoid race conditions between `dokkaJavadocCollector` and `dokkaJavadocJar` tasks
tasks.named("dokkaJavadocCollector").configure {
    subprojects.flatMap { it.tasks }
        .filter { it.project.name != "openai-java" && it.name == "dokkaJavadocJar" }
        .forEach { mustRunAfter(it) }
}
