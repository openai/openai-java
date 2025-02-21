package com.openai.core.http

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.catchThrowable
import org.assertj.core.api.Assumptions.assumeThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class HeadersTest {

    enum class TestCase(
        val headers: Headers,
        val expectedMap: Map<String, List<String>>,
        val expectedSize: Int,
    ) {
        EMPTY(Headers.builder().build(), expectedMap = mapOf(), expectedSize = 0),
        PUT_ONE(
            Headers.builder().put("name", "value").build(),
            expectedMap = mapOf("name" to listOf("value")),
            expectedSize = 1,
        ),
        PUT_MULTIPLE(
            Headers.builder().put("name", listOf("value1", "value2")).build(),
            expectedMap = mapOf("name" to listOf("value1", "value2")),
            expectedSize = 2,
        ),
        MULTIPLE_PUT(
            Headers.builder().put("name1", "value").put("name2", "value").build(),
            expectedMap = mapOf("name1" to listOf("value"), "name2" to listOf("value")),
            expectedSize = 2,
        ),
        MULTIPLE_PUT_SAME_NAME(
            Headers.builder().put("name", "value1").put("name", "value2").build(),
            expectedMap = mapOf("name" to listOf("value1", "value2")),
            expectedSize = 2,
        ),
        MULTIPLE_PUT_MULTIPLE(
            Headers.builder()
                .put("name", listOf("value1", "value2"))
                .put("name", listOf("value1", "value2"))
                .build(),
            expectedMap = mapOf("name" to listOf("value1", "value2", "value1", "value2")),
            expectedSize = 4,
        ),
        PUT_CASE_INSENSITIVE(
            Headers.builder()
                .put("name", "value1")
                .put("NAME", "value2")
                .put("nAmE", "value3")
                .build(),
            expectedMap = mapOf("name" to listOf("value1", "value2", "value3")),
            expectedSize = 3,
        ),
        PUT_ALL_MAP(
            Headers.builder()
                .putAll(
                    mapOf(
                        "name1" to listOf("value1", "value2"),
                        "name2" to listOf("value1", "value2"),
                    )
                )
                .build(),
            expectedMap =
                mapOf("name1" to listOf("value1", "value2"), "name2" to listOf("value1", "value2")),
            expectedSize = 4,
        ),
        PUT_ALL_HEADERS(
            Headers.builder().putAll(Headers.builder().put("name", "value").build()).build(),
            expectedMap = mapOf("name" to listOf("value")),
            expectedSize = 1,
        ),
        PUT_ALL_CASE_INSENSITIVE(
            Headers.builder()
                .putAll(
                    mapOf(
                        "name" to listOf("value1"),
                        "NAME" to listOf("value2"),
                        "nAmE" to listOf("value3"),
                    )
                )
                .build(),
            expectedMap = mapOf("name" to listOf("value1", "value2", "value3")),
            expectedSize = 3,
        ),
        REMOVE_ABSENT(
            Headers.builder().remove("name").build(),
            expectedMap = mapOf(),
            expectedSize = 0,
        ),
        REMOVE_PRESENT_ONE(
            Headers.builder().put("name", "value").remove("name").build(),
            expectedMap = mapOf(),
            expectedSize = 0,
        ),
        REMOVE_PRESENT_MULTIPLE(
            Headers.builder().put("name", listOf("value1", "value2")).remove("name").build(),
            expectedMap = mapOf(),
            expectedSize = 0,
        ),
        REMOVE_CASE_INSENSITIVE(
            Headers.builder().put("name", listOf("value1", "value2")).remove("NAME").build(),
            expectedMap = mapOf(),
            expectedSize = 0,
        ),
        REMOVE_ALL(
            Headers.builder()
                .put("name1", "value")
                .put("name3", "value")
                .removeAll(setOf("name1", "name2", "name3"))
                .build(),
            expectedMap = mapOf(),
            expectedSize = 0,
        ),
        REMOVE_ALL_CASE_INSENSITIVE(
            Headers.builder()
                .put("name1", "value")
                .put("name3", "value")
                .removeAll(setOf("NAME1", "nAmE3"))
                .build(),
            expectedMap = mapOf(),
            expectedSize = 0,
        ),
        CLEAR(
            Headers.builder().put("name1", "value").put("name2", "value").clear().build(),
            expectedMap = mapOf(),
            expectedSize = 0,
        ),
        REPLACE_ONE_ABSENT(
            Headers.builder().replace("name", "value").build(),
            expectedMap = mapOf("name" to listOf("value")),
            expectedSize = 1,
        ),
        REPLACE_ONE_PRESENT_ONE(
            Headers.builder().put("name", "value1").replace("name", "value2").build(),
            expectedMap = mapOf("name" to listOf("value2")),
            expectedSize = 1,
        ),
        REPLACE_ONE_PRESENT_MULTIPLE(
            Headers.builder()
                .put("name", listOf("value1", "value2"))
                .replace("name", "value3")
                .build(),
            expectedMap = mapOf("name" to listOf("value3")),
            expectedSize = 1,
        ),
        REPLACE_MULTIPLE_ABSENT(
            Headers.builder().replace("name", listOf("value1", "value2")).build(),
            expectedMap = mapOf("name" to listOf("value1", "value2")),
            expectedSize = 2,
        ),
        REPLACE_MULTIPLE_PRESENT_ONE(
            Headers.builder()
                .put("name", "value1")
                .replace("name", listOf("value2", "value3"))
                .build(),
            expectedMap = mapOf("name" to listOf("value2", "value3")),
            expectedSize = 2,
        ),
        REPLACE_MULTIPLE_PRESENT_MULTIPLE(
            Headers.builder()
                .put("name", listOf("value1", "value2"))
                .replace("name", listOf("value3", "value4"))
                .build(),
            expectedMap = mapOf("name" to listOf("value3", "value4")),
            expectedSize = 2,
        ),
        REPLACE_CASE_INSENSITIVE(
            Headers.builder()
                .put("name", "value1")
                .replace("NAME", listOf("value2", "value3"))
                .build(),
            expectedMap = mapOf("NAME" to listOf("value2", "value3")),
            expectedSize = 2,
        ),
        REPLACE_ALL_MAP(
            Headers.builder()
                .put("name1", "value1")
                .put("name2", "value1")
                .put("name3", "value1")
                .replaceAll(mapOf("name1" to listOf("value2"), "name3" to listOf("value2")))
                .build(),
            expectedMap =
                mapOf(
                    "name1" to listOf("value2"),
                    "name2" to listOf("value1"),
                    "name3" to listOf("value2"),
                ),
            expectedSize = 3,
        ),
        REPLACE_ALL_HEADERS(
            Headers.builder()
                .put("name1", "value1")
                .put("name2", "value1")
                .put("name3", "value1")
                .replaceAll(Headers.builder().put("name1", "value2").put("name3", "value2").build())
                .build(),
            expectedMap =
                mapOf(
                    "name1" to listOf("value2"),
                    "name2" to listOf("value1"),
                    "name3" to listOf("value2"),
                ),
            expectedSize = 3,
        ),
        REPLACE_ALL_CASE_INSENSITIVE(
            Headers.builder()
                .put("name1", "value1")
                .put("name2", "value1")
                .replaceAll(mapOf("NAME1" to listOf("value2"), "nAmE2" to listOf("value2")))
                .build(),
            expectedMap = mapOf("NAME1" to listOf("value2"), "nAmE2" to listOf("value2")),
            expectedSize = 2,
        ),
    }

    @ParameterizedTest
    @EnumSource
    fun namesAndValues(testCase: TestCase) {
        val map = mutableMapOf<String, List<String>>()
        val headers = testCase.headers
        headers.names().forEach { name -> map[name] = headers.values(name) }

        assertThat(map).isEqualTo(testCase.expectedMap)
    }

    @ParameterizedTest
    @EnumSource
    fun caseInsensitiveNames(testCase: TestCase) {
        val headers = testCase.headers

        for (name in headers.names()) {
            assertThat(headers.values(name)).isEqualTo(headers.values(name.lowercase()))
            assertThat(headers.values(name)).isEqualTo(headers.values(name.uppercase()))
        }
    }

    @ParameterizedTest
    @EnumSource
    fun size(testCase: TestCase) {
        val size = testCase.headers.size

        assertThat(size).isEqualTo(testCase.expectedSize)
    }

    @ParameterizedTest
    @EnumSource
    fun namesAreImmutable(testCase: TestCase) {
        val headers = testCase.headers
        val headerNamesCopy = headers.names().toSet()

        val throwable = catchThrowable {
            (headers.names() as MutableSet<String>).add("another name")
        }

        assertThat(throwable).isInstanceOf(UnsupportedOperationException::class.java)
        assertThat(headers.names()).isEqualTo(headerNamesCopy)
    }

    @ParameterizedTest
    @EnumSource
    fun valuesAreImmutable(testCase: TestCase) {
        val headers = testCase.headers
        assumeThat(headers.size).isNotEqualTo(0)
        val name = headers.names().first()
        val headerValuesCopy = headers.values(name).toList()

        val throwable = catchThrowable {
            (headers.values(name) as MutableList<String>).add("another value")
        }

        assertThat(throwable).isInstanceOf(UnsupportedOperationException::class.java)
        assertThat(headers.values(name)).isEqualTo(headerValuesCopy)
    }
}
