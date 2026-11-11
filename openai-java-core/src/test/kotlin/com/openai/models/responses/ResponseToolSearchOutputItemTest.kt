// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseToolSearchOutputItemTest {

    @Test
    fun createAndRoundtrip() {
        val responseToolSearchOutputItem =
            ResponseToolSearchOutputItem.builder()
                .id("id")
                .callId("call_id")
                .execution(ResponseToolSearchOutputItem.Execution.SERVER)
                .status(ResponseToolSearchOutputItem.Status.IN_PROGRESS)
                .addTool(
                    FunctionTool.builder()
                        .name("name")
                        .parameters(
                            FunctionTool.Parameters.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .strict(true)
                        .addAllowedCaller(FunctionTool.AllowedCaller.DIRECT)
                        .async(true)
                        .deferLoading(true)
                        .description("description")
                        .outputSchema(
                            FunctionTool.OutputSchema.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .build()
                )
                .createdBy("created_by")
                .build()

        assertThat(responseToolSearchOutputItem.id()).contains("id")
        assertThat(responseToolSearchOutputItem.callId()).contains("call_id")
        assertThat(responseToolSearchOutputItem.execution())
            .contains(ResponseToolSearchOutputItem.Execution.SERVER)
        assertThat(responseToolSearchOutputItem.status())
            .contains(ResponseToolSearchOutputItem.Status.IN_PROGRESS)
        assertThat(responseToolSearchOutputItem.tools().getOrNull())
            .containsExactly(
                Tool.ofFunction(
                    FunctionTool.builder()
                        .name("name")
                        .parameters(
                            FunctionTool.Parameters.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .strict(true)
                        .addAllowedCaller(FunctionTool.AllowedCaller.DIRECT)
                        .async(true)
                        .deferLoading(true)
                        .description("description")
                        .outputSchema(
                            FunctionTool.OutputSchema.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .build()
                )
            )
        assertThat(responseToolSearchOutputItem.createdBy()).contains("created_by")

        val jsonMapper = jsonMapper()

        val roundtrippedResponseToolSearchOutputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseToolSearchOutputItem),
                jacksonTypeRef<ResponseToolSearchOutputItem>(),
            )

        assertThat(roundtrippedResponseToolSearchOutputItem).isEqualTo(responseToolSearchOutputItem)
    }
}
