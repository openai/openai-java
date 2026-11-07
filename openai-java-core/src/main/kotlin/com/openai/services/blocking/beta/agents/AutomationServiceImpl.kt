// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.blocking.beta.agents

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
import com.openai.models.beta.agents.automations.Automation
import com.openai.models.beta.agents.automations.AutomationCreateParams
import com.openai.models.beta.agents.automations.AutomationDeleteParams
import com.openai.models.beta.agents.automations.AutomationDeleted
import com.openai.models.beta.agents.automations.AutomationListPage
import com.openai.models.beta.agents.automations.AutomationListPageResponse
import com.openai.models.beta.agents.automations.AutomationListParams
import com.openai.models.beta.agents.automations.AutomationPauseParams
import com.openai.models.beta.agents.automations.AutomationResumeParams
import com.openai.models.beta.agents.automations.AutomationRetrieveParams
import com.openai.models.beta.agents.automations.AutomationUpdateParams
import com.openai.services.blocking.beta.agents.automations.InvocationService
import com.openai.services.blocking.beta.agents.automations.InvocationServiceImpl
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class AutomationServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    AutomationService {

    companion object {

        private val DEFAULT_HEADERS = Headers.builder().put("OpenAI-Beta", "agents=v1").build()
    }

    private val withRawResponse: AutomationService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val invocations: InvocationService by lazy { InvocationServiceImpl(clientOptions) }

    override fun withRawResponse(): AutomationService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): AutomationService =
        AutomationServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun invocations(): InvocationService = invocations

    override fun create(
        params: AutomationCreateParams,
        requestOptions: RequestOptions,
    ): Automation =
        // post /agents/automations
        withRawResponse().create(params, requestOptions).parse()

    override fun retrieve(
        params: AutomationRetrieveParams,
        requestOptions: RequestOptions,
    ): Automation =
        // get /agents/automations/{automation_id}
        withRawResponse().retrieve(params, requestOptions).parse()

    override fun update(
        params: AutomationUpdateParams,
        requestOptions: RequestOptions,
    ): Automation =
        // post /agents/automations/{automation_id}
        withRawResponse().update(params, requestOptions).parse()

    override fun list(
        params: AutomationListParams,
        requestOptions: RequestOptions,
    ): AutomationListPage =
        // get /agents/automations
        withRawResponse().list(params, requestOptions).parse()

    override fun delete(
        params: AutomationDeleteParams,
        requestOptions: RequestOptions,
    ): AutomationDeleted =
        // delete /agents/automations/{automation_id}
        withRawResponse().delete(params, requestOptions).parse()

    override fun pause(params: AutomationPauseParams, requestOptions: RequestOptions): Automation =
        // post /agents/automations/{automation_id}/pause
        withRawResponse().pause(params, requestOptions).parse()

    override fun resume(
        params: AutomationResumeParams,
        requestOptions: RequestOptions,
    ): Automation =
        // post /agents/automations/{automation_id}/resume
        withRawResponse().resume(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        AutomationService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        private val invocations: InvocationService.WithRawResponse by lazy {
            InvocationServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): AutomationService.WithRawResponse =
            AutomationServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun invocations(): InvocationService.WithRawResponse = invocations

        private val createHandler: Handler<Automation> =
            jsonHandler<Automation>(clientOptions.jsonMapper)

        override fun create(
            params: AutomationCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Automation> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("agents", "automations")
                    .putAllHeaders(DEFAULT_HEADERS)
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

        private val retrieveHandler: Handler<Automation> =
            jsonHandler<Automation>(clientOptions.jsonMapper)

        override fun retrieve(
            params: AutomationRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Automation> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("automationId", params.automationId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("agents", "automations", params._pathParam(0))
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

        private val updateHandler: Handler<Automation> =
            jsonHandler<Automation>(clientOptions.jsonMapper)

        override fun update(
            params: AutomationUpdateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Automation> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("automationId", params.automationId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("agents", "automations", params._pathParam(0))
                    .putAllHeaders(DEFAULT_HEADERS)
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
                    .use { updateHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val listHandler: Handler<AutomationListPageResponse> =
            jsonHandler<AutomationListPageResponse>(clientOptions.jsonMapper)

        override fun list(
            params: AutomationListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<AutomationListPage> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("agents", "automations")
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
                        AutomationListPage.builder()
                            .service(AutomationServiceImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }

        private val deleteHandler: Handler<AutomationDeleted> =
            jsonHandler<AutomationDeleted>(clientOptions.jsonMapper)

        override fun delete(
            params: AutomationDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<AutomationDeleted> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("automationId", params.automationId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("agents", "automations", params._pathParam(0))
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
                    .use { deleteHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val pauseHandler: Handler<Automation> =
            jsonHandler<Automation>(clientOptions.jsonMapper)

        override fun pause(
            params: AutomationPauseParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Automation> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("automationId", params.automationId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("agents", "automations", params._pathParam(0), "pause")
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
                    .use { pauseHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val resumeHandler: Handler<Automation> =
            jsonHandler<Automation>(clientOptions.jsonMapper)

        override fun resume(
            params: AutomationResumeParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Automation> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("automationId", params.automationId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("agents", "automations", params._pathParam(0), "resume")
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
                    .use { resumeHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
