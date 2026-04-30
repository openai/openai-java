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
import com.openai.models.admin.organization.groups.Group
import com.openai.models.admin.organization.groups.GroupCreateParams
import com.openai.models.admin.organization.groups.GroupDeleteParams
import com.openai.models.admin.organization.groups.GroupDeleteResponse
import com.openai.models.admin.organization.groups.GroupListPage
import com.openai.models.admin.organization.groups.GroupListPageResponse
import com.openai.models.admin.organization.groups.GroupListParams
import com.openai.models.admin.organization.groups.GroupUpdateParams
import com.openai.models.admin.organization.groups.GroupUpdateResponse
import com.openai.services.blocking.admin.organization.groups.RoleService
import com.openai.services.blocking.admin.organization.groups.RoleServiceImpl
import com.openai.services.blocking.admin.organization.groups.UserService
import com.openai.services.blocking.admin.organization.groups.UserServiceImpl
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class GroupServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    GroupService {

    private val withRawResponse: GroupService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val users: UserService by lazy { UserServiceImpl(clientOptions) }

    private val roles: RoleService by lazy { RoleServiceImpl(clientOptions) }

    override fun withRawResponse(): GroupService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): GroupService =
        GroupServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun users(): UserService = users

    override fun roles(): RoleService = roles

    override fun create(params: GroupCreateParams, requestOptions: RequestOptions): Group =
        // post /organization/groups
        withRawResponse().create(params, requestOptions).parse()

    override fun update(
        params: GroupUpdateParams,
        requestOptions: RequestOptions,
    ): GroupUpdateResponse =
        // post /organization/groups/{group_id}
        withRawResponse().update(params, requestOptions).parse()

    override fun list(params: GroupListParams, requestOptions: RequestOptions): GroupListPage =
        // get /organization/groups
        withRawResponse().list(params, requestOptions).parse()

    override fun delete(
        params: GroupDeleteParams,
        requestOptions: RequestOptions,
    ): GroupDeleteResponse =
        // delete /organization/groups/{group_id}
        withRawResponse().delete(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        GroupService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        private val users: UserService.WithRawResponse by lazy {
            UserServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val roles: RoleService.WithRawResponse by lazy {
            RoleServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): GroupService.WithRawResponse =
            GroupServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun users(): UserService.WithRawResponse = users

        override fun roles(): RoleService.WithRawResponse = roles

        private val createHandler: Handler<Group> = jsonHandler<Group>(clientOptions.jsonMapper)

        override fun create(
            params: GroupCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Group> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("organization", "groups")
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

        private val updateHandler: Handler<GroupUpdateResponse> =
            jsonHandler<GroupUpdateResponse>(clientOptions.jsonMapper)

        override fun update(
            params: GroupUpdateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<GroupUpdateResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("groupId", params.groupId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("organization", "groups", params._pathParam(0))
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

        private val listHandler: Handler<GroupListPageResponse> =
            jsonHandler<GroupListPageResponse>(clientOptions.jsonMapper)

        override fun list(
            params: GroupListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<GroupListPage> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("organization", "groups")
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
                        GroupListPage.builder()
                            .service(GroupServiceImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }

        private val deleteHandler: Handler<GroupDeleteResponse> =
            jsonHandler<GroupDeleteResponse>(clientOptions.jsonMapper)

        override fun delete(
            params: GroupDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<GroupDeleteResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("groupId", params.groupId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("organization", "groups", params._pathParam(0))
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
