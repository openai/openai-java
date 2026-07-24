package com.openai.compatibility

import com.openai.models.ChatModel
import com.openai.models.chat.completions.StructuredChatCompletion
import com.openai.models.chat.completions.StructuredChatCompletionCreateParams
import com.openai.models.responses.ResponseTextConfig
import com.openai.models.responses.StructuredResponse
import com.openai.models.responses.StructuredResponseCreateParams
import com.openai.models.responses.StructuredResponseTextConfig
import com.openai.services.async.ResponseServiceAsync
import com.openai.services.async.chat.ChatCompletionServiceAsync
import com.openai.services.blocking.ResponseService
import com.openai.services.blocking.chat.ChatCompletionService
import java.util.Optional

internal data class CompatibilityOutput(val value: String)

internal object StructuredOutputsCompatibility {
    fun chatParams(): StructuredChatCompletionCreateParams<CompatibilityOutput> =
        StructuredChatCompletionCreateParams.builder<CompatibilityOutput>()
            .addUserMessage("input")
            .model(ChatModel.GPT_4O_MINI)
            .responseFormat(CompatibilityOutput::class.java)
            .build()

    fun responseParams(): StructuredResponseCreateParams<CompatibilityOutput> =
        StructuredResponseCreateParams.builder<CompatibilityOutput>()
            .input("input")
            .model(ChatModel.GPT_4O_MINI)
            .text(CompatibilityOutput::class.java)
            .build()

    fun responseTextConfig(): StructuredResponseTextConfig<CompatibilityOutput> =
        StructuredResponseTextConfig.builder<CompatibilityOutput>()
            .format(CompatibilityOutput::class.java)
            .verbosity(ResponseTextConfig.Verbosity.HIGH)
            .build()

    fun chatOutput(
        completion: StructuredChatCompletion<CompatibilityOutput>
    ): Optional<CompatibilityOutput> = completion.choices().first().message().content()

    fun responseOutput(response: StructuredResponse<CompatibilityOutput>): CompatibilityOutput? =
        response
            .output()
            .firstOrNull { it.isMessage() }
            ?.asMessage()
            ?.content()
            ?.firstOrNull { it.isOutputText() }
            ?.asOutputText()

    fun blockingChat(
        service: ChatCompletionService,
        params: StructuredChatCompletionCreateParams<CompatibilityOutput>,
    ): StructuredChatCompletion<CompatibilityOutput> {
        service.createStreaming(params)
        return service.create(params)
    }

    fun asyncChat(
        service: ChatCompletionServiceAsync,
        params: StructuredChatCompletionCreateParams<CompatibilityOutput>,
    ) {
        service.create(params)
        service.createStreaming(params)
    }

    fun blockingResponse(
        service: ResponseService,
        params: StructuredResponseCreateParams<CompatibilityOutput>,
    ): StructuredResponse<CompatibilityOutput> {
        service.createStreaming(params)
        return service.create(params)
    }

    fun asyncResponse(
        service: ResponseServiceAsync,
        params: StructuredResponseCreateParams<CompatibilityOutput>,
    ) {
        service.create(params)
        service.createStreaming(params)
    }
}
