// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.checkRequired
import com.openai.core.handlers.errorBodyHandler
import com.openai.core.handlers.errorHandler
import com.openai.core.handlers.jsonHandler
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse
import com.openai.core.http.HttpResponse.Handler
import com.openai.core.http.HttpResponseFor
import com.openai.core.http.json
import com.openai.core.http.parseable
import com.openai.core.prepareAsync
import com.openai.models.uploads.Upload
import com.openai.models.uploads.UploadCancelParams
import com.openai.models.uploads.UploadCompleteParams
import com.openai.models.uploads.UploadCreateParams
import com.openai.services.async.uploads.PartServiceAsync
import com.openai.services.async.uploads.PartServiceAsyncImpl
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class UploadServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    UploadServiceAsync {

    private val withRawResponse: UploadServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val parts: PartServiceAsync by lazy { PartServiceAsyncImpl(clientOptions) }

    override fun withRawResponse(): UploadServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): UploadServiceAsync =
        UploadServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun parts(): PartServiceAsync = parts

    override fun create(
        params: UploadCreateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<Upload> =
        // post /uploads
        withRawResponse().create(params, requestOptions).thenApply { it.parse() }

    override fun cancel(
        params: UploadCancelParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<Upload> =
        // post /uploads/{upload_id}/cancel
        withRawResponse().cancel(params, requestOptions).thenApply { it.parse() }

    override fun complete(
        params: UploadCompleteParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<Upload> =
        // post /uploads/{upload_id}/complete
        withRawResponse().complete(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        UploadServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        private val parts: PartServiceAsync.WithRawResponse by lazy {
            PartServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): UploadServiceAsync.WithRawResponse =
            UploadServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun parts(): PartServiceAsync.WithRawResponse = parts

        private val createHandler: Handler<Upload> = jsonHandler<Upload>(clientOptions.jsonMapper)

        override fun create(
            params: UploadCreateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Upload>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("uploads")
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

        private val cancelHandler: Handler<Upload> = jsonHandler<Upload>(clientOptions.jsonMapper)

        override fun cancel(
            params: UploadCancelParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Upload>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("uploadId", params.uploadId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("uploads", params._pathParam(0), "cancel")
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepareAsync(clientOptions, params, deploymentModel = null)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { cancelHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val completeHandler: Handler<Upload> = jsonHandler<Upload>(clientOptions.jsonMapper)

        override fun complete(
            params: UploadCompleteParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Upload>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("uploadId", params.uploadId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("uploads", params._pathParam(0), "complete")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params, deploymentModel = null)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
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
}
