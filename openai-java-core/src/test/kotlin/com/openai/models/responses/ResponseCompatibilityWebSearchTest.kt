package com.openai.models.responses

import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.beta.responses.BetaResponseFunctionWebSearch
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class ResponseCompatibilityWebSearchTest {

    @Test
    fun explicitNullActionIsEmptyInBothClients() {
        val gaCall = ga("null").validate()
        val betaCall = beta("null").validate()
        assertThat(gaCall.action()).isEmpty
        assertThat(betaCall.action()).isEmpty
        assertThat(gaCall._action().isNull()).isTrue
        assertThat(betaCall._action().isNull()).isTrue
    }

    @Test
    fun presentSearchExposesItsQueries() {
        val action = """{"type":"search","queries":["weather"]}"""
        assertThat(ga(action).validate().action().get().asSearch().queries().get())
            .containsExactly("weather")
        assertThat(beta(action).validate().action().get().asSearch().queries().get())
            .containsExactly("weather")
    }

    @Test
    fun presentOpenPageExposesItsUrl() {
        val action = """{"type":"open_page","url":"https://example.org"}"""
        assertThat(ga(action).validate().action().get().asOpenPage().url())
            .contains("https://example.org")
        assertThat(beta(action).validate().action().get().asOpenPage().url())
            .contains("https://example.org")
    }

    @Test
    fun presentFindExposesItsPattern() {
        val action = """{"type":"find_in_page","url":"https://example.org","pattern":"rain"}"""
        assertThat(ga(action).validate().action().get().asFind().patternOrThrow()).isEqualTo("rain")
        assertThat(beta(action).validate().action().get().asFindInPage().patternOrThrow())
            .isEqualTo("rain")
    }

    @ParameterizedTest
    @ValueSource(strings = ["""{"type":"unknown"}""", """{"type":42}"""])
    fun strictValidationRejectsMalformedActionTags(action: String) {
        assertThatThrownBy { ga(action).validate() }
            .isInstanceOf(OpenAIInvalidDataException::class.java)
        assertThatThrownBy { beta(action).validate() }
            .isInstanceOf(OpenAIInvalidDataException::class.java)
    }

    @ParameterizedTest
    @ValueSource(
        strings =
            [
                """{"type":"find_in_page","pattern":"rain"}""",
                """{"type":"find_in_page","pattern":"rain","url":null}""",
            ]
    )
    fun presentFindStillRequiresAUrl(action: String) {
        assertThatThrownBy { ga(action).validate() }
            .isInstanceOf(OpenAIInvalidDataException::class.java)
            .hasMessageContaining("url")
        assertThatThrownBy { beta(action).validate() }
            .isInstanceOf(OpenAIInvalidDataException::class.java)
            .hasMessageContaining("url")
    }

    private fun call(action: String) =
        """{"id":"ws_1","type":"web_search_call","status":"completed","action":$action}"""

    private fun ga(action: String) =
        jsonMapper().readValue(call(action), ResponseFunctionWebSearch::class.java)

    private fun beta(action: String) =
        jsonMapper().readValue(call(action), BetaResponseFunctionWebSearch::class.java)
}
