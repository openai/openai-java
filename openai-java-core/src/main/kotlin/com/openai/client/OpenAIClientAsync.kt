// File generated from our OpenAPI spec by Stainless.

package com.openai.client

import com.openai.services.async.BatchServiceAsync
import com.openai.services.async.BetaServiceAsync
import com.openai.services.async.ChatServiceAsync
import com.openai.services.async.CompletionServiceAsync
import com.openai.services.async.EmbeddingServiceAsync
import com.openai.services.async.FileServiceAsync
import com.openai.services.async.FineTuningServiceAsync
import com.openai.services.async.ImageServiceAsync
import com.openai.services.async.ModelServiceAsync
import com.openai.services.async.ModerationServiceAsync
import com.openai.services.async.UploadServiceAsync

interface OpenAIClientAsync {

    fun sync(): OpenAIClient

    fun completions(): CompletionServiceAsync

    fun chat(): ChatServiceAsync

    fun embeddings(): EmbeddingServiceAsync

    fun files(): FileServiceAsync

    fun images(): ImageServiceAsync

    fun moderations(): ModerationServiceAsync

    fun models(): ModelServiceAsync

    fun fineTuning(): FineTuningServiceAsync

    fun beta(): BetaServiceAsync

    fun batches(): BatchServiceAsync

    fun uploads(): UploadServiceAsync

    /**
     * Closes this client, relinquishing any underlying resources.
     *
     * This is purposefully not inherited from [AutoCloseable] because the client is long-lived and
     * usually should not be synchronously closed via try-with-resources.
     *
     * It's also usually not necessary to call this method at all. the default HTTP client
     * automatically releases threads and connections if they remain idle, but if you are writing an
     * application that needs to aggressively release unused resources, then you may call this
     * method.
     */
    fun close()
}
