package com.openai.core.http

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

internal class HeadersMapViewTest {

    @Test
    fun asMapReturnsCaseInsensitiveImmutableHeaderMapping() {
        val headers =
            Headers.builder()
                .put("X-Test", "one")
                .put("x-test", "two")
                .put("Other", "value")
                .build()

        val map = headers.asMap()

        assertThat(map["X-TEST"]).containsExactly("one", "two")
        assertThat(map["other"]).containsExactly("value")
        assertThat(map).hasSize(2)
    }

    @Test
    fun asMapDoesNotAllowMapMutation() {
        val map = Headers.builder().put("X-Test", "value").build().asMap()

        assertThatThrownBy {
                @Suppress("UNCHECKED_CAST")
                (map as MutableMap<String, List<String>>)["Other"] = listOf("value")
            }
            .isInstanceOf(UnsupportedOperationException::class.java)
    }

    @Test
    fun asMapDoesNotAllowValueListMutation() {
        val values = Headers.builder().put("X-Test", "value").build().asMap()["X-Test"]!!

        assertThatThrownBy {
                @Suppress("UNCHECKED_CAST")
                (values as MutableList<String>).add("other")
            }
            .isInstanceOf(UnsupportedOperationException::class.java)
    }
}
