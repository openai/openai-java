// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking

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
import com.openai.models.ErrorObject
import com.openai.models.vectorstores.VectorStore
import com.openai.models.vectorstores.VectorStoreCreateParams
import com.openai.models.vectorstores.VectorStoreDeleteParams
import com.openai.models.vectorstores.VectorStoreDeleted
import com.openai.models.vectorstores.VectorStoreListPage
import com.openai.models.vectorstores.VectorStoreListParams
import com.openai.models.vectorstores.VectorStoreRetrieveParams
import com.openai.models.vectorstores.VectorStoreSearchPage
import com.openai.models.vectorstores.VectorStoreSearchParams
import com.openai.models.vectorstores.VectorStoreUpdateParams
import com.openai.services.blocking.vectorstores.FileBatchService
import com.openai.services.blocking.vectorstores.FileBatchServiceImpl
import com.openai.services.blocking.vectorstores.FileService
import com.openai.services.blocking.vectorstores.FileServiceImpl

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
        params: VectorStoreCreateParams,
        requestOptions: RequestOptions,
    ): VectorStore =
        // post /vector_stores
        withRawResponse().create(params, requestOptions).parse()

    override fun retrieve(
        params: VectorStoreRetrieveParams,
        requestOptions: RequestOptions,
    ): VectorStore =
        // get /vector_stores/{vector_store_id}
        withRawResponse().retrieve(params, requestOptions).parse()

    override fun update(
        params: VectorStoreUpdateParams,
        requestOptions: RequestOptions,
    ): VectorStore =
        // post /vector_stores/{vector_store_id}
        withRawResponse().update(params, requestOptions).parse()

    override fun list(
        params: VectorStoreListParams,
        requestOptions: RequestOptions,
    ): VectorStoreListPage =
        // get /vector_stores
        withRawResponse().list(params, requestOptions).parse()

    override fun delete(
        params: VectorStoreDeleteParams,
        requestOptions: RequestOptions,
    ): VectorStoreDeleted =
        // delete /vector_stores/{vector_store_id}
        withRawResponse().delete(params, requestOptions).parse()

    override fun search(
        params: VectorStoreSearchParams,
        requestOptions: RequestOptions,
    ): VectorStoreSearchPage =
        // post /vector_stores/{vector_store_id}/search
        withRawResponse().search(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        VectorStoreService.WithRawResponse {

        private val errorHandler: Handler<ErrorObject?> = errorHandler(clientOptions.jsonMapper)

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
            params: VectorStoreCreateParams,
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
            params: VectorStoreRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<VectorStore> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("vector_stores", params._pathParam(0))
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
            params: VectorStoreUpdateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<VectorStore> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("vector_stores", params._pathParam(0))
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

        private val listHandler: Handler<VectorStoreListPage.Response> =
            jsonHandler<VectorStoreListPage.Response>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun list(
            params: VectorStoreListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<VectorStoreListPage> {
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
                        VectorStoreListPage.of(VectorStoreServiceImpl(clientOptions), params, it)
                    }
            }
        }

        private val deleteHandler: Handler<VectorStoreDeleted> =
            jsonHandler<VectorStoreDeleted>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun delete(
            params: VectorStoreDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<VectorStoreDeleted> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .addPathSegments("vector_stores", params._pathParam(0))
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

        private val searchHandler: Handler<VectorStoreSearchPage.Response> =
            jsonHandler<VectorStoreSearchPage.Response>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun search(
            params: VectorStoreSearchParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<VectorStoreSearchPage> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("vector_stores", params._pathParam(0), "search")
                    .putAllHeaders(DEFAULT_HEADERS)
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params, deploymentModel = null)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { searchHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
                    .let {
                        VectorStoreSearchPage.of(VectorStoreServiceImpl(clientOptions), params, it)
                    }
            }
        }
    }
}
