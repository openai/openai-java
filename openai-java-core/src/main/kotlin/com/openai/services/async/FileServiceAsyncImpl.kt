// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.handlers.errorHandler
import com.openai.core.handlers.jsonHandler
import com.openai.core.handlers.withErrorHandler
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse
import com.openai.core.http.HttpResponse.Handler
import com.openai.core.json
import com.openai.core.prepareAsync
import com.openai.errors.OpenAIError
import com.openai.models.FileContentParams
import com.openai.models.FileDeleteParams
import com.openai.models.FileDeleted
import com.openai.models.FileListPageAsync
import com.openai.models.FileListParams
import com.openai.models.FileObject
import com.openai.models.FileRetrieveParams
import java.util.concurrent.CompletableFuture

class FileServiceAsyncImpl
internal constructor(
    private val clientOptions: ClientOptions,
) : FileServiceAsync {

    private val errorHandler: Handler<OpenAIError> = errorHandler(clientOptions.jsonMapper)

    private val retrieveHandler: Handler<FileObject> =
        jsonHandler<FileObject>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Returns information about a specific file. */
    override fun retrieve(
        params: FileRetrieveParams,
        requestOptions: RequestOptions
    ): CompletableFuture<FileObject> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("files", params.getPathParam(0))
                .build()
                .prepareAsync(clientOptions, params, deploymentModel = null)
        return request
            .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
            .thenApply { response ->
                response
                    .use { retrieveHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                            it.validate()
                        }
                    }
            }
    }

    private val listHandler: Handler<FileListPageAsync.Response> =
        jsonHandler<FileListPageAsync.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Returns a list of files. */
    override fun list(
        params: FileListParams,
        requestOptions: RequestOptions
    ): CompletableFuture<FileListPageAsync> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("files")
                .build()
                .prepareAsync(clientOptions, params, deploymentModel = null)
        return request
            .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
            .thenApply { response ->
                response
                    .use { listHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                            it.validate()
                        }
                    }
                    .let { FileListPageAsync.of(this, params, it) }
            }
    }

    private val deleteHandler: Handler<FileDeleted> =
        jsonHandler<FileDeleted>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Delete a file. */
    override fun delete(
        params: FileDeleteParams,
        requestOptions: RequestOptions
    ): CompletableFuture<FileDeleted> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.DELETE)
                .addPathSegments("files", params.getPathParam(0))
                .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                .build()
                .prepareAsync(clientOptions, params, deploymentModel = null)
        return request
            .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
            .thenApply { response ->
                response
                    .use { deleteHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                            it.validate()
                        }
                    }
            }
    }

    /** Returns the contents of the specified file. */
    override fun content(
        params: FileContentParams,
        requestOptions: RequestOptions
    ): CompletableFuture<HttpResponse> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("files", params.getPathParam(0), "content")
                .build()
                .prepareAsync(clientOptions, params, deploymentModel = null)
        return request.thenComposeAsync {
            clientOptions.httpClient.executeAsync(it, requestOptions)
        }
    }
}
