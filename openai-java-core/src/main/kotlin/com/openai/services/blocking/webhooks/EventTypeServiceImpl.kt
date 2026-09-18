// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.blocking.webhooks

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
import com.openai.core.http.parseable
import com.openai.core.prepare
import com.openai.models.webhooks.WebhookEventTypeList
import com.openai.models.webhooks.eventtypes.EventTypeListParams
import java.util.function.Consumer

class EventTypeServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    EventTypeService {

    private val withRawResponse: EventTypeService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): EventTypeService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): EventTypeService =
        EventTypeServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun list(
        params: EventTypeListParams,
        requestOptions: RequestOptions,
    ): WebhookEventTypeList =
        // get /webhook_event_types
        withRawResponse().list(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        EventTypeService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): EventTypeService.WithRawResponse =
            EventTypeServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val listHandler: Handler<WebhookEventTypeList> =
            jsonHandler<WebhookEventTypeList>(clientOptions.jsonMapper)

        override fun list(
            params: EventTypeListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<WebhookEventTypeList> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("webhook_event_types")
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
            }
        }
    }
}
