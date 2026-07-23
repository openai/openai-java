// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.admin.organization

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
import com.openai.models.admin.organization.spendlimit.OrganizationSpendLimit
import com.openai.models.admin.organization.spendlimit.OrganizationSpendLimitDeleted
import com.openai.models.admin.organization.spendlimit.SpendLimitDeleteParams
import com.openai.models.admin.organization.spendlimit.SpendLimitRetrieveParams
import com.openai.models.admin.organization.spendlimit.SpendLimitUpdateParams
import java.util.function.Consumer

class SpendLimitServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    SpendLimitService {

    private val withRawResponse: SpendLimitService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): SpendLimitService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): SpendLimitService =
        SpendLimitServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun retrieve(
        params: SpendLimitRetrieveParams,
        requestOptions: RequestOptions,
    ): OrganizationSpendLimit =
        // get /organization/spend_limit
        withRawResponse().retrieve(params, requestOptions).parse()

    override fun update(
        params: SpendLimitUpdateParams,
        requestOptions: RequestOptions,
    ): OrganizationSpendLimit =
        // post /organization/spend_limit
        withRawResponse().update(params, requestOptions).parse()

    override fun delete(
        params: SpendLimitDeleteParams,
        requestOptions: RequestOptions,
    ): OrganizationSpendLimitDeleted =
        // delete /organization/spend_limit
        withRawResponse().delete(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        SpendLimitService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): SpendLimitService.WithRawResponse =
            SpendLimitServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val retrieveHandler: Handler<OrganizationSpendLimit> =
            jsonHandler<OrganizationSpendLimit>(clientOptions.jsonMapper)

        override fun retrieve(
            params: SpendLimitRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<OrganizationSpendLimit> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("organization", "spend_limit")
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

        private val updateHandler: Handler<OrganizationSpendLimit> =
            jsonHandler<OrganizationSpendLimit>(clientOptions.jsonMapper)

        override fun update(
            params: SpendLimitUpdateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<OrganizationSpendLimit> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("organization", "spend_limit")
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

        private val deleteHandler: Handler<OrganizationSpendLimitDeleted> =
            jsonHandler<OrganizationSpendLimitDeleted>(clientOptions.jsonMapper)

        override fun delete(
            params: SpendLimitDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<OrganizationSpendLimitDeleted> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("organization", "spend_limit")
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
