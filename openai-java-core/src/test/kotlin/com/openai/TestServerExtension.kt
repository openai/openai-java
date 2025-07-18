package com.openai

import java.io.File
import java.lang.RuntimeException
import java.time.Duration
import org.junit.jupiter.api.extension.BeforeAllCallback
import org.junit.jupiter.api.extension.ConditionEvaluationResult
import org.junit.jupiter.api.extension.ExecutionCondition
import org.junit.jupiter.api.extension.ExtensionContext
import org.testcontainers.containers.GenericContainer
import org.testcontainers.containers.wait.strategy.Wait
import org.testcontainers.utility.DockerImageName
import org.testcontainers.utility.MountableFile

class TestServerExtension : BeforeAllCallback, ExecutionCondition {

    companion object {
        private const val INTERNAL_PORT = 4010 // Port inside the container

        val BASE_URL: String
            get() = "http://${prismContainer.host}:${prismContainer.getMappedPort(INTERNAL_PORT)}"

        const val SKIP_TESTS_ENV: String = "SKIP_MOCK_TESTS"
        private const val NODEJS_IMAGE = "node:22"
        private const val PRISM_CLI_VERSION = "5.8.5"
        private const val API_SPEC_PATH = "/app/openapi.yml" // Path inside the container

        // Track if the container has been started
        private var containerStarted = false

        private fun getOpenApiSpecPath(): String {
            // First check environment variable
            val envPath = System.getenv("OPENAPI_SPEC_PATH")
            if (envPath != null) {
                return envPath
            }

            // Try to read from .stats.yml file
            try {
                val statsFile = File("../.stats.yml")
                if (statsFile.exists()) {
                    val content = statsFile.readText()
                    val urlLine = content.lines().find { it.startsWith("openapi_spec_url:") }
                    if (urlLine != null) {
                        val url = urlLine.substringAfter("openapi_spec_url:").trim()
                        if (url.isNotEmpty()) {
                            return url
                        }
                    }
                }
            } catch (e: Exception) {
                println(
                    "Could not read .stats.yml fails, fall back to default. Error is: ${e.message}"
                )
            }
            return "/tmp/openapi.yml"
        }

        private val prismContainer: GenericContainer<*> by lazy {
            val apiSpecPath = getOpenApiSpecPath()
            println("Using OpenAPI spec path: $apiSpecPath")
            val isUrl = apiSpecPath.startsWith("http://") || apiSpecPath.startsWith("https://")

            // Create container with or without copying the file based on whether apiSpecPath is a
            // URL
            val container =
                GenericContainer(DockerImageName.parse(NODEJS_IMAGE))
                    .withExposedPorts(INTERNAL_PORT)
                    .withCommand(
                        "npm",
                        "exec",
                        "--package=@stainless-api/prism-cli@$PRISM_CLI_VERSION",
                        "--",
                        "prism",
                        "mock",
                        apiSpecPath,
                        "--host",
                        "0.0.0.0",
                        "--port",
                        INTERNAL_PORT.toString(),
                    )
                    .withReuse(true)

            // Only copy the file to the container if apiSpecPath is a local file
            if (!isUrl) {
                try {
                    val file = File(apiSpecPath)
                    if (file.exists()) {
                        container.withCopyToContainer(
                            MountableFile.forHostPath(apiSpecPath),
                            API_SPEC_PATH,
                        )
                    } else {
                        println("OpenAPI spec file not found at: $apiSpecPath")
                        throw RuntimeException("OpenAPI spec file not found at: $apiSpecPath")
                    }
                } catch (e: Exception) {
                    println("Error reading OpenAPI spec file: ${e.message}")
                    throw RuntimeException("Error reading OpenAPI spec file: $apiSpecPath", e)
                }
            }

            // Add waiting strategy
            container.waitingFor(
                Wait.forLogMessage(".*Prism is listening.*", 1)
                    .withStartupTimeout(Duration.ofSeconds(300))
            )

            // Start the container here once during lazy initialization
            container.start()
            containerStarted = true
            println(
                "Prism container started at: ${container.host}:${container.getMappedPort(INTERNAL_PORT)}"
            )

            container
        }

        // Method to ensure container is started, can be called from beforeAll
        fun ensureContainerStarted() {
            if (!containerStarted) {
                // This will trigger lazy initialization and start the container
                prismContainer
            }
        }
    }

    override fun beforeAll(context: ExtensionContext?) {
        try {
            // Use the companion method to ensure container is started only once
            ensureContainerStarted()
        } catch (e: Exception) {
            throw RuntimeException(
                """
                Failed to connect to Prism mock server running in TestContainer.
                
                You can set the environment variable `SKIP_MOCK_TESTS` to `true` to skip running any tests
                that require the mock server.
                
                You may also need to set `OPENAPI_SPEC_PATH` to the path of your OpenAPI spec file.
                """
                    .trimIndent(),
                e,
            )
        }
    }

    override fun evaluateExecutionCondition(context: ExtensionContext): ConditionEvaluationResult {
        return if (System.getenv(SKIP_TESTS_ENV).toBoolean()) {
            ConditionEvaluationResult.disabled(
                "Environment variable $SKIP_TESTS_ENV is set to true"
            )
        } else {
            ConditionEvaluationResult.enabled(
                "Environment variable $SKIP_TESTS_ENV is not set to true"
            )
        }
    }
}
