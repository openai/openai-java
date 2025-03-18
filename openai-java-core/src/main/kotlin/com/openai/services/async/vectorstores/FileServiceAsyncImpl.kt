// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.vectorstores

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
import com.openai.core.prepareAsync
import com.openai.errors.OpenAIError
import com.openai.models.vectorstores.files.FileContentPageAsync
import com.openai.models.vectorstores.files.FileContentParams
import com.openai.models.vectorstores.files.FileCreateParams
import com.openai.models.vectorstores.files.FileDeleteParams
import com.openai.models.vectorstores.files.FileListPageAsync
import com.openai.models.vectorstores.files.FileListParams
import com.openai.models.vectorstores.files.FileRetrieveParams
import com.openai.models.vectorstores.files.FileUpdateParams
import com.openai.models.vectorstores.files.VectorStoreFile
import com.openai.models.vectorstores.files.VectorStoreFileDeleted
import java.util.concurrent.CompletableFuture

class FileServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    FileServiceAsync {

    companion object {

        private val DEFAULT_HEADERS = Headers.builder().put("OpenAI-Beta", "assistants=v2").build()
    }

    private val withRawResponse: FileServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): FileServiceAsync.WithRawResponse = withRawResponse

    override fun create(
        params: FileCreateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<VectorStoreFile> =
        // post /vector_stores/{vector_store_id}/files
        withRawResponse().create(params, requestOptions).thenApply { it.parse() }

    override fun retrieve(
        params: FileRetrieveParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<VectorStoreFile> =
        // get /vector_stores/{vector_store_id}/files/{file_id}
        withRawResponse().retrieve(params, requestOptions).thenApply { it.parse() }

    override fun update(
        params: FileUpdateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<VectorStoreFile> =
        // post /vector_stores/{vector_store_id}/files/{file_id}
        withRawResponse().update(params, requestOptions).thenApply { it.parse() }

    override fun list(
        params: FileListParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<FileListPageAsync> =
        // get /vector_stores/{vector_store_id}/files
        withRawResponse().list(params, requestOptions).thenApply { it.parse() }

    override fun delete(
        params: FileDeleteParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<VectorStoreFileDeleted> =
        // delete /vector_stores/{vector_store_id}/files/{file_id}
        withRawResponse().delete(params, requestOptions).thenApply { it.parse() }

    override fun content(
        params: FileContentParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<FileContentPageAsync> =
        // get /vector_stores/{vector_store_id}/files/{file_id}/content
        withRawResponse().content(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        FileServiceAsync.WithRawResponse {

        private val errorHandler: Handler<OpenAIError> = errorHandler(clientOptions.jsonMapper)

        private val createHandler: Handler<VectorStoreFile> =
            jsonHandler<VectorStoreFile>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun create(
            params: FileCreateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<VectorStoreFile>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("vector_stores", params._pathParam(0), "files")
                    .putAllHeaders(DEFAULT_HEADERS)
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params, deploymentModel = null)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { createHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val retrieveHandler: Handler<VectorStoreFile> =
            jsonHandler<VectorStoreFile>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun retrieve(
            params: FileRetrieveParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<VectorStoreFile>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments(
                        "vector_stores",
                        params._pathParam(0),
                        "files",
                        params._pathParam(1),
                    )
                    .putAllHeaders(DEFAULT_HEADERS)
                    .build()
                    .prepareAsync(clientOptions, params, deploymentModel = null)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { retrieveHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val updateHandler: Handler<VectorStoreFile> =
            jsonHandler<VectorStoreFile>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun update(
            params: FileUpdateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<VectorStoreFile>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments(
                        "vector_stores",
                        params._pathParam(0),
                        "files",
                        params._pathParam(1),
                    )
                    .putAllHeaders(DEFAULT_HEADERS)
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params, deploymentModel = null)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { updateHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val listHandler: Handler<FileListPageAsync.Response> =
            jsonHandler<FileListPageAsync.Response>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun list(
            params: FileListParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<FileListPageAsync>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("vector_stores", params._pathParam(0), "files")
                    .putAllHeaders(DEFAULT_HEADERS)
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
                                FileListPageAsync.of(
                                    FileServiceAsyncImpl(clientOptions),
                                    params,
                                    it,
                                )
                            }
                    }
                }
        }

        private val deleteHandler: Handler<VectorStoreFileDeleted> =
            jsonHandler<VectorStoreFileDeleted>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun delete(
            params: FileDeleteParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<VectorStoreFileDeleted>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .addPathSegments(
                        "vector_stores",
                        params._pathParam(0),
                        "files",
                        params._pathParam(1),
                    )
                    .putAllHeaders(DEFAULT_HEADERS)
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepareAsync(clientOptions, params, deploymentModel = null)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
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

        private val contentHandler: Handler<FileContentPageAsync.Response> =
            jsonHandler<FileContentPageAsync.Response>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun content(
            params: FileContentParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<FileContentPageAsync>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments(
                        "vector_stores",
                        params._pathParam(0),
                        "files",
                        params._pathParam(1),
                        "content",
                    )
                    .putAllHeaders(DEFAULT_HEADERS)
                    .build()
                    .prepareAsync(clientOptions, params, deploymentModel = null)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { contentHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                            .let {
                                FileContentPageAsync.of(
                                    FileServiceAsyncImpl(clientOptions),
                                    params,
                                    it,
                                )
                            }
                    }
                }
        }
    }
}
