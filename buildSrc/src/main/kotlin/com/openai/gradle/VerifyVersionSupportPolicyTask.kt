package com.openai.gradle

import java.io.DataInputStream
import org.gradle.api.DefaultTask
import org.gradle.api.file.ConfigurableFileCollection
import org.gradle.api.provider.ListProperty
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.InputFiles
import org.gradle.api.tasks.PathSensitive
import org.gradle.api.tasks.PathSensitivity
import org.gradle.api.tasks.TaskAction
import org.gradle.work.DisableCachingByDefault

@DisableCachingByDefault(because = "This verification task has no outputs")
abstract class VerifyVersionSupportPolicyTask : DefaultTask() {
    @get:Input abstract val artifactName: Property<String>

    @get:Input abstract val runtimeFloor: Property<Int>

    @get:Input abstract val lifecycle: Property<String>

    @get:Input abstract val requiredBuildJdk: Property<Int>

    @get:Input abstract val configuredBuildJdk: Property<Int>

    @get:Input abstract val sourceCompatibility: Property<Int>

    @get:Input abstract val targetCompatibility: Property<Int>

    @get:Input abstract val javaRelease: Property<Int>

    @get:Input abstract val kotlinJvmTarget: Property<String>

    @get:Input abstract val kotlinFreeCompilerArgs: ListProperty<String>

    @get:InputFiles
    @get:PathSensitive(PathSensitivity.RELATIVE)
    abstract val classFiles: ConfigurableFileCollection

    @TaskAction
    fun verify() {
        val name = artifactName.get()
        val floor = runtimeFloor.get()
        val allowedLifecycles = setOf("active", "maintenance", "deprecated", "eol")

        check(lifecycle.get() in allowedLifecycles) {
            "$name must declare one of ${allowedLifecycles.sorted()}, but declared '${lifecycle.get()}'"
        }
        check(configuredBuildJdk.get() == requiredBuildJdk.get()) {
            "$name must build with JDK ${requiredBuildJdk.get()}"
        }
        check(sourceCompatibility.get() == floor) {
            "$name source compatibility must be Java $floor"
        }
        check(targetCompatibility.get() == floor) {
            "$name target compatibility must be Java $floor"
        }
        check(javaRelease.get() == floor) { "$name Java compiler must enforce --release $floor" }

        val expectedKotlinTarget = if (floor == 8) "1.8" else floor.toString()
        check(kotlinJvmTarget.get() == expectedKotlinTarget) {
            "$name Kotlin JVM target must be $expectedKotlinTarget"
        }
        val jdkReleaseArguments =
            kotlinFreeCompilerArgs.get().filter { it.startsWith("-Xjdk-release=") }
        check(jdkReleaseArguments == listOf("-Xjdk-release=$expectedKotlinTarget")) {
            "$name Kotlin compiler must enforce exactly -Xjdk-release=$expectedKotlinTarget"
        }

        val maximumClassMajorVersion = 44 + floor
        val bytecodeErrors =
            classFiles.asFileTree
                .matching { include("**/*.class") }
                .mapNotNull { classFile ->
                    DataInputStream(classFile.inputStream().buffered()).use { input ->
                        check(input.readInt() == 0xCAFEBABE.toInt()) {
                            "$classFile is not a valid JVM class file"
                        }
                        input.readUnsignedShort()
                        val classMajorVersion = input.readUnsignedShort()
                        if (classMajorVersion > maximumClassMajorVersion) {
                            "$classFile uses class-file version $classMajorVersion; $name permits " +
                                "at most $maximumClassMajorVersion (Java $floor)"
                        } else {
                            null
                        }
                    }
                }

        check(bytecodeErrors.isEmpty()) {
            bytecodeErrors.joinToString(
                separator = "\n- ",
                prefix = "Published bytecode exceeds its declared runtime floor:\n- ",
            )
        }
    }
}
