// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.openai.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BetaThreadMessageCreateParamsTest {

    @Test
    fun createBetaThreadMessageCreateParams() {
        BetaThreadMessageCreateParams.builder()
            .threadId("thread_id")
            .content(BetaThreadMessageCreateParams.Content.ofTextContent("string"))
            .role(BetaThreadMessageCreateParams.Role.USER)
            .attachments(
                listOf(
                    BetaThreadMessageCreateParams.Attachment.builder()
                        .fileId("file_id")
                        .tools(
                            listOf(
                                BetaThreadMessageCreateParams.Attachment.Tool.ofCodeInterpreterTool(
                                    CodeInterpreterTool.builder()
                                        .type(CodeInterpreterTool.Type.CODE_INTERPRETER)
                                        .build()
                                )
                            )
                        )
                        .build()
                )
            )
            .metadata(JsonValue.from(mapOf<String, Any>()))
            .build()
    }

    @Test
    fun getBody() {
        val params =
            BetaThreadMessageCreateParams.builder()
                .threadId("thread_id")
                .content(BetaThreadMessageCreateParams.Content.ofTextContent("string"))
                .role(BetaThreadMessageCreateParams.Role.USER)
                .attachments(
                    listOf(
                        BetaThreadMessageCreateParams.Attachment.builder()
                            .fileId("file_id")
                            .tools(
                                listOf(
                                    BetaThreadMessageCreateParams.Attachment.Tool
                                        .ofCodeInterpreterTool(
                                            CodeInterpreterTool.builder()
                                                .type(CodeInterpreterTool.Type.CODE_INTERPRETER)
                                                .build()
                                        )
                                )
                            )
                            .build()
                    )
                )
                .metadata(JsonValue.from(mapOf<String, Any>()))
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.content())
            .isEqualTo(BetaThreadMessageCreateParams.Content.ofTextContent("string"))
        assertThat(body.role()).isEqualTo(BetaThreadMessageCreateParams.Role.USER)
        assertThat(body.attachments())
            .contains(
                listOf(
                    BetaThreadMessageCreateParams.Attachment.builder()
                        .fileId("file_id")
                        .tools(
                            listOf(
                                BetaThreadMessageCreateParams.Attachment.Tool.ofCodeInterpreterTool(
                                    CodeInterpreterTool.builder()
                                        .type(CodeInterpreterTool.Type.CODE_INTERPRETER)
                                        .build()
                                )
                            )
                        )
                        .build()
                )
            )
        assertThat(body._metadata()).isEqualTo(JsonValue.from(mapOf<String, Any>()))
    }

    @Test
    fun getBodyWithoutOptionalFields() {
        val params =
            BetaThreadMessageCreateParams.builder()
                .threadId("thread_id")
                .content(BetaThreadMessageCreateParams.Content.ofTextContent("string"))
                .role(BetaThreadMessageCreateParams.Role.USER)
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.content())
            .isEqualTo(BetaThreadMessageCreateParams.Content.ofTextContent("string"))
        assertThat(body.role()).isEqualTo(BetaThreadMessageCreateParams.Role.USER)
    }

    @Test
    fun getPathParam() {
        val params =
            BetaThreadMessageCreateParams.builder()
                .threadId("thread_id")
                .content(BetaThreadMessageCreateParams.Content.ofTextContent("string"))
                .role(BetaThreadMessageCreateParams.Role.USER)
                .build()
        assertThat(params).isNotNull
        // path param "threadId"
        assertThat(params.getPathParam(0)).isEqualTo("thread_id")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
