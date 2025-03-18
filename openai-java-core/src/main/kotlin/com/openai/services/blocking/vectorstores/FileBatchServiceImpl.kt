// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.vectorstores

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
import com.openai.models.vectorstores.filebatches.FileBatchCancelParams
import com.openai.models.vectorstores.filebatches.FileBatchCreateParams
import com.openai.models.vectorstores.filebatches.FileBatchListFilesPage
import com.openai.models.vectorstores.filebatches.FileBatchListFilesParams
import com.openai.models.vectorstores.filebatches.FileBatchRetrieveParams
import com.openai.models.vectorstores.filebatches.VectorStoreFileBatch

class FileBatchServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    FileBatchService {

    companion object {

        private val DEFAULT_HEADERS = Headers.builder().put("OpenAI-Beta", "assistants=v2").build()
    }

    private val withRawResponse: FileBatchService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): FileBatchService.WithRawResponse = withRawResponse

    override fun create(
        params: FileBatchCreateParams,
        requestOptions: RequestOptions,
    ): VectorStoreFileBatch =
        // post /vector_stores/{vector_store_id}/file_batches
        withRawResponse().create(params, requestOptions).parse()

    override fun retrieve(
        params: FileBatchRetrieveParams,
        requestOptions: RequestOptions,
    ): VectorStoreFileBatch =
        // get /vector_stores/{vector_store_id}/file_batches/{batch_id}
        withRawResponse().retrieve(params, requestOptions).parse()

    override fun cancel(
        params: FileBatchCancelParams,
        requestOptions: RequestOptions,
    ): VectorStoreFileBatch =
        // post /vector_stores/{vector_store_id}/file_batches/{batch_id}/cancel
        withRawResponse().cancel(params, requestOptions).parse()

    override fun listFiles(
        params: FileBatchListFilesParams,
        requestOptions: RequestOptions,
    ): FileBatchListFilesPage =
        // get /vector_stores/{vector_store_id}/file_batches/{batch_id}/files
        withRawResponse().listFiles(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        FileBatchService.WithRawResponse {

        private val errorHandler: Handler<OpenAIError> = errorHandler(clientOptions.jsonMapper)

        private val createHandler: Handler<VectorStoreFileBatch> =
            jsonHandler<VectorStoreFileBatch>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun create(
            params: FileBatchCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<VectorStoreFileBatch> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("vector_stores", params._pathParam(0), "file_batches")
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

        private val retrieveHandler: Handler<VectorStoreFileBatch> =
            jsonHandler<VectorStoreFileBatch>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun retrieve(
            params: FileBatchRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<VectorStoreFileBatch> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments(
                        "vector_stores",
                        params._pathParam(0),
                        "file_batches",
                        params._pathParam(1),
                    )
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

        private val cancelHandler: Handler<VectorStoreFileBatch> =
            jsonHandler<VectorStoreFileBatch>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun cancel(
            params: FileBatchCancelParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<VectorStoreFileBatch> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments(
                        "vector_stores",
                        params._pathParam(0),
                        "file_batches",
                        params._pathParam(1),
                        "cancel",
                    )
                    .putAllHeaders(DEFAULT_HEADERS)
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

        private val listFilesHandler: Handler<FileBatchListFilesPage.Response> =
            jsonHandler<FileBatchListFilesPage.Response>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun listFiles(
            params: FileBatchListFilesParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FileBatchListFilesPage> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments(
                        "vector_stores",
                        params._pathParam(0),
                        "file_batches",
                        params._pathParam(1),
                        "files",
                    )
                    .putAllHeaders(DEFAULT_HEADERS)
                    .build()
                    .prepare(clientOptions, params, deploymentModel = null)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { listFilesHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
                    .let {
                        FileBatchListFilesPage.of(FileBatchServiceImpl(clientOptions), params, it)
                    }
            }
        }
    }
}
