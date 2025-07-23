// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.evals.runs

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.checkRequired
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
import com.openai.models.evals.runs.outputitems.OutputItemListPage
import com.openai.models.evals.runs.outputitems.OutputItemListPageResponse
import com.openai.models.evals.runs.outputitems.OutputItemListParams
import com.openai.models.evals.runs.outputitems.OutputItemRetrieveParams
import com.openai.models.evals.runs.outputitems.OutputItemRetrieveResponse
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class OutputItemServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    OutputItemService {

    private val withRawResponse: OutputItemService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): OutputItemService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): OutputItemService =
        OutputItemServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

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

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): OutputItemService.WithRawResponse =
            OutputItemServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val retrieveHandler: Handler<OutputItemRetrieveResponse> =
            jsonHandler<OutputItemRetrieveResponse>(clientOptions.jsonMapper)

        override fun retrieve(
            params: OutputItemRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<OutputItemRetrieveResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("outputItemId", params.outputItemId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
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

        private val listHandler: Handler<OutputItemListPageResponse> =
            jsonHandler<OutputItemListPageResponse>(clientOptions.jsonMapper)

        override fun list(
            params: OutputItemListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<OutputItemListPage> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("runId", params.runId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
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
            return errorHandler.handle(response).parseable {
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
