package com.openai.helpers

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.webhooks.UnwrapWebhookEvent
import java.io.File
import java.io.StringWriter
import java.lang.reflect.InvocationTargetException
import java.net.URLClassLoader
import java.nio.file.Files
import java.nio.file.Path
import javax.tools.ToolProvider
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.io.TempDir
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class SafetyWebhookVisitorCompatibilityTest {

    @TempDir lateinit var tempDir: Path

    @ParameterizedTest
    @CsvSource(
        "safety.warning_issued, false, true",
        "safety.warning_issued, true, true",
        "safety.warning_issued, false, false",
        "safety.warning_issued, true, false",
        "safety.deactivation_issued, false, true",
        "safety.deactivation_issued, true, true",
        "safety.deactivation_issued, false, false",
        "safety.deactivation_issued, true, false",
    )
    fun existingVisitorsRemainSourceAndBinaryCompatible(
        type: String,
        binaryConsumer: Boolean,
        overridesUnknown: Boolean,
    ) {
        val union = UnwrapWebhookEvent::class.java
        val visitor = union.declaredClasses.single { it.simpleName == "Visitor" }
        val newMethods = setOf("visitSafetyDeactivationIssued", "visitSafetyWarningIssued")
        val visitMethods = visitor.declaredMethods.filter { it.name.startsWith("visit") }
        assertThat(visitMethods).allMatch { it.isDefault }
        val oldMethods = visitMethods.filter { it.name !in newMethods }.sortedBy { it.name }
        assertThat(oldMethods.map { it.name })
            .containsExactlyInAnyOrder(
                "visitBatchCancelled",
                "visitBatchCompleted",
                "visitBatchExpired",
                "visitBatchFailed",
                "visitEvalRunCanceled",
                "visitEvalRunFailed",
                "visitEvalRunSucceeded",
                "visitFineTuningJobCancelled",
                "visitFineTuningJobFailed",
                "visitFineTuningJobSucceeded",
                "visitLiveCallIncoming",
                "visitLiveTransportIncoming",
                "visitRealtimeCallIncoming",
                "visitResponseCancelled",
                "visitResponseCompleted",
                "visitResponseFailed",
                "visitResponseIncomplete",
                "visitSafetyAlertCreated",
                "visitSafetyOrgAlertCreated",
            )
        val jsonType = JsonValue::class.java.canonicalName
        val consumerName = "ExistingSafetyWebhookVisitor"
        val overrides =
            oldMethods.joinToString("\n") {
                "public $jsonType ${it.name}(${it.parameterTypes.single().canonicalName} event) " +
                    "{ throw new AssertionError(\"Unexpected old event\"); }"
            }
        val unknownOverride =
            if (overridesUnknown) "public $jsonType unknown($jsonType json) { return json; }"
            else ""
        val consumerSource =
            """
            public class $consumerName implements ${visitor.canonicalName}<$jsonType> {
                $overrides
                $unknownOverride
            }
            """
                .trimIndent()
        val classpath =
            (listOf(
                    union,
                    JsonValue::class.java,
                    Metadata::class.java,
                    JsonProperty::class.java,
                    JsonDeserialize::class.java,
                ) + oldMethods.flatMap { it.parameterTypes.toList() })
                .map { File(it.protectionDomain.codeSource.location.toURI()).path }
                .distinct()
                .joinToString(File.pathSeparator)
        val compileClasspath =
            if (binaryConsumer) {
                // Compile against the prior Visitor ABI; load only the consumer against the SDK.
                val oldDeclarations =
                    oldMethods.joinToString("\n") {
                        "T ${it.name}(${it.parameterTypes.single().canonicalName} event);"
                    }
                val oldInterface =
                    """
                    package ${union.`package`.name};
                    public class ${union.simpleName} {
                        public interface Visitor<T> {
                            $oldDeclarations
                            default T unknown($jsonType json) {
                                throw new IllegalStateException("Unknown event");
                            }
                        }
                    }
                    """
                        .trimIndent()
                val oldAbi = compile("old-abi", union.simpleName, oldInterface, classpath)
                "$oldAbi${File.pathSeparator}$classpath"
            } else {
                classpath
            }
        val consumer = compile("consumer", consumerName, consumerSource, compileClasspath)
        val json =
            """{
                "id": "evt-safety-test", "created_at": 123, "object": "event", "type": "$type",
                "data": {"id": "safety-case-test", "future_data": {"enabled": true}},
                "future_event": ["preserved"]
            }"""
        val event = jsonMapper().readValue(json, union)
        val expected = jsonMapper().readTree(json)

        URLClassLoader(arrayOf(consumer.toUri().toURL()), visitor.classLoader).use { loader ->
            val instance = loader.loadClass(consumerName).getDeclaredConstructor().newInstance()
            assertThat(instance).isInstanceOf(visitor)
            if (overridesUnknown) {
                val result = union.getMethod("accept", visitor).invoke(event, instance)
                assertThat(jsonMapper().readTree(jsonMapper().writeValueAsString(result)))
                    .isEqualTo(expected)
            } else {
                val error =
                    assertThrows<InvocationTargetException> {
                            union.getMethod("accept", visitor).invoke(event, instance)
                        }
                        .cause
                assertThat(error).isInstanceOf(OpenAIInvalidDataException::class.java)
                assertThat(error?.message).contains("Unknown UnwrapWebhookEvent")
            }
            assertThat(jsonMapper().readTree(jsonMapper().writeValueAsString(event)))
                .isEqualTo(expected)
        }
    }

    private fun compile(directory: String, name: String, source: String, classpath: String): Path {
        val root = Files.createDirectory(tempDir.resolve(directory))
        val sourceFile = Files.write(root.resolve("$name.java"), source.toByteArray())
        val output = Files.createDirectory(root.resolve("classes"))
        val compiler = ToolProvider.getSystemJavaCompiler()
        val diagnostics = StringWriter()
        compiler.getStandardFileManager(null, null, null).use { manager ->
            val success =
                compiler
                    .getTask(
                        diagnostics,
                        manager,
                        null,
                        listOf("--release", "8", "-classpath", classpath, "-d", output.toString()),
                        null,
                        manager.getJavaFileObjects(sourceFile.toFile()),
                    )
                    .call()
            assertThat(success).withFailMessage(diagnostics.toString()).isTrue()
        }
        return output
    }
}
