// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.uploads

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.handlers.errorHandler
import com.openai.core.handlers.jsonHandler
import com.openai.core.handlers.withErrorHandler
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse.Handler
import com.openai.core.http.HttpResponseFor
import com.openai.core.http.multipartFormData
import com.openai.core.http.parseable
import com.openai.core.prepareAsync
import com.openai.errors.OpenAIError
import com.openai.models.UploadPart
import com.openai.models.UploadPartCreateParams
import java.util.concurrent.CompletableFuture

class PartServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    PartServiceAsync {

    private val withRawResponse: PartServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): PartServiceAsync.WithRawResponse = withRawResponse

    override fun create(
        params: UploadPartCreateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<UploadPart> =
        // post /uploads/{upload_id}/parts
        withRawResponse().create(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        PartServiceAsync.WithRawResponse {

        private val errorHandler: Handler<OpenAIError> = errorHandler(clientOptions.jsonMapper)

        private val createHandler: Handler<UploadPart> =
            jsonHandler<UploadPart>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun create(
            params: UploadPartCreateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<UploadPart>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("uploads", params.getPathParam(0), "parts")
                    .body(multipartFormData(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params, deploymentModel = null)
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
    }
}
