package com.openai.helpers.beta.agents

import com.openai.client.OpenAIClientImpl
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.*
import java.io.ByteArrayInputStream
import java.io.InputStream
import java.time.Duration
import java.util.concurrent.CompletableFuture

internal val fileTestOptions =
    RequestOptions.builder().timeout(Duration.ofSeconds(9)).responseValidation(false).build()

internal abstract class AgentFileTestTransport : HttpClient {
    val requests = mutableListOf<HttpRequest>()
    val requestOptions = mutableListOf<RequestOptions>()
    var asyncOverride: ((HttpRequest, RequestOptions) -> CompletableFuture<HttpResponse>?)? = null

    protected fun response(text: String, status: Int = 200): HttpResponse =
        response(ByteArrayInputStream(text.toByteArray()), status)

    protected fun response(input: InputStream, status: Int = 200): HttpResponse =
        object : HttpResponse {
            override fun statusCode() = status

            override fun headers() =
                Headers.builder().put("Content-Type", "application/json").build()

            override fun body() = input

            override fun close() = input.close()
        }

    protected abstract fun respond(request: HttpRequest): HttpResponse

    override fun execute(request: HttpRequest, requestOptions: RequestOptions): HttpResponse {
        requests.add(request)
        this.requestOptions.add(requestOptions)
        return respond(request)
    }

    override fun executeAsync(
        request: HttpRequest,
        requestOptions: RequestOptions,
    ): CompletableFuture<HttpResponse> =
        try {
            asyncOverride?.invoke(request, requestOptions)
                ?: CompletableFuture.completedFuture(execute(request, requestOptions))
        } catch (error: Throwable) {
            CompletableFuture<HttpResponse>().apply { completeExceptionally(error) }
        }

    override fun close() {}

    fun client() =
        OpenAIClientImpl(
            ClientOptions.builder().httpClient(this).apiKey("synthetic").maxRetries(0).build()
        )
}

internal fun <T> withClient(t: AgentFileTestTransport, block: (OpenAIClientImpl) -> T): T {
    val client = t.client()
    return try {
        block(client)
    } finally {
        client.close()
    }
}
