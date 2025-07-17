// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.checkRequired
import com.openai.core.handlers.emptyHandler
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
import com.openai.models.containers.ContainerCreateParams
import com.openai.models.containers.ContainerCreateResponse
import com.openai.models.containers.ContainerDeleteParams
import com.openai.models.containers.ContainerListPage
import com.openai.models.containers.ContainerListPageResponse
import com.openai.models.containers.ContainerListParams
import com.openai.models.containers.ContainerRetrieveParams
import com.openai.models.containers.ContainerRetrieveResponse
import com.openai.services.blocking.containers.FileService
import com.openai.services.blocking.containers.FileServiceImpl
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class ContainerServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    ContainerService {

    private val withRawResponse: ContainerService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val files: FileService by lazy { FileServiceImpl(clientOptions) }

    override fun withRawResponse(): ContainerService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): ContainerService =
        ContainerServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun files(): FileService = files

    override fun create(
        params: ContainerCreateParams,
        requestOptions: RequestOptions,
    ): ContainerCreateResponse =
        // post /containers
        withRawResponse().create(params, requestOptions).parse()

    override fun retrieve(
        params: ContainerRetrieveParams,
        requestOptions: RequestOptions,
    ): ContainerRetrieveResponse =
        // get /containers/{container_id}
        withRawResponse().retrieve(params, requestOptions).parse()

    override fun list(
        params: ContainerListParams,
        requestOptions: RequestOptions,
    ): ContainerListPage =
        // get /containers
        withRawResponse().list(params, requestOptions).parse()

    override fun delete(params: ContainerDeleteParams, requestOptions: RequestOptions) {
        // delete /containers/{container_id}
        withRawResponse().delete(params, requestOptions)
    }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ContainerService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        private val files: FileService.WithRawResponse by lazy {
            FileServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ContainerService.WithRawResponse =
            ContainerServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun files(): FileService.WithRawResponse = files

        private val createHandler: Handler<ContainerCreateResponse> =
            jsonHandler<ContainerCreateResponse>(clientOptions.jsonMapper)

        override fun create(
            params: ContainerCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ContainerCreateResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("containers")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
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

        private val retrieveHandler: Handler<ContainerRetrieveResponse> =
            jsonHandler<ContainerRetrieveResponse>(clientOptions.jsonMapper)

        override fun retrieve(
            params: ContainerRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ContainerRetrieveResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("containerId", params.containerId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("containers", params._pathParam(0))
                    .build()
                    .prepare(clientOptions, params)
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

        private val listHandler: Handler<ContainerListPageResponse> =
            jsonHandler<ContainerListPageResponse>(clientOptions.jsonMapper)

        override fun list(
            params: ContainerListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ContainerListPage> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("containers")
                    .build()
                    .prepare(clientOptions, params)
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
                        ContainerListPage.builder()
                            .service(ContainerServiceImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }

        private val deleteHandler: Handler<Void?> = emptyHandler()

        override fun delete(
            params: ContainerDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponse {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("containerId", params.containerId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("containers", params._pathParam(0))
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response.use { deleteHandler.handle(it) }
            }
        }
    }
}
