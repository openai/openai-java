// File generated from our OpenAPI spec by Stainless.

package com.openai.client

import com.openai.services.blocking.BatchService
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

    fun batches(): BatchService

    fun uploads(): UploadService
}
