// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live.sessions

import com.openai.core.JsonValue
import com.openai.models.live.ClientConfig
import com.openai.models.live.DataChannelConfig
import com.openai.models.live.FunctionTool
import com.openai.models.live.MediaSessionForkConfig
import com.openai.models.live.ResponsesDelegationUpdateConfig
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SessionForkParamsTest {

    @Test
    fun create() {
        SessionForkParams.builder()
            .sessionId("session_id")
            .transport(SessionForkParams.Transport.builder().sdp("x").build())
            .session(
                MediaSessionForkConfig.builder()
                    .client(
                        ClientConfig.builder()
                            .dataChannel(
                                DataChannelConfig.builder()
                                    .allowedClientEventsOfStrings(listOf("string"))
                                    .allowedServerEventsAll()
                                    .build()
                            )
                            .build()
                    )
                    .delegation(
                        MediaSessionForkConfig.Delegation.builder()
                            .responses(
                                ResponsesDelegationUpdateConfig.builder()
                                    .instructions("instructions")
                                    .maxOutputTokens(16L)
                                    .model("model")
                                    .parallelToolCalls(true)
                                    .reasoning(
                                        ResponsesDelegationUpdateConfig.Reasoning.builder()
                                            .effort(
                                                ResponsesDelegationUpdateConfig.Reasoning.Effort
                                                    .NONE
                                            )
                                            .summary(
                                                ResponsesDelegationUpdateConfig.Reasoning.Summary
                                                    .CONCISE
                                            )
                                            .build()
                                    )
                                    .serviceTier(ResponsesDelegationUpdateConfig.ServiceTier.AUTO)
                                    .text(
                                        ResponsesDelegationUpdateConfig.Text.builder()
                                            .verbosity(
                                                ResponsesDelegationUpdateConfig.Text.Verbosity.LOW
                                            )
                                            .build()
                                    )
                                    .toolChoice(
                                        ResponsesDelegationUpdateConfig.ToolChoice
                                            .LiveToolChoiceEnum
                                            .AUTO
                                    )
                                    .addTool(
                                        FunctionTool.builder()
                                            .name("name")
                                            .description("description")
                                            .parameters(
                                                FunctionTool.Parameters.builder()
                                                    .putAdditionalProperty(
                                                        "foo",
                                                        JsonValue.from("bar"),
                                                    )
                                                    .build()
                                            )
                                            .strict(true)
                                            .build()
                                    )
                                    .build()
                            )
                            .build()
                    )
                    .store(true)
                    .build()
            )
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            SessionForkParams.builder()
                .sessionId("session_id")
                .transport(SessionForkParams.Transport.builder().sdp("x").build())
                .build()

        assertThat(params._pathParam(0)).isEqualTo("session_id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            SessionForkParams.builder()
                .sessionId("session_id")
                .transport(SessionForkParams.Transport.builder().sdp("x").build())
                .session(
                    MediaSessionForkConfig.builder()
                        .client(
                            ClientConfig.builder()
                                .dataChannel(
                                    DataChannelConfig.builder()
                                        .allowedClientEventsOfStrings(listOf("string"))
                                        .allowedServerEventsAll()
                                        .build()
                                )
                                .build()
                        )
                        .delegation(
                            MediaSessionForkConfig.Delegation.builder()
                                .responses(
                                    ResponsesDelegationUpdateConfig.builder()
                                        .instructions("instructions")
                                        .maxOutputTokens(16L)
                                        .model("model")
                                        .parallelToolCalls(true)
                                        .reasoning(
                                            ResponsesDelegationUpdateConfig.Reasoning.builder()
                                                .effort(
                                                    ResponsesDelegationUpdateConfig.Reasoning.Effort
                                                        .NONE
                                                )
                                                .summary(
                                                    ResponsesDelegationUpdateConfig.Reasoning
                                                        .Summary
                                                        .CONCISE
                                                )
                                                .build()
                                        )
                                        .serviceTier(
                                            ResponsesDelegationUpdateConfig.ServiceTier.AUTO
                                        )
                                        .text(
                                            ResponsesDelegationUpdateConfig.Text.builder()
                                                .verbosity(
                                                    ResponsesDelegationUpdateConfig.Text.Verbosity
                                                        .LOW
                                                )
                                                .build()
                                        )
                                        .toolChoice(
                                            ResponsesDelegationUpdateConfig.ToolChoice
                                                .LiveToolChoiceEnum
                                                .AUTO
                                        )
                                        .addTool(
                                            FunctionTool.builder()
                                                .name("name")
                                                .description("description")
                                                .parameters(
                                                    FunctionTool.Parameters.builder()
                                                        .putAdditionalProperty(
                                                            "foo",
                                                            JsonValue.from("bar"),
                                                        )
                                                        .build()
                                                )
                                                .strict(true)
                                                .build()
                                        )
                                        .build()
                                )
                                .build()
                        )
                        .store(true)
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body.transport())
            .isEqualTo(SessionForkParams.Transport.builder().sdp("x").build())
        assertThat(body.session())
            .contains(
                MediaSessionForkConfig.builder()
                    .client(
                        ClientConfig.builder()
                            .dataChannel(
                                DataChannelConfig.builder()
                                    .allowedClientEventsOfStrings(listOf("string"))
                                    .allowedServerEventsAll()
                                    .build()
                            )
                            .build()
                    )
                    .delegation(
                        MediaSessionForkConfig.Delegation.builder()
                            .responses(
                                ResponsesDelegationUpdateConfig.builder()
                                    .instructions("instructions")
                                    .maxOutputTokens(16L)
                                    .model("model")
                                    .parallelToolCalls(true)
                                    .reasoning(
                                        ResponsesDelegationUpdateConfig.Reasoning.builder()
                                            .effort(
                                                ResponsesDelegationUpdateConfig.Reasoning.Effort
                                                    .NONE
                                            )
                                            .summary(
                                                ResponsesDelegationUpdateConfig.Reasoning.Summary
                                                    .CONCISE
                                            )
                                            .build()
                                    )
                                    .serviceTier(ResponsesDelegationUpdateConfig.ServiceTier.AUTO)
                                    .text(
                                        ResponsesDelegationUpdateConfig.Text.builder()
                                            .verbosity(
                                                ResponsesDelegationUpdateConfig.Text.Verbosity.LOW
                                            )
                                            .build()
                                    )
                                    .toolChoice(
                                        ResponsesDelegationUpdateConfig.ToolChoice
                                            .LiveToolChoiceEnum
                                            .AUTO
                                    )
                                    .addTool(
                                        FunctionTool.builder()
                                            .name("name")
                                            .description("description")
                                            .parameters(
                                                FunctionTool.Parameters.builder()
                                                    .putAdditionalProperty(
                                                        "foo",
                                                        JsonValue.from("bar"),
                                                    )
                                                    .build()
                                            )
                                            .strict(true)
                                            .build()
                                    )
                                    .build()
                            )
                            .build()
                    )
                    .store(true)
                    .build()
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            SessionForkParams.builder()
                .sessionId("session_id")
                .transport(SessionForkParams.Transport.builder().sdp("x").build())
                .build()

        val body = params._body()

        assertThat(body.transport())
            .isEqualTo(SessionForkParams.Transport.builder().sdp("x").build())
    }
}
