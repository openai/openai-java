package com.openai.client.okhttp

import com.openai.core.RequestOptions
import com.openai.core.checkRequired
import com.openai.core.http.Headers
import com.openai.core.http.HttpClient
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpRequestBody
import com.openai.core.http.HttpResponse
import com.openai.errors.OpenAIIoException
import java.io.IOException
import java.io.InputStream
import java.net.Proxy
import java.time.Duration
import java.util.concurrent.CompletableFuture
import okhttp3.Call
import okhttp3.Callback
import okhttp3.HttpUrl
import okhttp3.HttpUrl.Companion.toHttpUrl
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import okio.BufferedSink

class OkHttpClient
private constructor(private val okHttpClient: okhttp3.OkHttpClient, private val baseUrl: HttpUrl) :
    HttpClient {

    override fun execute(request: HttpRequest, requestOptions: RequestOptions): HttpResponse {
        val call = newCall(request, requestOptions)

        return try {
            call.execute().toResponse()
        } catch (e: IOException) {
            throw OpenAIIoException("Request failed", e)
        } finally {
            request.body?.close()
        }
    }

    override fun executeAsync(
        request: HttpRequest,
        requestOptions: RequestOptions,
    ): CompletableFuture<HttpResponse> {
        val future = CompletableFuture<HttpResponse>()

        request.body?.run { future.whenComplete { _, _ -> close() } }

        newCall(request, requestOptions)
            .enqueue(
                object : Callback {
                    override fun onResponse(call: Call, response: Response) {
                        future.complete(response.toResponse())
                    }

                    override fun onFailure(call: Call, e: IOException) {
                        future.completeExceptionally(OpenAIIoException("Request failed", e))
                    }
                }
            )

        return future
    }

    override fun close() {
        okHttpClient.dispatcher.executorService.shutdown()
        okHttpClient.connectionPool.evictAll()
        okHttpClient.cache?.close()
    }

    private fun newCall(request: HttpRequest, requestOptions: RequestOptions): Call {
        val clientBuilder = okHttpClient.newBuilder()

        val logLevel =
            when (System.getenv("OPENAI_LOG")?.lowercase()) {
                "info" -> HttpLoggingInterceptor.Level.BASIC
                "debug" -> HttpLoggingInterceptor.Level.BODY
                else -> null
            }
        if (logLevel != null) {
            clientBuilder.addNetworkInterceptor(
                HttpLoggingInterceptor().setLevel(logLevel).apply { redactHeader("Authorization") }
            )
        }

        val timeout = requestOptions.timeout
        if (timeout != null) {
            clientBuilder
                .connectTimeout(timeout)
                .readTimeout(timeout)
                .writeTimeout(timeout)
                .callTimeout(if (timeout.seconds == 0L) timeout else timeout.plusSeconds(30))
        }

        val client = clientBuilder.build()
        return client.newCall(request.toRequest(client))
    }

    private fun HttpRequest.toRequest(client: okhttp3.OkHttpClient): Request {
        var body: RequestBody? = body?.toRequestBody()
        if (body == null && requiresBody(method)) {
            body = "".toRequestBody()
        }

        val builder = Request.Builder().url(toUrl()).method(method.name, body)
        headers.names().forEach { name ->
            headers.values(name).forEach { builder.header(name, it) }
        }

        if (
            !headers.names().contains("X-Stainless-Read-Timeout") && client.readTimeoutMillis != 0
        ) {
            builder.header(
                "X-Stainless-Read-Timeout",
                Duration.ofMillis(client.readTimeoutMillis.toLong()).seconds.toString(),
            )
        }
        if (!headers.names().contains("X-Stainless-Timeout") && client.callTimeoutMillis != 0) {
            builder.header(
                "X-Stainless-Timeout",
                Duration.ofMillis(client.callTimeoutMillis.toLong()).seconds.toString(),
            )
        }

        return builder.build()
    }

    /** `OkHttpClient` always requires a request body for some methods. */
    private fun requiresBody(method: HttpMethod): Boolean =
        when (method) {
            HttpMethod.POST,
            HttpMethod.PUT,
            HttpMethod.PATCH -> true
            else -> false
        }

    private fun HttpRequest.toUrl(): String {
        url?.let {
            return it
        }

        val builder = baseUrl.newBuilder()
        pathSegments.forEach(builder::addPathSegment)
        queryParams.keys().forEach { key ->
            queryParams.values(key).forEach { builder.addQueryParameter(key, it) }
        }

        return builder.toString()
    }

    private fun HttpRequestBody.toRequestBody(): RequestBody {
        val mediaType = contentType()?.toMediaType()
        val length = contentLength()

        return object : RequestBody() {
            override fun contentType(): MediaType? = mediaType

            override fun contentLength(): Long = length

            override fun isOneShot(): Boolean = !repeatable()

            override fun writeTo(sink: BufferedSink) = writeTo(sink.outputStream())
        }
    }

    private fun Response.toResponse(): HttpResponse {
        val headers = headers.toHeaders()

        return object : HttpResponse {
            override fun statusCode(): Int = code

            override fun headers(): Headers = headers

            override fun body(): InputStream = body!!.byteStream()

            override fun close() = body!!.close()
        }
    }

    private fun okhttp3.Headers.toHeaders(): Headers {
        val headersBuilder = Headers.builder()
        forEach { (name, value) -> headersBuilder.put(name, value) }
        return headersBuilder.build()
    }

    companion object {
        @JvmStatic fun builder() = Builder()
    }

    class Builder internal constructor() {

        private var baseUrl: HttpUrl? = null
        // The default timeout is 10 minutes.
        private var timeout: Duration = Duration.ofSeconds(600)
        private var proxy: Proxy? = null

        fun baseUrl(baseUrl: String) = apply { this.baseUrl = baseUrl.toHttpUrl() }

        fun timeout(timeout: Duration) = apply { this.timeout = timeout }

        fun proxy(proxy: Proxy?) = apply { this.proxy = proxy }

        fun build(): OkHttpClient =
            OkHttpClient(
                okhttp3.OkHttpClient.Builder()
                    .connectTimeout(timeout)
                    .readTimeout(timeout)
                    .writeTimeout(timeout)
                    .callTimeout(if (timeout.seconds == 0L) timeout else timeout.plusSeconds(30))
                    .proxy(proxy)
                    .build(),
                checkRequired("baseUrl", baseUrl),
            )
    }
}
