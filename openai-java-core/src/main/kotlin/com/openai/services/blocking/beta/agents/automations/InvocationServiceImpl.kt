// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.blocking.beta.agents.automations

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.SecurityOptions
import com.openai.core.checkRequired
import com.openai.core.handlers.errorBodyHandler
import com.openai.core.handlers.errorHandler
import com.openai.core.handlers.jsonHandler
import com.openai.core.http.Headers
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse
import com.openai.core.http.HttpResponse.Handler
import com.openai.core.http.HttpResponseFor
import com.openai.core.http.json
import com.openai.core.http.parseable
import com.openai.core.prepare
import com.openai.models.beta.agents.automations.invocations.AutomationInvocation
import com.openai.models.beta.agents.automations.invocations.InvocationCreateParams
import com.openai.models.beta.agents.automations.invocations.InvocationListPage
import com.openai.models.beta.agents.automations.invocations.InvocationListPageResponse
import com.openai.models.beta.agents.automations.invocations.InvocationListParams
import com.openai.models.beta.agents.automations.invocations.InvocationRetrieveParams
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class InvocationServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    InvocationService {

    companion object {

        private val DEFAULT_HEADERS = Headers.builder().put("OpenAI-Beta", "agents=v1").build()
    }

    private val withRawResponse: InvocationService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): InvocationService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): InvocationService =
        InvocationServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun create(
        params: InvocationCreateParams,
        requestOptions: RequestOptions,
    ): AutomationInvocation =
        // post /agents/automations/{automation_id}/invocations
        withRawResponse().create(params, requestOptions).parse()

    override fun retrieve(
        params: InvocationRetrieveParams,
        requestOptions: RequestOptions,
    ): AutomationInvocation =
        // get /agents/automations/{automation_id}/invocations/{invocation_id}
        withRawResponse().retrieve(params, requestOptions).parse()

    override fun list(
        params: InvocationListParams,
        requestOptions: RequestOptions,
    ): InvocationListPage =
        // get /agents/automations/{automation_id}/invocations
        withRawResponse().list(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        InvocationService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): InvocationService.WithRawResponse =
            InvocationServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val createHandler: Handler<AutomationInvocation> =
            jsonHandler<AutomationInvocation>(clientOptions.jsonMapper)

        override fun create(
            params: InvocationCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<AutomationInvocation> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("automationId", params.automationId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("agents", "automations", params._pathParam(0), "invocations")
                    .putAllHeaders(DEFAULT_HEADERS)
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
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

        private val retrieveHandler: Handler<AutomationInvocation> =
            jsonHandler<AutomationInvocation>(clientOptions.jsonMapper)

        override fun retrieve(
            params: InvocationRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<AutomationInvocation> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("invocationId", params.invocationId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "agents",
                        "automations",
                        params._pathParam(0),
                        "invocations",
                        params._pathParam(1),
                    )
                    .putAllHeaders(DEFAULT_HEADERS)
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
                    .use { retrieveHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val listHandler: Handler<InvocationListPageResponse> =
            jsonHandler<InvocationListPageResponse>(clientOptions.jsonMapper)

        override fun list(
            params: InvocationListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<InvocationListPage> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("automationId", params.automationId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("agents", "automations", params._pathParam(0), "invocations")
                    .putAllHeaders(DEFAULT_HEADERS)
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
                    .use { listHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
                    .let {
                        InvocationListPage.builder()
                            .service(InvocationServiceImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }
    }
}
