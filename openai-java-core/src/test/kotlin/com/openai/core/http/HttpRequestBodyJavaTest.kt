package com.openai.core.http

import java.net.URLClassLoader
import java.nio.file.Files
import java.nio.file.Path
import javax.tools.ToolProvider
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.io.TempDir
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class HttpRequestBodyJavaTest {
    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun javaImplementationUsesDefaultContent(
        compiledAgainstOldInterface: Boolean,
        @TempDir directory: Path,
    ) {
        val sources = mutableListOf<Path>()
        if (compiledAgainstOldInterface) {
            // Load this implementation against today's SDK after compiling against the old API.
            val api = directory.resolve("com/openai/core/http/HttpRequestBody.java")
            Files.createDirectories(api.parent)
            Files.write(
                api,
                """
                package com.openai.core.http;
                public interface HttpRequestBody extends AutoCloseable {
                    void writeTo(java.io.OutputStream output);
                    String contentType();
                    long contentLength();
                    boolean repeatable();
                    void close();
                }
                """
                    .trimIndent()
                    .toByteArray(),
            )
            sources.add(api)
        }
        val implementation = directory.resolve("LegacyBody.java")
        Files.write(
            implementation,
            """
            public final class LegacyBody implements com.openai.core.http.HttpRequestBody {
                public void writeTo(java.io.OutputStream output) {
                    try { output.write(new byte[] {1, 2, 3}); }
                    catch (java.io.IOException e) { throw new java.io.UncheckedIOException(e); }
                }
                public String contentType() { return null; }
                public long contentLength() { return 3; }
                public boolean repeatable() { return true; }
                public void close() {}
            }
            """
                .trimIndent()
                .toByteArray(),
        )
        sources.add(implementation)

        val arguments =
            listOf(
                "--release",
                "8",
                "-classpath",
                System.getProperty("java.class.path"),
                "-d",
                directory.toString(),
            ) + sources.map { it.toString() }
        assertThat(
                ToolProvider.getSystemJavaCompiler()
                    .run(null, null, null, *arguments.toTypedArray())
            )
            .isZero()

        URLClassLoader(arrayOf(directory.toUri().toURL()), HttpRequestBody::class.java.classLoader)
            .use { loader ->
                val body =
                    loader.loadClass("LegacyBody").getDeclaredConstructor().newInstance()
                        as HttpRequestBody
                body.use {
                    it.content().use { content ->
                        assertThat(content.readBytes()).isEqualTo(byteArrayOf(1, 2, 3))
                    }
                }
            }
    }
}
