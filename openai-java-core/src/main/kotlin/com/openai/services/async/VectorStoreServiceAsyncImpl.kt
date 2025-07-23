// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.checkRequired
import com.openai.core.handlers.errorBodyHandler
import com.openai.core.handlers.errorHandler
import com.openai.core.handlers.jsonHandler
import com.openai.core.http.Headers
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse
import com.openai.core.http.HttpResponse.Handler
import com.openai.core.http.HttpResponseFor
import com.openai.core.http.json
import com.openai.core.http.parseable
import com.openai.core.prepareAsync
import com.openai.models.vectorstores.VectorStore
import com.openai.models.vectorstores.VectorStoreCreateParams
import com.openai.models.vectorstores.VectorStoreDeleteParams
import com.openai.models.vectorstores.VectorStoreDeleted
import com.openai.models.vectorstores.VectorStoreListPageAsync
import com.openai.models.vectorstores.VectorStoreListPageResponse
import com.openai.models.vectorstores.VectorStoreListParams
import com.openai.models.vectorstores.VectorStoreRetrieveParams
import com.openai.models.vectorstores.VectorStoreSearchPageAsync
import com.openai.models.vectorstores.VectorStoreSearchPageResponse
import com.openai.models.vectorstores.VectorStoreSearchParams
import com.openai.models.vectorstores.VectorStoreUpdateParams
import com.openai.services.async.vectorstores.FileBatchServiceAsync
import com.openai.services.async.vectorstores.FileBatchServiceAsyncImpl
import com.openai.services.async.vectorstores.FileServiceAsync
import com.openai.services.async.vectorstores.FileServiceAsyncImpl
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class VectorStoreServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    VectorStoreServiceAsync {

    companion object {

        private val DEFAULT_HEADERS = Headers.builder().put("OpenAI-Beta", "assistants=v2").build()
    }

    private val withRawResponse: VectorStoreServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val files: FileServiceAsync by lazy { FileServiceAsyncImpl(clientOptions) }

    private val fileBatches: FileBatchServiceAsync by lazy {
        FileBatchServiceAsyncImpl(clientOptions)
    }

    override fun withRawResponse(): VectorStoreServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): VectorStoreServiceAsync =
        VectorStoreServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun files(): FileServiceAsync = files

    override fun fileBatches(): FileBatchServiceAsync = fileBatches

    override fun create(
        params: VectorStoreCreateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<VectorStore> =
        // post /vector_stores
        withRawResponse().create(params, requestOptions).thenApply { it.parse() }

    override fun retrieve(
        params: VectorStoreRetrieveParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<VectorStore> =
        // get /vector_stores/{vector_store_id}
        withRawResponse().retrieve(params, requestOptions).thenApply { it.parse() }

    override fun update(
        params: VectorStoreUpdateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<VectorStore> =
        // post /vector_stores/{vector_store_id}
        withRawResponse().update(params, requestOptions).thenApply { it.parse() }

    override fun list(
        params: VectorStoreListParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<VectorStoreListPageAsync> =
        // get /vector_stores
        withRawResponse().list(params, requestOptions).thenApply { it.parse() }

    override fun delete(
        params: VectorStoreDeleteParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<VectorStoreDeleted> =
        // delete /vector_stores/{vector_store_id}
        withRawResponse().delete(params, requestOptions).thenApply { it.parse() }

    override fun search(
        params: VectorStoreSearchParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<VectorStoreSearchPageAsync> =
        // post /vector_stores/{vector_store_id}/search
        withRawResponse().search(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        VectorStoreServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        private val files: FileServiceAsync.WithRawResponse by lazy {
            FileServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val fileBatches: FileBatchServiceAsync.WithRawResponse by lazy {
            FileBatchServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): VectorStoreServiceAsync.WithRawResponse =
            VectorStoreServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun files(): FileServiceAsync.WithRawResponse = files

        override fun fileBatches(): FileBatchServiceAsync.WithRawResponse = fileBatches

        private val createHandler: Handler<VectorStore> =
            jsonHandler<VectorStore>(clientOptions.jsonMapper)

        override fun create(
            params: VectorStoreCreateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<VectorStore>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("vector_stores")
                    .putAllHeaders(DEFAULT_HEADERS)
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params, deploymentModel = null)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
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

        private val retrieveHandler: Handler<VectorStore> =
            jsonHandler<VectorStore>(clientOptions.jsonMapper)

        override fun retrieve(
            params: VectorStoreRetrieveParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<VectorStore>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("vectorStoreId", params.vectorStoreId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("vector_stores", params._pathParam(0))
                    .putAllHeaders(DEFAULT_HEADERS)
                    .build()
                    .prepareAsync(clientOptions, params, deploymentModel = null)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
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

        private val updateHandler: Handler<VectorStore> =
            jsonHandler<VectorStore>(clientOptions.jsonMapper)

        override fun update(
            params: VectorStoreUpdateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<VectorStore>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("vectorStoreId", params.vectorStoreId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("vector_stores", params._pathParam(0))
                    .putAllHeaders(DEFAULT_HEADERS)
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params, deploymentModel = null)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
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

        private val listHandler: Handler<VectorStoreListPageResponse> =
            jsonHandler<VectorStoreListPageResponse>(clientOptions.jsonMapper)

        override fun list(
            params: VectorStoreListParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<VectorStoreListPageAsync>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("vector_stores")
                    .putAllHeaders(DEFAULT_HEADERS)
                    .build()
                    .prepareAsync(clientOptions, params, deploymentModel = null)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { listHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                            .let {
                                VectorStoreListPageAsync.builder()
                                    .service(VectorStoreServiceAsyncImpl(clientOptions))
                                    .streamHandlerExecutor(clientOptions.streamHandlerExecutor)
                                    .params(params)
                                    .response(it)
                                    .build()
                            }
                    }
                }
        }

        private val deleteHandler: Handler<VectorStoreDeleted> =
            jsonHandler<VectorStoreDeleted>(clientOptions.jsonMapper)

        override fun delete(
            params: VectorStoreDeleteParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<VectorStoreDeleted>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("vectorStoreId", params.vectorStoreId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("vector_stores", params._pathParam(0))
                    .putAllHeaders(DEFAULT_HEADERS)
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepareAsync(clientOptions, params, deploymentModel = null)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
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

        private val searchHandler: Handler<VectorStoreSearchPageResponse> =
            jsonHandler<VectorStoreSearchPageResponse>(clientOptions.jsonMapper)

        override fun search(
            params: VectorStoreSearchParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<VectorStoreSearchPageAsync>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("vectorStoreId", params.vectorStoreId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("vector_stores", params._pathParam(0), "search")
                    .putAllHeaders(DEFAULT_HEADERS)
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params, deploymentModel = null)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { searchHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                            .let {
                                VectorStoreSearchPageAsync.builder()
                                    .service(VectorStoreServiceAsyncImpl(clientOptions))
                                    .streamHandlerExecutor(clientOptions.streamHandlerExecutor)
                                    .params(params)
                                    .response(it)
                                    .build()
                            }
                    }
                }
        }
    }
}
