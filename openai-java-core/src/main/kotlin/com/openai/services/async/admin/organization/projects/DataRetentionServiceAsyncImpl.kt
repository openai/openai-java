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
import com.openai.models.admin.organization.projects.dataretention.DataRetentionRetrieveParams
import com.openai.models.admin.organization.projects.dataretention.DataRetentionUpdateParams
import com.openai.models.admin.organization.projects.dataretention.ProjectDataRetention
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class DataRetentionServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    DataRetentionServiceAsync {

    private val withRawResponse: DataRetentionServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): DataRetentionServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): DataRetentionServiceAsync =
        DataRetentionServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun retrieve(
        params: DataRetentionRetrieveParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<ProjectDataRetention> =
        // get /organization/projects/{project_id}/data_retention
        withRawResponse().retrieve(params, requestOptions).thenApplyPropagatingCancellation {
            it.parse()
        }

    override fun update(
        params: DataRetentionUpdateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<ProjectDataRetention> =
        // post /organization/projects/{project_id}/data_retention
        withRawResponse().update(params, requestOptions).thenApplyPropagatingCancellation {
            it.parse()
        }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        DataRetentionServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): DataRetentionServiceAsync.WithRawResponse =
            DataRetentionServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val retrieveHandler: Handler<ProjectDataRetention> =
            jsonHandler<ProjectDataRetention>(clientOptions.jsonMapper)

        override fun retrieve(
            params: DataRetentionRetrieveParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ProjectDataRetention>> {
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
                        "data_retention",
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
                            .use { retrieveHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val updateHandler: Handler<ProjectDataRetention> =
            jsonHandler<ProjectDataRetention>(clientOptions.jsonMapper)

        override fun update(
            params: DataRetentionUpdateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ProjectDataRetention>> {
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
                        "data_retention",
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
    }
}
