// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.checkRequired
import com.openai.core.handlers.errorHandler
import com.openai.core.handlers.jsonHandler
import com.openai.core.handlers.withErrorHandler
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse
import com.openai.core.http.HttpResponse.Handler
import com.openai.core.http.HttpResponseFor
import com.openai.core.http.json
import com.openai.core.http.multipartFormData
import com.openai.core.http.parseable
import com.openai.core.prepareAsync
import com.openai.models.ErrorObject
import com.openai.models.files.FileContentParams
import com.openai.models.files.FileCreateParams
import com.openai.models.files.FileDeleteParams
import com.openai.models.files.FileDeleted
import com.openai.models.files.FileListPageAsync
import com.openai.models.files.FileListPageResponse
import com.openai.models.files.FileListParams
import com.openai.models.files.FileObject
import com.openai.models.files.FileRetrieveParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class FileServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    FileServiceAsync {

    private val withRawResponse: FileServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): FileServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): FileServiceAsync =
        FileServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun create(
        params: FileCreateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<FileObject> =
        // post /files
        withRawResponse().create(params, requestOptions).thenApply { it.parse() }

    override fun retrieve(
        params: FileRetrieveParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<FileObject> =
        // get /files/{file_id}
        withRawResponse().retrieve(params, requestOptions).thenApply { it.parse() }

    override fun list(
        params: FileListParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<FileListPageAsync> =
        // get /files
        withRawResponse().list(params, requestOptions).thenApply { it.parse() }

    override fun delete(
        params: FileDeleteParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<FileDeleted> =
        // delete /files/{file_id}
        withRawResponse().delete(params, requestOptions).thenApply { it.parse() }

    override fun content(
        params: FileContentParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<HttpResponse> =
        // get /files/{file_id}/content
        withRawResponse().content(params, requestOptions)

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        FileServiceAsync.WithRawResponse {

        private val errorHandler: Handler<ErrorObject?> = errorHandler(clientOptions.jsonMapper)

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): FileServiceAsync.WithRawResponse =
            FileServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val createHandler: Handler<FileObject> =
            jsonHandler<FileObject>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun create(
            params: FileCreateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<FileObject>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("files")
                    .body(multipartFormData(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
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

        private val retrieveHandler: Handler<FileObject> =
            jsonHandler<FileObject>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun retrieve(
            params: FileRetrieveParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<FileObject>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("fileId", params.fileId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("files", params._pathParam(0))
                    .build()
                    .prepareAsync(clientOptions, params)
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

        private val listHandler: Handler<FileListPageResponse> =
            jsonHandler<FileListPageResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun list(
            params: FileListParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<FileListPageAsync>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("files")
                    .build()
                    .prepareAsync(clientOptions, params)
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
                                FileListPageAsync.builder()
                                    .service(FileServiceAsyncImpl(clientOptions))
                                    .streamHandlerExecutor(clientOptions.streamHandlerExecutor)
                                    .params(params)
                                    .response(it)
                                    .build()
                            }
                    }
                }
        }

        private val deleteHandler: Handler<FileDeleted> =
            jsonHandler<FileDeleted>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun delete(
            params: FileDeleteParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<FileDeleted>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("fileId", params.fileId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("files", params._pathParam(0))
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepareAsync(clientOptions, params)
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

        override fun content(
            params: FileContentParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("fileId", params.fileId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("files", params._pathParam(0), "content")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request.thenComposeAsync {
                clientOptions.httpClient.executeAsync(it, requestOptions)
            }
        }
    }
}
