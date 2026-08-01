// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.SecurityOptions
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
import com.openai.core.prepare
import com.openai.models.contentprovenancechecks.ContentProvenanceCheck
import com.openai.models.contentprovenancechecks.ContentProvenanceCheckCreateParams
import java.util.function.Consumer

class ContentProvenanceCheckServiceImpl
internal constructor(private val clientOptions: ClientOptions) : ContentProvenanceCheckService {

    private val withRawResponse: ContentProvenanceCheckService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): ContentProvenanceCheckService.WithRawResponse = withRawResponse

    override fun withOptions(
        modifier: Consumer<ClientOptions.Builder>
    ): ContentProvenanceCheckService =
        ContentProvenanceCheckServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun create(
        params: ContentProvenanceCheckCreateParams,
        requestOptions: RequestOptions,
    ): ContentProvenanceCheck =
        // post /content_provenance_checks
        withRawResponse().create(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ContentProvenanceCheckService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ContentProvenanceCheckService.WithRawResponse =
            ContentProvenanceCheckServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val createHandler: Handler<ContentProvenanceCheck> =
            jsonHandler<ContentProvenanceCheck>(clientOptions.jsonMapper)

        override fun create(
            params: ContentProvenanceCheckCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ContentProvenanceCheck> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("content_provenance_checks")
                    .body(multipartFormData(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(
                        clientOptions,
                        params,
                        SecurityOptions.builder().bearerAuth(true).build(),
                    )
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
    }
}
