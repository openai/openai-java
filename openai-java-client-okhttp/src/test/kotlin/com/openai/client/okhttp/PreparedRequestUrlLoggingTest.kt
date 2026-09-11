package com.openai.client.okhttp

import com.fasterxml.jackson.databind.ObjectMapper
import com.openai.core.LogLevel
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.core.http.LoggingHttpClient
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import okhttp3.Interceptor
import okhttp3.Protocol
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.parallel.ResourceLock

/** Measured native URLs from issue #886, checked against request logging and preparation. */
internal class PreparedRequestUrlLoggingTest {
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
        val transport =
            OkHttpClient(
                okhttp3.OkHttpClient.Builder()
                    .addInterceptor(
                        Interceptor { chain ->
                            preparedUrls.add(chain.request().url.toString())
                            Response.Builder()
                                .request(chain.request())
                                .protocol(Protocol.HTTP_1_1)
                                .code(200)
                                .message("OK")
                                .body("".toResponseBody())
                                .build()
                        }
                    )
                    .build()
            )
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
                assertThat(output.toString("UTF-8")).contains("--> GET ${testCase.expected}\n")
            }
        } finally {
            System.setErr(originalErr)
            logger.close()
        }
    }

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
