package com.openai.core.http

import com.fasterxml.jackson.databind.ObjectMapper
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

/** Measured URL inputs and default-transport outputs from the issue #886 investigation. */
internal class HttpRequestUrlParityTest {
    data class UrlCase(
        val name: String,
        val base: String,
        val path: List<String>,
        val query: List<Pair<String, String>>,
        val expected: String,
    ) {
        override fun toString(): String = name
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("cases")
    fun urlMatchesDefaultTransport(testCase: UrlCase) {
        val builder = HttpRequest.builder().method(HttpMethod.GET).baseUrl(testCase.base)
        testCase.path.forEach(builder::addPathSegment)
        testCase.query.forEach { (key, value) -> builder.putQueryParam(key, value) }
        val request = builder.build()

        if (testCase.expected == "ERROR IllegalArgumentException") {
            assertThatThrownBy { request.url() }.isInstanceOf(IllegalArgumentException::class.java)
        } else {
            assertThat(request.url()).isEqualTo(testCase.expected)
        }
    }

    companion object {
        @JvmStatic
        fun cases(): List<UrlCase> {
            val mapper = ObjectMapper()
            val stream =
                checkNotNull(
                    HttpRequestUrlParityTest::class
                        .java
                        .getResourceAsStream("/com/openai/core/http/url-parity-cases.tsv")
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
