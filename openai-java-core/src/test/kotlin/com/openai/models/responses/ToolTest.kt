// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.openai.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ToolTest {

    @Test
    fun ofFileSearch() {
        val fileSearch = FileSearchTool.builder().addVectorStoreId("string").build()

        val tool = Tool.ofFileSearch(fileSearch)

        assertThat(tool.fileSearch()).contains(fileSearch)
        assertThat(tool.function()).isEmpty
        assertThat(tool.computerUsePreview()).isEmpty
        assertThat(tool.webSearch()).isEmpty
    }

    @Test
    fun ofFunction() {
        val function =
            FunctionTool.builder()
                .name("name")
                .parameters(
                    FunctionTool.Parameters.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .strict(true)
                .build()

        val tool = Tool.ofFunction(function)

        assertThat(tool.fileSearch()).isEmpty
        assertThat(tool.function()).contains(function)
        assertThat(tool.computerUsePreview()).isEmpty
        assertThat(tool.webSearch()).isEmpty
    }

    @Test
    fun ofComputerUsePreview() {
        val computerUsePreview =
            ComputerTool.builder()
                .displayHeight(0.0)
                .displayWidth(0.0)
                .environment(ComputerTool.Environment.MAC)
                .build()

        val tool = Tool.ofComputerUsePreview(computerUsePreview)

        assertThat(tool.fileSearch()).isEmpty
        assertThat(tool.function()).isEmpty
        assertThat(tool.computerUsePreview()).contains(computerUsePreview)
        assertThat(tool.webSearch()).isEmpty
    }

    @Test
    fun ofWebSearch() {
        val webSearch = WebSearchTool.builder().type(WebSearchTool.Type.WEB_SEARCH_PREVIEW).build()

        val tool = Tool.ofWebSearch(webSearch)

        assertThat(tool.fileSearch()).isEmpty
        assertThat(tool.function()).isEmpty
        assertThat(tool.computerUsePreview()).isEmpty
        assertThat(tool.webSearch()).contains(webSearch)
    }
}
