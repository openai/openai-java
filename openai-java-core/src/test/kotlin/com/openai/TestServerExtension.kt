package com.openai

import java.lang.RuntimeException
import java.lang.reflect.Method
import java.net.URL
import java.nio.channels.FileChannel
import java.nio.file.Paths
import java.nio.file.StandardOpenOption.CREATE
import java.nio.file.StandardOpenOption.WRITE
import java.util.UUID
import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.withLock
import org.junit.jupiter.api.extension.BeforeAllCallback
import org.junit.jupiter.api.extension.ConditionEvaluationResult
import org.junit.jupiter.api.extension.ExecutionCondition
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.api.extension.InvocationInterceptor
import org.junit.jupiter.api.extension.ReflectiveInvocationContext

class TestServerExtension : BeforeAllCallback, ExecutionCondition, InvocationInterceptor {

    override fun beforeAll(context: ExtensionContext?) {
        try {
            URL(BASE_URL).openConnection().connect()
        } catch (e: Exception) {
            throw RuntimeException(
                """
                The test suite will not run without a mock server running against your OpenAPI spec.

                You can set the environment variable `SKIP_MOCK_TESTS` to `true` to skip running any tests
                that require the mock server.

                To fix run `./scripts/mock` in a separate terminal.
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

    override fun interceptTestMethod(
        invocation: InvocationInterceptor.Invocation<Void>,
        invocationContext: ReflectiveInvocationContext<Method>,
        extensionContext: ExtensionContext,
    ) {
        PROCESS_LOCK.withLock {
            FileChannel.open(LOCK_FILE, CREATE, WRITE).use { channel ->
                channel.lock().use { invocation.proceed() }
            }
        }
    }

    companion object {

        val BASE_URL = System.getenv("TEST_API_BASE_URL") ?: "http://localhost:4010"

        const val SKIP_TESTS_ENV: String = "SKIP_MOCK_TESTS"

        // JUnit resource locks do not coordinate separate Gradle test-worker JVMs. Use both a
        // process-local lock and an OS file lock so tests sharing one mock server cannot race.
        private val PROCESS_LOCK = ReentrantLock(true)
        private val LOCK_FILE =
            Paths.get(
                System.getProperty("java.io.tmpdir"),
                "openai-java-test-server-${UUID.nameUUIDFromBytes(BASE_URL.toByteArray())}.lock",
            )
    }
}
