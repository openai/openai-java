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
import com.openai.models.admin.organization.projects.roles.RoleCreateParams
import com.openai.models.admin.organization.projects.roles.RoleDeleteParams
import com.openai.models.admin.organization.projects.roles.RoleDeleteResponse
import com.openai.models.admin.organization.projects.roles.RoleListPageAsync
import com.openai.models.admin.organization.projects.roles.RoleListPageResponse
import com.openai.models.admin.organization.projects.roles.RoleListParams
import com.openai.models.admin.organization.projects.roles.RoleUpdateParams
import com.openai.models.admin.organization.roles.Role
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class RoleServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    RoleServiceAsync {

    private val withRawResponse: RoleServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): RoleServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): RoleServiceAsync =
        RoleServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun create(
        params: RoleCreateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<Role> =
        // post /projects/{project_id}/roles
        withRawResponse().create(params, requestOptions).thenApply { it.parse() }

    override fun update(
        params: RoleUpdateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<Role> =
        // post /projects/{project_id}/roles/{role_id}
        withRawResponse().update(params, requestOptions).thenApply { it.parse() }

    override fun list(
        params: RoleListParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<RoleListPageAsync> =
        // get /projects/{project_id}/roles
        withRawResponse().list(params, requestOptions).thenApply { it.parse() }

    override fun delete(
        params: RoleDeleteParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<RoleDeleteResponse> =
        // delete /projects/{project_id}/roles/{role_id}
        withRawResponse().delete(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        RoleServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): RoleServiceAsync.WithRawResponse =
            RoleServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val createHandler: Handler<Role> = jsonHandler<Role>(clientOptions.jsonMapper)

        override fun create(
            params: RoleCreateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Role>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("projectId", params.projectId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("projects", params._pathParam(0), "roles")
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

        private val updateHandler: Handler<Role> = jsonHandler<Role>(clientOptions.jsonMapper)

        override fun update(
            params: RoleUpdateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Role>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("roleId", params.roleId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "projects",
                        params._pathParam(0),
                        "roles",
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
                            .use { updateHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val listHandler: Handler<RoleListPageResponse> =
            jsonHandler<RoleListPageResponse>(clientOptions.jsonMapper)

        override fun list(
            params: RoleListParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<RoleListPageAsync>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("projectId", params.projectId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("projects", params._pathParam(0), "roles")
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
                                RoleListPageAsync.builder()
                                    .service(RoleServiceAsyncImpl(clientOptions))
                                    .streamHandlerExecutor(clientOptions.streamHandlerExecutor)
                                    .params(params)
                                    .response(it)
                                    .build()
                            }
                    }
                }
        }

        private val deleteHandler: Handler<RoleDeleteResponse> =
            jsonHandler<RoleDeleteResponse>(clientOptions.jsonMapper)

        override fun delete(
            params: RoleDeleteParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<RoleDeleteResponse>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("roleId", params.roleId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "projects",
                        params._pathParam(0),
                        "roles",
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
