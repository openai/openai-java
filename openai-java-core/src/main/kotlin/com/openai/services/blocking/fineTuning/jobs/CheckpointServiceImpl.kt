// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.fineTuning.jobs

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.handlers.errorHandler
import com.openai.core.handlers.jsonHandler
import com.openai.core.handlers.withErrorHandler
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse.Handler
import com.openai.core.prepare
import com.openai.errors.OpenAIError
import com.openai.models.FineTuningJobCheckpointListPage
import com.openai.models.FineTuningJobCheckpointListParams

class CheckpointServiceImpl
internal constructor(
    private val clientOptions: ClientOptions,
) : CheckpointService {

    private val errorHandler: Handler<OpenAIError> = errorHandler(clientOptions.jsonMapper)

    private val listHandler: Handler<FineTuningJobCheckpointListPage.Response> =
        jsonHandler<FineTuningJobCheckpointListPage.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** List checkpoints for a fine-tuning job. */
    override fun list(
        params: FineTuningJobCheckpointListParams,
        requestOptions: RequestOptions
    ): FineTuningJobCheckpointListPage {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("fine_tuning", "jobs", params.getPathParam(0), "checkpoints")
                .build()
                .prepare(clientOptions, params, deploymentModel = null)
        return clientOptions.httpClient.execute(request, requestOptions).let { response ->
            response
                .use { listHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
                .let { FineTuningJobCheckpointListPage.of(this, params, it) }
        }
    }
}
