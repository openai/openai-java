// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.admin.organization

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
import com.openai.models.admin.organization.projects.Project
import com.openai.models.admin.organization.projects.ProjectArchiveParams
import com.openai.models.admin.organization.projects.ProjectCreateParams
import com.openai.models.admin.organization.projects.ProjectListPage
import com.openai.models.admin.organization.projects.ProjectListPageResponse
import com.openai.models.admin.organization.projects.ProjectListParams
import com.openai.models.admin.organization.projects.ProjectRetrieveParams
import com.openai.models.admin.organization.projects.ProjectUpdateParams
import com.openai.services.blocking.admin.organization.projects.ApiKeyService
import com.openai.services.blocking.admin.organization.projects.ApiKeyServiceImpl
import com.openai.services.blocking.admin.organization.projects.CertificateService
import com.openai.services.blocking.admin.organization.projects.CertificateServiceImpl
import com.openai.services.blocking.admin.organization.projects.GroupService
import com.openai.services.blocking.admin.organization.projects.GroupServiceImpl
import com.openai.services.blocking.admin.organization.projects.RateLimitService
import com.openai.services.blocking.admin.organization.projects.RateLimitServiceImpl
import com.openai.services.blocking.admin.organization.projects.RoleService
import com.openai.services.blocking.admin.organization.projects.RoleServiceImpl
import com.openai.services.blocking.admin.organization.projects.ServiceAccountService
import com.openai.services.blocking.admin.organization.projects.ServiceAccountServiceImpl
import com.openai.services.blocking.admin.organization.projects.UserService
import com.openai.services.blocking.admin.organization.projects.UserServiceImpl
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class ProjectServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    ProjectService {

    private val withRawResponse: ProjectService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val users: UserService by lazy { UserServiceImpl(clientOptions) }

    private val serviceAccounts: ServiceAccountService by lazy {
        ServiceAccountServiceImpl(clientOptions)
    }

    private val apiKeys: ApiKeyService by lazy { ApiKeyServiceImpl(clientOptions) }

    private val rateLimits: RateLimitService by lazy { RateLimitServiceImpl(clientOptions) }

    private val groups: GroupService by lazy { GroupServiceImpl(clientOptions) }

    private val roles: RoleService by lazy { RoleServiceImpl(clientOptions) }

    private val certificates: CertificateService by lazy { CertificateServiceImpl(clientOptions) }

    override fun withRawResponse(): ProjectService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): ProjectService =
        ProjectServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun users(): UserService = users

    override fun serviceAccounts(): ServiceAccountService = serviceAccounts

    override fun apiKeys(): ApiKeyService = apiKeys

    override fun rateLimits(): RateLimitService = rateLimits

    override fun groups(): GroupService = groups

    override fun roles(): RoleService = roles

    override fun certificates(): CertificateService = certificates

    override fun create(params: ProjectCreateParams, requestOptions: RequestOptions): Project =
        // post /organization/projects
        withRawResponse().create(params, requestOptions).parse()

    override fun retrieve(params: ProjectRetrieveParams, requestOptions: RequestOptions): Project =
        // get /organization/projects/{project_id}
        withRawResponse().retrieve(params, requestOptions).parse()

    override fun update(params: ProjectUpdateParams, requestOptions: RequestOptions): Project =
        // post /organization/projects/{project_id}
        withRawResponse().update(params, requestOptions).parse()

    override fun list(params: ProjectListParams, requestOptions: RequestOptions): ProjectListPage =
        // get /organization/projects
        withRawResponse().list(params, requestOptions).parse()

    override fun archive(params: ProjectArchiveParams, requestOptions: RequestOptions): Project =
        // post /organization/projects/{project_id}/archive
        withRawResponse().archive(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ProjectService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        private val users: UserService.WithRawResponse by lazy {
            UserServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val serviceAccounts: ServiceAccountService.WithRawResponse by lazy {
            ServiceAccountServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val apiKeys: ApiKeyService.WithRawResponse by lazy {
            ApiKeyServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val rateLimits: RateLimitService.WithRawResponse by lazy {
            RateLimitServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val groups: GroupService.WithRawResponse by lazy {
            GroupServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val roles: RoleService.WithRawResponse by lazy {
            RoleServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val certificates: CertificateService.WithRawResponse by lazy {
            CertificateServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ProjectService.WithRawResponse =
            ProjectServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun users(): UserService.WithRawResponse = users

        override fun serviceAccounts(): ServiceAccountService.WithRawResponse = serviceAccounts

        override fun apiKeys(): ApiKeyService.WithRawResponse = apiKeys

        override fun rateLimits(): RateLimitService.WithRawResponse = rateLimits

        override fun groups(): GroupService.WithRawResponse = groups

        override fun roles(): RoleService.WithRawResponse = roles

        override fun certificates(): CertificateService.WithRawResponse = certificates

        private val createHandler: Handler<Project> = jsonHandler<Project>(clientOptions.jsonMapper)

        override fun create(
            params: ProjectCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Project> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("organization", "projects")
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
                    .use { createHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val retrieveHandler: Handler<Project> =
            jsonHandler<Project>(clientOptions.jsonMapper)

        override fun retrieve(
            params: ProjectRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Project> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("projectId", params.projectId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("organization", "projects", params._pathParam(0))
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
                    .use { retrieveHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val updateHandler: Handler<Project> = jsonHandler<Project>(clientOptions.jsonMapper)

        override fun update(
            params: ProjectUpdateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Project> {
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
                    .prepare(
                        clientOptions,
                        params,
                        SecurityOptions.builder().adminApiKeyAuth(true).build(),
                    )
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { updateHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val listHandler: Handler<ProjectListPageResponse> =
            jsonHandler<ProjectListPageResponse>(clientOptions.jsonMapper)

        override fun list(
            params: ProjectListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ProjectListPage> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("organization", "projects")
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
                    .use { listHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
                    .let {
                        ProjectListPage.builder()
                            .service(ProjectServiceImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }

        private val archiveHandler: Handler<Project> =
            jsonHandler<Project>(clientOptions.jsonMapper)

        override fun archive(
            params: ProjectArchiveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Project> {
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
                    .prepare(
                        clientOptions,
                        params,
                        SecurityOptions.builder().adminApiKeyAuth(true).build(),
                    )
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
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
