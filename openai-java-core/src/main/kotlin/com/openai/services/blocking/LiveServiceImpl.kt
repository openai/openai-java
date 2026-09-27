// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.blocking

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.SecurityOptions
import com.openai.core.handlers.errorBodyHandler
import com.openai.core.handlers.errorHandler
import com.openai.core.handlers.jsonHandler
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse
import com.openai.core.http.HttpResponse.Handler
import com.openai.core.http.HttpResponseFor
import com.openai.core.http.json
import com.openai.core.http.parseable
import com.openai.core.prepare
import com.openai.models.live.LiveCreateParams
import com.openai.models.live.LiveCreateResponse
import com.openai.services.blocking.live.ForkService
import com.openai.services.blocking.live.ForkServiceImpl
import com.openai.services.blocking.live.SessionService
import com.openai.services.blocking.live.SessionServiceImpl
import com.openai.services.blocking.live.SidebandService
import com.openai.services.blocking.live.SidebandServiceImpl
import java.util.function.Consumer

class LiveServiceImpl internal constructor(private val clientOptions: ClientOptions) : LiveService {

    private val withRawResponse: LiveService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val sideband: SidebandService by lazy { SidebandServiceImpl(clientOptions) }

    private val forks: ForkService by lazy { ForkServiceImpl(clientOptions) }

    private val sessions: SessionService by lazy { SessionServiceImpl(clientOptions) }

    override fun withRawResponse(): LiveService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): LiveService =
        LiveServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun sideband(): SidebandService = sideband

    override fun forks(): ForkService = forks

    override fun sessions(): SessionService = sessions

    override fun create(
        params: LiveCreateParams,
        requestOptions: RequestOptions,
    ): LiveCreateResponse =
        // post /live/sessions
        withRawResponse().create(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        LiveService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        private val sideband: SidebandService.WithRawResponse by lazy {
            SidebandServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val forks: ForkService.WithRawResponse by lazy {
            ForkServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val sessions: SessionService.WithRawResponse by lazy {
            SessionServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): LiveService.WithRawResponse =
            LiveServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun sideband(): SidebandService.WithRawResponse = sideband

        override fun forks(): ForkService.WithRawResponse = forks

        override fun sessions(): SessionService.WithRawResponse = sessions

        private val createHandler: Handler<LiveCreateResponse> =
            jsonHandler<LiveCreateResponse>(clientOptions.jsonMapper)

        override fun create(
            params: LiveCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<LiveCreateResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("live", "sessions")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(
                        clientOptions,
                        params,
                        SecurityOptions.builder().bearerAuth(true).build(),
                    )
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { createHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
