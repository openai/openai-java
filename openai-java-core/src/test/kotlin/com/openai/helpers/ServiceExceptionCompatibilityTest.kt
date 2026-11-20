package com.openai.helpers

import com.openai.core.JsonValue
import com.openai.core.http.Headers
import com.openai.errors.OpenAIException
import com.openai.errors.OpenAIServiceException
import java.io.File
import java.net.URLClassLoader
import java.nio.file.Path
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.io.TempDir

internal class ServiceExceptionCompatibilityTest {
    @Test
    fun existingRequestIdHelperRemainsSourceAndBinaryCompatible(@TempDir dir: Path) {
        val classpath =
            listOf(
                    OpenAIServiceException::class.java,
                    OpenAIException::class.java,
                    JsonValue::class.java,
                    Headers::class.java,
                    Metadata::class.java,
                )
                .map { File(it.protectionDomain.codeSource.location.toURI()).path }
                .distinct()
                .joinToString(File.pathSeparator)
        val methods =
            """
            public abstract int statusCode();
            public abstract com.openai.core.http.Headers headers();
            public abstract com.openai.core.JsonValue body();
            public abstract java.util.Optional<String> code();
            public abstract java.util.Optional<String> param();
            public abstract java.util.Optional<String> type();
            """
                .trimIndent()
        val oldAbi =
            compileJava(
                dir,
                "old-abi",
                "OpenAIServiceException",
                """
            package com.openai.errors;
            public abstract class OpenAIServiceException extends OpenAIException {
                protected OpenAIServiceException(String message, Throwable cause) { super(message, cause); }
                $methods
            }
        """
                    .trimIndent(),
                classpath,
            )
        val source =
            """
            public class LegacyServiceException extends com.openai.errors.OpenAIServiceException {
                public LegacyServiceException() { super("legacy", null); }
                public java.util.Optional<String> requestId() { return java.util.Optional.of("legacy_id"); }
                public int statusCode() { return 418; }
                public com.openai.core.http.Headers headers() {
                    return com.openai.core.http.Headers.builder().put("x-request-id", "server_id").build();
                }
                public com.openai.core.JsonValue body() { return null; }
                public java.util.Optional<String> code() { return java.util.Optional.empty(); }
                public java.util.Optional<String> param() { return java.util.Optional.empty(); }
                public java.util.Optional<String> type() { return java.util.Optional.empty(); }
            }
            """
                .trimIndent()
        val fresh = compileJava(dir, "fresh", "LegacyServiceException", source, classpath)
        val binary =
            compileJava(
                dir,
                "binary",
                "LegacyServiceException",
                source,
                "$oldAbi${File.pathSeparator}$classpath",
            )
        for (consumer in listOf(fresh, binary)) {
            // Load only the consumer with today's SDK, never the old API stub.
            URLClassLoader(
                    arrayOf(consumer.toUri().toURL()),
                    OpenAIServiceException::class.java.classLoader,
                )
                .use { loader ->
                    val error =
                        loader
                            .loadClass("LegacyServiceException")
                            .getDeclaredConstructor()
                            .newInstance() as OpenAIServiceException
                    assertThat(error.requestId()).contains("legacy_id")
                    assertThat(error.headers().values("x-request-id")).containsExactly("server_id")
                }
        }
    }
}
