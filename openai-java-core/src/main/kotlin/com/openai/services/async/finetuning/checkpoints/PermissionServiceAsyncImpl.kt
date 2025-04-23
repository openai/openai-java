// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.finetuning.checkpoints

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.handlers.errorHandler
import com.openai.core.handlers.jsonHandler
import com.openai.core.handlers.withErrorHandler
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse.Handler
import com.openai.core.http.HttpResponseFor
import com.openai.core.http.json
import com.openai.core.http.parseable
import com.openai.core.prepareAsync
import com.openai.models.ErrorObject
import com.openai.models.finetuning.checkpoints.permissions.PermissionCreatePageAsync
import com.openai.models.finetuning.checkpoints.permissions.PermissionCreatePageResponse
import com.openai.models.finetuning.checkpoints.permissions.PermissionCreateParams
import com.openai.models.finetuning.checkpoints.permissions.PermissionDeleteParams
import com.openai.models.finetuning.checkpoints.permissions.PermissionDeleteResponse
import com.openai.models.finetuning.checkpoints.permissions.PermissionRetrieveParams
import com.openai.models.finetuning.checkpoints.permissions.PermissionRetrieveResponse
import java.util.concurrent.CompletableFuture

class PermissionServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    PermissionServiceAsync {

    private val withRawResponse: PermissionServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): PermissionServiceAsync.WithRawResponse = withRawResponse

    override fun create(
        params: PermissionCreateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<PermissionCreatePageAsync> =
        // post /fine_tuning/checkpoints/{fine_tuned_model_checkpoint}/permissions
        withRawResponse().create(params, requestOptions).thenApply { it.parse() }

    override fun retrieve(
        params: PermissionRetrieveParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<PermissionRetrieveResponse> =
        // get /fine_tuning/checkpoints/{fine_tuned_model_checkpoint}/permissions
        withRawResponse().retrieve(params, requestOptions).thenApply { it.parse() }

    override fun delete(
        params: PermissionDeleteParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<PermissionDeleteResponse> =
        // delete /fine_tuning/checkpoints/{fine_tuned_model_checkpoint}/permissions/{permission_id}
        withRawResponse().delete(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        PermissionServiceAsync.WithRawResponse {

        private val errorHandler: Handler<ErrorObject?> = errorHandler(clientOptions.jsonMapper)

        private val createHandler: Handler<PermissionCreatePageResponse> =
            jsonHandler<PermissionCreatePageResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun create(
            params: PermissionCreateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<PermissionCreatePageAsync>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments(
                        "fine_tuning",
                        "checkpoints",
                        params._pathParam(0),
                        "permissions",
                    )
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params, deploymentModel = null)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { createHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                            .let {
                                PermissionCreatePageAsync.builder()
                                    .service(PermissionServiceAsyncImpl(clientOptions))
                                    .params(params)
                                    .response(it)
                                    .build()
                            }
                    }
                }
        }

        private val retrieveHandler: Handler<PermissionRetrieveResponse> =
            jsonHandler<PermissionRetrieveResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun retrieve(
            params: PermissionRetrieveParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<PermissionRetrieveResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments(
                        "fine_tuning",
                        "checkpoints",
                        params._pathParam(0),
                        "permissions",
                    )
                    .build()
                    .prepareAsync(clientOptions, params, deploymentModel = null)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
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

        private val deleteHandler: Handler<PermissionDeleteResponse> =
            jsonHandler<PermissionDeleteResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun delete(
            params: PermissionDeleteParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<PermissionDeleteResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .addPathSegments(
                        "fine_tuning",
                        "checkpoints",
                        params._pathParam(0),
                        "permissions",
                        params._pathParam(1),
                    )
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepareAsync(clientOptions, params, deploymentModel = null)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
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
