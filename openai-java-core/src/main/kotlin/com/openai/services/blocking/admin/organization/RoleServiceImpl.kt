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
import com.openai.models.admin.organization.roles.Role
import com.openai.models.admin.organization.roles.RoleCreateParams
import com.openai.models.admin.organization.roles.RoleDeleteParams
import com.openai.models.admin.organization.roles.RoleDeleteResponse
import com.openai.models.admin.organization.roles.RoleListPage
import com.openai.models.admin.organization.roles.RoleListPageResponse
import com.openai.models.admin.organization.roles.RoleListParams
import com.openai.models.admin.organization.roles.RoleUpdateParams
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class RoleServiceImpl internal constructor(private val clientOptions: ClientOptions) : RoleService {

    private val withRawResponse: RoleService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): RoleService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): RoleService =
        RoleServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun create(params: RoleCreateParams, requestOptions: RequestOptions): Role =
        // post /organization/roles
        withRawResponse().create(params, requestOptions).parse()

    override fun update(params: RoleUpdateParams, requestOptions: RequestOptions): Role =
        // post /organization/roles/{role_id}
        withRawResponse().update(params, requestOptions).parse()

    override fun list(params: RoleListParams, requestOptions: RequestOptions): RoleListPage =
        // get /organization/roles
        withRawResponse().list(params, requestOptions).parse()

    override fun delete(
        params: RoleDeleteParams,
        requestOptions: RequestOptions,
    ): RoleDeleteResponse =
        // delete /organization/roles/{role_id}
        withRawResponse().delete(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        RoleService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): RoleService.WithRawResponse =
            RoleServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val createHandler: Handler<Role> = jsonHandler<Role>(clientOptions.jsonMapper)

        override fun create(
            params: RoleCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Role> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("organization", "roles")
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

        private val updateHandler: Handler<Role> = jsonHandler<Role>(clientOptions.jsonMapper)

        override fun update(
            params: RoleUpdateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Role> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("roleId", params.roleId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("organization", "roles", params._pathParam(0))
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

        private val listHandler: Handler<RoleListPageResponse> =
            jsonHandler<RoleListPageResponse>(clientOptions.jsonMapper)

        override fun list(
            params: RoleListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<RoleListPage> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("organization", "roles")
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
                        RoleListPage.builder()
                            .service(RoleServiceImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }

        private val deleteHandler: Handler<RoleDeleteResponse> =
            jsonHandler<RoleDeleteResponse>(clientOptions.jsonMapper)

        override fun delete(
            params: RoleDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<RoleDeleteResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("roleId", params.roleId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("organization", "roles", params._pathParam(0))
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
