// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.containers.files

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.checkRequired
import com.openai.core.handlers.emptyHandler
import com.openai.core.handlers.errorHandler
import com.openai.core.handlers.withErrorHandler
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse
import com.openai.core.http.HttpResponse.Handler
import com.openai.core.http.parseable
import com.openai.core.prepare
import com.openai.models.ErrorObject
import com.openai.models.containers.files.content.ContentRetrieveParams
import kotlin.jvm.optionals.getOrNull

class ContentServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    ContentService {

    private val withRawResponse: ContentService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): ContentService.WithRawResponse = withRawResponse

    override fun retrieve(params: ContentRetrieveParams, requestOptions: RequestOptions) {
        // get /containers/{container_id}/files/{file_id}/content
        withRawResponse().retrieve(params, requestOptions)
    }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ContentService.WithRawResponse {

        private val errorHandler: Handler<ErrorObject?> = errorHandler(clientOptions.jsonMapper)

        private val retrieveHandler: Handler<Void?> = emptyHandler().withErrorHandler(errorHandler)

        override fun retrieve(
            params: ContentRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponse {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("fileId", params.fileId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments(
                        "containers",
                        params._pathParam(0),
                        "files",
                        params._pathParam(1),
                        "content",
                    )
                    .build()
                    .prepare(clientOptions, params, deploymentModel = null)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable { response.use { retrieveHandler.handle(it) } }
        }
    }
}
