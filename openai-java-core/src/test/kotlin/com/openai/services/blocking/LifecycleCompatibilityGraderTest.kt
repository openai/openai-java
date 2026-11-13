package com.openai.services.blocking

import com.github.tomakehurst.wiremock.client.WireMock.okJson
import com.github.tomakehurst.wiremock.client.WireMock.post
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.finetuning.alpha.graders.GraderRunParams
import com.openai.models.finetuning.alpha.graders.GraderRunResponse
import com.openai.models.graders.gradermodels.StringCheckGrader
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.parallel.ResourceLock

@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class LifecycleCompatibilityGraderTest {
    private fun result(usage: String) =
        """{
            "reward":1.0, "sub_rewards":{}, "model_grader_token_usage_per_model":{},
            "metadata":{
                "name":"test","type":"string_check","scores":{},"sampled_model_name":null,
                "execution_time":0.1,"token_usage":$usage,
                "errors":{
                    "formula_parse_error":false,"sample_parse_error":false,
                    "truncated_observation_error":false,"unresponsive_reward_error":false,
                    "invalid_variable_error":false,"other_error":false,
                    "python_grader_server_error":false,"python_grader_server_error_type":null,
                    "python_grader_runtime_error":false,"python_grader_runtime_error_details":null,
                    "model_grader_server_error":false,"model_grader_refusal_error":false,
                    "model_grader_parse_error":false,"model_grader_server_error_details":null
                }
            }
        }"""

    @Test
    fun runReturnsTypedTokenCounts(server: WireMockRuntimeInfo) {
        val json =
            result(
                """{"prompt_tokens":5,"total_tokens":7,"completion_tokens":2,"cached_tokens":null}"""
            )
        server.wireMock.register(post("/fine_tuning/alpha/graders/run").willReturn(okJson(json)))
        server.withStrictClient { client ->
            val grader =
                StringCheckGrader.builder()
                    .name("exact match")
                    .input("answer")
                    .operation(StringCheckGrader.Operation.EQ)
                    .reference("answer")
                    .build()
            val params = GraderRunParams.builder().grader(grader).modelSample("answer").build()
            val response = client.fineTuning().alpha().graders().run(params)
            val usage = response.metadataOrThrow().tokenUsage().get()
            assertThat(usage.promptTokensOrThrow()).isEqualTo(5L)
            assertThat(usage.totalTokensOrThrow()).isEqualTo(7L)
            assertThat(usage.completionTokens()).contains(2L)
            assertThat(usage.cachedTokens()).isEmpty
            assertWireJson(response, json)
        }
    }

    @Test
    fun acceptsNullUsage() {
        val json = result("null")
        val response = jsonMapper().readValue(json, GraderRunResponse::class.java).validate()
        assertThat(response.metadataOrThrow().tokenUsage()).isEmpty
        assertThat(response.metadataOrThrow()._tokenUsage().isNull()).isTrue()
        assertWireJson(response, json)
    }

    @Test
    fun historicalIntegerIsRecoverableThroughTheRawAccessor() {
        val json = result("7")
        val response = jsonMapper().readValue(json, GraderRunResponse::class.java)
        assertThat(response.metadataOrThrow()._tokenUsage().asNumber().get().toLong()).isEqualTo(7L)
        assertThrows<OpenAIInvalidDataException> { response.metadataOrThrow().tokenUsage() }
        assertThrows<OpenAIInvalidDataException> { response.validate() }
        assertWireJson(response, json)
    }

    @Test
    fun validatesRequiredCountsInsideUsage() {
        val json = result("""{"prompt_tokens":5}""")
        val response = jsonMapper().readValue(json, GraderRunResponse::class.java)
        assertThrows<OpenAIInvalidDataException> { response.validate() }
        assertWireJson(response, json)
    }
}
