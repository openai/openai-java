// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.containers.files

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.checkRequired
import com.openai.core.handlers.errorBodyHandler
import com.openai.core.handlers.errorHandler
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse
import com.openai.core.http.HttpResponse.Handler
import com.openai.core.prepareAsync
import com.openai.models.containers.files.content.ContentRetrieveParams
import com.openai.core.http.CancellationTokenSource
import com.openai.core.withCancellation
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class ContentServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    ContentServiceAsync {

    private val withRawResponse: ContentServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): ContentServiceAsync.WithRawResponse = withRawResponse


    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): ContentServiceAsync =
        ContentServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun retrieve(
        params: ContentRetrieveParams,
        requestOptions: RequestOptions,
        ContentServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun retrieve(
        params: ContentRetrieveParams,
        requestOptions: RequestOptions,
        params: ContentRetrieveParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<HttpResponse> =
        // get /containers/{container_id}/files/{file_id}/content
        withRawResponse().retrieve(params, requestOptions)

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ContentServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            val cancellationTokenSource = CancellationTokenSource()
            modifier: Consumer<ClientOptions.Builder>
        ): ContentServiceAsync.WithRawResponse =
            ContentServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun retrieve(
            params: ContentRetrieveParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponse> {
            val cancellationTokenSource = CancellationTokenSource()
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("fileId", params.fileId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "containers",
                        params._pathParam(0),
                        "files",
                        params._pathParam(1),
                        "content",
                    )
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val delegate =
                    request
                        .thenComposeAsync {
                            clientOptions.httpClient.executeAsync(
                                it,
                                requestOptions,
                                cancellationTokenSource.token()
                            )
                        }
                .thenApply { response -> errorHandler.handle(response) }
        }
    return delegate.withCancellation(cancellationTokenSource)
    }
}
