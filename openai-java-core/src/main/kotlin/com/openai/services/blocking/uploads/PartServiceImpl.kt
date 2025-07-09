// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.uploads

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.checkRequired
import com.openai.core.handlers.errorHandler
import com.openai.core.handlers.jsonHandler
import com.openai.core.handlers.withErrorHandler
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse.Handler
import com.openai.core.http.HttpResponseFor
import com.openai.core.http.multipartFormData
import com.openai.core.http.parseable
import com.openai.core.prepare
import com.openai.models.ErrorObject
import com.openai.models.uploads.parts.PartCreateParams
import com.openai.models.uploads.parts.UploadPart
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class PartServiceImpl internal constructor(private val clientOptions: ClientOptions) : PartService {

    private val withRawResponse: PartService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): PartService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): PartService =
        PartServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun create(params: PartCreateParams, requestOptions: RequestOptions): UploadPart =
        // post /uploads/{upload_id}/parts
        withRawResponse().create(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        PartService.WithRawResponse {

        private val errorHandler: Handler<ErrorObject?> = errorHandler(clientOptions.jsonMapper)

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): PartService.WithRawResponse =
            PartServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val createHandler: Handler<UploadPart> =
            jsonHandler<UploadPart>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun create(
            params: PartCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<UploadPart> {
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
    }
}
