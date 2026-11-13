package com.openai.client.okhttp

import com.fasterxml.jackson.core.type.TypeReference
import com.openai.core.jsonMapper
import com.openai.models.finetuning.alpha.graders.GraderRunParams
import com.openai.models.finetuning.alpha.graders.GraderValidateParams
import com.openai.models.graders.gradermodels.MultiGrader
import com.openai.models.graders.gradermodels.PythonGrader
import java.util.concurrent.TimeUnit
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MultiGraderContractTest {

    @Test
    fun builderSnapshotsNamedGraders() {
        val script =
            MultiGrader.Graders.ofPythonGrader(
                PythonGrader.builder().name("script").source("return 1").build()
            )
        val entries = mutableMapOf("first" to script)
        val builder =
            MultiGrader.builder().name("combined").calculateOutput("first").graders(entries)
        entries.clear()
        val first = builder.build()
        val second = builder.putGrader("second", script).build()
        val third = first.toBuilder().putGrader("third", script).build()

        assertThat(first.validate()).isSameAs(first)
        assertThat(first.gradersOrThrow()).containsOnlyKeys("first")
        assertThat(second.gradersOrThrow()).containsOnlyKeys("first", "second")
        assertThat(third.gradersOrThrow()).containsOnlyKeys("first", "third")
    }

    @Test
    fun validatesNamedGradersAndPreservesTheirValues() {
        val mapper = jsonMapper()
        val expected =
            mapper.readTree(
                """
                {
                  "grader": {
                    "type": "multi", "name": "combined", "calculate_output": "exact",
                    "graders": {
                      "exact": {"type":"string_check","name":"match","input":"A","reference":"A","operation":"eq"},
                      "sim / λ": {"type":"text_similarity","name":"similar","input":"B","reference":"B","evaluation_metric":"fuzzy_match"},
                      "python": {"type":"python","name":"script","source":"def grade(sample, item): return 1","extra":{"tags":["first"]}},
                      "score.v2": {"type":"score_model","name":"rate","model":"model","input":[]},
                      "label": {"type":"label_model","name":"classify","model":"model","input":[],"labels":["yes"],"passing_labels":["yes"]},
                      "future": {"type":"future_kind","metadata":{"enabled":true}}
                    }
                  }
                }
                """
                    .trimIndent()
            )
        val entries =
            mapper.convertValue(
                expected["grader"]["graders"],
                object : TypeReference<Map<String, MultiGrader.Graders>>() {},
            )
        val grader =
            MultiGrader.builder().name("combined").calculateOutput("exact").graders(entries).build()

        MockWebServer().use { server ->
            server.enqueue(
                MockResponse()
                    .setHeader("Content-Type", "application/json")
                    .setBody(expected.toString())
            )
            val client =
                OpenAIOkHttpClient.builder()
                    .apiKey("test-key")
                    .baseUrl(server.url("/v1/").toString())
                    .maxRetries(0)
                    .build()
            try {
                val response =
                    client
                        .fineTuning()
                        .alpha()
                        .graders()
                        .validate(GraderValidateParams.builder().grader(grader).build())
                val request = requireNotNull(server.takeRequest(1, TimeUnit.SECONDS))
                assertThat(request.method).isEqualTo("POST")
                assertThat(request.path).isEqualTo("/v1/fine_tuning/alpha/graders/validate")
                assertThat(mapper.readTree(request.body.readUtf8())).isEqualTo(expected)
                val returned = response.graderOrThrow().asMulti()
                val decoded = returned.gradersOrThrow()
                assertThat(decoded).isEqualTo(entries)
                assertThat(decoded.getValue("exact").isStringCheckGrader()).isTrue()
                assertThat(decoded.getValue("sim / λ").isTextSimilarityGrader()).isTrue()
                assertThat(decoded.getValue("python").isPythonGrader()).isTrue()
                assertThat(decoded.getValue("score.v2").isScoreModelGrader()).isTrue()
                assertThat(decoded.getValue("label").isLabelModelGrader()).isTrue()
                assertThat(decoded.getValue("future")._json()).isPresent()

                server.enqueue(
                    MockResponse().setHeader("Content-Type", "application/json").setBody("{}")
                )
                client
                    .fineTuning()
                    .alpha()
                    .graders()
                    .run(GraderRunParams.builder().grader(returned).modelSample("A").build())
                val run = requireNotNull(server.takeRequest(1, TimeUnit.SECONDS))
                assertThat(run.path).isEqualTo("/v1/fine_tuning/alpha/graders/run")
                assertThat(mapper.readTree(run.body.readUtf8())["grader"])
                    .isEqualTo(expected["grader"])
            } finally {
                client.close()
            }
        }
    }
}
