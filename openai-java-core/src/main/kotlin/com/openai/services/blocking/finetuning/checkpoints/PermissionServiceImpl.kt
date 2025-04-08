// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.finetuning.checkpoints

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
import com.openai.core.prepare
import com.openai.models.ErrorObject
import com.openai.models.finetuning.checkpoints.permissions.PermissionCreatePage
import com.openai.models.finetuning.checkpoints.permissions.PermissionCreateParams
import com.openai.models.finetuning.checkpoints.permissions.PermissionDeleteParams
import com.openai.models.finetuning.checkpoints.permissions.PermissionDeleteResponse
import com.openai.models.finetuning.checkpoints.permissions.PermissionRetrieveParams
import com.openai.models.finetuning.checkpoints.permissions.PermissionRetrieveResponse

class PermissionServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    PermissionService {

    private val withRawResponse: PermissionService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): PermissionService.WithRawResponse = withRawResponse

    override fun create(
        params: PermissionCreateParams,
        requestOptions: RequestOptions,
    ): PermissionCreatePage =
        // post /fine_tuning/checkpoints/{fine_tuned_model_checkpoint}/permissions
        withRawResponse().create(params, requestOptions).parse()

    override fun retrieve(
        params: PermissionRetrieveParams,
        requestOptions: RequestOptions,
    ): PermissionRetrieveResponse =
        // get /fine_tuning/checkpoints/{fine_tuned_model_checkpoint}/permissions
        withRawResponse().retrieve(params, requestOptions).parse()

    override fun delete(
        params: PermissionDeleteParams,
        requestOptions: RequestOptions,
    ): PermissionDeleteResponse =
        // delete /fine_tuning/checkpoints/{fine_tuned_model_checkpoint}/permissions
        withRawResponse().delete(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        PermissionService.WithRawResponse {

        private val errorHandler: Handler<ErrorObject?> = errorHandler(clientOptions.jsonMapper)

        private val createHandler: Handler<PermissionCreatePage.Response> =
            jsonHandler<PermissionCreatePage.Response>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun create(
            params: PermissionCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<PermissionCreatePage> {
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
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { createHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
                    .let {
                        PermissionCreatePage.of(PermissionServiceImpl(clientOptions), params, it)
                    }
            }
        }

        private val retrieveHandler: Handler<PermissionRetrieveResponse> =
            jsonHandler<PermissionRetrieveResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun retrieve(
            params: PermissionRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<PermissionRetrieveResponse> {
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
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { retrieveHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
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
        ): HttpResponseFor<PermissionDeleteResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .addPathSegments(
                        "fine_tuning",
                        "checkpoints",
                        params._pathParam(0),
                        "permissions",
                    )
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
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
