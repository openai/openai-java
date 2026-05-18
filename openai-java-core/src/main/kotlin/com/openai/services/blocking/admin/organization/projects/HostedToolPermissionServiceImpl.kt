// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.admin.organization.projects

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
import com.openai.models.admin.organization.projects.hostedtoolpermissions.HostedToolPermissionRetrieveParams
import com.openai.models.admin.organization.projects.hostedtoolpermissions.HostedToolPermissionUpdateParams
import com.openai.models.admin.organization.projects.hostedtoolpermissions.ProjectHostedToolPermissions
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class HostedToolPermissionServiceImpl
internal constructor(private val clientOptions: ClientOptions) : HostedToolPermissionService {

    private val withRawResponse: HostedToolPermissionService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): HostedToolPermissionService.WithRawResponse = withRawResponse

    override fun withOptions(
        modifier: Consumer<ClientOptions.Builder>
    ): HostedToolPermissionService =
        HostedToolPermissionServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun retrieve(
        params: HostedToolPermissionRetrieveParams,
        requestOptions: RequestOptions,
    ): ProjectHostedToolPermissions =
        // get /organization/projects/{project_id}/hosted_tool_permissions
        withRawResponse().retrieve(params, requestOptions).parse()

    override fun update(
        params: HostedToolPermissionUpdateParams,
        requestOptions: RequestOptions,
    ): ProjectHostedToolPermissions =
        // post /organization/projects/{project_id}/hosted_tool_permissions
        withRawResponse().update(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        HostedToolPermissionService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): HostedToolPermissionService.WithRawResponse =
            HostedToolPermissionServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val retrieveHandler: Handler<ProjectHostedToolPermissions> =
            jsonHandler<ProjectHostedToolPermissions>(clientOptions.jsonMapper)

        override fun retrieve(
            params: HostedToolPermissionRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ProjectHostedToolPermissions> {
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
                        "hosted_tool_permissions",
                    )
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

        private val updateHandler: Handler<ProjectHostedToolPermissions> =
            jsonHandler<ProjectHostedToolPermissions>(clientOptions.jsonMapper)

        override fun update(
            params: HostedToolPermissionUpdateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ProjectHostedToolPermissions> {
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
                        "hosted_tool_permissions",
                    )
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
    }
}
