package com.openai.compatibility

import com.openai.models.ChatModel
import com.openai.models.ResponsesModel
import com.openai.models.chat.completions.ChatCompletionAssistantMessageParam
import com.openai.models.chat.completions.ChatCompletionCreateParams
import com.openai.models.chat.completions.ChatCompletionDeveloperMessageParam
import com.openai.models.chat.completions.ChatCompletionFunctionCallOption
import com.openai.models.chat.completions.ChatCompletionFunctionTool
import com.openai.models.chat.completions.ChatCompletionMessageParam
import com.openai.models.chat.completions.ChatCompletionSystemMessageParam
import com.openai.models.chat.completions.ChatCompletionTool
import com.openai.models.chat.completions.ChatCompletionToolChoiceOption
import com.openai.models.chat.completions.ChatCompletionUserMessageParam
import com.openai.models.responses.FunctionTool
import com.openai.models.responses.Response
import com.openai.models.responses.ResponseCreateParams
import com.openai.models.responses.ResponseIncludable
import com.openai.models.responses.ResponseOutputItem
import com.openai.models.responses.ResponseOutputMessage
import com.openai.models.responses.ResponseOutputText
import com.openai.models.responses.ResponseReasoningItem
import com.openai.models.responses.Tool
import com.openai.models.responses.ToolChoiceFunction
import com.openai.models.responses.ToolChoiceTypes

internal object UnionFactoriesCompatibility {
    fun chatMessage(message: ChatCompletionUserMessageParam): ChatCompletionMessageParam =
        ChatCompletionMessageParam.ofUser(message)

    fun assistantContent(text: String): ChatCompletionAssistantMessageParam.Content =
        ChatCompletionAssistantMessageParam.Content.ofText(text)

    fun developerContent(text: String): ChatCompletionDeveloperMessageParam.Content =
        ChatCompletionDeveloperMessageParam.Content.ofText(text)

    fun systemContent(text: String): ChatCompletionSystemMessageParam.Content =
        ChatCompletionSystemMessageParam.Content.ofText(text)

    fun userContent(text: String): ChatCompletionUserMessageParam.Content =
        ChatCompletionUserMessageParam.Content.ofText(text)

    fun functionCall(
        option: ChatCompletionFunctionCallOption
    ): ChatCompletionCreateParams.FunctionCall =
        ChatCompletionCreateParams.FunctionCall.ofFunctionCallOption(option)

    fun chatTool(function: ChatCompletionFunctionTool): ChatCompletionTool =
        ChatCompletionTool.ofFunction(function)

    fun chatToolChoice(auto: ChatCompletionToolChoiceOption.Auto): ChatCompletionToolChoiceOption =
        ChatCompletionToolChoiceOption.ofAuto(auto)

    fun responsesModel(model: ChatModel): ResponsesModel = ResponsesModel.ofChat(model)

    fun responseInput(text: String): ResponseCreateParams.Input =
        ResponseCreateParams.Input.ofText(text)

    fun responseIncludable(value: String): ResponseIncludable = ResponseIncludable.of(value)

    fun responseConversation(id: String): ResponseCreateParams.Conversation =
        ResponseCreateParams.Conversation.ofId(id)

    fun responseToolChoice(types: ToolChoiceTypes): ResponseCreateParams.ToolChoice =
        ResponseCreateParams.ToolChoice.ofTypes(types)

    fun responseTool(function: FunctionTool): Tool = Tool.ofFunction(function)

    fun codeInterpreterContainer(
        auto: Tool.CodeInterpreter.Container.CodeInterpreterToolAuto
    ): Tool.CodeInterpreter.Container =
        Tool.CodeInterpreter.Container.ofCodeInterpreterToolAuto(auto)

    fun responseOutputContent(outputText: ResponseOutputText): ResponseOutputMessage.Content =
        ResponseOutputMessage.Content.ofOutputText(outputText)

    fun responseResultToolChoice(function: ToolChoiceFunction): Response.ToolChoice =
        Response.ToolChoice.ofFunction(function)

    fun responseOutputItem(reasoning: ResponseReasoningItem): ResponseOutputItem =
        ResponseOutputItem.ofReasoning(reasoning)
}
