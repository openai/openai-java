// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.beta

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.handlers.errorHandler
import com.openai.core.handlers.jsonHandler
import com.openai.core.handlers.withErrorHandler
import com.openai.core.http.Headers
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse.Handler
import com.openai.core.http.HttpResponseFor
import com.openai.core.http.json
import com.openai.core.http.parseable
import com.openai.core.prepare
import com.openai.errors.OpenAIError
import com.openai.models.BetaVectorStoreCreateParams
import com.openai.models.BetaVectorStoreDeleteParams
import com.openai.models.BetaVectorStoreListPage
import com.openai.models.BetaVectorStoreListParams
import com.openai.models.BetaVectorStoreRetrieveParams
import com.openai.models.BetaVectorStoreUpdateParams
import com.openai.models.VectorStore
import com.openai.models.VectorStoreDeleted
import com.openai.services.blocking.beta.vectorStores.FileBatchService
import com.openai.services.blocking.beta.vectorStores.FileBatchServiceImpl
import com.openai.services.blocking.beta.vectorStores.FileService
import com.openai.services.blocking.beta.vectorStores.FileServiceImpl

class VectorStoreServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    VectorStoreService {

    companion object {

        private val DEFAULT_HEADERS = Headers.builder().put("OpenAI-Beta", "assistants=v2").build()
    }

    private val withRawResponse: VectorStoreService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val files: FileService by lazy { FileServiceImpl(clientOptions) }

    private val fileBatches: FileBatchService by lazy { FileBatchServiceImpl(clientOptions) }

    override fun withRawResponse(): VectorStoreService.WithRawResponse = withRawResponse

    override fun files(): FileService = files

    override fun fileBatches(): FileBatchService = fileBatches

    override fun create(
        params: BetaVectorStoreCreateParams,
        requestOptions: RequestOptions,
    ): VectorStore =
        // post /vector_stores
        withRawResponse().create(params, requestOptions).parse()

    override fun retrieve(
        params: BetaVectorStoreRetrieveParams,
        requestOptions: RequestOptions,
    ): VectorStore =
        // get /vector_stores/{vector_store_id}
        withRawResponse().retrieve(params, requestOptions).parse()

    override fun update(
        params: BetaVectorStoreUpdateParams,
        requestOptions: RequestOptions,
    ): VectorStore =
        // post /vector_stores/{vector_store_id}
        withRawResponse().update(params, requestOptions).parse()

    override fun list(
        params: BetaVectorStoreListParams,
        requestOptions: RequestOptions,
    ): BetaVectorStoreListPage =
        // get /vector_stores
        withRawResponse().list(params, requestOptions).parse()

    override fun delete(
        params: BetaVectorStoreDeleteParams,
        requestOptions: RequestOptions,
    ): VectorStoreDeleted =
        // delete /vector_stores/{vector_store_id}
        withRawResponse().delete(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        VectorStoreService.WithRawResponse {

        private val errorHandler: Handler<OpenAIError> = errorHandler(clientOptions.jsonMapper)

        private val files: FileService.WithRawResponse by lazy {
            FileServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val fileBatches: FileBatchService.WithRawResponse by lazy {
            FileBatchServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun files(): FileService.WithRawResponse = files

        override fun fileBatches(): FileBatchService.WithRawResponse = fileBatches

        private val createHandler: Handler<VectorStore> =
            jsonHandler<VectorStore>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun create(
            params: BetaVectorStoreCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<VectorStore> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("vector_stores")
                    .putAllHeaders(DEFAULT_HEADERS)
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

        private val retrieveHandler: Handler<VectorStore> =
            jsonHandler<VectorStore>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun retrieve(
            params: BetaVectorStoreRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<VectorStore> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("vector_stores", params.getPathParam(0))
                    .putAllHeaders(DEFAULT_HEADERS)
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

        private val updateHandler: Handler<VectorStore> =
            jsonHandler<VectorStore>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun update(
            params: BetaVectorStoreUpdateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<VectorStore> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("vector_stores", params.getPathParam(0))
                    .putAllHeaders(DEFAULT_HEADERS)
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params, deploymentModel = null)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { updateHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val listHandler: Handler<BetaVectorStoreListPage.Response> =
            jsonHandler<BetaVectorStoreListPage.Response>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun list(
            params: BetaVectorStoreListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<BetaVectorStoreListPage> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("vector_stores")
                    .putAllHeaders(DEFAULT_HEADERS)
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
                        BetaVectorStoreListPage.of(
                            VectorStoreServiceImpl(clientOptions),
                            params,
                            it,
                        )
                    }
            }
        }

        private val deleteHandler: Handler<VectorStoreDeleted> =
            jsonHandler<VectorStoreDeleted>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun delete(
            params: BetaVectorStoreDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<VectorStoreDeleted> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .addPathSegments("vector_stores", params.getPathParam(0))
                    .putAllHeaders(DEFAULT_HEADERS)
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepare(clientOptions, params, deploymentModel = null)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
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
