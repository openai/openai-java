package com.openai.services.blocking

import com.github.tomakehurst.wiremock.client.WireMock.get
import com.github.tomakehurst.wiremock.client.WireMock.okJson
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.evals.runs.RunRetrieveParams
import com.openai.models.evals.runs.RunRetrieveResponse
import com.openai.models.evals.runs.outputitems.OutputItemRetrieveParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.parallel.ResourceLock

@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class LifecycleCompatibilityEvalTest {
    private fun run(status: String, fields: String, passed: Int = 0) =
        """{
            "object":"eval.run", "id":"run_test", "eval_id":"eval_test", "created_at":1,
            "report_url":"https://example.com/report", "status":"$status", "metadata":{},
            "result_counts":{"total":$passed,"errored":0,"failed":0,"passed":$passed},
            "data_source":{"type":"jsonl","source":{"type":"file_id","id":"file_test"}},
            $fields
        }"""

    @Test
    fun retrievesQueuedRunBeforeResultsExist(server: WireMockRuntimeInfo) {
        val json =
            run(
                "queued",
                """"error":null, "model":null, "name":null,
                   "per_model_usage":null, "per_testing_criteria_results":null""",
            )
        server.wireMock.register(get("/evals/eval_test/runs/run_test").willReturn(okJson(json)))
        server.withStrictClient { client ->
            val params = RunRetrieveParams.builder().evalId("eval_test").runId("run_test").build()
            val result = client.evals().runs().retrieve(params)
            assertThat(result.error()).isEmpty
            assertThat(result.model()).isEmpty
            assertThat(result.name()).isEmpty
            assertThat(result.perModelUsage()).isEmpty
            assertThat(result.perTestingCriteriaResults()).isEmpty
            assertWireJson(result, json)
        }
    }

    @Test
    fun partialResultsRemainReadableAfterRunFailure() {
        val json =
            run(
                "failed",
                """"model":"test_model", "name":"grading", "error":{"code":"timeout","message":"Timed out"},
                   "per_model_usage":[{"model_name":"test_model","invocation_count":1,
                       "prompt_tokens":4,"completion_tokens":2,"total_tokens":6,"cached_tokens":0}],
                   "per_testing_criteria_results":[{"testing_criteria":"accuracy","passed":1,"failed":0}]""",
                passed = 1,
            )
        val result = jsonMapper().readValue(json, RunRetrieveResponse::class.java).validate()
        assertThat(result.error().get().codeOrThrow()).isEqualTo("timeout")
        assertThat(result.model()).contains("test_model")
        assertThat(result.name()).contains("grading")
        assertThat(result.perModelUsage().get().single().totalTokensOrThrow()).isEqualTo(6L)
        assertThat(result.perTestingCriteriaResults().get().single().passedOrThrow()).isEqualTo(1L)
        assertWireJson(result, json)
    }

    @Test
    fun malformedUsageRetainsItsRawValue() {
        val json = run("queued", """"per_model_usage":false""")
        val result = jsonMapper().readValue(json, RunRetrieveResponse::class.java)
        assertThat(result._perModelUsage().asBoolean()).contains(false)
        assertThrows<OpenAIInvalidDataException> { result.perModelUsage() }
        assertWireJson(result, json)
    }

    @Test
    fun retrievesSuccessfulAndErroredSamples(server: WireMockRuntimeInfo) {
        val path = "/evals/eval_test/runs/run_test/output_items/item_test"
        fun outputItem(status: String, error: String) =
            """{
                "id":"item_test","object":"eval.run.output_item","run_id":"run_test","eval_id":"eval_test",
                "created_at":1,"status":"$status","results":[],"datasource_item":{},"datasource_item_id":1,
                "sample":{"input":[],"output":[],"finish_reason":"stop","model":"test_model",
                    "temperature":1.0,"top_p":1.0,"seed":0,"max_completion_tokens":16,"error":$error,
                    "usage":{"cached_tokens":0,"completion_tokens":1,"prompt_tokens":2,"total_tokens":3}}
            }"""
        val params =
            OutputItemRetrieveParams.builder()
                .evalId("eval_test")
                .runId("run_test")
                .outputItemId("item_test")
                .build()
        server.withStrictClient { client ->
            val items = client.evals().runs().outputItems()
            val success = outputItem("pass", "null")
            server.wireMock.register(get(path).willReturn(okJson(success)))
            val passed = items.retrieve(params)
            assertThat(passed.sampleOrThrow().error()).isEmpty
            assertWireJson(passed, success)

            val failure = outputItem("error", """{"code":"timeout","message":"Timed out"}""")
            server.wireMock.register(get(path).willReturn(okJson(failure)))
            val failed = items.retrieve(params)
            assertThat(failed.sampleOrThrow().error().get().messageOrThrow()).isEqualTo("Timed out")
            assertWireJson(failed, failure)
        }
    }
}
