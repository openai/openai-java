// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
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
import com.openai.core.prepare
import com.openai.errors.OpenAIError
import com.openai.models.files.FileContentParams
import com.openai.models.files.FileCreateParams
import com.openai.models.files.FileDeleteParams
import com.openai.models.files.FileDeleted
import com.openai.models.files.FileListPage
import com.openai.models.files.FileListParams
import com.openai.models.files.FileObject
import com.openai.models.files.FileRetrieveParams

class FileServiceImpl internal constructor(private val clientOptions: ClientOptions) : FileService {

    private val withRawResponse: FileService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): FileService.WithRawResponse = withRawResponse

    override fun create(params: FileCreateParams, requestOptions: RequestOptions): FileObject =
        // post /files
        withRawResponse().create(params, requestOptions).parse()

    override fun retrieve(params: FileRetrieveParams, requestOptions: RequestOptions): FileObject =
        // get /files/{file_id}
        withRawResponse().retrieve(params, requestOptions).parse()

    override fun list(params: FileListParams, requestOptions: RequestOptions): FileListPage =
        // get /files
        withRawResponse().list(params, requestOptions).parse()

    override fun delete(params: FileDeleteParams, requestOptions: RequestOptions): FileDeleted =
        // delete /files/{file_id}
        withRawResponse().delete(params, requestOptions).parse()

    override fun content(params: FileContentParams, requestOptions: RequestOptions): HttpResponse =
        // get /files/{file_id}/content
        withRawResponse().content(params, requestOptions)

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        FileService.WithRawResponse {

        private val errorHandler: Handler<OpenAIError> = errorHandler(clientOptions.jsonMapper)

        private val createHandler: Handler<FileObject> =
            jsonHandler<FileObject>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun create(
            params: FileCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FileObject> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("files")
                    .body(multipartFormData(clientOptions.jsonMapper, params._body()))
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

        private val retrieveHandler: Handler<FileObject> =
            jsonHandler<FileObject>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun retrieve(
            params: FileRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FileObject> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("files", params._pathParam(0))
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

        private val listHandler: Handler<FileListPage.Response> =
            jsonHandler<FileListPage.Response>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun list(
            params: FileListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FileListPage> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("files")
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
                    .let { FileListPage.of(FileServiceImpl(clientOptions), params, it) }
            }
        }

        private val deleteHandler: Handler<FileDeleted> =
            jsonHandler<FileDeleted>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun delete(
            params: FileDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FileDeleted> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .addPathSegments("files", params._pathParam(0))
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

        override fun content(
            params: FileContentParams,
            requestOptions: RequestOptions,
        ): HttpResponse {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("files", params._pathParam(0), "content")
                    .build()
                    .prepare(clientOptions, params, deploymentModel = null)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return clientOptions.httpClient.execute(request, requestOptions)
        }
    }
}
