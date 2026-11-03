// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.async.admin.organization

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
import com.openai.models.admin.organization.workloadidentityproviders.WorkloadIdentityProvider
import com.openai.models.admin.organization.workloadidentityproviders.WorkloadIdentityProviderCreateParams
import com.openai.models.admin.organization.workloadidentityproviders.WorkloadIdentityProviderDeleteParams
import com.openai.models.admin.organization.workloadidentityproviders.WorkloadIdentityProviderDeleted
import com.openai.models.admin.organization.workloadidentityproviders.WorkloadIdentityProviderListPageAsync
import com.openai.models.admin.organization.workloadidentityproviders.WorkloadIdentityProviderListPageResponse
import com.openai.models.admin.organization.workloadidentityproviders.WorkloadIdentityProviderListParams
import com.openai.models.admin.organization.workloadidentityproviders.WorkloadIdentityProviderRetrieveParams
import com.openai.models.admin.organization.workloadidentityproviders.WorkloadIdentityProviderUpdateParams
import com.openai.services.async.admin.organization.workloadidentityproviders.FederationRuleServiceAsync
import com.openai.services.async.admin.organization.workloadidentityproviders.FederationRuleServiceAsyncImpl
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class WorkloadIdentityProviderServiceAsyncImpl
internal constructor(private val clientOptions: ClientOptions) :
    WorkloadIdentityProviderServiceAsync {

    private val withRawResponse: WorkloadIdentityProviderServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val federationRules: FederationRuleServiceAsync by lazy {
        FederationRuleServiceAsyncImpl(clientOptions)
    }

    override fun withRawResponse(): WorkloadIdentityProviderServiceAsync.WithRawResponse =
        withRawResponse

    override fun withOptions(
        modifier: Consumer<ClientOptions.Builder>
    ): WorkloadIdentityProviderServiceAsync =
        WorkloadIdentityProviderServiceAsyncImpl(
            clientOptions.toBuilder().apply(modifier::accept).build()
        )

    override fun federationRules(): FederationRuleServiceAsync = federationRules

    override fun create(
        params: WorkloadIdentityProviderCreateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<WorkloadIdentityProvider> =
        // post /organization/workload_identity_providers
        withRawResponse().create(params, requestOptions).thenApply { it.parse() }

    override fun retrieve(
        params: WorkloadIdentityProviderRetrieveParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<WorkloadIdentityProvider> =
        // get /organization/workload_identity_providers/{workload_identity_provider_id}
        withRawResponse().retrieve(params, requestOptions).thenApply { it.parse() }

    override fun update(
        params: WorkloadIdentityProviderUpdateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<WorkloadIdentityProvider> =
        // post /organization/workload_identity_providers/{workload_identity_provider_id}
        withRawResponse().update(params, requestOptions).thenApply { it.parse() }

    override fun list(
        params: WorkloadIdentityProviderListParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<WorkloadIdentityProviderListPageAsync> =
        // get /organization/workload_identity_providers
        withRawResponse().list(params, requestOptions).thenApply { it.parse() }

    override fun delete(
        params: WorkloadIdentityProviderDeleteParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<WorkloadIdentityProviderDeleted> =
        // delete /organization/workload_identity_providers/{workload_identity_provider_id}
        withRawResponse().delete(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        WorkloadIdentityProviderServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        private val federationRules: FederationRuleServiceAsync.WithRawResponse by lazy {
            FederationRuleServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): WorkloadIdentityProviderServiceAsync.WithRawResponse =
            WorkloadIdentityProviderServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun federationRules(): FederationRuleServiceAsync.WithRawResponse = federationRules

        private val createHandler: Handler<WorkloadIdentityProvider> =
            jsonHandler<WorkloadIdentityProvider>(clientOptions.jsonMapper)

        override fun create(
            params: WorkloadIdentityProviderCreateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<WorkloadIdentityProvider>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("organization", "workload_identity_providers")
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
                            .use { createHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val retrieveHandler: Handler<WorkloadIdentityProvider> =
            jsonHandler<WorkloadIdentityProvider>(clientOptions.jsonMapper)

        override fun retrieve(
            params: WorkloadIdentityProviderRetrieveParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<WorkloadIdentityProvider>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired(
                "workloadIdentityProviderId",
                params.workloadIdentityProviderId().getOrNull(),
            )
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "organization",
                        "workload_identity_providers",
                        params._pathParam(0),
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
                            .use { retrieveHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val updateHandler: Handler<WorkloadIdentityProvider> =
            jsonHandler<WorkloadIdentityProvider>(clientOptions.jsonMapper)

        override fun update(
            params: WorkloadIdentityProviderUpdateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<WorkloadIdentityProvider>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired(
                "workloadIdentityProviderId",
                params.workloadIdentityProviderId().getOrNull(),
            )
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "organization",
                        "workload_identity_providers",
                        params._pathParam(0),
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
                            .use { updateHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val listHandler: Handler<WorkloadIdentityProviderListPageResponse> =
            jsonHandler<WorkloadIdentityProviderListPageResponse>(clientOptions.jsonMapper)

        override fun list(
            params: WorkloadIdentityProviderListParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<WorkloadIdentityProviderListPageAsync>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("organization", "workload_identity_providers")
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
                            .use { listHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                            .let {
                                WorkloadIdentityProviderListPageAsync.builder()
                                    .service(
                                        WorkloadIdentityProviderServiceAsyncImpl(clientOptions)
                                    )
                                    .streamHandlerExecutor(clientOptions.streamHandlerExecutor)
                                    .params(params)
                                    .response(it)
                                    .build()
                            }
                    }
                }
        }

        private val deleteHandler: Handler<WorkloadIdentityProviderDeleted> =
            jsonHandler<WorkloadIdentityProviderDeleted>(clientOptions.jsonMapper)

        override fun delete(
            params: WorkloadIdentityProviderDeleteParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<WorkloadIdentityProviderDeleted>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired(
                "workloadIdentityProviderId",
                params.workloadIdentityProviderId().getOrNull(),
            )
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "organization",
                        "workload_identity_providers",
                        params._pathParam(0),
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
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
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
