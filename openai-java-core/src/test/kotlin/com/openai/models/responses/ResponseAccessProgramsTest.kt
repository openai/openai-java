package com.openai.models.responses

import com.openai.core.JsonNull
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseAccessProgramsTest {

    @Test
    fun buildWithoutAccessPrograms() {
        val response =
            Response.builder()
                .id("response-id")
                .createdAt(0.0)
                .error(null)
                .incompleteDetails(null)
                .instructions(null)
                .metadata(null)
                .model("test-model")
                .output(listOf())
                .parallelToolCalls(false)
                .temperature(null)
                .toolChoice(JsonNull.of())
                .tools(listOf())
                .topP(null)
                .build()

        assertThat(response.accessPrograms()).isEmpty()
        assertThat(response._accessPrograms()).isEqualTo(JsonNull.of())
        val json = jsonMapper().readTree(jsonMapper().writeValueAsString(response))
        assertThat(json.has("access_programs")).isTrue()
        assertThat(json.get("access_programs").isNull).isTrue()
    }
}
