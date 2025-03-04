// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.fineTuning.jobs

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.handlers.errorHandler
import com.openai.core.handlers.jsonHandler
import com.openai.core.handlers.withErrorHandler
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse.Handler
import com.openai.core.prepareAsync
import com.openai.errors.OpenAIError
import com.openai.models.FineTuningJobCheckpointListPageAsync
import com.openai.models.FineTuningJobCheckpointListParams
import java.util.concurrent.CompletableFuture

class CheckpointServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    CheckpointServiceAsync {

    private val errorHandler: Handler<OpenAIError> = errorHandler(clientOptions.jsonMapper)

    private val listHandler: Handler<FineTuningJobCheckpointListPageAsync.Response> =
        jsonHandler<FineTuningJobCheckpointListPageAsync.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** List checkpoints for a fine-tuning job. */
    override fun list(
        params: FineTuningJobCheckpointListParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<FineTuningJobCheckpointListPageAsync> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("fine_tuning", "jobs", params.getPathParam(0), "checkpoints")
                .build()
                .prepareAsync(clientOptions, params)
        val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
        return request
            .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
            .thenApply { response ->
                response
                    .use { listHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
                    .let { FineTuningJobCheckpointListPageAsync.of(this, params, it) }
            }
    }
}
