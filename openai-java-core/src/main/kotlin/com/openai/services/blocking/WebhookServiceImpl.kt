// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.blocking

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.SecurityOptions
import com.openai.core.checkRequired
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
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.webhooks.DeletedWebhookEndpoint
import com.openai.models.webhooks.UnwrapWebhookEvent
import com.openai.models.webhooks.WebhookCreateParams
import com.openai.models.webhooks.WebhookDeleteParams
import com.openai.models.webhooks.WebhookEndpoint
import com.openai.models.webhooks.WebhookEndpointList
import com.openai.models.webhooks.WebhookEndpointTestResult
import com.openai.models.webhooks.WebhookEndpointWithSecret
import com.openai.models.webhooks.WebhookListPage
import com.openai.models.webhooks.WebhookListParams
import com.openai.models.webhooks.WebhookRetrieveParams
import com.openai.models.webhooks.WebhookRotateSecretParams
import com.openai.models.webhooks.WebhookTestParams
import com.openai.models.webhooks.WebhookUpdateParams
import com.openai.services.blocking.webhooks.EventTypeService
import com.openai.services.blocking.webhooks.EventTypeServiceImpl
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class WebhookServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    WebhookService {

    private val withRawResponse: WebhookService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val eventTypes: EventTypeService by lazy { EventTypeServiceImpl(clientOptions) }

    override fun withRawResponse(): WebhookService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): WebhookService =
        WebhookServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun unwrap(body: String): UnwrapWebhookEvent =
        try {
            clientOptions.jsonMapper.readValue(body, jacksonTypeRef<UnwrapWebhookEvent>())
        } catch (e: Exception) {
            throw OpenAIInvalidDataException("Error parsing body", e)
        }

    override fun eventTypes(): EventTypeService = eventTypes

    override fun create(
        params: WebhookCreateParams,
        requestOptions: RequestOptions,
    ): WebhookEndpointWithSecret =
        // post /webhook_endpoints
        withRawResponse().create(params, requestOptions).parse()

    override fun retrieve(
        params: WebhookRetrieveParams,
        requestOptions: RequestOptions,
    ): WebhookEndpoint =
        // get /webhook_endpoints/{webhook_endpoint_id}
        withRawResponse().retrieve(params, requestOptions).parse()

    override fun update(
        params: WebhookUpdateParams,
        requestOptions: RequestOptions,
    ): WebhookEndpoint =
        // post /webhook_endpoints/{webhook_endpoint_id}
        withRawResponse().update(params, requestOptions).parse()

    override fun list(params: WebhookListParams, requestOptions: RequestOptions): WebhookListPage =
        // get /webhook_endpoints
        withRawResponse().list(params, requestOptions).parse()

    override fun delete(
        params: WebhookDeleteParams,
        requestOptions: RequestOptions,
    ): DeletedWebhookEndpoint =
        // delete /webhook_endpoints/{webhook_endpoint_id}
        withRawResponse().delete(params, requestOptions).parse()

    override fun rotateSecret(
        params: WebhookRotateSecretParams,
        requestOptions: RequestOptions,
    ): WebhookEndpointWithSecret =
        // post /webhook_endpoints/{webhook_endpoint_id}/rotate_secret
        withRawResponse().rotateSecret(params, requestOptions).parse()

    override fun test(
        params: WebhookTestParams,
        requestOptions: RequestOptions,
    ): WebhookEndpointTestResult =
        // post /webhook_endpoints/{webhook_endpoint_id}/test
        withRawResponse().test(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        WebhookService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        private val eventTypes: EventTypeService.WithRawResponse by lazy {
            EventTypeServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): WebhookService.WithRawResponse =
            WebhookServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun eventTypes(): EventTypeService.WithRawResponse = eventTypes

        private val createHandler: Handler<WebhookEndpointWithSecret> =
            jsonHandler<WebhookEndpointWithSecret>(clientOptions.jsonMapper)

        override fun create(
            params: WebhookCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<WebhookEndpointWithSecret> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("webhook_endpoints")
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

        private val retrieveHandler: Handler<WebhookEndpoint> =
            jsonHandler<WebhookEndpoint>(clientOptions.jsonMapper)

        override fun retrieve(
            params: WebhookRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<WebhookEndpoint> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("webhookEndpointId", params.webhookEndpointId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("webhook_endpoints", params._pathParam(0))
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

        private val updateHandler: Handler<WebhookEndpoint> =
            jsonHandler<WebhookEndpoint>(clientOptions.jsonMapper)

        override fun update(
            params: WebhookUpdateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<WebhookEndpoint> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("webhookEndpointId", params.webhookEndpointId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("webhook_endpoints", params._pathParam(0))
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

        private val listHandler: Handler<WebhookEndpointList> =
            jsonHandler<WebhookEndpointList>(clientOptions.jsonMapper)

        override fun list(
            params: WebhookListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<WebhookListPage> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("webhook_endpoints")
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
                        WebhookListPage.builder()
                            .service(WebhookServiceImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }

        private val deleteHandler: Handler<DeletedWebhookEndpoint> =
            jsonHandler<DeletedWebhookEndpoint>(clientOptions.jsonMapper)

        override fun delete(
            params: WebhookDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<DeletedWebhookEndpoint> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("webhookEndpointId", params.webhookEndpointId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("webhook_endpoints", params._pathParam(0))
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

        private val rotateSecretHandler: Handler<WebhookEndpointWithSecret> =
            jsonHandler<WebhookEndpointWithSecret>(clientOptions.jsonMapper)

        override fun rotateSecret(
            params: WebhookRotateSecretParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<WebhookEndpointWithSecret> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("webhookEndpointId", params.webhookEndpointId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("webhook_endpoints", params._pathParam(0), "rotate_secret")
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
                    .use { rotateSecretHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val testHandler: Handler<WebhookEndpointTestResult> =
            jsonHandler<WebhookEndpointTestResult>(clientOptions.jsonMapper)

        override fun test(
            params: WebhookTestParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<WebhookEndpointTestResult> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("webhookEndpointId", params.webhookEndpointId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("webhook_endpoints", params._pathParam(0), "test")
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
                    .use { testHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
