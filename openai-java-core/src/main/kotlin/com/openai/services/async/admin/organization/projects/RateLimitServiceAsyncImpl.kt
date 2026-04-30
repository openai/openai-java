// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.admin.organization.projects

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
import com.openai.core.prepareAsync
import com.openai.models.admin.organization.projects.ratelimits.ProjectRateLimit
import com.openai.models.admin.organization.projects.ratelimits.RateLimitListRateLimitsPageAsync
import com.openai.models.admin.organization.projects.ratelimits.RateLimitListRateLimitsPageResponse
import com.openai.models.admin.organization.projects.ratelimits.RateLimitListRateLimitsParams
import com.openai.models.admin.organization.projects.ratelimits.RateLimitUpdateRateLimitParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class RateLimitServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    RateLimitServiceAsync {

    private val withRawResponse: RateLimitServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): RateLimitServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): RateLimitServiceAsync =
        RateLimitServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun listRateLimits(
        params: RateLimitListRateLimitsParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<RateLimitListRateLimitsPageAsync> =
        // get /organization/projects/{project_id}/rate_limits
        withRawResponse().listRateLimits(params, requestOptions).thenApply { it.parse() }

    override fun updateRateLimit(
        params: RateLimitUpdateRateLimitParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<ProjectRateLimit> =
        // post /organization/projects/{project_id}/rate_limits/{rate_limit_id}
        withRawResponse().updateRateLimit(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        RateLimitServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): RateLimitServiceAsync.WithRawResponse =
            RateLimitServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val listRateLimitsHandler: Handler<RateLimitListRateLimitsPageResponse> =
            jsonHandler<RateLimitListRateLimitsPageResponse>(clientOptions.jsonMapper)

        override fun listRateLimits(
            params: RateLimitListRateLimitsParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<RateLimitListRateLimitsPageAsync>> {
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
                    .prepareAsync(
                        clientOptions,
                        params,
                        SecurityOptions.builder().adminApiKeyAuth(true).build(),
                    )
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { listRateLimitsHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                            .let {
                                RateLimitListRateLimitsPageAsync.builder()
                                    .service(RateLimitServiceAsyncImpl(clientOptions))
                                    .streamHandlerExecutor(clientOptions.streamHandlerExecutor)
                                    .params(params)
                                    .response(it)
                                    .build()
                            }
                    }
                }
        }

        private val updateRateLimitHandler: Handler<ProjectRateLimit> =
            jsonHandler<ProjectRateLimit>(clientOptions.jsonMapper)

        override fun updateRateLimit(
            params: RateLimitUpdateRateLimitParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ProjectRateLimit>> {
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
                    .prepareAsync(
                        clientOptions,
                        params,
                        SecurityOptions.builder().adminApiKeyAuth(true).build(),
                    )
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
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
}
