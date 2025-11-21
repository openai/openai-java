// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async

import com.openai.core.ClientOptions
import com.openai.services.async.graders.GraderModelServiceAsync
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface GraderServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): GraderServiceAsync

    fun graderModels(): GraderModelServiceAsync

    /**
     * A view of [GraderServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): GraderServiceAsync.WithRawResponse

        fun graderModels(): GraderModelServiceAsync.WithRawResponse
    }
}
