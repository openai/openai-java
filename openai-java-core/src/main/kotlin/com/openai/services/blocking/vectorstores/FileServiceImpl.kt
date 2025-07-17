// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.vectorstores

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
import com.openai.core.prepare
import com.openai.models.vectorstores.files.FileContentPage
import com.openai.models.vectorstores.files.FileContentPageResponse
import com.openai.models.vectorstores.files.FileContentParams
import com.openai.models.vectorstores.files.FileCreateParams
import com.openai.models.vectorstores.files.FileDeleteParams
import com.openai.models.vectorstores.files.FileListPage
import com.openai.models.vectorstores.files.FileListPageResponse
import com.openai.models.vectorstores.files.FileListParams
import com.openai.models.vectorstores.files.FileRetrieveParams
import com.openai.models.vectorstores.files.FileUpdateParams
import com.openai.models.vectorstores.files.VectorStoreFile
import com.openai.models.vectorstores.files.VectorStoreFileDeleted
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class FileServiceImpl internal constructor(private val clientOptions: ClientOptions) : FileService {

    companion object {

        private val DEFAULT_HEADERS = Headers.builder().put("OpenAI-Beta", "assistants=v2").build()
    }

    private val withRawResponse: FileService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): FileService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): FileService =
        FileServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun create(params: FileCreateParams, requestOptions: RequestOptions): VectorStoreFile =
        // post /vector_stores/{vector_store_id}/files
        withRawResponse().create(params, requestOptions).parse()

    override fun retrieve(
        params: FileRetrieveParams,
        requestOptions: RequestOptions,
    ): VectorStoreFile =
        // get /vector_stores/{vector_store_id}/files/{file_id}
        withRawResponse().retrieve(params, requestOptions).parse()

    override fun update(params: FileUpdateParams, requestOptions: RequestOptions): VectorStoreFile =
        // post /vector_stores/{vector_store_id}/files/{file_id}
        withRawResponse().update(params, requestOptions).parse()

    override fun list(params: FileListParams, requestOptions: RequestOptions): FileListPage =
        // get /vector_stores/{vector_store_id}/files
        withRawResponse().list(params, requestOptions).parse()

    override fun delete(
        params: FileDeleteParams,
        requestOptions: RequestOptions,
    ): VectorStoreFileDeleted =
        // delete /vector_stores/{vector_store_id}/files/{file_id}
        withRawResponse().delete(params, requestOptions).parse()

    override fun content(
        params: FileContentParams,
        requestOptions: RequestOptions,
    ): FileContentPage =
        // get /vector_stores/{vector_store_id}/files/{file_id}/content
        withRawResponse().content(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        FileService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): FileService.WithRawResponse =
            FileServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val createHandler: Handler<VectorStoreFile> =
            jsonHandler<VectorStoreFile>(clientOptions.jsonMapper)

        override fun create(
            params: FileCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<VectorStoreFile> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("vectorStoreId", params.vectorStoreId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("vector_stores", params._pathParam(0), "files")
                    .putAllHeaders(DEFAULT_HEADERS)
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
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
            jsonHandler<VectorStoreFile>(clientOptions.jsonMapper)

        override fun retrieve(
            params: FileRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<VectorStoreFile> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("fileId", params.fileId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "vector_stores",
                        params._pathParam(0),
                        "files",
                        params._pathParam(1),
                    )
                    .putAllHeaders(DEFAULT_HEADERS)
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { retrieveHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val updateHandler: Handler<VectorStoreFile> =
            jsonHandler<VectorStoreFile>(clientOptions.jsonMapper)

        override fun update(
            params: FileUpdateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<VectorStoreFile> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("fileId", params.fileId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "vector_stores",
                        params._pathParam(0),
                        "files",
                        params._pathParam(1),
                    )
                    .putAllHeaders(DEFAULT_HEADERS)
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { updateHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val listHandler: Handler<FileListPageResponse> =
            jsonHandler<FileListPageResponse>(clientOptions.jsonMapper)

        override fun list(
            params: FileListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FileListPage> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("vectorStoreId", params.vectorStoreId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("vector_stores", params._pathParam(0), "files")
                    .putAllHeaders(DEFAULT_HEADERS)
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { listHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
                    .let {
                        FileListPage.builder()
                            .service(FileServiceImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }

        private val deleteHandler: Handler<VectorStoreFileDeleted> =
            jsonHandler<VectorStoreFileDeleted>(clientOptions.jsonMapper)

        override fun delete(
            params: FileDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<VectorStoreFileDeleted> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("fileId", params.fileId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "vector_stores",
                        params._pathParam(0),
                        "files",
                        params._pathParam(1),
                    )
                    .putAllHeaders(DEFAULT_HEADERS)
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { deleteHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val contentHandler: Handler<FileContentPageResponse> =
            jsonHandler<FileContentPageResponse>(clientOptions.jsonMapper)

        override fun content(
            params: FileContentParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FileContentPage> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("fileId", params.fileId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "vector_stores",
                        params._pathParam(0),
                        "files",
                        params._pathParam(1),
                        "content",
                    )
                    .putAllHeaders(DEFAULT_HEADERS)
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { contentHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
                    .let {
                        FileContentPage.builder()
                            .service(FileServiceImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }
    }
}
