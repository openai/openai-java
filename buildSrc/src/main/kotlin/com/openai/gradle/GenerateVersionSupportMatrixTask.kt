package com.openai.gradle

import org.gradle.api.DefaultTask
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.provider.Property
import org.gradle.api.tasks.CacheableTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.PathSensitive
import org.gradle.api.tasks.PathSensitivity
import org.gradle.api.tasks.TaskAction

@CacheableTask
abstract class GenerateVersionSupportMatrixTask : DefaultTask() {
    @get:InputFile
    @get:PathSensitive(PathSensitivity.RELATIVE)
    abstract val policyFile: RegularFileProperty

    @get:Input abstract val mode: Property<String>

    @get:OutputFile abstract val outputFile: RegularFileProperty

    @TaskAction
    fun generate() {
        val versions = VersionSupportPolicy.load(policyFile.get().asFile).runtimeMatrix(mode.get())
        val json = versions.joinToString(separator = "\",\"", prefix = "[\"", postfix = "\"]")
        outputFile.get().asFile.apply {
            parentFile.mkdirs()
            writeText("$json\n")
        }
    }
}
