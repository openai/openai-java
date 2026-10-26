package com.openai.vertex

import com.openai.client.OpenAIClient
import com.openai.client.okhttp.VertexOpenAIOkHttpClient
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIServiceException
import com.openai.models.responses.FunctionTool
import com.openai.models.responses.ResponseCompactParams
import com.openai.models.responses.ResponseCreateParams
import com.openai.models.responses.ResponseInputItem
import com.openai.models.responses.ResponseStatus
import com.openai.models.responses.ToolChoiceOptions
import java.net.URI
import java.time.Instant
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable

/**
 * Authorized-environment acceptance only. No default endpoint, model, or credentials are embedded.
 * Service exceptions and model output are deliberately excluded from test reports.
 */
@EnabledIfEnvironmentVariable(named = "VERTEX_LIVE_TEST", matches = "1")
internal class VertexLiveTest {
    @Test
    fun createCompletes() = acceptance { client, model, evidence ->
        evidence.probe("create-store-false") {
            val response =
                client
                    .responses()
                    .create(
                        ResponseCreateParams.builder()
                            .model(model)
                            .input("Reply briefly with a greeting.")
                            .store(false)
                            .build()
                    )
            check(response.id().isNotBlank())
            check(response.status().orElse(null) == ResponseStatus.COMPLETED)
        }
    }

    @Test
    fun streamingCompletes() = acceptance { client, model, evidence ->
        val params =
            ResponseCreateParams.builder()
                .model(model)
                .input("Reply briefly with a greeting.")
                .store(false)
                .build()
        evidence.probe("stream-complete") {
            var completed = false
            client.responses().createStreaming(params).use { stream ->
                stream.stream().forEach { event ->
                    check(!event.isError()) { "Stream error" }
                    if (event.isCompleted()) completed = true
                }
            }
            check(completed) { "Stream did not complete" }
        }
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "VERTEX_LIVE_STATEFUL", matches = "1")
    fun storeRetrieveFollowupAndDelete() = acceptance { client, model, evidence ->
        var storedResponseId: String? = null
        try {
            val response =
                evidence.probe("store-create") {
                    client
                        .responses()
                        .create(
                            ResponseCreateParams.builder()
                                .model(model)
                                .input("Remember the number 42.")
                                .store(true)
                                .build()
                        )
                        .also {
                            val id = it.id()
                            check(id.isNotBlank())
                            storedResponseId = id
                            check(it.status().orElse(null) == ResponseStatus.COMPLETED)
                        }
                }
            evidence.probe("store-retrieve") {
                check(client.responses().retrieve(response.id()).id() == response.id())
            }
            evidence.probe("previous-response-id") {
                val followup =
                    client
                        .responses()
                        .create(
                            ResponseCreateParams.builder()
                                .model(model)
                                .previousResponseId(response.id())
                                .input("Which number did I give you?")
                                .store(false)
                                .build()
                        )
                check(followup.id().isNotBlank())
                check(followup.status().orElse(null) == ResponseStatus.COMPLETED)
            }
        } finally {
            storedResponseId?.let { id ->
                evidence.probe("store-delete") { client.responses().delete(id) }
            }
        }
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "VERTEX_LIVE_TOOLS", matches = "1")
    fun functionToolsComplete() = acceptance { client, model, evidence ->
        val tool =
            FunctionTool.builder()
                .name("echo_fixture")
                .parameters(
                    FunctionTool.Parameters.builder()
                        .putAdditionalProperty("type", JsonValue.from("object"))
                        .putAdditionalProperty(
                            "properties",
                            JsonValue.from(emptyMap<String, Any>()),
                        )
                        .putAdditionalProperty("required", JsonValue.from(emptyList<String>()))
                        .putAdditionalProperty("additionalProperties", JsonValue.from(false))
                        .build()
                )
                .strict(true)
                .build()
        val first =
            evidence.probe("tools-function-call") {
                client
                    .responses()
                    .create(
                        ResponseCreateParams.builder()
                            .model(model)
                            .input("Call echo_fixture once.")
                            .addTool(tool)
                            .toolChoice(ToolChoiceOptions.REQUIRED)
                            .store(false)
                            .build()
                    )
                    .also {
                        check(it.status().orElse(null) == ResponseStatus.COMPLETED)
                        check(it.output().any { item -> item.isFunctionCall() })
                    }
            }
        val messages = mutableListOf<ResponseInputItem>()
        first.output().forEach { item ->
            messages.add(jsonMapper().convertValue(item, ResponseInputItem::class.java))
            if (item.isFunctionCall()) {
                messages.add(
                    ResponseInputItem.ofFunctionCallOutput(
                        ResponseInputItem.FunctionCallOutput.builder()
                            .callId(item.asFunctionCall().callId())
                            .output("ok")
                            .build()
                    )
                )
            }
        }
        evidence.probe("tools-function-output") {
            val second =
                client
                    .responses()
                    .create(
                        ResponseCreateParams.builder()
                            .model(model)
                            .input(ResponseCreateParams.Input.ofResponse(messages))
                            .store(false)
                            .build()
                    )
            check(second.id().isNotBlank())
            check(second.status().orElse(null) == ResponseStatus.COMPLETED)
            check(second.output().none { it.isFunctionCall() })
        }
    }

