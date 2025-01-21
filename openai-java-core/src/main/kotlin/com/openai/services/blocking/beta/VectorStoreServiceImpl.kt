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
import com.openai.core.json
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

class VectorStoreServiceImpl
internal constructor(
    private val clientOptions: ClientOptions,
) : VectorStoreService {

    companion object {

        private val DEFAULT_HEADERS = Headers.builder().put("OpenAI-Beta", "assistants=v2").build()
    }

    private val errorHandler: Handler<OpenAIError> = errorHandler(clientOptions.jsonMapper)

    private val files: FileService by lazy { FileServiceImpl(clientOptions) }

    private val fileBatches: FileBatchService by lazy { FileBatchServiceImpl(clientOptions) }

    override fun files(): FileService = files

    override fun fileBatches(): FileBatchService = fileBatches

    private val createHandler: Handler<VectorStore> =
        jsonHandler<VectorStore>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Create a vector store. */
    override fun create(
        params: BetaVectorStoreCreateParams,
        requestOptions: RequestOptions
    ): VectorStore {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("vector_stores")
                .putAllQueryParams(clientOptions.queryParams)
                .replaceAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .replaceAllHeaders(DEFAULT_HEADERS)
                .replaceAllHeaders(params.getHeaders())
                .body(json(clientOptions.jsonMapper, params.getBody()))
                .build()
        return clientOptions.httpClient.execute(request, requestOptions).let { response ->
            response
                .use { createHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }

    private val retrieveHandler: Handler<VectorStore> =
        jsonHandler<VectorStore>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Retrieves a vector store. */
    override fun retrieve(
        params: BetaVectorStoreRetrieveParams,
        requestOptions: RequestOptions
    ): VectorStore {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("vector_stores", params.getPathParam(0))
                .putAllQueryParams(clientOptions.queryParams)
                .replaceAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .replaceAllHeaders(DEFAULT_HEADERS)
                .replaceAllHeaders(params.getHeaders())
                .build()
        return clientOptions.httpClient.execute(request, requestOptions).let { response ->
            response
                .use { retrieveHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }

    private val updateHandler: Handler<VectorStore> =
        jsonHandler<VectorStore>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Modifies a vector store. */
    override fun update(
        params: BetaVectorStoreUpdateParams,
        requestOptions: RequestOptions
    ): VectorStore {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("vector_stores", params.getPathParam(0))
                .putAllQueryParams(clientOptions.queryParams)
                .replaceAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .replaceAllHeaders(DEFAULT_HEADERS)
                .replaceAllHeaders(params.getHeaders())
                .body(json(clientOptions.jsonMapper, params.getBody()))
                .build()
        return clientOptions.httpClient.execute(request, requestOptions).let { response ->
            response
                .use { updateHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }

    private val listHandler: Handler<BetaVectorStoreListPage.Response> =
        jsonHandler<BetaVectorStoreListPage.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Returns a list of vector stores. */
    override fun list(
        params: BetaVectorStoreListParams,
        requestOptions: RequestOptions
    ): BetaVectorStoreListPage {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("vector_stores")
                .putAllQueryParams(clientOptions.queryParams)
                .replaceAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .replaceAllHeaders(DEFAULT_HEADERS)
                .replaceAllHeaders(params.getHeaders())
                .build()
        return clientOptions.httpClient.execute(request, requestOptions).let { response ->
            response
                .use { listHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
                .let { BetaVectorStoreListPage.of(this, params, it) }
        }
    }

    private val deleteHandler: Handler<VectorStoreDeleted> =
        jsonHandler<VectorStoreDeleted>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Delete a vector store. */
    override fun delete(
        params: BetaVectorStoreDeleteParams,
        requestOptions: RequestOptions
    ): VectorStoreDeleted {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.DELETE)
                .addPathSegments("vector_stores", params.getPathParam(0))
                .putAllQueryParams(clientOptions.queryParams)
                .replaceAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .replaceAllHeaders(DEFAULT_HEADERS)
                .replaceAllHeaders(params.getHeaders())
                .apply { params.getBody().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                .build()
        return clientOptions.httpClient.execute(request, requestOptions).let { response ->
            response
                .use { deleteHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }
}
