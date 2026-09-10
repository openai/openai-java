// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class WebSearchActionTest {

    @Test
    fun ofSearch() {
        val search = WebSearchAction.Search.builder().addQuery("string").query("query").build()

        val webSearchAction = WebSearchAction.ofSearch(search)

        assertThat(webSearchAction.search()).contains(search)
        assertThat(webSearchAction.openPage()).isEmpty
        assertThat(webSearchAction.findInPage()).isEmpty
        assertThat(webSearchAction.other()).isEmpty
    }

    @Test
    fun ofSearchRoundtrip() {
        val jsonMapper = jsonMapper()
        val webSearchAction =
            WebSearchAction.ofSearch(
                WebSearchAction.Search.builder().addQuery("string").query("query").build()
            )

        val roundtrippedWebSearchAction =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(webSearchAction),
                jacksonTypeRef<WebSearchAction>(),
            )

        assertThat(roundtrippedWebSearchAction).isEqualTo(webSearchAction)
    }

    @Test
    fun ofOpenPage() {
        val openPage = WebSearchAction.OpenPage.builder().url("url").build()

        val webSearchAction = WebSearchAction.ofOpenPage(openPage)

        assertThat(webSearchAction.search()).isEmpty
        assertThat(webSearchAction.openPage()).contains(openPage)
        assertThat(webSearchAction.findInPage()).isEmpty
        assertThat(webSearchAction.other()).isEmpty
    }

    @Test
    fun ofOpenPageRoundtrip() {
        val jsonMapper = jsonMapper()
        val webSearchAction =
            WebSearchAction.ofOpenPage(WebSearchAction.OpenPage.builder().url("url").build())

        val roundtrippedWebSearchAction =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(webSearchAction),
                jacksonTypeRef<WebSearchAction>(),
            )

        assertThat(roundtrippedWebSearchAction).isEqualTo(webSearchAction)
    }

    @Test
    fun ofFindInPage() {
        val findInPage = WebSearchAction.FindInPage.builder().pattern("pattern").url("url").build()

        val webSearchAction = WebSearchAction.ofFindInPage(findInPage)

        assertThat(webSearchAction.search()).isEmpty
        assertThat(webSearchAction.openPage()).isEmpty
        assertThat(webSearchAction.findInPage()).contains(findInPage)
        assertThat(webSearchAction.other()).isEmpty
    }

    @Test
    fun ofFindInPageRoundtrip() {
        val jsonMapper = jsonMapper()
        val webSearchAction =
            WebSearchAction.ofFindInPage(
                WebSearchAction.FindInPage.builder().pattern("pattern").url("url").build()
            )

        val roundtrippedWebSearchAction =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(webSearchAction),
                jacksonTypeRef<WebSearchAction>(),
            )

        assertThat(roundtrippedWebSearchAction).isEqualTo(webSearchAction)
    }

    @Test
    fun ofOther() {
        val webSearchAction = WebSearchAction.ofOther()

        assertThat(webSearchAction.search()).isEmpty
        assertThat(webSearchAction.openPage()).isEmpty
        assertThat(webSearchAction.findInPage()).isEmpty
        assertThat(webSearchAction.other()).contains(JsonValue.from(mapOf("type" to "other")))
    }

    @Test
    fun ofOtherRoundtrip() {
        val jsonMapper = jsonMapper()
        val webSearchAction = WebSearchAction.ofOther()

        val roundtrippedWebSearchAction =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(webSearchAction),
                jacksonTypeRef<WebSearchAction>(),
            )

        assertThat(roundtrippedWebSearchAction).isEqualTo(webSearchAction)
    }

    enum class IncompatibleJsonShapeTestCase(val value: JsonValue) {
        BOOLEAN(JsonValue.from(false)),
        STRING(JsonValue.from("invalid")),
        INTEGER(JsonValue.from(-1)),
        FLOAT(JsonValue.from(3.14)),
        ARRAY(JsonValue.from(listOf("invalid", "array"))),
    }

    @ParameterizedTest
    @EnumSource
    fun incompatibleJsonShapeDeserializesToUnknown(testCase: IncompatibleJsonShapeTestCase) {
        val webSearchAction =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<WebSearchAction>())

        val e = assertThrows<OpenAIInvalidDataException> { webSearchAction.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
