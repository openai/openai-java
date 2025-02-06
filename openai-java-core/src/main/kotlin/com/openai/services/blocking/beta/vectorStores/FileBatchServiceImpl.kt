// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.beta.vectorStores

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
import com.openai.core.prepare
import com.openai.errors.OpenAIError
import com.openai.models.BetaVectorStoreFileBatchCancelParams
import com.openai.models.BetaVectorStoreFileBatchCreateParams
import com.openai.models.BetaVectorStoreFileBatchListFilesPage
import com.openai.models.BetaVectorStoreFileBatchListFilesParams
import com.openai.models.BetaVectorStoreFileBatchRetrieveParams
import com.openai.models.VectorStoreFileBatch

class FileBatchServiceImpl
internal constructor(
    private val clientOptions: ClientOptions,
) : FileBatchService {

    companion object {

        private val DEFAULT_HEADERS = Headers.builder().put("OpenAI-Beta", "assistants=v2").build()
    }

    private val errorHandler: Handler<OpenAIError> = errorHandler(clientOptions.jsonMapper)

    private val createHandler: Handler<VectorStoreFileBatch> =
        jsonHandler<VectorStoreFileBatch>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Create a vector store file batch. */
    override fun create(
        params: BetaVectorStoreFileBatchCreateParams,
        requestOptions: RequestOptions
    ): VectorStoreFileBatch {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("vector_stores", params.getPathParam(0), "file_batches")
                .putAllHeaders(DEFAULT_HEADERS)
                .body(json(clientOptions.jsonMapper, params._body()))
                .build()
                .prepare(clientOptions, params, deploymentModel = null)
        val response = clientOptions.httpClient.execute(request, requestOptions)
        return response
            .use { createHandler.handle(it) }
            .also {
                if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                    it.validate()
                }
            }
    }

    private val retrieveHandler: Handler<VectorStoreFileBatch> =
        jsonHandler<VectorStoreFileBatch>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Retrieves a vector store file batch. */
    override fun retrieve(
        params: BetaVectorStoreFileBatchRetrieveParams,
        requestOptions: RequestOptions
    ): VectorStoreFileBatch {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments(
                    "vector_stores",
                    params.getPathParam(0),
                    "file_batches",
                    params.getPathParam(1)
                )
                .putAllHeaders(DEFAULT_HEADERS)
                .build()
                .prepare(clientOptions, params, deploymentModel = null)
        val response = clientOptions.httpClient.execute(request, requestOptions)
        return response
            .use { retrieveHandler.handle(it) }
            .also {
                if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                    it.validate()
                }
            }
    }

    private val cancelHandler: Handler<VectorStoreFileBatch> =
        jsonHandler<VectorStoreFileBatch>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /**
     * Cancel a vector store file batch. This attempts to cancel the processing of files in this
     * batch as soon as possible.
     */
    override fun cancel(
        params: BetaVectorStoreFileBatchCancelParams,
        requestOptions: RequestOptions
    ): VectorStoreFileBatch {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments(
                    "vector_stores",
                    params.getPathParam(0),
                    "file_batches",
                    params.getPathParam(1),
                    "cancel"
                )
                .putAllHeaders(DEFAULT_HEADERS)
                .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                .build()
                .prepare(clientOptions, params, deploymentModel = null)
        val response = clientOptions.httpClient.execute(request, requestOptions)
        return response
            .use { cancelHandler.handle(it) }
            .also {
                if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                    it.validate()
                }
            }
    }

    private val listFilesHandler: Handler<BetaVectorStoreFileBatchListFilesPage.Response> =
        jsonHandler<BetaVectorStoreFileBatchListFilesPage.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Returns a list of vector store files in a batch. */
    override fun listFiles(
        params: BetaVectorStoreFileBatchListFilesParams,
        requestOptions: RequestOptions
    ): BetaVectorStoreFileBatchListFilesPage {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments(
                    "vector_stores",
                    params.getPathParam(0),
                    "file_batches",
                    params.getPathParam(1),
                    "files"
                )
                .putAllHeaders(DEFAULT_HEADERS)
                .build()
                .prepare(clientOptions, params, deploymentModel = null)
        val response = clientOptions.httpClient.execute(request, requestOptions)
        return response
            .use { listFilesHandler.handle(it) }
            .also {
                if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                    it.validate()
                }
            }
            .let { BetaVectorStoreFileBatchListFilesPage.of(this, params, it) }
    }
}
