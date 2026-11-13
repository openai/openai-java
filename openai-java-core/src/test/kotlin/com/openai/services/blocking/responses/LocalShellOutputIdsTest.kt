package com.openai.services.blocking.responses

import com.github.tomakehurst.wiremock.client.WireMock.equalToJson
import com.github.tomakehurst.wiremock.client.WireMock.get
import com.github.tomakehurst.wiremock.client.WireMock.okJson
import com.github.tomakehurst.wiremock.client.WireMock.post
import com.github.tomakehurst.wiremock.client.WireMock.postRequestedFor
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo
import com.github.tomakehurst.wiremock.client.WireMock.verify
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.responses.ResponseCreateParams
import com.openai.models.responses.ResponseInputItem
import com.openai.models.responses.ResponseItem
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.parallel.ResourceLock

@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class LocalShellOutputIdsTest {
    private val mapper = jsonMapper()

    @Test
    fun retrieveAndReplay(wireMock: WireMockRuntimeInfo) {
        val payload =
            """{"type":"local_shell_call_output","id":"out_1","call_id":"call_7","output":"ok","status":"completed","extra":17}"""
        stubFor(
            get("/responses/resp_1/input_items")
                .willReturn(
                    okJson(
                        """{"data":[$payload,{"type":"mcp_approval_response","id":"approval_2","approval_request_id":"req_3","approve":true}],"has_more":false}"""
                    )
                )
        )
        val client =
            OpenAIOkHttpClient.builder().apiKey("test").baseUrl(wireMock.httpBaseUrl).build()
        try {
            val items = client.responses().inputItems().list("resp_1").items()
            val output = items.first().asLocalShellCallOutput().validate()
            assertThat(output.id()).contains("out_1")
            assertThat(output.callIdOrThrow()).isEqualTo("call_7")
            assertThat(output._id().asString()).contains("out_1")
            assertThat(output._callId().asString()).contains("call_7")
            assertThat(output._allProperties())
                .containsEntry("call_id", JsonValue.from("call_7"))
                .containsEntry("extra", JsonValue.from(17))

            val rebuilt = output.toBuilder().id("out_1").callId("call_7").build()
            val replay = mapper.writeValueAsString(ResponseItem.ofLocalShellCallOutput(rebuilt))
            assertThat(mapper.readTree(replay)).isEqualTo(mapper.readTree(payload))
            assertThat(mapper.readValue(replay, ResponseItem::class.java).asLocalShellCallOutput())
                .isEqualTo(output)
            assertThat(items.last().asMcpApprovalResponse().approvalRequestIdOrThrow())
                .isEqualTo("req_3")

            stubFor(
                post("/responses").willReturn(okJson("""{"id":"resp_2","object":"response"}"""))
            )
            val input = mapper.readValue(replay, ResponseInputItem::class.java)
            client
                .responses()
                .create(
                    ResponseCreateParams.builder()
                        .model("test")
                        .inputOfResponse(listOf(input))
                        .build()
                )
            verify(
                postRequestedFor(urlEqualTo("/responses"))
                    .withRequestBody(equalToJson("""{"model":"test","input":[$payload]}"""))
            )
        } finally {
            client.close()
        }
    }

    @Test
    fun submissionPreservesAnExplicitCallId() {
        val input =
            ResponseInputItem.LocalShellCallOutput.builder()
                .id("out_1")
                .output("ok")
                .putAdditionalProperty("call_id", JsonValue.from("call_7"))
                .build()
        val params =
            ResponseCreateParams.builder()
                .model("test")
                .inputOfResponse(listOf(ResponseInputItem.ofLocalShellCallOutput(input)))
                .build()
        val sent = mapper.readTree(mapper.writeValueAsString(params._body()))["input"][0]
        assertThat(sent["id"].asText()).isEqualTo("out_1")
        assertThat(sent["call_id"].asText()).isEqualTo("call_7")
    }

    @Test
    fun validationIdentifiesInvalidCallId() {
        val invalidValues =
            listOf(
                "" to "`call_id` is not set",
                ""","call_id":null""" to "`call_id` is null",
                ""","call_id":{}""" to "`call_id` is invalid",
            )
        for ((field, diagnostic) in invalidValues) {
            val json = """{"type":"local_shell_call_output","id":"out_1","output":"ok"$field}"""
            val item = mapper.readValue(json, ResponseItem::class.java).asLocalShellCallOutput()
            assertThat(item.idOrThrow()).isEqualTo("out_1")
            assertThatThrownBy { item.validate() }
                .isInstanceOf(OpenAIInvalidDataException::class.java)
                .hasMessageContaining(diagnostic)
        }
    }
}
