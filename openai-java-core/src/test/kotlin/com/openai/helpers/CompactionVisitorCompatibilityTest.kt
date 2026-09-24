package com.openai.helpers

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.models.beta.responses.BetaResponseStreamEvent
import com.openai.models.beta.responses.BetaResponsesServerEvent
import com.openai.models.responses.ResponseStreamEvent
import com.openai.models.responses.ResponsesServerEvent
import java.io.File
import java.io.StringWriter
import java.lang.reflect.Modifier
import java.net.URLClassLoader
import java.nio.file.Files
import java.nio.file.Path
import javax.tools.ToolProvider
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.io.TempDir
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class CompactionVisitorCompatibilityTest {

    @TempDir lateinit var tempDir: Path

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3])
    fun legacyVisitorsRemainSourceAndBinaryCompatible(index: Int) {
        val union =
            listOf(
                ResponseStreamEvent::class.java,
                ResponsesServerEvent::class.java,
                BetaResponseStreamEvent::class.java,
                BetaResponsesServerEvent::class.java,
            )[index]
        val visitor = union.declaredClasses.single { it.simpleName == "Visitor" }
        val progressMethod =
            if (index == 0) "visitCompactionCompacting" else "visitResponseCompactionCompacting"
        val oldMethods =
            visitor.declaredMethods
                .filter { Modifier.isAbstract(it.modifiers) && it.name != progressMethod }
                .sortedBy { it.name }
        val jsonType = JsonValue::class.java.canonicalName
        val consumerName = "LegacyVisitor$index"
        val overrides =
            oldMethods.joinToString("\n") {
                "public $jsonType ${it.name}(${it.parameterTypes.single().canonicalName} event) " +
                    "{ throw new AssertionError(\"Unexpected old event\"); }"
            }
        val consumerSource =
            """
            public class $consumerName implements ${visitor.canonicalName}<$jsonType> {
                $overrides
                public $jsonType unknown($jsonType json) { return json; }
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

        // Compile a real Java implementation that omits the new method against the current SDK.
        val sourceConsumer = compile("source-consumer", consumerName, consumerSource, classpath)

        // Recreate the prior Visitor ABI, compile against it, then exclude it from the runtime.
        // The unchanged consumer class must link to the current SDK's actual Visitor interface.
        val oldDeclarations =
            oldMethods.joinToString("\n") {
                "T ${it.name}(${it.parameterTypes.single().canonicalName} event);"
            }
        val nestedTypes =
            oldMethods
                .map { it.parameterTypes.single() }
                .filter { it.enclosingClass == union }
                .distinct()
                .joinToString("\n") { "public static class ${it.simpleName} {}" }
        val oldInterface =
            """
            package ${union.`package`.name};
            public class ${union.simpleName} {
                $nestedTypes
                public interface Visitor<T> {
                    $oldDeclarations
                    default T unknown($jsonType json) { throw new IllegalStateException("Unknown event"); }
                }
            }
            """
                .trimIndent()
        val oldAbi = compile("old-abi", union.simpleName, oldInterface, classpath)
        val binaryConsumer =
            compile(
                "binary-consumer",
                consumerName,
                consumerSource,
                "$oldAbi${File.pathSeparator}$classpath",
            )

        val json =
            """{"type":"response.compaction.compacting","sequence_number":3,"item_id":"cmp_test","output_index":0,"stream_id":"stream_test","future_field":"preserved"}"""
        val event = jsonMapper().readValue(json, union)
        val expected = jsonMapper().readTree(json)
        for (consumer in listOf(sourceConsumer, binaryConsumer)) {
            URLClassLoader(arrayOf(consumer.toUri().toURL()), visitor.classLoader).use { loader ->
                val instance = loader.loadClass(consumerName).getDeclaredConstructor().newInstance()
                assertThat(instance).isInstanceOf(visitor)
                val result = union.getMethod("accept", visitor).invoke(event, instance)
                assertThat(jsonMapper().readTree(jsonMapper().writeValueAsString(result)))
                    .isEqualTo(expected)
            }
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
