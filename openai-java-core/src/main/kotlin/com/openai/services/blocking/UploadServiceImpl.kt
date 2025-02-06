// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.handlers.errorHandler
import com.openai.core.handlers.jsonHandler
import com.openai.core.handlers.withErrorHandler
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse.Handler
import com.openai.core.json
import com.openai.core.prepare
import com.openai.errors.OpenAIError
import com.openai.models.Upload
import com.openai.models.UploadCancelParams
import com.openai.models.UploadCompleteParams
import com.openai.models.UploadCreateParams
import com.openai.services.blocking.uploads.PartService
import com.openai.services.blocking.uploads.PartServiceImpl

class UploadServiceImpl
internal constructor(
    private val clientOptions: ClientOptions,
) : UploadService {

    private val errorHandler: Handler<OpenAIError> = errorHandler(clientOptions.jsonMapper)

    private val parts: PartService by lazy { PartServiceImpl(clientOptions) }

    override fun parts(): PartService = parts

    private val createHandler: Handler<Upload> =
        jsonHandler<Upload>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /**
     * Creates an intermediate
     * [Upload](https://platform.openai.com/docs/api-reference/uploads/object) object that you can
     * add [Parts](https://platform.openai.com/docs/api-reference/uploads/part-object) to.
     * Currently, an Upload can accept at most 8 GB in total and expires after an hour after you
     * create it.
     *
     * Once you complete the Upload, we will create a
     * [File](https://platform.openai.com/docs/api-reference/files/object) object that contains all
     * the parts you uploaded. This File is usable in the rest of our platform as a regular File
     * object.
     *
     * For certain `purpose`s, the correct `mime_type` must be specified. Please refer to
     * documentation for the supported MIME types for your use case:
     * - [Assistants](https://platform.openai.com/docs/assistants/tools/file-search#supported-files)
     *
     * For guidance on the proper filename extensions for each purpose, please follow the
     * documentation on
     * [creating a File](https://platform.openai.com/docs/api-reference/files/create).
     */
    override fun create(params: UploadCreateParams, requestOptions: RequestOptions): Upload {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("uploads")
                .body(json(clientOptions.jsonMapper, params._body()))
                .build()
                .prepare(clientOptions, params, deploymentModel = null)
        val response = clientOptions.httpClient.execute(request, requestOptions)
        return response
            .use { createHandler.handle(it) }
            .also {
                if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                    it.validate()
                }
            }
    }

    private val cancelHandler: Handler<Upload> =
        jsonHandler<Upload>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Cancels the Upload. No Parts may be added after an Upload is cancelled. */
    override fun cancel(params: UploadCancelParams, requestOptions: RequestOptions): Upload {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("uploads", params.getPathParam(0), "cancel")
                .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                .build()
                .prepare(clientOptions, params, deploymentModel = null)
        val response = clientOptions.httpClient.execute(request, requestOptions)
        return response
            .use { cancelHandler.handle(it) }
            .also {
                if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                    it.validate()
                }
            }
    }

    private val completeHandler: Handler<Upload> =
        jsonHandler<Upload>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /**
     * Completes the [Upload](https://platform.openai.com/docs/api-reference/uploads/object).
     *
     * Within the returned Upload object, there is a nested
     * [File](https://platform.openai.com/docs/api-reference/files/object) object that is ready to
     * use in the rest of the platform.
     *
     * You can specify the order of the Parts by passing in an ordered list of the Part IDs.
     *
     * The number of bytes uploaded upon completion must match the number of bytes initially
     * specified when creating the Upload object. No Parts may be added after an Upload is
     * completed.
     */
    override fun complete(params: UploadCompleteParams, requestOptions: RequestOptions): Upload {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("uploads", params.getPathParam(0), "complete")
                .body(json(clientOptions.jsonMapper, params._body()))
                .build()
                .prepare(clientOptions, params, deploymentModel = null)
        val response = clientOptions.httpClient.execute(request, requestOptions)
        return response
            .use { completeHandler.handle(it) }
            .also {
                if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                    it.validate()
                }
            }
    }
}
