// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.evals.runs

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.handlers.errorHandler
import com.openai.core.handlers.jsonHandler
import com.openai.core.handlers.withErrorHandler
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse.Handler
import com.openai.core.http.HttpResponseFor
import com.openai.core.http.parseable
import com.openai.core.prepare
import com.openai.models.ErrorObject
import com.openai.models.evals.runs.outputitems.OutputItemListPage
import com.openai.models.evals.runs.outputitems.OutputItemListPageResponse
import com.openai.models.evals.runs.outputitems.OutputItemListParams
import com.openai.models.evals.runs.outputitems.OutputItemRetrieveParams
import com.openai.models.evals.runs.outputitems.OutputItemRetrieveResponse

class OutputItemServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    OutputItemService {

    private val withRawResponse: OutputItemService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): OutputItemService.WithRawResponse = withRawResponse

    override fun retrieve(
        params: OutputItemRetrieveParams,
        requestOptions: RequestOptions,
    ): OutputItemRetrieveResponse =
        // get /evals/{eval_id}/runs/{run_id}/output_items/{output_item_id}
        withRawResponse().retrieve(params, requestOptions).parse()

    override fun list(
        params: OutputItemListParams,
        requestOptions: RequestOptions,
    ): OutputItemListPage =
        // get /evals/{eval_id}/runs/{run_id}/output_items
        withRawResponse().list(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        OutputItemService.WithRawResponse {

        private val errorHandler: Handler<ErrorObject?> = errorHandler(clientOptions.jsonMapper)

        private val retrieveHandler: Handler<OutputItemRetrieveResponse> =
            jsonHandler<OutputItemRetrieveResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun retrieve(
            params: OutputItemRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<OutputItemRetrieveResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments(
                        "evals",
                        params._pathParam(0),
                        "runs",
                        params._pathParam(1),
                        "output_items",
                        params._pathParam(2),
                    )
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

        private val listHandler: Handler<OutputItemListPageResponse> =
            jsonHandler<OutputItemListPageResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun list(
            params: OutputItemListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<OutputItemListPage> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments(
                        "evals",
                        params._pathParam(0),
                        "runs",
                        params._pathParam(1),
                        "output_items",
                    )
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
                    .let {
                        OutputItemListPage.builder()
                            .service(OutputItemServiceImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }
    }
}
