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
import com.openai.models.admin.organization.projects.modelpermissions.ModelPermissionDeleteParams
import com.openai.models.admin.organization.projects.modelpermissions.ModelPermissionRetrieveParams
import com.openai.models.admin.organization.projects.modelpermissions.ModelPermissionUpdateParams
import com.openai.models.admin.organization.projects.modelpermissions.ProjectModelPermissions
import com.openai.models.admin.organization.projects.modelpermissions.ProjectModelPermissionsDeleted
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class ModelPermissionServiceAsyncImpl
internal constructor(private val clientOptions: ClientOptions) : ModelPermissionServiceAsync {

    private val withRawResponse: ModelPermissionServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): ModelPermissionServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(
        modifier: Consumer<ClientOptions.Builder>
    ): ModelPermissionServiceAsync =
        ModelPermissionServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun retrieve(
        params: ModelPermissionRetrieveParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<ProjectModelPermissions> =
        // get /organization/projects/{project_id}/model_permissions
        withRawResponse().retrieve(params, requestOptions).thenApplyPropagatingCancellation {
            it.parse()
        }

    override fun update(
        params: ModelPermissionUpdateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<ProjectModelPermissions> =
        // post /organization/projects/{project_id}/model_permissions
        withRawResponse().update(params, requestOptions).thenApplyPropagatingCancellation {
            it.parse()
        }

    override fun delete(
        params: ModelPermissionDeleteParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<ProjectModelPermissionsDeleted> =
        // delete /organization/projects/{project_id}/model_permissions
        withRawResponse().delete(params, requestOptions).thenApplyPropagatingCancellation {
            it.parse()
        }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ModelPermissionServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ModelPermissionServiceAsync.WithRawResponse =
            ModelPermissionServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val retrieveHandler: Handler<ProjectModelPermissions> =
            jsonHandler<ProjectModelPermissions>(clientOptions.jsonMapper)

        override fun retrieve(
            params: ModelPermissionRetrieveParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ProjectModelPermissions>> {
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
                        "model_permissions",
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

        private val updateHandler: Handler<ProjectModelPermissions> =
            jsonHandler<ProjectModelPermissions>(clientOptions.jsonMapper)

        override fun update(
            params: ModelPermissionUpdateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ProjectModelPermissions>> {
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
                        "model_permissions",
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

        private val deleteHandler: Handler<ProjectModelPermissionsDeleted> =
            jsonHandler<ProjectModelPermissionsDeleted>(clientOptions.jsonMapper)

        override fun delete(
            params: ModelPermissionDeleteParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ProjectModelPermissionsDeleted>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("projectId", params.projectId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "organization",
                        "projects",
                        params._pathParam(0),
                        "model_permissions",
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
