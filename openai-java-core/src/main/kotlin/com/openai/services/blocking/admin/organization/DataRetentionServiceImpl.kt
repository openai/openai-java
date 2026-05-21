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
import com.openai.models.admin.organization.dataretention.DataRetentionRetrieveParams
import com.openai.models.admin.organization.dataretention.DataRetentionUpdateParams
import com.openai.models.admin.organization.dataretention.OrganizationDataRetention
import java.util.function.Consumer

class DataRetentionServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    DataRetentionService {

    private val withRawResponse: DataRetentionService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): DataRetentionService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): DataRetentionService =
        DataRetentionServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun retrieve(
        params: DataRetentionRetrieveParams,
        requestOptions: RequestOptions,
    ): OrganizationDataRetention =
        // get /organization/data_retention
        withRawResponse().retrieve(params, requestOptions).parse()

    override fun update(
        params: DataRetentionUpdateParams,
        requestOptions: RequestOptions,
    ): OrganizationDataRetention =
        // post /organization/data_retention
        withRawResponse().update(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        DataRetentionService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): DataRetentionService.WithRawResponse =
            DataRetentionServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val retrieveHandler: Handler<OrganizationDataRetention> =
            jsonHandler<OrganizationDataRetention>(clientOptions.jsonMapper)

        override fun retrieve(
            params: DataRetentionRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<OrganizationDataRetention> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("organization", "data_retention")
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

        private val updateHandler: Handler<OrganizationDataRetention> =
            jsonHandler<OrganizationDataRetention>(clientOptions.jsonMapper)

        override fun update(
            params: DataRetentionUpdateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<OrganizationDataRetention> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("organization", "data_retention")
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
    }
}
