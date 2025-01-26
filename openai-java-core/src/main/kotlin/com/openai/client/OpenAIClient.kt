// File generated from our OpenAPI spec by Stainless.

package com.openai.client

import com.openai.services.blocking.BatchService
import com.openai.services.blocking.BetaService
import com.openai.services.blocking.ChatService
import com.openai.services.blocking.CompletionService
import com.openai.services.blocking.EmbeddingService
import com.openai.services.blocking.FileService
import com.openai.services.blocking.FineTuningService
import com.openai.services.blocking.ImageService
import com.openai.services.blocking.ModelService
import com.openai.services.blocking.ModerationService
import com.openai.services.blocking.UploadService

interface OpenAIClient {

    fun async(): OpenAIClientAsync

    fun completions(): CompletionService

    fun chat(): ChatService

    fun embeddings(): EmbeddingService

    fun files(): FileService

    fun images(): ImageService

    fun moderations(): ModerationService

    fun models(): ModelService

    fun fineTuning(): FineTuningService

    fun beta(): BetaService

    fun batches(): BatchService

    fun uploads(): UploadService

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
