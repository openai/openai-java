// File generated from our OpenAPI spec by Stainless.

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
import com.openai.models.admin.organization.projects.Project
import com.openai.models.admin.organization.projects.ProjectArchiveParams
import com.openai.models.admin.organization.projects.ProjectCreateParams
import com.openai.models.admin.organization.projects.ProjectListPageAsync
import com.openai.models.admin.organization.projects.ProjectListPageResponse
import com.openai.models.admin.organization.projects.ProjectListParams
import com.openai.models.admin.organization.projects.ProjectRetrieveParams
import com.openai.models.admin.organization.projects.ProjectUpdateParams
import com.openai.services.async.admin.organization.projects.ApiKeyServiceAsync
import com.openai.services.async.admin.organization.projects.ApiKeyServiceAsyncImpl
import com.openai.services.async.admin.organization.projects.CertificateServiceAsync
import com.openai.services.async.admin.organization.projects.CertificateServiceAsyncImpl
import com.openai.services.async.admin.organization.projects.GroupServiceAsync
import com.openai.services.async.admin.organization.projects.GroupServiceAsyncImpl
import com.openai.services.async.admin.organization.projects.RateLimitServiceAsync
import com.openai.services.async.admin.organization.projects.RateLimitServiceAsyncImpl
import com.openai.services.async.admin.organization.projects.RoleServiceAsync
import com.openai.services.async.admin.organization.projects.RoleServiceAsyncImpl
import com.openai.services.async.admin.organization.projects.ServiceAccountServiceAsync
import com.openai.services.async.admin.organization.projects.ServiceAccountServiceAsyncImpl
import com.openai.services.async.admin.organization.projects.UserServiceAsync
import com.openai.services.async.admin.organization.projects.UserServiceAsyncImpl
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class ProjectServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    ProjectServiceAsync {

    private val withRawResponse: ProjectServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val users: UserServiceAsync by lazy { UserServiceAsyncImpl(clientOptions) }

    private val serviceAccounts: ServiceAccountServiceAsync by lazy {
        ServiceAccountServiceAsyncImpl(clientOptions)
    }

    private val apiKeys: ApiKeyServiceAsync by lazy { ApiKeyServiceAsyncImpl(clientOptions) }

    private val rateLimits: RateLimitServiceAsync by lazy {
        RateLimitServiceAsyncImpl(clientOptions)
    }

    private val groups: GroupServiceAsync by lazy { GroupServiceAsyncImpl(clientOptions) }

    private val roles: RoleServiceAsync by lazy { RoleServiceAsyncImpl(clientOptions) }

    private val certificates: CertificateServiceAsync by lazy {
        CertificateServiceAsyncImpl(clientOptions)
    }

    override fun withRawResponse(): ProjectServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): ProjectServiceAsync =
        ProjectServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun users(): UserServiceAsync = users

    override fun serviceAccounts(): ServiceAccountServiceAsync = serviceAccounts

    override fun apiKeys(): ApiKeyServiceAsync = apiKeys

    override fun rateLimits(): RateLimitServiceAsync = rateLimits

    override fun groups(): GroupServiceAsync = groups

    override fun roles(): RoleServiceAsync = roles

    override fun certificates(): CertificateServiceAsync = certificates

    override fun create(
        params: ProjectCreateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<Project> =
        // post /organization/projects
        withRawResponse().create(params, requestOptions).thenApply { it.parse() }

    override fun retrieve(
        params: ProjectRetrieveParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<Project> =
        // get /organization/projects/{project_id}
        withRawResponse().retrieve(params, requestOptions).thenApply { it.parse() }

    override fun update(
        params: ProjectUpdateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<Project> =
        // post /organization/projects/{project_id}
        withRawResponse().update(params, requestOptions).thenApply { it.parse() }

    override fun list(
        params: ProjectListParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<ProjectListPageAsync> =
        // get /organization/projects
        withRawResponse().list(params, requestOptions).thenApply { it.parse() }

    override fun archive(
        params: ProjectArchiveParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<Project> =
        // post /organization/projects/{project_id}/archive
        withRawResponse().archive(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ProjectServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        private val users: UserServiceAsync.WithRawResponse by lazy {
            UserServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val serviceAccounts: ServiceAccountServiceAsync.WithRawResponse by lazy {
            ServiceAccountServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val apiKeys: ApiKeyServiceAsync.WithRawResponse by lazy {
            ApiKeyServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val rateLimits: RateLimitServiceAsync.WithRawResponse by lazy {
            RateLimitServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val groups: GroupServiceAsync.WithRawResponse by lazy {
            GroupServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val roles: RoleServiceAsync.WithRawResponse by lazy {
            RoleServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val certificates: CertificateServiceAsync.WithRawResponse by lazy {
            CertificateServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ProjectServiceAsync.WithRawResponse =
            ProjectServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun users(): UserServiceAsync.WithRawResponse = users

        override fun serviceAccounts(): ServiceAccountServiceAsync.WithRawResponse = serviceAccounts

        override fun apiKeys(): ApiKeyServiceAsync.WithRawResponse = apiKeys

        override fun rateLimits(): RateLimitServiceAsync.WithRawResponse = rateLimits

        override fun groups(): GroupServiceAsync.WithRawResponse = groups

        override fun roles(): RoleServiceAsync.WithRawResponse = roles

        override fun certificates(): CertificateServiceAsync.WithRawResponse = certificates

        private val createHandler: Handler<Project> = jsonHandler<Project>(clientOptions.jsonMapper)

        override fun create(
            params: ProjectCreateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Project>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("organization", "projects")
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

        private val retrieveHandler: Handler<Project> =
            jsonHandler<Project>(clientOptions.jsonMapper)

        override fun retrieve(
            params: ProjectRetrieveParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Project>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("projectId", params.projectId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("organization", "projects", params._pathParam(0))
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

        private val updateHandler: Handler<Project> = jsonHandler<Project>(clientOptions.jsonMapper)

        override fun update(
            params: ProjectUpdateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Project>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("projectId", params.projectId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("organization", "projects", params._pathParam(0))
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

        private val listHandler: Handler<ProjectListPageResponse> =
            jsonHandler<ProjectListPageResponse>(clientOptions.jsonMapper)

        override fun list(
            params: ProjectListParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ProjectListPageAsync>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("organization", "projects")
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
                                ProjectListPageAsync.builder()
                                    .service(ProjectServiceAsyncImpl(clientOptions))
                                    .streamHandlerExecutor(clientOptions.streamHandlerExecutor)
                                    .params(params)
                                    .response(it)
                                    .build()
                            }
                    }
                }
        }

        private val archiveHandler: Handler<Project> =
            jsonHandler<Project>(clientOptions.jsonMapper)

        override fun archive(
            params: ProjectArchiveParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Project>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("projectId", params.projectId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("organization", "projects", params._pathParam(0), "archive")
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
                            .use { archiveHandler.handle(it) }
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
