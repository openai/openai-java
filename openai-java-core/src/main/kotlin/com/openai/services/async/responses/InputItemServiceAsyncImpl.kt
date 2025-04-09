// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.responses

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
import com.openai.core.prepareAsync
import com.openai.models.ErrorObject
import com.openai.models.responses.inputitems.InputItemListPageAsync
import com.openai.models.responses.inputitems.InputItemListParams
import com.openai.models.responses.inputitems.ResponseItemList
import java.util.concurrent.CompletableFuture

class InputItemServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    InputItemServiceAsync {

    private val withRawResponse: InputItemServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): InputItemServiceAsync.WithRawResponse = withRawResponse

    override fun list(
        params: InputItemListParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<InputItemListPageAsync> =
        // get /responses/{response_id}/input_items
        withRawResponse().list(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        InputItemServiceAsync.WithRawResponse {

        private val errorHandler: Handler<ErrorObject?> = errorHandler(clientOptions.jsonMapper)

        private val listHandler: Handler<ResponseItemList> =
            jsonHandler<ResponseItemList>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun list(
            params: InputItemListParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<InputItemListPageAsync>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("responses", params._pathParam(0), "input_items")
                    .build()
                    .prepareAsync(clientOptions, params, deploymentModel = null)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { listHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                            .let {
                                InputItemListPageAsync.builder()
                                    .service(InputItemServiceAsyncImpl(clientOptions))
                                    .params(params)
                                    .response(it)
                                    .build()
                            }
                    }
                }
        }
    }
}
