// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.handlers.errorHandler
import com.openai.core.handlers.jsonHandler
import com.openai.core.handlers.withErrorHandler
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse.Handler
import com.openai.core.http.HttpResponseFor
import com.openai.core.http.json
import com.openai.core.http.parseable
import com.openai.core.prepare
import com.openai.models.ErrorObject
import com.openai.models.uploads.Upload
import com.openai.models.uploads.UploadCancelParams
import com.openai.models.uploads.UploadCompleteParams
import com.openai.models.uploads.UploadCreateParams
import com.openai.services.blocking.uploads.PartService
import com.openai.services.blocking.uploads.PartServiceImpl

class UploadServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    UploadService {

    private val withRawResponse: UploadService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val parts: PartService by lazy { PartServiceImpl(clientOptions) }

    override fun withRawResponse(): UploadService.WithRawResponse = withRawResponse

    override fun parts(): PartService = parts

    override fun create(params: UploadCreateParams, requestOptions: RequestOptions): Upload =
        // post /uploads
        withRawResponse().create(params, requestOptions).parse()

    override fun cancel(params: UploadCancelParams, requestOptions: RequestOptions): Upload =
        // post /uploads/{upload_id}/cancel
        withRawResponse().cancel(params, requestOptions).parse()

    override fun complete(params: UploadCompleteParams, requestOptions: RequestOptions): Upload =
        // post /uploads/{upload_id}/complete
        withRawResponse().complete(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        UploadService.WithRawResponse {

        private val errorHandler: Handler<ErrorObject?> = errorHandler(clientOptions.jsonMapper)

        private val parts: PartService.WithRawResponse by lazy {
            PartServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun parts(): PartService.WithRawResponse = parts

        private val createHandler: Handler<Upload> =
            jsonHandler<Upload>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun create(
            params: UploadCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Upload> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("uploads")
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

        private val cancelHandler: Handler<Upload> =
            jsonHandler<Upload>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun cancel(
            params: UploadCancelParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Upload> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("uploads", params._pathParam(0), "cancel")
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

        private val completeHandler: Handler<Upload> =
            jsonHandler<Upload>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun complete(
            params: UploadCompleteParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Upload> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("uploads", params._pathParam(0), "complete")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params, deploymentModel = null)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { completeHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
