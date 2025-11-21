// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.uploads

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
import com.openai.core.http.multipartFormData
import com.openai.core.http.parseable
import com.openai.core.prepareAsync
import com.openai.models.uploads.parts.PartCreateParams
import com.openai.models.uploads.parts.UploadPart
import com.openai.core.http.CancellationTokenSource
import com.openai.core.withCancellation
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class PartServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    PartServiceAsync {

    private val withRawResponse: PartServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): PartServiceAsync.WithRawResponse = withRawResponse


    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): PartServiceAsync =
        PartServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun create(
        params: PartCreateParams,
        requestOptions: RequestOptions,
        PartServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun create(
        params: PartCreateParams,
        requestOptions: RequestOptions,
        params: PartCreateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<UploadPart> =
        // post /uploads/{upload_id}/parts
        withRawResponse().create(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        PartServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            val cancellationTokenSource = CancellationTokenSource()
            modifier: Consumer<ClientOptions.Builder>
        ): PartServiceAsync.WithRawResponse =
            PartServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val createHandler: Handler<UploadPart> =
            jsonHandler<UploadPart>(clientOptions.jsonMapper)

        override fun create(
            params: PartCreateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<UploadPart>> {
            val cancellationTokenSource = CancellationTokenSource()
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("uploadId", params.uploadId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("uploads", params._pathParam(0), "parts")
                    .body(multipartFormData(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return
                    request
                        .thenComposeAsync {
                            clientOptions.httpClient.executeAsync(
                                it,
                                requestOptions,
                                cancellationTokenSource.token()
                            )
                        }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { createHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }

            .withCancellation(cancellationTokenSource)
                            }
                    }
                }
        }
    }
}
