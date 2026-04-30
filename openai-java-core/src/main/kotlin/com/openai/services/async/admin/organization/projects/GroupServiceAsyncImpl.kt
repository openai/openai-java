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
import com.openai.models.admin.organization.projects.groups.GroupCreateParams
import com.openai.models.admin.organization.projects.groups.GroupDeleteParams
import com.openai.models.admin.organization.projects.groups.GroupDeleteResponse
import com.openai.models.admin.organization.projects.groups.GroupListPageAsync
import com.openai.models.admin.organization.projects.groups.GroupListPageResponse
import com.openai.models.admin.organization.projects.groups.GroupListParams
import com.openai.models.admin.organization.projects.groups.ProjectGroup
import com.openai.services.async.admin.organization.projects.groups.RoleServiceAsync
import com.openai.services.async.admin.organization.projects.groups.RoleServiceAsyncImpl
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class GroupServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    GroupServiceAsync {

    private val withRawResponse: GroupServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val roles: RoleServiceAsync by lazy { RoleServiceAsyncImpl(clientOptions) }

    override fun withRawResponse(): GroupServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): GroupServiceAsync =
        GroupServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun roles(): RoleServiceAsync = roles

    override fun create(
        params: GroupCreateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<ProjectGroup> =
        // post /organization/projects/{project_id}/groups
        withRawResponse().create(params, requestOptions).thenApply { it.parse() }

    override fun list(
        params: GroupListParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<GroupListPageAsync> =
        // get /organization/projects/{project_id}/groups
        withRawResponse().list(params, requestOptions).thenApply { it.parse() }

    override fun delete(
        params: GroupDeleteParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<GroupDeleteResponse> =
        // delete /organization/projects/{project_id}/groups/{group_id}
        withRawResponse().delete(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        GroupServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        private val roles: RoleServiceAsync.WithRawResponse by lazy {
            RoleServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): GroupServiceAsync.WithRawResponse =
            GroupServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun roles(): RoleServiceAsync.WithRawResponse = roles

        private val createHandler: Handler<ProjectGroup> =
            jsonHandler<ProjectGroup>(clientOptions.jsonMapper)

        override fun create(
            params: GroupCreateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ProjectGroup>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("projectId", params.projectId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("organization", "projects", params._pathParam(0), "groups")
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

        private val listHandler: Handler<GroupListPageResponse> =
            jsonHandler<GroupListPageResponse>(clientOptions.jsonMapper)

        override fun list(
            params: GroupListParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<GroupListPageAsync>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("projectId", params.projectId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("organization", "projects", params._pathParam(0), "groups")
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
                                GroupListPageAsync.builder()
                                    .service(GroupServiceAsyncImpl(clientOptions))
                                    .streamHandlerExecutor(clientOptions.streamHandlerExecutor)
                                    .params(params)
                                    .response(it)
                                    .build()
                            }
                    }
                }
        }

        private val deleteHandler: Handler<GroupDeleteResponse> =
            jsonHandler<GroupDeleteResponse>(clientOptions.jsonMapper)

        override fun delete(
            params: GroupDeleteParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<GroupDeleteResponse>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("groupId", params.groupId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "organization",
                        "projects",
                        params._pathParam(0),
                        "groups",
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
