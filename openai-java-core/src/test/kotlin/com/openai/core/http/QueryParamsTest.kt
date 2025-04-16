package com.openai.core.http

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class QueryParamsTest {

    enum class TestCase(
        val queryParams: QueryParams,
        val expectedMap: Map<String, List<String>>,
        val expectedSize: Int,
    ) {
        EMPTY(QueryParams.builder().build(), expectedMap = mapOf(), expectedSize = 0),
        PUT_ONE(
            QueryParams.builder().put("key", "value").build(),
            expectedMap = mapOf("key" to listOf("value")),
            expectedSize = 1,
        ),
        PUT_MULTIPLE(
            QueryParams.builder().put("key", listOf("value1", "value2")).build(),
            expectedMap = mapOf("key" to listOf("value1", "value2")),
            expectedSize = 2,
        ),
        MULTIPLE_PUT(
            QueryParams.builder().put("key1", "value").put("key2", "value").build(),
            expectedMap = mapOf("key1" to listOf("value"), "key2" to listOf("value")),
            expectedSize = 2,
        ),
        MULTIPLE_PUT_SAME_NAME(
            QueryParams.builder().put("key", "value1").put("key", "value2").build(),
            expectedMap = mapOf("key" to listOf("value1", "value2")),
            expectedSize = 2,
        ),
        MULTIPLE_PUT_MULTIPLE(
            QueryParams.builder()
                .put("key", listOf("value1", "value2"))
                .put("key", listOf("value1", "value2"))
                .build(),
            expectedMap = mapOf("key" to listOf("value1", "value2", "value1", "value2")),
            expectedSize = 4,
        ),
        PUT_ALL_MAP(
            QueryParams.builder()
                .putAll(
                    mapOf(
                        "key1" to listOf("value1", "value2"),
                        "key2" to listOf("value1", "value2"),
                    )
                )
                .build(),
            expectedMap =
                mapOf("key1" to listOf("value1", "value2"), "key2" to listOf("value1", "value2")),
            expectedSize = 4,
        ),
        PUT_ALL_HEADERS(
            QueryParams.builder().putAll(QueryParams.builder().put("key", "value").build()).build(),
            expectedMap = mapOf("key" to listOf("value")),
            expectedSize = 1,
        ),
        REMOVE_ABSENT(
            QueryParams.builder().remove("key").build(),
            expectedMap = mapOf(),
            expectedSize = 0,
        ),
        REMOVE_PRESENT_ONE(
            QueryParams.builder().put("key", "value").remove("key").build(),
            expectedMap = mapOf(),
            expectedSize = 0,
        ),
        REMOVE_PRESENT_MULTIPLE(
            QueryParams.builder().put("key", listOf("value1", "value2")).remove("key").build(),
            expectedMap = mapOf(),
            expectedSize = 0,
        ),
        REMOVE_ALL(
            QueryParams.builder()
                .put("key1", "value")
                .put("key3", "value")
                .removeAll(setOf("key1", "key2", "key3"))
                .build(),
            expectedMap = mapOf(),
            expectedSize = 0,
        ),
        CLEAR(
            QueryParams.builder().put("key1", "value").put("key2", "value").clear().build(),
            expectedMap = mapOf(),
            expectedSize = 0,
        ),
        REPLACE_ONE_ABSENT(
            QueryParams.builder().replace("key", "value").build(),
            expectedMap = mapOf("key" to listOf("value")),
            expectedSize = 1,
        ),
        REPLACE_ONE_PRESENT_ONE(
            QueryParams.builder().put("key", "value1").replace("key", "value2").build(),
            expectedMap = mapOf("key" to listOf("value2")),
            expectedSize = 1,
        ),
        REPLACE_ONE_PRESENT_MULTIPLE(
            QueryParams.builder()
                .put("key", listOf("value1", "value2"))
                .replace("key", "value3")
                .build(),
            expectedMap = mapOf("key" to listOf("value3")),
            expectedSize = 1,
        ),
        REPLACE_MULTIPLE_ABSENT(
            QueryParams.builder().replace("key", listOf("value1", "value2")).build(),
            expectedMap = mapOf("key" to listOf("value1", "value2")),
            expectedSize = 2,
        ),
        REPLACE_MULTIPLE_PRESENT_ONE(
            QueryParams.builder()
                .put("key", "value1")
                .replace("key", listOf("value2", "value3"))
                .build(),
            expectedMap = mapOf("key" to listOf("value2", "value3")),
            expectedSize = 2,
        ),
        REPLACE_MULTIPLE_PRESENT_MULTIPLE(
            QueryParams.builder()
                .put("key", listOf("value1", "value2"))
                .replace("key", listOf("value3", "value4"))
                .build(),
            expectedMap = mapOf("key" to listOf("value3", "value4")),
            expectedSize = 2,
        ),
        REPLACE_ALL_MAP(
            QueryParams.builder()
                .put("key1", "value1")
                .put("key2", "value1")
                .put("key3", "value1")
                .replaceAll(mapOf("key1" to listOf("value2"), "key3" to listOf("value2")))
                .build(),
            expectedMap =
                mapOf(
                    "key1" to listOf("value2"),
                    "key2" to listOf("value1"),
                    "key3" to listOf("value2"),
                ),
            expectedSize = 3,
        ),
        REPLACE_ALL_HEADERS(
            QueryParams.builder()
                .put("key1", "value1")
                .put("key2", "value1")
                .put("key3", "value1")
                .replaceAll(
                    QueryParams.builder().put("key1", "value2").put("key3", "value2").build()
                )
                .build(),
            expectedMap =
                mapOf(
                    "key1" to listOf("value2"),
                    "key2" to listOf("value1"),
                    "key3" to listOf("value2"),
                ),
            expectedSize = 3,
        ),
    }

    @ParameterizedTest
    @EnumSource
    fun keysAndValues(testCase: TestCase) {
        val map = mutableMapOf<String, List<String>>()
        val queryParams = testCase.queryParams
        queryParams.keys().forEach { key -> map[key] = queryParams.values(key) }

        assertThat(map).isEqualTo(testCase.expectedMap)
    }

    @ParameterizedTest
    @EnumSource
    fun size(testCase: TestCase) {
        val size = testCase.queryParams.size

        assertThat(size).isEqualTo(testCase.expectedSize)
    }
}
