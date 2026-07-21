// File generated from our OpenAPI spec by Stainless.

package com.openai.springboot

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.expression.Expression

internal class SpringFrameworkVersionTest {

    @Test
    fun springExpressionUsesPatchedVersion() {
        assertThat(Expression::class.java.`package`.implementationVersion).isEqualTo("5.3.39")
    }
}
