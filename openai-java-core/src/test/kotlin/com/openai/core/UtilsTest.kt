package com.openai.core

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UtilsTest {
    @Test
    fun contentDeepEquals() {
        assertThat(42 contentEquals 42).isTrue()
        assertThat(42 contentEquals "Hello World!").isFalse()
        assertThat(byteArrayOf(1, 2, 3) contentEquals byteArrayOf(1, 2, 3)).isTrue()
        assertThat(byteArrayOf(1, 2, 3) contentEquals byteArrayOf(1, 2, 4)).isFalse()
        assertThat(
                arrayOf(byteArrayOf(1, 2), byteArrayOf(3)) contentEquals
                    arrayOf(byteArrayOf(1, 2), byteArrayOf(3))
            )
            .isTrue()
        assertThat(
                arrayOf(byteArrayOf(1, 2), byteArrayOf(3)) contentEquals
                    arrayOf(byteArrayOf(1), byteArrayOf(2, 3))
            )
            .isFalse()
    }

    @Test
    fun contentToString() {
        assertThat((42).contentToString()).isEqualTo("42")
        assertThat("Hello World!".contentToString()).isEqualTo("Hello World!")
        assertThat(byteArrayOf(1, 2, 3).contentToString()).isEqualTo("[1, 2, 3]")
        assertThat(arrayOf(byteArrayOf(1, 2), byteArrayOf(3)).contentToString())
            .isEqualTo("[[1, 2], [3]]")
    }
}
