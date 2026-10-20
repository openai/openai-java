package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseFunctionWebSearchStatusTest {
    @Test
    fun deserializeIncompleteStatus() {
        val responseFunctionWebSearch =
            jsonMapper()
                .readValue(
                    """
                    {
                        "id": "ws_incomplete",
                        "type": "web_search_call",
                        "status": "incomplete",
                        "action": {"type": "search", "query": "synthetic query"}
                    }
                    """
                        .trimIndent(),
                    jacksonTypeRef<ResponseFunctionWebSearch>(),
                )

        responseFunctionWebSearch.validate()
        assertThat(responseFunctionWebSearch.status().value())
            .isEqualTo(ResponseFunctionWebSearch.Status.Value.INCOMPLETE)
        assertThat(responseFunctionWebSearch.status().known())
            .isEqualTo(ResponseFunctionWebSearch.Status.Known.INCOMPLETE)
    }
}
