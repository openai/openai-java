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
import com.openai.core.http.HttpResponseFor
import com.openai.core.http.json
import com.openai.core.http.parseable
import com.openai.core.prepare
import com.openai.errors.OpenAIError
import com.openai.models.BetaVectorStoreFileCreateParams
import com.openai.models.BetaVectorStoreFileDeleteParams
import com.openai.models.BetaVectorStoreFileListPage
import com.openai.models.BetaVectorStoreFileListParams
import com.openai.models.BetaVectorStoreFileRetrieveParams
import com.openai.models.VectorStoreFile
import com.openai.models.VectorStoreFileDeleted

class FileServiceImpl internal constructor(private val clientOptions: ClientOptions) : FileService {

    companion object {

        private val DEFAULT_HEADERS = Headers.builder().put("OpenAI-Beta", "assistants=v2").build()
    }

    private val withRawResponse: FileService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): FileService.WithRawResponse = withRawResponse

    override fun create(
        params: BetaVectorStoreFileCreateParams,
        requestOptions: RequestOptions,
    ): VectorStoreFile =
        // post /vector_stores/{vector_store_id}/files
        withRawResponse().create(params, requestOptions).parse()

    override fun retrieve(
        params: BetaVectorStoreFileRetrieveParams,
        requestOptions: RequestOptions,
    ): VectorStoreFile =
        // get /vector_stores/{vector_store_id}/files/{file_id}
        withRawResponse().retrieve(params, requestOptions).parse()

    override fun list(
        params: BetaVectorStoreFileListParams,
        requestOptions: RequestOptions,
    ): BetaVectorStoreFileListPage =
        // get /vector_stores/{vector_store_id}/files
        withRawResponse().list(params, requestOptions).parse()

    override fun delete(
        params: BetaVectorStoreFileDeleteParams,
        requestOptions: RequestOptions,
    ): VectorStoreFileDeleted =
        // delete /vector_stores/{vector_store_id}/files/{file_id}
        withRawResponse().delete(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        FileService.WithRawResponse {

        private val errorHandler: Handler<OpenAIError> = errorHandler(clientOptions.jsonMapper)

        private val createHandler: Handler<VectorStoreFile> =
            jsonHandler<VectorStoreFile>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun create(
            params: BetaVectorStoreFileCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<VectorStoreFile> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("vector_stores", params.getPathParam(0), "files")
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

        private val retrieveHandler: Handler<VectorStoreFile> =
            jsonHandler<VectorStoreFile>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun retrieve(
            params: BetaVectorStoreFileRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<VectorStoreFile> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments(
                        "vector_stores",
                        params.getPathParam(0),
                        "files",
                        params.getPathParam(1),
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

        private val listHandler: Handler<BetaVectorStoreFileListPage.Response> =
            jsonHandler<BetaVectorStoreFileListPage.Response>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun list(
            params: BetaVectorStoreFileListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<BetaVectorStoreFileListPage> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("vector_stores", params.getPathParam(0), "files")
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
                        BetaVectorStoreFileListPage.of(FileServiceImpl(clientOptions), params, it)
                    }
            }
        }

        private val deleteHandler: Handler<VectorStoreFileDeleted> =
            jsonHandler<VectorStoreFileDeleted>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun delete(
            params: BetaVectorStoreFileDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<VectorStoreFileDeleted> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .addPathSegments(
                        "vector_stores",
                        params.getPathParam(0),
                        "files",
                        params.getPathParam(1),
                    )
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
