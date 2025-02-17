package com.openai

import java.lang.RuntimeException
import java.net.URL
import org.junit.jupiter.api.extension.BeforeAllCallback
import org.junit.jupiter.api.extension.ConditionEvaluationResult
import org.junit.jupiter.api.extension.ExecutionCondition
import org.junit.jupiter.api.extension.ExtensionContext

class TestServerExtension : BeforeAllCallback, ExecutionCondition {

    override fun beforeAll(context: ExtensionContext?) {
        try {
            URL(BASE_URL).openConnection().connect()
        } catch (e: Exception) {
            throw RuntimeException(
                """
                The test suite will not run without a mock Prism server running against your OpenAPI spec.

                You can set the environment variable `SKIP_MOCK_TESTS` to `true` to skip running any tests
                that require the mock server.

                To fix:

                1. Install Prism (requires Node 16+):

                  With npm:
                    $ npm install -g @stoplight/prism-cli

                  With yarn:
                    $ yarn global add @stoplight/prism-cli

                2. Run the mock server

                  To run the server, pass in the path of your OpenAPI spec to the prism command:
                    $ prism mock path/to/your.openapi.yml
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

    companion object {

        val BASE_URL = System.getenv("TEST_API_BASE_URL") ?: "http://localhost:4010"

        const val SKIP_TESTS_ENV: String = "SKIP_MOCK_TESTS"
    }
}
