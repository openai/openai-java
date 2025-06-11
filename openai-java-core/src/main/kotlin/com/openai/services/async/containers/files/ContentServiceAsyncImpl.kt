// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.containers.files

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.checkRequired
import com.openai.core.handlers.errorHandler
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse
import com.openai.core.http.HttpResponse.Handler
import com.openai.core.prepareAsync
import com.openai.models.ErrorObject
import com.openai.models.containers.files.content.ContentRetrieveParams
import java.util.concurrent.CompletableFuture
import kotlin.jvm.optionals.getOrNull

class ContentServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    ContentServiceAsync {

    private val withRawResponse: ContentServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): ContentServiceAsync.WithRawResponse = withRawResponse

    override fun retrieve(
        params: ContentRetrieveParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<HttpResponse> =
        // get /containers/{container_id}/files/{file_id}/content
        withRawResponse().retrieve(params, requestOptions)

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ContentServiceAsync.WithRawResponse {

        private val errorHandler: Handler<ErrorObject?> = errorHandler(clientOptions.jsonMapper)

        override fun retrieve(
            params: ContentRetrieveParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponse> {
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
                    .prepareAsync(clientOptions, params, deploymentModel = null)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request.thenComposeAsync {
                clientOptions.httpClient.executeAsync(it, requestOptions)
            }
        }
    }
}
