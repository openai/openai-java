// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.beta

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
import com.openai.core.prepare
import com.openai.models.beta.chatkit.ChatKitUploadFileParams
import com.openai.models.beta.chatkit.ChatKitUploadFileResponse
import com.openai.services.blocking.beta.chatkit.SessionService
import com.openai.services.blocking.beta.chatkit.SessionServiceImpl
import com.openai.services.blocking.beta.chatkit.ThreadService
import com.openai.services.blocking.beta.chatkit.ThreadServiceImpl
import java.util.function.Consumer

class ChatKitServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    ChatKitService {

    companion object {

        private val DEFAULT_HEADERS =
            Headers.builder().put("OpenAI-Beta", "chatkit_beta=v1").build()
    }

    private val withRawResponse: ChatKitService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val sessions: SessionService by lazy { SessionServiceImpl(clientOptions) }

    private val threads: ThreadService by lazy { ThreadServiceImpl(clientOptions) }

    override fun withRawResponse(): ChatKitService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): ChatKitService =
        ChatKitServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun sessions(): SessionService = sessions

    override fun threads(): ThreadService = threads

    override fun uploadFile(
        params: ChatKitUploadFileParams,
        requestOptions: RequestOptions,
    ): ChatKitUploadFileResponse =
        // post /chatkit/files
        withRawResponse().uploadFile(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ChatKitService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        private val sessions: SessionService.WithRawResponse by lazy {
            SessionServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val threads: ThreadService.WithRawResponse by lazy {
            ThreadServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ChatKitService.WithRawResponse =
            ChatKitServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun sessions(): SessionService.WithRawResponse = sessions

        override fun threads(): ThreadService.WithRawResponse = threads

        private val uploadFileHandler: Handler<ChatKitUploadFileResponse> =
            jsonHandler<ChatKitUploadFileResponse>(clientOptions.jsonMapper)

        override fun uploadFile(
            params: ChatKitUploadFileParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ChatKitUploadFileResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("chatkit", "files")
                    .putAllHeaders(DEFAULT_HEADERS)
                    .body(multipartFormData(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
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
