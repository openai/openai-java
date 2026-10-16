package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseFunctionWebSearchStatusTest {
    @Test
    fun deserializeIncompleteStatus() {
        val betaResponseFunctionWebSearch =
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
                    jacksonTypeRef<BetaResponseFunctionWebSearch>(),
                )

        betaResponseFunctionWebSearch.validate()
        assertThat(betaResponseFunctionWebSearch.status().value())
            .isEqualTo(BetaResponseFunctionWebSearch.Status.Value.INCOMPLETE)
        assertThat(betaResponseFunctionWebSearch.status().known())
            .isEqualTo(BetaResponseFunctionWebSearch.Status.Known.INCOMPLETE)
    }
}
