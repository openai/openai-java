package com.openai.gradle

/** The canonical external compiler classpath for the core artifact and its internal shards. */
object CoreCompilationDependencies {
    const val JACKSON_COMPATIBILITY_VERSION = "2.14.0"
    const val JACKSON_PUBLISHED_VERSION = "2.18.9"

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

    val publishedApiDependencies =
        listOf(
            "com.fasterxml.jackson.core:jackson-core:$JACKSON_PUBLISHED_VERSION",
            "com.fasterxml.jackson.core:jackson-databind:$JACKSON_PUBLISHED_VERSION",
            "com.google.errorprone:error_prone_annotations:2.33.0",
            "io.swagger.core.v3:swagger-annotations:2.2.31",
        )

    val publishedImplementationDependencies =
        listOf(
            "com.fasterxml.jackson.core:jackson-annotations:$JACKSON_PUBLISHED_VERSION",
            "com.fasterxml.jackson.datatype:jackson-datatype-jdk8:$JACKSON_PUBLISHED_VERSION",
            "com.fasterxml.jackson.datatype:jackson-datatype-jsr310:$JACKSON_PUBLISHED_VERSION",
            "com.fasterxml.jackson.module:jackson-module-kotlin:$JACKSON_PUBLISHED_VERSION",
            "com.github.victools:jsonschema-generator:4.38.0",
            "com.github.victools:jsonschema-module-jackson:4.38.0",
            "com.github.victools:jsonschema-module-swagger-2:4.38.0",
        )

    val compilerClasspathDependencies =
        publishedApiDependencies + publishedImplementationDependencies
}
