package com.openai.client.okhttp

import com.fasterxml.jackson.databind.ObjectMapper
import com.openai.core.LogLevel
import com.openai.core.RequestOptions
import com.openai.core.http.HttpClient
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse
import com.openai.core.http.LoggingHttpClient
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import java.util.concurrent.CompletableFuture
import okhttp3.Protocol
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.parallel.ResourceLock

/** Measured native URLs from issue #886, checked against request logging and preparation. */
internal class PreparedRequestUrlLoggingTest {

    @Test
    @ResourceLock("stderr")
    fun recompiledDelegatedWrapperPreservesBothOverridesAndPreparedUrl() {
        for (level in listOf(LogLevel.OFF, LogLevel.INFO)) {
            for (async in listOf(false, true)) {
                val preparedUrls = mutableListOf<String>()
                val transport = recordingTransport(preparedUrls)
                var syncOverrides = 0
                var asyncOverrides = 0
                val wrapper =
                    object : HttpClient by transport {
                        override fun execute(
                            request: HttpRequest,
                            requestOptions: RequestOptions,
                        ): HttpResponse {
                            syncOverrides++
                            if (level == LogLevel.OFF) {
                                assertThat(requestOptions).isSameAs(RequestOptions.none())
                            }
                            return transport.execute(
                                request.toBuilder().addPathSegment("wrapped sync").build(),
                                requestOptions,
                            )
                        }

                        override fun executeAsync(
                            request: HttpRequest,
                            requestOptions: RequestOptions,
                        ): CompletableFuture<HttpResponse> {
                            asyncOverrides++
                            if (level == LogLevel.OFF) {
                                assertThat(requestOptions).isSameAs(RequestOptions.none())
                            }
                            return transport.executeAsync(
                                request.toBuilder().addPathSegment("wrapped async").build(),
                                requestOptions,
                            )
                        }
                    }
                val logger = LoggingHttpClient.builder().httpClient(wrapper).level(level).build()
                val output = ByteArrayOutputStream()
                val originalErr = System.err
                try {
                    System.setErr(PrintStream(output, true, "UTF-8"))
                    val request =
                        HttpRequest.builder()
                            .method(HttpMethod.GET)
                            .baseUrl("https://example.test/v1")
                            .build()
                    val response =
                        if (async) logger.executeAsync(request).get() else logger.execute(request)
                    response.use { assertThat(it.statusCode()).isEqualTo(200) }
                    val suffix = if (async) "async" else "sync"
                    val expectedUrl = "https://example.test/v1/wrapped%20$suffix"
                    assertThat(preparedUrls).containsExactly(expectedUrl)
                    assertThat(syncOverrides).isEqualTo(if (async) 0 else 1)
                    assertThat(asyncOverrides).isEqualTo(if (async) 1 else 0)
                    if (level == LogLevel.INFO) {
                        assertThat(output.toString("UTF-8")).contains("--> GET $expectedUrl\n")
                    } else {
                        assertThat(output.toString("UTF-8")).isEmpty()
                    }
                } finally {
                    System.setErr(originalErr)
                    logger.close()
                }
            }
        }
    }

    data class UrlCase(
        val name: String,
        val base: String,
        val path: List<String>,
        val query: List<Pair<String, String>>,
        val expected: String,
    ) {
        override fun toString(): String = name
    }

    @TestFactory
    @ResourceLock("stderr")
    fun logsThePreparedUrlOrRejectsBeforeDispatch(): List<DynamicTest> =
        cases().map { testCase ->
            DynamicTest.dynamicTest(testCase.name) { verifyPreparedUrl(testCase) }
        }

    private fun verifyPreparedUrl(testCase: UrlCase) {
        val builder = HttpRequest.builder().method(HttpMethod.GET).baseUrl(testCase.base)
        testCase.path.forEach(builder::addPathSegment)
        testCase.query.forEach { (key, value) -> builder.putQueryParam(key, value) }
        val preparedUrls = mutableListOf<String>()
        val transport = recordingTransport(preparedUrls)
        val logger = LoggingHttpClient.builder().httpClient(transport).level(LogLevel.INFO).build()
        val output = ByteArrayOutputStream()
        val originalErr = System.err
        try {
            System.setErr(PrintStream(output, true, "UTF-8"))
            if (testCase.expected == "ERROR IllegalArgumentException") {
                assertThatThrownBy { logger.execute(builder.build()) }
                    .isInstanceOf(IllegalArgumentException::class.java)
                assertThat(preparedUrls).isEmpty()
                assertThat(output.toString("UTF-8")).doesNotContain("--> GET")
            } else {
                logger.execute(builder.build()).use { assertThat(it.statusCode()).isEqualTo(200) }
                assertThat(preparedUrls).containsExactly(testCase.expected)
                val loggedUrl =
                    testCase.expected.replace(Regex("^([A-Za-z][A-Za-z0-9+.-]*://)[^/?#@]*@")) {
                        "${it.groupValues[1]}██@"
                    }
                assertThat(output.toString("UTF-8")).contains("--> GET $loggedUrl\n")
            }
        } finally {
            System.setErr(originalErr)
            logger.close()
        }
    }

    private fun recordingTransport(preparedUrls: MutableList<String>): OkHttpClient =
        OkHttpClient(
            okhttp3.OkHttpClient.Builder()
                .addInterceptor { chain ->
                    preparedUrls.add(chain.request().url.toString())
                    Response.Builder()
                        .request(chain.request())
                        .protocol(Protocol.HTTP_1_1)
                        .code(200)
                        .message("OK")
                        .body("".toResponseBody())
                        .build()
                }
                .build()
        )

    companion object {
        @JvmStatic
        fun cases(): List<UrlCase> {
            val mapper = ObjectMapper()
            val stream =
                checkNotNull(
                    PreparedRequestUrlLoggingTest::class
                        .java
                        .getResourceAsStream("/com/openai/client/okhttp/url-parity-cases.tsv")
                )
            val lines = stream.bufferedReader(Charsets.UTF_8).use { it.readLines() }
            check(lines.first() == "name\tbase\tpath\tquery\texpected")
            val cases =
                lines.drop(1).map { line ->
                    val fields = line.split('\t')
                    check(fields.size == 5)
                    val path = mapper.readTree(fields[2]).map { it.asText() }
                    val query =
                        mapper.readTree(fields[3]).map { pair ->
                            check(pair.size() == 2)
                            pair[0].asText() to pair[1].asText()
                        }
                    UrlCase(
                        mapper.readTree(fields[0]).asText(),
                        mapper.readTree(fields[1]).asText(),
                        path,
                        query,
                        mapper.readTree(fields[4]).asText(),
                    )
                }
            check(cases.size == 147)
            check(cases.count { it.expected != "ERROR IllegalArgumentException" } == 117)
            check(cases.map { it.name }.toSet().size == cases.size)
            return cases
        }
    }
}
