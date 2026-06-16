// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.admin.organization

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
import com.openai.models.admin.organization.spendalerts.OrganizationSpendAlert
import com.openai.models.admin.organization.spendalerts.OrganizationSpendAlertDeleted
import com.openai.models.admin.organization.spendalerts.SpendAlertCreateParams
import com.openai.models.admin.organization.spendalerts.SpendAlertDeleteParams
import com.openai.models.admin.organization.spendalerts.SpendAlertListPage
import com.openai.models.admin.organization.spendalerts.SpendAlertListPageResponse
import com.openai.models.admin.organization.spendalerts.SpendAlertListParams
import com.openai.models.admin.organization.spendalerts.SpendAlertRetrieveParams
import com.openai.models.admin.organization.spendalerts.SpendAlertUpdateParams
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class SpendAlertServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    SpendAlertService {

    private val withRawResponse: SpendAlertService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): SpendAlertService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): SpendAlertService =
        SpendAlertServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun create(
        params: SpendAlertCreateParams,
        requestOptions: RequestOptions,
    ): OrganizationSpendAlert =
        // post /organization/spend_alerts
        withRawResponse().create(params, requestOptions).parse()

    override fun retrieve(
        params: SpendAlertRetrieveParams,
        requestOptions: RequestOptions,
    ): OrganizationSpendAlert =
        // get /organization/spend_alerts/{alert_id}
        withRawResponse().retrieve(params, requestOptions).parse()

    override fun update(
        params: SpendAlertUpdateParams,
        requestOptions: RequestOptions,
    ): OrganizationSpendAlert =
        // post /organization/spend_alerts/{alert_id}
        withRawResponse().update(params, requestOptions).parse()

    override fun list(
        params: SpendAlertListParams,
        requestOptions: RequestOptions,
    ): SpendAlertListPage =
        // get /organization/spend_alerts
        withRawResponse().list(params, requestOptions).parse()

    override fun delete(
        params: SpendAlertDeleteParams,
        requestOptions: RequestOptions,
    ): OrganizationSpendAlertDeleted =
        // delete /organization/spend_alerts/{alert_id}
        withRawResponse().delete(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        SpendAlertService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): SpendAlertService.WithRawResponse =
            SpendAlertServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val createHandler: Handler<OrganizationSpendAlert> =
            jsonHandler<OrganizationSpendAlert>(clientOptions.jsonMapper)

        override fun create(
            params: SpendAlertCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<OrganizationSpendAlert> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("organization", "spend_alerts")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(
                        clientOptions,
                        params,
                        SecurityOptions.builder().adminApiKeyAuth(true).build(),
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

        private val retrieveHandler: Handler<OrganizationSpendAlert> =
            jsonHandler<OrganizationSpendAlert>(clientOptions.jsonMapper)

        override fun retrieve(
            params: SpendAlertRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<OrganizationSpendAlert> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("alertId", params.alertId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("organization", "spend_alerts", params._pathParam(0))
                    .build()
                    .prepare(
                        clientOptions,
                        params,
                        SecurityOptions.builder().adminApiKeyAuth(true).build(),
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

        private val updateHandler: Handler<OrganizationSpendAlert> =
            jsonHandler<OrganizationSpendAlert>(clientOptions.jsonMapper)

        override fun update(
            params: SpendAlertUpdateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<OrganizationSpendAlert> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("alertId", params.alertId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("organization", "spend_alerts", params._pathParam(0))
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(
                        clientOptions,
                        params,
                        SecurityOptions.builder().adminApiKeyAuth(true).build(),
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

        private val listHandler: Handler<SpendAlertListPageResponse> =
            jsonHandler<SpendAlertListPageResponse>(clientOptions.jsonMapper)

        override fun list(
            params: SpendAlertListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<SpendAlertListPage> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("organization", "spend_alerts")
                    .build()
                    .prepare(
                        clientOptions,
                        params,
                        SecurityOptions.builder().adminApiKeyAuth(true).build(),
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
                        SpendAlertListPage.builder()
                            .service(SpendAlertServiceImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }

        private val deleteHandler: Handler<OrganizationSpendAlertDeleted> =
            jsonHandler<OrganizationSpendAlertDeleted>(clientOptions.jsonMapper)

        override fun delete(
            params: SpendAlertDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<OrganizationSpendAlertDeleted> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("alertId", params.alertId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("organization", "spend_alerts", params._pathParam(0))
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepare(
                        clientOptions,
                        params,
                        SecurityOptions.builder().adminApiKeyAuth(true).build(),
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
    }
}
