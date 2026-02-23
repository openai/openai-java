// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
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
import com.openai.core.http.multipartFormData
import com.openai.core.http.parseable
import com.openai.core.prepare
import com.openai.models.videos.Video
import com.openai.models.videos.VideoCreateParams
import com.openai.models.videos.VideoDeleteParams
import com.openai.models.videos.VideoDeleteResponse
import com.openai.models.videos.VideoDownloadContentParams
import com.openai.models.videos.VideoListPage
import com.openai.models.videos.VideoListPageResponse
import com.openai.models.videos.VideoListParams
import com.openai.models.videos.VideoRemixParams
import com.openai.models.videos.VideoRetrieveParams
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class VideoServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    VideoService {

    private val withRawResponse: VideoService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): VideoService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): VideoService =
        VideoServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun create(params: VideoCreateParams, requestOptions: RequestOptions): Video =
        // post /videos
        withRawResponse().create(params, requestOptions).parse()

    override fun retrieve(params: VideoRetrieveParams, requestOptions: RequestOptions): Video =
        // get /videos/{video_id}
        withRawResponse().retrieve(params, requestOptions).parse()

    override fun list(params: VideoListParams, requestOptions: RequestOptions): VideoListPage =
        // get /videos
        withRawResponse().list(params, requestOptions).parse()

    override fun delete(
        params: VideoDeleteParams,
        requestOptions: RequestOptions,
    ): VideoDeleteResponse =
        // delete /videos/{video_id}
        withRawResponse().delete(params, requestOptions).parse()

    override fun downloadContent(
        params: VideoDownloadContentParams,
        requestOptions: RequestOptions,
    ): HttpResponse =
        // get /videos/{video_id}/content
        withRawResponse().downloadContent(params, requestOptions)

    override fun remix(params: VideoRemixParams, requestOptions: RequestOptions): Video =
        // post /videos/{video_id}/remix
        withRawResponse().remix(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        VideoService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): VideoService.WithRawResponse =
            VideoServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val createHandler: Handler<Video> = jsonHandler<Video>(clientOptions.jsonMapper)

        override fun create(
            params: VideoCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Video> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("videos")
                    .body(multipartFormData(clientOptions.jsonMapper, params._body()))
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

        private val retrieveHandler: Handler<Video> = jsonHandler<Video>(clientOptions.jsonMapper)

        override fun retrieve(
            params: VideoRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Video> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("videoId", params.videoId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("videos", params._pathParam(0))
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

        private val listHandler: Handler<VideoListPageResponse> =
            jsonHandler<VideoListPageResponse>(clientOptions.jsonMapper)

        override fun list(
            params: VideoListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<VideoListPage> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("videos")
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
                        VideoListPage.builder()
                            .service(VideoServiceImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }

        private val deleteHandler: Handler<VideoDeleteResponse> =
            jsonHandler<VideoDeleteResponse>(clientOptions.jsonMapper)

        override fun delete(
            params: VideoDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<VideoDeleteResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("videoId", params.videoId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("videos", params._pathParam(0))
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepare(clientOptions, params)
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

        override fun downloadContent(
            params: VideoDownloadContentParams,
            requestOptions: RequestOptions,
        ): HttpResponse {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("videoId", params.videoId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("videos", params._pathParam(0), "content")
                    .putHeader("Accept", "application/binary")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response)
        }

        private val remixHandler: Handler<Video> = jsonHandler<Video>(clientOptions.jsonMapper)

        override fun remix(
            params: VideoRemixParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Video> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("videoId", params.videoId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("videos", params._pathParam(0), "remix")
                    .body(multipartFormData(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { remixHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
