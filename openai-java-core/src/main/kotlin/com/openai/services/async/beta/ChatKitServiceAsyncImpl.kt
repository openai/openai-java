// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.beta

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.handlers.errorBodyHandler
import com.openai.core.handlers.errorHandler
import com.openai.core.handlers.jsonHandler
import com.openai.core.http.Headers
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse
import com.openai.core.http.HttpResponse.Handler
import com.openai.core.http.HttpResponseFor
import com.openai.core.http.multipartFormData
import com.openai.core.http.parseable
import com.openai.core.prepareAsync
import com.openai.models.beta.chatkit.ChatKitUploadFileParams
import com.openai.models.beta.chatkit.ChatKitUploadFileResponse
import com.openai.services.async.beta.chatkit.SessionServiceAsync
import com.openai.services.async.beta.chatkit.SessionServiceAsyncImpl
import com.openai.services.async.beta.chatkit.ThreadServiceAsync
import com.openai.services.async.beta.chatkit.ThreadServiceAsyncImpl
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

class ChatKitServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    ChatKitServiceAsync {

    companion object {

        private val DEFAULT_HEADERS =
            Headers.builder().put("OpenAI-Beta", "chatkit_beta=v1").build()
    }

    private val withRawResponse: ChatKitServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val sessions: SessionServiceAsync by lazy { SessionServiceAsyncImpl(clientOptions) }

    private val threads: ThreadServiceAsync by lazy { ThreadServiceAsyncImpl(clientOptions) }

    override fun withRawResponse(): ChatKitServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): ChatKitServiceAsync =
        ChatKitServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun sessions(): SessionServiceAsync = sessions

    override fun threads(): ThreadServiceAsync = threads

    override fun uploadFile(
        params: ChatKitUploadFileParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<ChatKitUploadFileResponse> =
        // post /chatkit/files
        withRawResponse().uploadFile(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ChatKitServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        private val sessions: SessionServiceAsync.WithRawResponse by lazy {
            SessionServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val threads: ThreadServiceAsync.WithRawResponse by lazy {
            ThreadServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ChatKitServiceAsync.WithRawResponse =
            ChatKitServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun sessions(): SessionServiceAsync.WithRawResponse = sessions

        override fun threads(): ThreadServiceAsync.WithRawResponse = threads

        private val uploadFileHandler: Handler<ChatKitUploadFileResponse> =
            jsonHandler<ChatKitUploadFileResponse>(clientOptions.jsonMapper)

        override fun uploadFile(
            params: ChatKitUploadFileParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ChatKitUploadFileResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("chatkit", "files")
                    .putAllHeaders(DEFAULT_HEADERS)
                    .body(multipartFormData(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { uploadFileHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }
    }
}