    @Test
    fun compaction() = acceptance { client, model, evidence ->
        evidence.probe("compact") {
            val compacted =
                client
                    .responses()
                    .compact(
                        ResponseCompactParams.builder()
                            .model(model)
                            .input("Reply briefly with a greeting.")
                            .build()
                    )
            check(compacted.id().isNotBlank())
            // Parse the actual typed compacted-output envelope, without inspecting or saving
            // its opaque contents.
            compacted.output()
        }
    }

    private fun acceptance(run: (OpenAIClient, String, Evidence) -> Unit) {
        val model = required("VERTEX_LIVE_MODEL")
        val revision = required("VERTEX_LIVE_REVISION")
        require(revision.matches(Regex("[0-9a-f]{40}"))) {
            "VERTEX_LIVE_REVISION must be the full source revision under test."
        }
        val baseUrl = System.getenv("VERTEX_LIVE_BASE_URL")?.trim()?.takeIf { it.isNotEmpty() }
        val project = System.getenv("GOOGLE_CLOUD_PROJECT")
        val location = System.getenv("GOOGLE_CLOUD_LOCATION")
        val label = required("VERTEX_LIVE_ENVIRONMENT")
        val resolved = vertexBaseUrl(baseUrl, project, location)
        // Only sanitized caller-controlled environment/model values and hostname, never URL path,
        // Google project, token, response identifier, or model/customer content.
        val endpoint = URI(resolved).host
        val version =
            VertexOpenAIOkHttpClient::class.java.`package`.implementationVersion ?: "source"
        val client = VertexOpenAIOkHttpClient.builder().baseUrl(resolved).maxRetries(0).build()
        try {
            run(
                client,
                model,
                Evidence(
                    "env=${safe(label)} model=${safe(model)} host=${safe(endpoint)} version=${safe(version)} revision=$revision"
                ),
            )
        } finally {
            client.close()
        }
    }

    private class Evidence(private val metadata: String) {
        fun <T> probe(case: String, run: () -> T): T {
            try {
                return run().also {
                    println(
                        "Vertex acceptance time=${Instant.now()} case=$case result=pass $metadata"
                    )
                }
            } catch (failure: Exception) {
                // Status comes from the SDK's typed exception, never from a body, cause, or
                // message. A 401/403/404/429 is not an unsupported-feature verdict.
                val status = (failure as? OpenAIServiceException)?.statusCode() ?: "-"
                println(
                    "Vertex acceptance time=${Instant.now()} case=$case result=fail $metadata http=$status kind=${failure.javaClass.simpleName}"
                )
                // Service exceptions may contain content; do not retain them as an XML cause.
                throw AssertionError(
                    "Vertex acceptance $case failed (${failure.javaClass.simpleName} http=$status); see sanitized run metadata."
                )
            }
        }
    }

    private fun required(name: String): String =
        System.getenv(name)?.trim()?.takeIf { it.isNotEmpty() }
            ?: error("$name must be configured for live acceptance.")

    private fun safe(value: String): String =
        value.replace(Regex("[^A-Za-z0-9_.:/-]"), "_").take(120)
}
