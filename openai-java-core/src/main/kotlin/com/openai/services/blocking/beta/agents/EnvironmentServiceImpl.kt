// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.blocking.beta.agents

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.SecurityOptions
import com.openai.core.checkRequired
import com.openai.core.handlers.errorBodyHandler
import com.openai.core.handlers.errorHandler
import com.openai.core.handlers.jsonHandler
import com.openai.core.http.Headers
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse
import com.openai.core.http.HttpResponse.Handler
import com.openai.core.http.HttpResponseFor
import com.openai.core.http.json
import com.openai.core.http.parseable
import com.openai.core.prepare
import com.openai.models.beta.agents.environments.EnvironmentCreateParams
import com.openai.models.beta.agents.environments.EnvironmentInfo
import com.openai.models.beta.agents.environments.EnvironmentListPage
import com.openai.models.beta.agents.environments.EnvironmentListPageResponse
import com.openai.models.beta.agents.environments.EnvironmentListParams
import com.openai.models.beta.agents.environments.EnvironmentRetrieveParams
import com.openai.services.blocking.beta.agents.environments.FileService
import com.openai.services.blocking.beta.agents.environments.FileServiceImpl
import com.openai.services.blocking.beta.agents.environments.TemplateService
import com.openai.services.blocking.beta.agents.environments.TemplateServiceImpl
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class EnvironmentServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    EnvironmentService {

    companion object {

        private val DEFAULT_HEADERS = Headers.builder().put("OpenAI-Beta", "agents=v1").build()
    }

    private val withRawResponse: EnvironmentService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val files: FileService by lazy { FileServiceImpl(clientOptions) }

    private val templates: TemplateService by lazy { TemplateServiceImpl(clientOptions) }

    override fun withRawResponse(): EnvironmentService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): EnvironmentService =
        EnvironmentServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun files(): FileService = files

    override fun templates(): TemplateService = templates

    override fun create(
        params: EnvironmentCreateParams,
        requestOptions: RequestOptions,
    ): EnvironmentInfo =
        // post /agents/environments
        withRawResponse().create(params, requestOptions).parse()

    override fun retrieve(
        params: EnvironmentRetrieveParams,
        requestOptions: RequestOptions,
    ): EnvironmentInfo =
        // get /agents/environments/{environment_id}
        withRawResponse().retrieve(params, requestOptions).parse()

    override fun list(
        params: EnvironmentListParams,
        requestOptions: RequestOptions,
    ): EnvironmentListPage =
        // get /agents/environments
        withRawResponse().list(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        EnvironmentService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        private val files: FileService.WithRawResponse by lazy {
            FileServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val templates: TemplateService.WithRawResponse by lazy {
            TemplateServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): EnvironmentService.WithRawResponse =
            EnvironmentServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun files(): FileService.WithRawResponse = files

        override fun templates(): TemplateService.WithRawResponse = templates

        private val createHandler: Handler<EnvironmentInfo> =
            jsonHandler<EnvironmentInfo>(clientOptions.jsonMapper)

        override fun create(
            params: EnvironmentCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<EnvironmentInfo> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("agents", "environments")
                    .putAllHeaders(DEFAULT_HEADERS)
                    .body(json(clientOptions.jsonMapper, params._body()))
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

        private val retrieveHandler: Handler<EnvironmentInfo> =
            jsonHandler<EnvironmentInfo>(clientOptions.jsonMapper)

        override fun retrieve(
            params: EnvironmentRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<EnvironmentInfo> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("environmentId", params.environmentId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("agents", "environments", params._pathParam(0))
                    .putAllHeaders(DEFAULT_HEADERS)
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
                    .use { retrieveHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val listHandler: Handler<EnvironmentListPageResponse> =
            jsonHandler<EnvironmentListPageResponse>(clientOptions.jsonMapper)

        override fun list(
            params: EnvironmentListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<EnvironmentListPage> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("agents", "environments")
                    .putAllHeaders(DEFAULT_HEADERS)
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
                    .use { listHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
                    .let {
                        EnvironmentListPage.builder()
                            .service(EnvironmentServiceImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }
    }
}
