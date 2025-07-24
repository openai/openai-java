// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking

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
import com.openai.core.http.json
import com.openai.core.http.parseable
import com.openai.core.prepare
import com.openai.models.evals.EvalCreateParams
import com.openai.models.evals.EvalCreateResponse
import com.openai.models.evals.EvalDeleteParams
import com.openai.models.evals.EvalDeleteResponse
import com.openai.models.evals.EvalListPage
import com.openai.models.evals.EvalListPageResponse
import com.openai.models.evals.EvalListParams
import com.openai.models.evals.EvalRetrieveParams
import com.openai.models.evals.EvalRetrieveResponse
import com.openai.models.evals.EvalUpdateParams
import com.openai.models.evals.EvalUpdateResponse
import com.openai.services.blocking.evals.RunService
import com.openai.services.blocking.evals.RunServiceImpl
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class EvalServiceImpl internal constructor(private val clientOptions: ClientOptions) : EvalService {

    private val withRawResponse: EvalService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val runs: RunService by lazy { RunServiceImpl(clientOptions) }

    override fun withRawResponse(): EvalService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): EvalService =
        EvalServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun runs(): RunService = runs

    override fun create(
        params: EvalCreateParams,
        requestOptions: RequestOptions,
    ): EvalCreateResponse =
        // post /evals
        withRawResponse().create(params, requestOptions).parse()

    override fun retrieve(
        params: EvalRetrieveParams,
        requestOptions: RequestOptions,
    ): EvalRetrieveResponse =
        // get /evals/{eval_id}
        withRawResponse().retrieve(params, requestOptions).parse()

    override fun update(
        params: EvalUpdateParams,
        requestOptions: RequestOptions,
    ): EvalUpdateResponse =
        // post /evals/{eval_id}
        withRawResponse().update(params, requestOptions).parse()

    override fun list(params: EvalListParams, requestOptions: RequestOptions): EvalListPage =
        // get /evals
        withRawResponse().list(params, requestOptions).parse()

    override fun delete(
        params: EvalDeleteParams,
        requestOptions: RequestOptions,
    ): EvalDeleteResponse =
        // delete /evals/{eval_id}
        withRawResponse().delete(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        EvalService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        private val runs: RunService.WithRawResponse by lazy {
            RunServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): EvalService.WithRawResponse =
            EvalServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun runs(): RunService.WithRawResponse = runs

        private val createHandler: Handler<EvalCreateResponse> =
            jsonHandler<EvalCreateResponse>(clientOptions.jsonMapper)

        override fun create(
            params: EvalCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<EvalCreateResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("evals")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
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

        private val retrieveHandler: Handler<EvalRetrieveResponse> =
            jsonHandler<EvalRetrieveResponse>(clientOptions.jsonMapper)

        override fun retrieve(
            params: EvalRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<EvalRetrieveResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("evalId", params.evalId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("evals", params._pathParam(0))
                    .build()
                    .prepare(clientOptions, params)
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

        private val updateHandler: Handler<EvalUpdateResponse> =
            jsonHandler<EvalUpdateResponse>(clientOptions.jsonMapper)

        override fun update(
            params: EvalUpdateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<EvalUpdateResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("evalId", params.evalId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("evals", params._pathParam(0))
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
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

        private val listHandler: Handler<EvalListPageResponse> =
            jsonHandler<EvalListPageResponse>(clientOptions.jsonMapper)

        override fun list(
            params: EvalListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<EvalListPage> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("evals")
                    .build()
                    .prepare(clientOptions, params)
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
                        EvalListPage.builder()
                            .service(EvalServiceImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }

        private val deleteHandler: Handler<EvalDeleteResponse> =
            jsonHandler<EvalDeleteResponse>(clientOptions.jsonMapper)

        override fun delete(
            params: EvalDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<EvalDeleteResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("evalId", params.evalId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("evals", params._pathParam(0))
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepare(clientOptions, params)
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
