// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.handlers.errorHandler
import com.openai.core.handlers.jsonHandler
import com.openai.core.handlers.withErrorHandler
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse.Handler
import com.openai.core.http.HttpResponseFor
import com.openai.core.http.json
import com.openai.core.http.parseable
import com.openai.core.prepare
import com.openai.models.ErrorObject
import com.openai.models.batches.Batch
import com.openai.models.batches.BatchCancelParams
import com.openai.models.batches.BatchCreateParams
import com.openai.models.batches.BatchListPage
import com.openai.models.batches.BatchListParams
import com.openai.models.batches.BatchRetrieveParams

class BatchServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    BatchService {

    private val withRawResponse: BatchService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): BatchService.WithRawResponse = withRawResponse

    override fun create(params: BatchCreateParams, requestOptions: RequestOptions): Batch =
        // post /batches
        withRawResponse().create(params, requestOptions).parse()

    override fun retrieve(params: BatchRetrieveParams, requestOptions: RequestOptions): Batch =
        // get /batches/{batch_id}
        withRawResponse().retrieve(params, requestOptions).parse()

    override fun list(params: BatchListParams, requestOptions: RequestOptions): BatchListPage =
        // get /batches
        withRawResponse().list(params, requestOptions).parse()

    override fun cancel(params: BatchCancelParams, requestOptions: RequestOptions): Batch =
        // post /batches/{batch_id}/cancel
        withRawResponse().cancel(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        BatchService.WithRawResponse {

        private val errorHandler: Handler<ErrorObject?> = errorHandler(clientOptions.jsonMapper)

        private val createHandler: Handler<Batch> =
            jsonHandler<Batch>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun create(
            params: BatchCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Batch> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("batches")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params, deploymentModel = null)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { createHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val retrieveHandler: Handler<Batch> =
            jsonHandler<Batch>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun retrieve(
            params: BatchRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Batch> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("batches", params._pathParam(0))
                    .build()
                    .prepare(clientOptions, params, deploymentModel = null)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { retrieveHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val listHandler: Handler<BatchListPage.Response> =
            jsonHandler<BatchListPage.Response>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun list(
            params: BatchListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<BatchListPage> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("batches")
                    .build()
                    .prepare(clientOptions, params, deploymentModel = null)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { listHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
                    .let { BatchListPage.of(BatchServiceImpl(clientOptions), params, it) }
            }
        }

        private val cancelHandler: Handler<Batch> =
            jsonHandler<Batch>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun cancel(
            params: BatchCancelParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Batch> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("batches", params._pathParam(0), "cancel")
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepare(clientOptions, params, deploymentModel = null)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { cancelHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
