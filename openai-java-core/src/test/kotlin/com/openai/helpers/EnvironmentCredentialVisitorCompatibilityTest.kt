package com.openai.helpers

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.beta.agents.vaults.credentials.CredentialAuth
import com.openai.models.beta.agents.vaults.credentials.CredentialAuthCreateParam
import com.openai.models.beta.agents.vaults.credentials.CredentialAuthRotateParam
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
import org.junit.jupiter.params.provider.ValueSource

internal class EnvironmentCredentialVisitorCompatibilityTest {

    @TempDir lateinit var tempDir: Path

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11])
    fun existingVisitorsRemainSourceAndBinaryCompatible(case: Int) {
        val overridesUnknown = case < 6
        val index = if (overridesUnknown) case / 2 else ((case - 6) / 2 + 1) % 3
        val binaryConsumer = case % 2 == 1
        val union =
            listOf(
                CredentialAuth::class.java,
                CredentialAuthCreateParam::class.java,
                CredentialAuthRotateParam::class.java,
            )[index]
        val visitor = union.declaredClasses.single { it.simpleName == "Visitor" }
        val visitMethods = visitor.declaredMethods.filter { it.name.startsWith("visit") }
        assertThat(visitMethods).allMatch { it.isDefault }
        val oldMethods =
            visitMethods.filter { it.name != "visitEnvironmentVariable" }.sortedBy { it.name }
        assertThat(oldMethods.map { it.name })
            .containsExactlyInAnyOrder(
                if (index == 0) "visitMcpO" else "visitMcpOAuth",
                "visitStaticBearer",
            )
        val jsonType = JsonValue::class.java.canonicalName
        val consumerName = "ExistingCredentialVisitor$case"
        val overrides =
            oldMethods.joinToString("\n") {
                "public $jsonType ${it.name}(${it.parameterTypes.single().canonicalName} auth) " +
                    "{ throw new AssertionError(\"Unexpected old credential\"); }"
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
                        "T ${it.name}(${it.parameterTypes.single().canonicalName} auth);"
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
                            default T unknown($jsonType json) {
                                throw new IllegalStateException("Unknown credential");
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
            listOf(
                """{"type":"environment_variable","secret_name":"SDK_TEST_KEY","secret_value":"fake-secret","networking":{"type":"unrestricted"},"future_field":"preserved"}""",
                """{"type":"environment_variable","secret_name":"SDK_TEST_KEY","secret_value":"fake-secret","networking":{"type":"unrestricted"},"future_field":"preserved"}""",
                """{"type":"environment_variable","secret_value":"fake-secret","future_field":"preserved"}""",
            )[index]
        val auth = jsonMapper().readValue(json, union)
        val expected = jsonMapper().readTree(json)

        URLClassLoader(arrayOf(consumer.toUri().toURL()), visitor.classLoader).use { loader ->
            val instance = loader.loadClass(consumerName).getDeclaredConstructor().newInstance()
            assertThat(instance).isInstanceOf(visitor)
            if (overridesUnknown) {
                val result = union.getMethod("accept", visitor).invoke(auth, instance)
                assertThat(jsonMapper().readTree(jsonMapper().writeValueAsString(result)))
                    .isEqualTo(expected)
            } else {
                val error =
                    assertThrows<InvocationTargetException> {
                            union.getMethod("accept", visitor).invoke(auth, instance)
                        }
                        .cause
                assertThat(error).isInstanceOf(OpenAIInvalidDataException::class.java)
                if (index == 0) {
                    assertThat(error?.message)
                        .doesNotContain("fake-secret")
                        .contains("[REDACTED]", "future_field", "preserved")
                } else {
                    assertThat(error?.message).isEqualTo("Unknown ${union.simpleName}: [REDACTED]")
                }
                assertThat(jsonMapper().readTree(jsonMapper().writeValueAsString(auth)))
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
