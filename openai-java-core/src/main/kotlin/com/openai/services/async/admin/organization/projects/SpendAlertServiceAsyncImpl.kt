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
import com.openai.core.thenApplyPropagatingCancellation
import com.openai.core.thenComposeAsyncPropagatingCancellation
import com.openai.models.admin.organization.projects.spendalerts.ProjectSpendAlert
import com.openai.models.admin.organization.projects.spendalerts.ProjectSpendAlertDeleted
import com.openai.models.admin.organization.projects.spendalerts.SpendAlertCreateParams
import com.openai.models.admin.organization.projects.spendalerts.SpendAlertDeleteParams
import com.openai.models.admin.organization.projects.spendalerts.SpendAlertListPageAsync
import com.openai.models.admin.organization.projects.spendalerts.SpendAlertListPageResponse
import com.openai.models.admin.organization.projects.spendalerts.SpendAlertListParams
import com.openai.models.admin.organization.projects.spendalerts.SpendAlertUpdateParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class SpendAlertServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    SpendAlertServiceAsync {

    private val withRawResponse: SpendAlertServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): SpendAlertServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): SpendAlertServiceAsync =
        SpendAlertServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun create(
        params: SpendAlertCreateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<ProjectSpendAlert> =
        // post /organization/projects/{project_id}/spend_alerts
        withRawResponse().create(params, requestOptions).thenApplyPropagatingCancellation {
            it.parse()
        }

    override fun update(
        params: SpendAlertUpdateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<ProjectSpendAlert> =
        // post /organization/projects/{project_id}/spend_alerts/{alert_id}
        withRawResponse().update(params, requestOptions).thenApplyPropagatingCancellation {
            it.parse()
        }

    override fun list(
        params: SpendAlertListParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<SpendAlertListPageAsync> =
        // get /organization/projects/{project_id}/spend_alerts
        withRawResponse().list(params, requestOptions).thenApplyPropagatingCancellation {
            it.parse()
        }

    override fun delete(
        params: SpendAlertDeleteParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<ProjectSpendAlertDeleted> =
        // delete /organization/projects/{project_id}/spend_alerts/{alert_id}
        withRawResponse().delete(params, requestOptions).thenApplyPropagatingCancellation {
            it.parse()
        }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        SpendAlertServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): SpendAlertServiceAsync.WithRawResponse =
            SpendAlertServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val createHandler: Handler<ProjectSpendAlert> =
            jsonHandler<ProjectSpendAlert>(clientOptions.jsonMapper)

        override fun create(
            params: SpendAlertCreateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ProjectSpendAlert>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("projectId", params.projectId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "organization",
                        "projects",
                        params._pathParam(0),
                        "spend_alerts",
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
                .thenComposeAsyncPropagatingCancellation {
                    clientOptions.httpClient.executeAsync(it, requestOptions)
                }
                .thenApplyPropagatingCancellation { response ->
                    errorHandler.handle(response).parseable {
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

        private val updateHandler: Handler<ProjectSpendAlert> =
            jsonHandler<ProjectSpendAlert>(clientOptions.jsonMapper)

        override fun update(
            params: SpendAlertUpdateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ProjectSpendAlert>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("alertId", params.alertId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "organization",
                        "projects",
                        params._pathParam(0),
                        "spend_alerts",
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
                .thenComposeAsyncPropagatingCancellation {
                    clientOptions.httpClient.executeAsync(it, requestOptions)
                }
                .thenApplyPropagatingCancellation { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { updateHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val listHandler: Handler<SpendAlertListPageResponse> =
            jsonHandler<SpendAlertListPageResponse>(clientOptions.jsonMapper)

        override fun list(
            params: SpendAlertListParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<SpendAlertListPageAsync>> {
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
                        "spend_alerts",
                    )
                    .build()
                    .prepareAsync(
                        clientOptions,
                        params,
                        SecurityOptions.builder().adminApiKeyAuth(true).build(),
                    )
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsyncPropagatingCancellation {
                    clientOptions.httpClient.executeAsync(it, requestOptions)
                }
                .thenApplyPropagatingCancellation { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { listHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                            .let {
                                SpendAlertListPageAsync.builder()
                                    .service(SpendAlertServiceAsyncImpl(clientOptions))
                                    .streamHandlerExecutor(clientOptions.streamHandlerExecutor)
                                    .params(params)
                                    .response(it)
                                    .build()
                            }
                    }
                }
        }

        private val deleteHandler: Handler<ProjectSpendAlertDeleted> =
            jsonHandler<ProjectSpendAlertDeleted>(clientOptions.jsonMapper)

        override fun delete(
            params: SpendAlertDeleteParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ProjectSpendAlertDeleted>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("alertId", params.alertId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "organization",
                        "projects",
                        params._pathParam(0),
                        "spend_alerts",
                        params._pathParam(1),
                    )
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepareAsync(
                        clientOptions,
                        params,
                        SecurityOptions.builder().adminApiKeyAuth(true).build(),
                    )
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsyncPropagatingCancellation {
                    clientOptions.httpClient.executeAsync(it, requestOptions)
                }
                .thenApplyPropagatingCancellation { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { deleteHandler.handle(it) }
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
