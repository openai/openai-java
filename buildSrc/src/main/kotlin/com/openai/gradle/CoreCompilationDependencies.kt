package com.openai.gradle

/** The canonical external compiler classpath for the core artifact and its internal shards. */
object CoreCompilationDependencies {
    const val JACKSON_COMPATIBILITY_VERSION = "2.14.0"

    private val jacksonModules =
        listOf(
            "com.fasterxml.jackson.core:jackson-core",
            "com.fasterxml.jackson.core:jackson-databind",
            "com.fasterxml.jackson.core:jackson-annotations",
            "com.fasterxml.jackson.datatype:jackson-datatype-jdk8",
            "com.fasterxml.jackson.datatype:jackson-datatype-jsr310",
            "com.fasterxml.jackson.module:jackson-module-kotlin",
        )

    val jacksonCompatibilityDependencies =
        jacksonModules.map { "$it:$JACKSON_COMPATIBILITY_VERSION" }

    fun publishedApiDependencies(jacksonPublishedVersion: String) =
        listOf(
            "com.fasterxml.jackson.core:jackson-core:$jacksonPublishedVersion",
            "com.fasterxml.jackson.core:jackson-databind:$jacksonPublishedVersion",
            "com.google.errorprone:error_prone_annotations:2.33.0",
            "io.swagger.core.v3:swagger-annotations:2.2.31",
        )

    fun publishedImplementationDependencies(jacksonPublishedVersion: String) =
        listOf(
            "org.jetbrains.kotlin:kotlin-reflect:1.8.20",
            "com.fasterxml.jackson.core:jackson-annotations:$jacksonPublishedVersion",
            "com.fasterxml.jackson.datatype:jackson-datatype-jdk8:$jacksonPublishedVersion",
            "com.fasterxml.jackson.datatype:jackson-datatype-jsr310:$jacksonPublishedVersion",
            "com.fasterxml.jackson.module:jackson-module-kotlin:$jacksonPublishedVersion",
            "com.github.victools:jsonschema-generator:4.38.0",
            "com.github.victools:jsonschema-module-jackson:4.38.0",
            "com.github.victools:jsonschema-module-swagger-2:4.38.0",
        )

    fun compilerClasspathDependencies(jacksonPublishedVersion: String) =
        publishedApiDependencies(jacksonPublishedVersion) +
            publishedImplementationDependencies(jacksonPublishedVersion)
}
