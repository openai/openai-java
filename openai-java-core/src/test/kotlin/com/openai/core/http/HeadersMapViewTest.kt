package com.openai.core.http

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

internal class HeadersMapViewTest {
    @Test
    fun preservesNamesAndOrderedValuesWithCaseInsensitiveLookup() {
        val headers = Headers.builder().put("X-Test", "one").put("x-test", "two").build()
        val map = headers.asMap()

        assertThat(map).hasSize(1)
        assertThat(map.keys).containsExactly("X-Test")
        assertThat(map["X-TEST"]).containsExactly("one", "two")
        assertThat(map.containsKey("x-test")).isTrue()
        assertThat(map["missing"]).isNull()
        assertThat(headers.values("missing")).isEmpty()
        assertThat(Headers.builder().build().asMap()).isEmpty()
    }

    @Test
    fun rejectsMapAndValueMutations() {
        val map = Headers.builder().put("X-Test", "one").build().asMap() as MutableMap

        assertThatThrownBy { map["Other"] = listOf("value") }
            .isInstanceOf(UnsupportedOperationException::class.java)
        assertThatThrownBy { (map.getValue("x-test") as MutableList).add("two") }
            .isInstanceOf(UnsupportedOperationException::class.java)
        assertThatThrownBy { map.entries.first().setValue(listOf("two")) }
            .isInstanceOf(UnsupportedOperationException::class.java)
    }

    @Test
    fun remainsUnchangedWhenBuildersAreModified() {
        val builder = Headers.builder().put("X-Test", "one")
        val headers = builder.build()
        val map = headers.asMap()

        builder.put("x-test", "two")
        headers.toBuilder().replace("X-Test", "three").build()

        assertThat(map["x-test"]).containsExactly("one")
    }
}
