// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.admin.organization.projects

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.SecurityOptions
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
import com.openai.core.prepare
import com.openai.models.admin.organization.projects.ratelimits.ProjectRateLimit
import com.openai.models.admin.organization.projects.ratelimits.RateLimitListRateLimitsPage
import com.openai.models.admin.organization.projects.ratelimits.RateLimitListRateLimitsPageResponse
import com.openai.models.admin.organization.projects.ratelimits.RateLimitListRateLimitsParams
import com.openai.models.admin.organization.projects.ratelimits.RateLimitUpdateRateLimitParams
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class RateLimitServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    RateLimitService {

    private val withRawResponse: RateLimitService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): RateLimitService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): RateLimitService =
        RateLimitServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun listRateLimits(
        params: RateLimitListRateLimitsParams,
        requestOptions: RequestOptions,
    ): RateLimitListRateLimitsPage =
        // get /organization/projects/{project_id}/rate_limits
        withRawResponse().listRateLimits(params, requestOptions).parse()

    override fun updateRateLimit(
        params: RateLimitUpdateRateLimitParams,
        requestOptions: RequestOptions,
    ): ProjectRateLimit =
        // post /organization/projects/{project_id}/rate_limits/{rate_limit_id}
        withRawResponse().updateRateLimit(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        RateLimitService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): RateLimitService.WithRawResponse =
            RateLimitServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val listRateLimitsHandler: Handler<RateLimitListRateLimitsPageResponse> =
            jsonHandler<RateLimitListRateLimitsPageResponse>(clientOptions.jsonMapper)

        override fun listRateLimits(
            params: RateLimitListRateLimitsParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<RateLimitListRateLimitsPage> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("projectId", params.projectId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "organization",
                        "projects",
                        params._pathParam(0),
                        "rate_limits",
                    )
                    .build()
                    .prepare(
                        clientOptions,
                        params,
                        SecurityOptions.builder().adminApiKeyAuth(true).build(),
                    )
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { listRateLimitsHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
                    .let {
                        RateLimitListRateLimitsPage.builder()
                            .service(RateLimitServiceImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }

        private val updateRateLimitHandler: Handler<ProjectRateLimit> =
            jsonHandler<ProjectRateLimit>(clientOptions.jsonMapper)

        override fun updateRateLimit(
            params: RateLimitUpdateRateLimitParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ProjectRateLimit> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("rateLimitId", params.rateLimitId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "organization",
                        "projects",
                        params._pathParam(0),
                        "rate_limits",
                        params._pathParam(1),
                    )
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(
                        clientOptions,
                        params,
                        SecurityOptions.builder().adminApiKeyAuth(true).build(),
                    )
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { updateRateLimitHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
