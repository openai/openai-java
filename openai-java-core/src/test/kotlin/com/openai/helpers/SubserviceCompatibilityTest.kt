package com.openai.helpers

import com.openai.core.ClientOptions
import com.openai.services.async.RealtimeServiceAsync
import com.openai.services.blocking.RealtimeService
import java.io.File
import java.io.StringWriter
import java.lang.reflect.InvocationTargetException
import java.net.URLClassLoader
import java.nio.file.Files
import java.nio.file.Path
import javax.tools.ToolProvider
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.io.TempDir
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class SubserviceCompatibilityTest {
    @TempDir lateinit var tempDir: Path

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3])
    fun existingJavaServicesRemainSourceAndBinaryCompatible(index: Int) {
        val outer = if (index < 2) RealtimeService::class.java else RealtimeServiceAsync::class.java
        val service =
            if (index % 2 == 0) outer
            else outer.declaredClasses.single { it.simpleName == "WithRawResponse" }
        val methods = service.methods.filter { it.name != "translations" }.sortedBy { it.name }
        fun declaration(method: java.lang.reflect.Method): String =
            "${method.returnType.canonicalName} ${method.name}(" +
                method.parameterTypes
                    .mapIndexed { i, type -> "${type.canonicalName} p$i" }
                    .joinToString(", ") +
                ")"
        val consumerName = "LegacyService$index"
        val overrides =
            methods.joinToString("\n") {
                "public ${declaration(it)} { " +
                    (if (it.name == "calls") "calls++; " else "") +
                    (if (it.returnType == service) "return this;" else "return null;") +
                    " }"
            }
        val consumerSource =
            "public class $consumerName implements ${service.canonicalName} { public int calls; $overrides }"
        val classpath =
            (listOf(outer, ClientOptions::class.java, Metadata::class.java) +
                    methods.flatMap { it.parameterTypes.toList() + it.returnType })
                .mapNotNull { it.protectionDomain.codeSource?.location }
                .map { File(it.toURI()).path }
                .distinct()
                .joinToString(File.pathSeparator)
        val sourceConsumer =
            compileJava(tempDir, "source-consumer", consumerName, consumerSource, classpath)
        val raw = outer.declaredClasses.single { it.simpleName == "WithRawResponse" }
        fun oldDeclarations(type: Class<*>): String =
            type.methods
                .filter { it.name != "translations" }
                .joinToString("\n") { "${declaration(it)};" }
        // Compile against the earlier ABI, then load only the unchanged consumer with today's SDK.
        val oldSource =
            "package ${outer.`package`.name}; public interface ${outer.simpleName} { ${oldDeclarations(outer)} public interface WithRawResponse { ${oldDeclarations(raw)} } }"
        val oldAbi = compileJava(tempDir, "old-abi", outer.simpleName, oldSource, classpath)
        val binaryConsumer =
            compileJava(
                tempDir,
                "binary-consumer",
                consumerName,
                consumerSource,
                "$oldAbi${File.pathSeparator}$classpath",
            )
        for (consumer in listOf(sourceConsumer, binaryConsumer)) {
            URLClassLoader(arrayOf(consumer.toUri().toURL()), service.classLoader).use { loader ->
                val instance = loader.loadClass(consumerName).getDeclaredConstructor().newInstance()
                service.getMethod("calls").invoke(instance)
                assertThat(instance.javaClass.getField("calls").getInt(instance)).isEqualTo(1)
                assertThatThrownBy { service.getMethod("translations").invoke(instance) }
                    .isInstanceOf(InvocationTargetException::class.java)
                    .hasCauseInstanceOf(UnsupportedOperationException::class.java)
            }
        }
    }
}

internal fun compileJava(
    tempDir: Path,
    directory: String,
    name: String,
    source: String,
    classpath: String,
): Path {
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
