// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.responses

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
import com.openai.models.responses.inputitems.InputItemListPage
import com.openai.models.responses.inputitems.InputItemListParams
import com.openai.models.responses.inputitems.ResponseItemList

class InputItemServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    InputItemService {

    private val withRawResponse: InputItemService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): InputItemService.WithRawResponse = withRawResponse

    override fun list(
        params: InputItemListParams,
        requestOptions: RequestOptions,
    ): InputItemListPage =
        // get /responses/{response_id}/input_items
        withRawResponse().list(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        InputItemService.WithRawResponse {

        private val errorHandler: Handler<ErrorObject?> = errorHandler(clientOptions.jsonMapper)

        private val listHandler: Handler<ResponseItemList> =
            jsonHandler<ResponseItemList>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun list(
            params: InputItemListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<InputItemListPage> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("responses", params._pathParam(0), "input_items")
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
                        InputItemListPage.builder()
                            .service(InputItemServiceImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }
    }
}
