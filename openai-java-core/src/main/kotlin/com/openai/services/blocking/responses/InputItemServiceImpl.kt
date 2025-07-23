// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.responses

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
import com.openai.models.responses.inputitems.InputItemListPage
import com.openai.models.responses.inputitems.InputItemListParams
import com.openai.models.responses.inputitems.ResponseItemList
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class InputItemServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    InputItemService {

    private val withRawResponse: InputItemService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): InputItemService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): InputItemService =
        InputItemServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun list(
        params: InputItemListParams,
        requestOptions: RequestOptions,
    ): InputItemListPage =
        // get /responses/{response_id}/input_items
        withRawResponse().list(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        InputItemService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): InputItemService.WithRawResponse =
            InputItemServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val listHandler: Handler<ResponseItemList> =
            jsonHandler<ResponseItemList>(clientOptions.jsonMapper)

        override fun list(
            params: InputItemListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<InputItemListPage> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("responseId", params.responseId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("responses", params._pathParam(0), "input_items")
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
