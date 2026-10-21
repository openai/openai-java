// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseFunctionShellCallOutputContentTest {

    @Test
    fun createAndRoundtrip() {
        val responseFunctionShellCallOutputContent =
            ResponseFunctionShellCallOutputContent.builder()
                .outcomeTimeout()
                .stderr("stderr")
                .stdout("stdout")
                .build()

        assertThat(responseFunctionShellCallOutputContent.outcome())
            .isEqualTo(ResponseFunctionShellCallOutputContent.Outcome.ofTimeout())
        assertThat(responseFunctionShellCallOutputContent.stderr()).isEqualTo("stderr")
        assertThat(responseFunctionShellCallOutputContent.stdout()).isEqualTo("stdout")

        val jsonMapper = jsonMapper()

        val roundtrippedResponseFunctionShellCallOutputContent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseFunctionShellCallOutputContent),
                jacksonTypeRef<ResponseFunctionShellCallOutputContent>(),
            )

        assertThat(roundtrippedResponseFunctionShellCallOutputContent)
            .isEqualTo(responseFunctionShellCallOutputContent)
    }
}
