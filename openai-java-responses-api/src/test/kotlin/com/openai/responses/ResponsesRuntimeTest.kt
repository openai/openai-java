package com.openai.responses

import com.openai.core.ClientOptions
import java.io.File
import java.lang.reflect.InvocationTargetException
import java.net.URLClassLoader
import java.util.jar.Attributes
import java.util.jar.JarEntry
import java.util.jar.JarOutputStream
import java.util.jar.Manifest
import kotlin.test.assertContains
import kotlin.test.assertIs
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.io.TempDir

internal class ResponsesRuntimeTest {
    @TempDir lateinit var directory: File

    private val marker = "META-INF/com.openai/openai-java-runtime.marker"
    private val optionsClass = "com/openai/core/ClientOptions.class"

    @Test
    fun diagnosesOldCoreInEitherOrderAtConstruction() {
        val split = jar("openai-java-runtime", "5.0.0", marker, optionsClass)
        val old = jar("openai-java-core", "4.70.0", optionsClass)
        for (order in listOf(listOf(old, split), listOf(split, old))) {
            val failure = assertThrows<InvocationTargetException> { construct(order) }
            val message = assertIs<IllegalStateException>(failure.cause).message.orEmpty()
            assertContains(message, "openai-java-core 4.70.0")
            assertContains(message, "openai-java-bom")
            assertContains(message, "compiled against v4")
        }
    }

    @Test
    fun acceptsIsolatedAlignedAndAmbiguousClasspaths() {
        val split = jar("openai-java-runtime", "5.0.0", marker, optionsClass)
        val explodedOptions = File(directory, optionsClass)
        explodedOptions.parentFile.mkdirs()
        explodedOptions.createNewFile()
        construct(listOf(split, directory))
        construct(listOf(jar("openai-java-core", "4.70.0", optionsClass)))
        construct(
            listOf(
                split,
                jar("openai-java-core", "5.0.0"),
                jar("openai-java-core", "4.70.0"),
                jar("shaded-app", "4.70.0", optionsClass),
                jar(null, "4.70.0", optionsClass),
                jar("openai-java-core", null, optionsClass),
                jar("openai-java-core", "unknown", optionsClass),
                jar("openai-java-core", "4.70.0", marker, optionsClass),
            )
        )
    }

    private fun construct(artifacts: List<File>) {
        val client = OpenAIResponsesClient::class.java
        // Share dependency types with the test, but load the entry point and all resources locally.
        val dependencies =
            object : ClassLoader(null) {
                override fun findClass(name: String): Class<*> {
                    if (name.startsWith(client.name)) throw ClassNotFoundException(name)
                    return client.classLoader.loadClass(name)
                }
            }
        val urls =
            artifacts.map { it.toURI().toURL() } + client.protectionDomain.codeSource.location
        URLClassLoader(urls.toTypedArray(), dependencies).use { loader ->
            val constructor =
                loader.loadClass(client.name).getConstructor(ClientOptions::class.java)
            val options =
                ClientOptions.builder().httpClient(RecordingTransport()).apiKey("test").build()
            try {
                (constructor.newInstance(options) as AutoCloseable).close()
            } catch (failure: InvocationTargetException) {
                options.close()
                throw failure
            }
        }
    }

    private fun jar(title: String?, version: String?, vararg resources: String): File {
        val manifest = Manifest()
        manifest.mainAttributes.apply {
            put(Attributes.Name.MANIFEST_VERSION, "1.0")
            title?.let { put(Attributes.Name.IMPLEMENTATION_TITLE, it) }
            version?.let { put(Attributes.Name.IMPLEMENTATION_VERSION, it) }
        }
        return File.createTempFile("fixture-", ".jar", directory).apply {
            JarOutputStream(outputStream(), manifest).use { jar ->
                for (resource in resources) {
                    jar.putNextEntry(JarEntry(resource))
                    jar.closeEntry()
                }
            }
        }
    }
}
