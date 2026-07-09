// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.BaseDeserializer
import com.openai.core.BaseSerializer
import com.openai.core.Enum
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.allMaxBy
import com.openai.core.checkKnown
import com.openai.core.checkRequired
import com.openai.core.getOrThrow
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Content item used to generate a response. */
@JsonDeserialize(using = BetaResponseItem.Deserializer::class)
@JsonSerialize(using = BetaResponseItem.Serializer::class)
class BetaResponseItem
private constructor(
    private val betaResponseInputMessageItem: BetaResponseInputMessageItem? = null,
    private val betaResponseOutputMessage: BetaResponseOutputMessage? = null,
    private val fileSearchCall: BetaResponseFileSearchToolCall? = null,
    private val computerCall: BetaResponseComputerToolCall? = null,
    private val computerCallOutput: BetaResponseComputerToolCallOutputItem? = null,
    private val webSearchCall: BetaResponseFunctionWebSearch? = null,
    private val functionCall: BetaResponseFunctionToolCallItem? = null,
    private val functionCallOutput: BetaResponseFunctionToolCallOutputItem? = null,
    private val agentMessage: AgentMessage? = null,
    private val multiAgentCall: MultiAgentCall? = null,
    private val multiAgentCallOutput: MultiAgentCallOutput? = null,
    private val toolSearchCall: BetaResponseToolSearchCall? = null,
    private val toolSearchOutput: BetaResponseToolSearchOutputItem? = null,
    private val additionalTools: AdditionalTools? = null,
    private val reasoning: BetaResponseReasoningItem? = null,
    private val program: Program? = null,
    private val programOutput: ProgramOutput? = null,
    private val compaction: BetaResponseCompactionItem? = null,
    private val imageGenerationCall: ImageGenerationCall? = null,
    private val codeInterpreterCall: BetaResponseCodeInterpreterToolCall? = null,
    private val localShellCall: LocalShellCall? = null,
    private val localShellCallOutput: LocalShellCallOutput? = null,
    private val shellCall: BetaResponseFunctionShellToolCall? = null,
    private val shellCallOutput: BetaResponseFunctionShellToolCallOutput? = null,
    private val applyPatchCall: BetaResponseApplyPatchToolCall? = null,
    private val applyPatchCallOutput: BetaResponseApplyPatchToolCallOutput? = null,
    private val mcpListTools: McpListTools? = null,
    private val mcpApprovalRequest: McpApprovalRequest? = null,
    private val mcpApprovalResponse: McpApprovalResponse? = null,
    private val mcpCall: McpCall? = null,
    private val customToolCall: BetaResponseCustomToolCallItem? = null,
    private val customToolCallOutput: BetaResponseCustomToolCallOutputItem? = null,
    private val _json: JsonValue? = null,
) {

    fun betaResponseInputMessageItem(): Optional<BetaResponseInputMessageItem> =
        Optional.ofNullable(betaResponseInputMessageItem)

    /** An output message from the model. */
    fun betaResponseOutputMessage(): Optional<BetaResponseOutputMessage> =
        Optional.ofNullable(betaResponseOutputMessage)

    /**
     * The results of a file search tool call. See the
     * [file search guide](https://platform.openai.com/docs/guides/tools-file-search) for more
     * information.
     */
    fun fileSearchCall(): Optional<BetaResponseFileSearchToolCall> =
        Optional.ofNullable(fileSearchCall)

    /**
     * A tool call to a computer use tool. See the
     * [computer use guide](https://platform.openai.com/docs/guides/tools-computer-use) for more
     * information.
     */
    fun computerCall(): Optional<BetaResponseComputerToolCall> = Optional.ofNullable(computerCall)

    fun computerCallOutput(): Optional<BetaResponseComputerToolCallOutputItem> =
        Optional.ofNullable(computerCallOutput)

    /**
     * The results of a web search tool call. See the
     * [web search guide](https://platform.openai.com/docs/guides/tools-web-search) for more
     * information.
     */
    fun webSearchCall(): Optional<BetaResponseFunctionWebSearch> =
        Optional.ofNullable(webSearchCall)

    /**
     * A tool call to run a function. See the
     * [function calling guide](https://platform.openai.com/docs/guides/function-calling) for more
     * information.
     */
    fun functionCall(): Optional<BetaResponseFunctionToolCallItem> =
        Optional.ofNullable(functionCall)

    fun functionCallOutput(): Optional<BetaResponseFunctionToolCallOutputItem> =
        Optional.ofNullable(functionCallOutput)

    fun agentMessage(): Optional<AgentMessage> = Optional.ofNullable(agentMessage)

    fun multiAgentCall(): Optional<MultiAgentCall> = Optional.ofNullable(multiAgentCall)

    fun multiAgentCallOutput(): Optional<MultiAgentCallOutput> =
        Optional.ofNullable(multiAgentCallOutput)

    fun toolSearchCall(): Optional<BetaResponseToolSearchCall> = Optional.ofNullable(toolSearchCall)

    fun toolSearchOutput(): Optional<BetaResponseToolSearchOutputItem> =
        Optional.ofNullable(toolSearchOutput)

    fun additionalTools(): Optional<AdditionalTools> = Optional.ofNullable(additionalTools)

    /**
     * A description of the chain of thought used by a reasoning model while generating a response.
     * Be sure to include these items in your `input` to the Responses API for subsequent turns of a
     * conversation if you are manually
     * [managing context](https://platform.openai.com/docs/guides/conversation-state).
     */
    fun reasoning(): Optional<BetaResponseReasoningItem> = Optional.ofNullable(reasoning)

    fun program(): Optional<Program> = Optional.ofNullable(program)

    fun programOutput(): Optional<ProgramOutput> = Optional.ofNullable(programOutput)

    /**
     * A compaction item generated by the
     * [`v1/responses/compact` API](https://platform.openai.com/docs/api-reference/responses/compact).
     */
    fun compaction(): Optional<BetaResponseCompactionItem> = Optional.ofNullable(compaction)

    /** An image generation request made by the model. */
    fun imageGenerationCall(): Optional<ImageGenerationCall> =
        Optional.ofNullable(imageGenerationCall)

    /** A tool call to run code. */
    fun codeInterpreterCall(): Optional<BetaResponseCodeInterpreterToolCall> =
        Optional.ofNullable(codeInterpreterCall)

    /** A tool call to run a command on the local shell. */
    fun localShellCall(): Optional<LocalShellCall> = Optional.ofNullable(localShellCall)

    /** The output of a local shell tool call. */
    fun localShellCallOutput(): Optional<LocalShellCallOutput> =
        Optional.ofNullable(localShellCallOutput)

    /** A tool call that executes one or more shell commands in a managed environment. */
    fun shellCall(): Optional<BetaResponseFunctionShellToolCall> = Optional.ofNullable(shellCall)

    /** The output of a shell tool call that was emitted. */
    fun shellCallOutput(): Optional<BetaResponseFunctionShellToolCallOutput> =
        Optional.ofNullable(shellCallOutput)

    /** A tool call that applies file diffs by creating, deleting, or updating files. */
    fun applyPatchCall(): Optional<BetaResponseApplyPatchToolCall> =
        Optional.ofNullable(applyPatchCall)

    /** The output emitted by an apply patch tool call. */
    fun applyPatchCallOutput(): Optional<BetaResponseApplyPatchToolCallOutput> =
        Optional.ofNullable(applyPatchCallOutput)

    /** A list of tools available on an MCP server. */
    fun mcpListTools(): Optional<McpListTools> = Optional.ofNullable(mcpListTools)

    /** A request for human approval of a tool invocation. */
    fun mcpApprovalRequest(): Optional<McpApprovalRequest> = Optional.ofNullable(mcpApprovalRequest)

    /** A response to an MCP approval request. */
    fun mcpApprovalResponse(): Optional<McpApprovalResponse> =
        Optional.ofNullable(mcpApprovalResponse)

    /** An invocation of a tool on an MCP server. */
    fun mcpCall(): Optional<McpCall> = Optional.ofNullable(mcpCall)

    /** A call to a custom tool created by the model. */
    fun customToolCall(): Optional<BetaResponseCustomToolCallItem> =
        Optional.ofNullable(customToolCall)

    /** The output of a custom tool call from your code, being sent back to the model. */
    fun customToolCallOutput(): Optional<BetaResponseCustomToolCallOutputItem> =
        Optional.ofNullable(customToolCallOutput)

    fun isBetaResponseInputMessageItem(): Boolean = betaResponseInputMessageItem != null

    fun isBetaResponseOutputMessage(): Boolean = betaResponseOutputMessage != null

    fun isFileSearchCall(): Boolean = fileSearchCall != null

    fun isComputerCall(): Boolean = computerCall != null

    fun isComputerCallOutput(): Boolean = computerCallOutput != null

    fun isWebSearchCall(): Boolean = webSearchCall != null

    fun isFunctionCall(): Boolean = functionCall != null

    fun isFunctionCallOutput(): Boolean = functionCallOutput != null

    fun isAgentMessage(): Boolean = agentMessage != null

    fun isMultiAgentCall(): Boolean = multiAgentCall != null

    fun isMultiAgentCallOutput(): Boolean = multiAgentCallOutput != null

    fun isToolSearchCall(): Boolean = toolSearchCall != null

    fun isToolSearchOutput(): Boolean = toolSearchOutput != null

    fun isAdditionalTools(): Boolean = additionalTools != null

    fun isReasoning(): Boolean = reasoning != null

    fun isProgram(): Boolean = program != null

    fun isProgramOutput(): Boolean = programOutput != null

    fun isCompaction(): Boolean = compaction != null

    fun isImageGenerationCall(): Boolean = imageGenerationCall != null

    fun isCodeInterpreterCall(): Boolean = codeInterpreterCall != null

    fun isLocalShellCall(): Boolean = localShellCall != null

    fun isLocalShellCallOutput(): Boolean = localShellCallOutput != null

    fun isShellCall(): Boolean = shellCall != null

    fun isShellCallOutput(): Boolean = shellCallOutput != null

    fun isApplyPatchCall(): Boolean = applyPatchCall != null

    fun isApplyPatchCallOutput(): Boolean = applyPatchCallOutput != null

    fun isMcpListTools(): Boolean = mcpListTools != null

    fun isMcpApprovalRequest(): Boolean = mcpApprovalRequest != null

    fun isMcpApprovalResponse(): Boolean = mcpApprovalResponse != null

    fun isMcpCall(): Boolean = mcpCall != null

    fun isCustomToolCall(): Boolean = customToolCall != null

    fun isCustomToolCallOutput(): Boolean = customToolCallOutput != null

    fun asBetaResponseInputMessageItem(): BetaResponseInputMessageItem =
        betaResponseInputMessageItem.getOrThrow("betaResponseInputMessageItem")

    /** An output message from the model. */
    fun asBetaResponseOutputMessage(): BetaResponseOutputMessage =
        betaResponseOutputMessage.getOrThrow("betaResponseOutputMessage")

    /**
     * The results of a file search tool call. See the
     * [file search guide](https://platform.openai.com/docs/guides/tools-file-search) for more
     * information.
     */
    fun asFileSearchCall(): BetaResponseFileSearchToolCall =
        fileSearchCall.getOrThrow("fileSearchCall")

    /**
     * A tool call to a computer use tool. See the
     * [computer use guide](https://platform.openai.com/docs/guides/tools-computer-use) for more
     * information.
     */
    fun asComputerCall(): BetaResponseComputerToolCall = computerCall.getOrThrow("computerCall")

    fun asComputerCallOutput(): BetaResponseComputerToolCallOutputItem =
        computerCallOutput.getOrThrow("computerCallOutput")

    /**
     * The results of a web search tool call. See the
     * [web search guide](https://platform.openai.com/docs/guides/tools-web-search) for more
     * information.
     */
    fun asWebSearchCall(): BetaResponseFunctionWebSearch = webSearchCall.getOrThrow("webSearchCall")

    /**
     * A tool call to run a function. See the
     * [function calling guide](https://platform.openai.com/docs/guides/function-calling) for more
     * information.
     */
    fun asFunctionCall(): BetaResponseFunctionToolCallItem = functionCall.getOrThrow("functionCall")

    fun asFunctionCallOutput(): BetaResponseFunctionToolCallOutputItem =
        functionCallOutput.getOrThrow("functionCallOutput")

    fun asAgentMessage(): AgentMessage = agentMessage.getOrThrow("agentMessage")

    fun asMultiAgentCall(): MultiAgentCall = multiAgentCall.getOrThrow("multiAgentCall")

    fun asMultiAgentCallOutput(): MultiAgentCallOutput =
        multiAgentCallOutput.getOrThrow("multiAgentCallOutput")

    fun asToolSearchCall(): BetaResponseToolSearchCall = toolSearchCall.getOrThrow("toolSearchCall")

    fun asToolSearchOutput(): BetaResponseToolSearchOutputItem =
        toolSearchOutput.getOrThrow("toolSearchOutput")

    fun asAdditionalTools(): AdditionalTools = additionalTools.getOrThrow("additionalTools")

    /**
     * A description of the chain of thought used by a reasoning model while generating a response.
     * Be sure to include these items in your `input` to the Responses API for subsequent turns of a
     * conversation if you are manually
     * [managing context](https://platform.openai.com/docs/guides/conversation-state).
     */
    fun asReasoning(): BetaResponseReasoningItem = reasoning.getOrThrow("reasoning")

    fun asProgram(): Program = program.getOrThrow("program")

    fun asProgramOutput(): ProgramOutput = programOutput.getOrThrow("programOutput")

    /**
     * A compaction item generated by the
     * [`v1/responses/compact` API](https://platform.openai.com/docs/api-reference/responses/compact).
     */
    fun asCompaction(): BetaResponseCompactionItem = compaction.getOrThrow("compaction")

    /** An image generation request made by the model. */
    fun asImageGenerationCall(): ImageGenerationCall =
        imageGenerationCall.getOrThrow("imageGenerationCall")

    /** A tool call to run code. */
    fun asCodeInterpreterCall(): BetaResponseCodeInterpreterToolCall =
        codeInterpreterCall.getOrThrow("codeInterpreterCall")

    /** A tool call to run a command on the local shell. */
    fun asLocalShellCall(): LocalShellCall = localShellCall.getOrThrow("localShellCall")

    /** The output of a local shell tool call. */
    fun asLocalShellCallOutput(): LocalShellCallOutput =
        localShellCallOutput.getOrThrow("localShellCallOutput")

    /** A tool call that executes one or more shell commands in a managed environment. */
    fun asShellCall(): BetaResponseFunctionShellToolCall = shellCall.getOrThrow("shellCall")

    /** The output of a shell tool call that was emitted. */
    fun asShellCallOutput(): BetaResponseFunctionShellToolCallOutput =
        shellCallOutput.getOrThrow("shellCallOutput")

    /** A tool call that applies file diffs by creating, deleting, or updating files. */
    fun asApplyPatchCall(): BetaResponseApplyPatchToolCall =
        applyPatchCall.getOrThrow("applyPatchCall")

    /** The output emitted by an apply patch tool call. */
    fun asApplyPatchCallOutput(): BetaResponseApplyPatchToolCallOutput =
        applyPatchCallOutput.getOrThrow("applyPatchCallOutput")

    /** A list of tools available on an MCP server. */
    fun asMcpListTools(): McpListTools = mcpListTools.getOrThrow("mcpListTools")

    /** A request for human approval of a tool invocation. */
    fun asMcpApprovalRequest(): McpApprovalRequest =
        mcpApprovalRequest.getOrThrow("mcpApprovalRequest")

    /** A response to an MCP approval request. */
    fun asMcpApprovalResponse(): McpApprovalResponse =
        mcpApprovalResponse.getOrThrow("mcpApprovalResponse")

    /** An invocation of a tool on an MCP server. */
    fun asMcpCall(): McpCall = mcpCall.getOrThrow("mcpCall")

    /** A call to a custom tool created by the model. */
    fun asCustomToolCall(): BetaResponseCustomToolCallItem =
        customToolCall.getOrThrow("customToolCall")

    /** The output of a custom tool call from your code, being sent back to the model. */
    fun asCustomToolCallOutput(): BetaResponseCustomToolCallOutputItem =
        customToolCallOutput.getOrThrow("customToolCallOutput")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    /**
     * Maps this instance's current variant to a value of type [T] using the given [visitor].
     *
     * Note that this method is _not_ forwards compatible with new variants from the API, unless
     * [visitor] overrides [Visitor.unknown]. To handle variants not known to this version of the
     * SDK gracefully, consider overriding [Visitor.unknown]:
     * ```java
     * import com.openai.core.JsonValue;
     * import java.util.Optional;
     *
     * Optional<String> result = betaResponseItem.accept(new BetaResponseItem.Visitor<Optional<String>>() {
     *     @Override
     *     public Optional<String> visitBetaResponseInputMessageItem(BetaResponseInputMessageItem betaResponseInputMessageItem) {
     *         return Optional.of(betaResponseInputMessageItem.toString());
     *     }
     *
     *     // ...
     *
     *     @Override
     *     public Optional<String> unknown(JsonValue json) {
     *         // Or inspect the `json`.
     *         return Optional.empty();
     *     }
     * });
     * ```
     *
     * @throws OpenAIInvalidDataException if [Visitor.unknown] is not overridden in [visitor] and
     *   the current variant is unknown.
     */
    fun <T> accept(visitor: Visitor<T>): T =
        when {
            betaResponseInputMessageItem != null ->
                visitor.visitBetaResponseInputMessageItem(betaResponseInputMessageItem)
            betaResponseOutputMessage != null ->
                visitor.visitBetaResponseOutputMessage(betaResponseOutputMessage)
            fileSearchCall != null -> visitor.visitFileSearchCall(fileSearchCall)
            computerCall != null -> visitor.visitComputerCall(computerCall)
            computerCallOutput != null -> visitor.visitComputerCallOutput(computerCallOutput)
            webSearchCall != null -> visitor.visitWebSearchCall(webSearchCall)
            functionCall != null -> visitor.visitFunctionCall(functionCall)
            functionCallOutput != null -> visitor.visitFunctionCallOutput(functionCallOutput)
            agentMessage != null -> visitor.visitAgentMessage(agentMessage)
            multiAgentCall != null -> visitor.visitMultiAgentCall(multiAgentCall)
            multiAgentCallOutput != null -> visitor.visitMultiAgentCallOutput(multiAgentCallOutput)
            toolSearchCall != null -> visitor.visitToolSearchCall(toolSearchCall)
            toolSearchOutput != null -> visitor.visitToolSearchOutput(toolSearchOutput)
            additionalTools != null -> visitor.visitAdditionalTools(additionalTools)
            reasoning != null -> visitor.visitReasoning(reasoning)
            program != null -> visitor.visitProgram(program)
            programOutput != null -> visitor.visitProgramOutput(programOutput)
            compaction != null -> visitor.visitCompaction(compaction)
            imageGenerationCall != null -> visitor.visitImageGenerationCall(imageGenerationCall)
            codeInterpreterCall != null -> visitor.visitCodeInterpreterCall(codeInterpreterCall)
            localShellCall != null -> visitor.visitLocalShellCall(localShellCall)
            localShellCallOutput != null -> visitor.visitLocalShellCallOutput(localShellCallOutput)
            shellCall != null -> visitor.visitShellCall(shellCall)
            shellCallOutput != null -> visitor.visitShellCallOutput(shellCallOutput)
            applyPatchCall != null -> visitor.visitApplyPatchCall(applyPatchCall)
            applyPatchCallOutput != null -> visitor.visitApplyPatchCallOutput(applyPatchCallOutput)
            mcpListTools != null -> visitor.visitMcpListTools(mcpListTools)
            mcpApprovalRequest != null -> visitor.visitMcpApprovalRequest(mcpApprovalRequest)
            mcpApprovalResponse != null -> visitor.visitMcpApprovalResponse(mcpApprovalResponse)
            mcpCall != null -> visitor.visitMcpCall(mcpCall)
            customToolCall != null -> visitor.visitCustomToolCall(customToolCall)
            customToolCallOutput != null -> visitor.visitCustomToolCallOutput(customToolCallOutput)
            else -> visitor.unknown(_json)
        }

    private var validated: Boolean = false

    /**
     * Validates that the types of all values in this object match their expected types recursively.
     *
     * This method is _not_ forwards compatible with new types from the API for existing fields.
     *
     * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
     *   expected type.
     */
    fun validate(): BetaResponseItem = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitBetaResponseInputMessageItem(
                    betaResponseInputMessageItem: BetaResponseInputMessageItem
                ) {
                    betaResponseInputMessageItem.validate()
                }

                override fun visitBetaResponseOutputMessage(
                    betaResponseOutputMessage: BetaResponseOutputMessage
                ) {
                    betaResponseOutputMessage.validate()
                }

                override fun visitFileSearchCall(fileSearchCall: BetaResponseFileSearchToolCall) {
                    fileSearchCall.validate()
                }

                override fun visitComputerCall(computerCall: BetaResponseComputerToolCall) {
                    computerCall.validate()
                }

                override fun visitComputerCallOutput(
                    computerCallOutput: BetaResponseComputerToolCallOutputItem
                ) {
                    computerCallOutput.validate()
                }

                override fun visitWebSearchCall(webSearchCall: BetaResponseFunctionWebSearch) {
                    webSearchCall.validate()
                }

                override fun visitFunctionCall(functionCall: BetaResponseFunctionToolCallItem) {
                    functionCall.validate()
                }

                override fun visitFunctionCallOutput(
                    functionCallOutput: BetaResponseFunctionToolCallOutputItem
                ) {
                    functionCallOutput.validate()
                }

                override fun visitAgentMessage(agentMessage: AgentMessage) {
                    agentMessage.validate()
                }

                override fun visitMultiAgentCall(multiAgentCall: MultiAgentCall) {
                    multiAgentCall.validate()
                }

                override fun visitMultiAgentCallOutput(multiAgentCallOutput: MultiAgentCallOutput) {
                    multiAgentCallOutput.validate()
                }

                override fun visitToolSearchCall(toolSearchCall: BetaResponseToolSearchCall) {
                    toolSearchCall.validate()
                }

                override fun visitToolSearchOutput(
                    toolSearchOutput: BetaResponseToolSearchOutputItem
                ) {
                    toolSearchOutput.validate()
                }

                override fun visitAdditionalTools(additionalTools: AdditionalTools) {
                    additionalTools.validate()
                }

                override fun visitReasoning(reasoning: BetaResponseReasoningItem) {
                    reasoning.validate()
                }

                override fun visitProgram(program: Program) {
                    program.validate()
                }

                override fun visitProgramOutput(programOutput: ProgramOutput) {
                    programOutput.validate()
                }

                override fun visitCompaction(compaction: BetaResponseCompactionItem) {
                    compaction.validate()
                }

                override fun visitImageGenerationCall(imageGenerationCall: ImageGenerationCall) {
                    imageGenerationCall.validate()
                }

                override fun visitCodeInterpreterCall(
                    codeInterpreterCall: BetaResponseCodeInterpreterToolCall
                ) {
                    codeInterpreterCall.validate()
                }

                override fun visitLocalShellCall(localShellCall: LocalShellCall) {
                    localShellCall.validate()
                }

                override fun visitLocalShellCallOutput(localShellCallOutput: LocalShellCallOutput) {
                    localShellCallOutput.validate()
                }

                override fun visitShellCall(shellCall: BetaResponseFunctionShellToolCall) {
                    shellCall.validate()
                }

                override fun visitShellCallOutput(
                    shellCallOutput: BetaResponseFunctionShellToolCallOutput
                ) {
                    shellCallOutput.validate()
                }

                override fun visitApplyPatchCall(applyPatchCall: BetaResponseApplyPatchToolCall) {
                    applyPatchCall.validate()
                }

                override fun visitApplyPatchCallOutput(
                    applyPatchCallOutput: BetaResponseApplyPatchToolCallOutput
                ) {
                    applyPatchCallOutput.validate()
                }

                override fun visitMcpListTools(mcpListTools: McpListTools) {
                    mcpListTools.validate()
                }

                override fun visitMcpApprovalRequest(mcpApprovalRequest: McpApprovalRequest) {
                    mcpApprovalRequest.validate()
                }

                override fun visitMcpApprovalResponse(mcpApprovalResponse: McpApprovalResponse) {
                    mcpApprovalResponse.validate()
                }

                override fun visitMcpCall(mcpCall: McpCall) {
                    mcpCall.validate()
                }

                override fun visitCustomToolCall(customToolCall: BetaResponseCustomToolCallItem) {
                    customToolCall.validate()
                }

                override fun visitCustomToolCallOutput(
                    customToolCallOutput: BetaResponseCustomToolCallOutputItem
                ) {
                    customToolCallOutput.validate()
                }
            }
        )
        validated = true
    }

    fun isValid(): Boolean =
        try {
            validate()
            true
        } catch (e: OpenAIInvalidDataException) {
            false
        }

    /**
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        accept(
            object : Visitor<Int> {
                override fun visitBetaResponseInputMessageItem(
                    betaResponseInputMessageItem: BetaResponseInputMessageItem
                ) = betaResponseInputMessageItem.validity()

                override fun visitBetaResponseOutputMessage(
                    betaResponseOutputMessage: BetaResponseOutputMessage
                ) = betaResponseOutputMessage.validity()

                override fun visitFileSearchCall(fileSearchCall: BetaResponseFileSearchToolCall) =
                    fileSearchCall.validity()

                override fun visitComputerCall(computerCall: BetaResponseComputerToolCall) =
                    computerCall.validity()

                override fun visitComputerCallOutput(
                    computerCallOutput: BetaResponseComputerToolCallOutputItem
                ) = computerCallOutput.validity()

                override fun visitWebSearchCall(webSearchCall: BetaResponseFunctionWebSearch) =
                    webSearchCall.validity()

                override fun visitFunctionCall(functionCall: BetaResponseFunctionToolCallItem) =
                    functionCall.validity()

                override fun visitFunctionCallOutput(
                    functionCallOutput: BetaResponseFunctionToolCallOutputItem
                ) = functionCallOutput.validity()

                override fun visitAgentMessage(agentMessage: AgentMessage) = agentMessage.validity()

                override fun visitMultiAgentCall(multiAgentCall: MultiAgentCall) =
                    multiAgentCall.validity()

                override fun visitMultiAgentCallOutput(multiAgentCallOutput: MultiAgentCallOutput) =
                    multiAgentCallOutput.validity()

                override fun visitToolSearchCall(toolSearchCall: BetaResponseToolSearchCall) =
                    toolSearchCall.validity()

                override fun visitToolSearchOutput(
                    toolSearchOutput: BetaResponseToolSearchOutputItem
                ) = toolSearchOutput.validity()

                override fun visitAdditionalTools(additionalTools: AdditionalTools) =
                    additionalTools.validity()

                override fun visitReasoning(reasoning: BetaResponseReasoningItem) =
                    reasoning.validity()

                override fun visitProgram(program: Program) = program.validity()

                override fun visitProgramOutput(programOutput: ProgramOutput) =
                    programOutput.validity()

                override fun visitCompaction(compaction: BetaResponseCompactionItem) =
                    compaction.validity()

                override fun visitImageGenerationCall(imageGenerationCall: ImageGenerationCall) =
                    imageGenerationCall.validity()

                override fun visitCodeInterpreterCall(
                    codeInterpreterCall: BetaResponseCodeInterpreterToolCall
                ) = codeInterpreterCall.validity()

                override fun visitLocalShellCall(localShellCall: LocalShellCall) =
                    localShellCall.validity()

                override fun visitLocalShellCallOutput(localShellCallOutput: LocalShellCallOutput) =
                    localShellCallOutput.validity()

                override fun visitShellCall(shellCall: BetaResponseFunctionShellToolCall) =
                    shellCall.validity()

                override fun visitShellCallOutput(
                    shellCallOutput: BetaResponseFunctionShellToolCallOutput
                ) = shellCallOutput.validity()

                override fun visitApplyPatchCall(applyPatchCall: BetaResponseApplyPatchToolCall) =
                    applyPatchCall.validity()

                override fun visitApplyPatchCallOutput(
                    applyPatchCallOutput: BetaResponseApplyPatchToolCallOutput
                ) = applyPatchCallOutput.validity()

                override fun visitMcpListTools(mcpListTools: McpListTools) = mcpListTools.validity()

                override fun visitMcpApprovalRequest(mcpApprovalRequest: McpApprovalRequest) =
                    mcpApprovalRequest.validity()

                override fun visitMcpApprovalResponse(mcpApprovalResponse: McpApprovalResponse) =
                    mcpApprovalResponse.validity()

                override fun visitMcpCall(mcpCall: McpCall) = mcpCall.validity()

                override fun visitCustomToolCall(customToolCall: BetaResponseCustomToolCallItem) =
                    customToolCall.validity()

                override fun visitCustomToolCallOutput(
                    customToolCallOutput: BetaResponseCustomToolCallOutputItem
                ) = customToolCallOutput.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is BetaResponseItem &&
            betaResponseInputMessageItem == other.betaResponseInputMessageItem &&
            betaResponseOutputMessage == other.betaResponseOutputMessage &&
            fileSearchCall == other.fileSearchCall &&
            computerCall == other.computerCall &&
            computerCallOutput == other.computerCallOutput &&
            webSearchCall == other.webSearchCall &&
            functionCall == other.functionCall &&
            functionCallOutput == other.functionCallOutput &&
            agentMessage == other.agentMessage &&
            multiAgentCall == other.multiAgentCall &&
            multiAgentCallOutput == other.multiAgentCallOutput &&
            toolSearchCall == other.toolSearchCall &&
            toolSearchOutput == other.toolSearchOutput &&
            additionalTools == other.additionalTools &&
            reasoning == other.reasoning &&
            program == other.program &&
            programOutput == other.programOutput &&
            compaction == other.compaction &&
            imageGenerationCall == other.imageGenerationCall &&
            codeInterpreterCall == other.codeInterpreterCall &&
            localShellCall == other.localShellCall &&
            localShellCallOutput == other.localShellCallOutput &&
            shellCall == other.shellCall &&
            shellCallOutput == other.shellCallOutput &&
            applyPatchCall == other.applyPatchCall &&
            applyPatchCallOutput == other.applyPatchCallOutput &&
            mcpListTools == other.mcpListTools &&
            mcpApprovalRequest == other.mcpApprovalRequest &&
            mcpApprovalResponse == other.mcpApprovalResponse &&
            mcpCall == other.mcpCall &&
            customToolCall == other.customToolCall &&
            customToolCallOutput == other.customToolCallOutput
    }

    override fun hashCode(): Int =
        Objects.hash(
            betaResponseInputMessageItem,
            betaResponseOutputMessage,
            fileSearchCall,
            computerCall,
            computerCallOutput,
            webSearchCall,
            functionCall,
            functionCallOutput,
            agentMessage,
            multiAgentCall,
            multiAgentCallOutput,
            toolSearchCall,
            toolSearchOutput,
            additionalTools,
            reasoning,
            program,
            programOutput,
            compaction,
            imageGenerationCall,
            codeInterpreterCall,
            localShellCall,
            localShellCallOutput,
            shellCall,
            shellCallOutput,
            applyPatchCall,
            applyPatchCallOutput,
            mcpListTools,
            mcpApprovalRequest,
            mcpApprovalResponse,
            mcpCall,
            customToolCall,
            customToolCallOutput,
        )

    override fun toString(): String =
        when {
            betaResponseInputMessageItem != null ->
                "BetaResponseItem{betaResponseInputMessageItem=$betaResponseInputMessageItem}"
            betaResponseOutputMessage != null ->
                "BetaResponseItem{betaResponseOutputMessage=$betaResponseOutputMessage}"
            fileSearchCall != null -> "BetaResponseItem{fileSearchCall=$fileSearchCall}"
            computerCall != null -> "BetaResponseItem{computerCall=$computerCall}"
            computerCallOutput != null -> "BetaResponseItem{computerCallOutput=$computerCallOutput}"
            webSearchCall != null -> "BetaResponseItem{webSearchCall=$webSearchCall}"
            functionCall != null -> "BetaResponseItem{functionCall=$functionCall}"
            functionCallOutput != null -> "BetaResponseItem{functionCallOutput=$functionCallOutput}"
            agentMessage != null -> "BetaResponseItem{agentMessage=$agentMessage}"
            multiAgentCall != null -> "BetaResponseItem{multiAgentCall=$multiAgentCall}"
            multiAgentCallOutput != null ->
                "BetaResponseItem{multiAgentCallOutput=$multiAgentCallOutput}"
            toolSearchCall != null -> "BetaResponseItem{toolSearchCall=$toolSearchCall}"
            toolSearchOutput != null -> "BetaResponseItem{toolSearchOutput=$toolSearchOutput}"
            additionalTools != null -> "BetaResponseItem{additionalTools=$additionalTools}"
            reasoning != null -> "BetaResponseItem{reasoning=$reasoning}"
            program != null -> "BetaResponseItem{program=$program}"
            programOutput != null -> "BetaResponseItem{programOutput=$programOutput}"
            compaction != null -> "BetaResponseItem{compaction=$compaction}"
            imageGenerationCall != null ->
                "BetaResponseItem{imageGenerationCall=$imageGenerationCall}"
            codeInterpreterCall != null ->
                "BetaResponseItem{codeInterpreterCall=$codeInterpreterCall}"
            localShellCall != null -> "BetaResponseItem{localShellCall=$localShellCall}"
            localShellCallOutput != null ->
                "BetaResponseItem{localShellCallOutput=$localShellCallOutput}"
            shellCall != null -> "BetaResponseItem{shellCall=$shellCall}"
            shellCallOutput != null -> "BetaResponseItem{shellCallOutput=$shellCallOutput}"
            applyPatchCall != null -> "BetaResponseItem{applyPatchCall=$applyPatchCall}"
            applyPatchCallOutput != null ->
                "BetaResponseItem{applyPatchCallOutput=$applyPatchCallOutput}"
            mcpListTools != null -> "BetaResponseItem{mcpListTools=$mcpListTools}"
            mcpApprovalRequest != null -> "BetaResponseItem{mcpApprovalRequest=$mcpApprovalRequest}"
            mcpApprovalResponse != null ->
                "BetaResponseItem{mcpApprovalResponse=$mcpApprovalResponse}"
            mcpCall != null -> "BetaResponseItem{mcpCall=$mcpCall}"
            customToolCall != null -> "BetaResponseItem{customToolCall=$customToolCall}"
            customToolCallOutput != null ->
                "BetaResponseItem{customToolCallOutput=$customToolCallOutput}"
            _json != null -> "BetaResponseItem{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid BetaResponseItem")
        }

    companion object {

        @JvmStatic
        fun ofBetaResponseInputMessageItem(
            betaResponseInputMessageItem: BetaResponseInputMessageItem
        ) = BetaResponseItem(betaResponseInputMessageItem = betaResponseInputMessageItem)

        /** An output message from the model. */
        @JvmStatic
        fun ofBetaResponseOutputMessage(betaResponseOutputMessage: BetaResponseOutputMessage) =
            BetaResponseItem(betaResponseOutputMessage = betaResponseOutputMessage)

        /**
         * The results of a file search tool call. See the
         * [file search guide](https://platform.openai.com/docs/guides/tools-file-search) for more
         * information.
         */
        @JvmStatic
        fun ofFileSearchCall(fileSearchCall: BetaResponseFileSearchToolCall) =
            BetaResponseItem(fileSearchCall = fileSearchCall)

        /**
         * A tool call to a computer use tool. See the
         * [computer use guide](https://platform.openai.com/docs/guides/tools-computer-use) for more
         * information.
         */
        @JvmStatic
        fun ofComputerCall(computerCall: BetaResponseComputerToolCall) =
            BetaResponseItem(computerCall = computerCall)

        @JvmStatic
        fun ofComputerCallOutput(computerCallOutput: BetaResponseComputerToolCallOutputItem) =
            BetaResponseItem(computerCallOutput = computerCallOutput)

        /**
         * The results of a web search tool call. See the
         * [web search guide](https://platform.openai.com/docs/guides/tools-web-search) for more
         * information.
         */
        @JvmStatic
        fun ofWebSearchCall(webSearchCall: BetaResponseFunctionWebSearch) =
            BetaResponseItem(webSearchCall = webSearchCall)

        /**
         * A tool call to run a function. See the
         * [function calling guide](https://platform.openai.com/docs/guides/function-calling) for
         * more information.
         */
        @JvmStatic
        fun ofFunctionCall(functionCall: BetaResponseFunctionToolCallItem) =
            BetaResponseItem(functionCall = functionCall)

        @JvmStatic
        fun ofFunctionCallOutput(functionCallOutput: BetaResponseFunctionToolCallOutputItem) =
            BetaResponseItem(functionCallOutput = functionCallOutput)

        @JvmStatic
        fun ofAgentMessage(agentMessage: AgentMessage) =
            BetaResponseItem(agentMessage = agentMessage)

        @JvmStatic
        fun ofMultiAgentCall(multiAgentCall: MultiAgentCall) =
            BetaResponseItem(multiAgentCall = multiAgentCall)

        @JvmStatic
        fun ofMultiAgentCallOutput(multiAgentCallOutput: MultiAgentCallOutput) =
            BetaResponseItem(multiAgentCallOutput = multiAgentCallOutput)

        @JvmStatic
        fun ofToolSearchCall(toolSearchCall: BetaResponseToolSearchCall) =
            BetaResponseItem(toolSearchCall = toolSearchCall)

        @JvmStatic
        fun ofToolSearchOutput(toolSearchOutput: BetaResponseToolSearchOutputItem) =
            BetaResponseItem(toolSearchOutput = toolSearchOutput)

        @JvmStatic
        fun ofAdditionalTools(additionalTools: AdditionalTools) =
            BetaResponseItem(additionalTools = additionalTools)

        /**
         * A description of the chain of thought used by a reasoning model while generating a
         * response. Be sure to include these items in your `input` to the Responses API for
         * subsequent turns of a conversation if you are manually
         * [managing context](https://platform.openai.com/docs/guides/conversation-state).
         */
        @JvmStatic
        fun ofReasoning(reasoning: BetaResponseReasoningItem) =
            BetaResponseItem(reasoning = reasoning)

        @JvmStatic fun ofProgram(program: Program) = BetaResponseItem(program = program)

        @JvmStatic
        fun ofProgramOutput(programOutput: ProgramOutput) =
            BetaResponseItem(programOutput = programOutput)

        /**
         * A compaction item generated by the
         * [`v1/responses/compact` API](https://platform.openai.com/docs/api-reference/responses/compact).
         */
        @JvmStatic
        fun ofCompaction(compaction: BetaResponseCompactionItem) =
            BetaResponseItem(compaction = compaction)

        /** An image generation request made by the model. */
        @JvmStatic
        fun ofImageGenerationCall(imageGenerationCall: ImageGenerationCall) =
            BetaResponseItem(imageGenerationCall = imageGenerationCall)

        /** A tool call to run code. */
        @JvmStatic
        fun ofCodeInterpreterCall(codeInterpreterCall: BetaResponseCodeInterpreterToolCall) =
            BetaResponseItem(codeInterpreterCall = codeInterpreterCall)

        /** A tool call to run a command on the local shell. */
        @JvmStatic
        fun ofLocalShellCall(localShellCall: LocalShellCall) =
            BetaResponseItem(localShellCall = localShellCall)

        /** The output of a local shell tool call. */
        @JvmStatic
        fun ofLocalShellCallOutput(localShellCallOutput: LocalShellCallOutput) =
            BetaResponseItem(localShellCallOutput = localShellCallOutput)

        /** A tool call that executes one or more shell commands in a managed environment. */
        @JvmStatic
        fun ofShellCall(shellCall: BetaResponseFunctionShellToolCall) =
            BetaResponseItem(shellCall = shellCall)

        /** The output of a shell tool call that was emitted. */
        @JvmStatic
        fun ofShellCallOutput(shellCallOutput: BetaResponseFunctionShellToolCallOutput) =
            BetaResponseItem(shellCallOutput = shellCallOutput)

        /** A tool call that applies file diffs by creating, deleting, or updating files. */
        @JvmStatic
        fun ofApplyPatchCall(applyPatchCall: BetaResponseApplyPatchToolCall) =
            BetaResponseItem(applyPatchCall = applyPatchCall)

        /** The output emitted by an apply patch tool call. */
        @JvmStatic
        fun ofApplyPatchCallOutput(applyPatchCallOutput: BetaResponseApplyPatchToolCallOutput) =
            BetaResponseItem(applyPatchCallOutput = applyPatchCallOutput)

        /** A list of tools available on an MCP server. */
        @JvmStatic
        fun ofMcpListTools(mcpListTools: McpListTools) =
            BetaResponseItem(mcpListTools = mcpListTools)

        /** A request for human approval of a tool invocation. */
        @JvmStatic
        fun ofMcpApprovalRequest(mcpApprovalRequest: McpApprovalRequest) =
            BetaResponseItem(mcpApprovalRequest = mcpApprovalRequest)

        /** A response to an MCP approval request. */
        @JvmStatic
        fun ofMcpApprovalResponse(mcpApprovalResponse: McpApprovalResponse) =
            BetaResponseItem(mcpApprovalResponse = mcpApprovalResponse)

        /** An invocation of a tool on an MCP server. */
        @JvmStatic fun ofMcpCall(mcpCall: McpCall) = BetaResponseItem(mcpCall = mcpCall)

        /** A call to a custom tool created by the model. */
        @JvmStatic
        fun ofCustomToolCall(customToolCall: BetaResponseCustomToolCallItem) =
            BetaResponseItem(customToolCall = customToolCall)

        /** The output of a custom tool call from your code, being sent back to the model. */
        @JvmStatic
        fun ofCustomToolCallOutput(customToolCallOutput: BetaResponseCustomToolCallOutputItem) =
            BetaResponseItem(customToolCallOutput = customToolCallOutput)
    }

    /**
     * An interface that defines how to map each variant of [BetaResponseItem] to a value of type
     * [T].
     */
    interface Visitor<out T> {

        fun visitBetaResponseInputMessageItem(
            betaResponseInputMessageItem: BetaResponseInputMessageItem
        ): T

        /** An output message from the model. */
        fun visitBetaResponseOutputMessage(betaResponseOutputMessage: BetaResponseOutputMessage): T

        /**
         * The results of a file search tool call. See the
         * [file search guide](https://platform.openai.com/docs/guides/tools-file-search) for more
         * information.
         */
        fun visitFileSearchCall(fileSearchCall: BetaResponseFileSearchToolCall): T

        /**
         * A tool call to a computer use tool. See the
         * [computer use guide](https://platform.openai.com/docs/guides/tools-computer-use) for more
         * information.
         */
        fun visitComputerCall(computerCall: BetaResponseComputerToolCall): T

        fun visitComputerCallOutput(computerCallOutput: BetaResponseComputerToolCallOutputItem): T

        /**
         * The results of a web search tool call. See the
         * [web search guide](https://platform.openai.com/docs/guides/tools-web-search) for more
         * information.
         */
        fun visitWebSearchCall(webSearchCall: BetaResponseFunctionWebSearch): T

        /**
         * A tool call to run a function. See the
         * [function calling guide](https://platform.openai.com/docs/guides/function-calling) for
         * more information.
         */
        fun visitFunctionCall(functionCall: BetaResponseFunctionToolCallItem): T

        fun visitFunctionCallOutput(functionCallOutput: BetaResponseFunctionToolCallOutputItem): T

        fun visitAgentMessage(agentMessage: AgentMessage): T

        fun visitMultiAgentCall(multiAgentCall: MultiAgentCall): T

        fun visitMultiAgentCallOutput(multiAgentCallOutput: MultiAgentCallOutput): T

        fun visitToolSearchCall(toolSearchCall: BetaResponseToolSearchCall): T

        fun visitToolSearchOutput(toolSearchOutput: BetaResponseToolSearchOutputItem): T

        fun visitAdditionalTools(additionalTools: AdditionalTools): T

        /**
         * A description of the chain of thought used by a reasoning model while generating a
         * response. Be sure to include these items in your `input` to the Responses API for
         * subsequent turns of a conversation if you are manually
         * [managing context](https://platform.openai.com/docs/guides/conversation-state).
         */
        fun visitReasoning(reasoning: BetaResponseReasoningItem): T

        fun visitProgram(program: Program): T

        fun visitProgramOutput(programOutput: ProgramOutput): T

        /**
         * A compaction item generated by the
         * [`v1/responses/compact` API](https://platform.openai.com/docs/api-reference/responses/compact).
         */
        fun visitCompaction(compaction: BetaResponseCompactionItem): T

        /** An image generation request made by the model. */
        fun visitImageGenerationCall(imageGenerationCall: ImageGenerationCall): T

        /** A tool call to run code. */
        fun visitCodeInterpreterCall(codeInterpreterCall: BetaResponseCodeInterpreterToolCall): T

        /** A tool call to run a command on the local shell. */
        fun visitLocalShellCall(localShellCall: LocalShellCall): T

        /** The output of a local shell tool call. */
        fun visitLocalShellCallOutput(localShellCallOutput: LocalShellCallOutput): T

        /** A tool call that executes one or more shell commands in a managed environment. */
        fun visitShellCall(shellCall: BetaResponseFunctionShellToolCall): T

        /** The output of a shell tool call that was emitted. */
        fun visitShellCallOutput(shellCallOutput: BetaResponseFunctionShellToolCallOutput): T

        /** A tool call that applies file diffs by creating, deleting, or updating files. */
        fun visitApplyPatchCall(applyPatchCall: BetaResponseApplyPatchToolCall): T

        /** The output emitted by an apply patch tool call. */
        fun visitApplyPatchCallOutput(applyPatchCallOutput: BetaResponseApplyPatchToolCallOutput): T

        /** A list of tools available on an MCP server. */
        fun visitMcpListTools(mcpListTools: McpListTools): T

        /** A request for human approval of a tool invocation. */
        fun visitMcpApprovalRequest(mcpApprovalRequest: McpApprovalRequest): T

        /** A response to an MCP approval request. */
        fun visitMcpApprovalResponse(mcpApprovalResponse: McpApprovalResponse): T

        /** An invocation of a tool on an MCP server. */
        fun visitMcpCall(mcpCall: McpCall): T

        /** A call to a custom tool created by the model. */
        fun visitCustomToolCall(customToolCall: BetaResponseCustomToolCallItem): T

        /** The output of a custom tool call from your code, being sent back to the model. */
        fun visitCustomToolCallOutput(customToolCallOutput: BetaResponseCustomToolCallOutputItem): T

        /**
         * Maps an unknown variant of [BetaResponseItem] to a value of type [T].
         *
         * An instance of [BetaResponseItem] can contain an unknown variant if it was deserialized
         * from data that doesn't match any known variant. For example, if the SDK is on an older
         * version than the API, then the API may respond with new variants that the SDK is unaware
         * of.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown BetaResponseItem: $json")
        }
    }

    internal class Deserializer : BaseDeserializer<BetaResponseItem>(BetaResponseItem::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): BetaResponseItem {
            val json = JsonValue.fromJsonNode(node)
            val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

            when (type) {
                "message" -> {
                    val bestMatches =
                        sequenceOf(
                                tryDeserialize(node, jacksonTypeRef<BetaResponseInputMessageItem>())
                                    ?.let {
                                        BetaResponseItem(
                                            betaResponseInputMessageItem = it,
                                            _json = json,
                                        )
                                    },
                                tryDeserialize(node, jacksonTypeRef<BetaResponseOutputMessage>())
                                    ?.let {
                                        BetaResponseItem(
                                            betaResponseOutputMessage = it,
                                            _json = json,
                                        )
                                    },
                            )
                            .filterNotNull()
                            .allMaxBy { it.validity() }
                            .toList()
                    return when (bestMatches.size) {
                        // This can happen if what we're deserializing is completely incompatible
                        // with all the possible variants (e.g. deserializing from boolean).
                        0 -> BetaResponseItem(_json = json)
                        1 -> bestMatches.single()
                        // If there's more than one match with the highest validity, then use the
                        // first completely valid match, or simply the first match if none are
                        // completely valid.
                        else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                    }
                }
                "file_search_call" -> {
                    return tryDeserialize(node, jacksonTypeRef<BetaResponseFileSearchToolCall>())
                        ?.let { BetaResponseItem(fileSearchCall = it, _json = json) }
                        ?: BetaResponseItem(_json = json)
                }
                "computer_call" -> {
                    return tryDeserialize(node, jacksonTypeRef<BetaResponseComputerToolCall>())
                        ?.let { BetaResponseItem(computerCall = it, _json = json) }
                        ?: BetaResponseItem(_json = json)
                }
                "computer_call_output" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<BetaResponseComputerToolCallOutputItem>(),
                        )
                        ?.let { BetaResponseItem(computerCallOutput = it, _json = json) }
                        ?: BetaResponseItem(_json = json)
                }
                "web_search_call" -> {
                    return tryDeserialize(node, jacksonTypeRef<BetaResponseFunctionWebSearch>())
                        ?.let { BetaResponseItem(webSearchCall = it, _json = json) }
                        ?: BetaResponseItem(_json = json)
                }
                "function_call" -> {
                    return tryDeserialize(node, jacksonTypeRef<BetaResponseFunctionToolCallItem>())
                        ?.let { BetaResponseItem(functionCall = it, _json = json) }
                        ?: BetaResponseItem(_json = json)
                }
                "function_call_output" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<BetaResponseFunctionToolCallOutputItem>(),
                        )
                        ?.let { BetaResponseItem(functionCallOutput = it, _json = json) }
                        ?: BetaResponseItem(_json = json)
                }
                "agent_message" -> {
                    return tryDeserialize(node, jacksonTypeRef<AgentMessage>())?.let {
                        BetaResponseItem(agentMessage = it, _json = json)
                    } ?: BetaResponseItem(_json = json)
                }
                "multi_agent_call" -> {
                    return tryDeserialize(node, jacksonTypeRef<MultiAgentCall>())?.let {
                        BetaResponseItem(multiAgentCall = it, _json = json)
                    } ?: BetaResponseItem(_json = json)
                }
                "multi_agent_call_output" -> {
                    return tryDeserialize(node, jacksonTypeRef<MultiAgentCallOutput>())?.let {
                        BetaResponseItem(multiAgentCallOutput = it, _json = json)
                    } ?: BetaResponseItem(_json = json)
                }
                "tool_search_call" -> {
                    return tryDeserialize(node, jacksonTypeRef<BetaResponseToolSearchCall>())?.let {
                        BetaResponseItem(toolSearchCall = it, _json = json)
                    } ?: BetaResponseItem(_json = json)
                }
                "tool_search_output" -> {
                    return tryDeserialize(node, jacksonTypeRef<BetaResponseToolSearchOutputItem>())
                        ?.let { BetaResponseItem(toolSearchOutput = it, _json = json) }
                        ?: BetaResponseItem(_json = json)
                }
                "additional_tools" -> {
                    return tryDeserialize(node, jacksonTypeRef<AdditionalTools>())?.let {
                        BetaResponseItem(additionalTools = it, _json = json)
                    } ?: BetaResponseItem(_json = json)
                }
                "reasoning" -> {
                    return tryDeserialize(node, jacksonTypeRef<BetaResponseReasoningItem>())?.let {
                        BetaResponseItem(reasoning = it, _json = json)
                    } ?: BetaResponseItem(_json = json)
                }
                "program" -> {
                    return tryDeserialize(node, jacksonTypeRef<Program>())?.let {
                        BetaResponseItem(program = it, _json = json)
                    } ?: BetaResponseItem(_json = json)
                }
                "program_output" -> {
                    return tryDeserialize(node, jacksonTypeRef<ProgramOutput>())?.let {
                        BetaResponseItem(programOutput = it, _json = json)
                    } ?: BetaResponseItem(_json = json)
                }
                "compaction" -> {
                    return tryDeserialize(node, jacksonTypeRef<BetaResponseCompactionItem>())?.let {
                        BetaResponseItem(compaction = it, _json = json)
                    } ?: BetaResponseItem(_json = json)
                }
                "image_generation_call" -> {
                    return tryDeserialize(node, jacksonTypeRef<ImageGenerationCall>())?.let {
                        BetaResponseItem(imageGenerationCall = it, _json = json)
                    } ?: BetaResponseItem(_json = json)
                }
                "code_interpreter_call" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<BetaResponseCodeInterpreterToolCall>(),
                        )
                        ?.let { BetaResponseItem(codeInterpreterCall = it, _json = json) }
                        ?: BetaResponseItem(_json = json)
                }
                "local_shell_call" -> {
                    return tryDeserialize(node, jacksonTypeRef<LocalShellCall>())?.let {
                        BetaResponseItem(localShellCall = it, _json = json)
                    } ?: BetaResponseItem(_json = json)
                }
                "local_shell_call_output" -> {
                    return tryDeserialize(node, jacksonTypeRef<LocalShellCallOutput>())?.let {
                        BetaResponseItem(localShellCallOutput = it, _json = json)
                    } ?: BetaResponseItem(_json = json)
                }
                "shell_call" -> {
                    return tryDeserialize(node, jacksonTypeRef<BetaResponseFunctionShellToolCall>())
                        ?.let { BetaResponseItem(shellCall = it, _json = json) }
                        ?: BetaResponseItem(_json = json)
                }
                "shell_call_output" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<BetaResponseFunctionShellToolCallOutput>(),
                        )
                        ?.let { BetaResponseItem(shellCallOutput = it, _json = json) }
                        ?: BetaResponseItem(_json = json)
                }
                "apply_patch_call" -> {
                    return tryDeserialize(node, jacksonTypeRef<BetaResponseApplyPatchToolCall>())
                        ?.let { BetaResponseItem(applyPatchCall = it, _json = json) }
                        ?: BetaResponseItem(_json = json)
                }
                "apply_patch_call_output" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<BetaResponseApplyPatchToolCallOutput>(),
                        )
                        ?.let { BetaResponseItem(applyPatchCallOutput = it, _json = json) }
                        ?: BetaResponseItem(_json = json)
                }
                "mcp_list_tools" -> {
                    return tryDeserialize(node, jacksonTypeRef<McpListTools>())?.let {
                        BetaResponseItem(mcpListTools = it, _json = json)
                    } ?: BetaResponseItem(_json = json)
                }
                "mcp_approval_request" -> {
                    return tryDeserialize(node, jacksonTypeRef<McpApprovalRequest>())?.let {
                        BetaResponseItem(mcpApprovalRequest = it, _json = json)
                    } ?: BetaResponseItem(_json = json)
                }
                "mcp_approval_response" -> {
                    return tryDeserialize(node, jacksonTypeRef<McpApprovalResponse>())?.let {
                        BetaResponseItem(mcpApprovalResponse = it, _json = json)
                    } ?: BetaResponseItem(_json = json)
                }
                "mcp_call" -> {
                    return tryDeserialize(node, jacksonTypeRef<McpCall>())?.let {
                        BetaResponseItem(mcpCall = it, _json = json)
                    } ?: BetaResponseItem(_json = json)
                }
                "custom_tool_call" -> {
                    return tryDeserialize(node, jacksonTypeRef<BetaResponseCustomToolCallItem>())
                        ?.let { BetaResponseItem(customToolCall = it, _json = json) }
                        ?: BetaResponseItem(_json = json)
                }
                "custom_tool_call_output" -> {
                    return tryDeserialize(
                            node,
                            jacksonTypeRef<BetaResponseCustomToolCallOutputItem>(),
                        )
                        ?.let { BetaResponseItem(customToolCallOutput = it, _json = json) }
                        ?: BetaResponseItem(_json = json)
                }
            }

            return BetaResponseItem(_json = json)
        }
    }

    internal class Serializer : BaseSerializer<BetaResponseItem>(BetaResponseItem::class) {

        override fun serialize(
            value: BetaResponseItem,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.betaResponseInputMessageItem != null ->
                    generator.writeObject(value.betaResponseInputMessageItem)
                value.betaResponseOutputMessage != null ->
                    generator.writeObject(value.betaResponseOutputMessage)
                value.fileSearchCall != null -> generator.writeObject(value.fileSearchCall)
                value.computerCall != null -> generator.writeObject(value.computerCall)
                value.computerCallOutput != null -> generator.writeObject(value.computerCallOutput)
                value.webSearchCall != null -> generator.writeObject(value.webSearchCall)
                value.functionCall != null -> generator.writeObject(value.functionCall)
                value.functionCallOutput != null -> generator.writeObject(value.functionCallOutput)
                value.agentMessage != null -> generator.writeObject(value.agentMessage)
                value.multiAgentCall != null -> generator.writeObject(value.multiAgentCall)
                value.multiAgentCallOutput != null ->
                    generator.writeObject(value.multiAgentCallOutput)
                value.toolSearchCall != null -> generator.writeObject(value.toolSearchCall)
                value.toolSearchOutput != null -> generator.writeObject(value.toolSearchOutput)
                value.additionalTools != null -> generator.writeObject(value.additionalTools)
                value.reasoning != null -> generator.writeObject(value.reasoning)
                value.program != null -> generator.writeObject(value.program)
                value.programOutput != null -> generator.writeObject(value.programOutput)
                value.compaction != null -> generator.writeObject(value.compaction)
                value.imageGenerationCall != null ->
                    generator.writeObject(value.imageGenerationCall)
                value.codeInterpreterCall != null ->
                    generator.writeObject(value.codeInterpreterCall)
                value.localShellCall != null -> generator.writeObject(value.localShellCall)
                value.localShellCallOutput != null ->
                    generator.writeObject(value.localShellCallOutput)
                value.shellCall != null -> generator.writeObject(value.shellCall)
                value.shellCallOutput != null -> generator.writeObject(value.shellCallOutput)
                value.applyPatchCall != null -> generator.writeObject(value.applyPatchCall)
                value.applyPatchCallOutput != null ->
                    generator.writeObject(value.applyPatchCallOutput)
                value.mcpListTools != null -> generator.writeObject(value.mcpListTools)
                value.mcpApprovalRequest != null -> generator.writeObject(value.mcpApprovalRequest)
                value.mcpApprovalResponse != null ->
                    generator.writeObject(value.mcpApprovalResponse)
                value.mcpCall != null -> generator.writeObject(value.mcpCall)
                value.customToolCall != null -> generator.writeObject(value.customToolCall)
                value.customToolCallOutput != null ->
                    generator.writeObject(value.customToolCallOutput)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid BetaResponseItem")
            }
        }
    }

    class AgentMessage
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val author: JsonField<String>,
        private val content: JsonField<List<Content>>,
        private val recipient: JsonField<String>,
        private val type: JsonValue,
        private val agent: JsonField<Agent>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("author") @ExcludeMissing author: JsonField<String> = JsonMissing.of(),
            @JsonProperty("content")
            @ExcludeMissing
            content: JsonField<List<Content>> = JsonMissing.of(),
            @JsonProperty("recipient")
            @ExcludeMissing
            recipient: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("agent") @ExcludeMissing agent: JsonField<Agent> = JsonMissing.of(),
        ) : this(id, author, content, recipient, type, agent, mutableMapOf())

        /**
         * The unique ID of the agent message.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun id(): String = id.getRequired("id")

        /**
         * The sending agent identity.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun author(): String = author.getRequired("author")

        /**
         * Encrypted content sent between agents.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun content(): List<Content> = content.getRequired("content")

        /**
         * The destination agent identity.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun recipient(): String = recipient.getRequired("recipient")

        /**
         * The type of the item. Always `agent_message`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("agent_message")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * The agent that produced this item.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun agent(): Optional<Agent> = agent.getOptional("agent")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [author].
         *
         * Unlike [author], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("author") @ExcludeMissing fun _author(): JsonField<String> = author

        /**
         * Returns the raw JSON value of [content].
         *
         * Unlike [content], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("content") @ExcludeMissing fun _content(): JsonField<List<Content>> = content

        /**
         * Returns the raw JSON value of [recipient].
         *
         * Unlike [recipient], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("recipient") @ExcludeMissing fun _recipient(): JsonField<String> = recipient

        /**
         * Returns the raw JSON value of [agent].
         *
         * Unlike [agent], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("agent") @ExcludeMissing fun _agent(): JsonField<Agent> = agent

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [AgentMessage].
             *
             * The following fields are required:
             * ```java
             * .id()
             * .author()
             * .content()
             * .recipient()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [AgentMessage]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var author: JsonField<String>? = null
            private var content: JsonField<MutableList<Content>>? = null
            private var recipient: JsonField<String>? = null
            private var type: JsonValue = JsonValue.from("agent_message")
            private var agent: JsonField<Agent> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(agentMessage: AgentMessage) = apply {
                id = agentMessage.id
                author = agentMessage.author
                content = agentMessage.content.map { it.toMutableList() }
                recipient = agentMessage.recipient
                type = agentMessage.type
                agent = agentMessage.agent
                additionalProperties = agentMessage.additionalProperties.toMutableMap()
            }

            /** The unique ID of the agent message. */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /** The sending agent identity. */
            fun author(author: String) = author(JsonField.of(author))

            /**
             * Sets [Builder.author] to an arbitrary JSON value.
             *
             * You should usually call [Builder.author] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun author(author: JsonField<String>) = apply { this.author = author }

            /** Encrypted content sent between agents. */
            fun content(content: List<Content>) = content(JsonField.of(content))

            /**
             * Sets [Builder.content] to an arbitrary JSON value.
             *
             * You should usually call [Builder.content] with a well-typed `List<Content>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun content(content: JsonField<List<Content>>) = apply {
                this.content = content.map { it.toMutableList() }
            }

            /**
             * Adds a single [Content] to [Builder.content].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addContent(content: Content) = apply {
                this.content =
                    (this.content ?: JsonField.of(mutableListOf())).also {
                        checkKnown("content", it).add(content)
                    }
            }

            /** Alias for calling [addContent] with `Content.ofInputText(inputText)`. */
            fun addContent(inputText: BetaResponseInputText) =
                addContent(Content.ofInputText(inputText))

            /**
             * Alias for calling [addContent] with the following:
             * ```java
             * BetaResponseInputText.builder()
             *     .text(text)
             *     .build()
             * ```
             */
            fun addInputTextContent(text: String) =
                addContent(BetaResponseInputText.builder().text(text).build())

            /** Alias for calling [addContent] with `Content.ofOutputText(outputText)`. */
            fun addContent(outputText: BetaResponseOutputText) =
                addContent(Content.ofOutputText(outputText))

            /** Alias for calling [addContent] with `Content.ofText(text)`. */
            fun addContent(text: Content.Text) = addContent(Content.ofText(text))

            /**
             * Alias for calling [addContent] with the following:
             * ```java
             * Content.Text.builder()
             *     .text(text)
             *     .build()
             * ```
             */
            fun addTextContent(text: String) = addContent(Content.Text.builder().text(text).build())

            /** Alias for calling [addContent] with `Content.ofSummaryText(summaryText)`. */
            fun addContent(summaryText: Content.SummaryText) =
                addContent(Content.ofSummaryText(summaryText))

            /**
             * Alias for calling [addContent] with the following:
             * ```java
             * Content.SummaryText.builder()
             *     .text(text)
             *     .build()
             * ```
             */
            fun addSummaryTextContent(text: String) =
                addContent(Content.SummaryText.builder().text(text).build())

            /** Alias for calling [addContent] with `Content.ofReasoningText(reasoningText)`. */
            fun addContent(reasoningText: Content.ReasoningText) =
                addContent(Content.ofReasoningText(reasoningText))

            /**
             * Alias for calling [addContent] with the following:
             * ```java
             * Content.ReasoningText.builder()
             *     .text(text)
             *     .build()
             * ```
             */
            fun addReasoningTextContent(text: String) =
                addContent(Content.ReasoningText.builder().text(text).build())

            /** Alias for calling [addContent] with `Content.ofRefusal(refusal)`. */
            fun addContent(refusal: BetaResponseOutputRefusal) =
                addContent(Content.ofRefusal(refusal))

            /**
             * Alias for calling [addContent] with the following:
             * ```java
             * BetaResponseOutputRefusal.builder()
             *     .refusal(refusal)
             *     .build()
             * ```
             */
            fun addRefusalContent(refusal: String) =
                addContent(BetaResponseOutputRefusal.builder().refusal(refusal).build())

            /** Alias for calling [addContent] with `Content.ofInputImage(inputImage)`. */
            fun addContent(inputImage: BetaResponseInputImage) =
                addContent(Content.ofInputImage(inputImage))

            /**
             * Alias for calling [addContent] with the following:
             * ```java
             * BetaResponseInputImage.builder()
             *     .detail(detail)
             *     .build()
             * ```
             */
            fun addInputImageContent(detail: BetaResponseInputImage.Detail) =
                addContent(BetaResponseInputImage.builder().detail(detail).build())

            /**
             * Alias for calling [addContent] with
             * `Content.ofComputerScreenshot(computerScreenshot)`.
             */
            fun addContent(computerScreenshot: Content.ComputerScreenshot) =
                addContent(Content.ofComputerScreenshot(computerScreenshot))

            /** Alias for calling [addContent] with `Content.ofInputFile(inputFile)`. */
            fun addContent(inputFile: BetaResponseInputFile) =
                addContent(Content.ofInputFile(inputFile))

            /** Alias for calling [addContent] with `Content.ofEncrypted(encrypted)`. */
            fun addContent(encrypted: Content.EncryptedContent) =
                addContent(Content.ofEncrypted(encrypted))

            /**
             * Alias for calling [addContent] with the following:
             * ```java
             * Content.EncryptedContent.builder()
             *     .encryptedContent(encryptedContent)
             *     .build()
             * ```
             */
            fun addEncryptedContent(encryptedContent: String) =
                addContent(
                    Content.EncryptedContent.builder().encryptedContent(encryptedContent).build()
                )

            /** The destination agent identity. */
            fun recipient(recipient: String) = recipient(JsonField.of(recipient))

            /**
             * Sets [Builder.recipient] to an arbitrary JSON value.
             *
             * You should usually call [Builder.recipient] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun recipient(recipient: JsonField<String>) = apply { this.recipient = recipient }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("agent_message")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

            /** The agent that produced this item. */
            fun agent(agent: Agent) = agent(JsonField.of(agent))

            /**
             * Sets [Builder.agent] to an arbitrary JSON value.
             *
             * You should usually call [Builder.agent] with a well-typed [Agent] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun agent(agent: JsonField<Agent>) = apply { this.agent = agent }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            /**
             * Returns an immutable instance of [AgentMessage].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .id()
             * .author()
             * .content()
             * .recipient()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): AgentMessage =
                AgentMessage(
                    checkRequired("id", id),
                    checkRequired("author", author),
                    checkRequired("content", content).map { it.toImmutable() },
                    checkRequired("recipient", recipient),
                    type,
                    agent,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
        fun validate(): AgentMessage = apply {
            if (validated) {
                return@apply
            }

            id()
            author()
            content().forEach { it.validate() }
            recipient()
            _type().let {
                if (it != JsonValue.from("agent_message")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
            agent().ifPresent { it.validate() }
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: OpenAIInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (if (id.asKnown().isPresent) 1 else 0) +
                (if (author.asKnown().isPresent) 1 else 0) +
                (content.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (if (recipient.asKnown().isPresent) 1 else 0) +
                type.let { if (it == JsonValue.from("agent_message")) 1 else 0 } +
                (agent.asKnown().getOrNull()?.validity() ?: 0)

        /** A content part that makes up an input or output item. */
        @JsonDeserialize(using = Content.Deserializer::class)
        @JsonSerialize(using = Content.Serializer::class)
        class Content
        private constructor(
            private val inputText: BetaResponseInputText? = null,
            private val outputText: BetaResponseOutputText? = null,
            private val text: Text? = null,
            private val summaryText: SummaryText? = null,
            private val reasoningText: ReasoningText? = null,
            private val refusal: BetaResponseOutputRefusal? = null,
            private val inputImage: BetaResponseInputImage? = null,
            private val computerScreenshot: ComputerScreenshot? = null,
            private val inputFile: BetaResponseInputFile? = null,
            private val encrypted: EncryptedContent? = null,
            private val _json: JsonValue? = null,
        ) {

            /** A text input to the model. */
            fun inputText(): Optional<BetaResponseInputText> = Optional.ofNullable(inputText)

            /** A text output from the model. */
            fun outputText(): Optional<BetaResponseOutputText> = Optional.ofNullable(outputText)

            /** A text content. */
            fun text(): Optional<Text> = Optional.ofNullable(text)

            /** A summary text from the model. */
            fun summaryText(): Optional<SummaryText> = Optional.ofNullable(summaryText)

            /** Reasoning text from the model. */
            fun reasoningText(): Optional<ReasoningText> = Optional.ofNullable(reasoningText)

            /** A refusal from the model. */
            fun refusal(): Optional<BetaResponseOutputRefusal> = Optional.ofNullable(refusal)

            /**
             * An image input to the model. Learn about
             * [image inputs](https://platform.openai.com/docs/guides/vision).
             */
            fun inputImage(): Optional<BetaResponseInputImage> = Optional.ofNullable(inputImage)

            /** A screenshot of a computer. */
            fun computerScreenshot(): Optional<ComputerScreenshot> =
                Optional.ofNullable(computerScreenshot)

            /** A file input to the model. */
            fun inputFile(): Optional<BetaResponseInputFile> = Optional.ofNullable(inputFile)

            /**
             * Opaque encrypted content that Responses API decrypts inside trusted model execution.
             */
            fun encrypted(): Optional<EncryptedContent> = Optional.ofNullable(encrypted)

            fun isInputText(): Boolean = inputText != null

            fun isOutputText(): Boolean = outputText != null

            fun isText(): Boolean = text != null

            fun isSummaryText(): Boolean = summaryText != null

            fun isReasoningText(): Boolean = reasoningText != null

            fun isRefusal(): Boolean = refusal != null

            fun isInputImage(): Boolean = inputImage != null

            fun isComputerScreenshot(): Boolean = computerScreenshot != null

            fun isInputFile(): Boolean = inputFile != null

            fun isEncrypted(): Boolean = encrypted != null

            /** A text input to the model. */
            fun asInputText(): BetaResponseInputText = inputText.getOrThrow("inputText")

            /** A text output from the model. */
            fun asOutputText(): BetaResponseOutputText = outputText.getOrThrow("outputText")

            /** A text content. */
            fun asText(): Text = text.getOrThrow("text")

            /** A summary text from the model. */
            fun asSummaryText(): SummaryText = summaryText.getOrThrow("summaryText")

            /** Reasoning text from the model. */
            fun asReasoningText(): ReasoningText = reasoningText.getOrThrow("reasoningText")

            /** A refusal from the model. */
            fun asRefusal(): BetaResponseOutputRefusal = refusal.getOrThrow("refusal")

            /**
             * An image input to the model. Learn about
             * [image inputs](https://platform.openai.com/docs/guides/vision).
             */
            fun asInputImage(): BetaResponseInputImage = inputImage.getOrThrow("inputImage")

            /** A screenshot of a computer. */
            fun asComputerScreenshot(): ComputerScreenshot =
                computerScreenshot.getOrThrow("computerScreenshot")

            /** A file input to the model. */
            fun asInputFile(): BetaResponseInputFile = inputFile.getOrThrow("inputFile")

            /**
             * Opaque encrypted content that Responses API decrypts inside trusted model execution.
             */
            fun asEncrypted(): EncryptedContent = encrypted.getOrThrow("encrypted")

            fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

            /**
             * Maps this instance's current variant to a value of type [T] using the given
             * [visitor].
             *
             * Note that this method is _not_ forwards compatible with new variants from the API,
             * unless [visitor] overrides [Visitor.unknown]. To handle variants not known to this
             * version of the SDK gracefully, consider overriding [Visitor.unknown]:
             * ```java
             * import com.openai.core.JsonValue;
             * import java.util.Optional;
             *
             * Optional<String> result = content.accept(new Content.Visitor<Optional<String>>() {
             *     @Override
             *     public Optional<String> visitInputText(BetaResponseInputText inputText) {
             *         return Optional.of(inputText.toString());
             *     }
             *
             *     // ...
             *
             *     @Override
             *     public Optional<String> unknown(JsonValue json) {
             *         // Or inspect the `json`.
             *         return Optional.empty();
             *     }
             * });
             * ```
             *
             * @throws OpenAIInvalidDataException if [Visitor.unknown] is not overridden in
             *   [visitor] and the current variant is unknown.
             */
            fun <T> accept(visitor: Visitor<T>): T =
                when {
                    inputText != null -> visitor.visitInputText(inputText)
                    outputText != null -> visitor.visitOutputText(outputText)
                    text != null -> visitor.visitText(text)
                    summaryText != null -> visitor.visitSummaryText(summaryText)
                    reasoningText != null -> visitor.visitReasoningText(reasoningText)
                    refusal != null -> visitor.visitRefusal(refusal)
                    inputImage != null -> visitor.visitInputImage(inputImage)
                    computerScreenshot != null ->
                        visitor.visitComputerScreenshot(computerScreenshot)
                    inputFile != null -> visitor.visitInputFile(inputFile)
                    encrypted != null -> visitor.visitEncrypted(encrypted)
                    else -> visitor.unknown(_json)
                }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
            fun validate(): Content = apply {
                if (validated) {
                    return@apply
                }

                accept(
                    object : Visitor<Unit> {
                        override fun visitInputText(inputText: BetaResponseInputText) {
                            inputText.validate()
                        }

                        override fun visitOutputText(outputText: BetaResponseOutputText) {
                            outputText.validate()
                        }

                        override fun visitText(text: Text) {
                            text.validate()
                        }

                        override fun visitSummaryText(summaryText: SummaryText) {
                            summaryText.validate()
                        }

                        override fun visitReasoningText(reasoningText: ReasoningText) {
                            reasoningText.validate()
                        }

                        override fun visitRefusal(refusal: BetaResponseOutputRefusal) {
                            refusal.validate()
                        }

                        override fun visitInputImage(inputImage: BetaResponseInputImage) {
                            inputImage.validate()
                        }

                        override fun visitComputerScreenshot(
                            computerScreenshot: ComputerScreenshot
                        ) {
                            computerScreenshot.validate()
                        }

                        override fun visitInputFile(inputFile: BetaResponseInputFile) {
                            inputFile.validate()
                        }

                        override fun visitEncrypted(encrypted: EncryptedContent) {
                            encrypted.validate()
                        }
                    }
                )
                validated = true
            }

            fun isValid(): Boolean =
                try {
                    validate()
                    true
                } catch (e: OpenAIInvalidDataException) {
                    false
                }

            /**
             * Returns a score indicating how many valid values are contained in this object
             * recursively.
             *
             * Used for best match union deserialization.
             */
            @JvmSynthetic
            internal fun validity(): Int =
                accept(
                    object : Visitor<Int> {
                        override fun visitInputText(inputText: BetaResponseInputText) =
                            inputText.validity()

                        override fun visitOutputText(outputText: BetaResponseOutputText) =
                            outputText.validity()

                        override fun visitText(text: Text) = text.validity()

                        override fun visitSummaryText(summaryText: SummaryText) =
                            summaryText.validity()

                        override fun visitReasoningText(reasoningText: ReasoningText) =
                            reasoningText.validity()

                        override fun visitRefusal(refusal: BetaResponseOutputRefusal) =
                            refusal.validity()

                        override fun visitInputImage(inputImage: BetaResponseInputImage) =
                            inputImage.validity()

                        override fun visitComputerScreenshot(
                            computerScreenshot: ComputerScreenshot
                        ) = computerScreenshot.validity()

                        override fun visitInputFile(inputFile: BetaResponseInputFile) =
                            inputFile.validity()

                        override fun visitEncrypted(encrypted: EncryptedContent) =
                            encrypted.validity()

                        override fun unknown(json: JsonValue?) = 0
                    }
                )

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Content &&
                    inputText == other.inputText &&
                    outputText == other.outputText &&
                    text == other.text &&
                    summaryText == other.summaryText &&
                    reasoningText == other.reasoningText &&
                    refusal == other.refusal &&
                    inputImage == other.inputImage &&
                    computerScreenshot == other.computerScreenshot &&
                    inputFile == other.inputFile &&
                    encrypted == other.encrypted
            }

            override fun hashCode(): Int =
                Objects.hash(
                    inputText,
                    outputText,
                    text,
                    summaryText,
                    reasoningText,
                    refusal,
                    inputImage,
                    computerScreenshot,
                    inputFile,
                    encrypted,
                )

            override fun toString(): String =
                when {
                    inputText != null -> "Content{inputText=$inputText}"
                    outputText != null -> "Content{outputText=$outputText}"
                    text != null -> "Content{text=$text}"
                    summaryText != null -> "Content{summaryText=$summaryText}"
                    reasoningText != null -> "Content{reasoningText=$reasoningText}"
                    refusal != null -> "Content{refusal=$refusal}"
                    inputImage != null -> "Content{inputImage=$inputImage}"
                    computerScreenshot != null -> "Content{computerScreenshot=$computerScreenshot}"
                    inputFile != null -> "Content{inputFile=$inputFile}"
                    encrypted != null -> "Content{encrypted=$encrypted}"
                    _json != null -> "Content{_unknown=$_json}"
                    else -> throw IllegalStateException("Invalid Content")
                }

            companion object {

                /** A text input to the model. */
                @JvmStatic
                fun ofInputText(inputText: BetaResponseInputText) = Content(inputText = inputText)

                /** A text output from the model. */
                @JvmStatic
                fun ofOutputText(outputText: BetaResponseOutputText) =
                    Content(outputText = outputText)

                /** A text content. */
                @JvmStatic fun ofText(text: Text) = Content(text = text)

                /** A summary text from the model. */
                @JvmStatic
                fun ofSummaryText(summaryText: SummaryText) = Content(summaryText = summaryText)

                /** Reasoning text from the model. */
                @JvmStatic
                fun ofReasoningText(reasoningText: ReasoningText) =
                    Content(reasoningText = reasoningText)

                /** A refusal from the model. */
                @JvmStatic
                fun ofRefusal(refusal: BetaResponseOutputRefusal) = Content(refusal = refusal)

                /**
                 * An image input to the model. Learn about
                 * [image inputs](https://platform.openai.com/docs/guides/vision).
                 */
                @JvmStatic
                fun ofInputImage(inputImage: BetaResponseInputImage) =
                    Content(inputImage = inputImage)

                /** A screenshot of a computer. */
                @JvmStatic
                fun ofComputerScreenshot(computerScreenshot: ComputerScreenshot) =
                    Content(computerScreenshot = computerScreenshot)

                /** A file input to the model. */
                @JvmStatic
                fun ofInputFile(inputFile: BetaResponseInputFile) = Content(inputFile = inputFile)

                /**
                 * Opaque encrypted content that Responses API decrypts inside trusted model
                 * execution.
                 */
                @JvmStatic
                fun ofEncrypted(encrypted: EncryptedContent) = Content(encrypted = encrypted)
            }

            /**
             * An interface that defines how to map each variant of [Content] to a value of type
             * [T].
             */
            interface Visitor<out T> {

                /** A text input to the model. */
                fun visitInputText(inputText: BetaResponseInputText): T

                /** A text output from the model. */
                fun visitOutputText(outputText: BetaResponseOutputText): T

                /** A text content. */
                fun visitText(text: Text): T

                /** A summary text from the model. */
                fun visitSummaryText(summaryText: SummaryText): T

                /** Reasoning text from the model. */
                fun visitReasoningText(reasoningText: ReasoningText): T

                /** A refusal from the model. */
                fun visitRefusal(refusal: BetaResponseOutputRefusal): T

                /**
                 * An image input to the model. Learn about
                 * [image inputs](https://platform.openai.com/docs/guides/vision).
                 */
                fun visitInputImage(inputImage: BetaResponseInputImage): T

                /** A screenshot of a computer. */
                fun visitComputerScreenshot(computerScreenshot: ComputerScreenshot): T

                /** A file input to the model. */
                fun visitInputFile(inputFile: BetaResponseInputFile): T

                /**
                 * Opaque encrypted content that Responses API decrypts inside trusted model
                 * execution.
                 */
                fun visitEncrypted(encrypted: EncryptedContent): T

                /**
                 * Maps an unknown variant of [Content] to a value of type [T].
                 *
                 * An instance of [Content] can contain an unknown variant if it was deserialized
                 * from data that doesn't match any known variant. For example, if the SDK is on an
                 * older version than the API, then the API may respond with new variants that the
                 * SDK is unaware of.
                 *
                 * @throws OpenAIInvalidDataException in the default implementation.
                 */
                fun unknown(json: JsonValue?): T {
                    throw OpenAIInvalidDataException("Unknown Content: $json")
                }
            }

            internal class Deserializer : BaseDeserializer<Content>(Content::class) {

                override fun ObjectCodec.deserialize(node: JsonNode): Content {
                    val json = JsonValue.fromJsonNode(node)
                    val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

                    when (type) {
                        "input_text" -> {
                            return tryDeserialize(node, jacksonTypeRef<BetaResponseInputText>())
                                ?.let { Content(inputText = it, _json = json) }
                                ?: Content(_json = json)
                        }
                        "output_text" -> {
                            return tryDeserialize(node, jacksonTypeRef<BetaResponseOutputText>())
                                ?.let { Content(outputText = it, _json = json) }
                                ?: Content(_json = json)
                        }
                        "text" -> {
                            return tryDeserialize(node, jacksonTypeRef<Text>())?.let {
                                Content(text = it, _json = json)
                            } ?: Content(_json = json)
                        }
                        "summary_text" -> {
                            return tryDeserialize(node, jacksonTypeRef<SummaryText>())?.let {
                                Content(summaryText = it, _json = json)
                            } ?: Content(_json = json)
                        }
                        "reasoning_text" -> {
                            return tryDeserialize(node, jacksonTypeRef<ReasoningText>())?.let {
                                Content(reasoningText = it, _json = json)
                            } ?: Content(_json = json)
                        }
                        "refusal" -> {
                            return tryDeserialize(node, jacksonTypeRef<BetaResponseOutputRefusal>())
                                ?.let { Content(refusal = it, _json = json) }
                                ?: Content(_json = json)
                        }
                        "input_image" -> {
                            return tryDeserialize(node, jacksonTypeRef<BetaResponseInputImage>())
                                ?.let { Content(inputImage = it, _json = json) }
                                ?: Content(_json = json)
                        }
                        "computer_screenshot" -> {
                            return tryDeserialize(node, jacksonTypeRef<ComputerScreenshot>())?.let {
                                Content(computerScreenshot = it, _json = json)
                            } ?: Content(_json = json)
                        }
                        "input_file" -> {
                            return tryDeserialize(node, jacksonTypeRef<BetaResponseInputFile>())
                                ?.let { Content(inputFile = it, _json = json) }
                                ?: Content(_json = json)
                        }
                        "encrypted_content" -> {
                            return tryDeserialize(node, jacksonTypeRef<EncryptedContent>())?.let {
                                Content(encrypted = it, _json = json)
                            } ?: Content(_json = json)
                        }
                    }

                    return Content(_json = json)
                }
            }

            internal class Serializer : BaseSerializer<Content>(Content::class) {

                override fun serialize(
                    value: Content,
                    generator: JsonGenerator,
                    provider: SerializerProvider,
                ) {
                    when {
                        value.inputText != null -> generator.writeObject(value.inputText)
                        value.outputText != null -> generator.writeObject(value.outputText)
                        value.text != null -> generator.writeObject(value.text)
                        value.summaryText != null -> generator.writeObject(value.summaryText)
                        value.reasoningText != null -> generator.writeObject(value.reasoningText)
                        value.refusal != null -> generator.writeObject(value.refusal)
                        value.inputImage != null -> generator.writeObject(value.inputImage)
                        value.computerScreenshot != null ->
                            generator.writeObject(value.computerScreenshot)
                        value.inputFile != null -> generator.writeObject(value.inputFile)
                        value.encrypted != null -> generator.writeObject(value.encrypted)
                        value._json != null -> generator.writeObject(value._json)
                        else -> throw IllegalStateException("Invalid Content")
                    }
                }
            }

            /** A text content. */
            class Text
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val text: JsonField<String>,
                private val type: JsonValue,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("text")
                    @ExcludeMissing
                    text: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                ) : this(text, type, mutableMapOf())

                /**
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun text(): String = text.getRequired("text")

                /**
                 * Expected to always return the following:
                 * ```java
                 * JsonValue.from("text")
                 * ```
                 *
                 * However, this method can be useful for debugging and logging (e.g. if the server
                 * responded with an unexpected value).
                 */
                @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

                /**
                 * Returns the raw JSON value of [text].
                 *
                 * Unlike [text], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("text") @ExcludeMissing fun _text(): JsonField<String> = text

                @JsonAnySetter
                private fun putAdditionalProperty(key: String, value: JsonValue) {
                    additionalProperties.put(key, value)
                }

                @JsonAnyGetter
                @ExcludeMissing
                fun _additionalProperties(): Map<String, JsonValue> =
                    Collections.unmodifiableMap(additionalProperties)

                fun toBuilder() = Builder().from(this)

                companion object {

                    /**
                     * Returns a mutable builder for constructing an instance of [Text].
                     *
                     * The following fields are required:
                     * ```java
                     * .text()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Text]. */
                class Builder internal constructor() {

                    private var text: JsonField<String>? = null
                    private var type: JsonValue = JsonValue.from("text")
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(text: Text) = apply {
                        this.text = text.text
                        type = text.type
                        additionalProperties = text.additionalProperties.toMutableMap()
                    }

                    fun text(text: String) = text(JsonField.of(text))

                    /**
                     * Sets [Builder.text] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.text] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun text(text: JsonField<String>) = apply { this.text = text }

                    /**
                     * Sets the field to an arbitrary JSON value.
                     *
                     * It is usually unnecessary to call this method because the field defaults to
                     * the following:
                     * ```java
                     * JsonValue.from("text")
                     * ```
                     *
                     * This method is primarily for setting the field to an undocumented or not yet
                     * supported value.
                     */
                    fun type(type: JsonValue) = apply { this.type = type }

                    fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                        this.additionalProperties.clear()
                        putAllAdditionalProperties(additionalProperties)
                    }

                    fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                        additionalProperties.put(key, value)
                    }

                    fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                        apply {
                            this.additionalProperties.putAll(additionalProperties)
                        }

                    fun removeAdditionalProperty(key: String) = apply {
                        additionalProperties.remove(key)
                    }

                    fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                        keys.forEach(::removeAdditionalProperty)
                    }

                    /**
                     * Returns an immutable instance of [Text].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     *
                     * The following fields are required:
                     * ```java
                     * .text()
                     * ```
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): Text =
                        Text(checkRequired("text", text), type, additionalProperties.toMutableMap())
                }

                private var validated: Boolean = false

                /**
                 * Validates that the types of all values in this object match their expected types
                 * recursively.
                 *
                 * This method is _not_ forwards compatible with new types from the API for existing
                 * fields.
                 *
                 * @throws OpenAIInvalidDataException if any value type in this object doesn't match
                 *   its expected type.
                 */
                fun validate(): Text = apply {
                    if (validated) {
                        return@apply
                    }

                    text()
                    _type().let {
                        if (it != JsonValue.from("text")) {
                            throw OpenAIInvalidDataException("'type' is invalid, received $it")
                        }
                    }
                    validated = true
                }

                fun isValid(): Boolean =
                    try {
                        validate()
                        true
                    } catch (e: OpenAIInvalidDataException) {
                        false
                    }

                /**
                 * Returns a score indicating how many valid values are contained in this object
                 * recursively.
                 *
                 * Used for best match union deserialization.
                 */
                @JvmSynthetic
                internal fun validity(): Int =
                    (if (text.asKnown().isPresent) 1 else 0) +
                        type.let { if (it == JsonValue.from("text")) 1 else 0 }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Text &&
                        text == other.text &&
                        type == other.type &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy { Objects.hash(text, type, additionalProperties) }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Text{text=$text, type=$type, additionalProperties=$additionalProperties}"
            }

            /** A summary text from the model. */
            class SummaryText
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val text: JsonField<String>,
                private val type: JsonValue,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("text")
                    @ExcludeMissing
                    text: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                ) : this(text, type, mutableMapOf())

                /**
                 * A summary of the reasoning output from the model so far.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun text(): String = text.getRequired("text")

                /**
                 * The type of the object. Always `summary_text`.
                 *
                 * Expected to always return the following:
                 * ```java
                 * JsonValue.from("summary_text")
                 * ```
                 *
                 * However, this method can be useful for debugging and logging (e.g. if the server
                 * responded with an unexpected value).
                 */
                @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

                /**
                 * Returns the raw JSON value of [text].
                 *
                 * Unlike [text], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("text") @ExcludeMissing fun _text(): JsonField<String> = text

                @JsonAnySetter
                private fun putAdditionalProperty(key: String, value: JsonValue) {
                    additionalProperties.put(key, value)
                }

                @JsonAnyGetter
                @ExcludeMissing
                fun _additionalProperties(): Map<String, JsonValue> =
                    Collections.unmodifiableMap(additionalProperties)

                fun toBuilder() = Builder().from(this)

                companion object {

                    /**
                     * Returns a mutable builder for constructing an instance of [SummaryText].
                     *
                     * The following fields are required:
                     * ```java
                     * .text()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [SummaryText]. */
                class Builder internal constructor() {

                    private var text: JsonField<String>? = null
                    private var type: JsonValue = JsonValue.from("summary_text")
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(summaryText: SummaryText) = apply {
                        text = summaryText.text
                        type = summaryText.type
                        additionalProperties = summaryText.additionalProperties.toMutableMap()
                    }

                    /** A summary of the reasoning output from the model so far. */
                    fun text(text: String) = text(JsonField.of(text))

                    /**
                     * Sets [Builder.text] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.text] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun text(text: JsonField<String>) = apply { this.text = text }

                    /**
                     * Sets the field to an arbitrary JSON value.
                     *
                     * It is usually unnecessary to call this method because the field defaults to
                     * the following:
                     * ```java
                     * JsonValue.from("summary_text")
                     * ```
                     *
                     * This method is primarily for setting the field to an undocumented or not yet
                     * supported value.
                     */
                    fun type(type: JsonValue) = apply { this.type = type }

                    fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                        this.additionalProperties.clear()
                        putAllAdditionalProperties(additionalProperties)
                    }

                    fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                        additionalProperties.put(key, value)
                    }

                    fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                        apply {
                            this.additionalProperties.putAll(additionalProperties)
                        }

                    fun removeAdditionalProperty(key: String) = apply {
                        additionalProperties.remove(key)
                    }

                    fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                        keys.forEach(::removeAdditionalProperty)
                    }

                    /**
                     * Returns an immutable instance of [SummaryText].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     *
                     * The following fields are required:
                     * ```java
                     * .text()
                     * ```
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): SummaryText =
                        SummaryText(
                            checkRequired("text", text),
                            type,
                            additionalProperties.toMutableMap(),
                        )
                }

                private var validated: Boolean = false

                /**
                 * Validates that the types of all values in this object match their expected types
                 * recursively.
                 *
                 * This method is _not_ forwards compatible with new types from the API for existing
                 * fields.
                 *
                 * @throws OpenAIInvalidDataException if any value type in this object doesn't match
                 *   its expected type.
                 */
                fun validate(): SummaryText = apply {
                    if (validated) {
                        return@apply
                    }

                    text()
                    _type().let {
                        if (it != JsonValue.from("summary_text")) {
                            throw OpenAIInvalidDataException("'type' is invalid, received $it")
                        }
                    }
                    validated = true
                }

                fun isValid(): Boolean =
                    try {
                        validate()
                        true
                    } catch (e: OpenAIInvalidDataException) {
                        false
                    }

                /**
                 * Returns a score indicating how many valid values are contained in this object
                 * recursively.
                 *
                 * Used for best match union deserialization.
                 */
                @JvmSynthetic
                internal fun validity(): Int =
                    (if (text.asKnown().isPresent) 1 else 0) +
                        type.let { if (it == JsonValue.from("summary_text")) 1 else 0 }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is SummaryText &&
                        text == other.text &&
                        type == other.type &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy { Objects.hash(text, type, additionalProperties) }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "SummaryText{text=$text, type=$type, additionalProperties=$additionalProperties}"
            }

            /** Reasoning text from the model. */
            class ReasoningText
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val text: JsonField<String>,
                private val type: JsonValue,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("text")
                    @ExcludeMissing
                    text: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                ) : this(text, type, mutableMapOf())

                /**
                 * The reasoning text from the model.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun text(): String = text.getRequired("text")

                /**
                 * The type of the reasoning text. Always `reasoning_text`.
                 *
                 * Expected to always return the following:
                 * ```java
                 * JsonValue.from("reasoning_text")
                 * ```
                 *
                 * However, this method can be useful for debugging and logging (e.g. if the server
                 * responded with an unexpected value).
                 */
                @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

                /**
                 * Returns the raw JSON value of [text].
                 *
                 * Unlike [text], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("text") @ExcludeMissing fun _text(): JsonField<String> = text

                @JsonAnySetter
                private fun putAdditionalProperty(key: String, value: JsonValue) {
                    additionalProperties.put(key, value)
                }

                @JsonAnyGetter
                @ExcludeMissing
                fun _additionalProperties(): Map<String, JsonValue> =
                    Collections.unmodifiableMap(additionalProperties)

                fun toBuilder() = Builder().from(this)

                companion object {

                    /**
                     * Returns a mutable builder for constructing an instance of [ReasoningText].
                     *
                     * The following fields are required:
                     * ```java
                     * .text()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [ReasoningText]. */
                class Builder internal constructor() {

                    private var text: JsonField<String>? = null
                    private var type: JsonValue = JsonValue.from("reasoning_text")
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(reasoningText: ReasoningText) = apply {
                        text = reasoningText.text
                        type = reasoningText.type
                        additionalProperties = reasoningText.additionalProperties.toMutableMap()
                    }

                    /** The reasoning text from the model. */
                    fun text(text: String) = text(JsonField.of(text))

                    /**
                     * Sets [Builder.text] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.text] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun text(text: JsonField<String>) = apply { this.text = text }

                    /**
                     * Sets the field to an arbitrary JSON value.
                     *
                     * It is usually unnecessary to call this method because the field defaults to
                     * the following:
                     * ```java
                     * JsonValue.from("reasoning_text")
                     * ```
                     *
                     * This method is primarily for setting the field to an undocumented or not yet
                     * supported value.
                     */
                    fun type(type: JsonValue) = apply { this.type = type }

                    fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                        this.additionalProperties.clear()
                        putAllAdditionalProperties(additionalProperties)
                    }

                    fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                        additionalProperties.put(key, value)
                    }

                    fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                        apply {
                            this.additionalProperties.putAll(additionalProperties)
                        }

                    fun removeAdditionalProperty(key: String) = apply {
                        additionalProperties.remove(key)
                    }

                    fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                        keys.forEach(::removeAdditionalProperty)
                    }

                    /**
                     * Returns an immutable instance of [ReasoningText].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     *
                     * The following fields are required:
                     * ```java
                     * .text()
                     * ```
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): ReasoningText =
                        ReasoningText(
                            checkRequired("text", text),
                            type,
                            additionalProperties.toMutableMap(),
                        )
                }

                private var validated: Boolean = false

                /**
                 * Validates that the types of all values in this object match their expected types
                 * recursively.
                 *
                 * This method is _not_ forwards compatible with new types from the API for existing
                 * fields.
                 *
                 * @throws OpenAIInvalidDataException if any value type in this object doesn't match
                 *   its expected type.
                 */
                fun validate(): ReasoningText = apply {
                    if (validated) {
                        return@apply
                    }

                    text()
                    _type().let {
                        if (it != JsonValue.from("reasoning_text")) {
                            throw OpenAIInvalidDataException("'type' is invalid, received $it")
                        }
                    }
                    validated = true
                }

                fun isValid(): Boolean =
                    try {
                        validate()
                        true
                    } catch (e: OpenAIInvalidDataException) {
                        false
                    }

                /**
                 * Returns a score indicating how many valid values are contained in this object
                 * recursively.
                 *
                 * Used for best match union deserialization.
                 */
                @JvmSynthetic
                internal fun validity(): Int =
                    (if (text.asKnown().isPresent) 1 else 0) +
                        type.let { if (it == JsonValue.from("reasoning_text")) 1 else 0 }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is ReasoningText &&
                        text == other.text &&
                        type == other.type &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy { Objects.hash(text, type, additionalProperties) }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "ReasoningText{text=$text, type=$type, additionalProperties=$additionalProperties}"
            }

            /** A screenshot of a computer. */
            class ComputerScreenshot
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val detail: JsonField<Detail>,
                private val fileId: JsonField<String>,
                private val imageUrl: JsonField<String>,
                private val type: JsonValue,
                private val promptCacheBreakpoint: JsonField<PromptCacheBreakpoint>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("detail")
                    @ExcludeMissing
                    detail: JsonField<Detail> = JsonMissing.of(),
                    @JsonProperty("file_id")
                    @ExcludeMissing
                    fileId: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("image_url")
                    @ExcludeMissing
                    imageUrl: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                    @JsonProperty("prompt_cache_breakpoint")
                    @ExcludeMissing
                    promptCacheBreakpoint: JsonField<PromptCacheBreakpoint> = JsonMissing.of(),
                ) : this(detail, fileId, imageUrl, type, promptCacheBreakpoint, mutableMapOf())

                /**
                 * The detail level of the screenshot image to be sent to the model. One of `high`,
                 * `low`, `auto`, or `original`. Defaults to `auto`.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun detail(): Detail = detail.getRequired("detail")

                /**
                 * The identifier of an uploaded file that contains the screenshot.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun fileId(): Optional<String> = fileId.getOptional("file_id")

                /**
                 * The URL of the screenshot image.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun imageUrl(): Optional<String> = imageUrl.getOptional("image_url")

                /**
                 * Specifies the event type. For a computer screenshot, this property is always set
                 * to `computer_screenshot`.
                 *
                 * Expected to always return the following:
                 * ```java
                 * JsonValue.from("computer_screenshot")
                 * ```
                 *
                 * However, this method can be useful for debugging and logging (e.g. if the server
                 * responded with an unexpected value).
                 */
                @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

                /**
                 * Marks the exact end of a reusable prompt prefix. The breakpoint inherits its TTL
                 * from the request's `prompt_cache_options.ttl`; the boundary is not rounded to a
                 * token block.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun promptCacheBreakpoint(): Optional<PromptCacheBreakpoint> =
                    promptCacheBreakpoint.getOptional("prompt_cache_breakpoint")

                /**
                 * Returns the raw JSON value of [detail].
                 *
                 * Unlike [detail], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("detail") @ExcludeMissing fun _detail(): JsonField<Detail> = detail

                /**
                 * Returns the raw JSON value of [fileId].
                 *
                 * Unlike [fileId], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("file_id") @ExcludeMissing fun _fileId(): JsonField<String> = fileId

                /**
                 * Returns the raw JSON value of [imageUrl].
                 *
                 * Unlike [imageUrl], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("image_url")
                @ExcludeMissing
                fun _imageUrl(): JsonField<String> = imageUrl

                /**
                 * Returns the raw JSON value of [promptCacheBreakpoint].
                 *
                 * Unlike [promptCacheBreakpoint], this method doesn't throw if the JSON field has
                 * an unexpected type.
                 */
                @JsonProperty("prompt_cache_breakpoint")
                @ExcludeMissing
                fun _promptCacheBreakpoint(): JsonField<PromptCacheBreakpoint> =
                    promptCacheBreakpoint

                @JsonAnySetter
                private fun putAdditionalProperty(key: String, value: JsonValue) {
                    additionalProperties.put(key, value)
                }

                @JsonAnyGetter
                @ExcludeMissing
                fun _additionalProperties(): Map<String, JsonValue> =
                    Collections.unmodifiableMap(additionalProperties)

                fun toBuilder() = Builder().from(this)

                companion object {

                    /**
                     * Returns a mutable builder for constructing an instance of
                     * [ComputerScreenshot].
                     *
                     * The following fields are required:
                     * ```java
                     * .detail()
                     * .fileId()
                     * .imageUrl()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [ComputerScreenshot]. */
                class Builder internal constructor() {

                    private var detail: JsonField<Detail>? = null
                    private var fileId: JsonField<String>? = null
                    private var imageUrl: JsonField<String>? = null
                    private var type: JsonValue = JsonValue.from("computer_screenshot")
                    private var promptCacheBreakpoint: JsonField<PromptCacheBreakpoint> =
                        JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(computerScreenshot: ComputerScreenshot) = apply {
                        detail = computerScreenshot.detail
                        fileId = computerScreenshot.fileId
                        imageUrl = computerScreenshot.imageUrl
                        type = computerScreenshot.type
                        promptCacheBreakpoint = computerScreenshot.promptCacheBreakpoint
                        additionalProperties =
                            computerScreenshot.additionalProperties.toMutableMap()
                    }

                    /**
                     * The detail level of the screenshot image to be sent to the model. One of
                     * `high`, `low`, `auto`, or `original`. Defaults to `auto`.
                     */
                    fun detail(detail: Detail) = detail(JsonField.of(detail))

                    /**
                     * Sets [Builder.detail] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.detail] with a well-typed [Detail] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun detail(detail: JsonField<Detail>) = apply { this.detail = detail }

                    /** The identifier of an uploaded file that contains the screenshot. */
                    fun fileId(fileId: String?) = fileId(JsonField.ofNullable(fileId))

                    /** Alias for calling [Builder.fileId] with `fileId.orElse(null)`. */
                    fun fileId(fileId: Optional<String>) = fileId(fileId.getOrNull())

                    /**
                     * Sets [Builder.fileId] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.fileId] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun fileId(fileId: JsonField<String>) = apply { this.fileId = fileId }

                    /** The URL of the screenshot image. */
                    fun imageUrl(imageUrl: String?) = imageUrl(JsonField.ofNullable(imageUrl))

                    /** Alias for calling [Builder.imageUrl] with `imageUrl.orElse(null)`. */
                    fun imageUrl(imageUrl: Optional<String>) = imageUrl(imageUrl.getOrNull())

                    /**
                     * Sets [Builder.imageUrl] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.imageUrl] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun imageUrl(imageUrl: JsonField<String>) = apply { this.imageUrl = imageUrl }

                    /**
                     * Sets the field to an arbitrary JSON value.
                     *
                     * It is usually unnecessary to call this method because the field defaults to
                     * the following:
                     * ```java
                     * JsonValue.from("computer_screenshot")
                     * ```
                     *
                     * This method is primarily for setting the field to an undocumented or not yet
                     * supported value.
                     */
                    fun type(type: JsonValue) = apply { this.type = type }

                    /**
                     * Marks the exact end of a reusable prompt prefix. The breakpoint inherits its
                     * TTL from the request's `prompt_cache_options.ttl`; the boundary is not
                     * rounded to a token block.
                     */
                    fun promptCacheBreakpoint(promptCacheBreakpoint: PromptCacheBreakpoint) =
                        promptCacheBreakpoint(JsonField.of(promptCacheBreakpoint))

                    /**
                     * Sets [Builder.promptCacheBreakpoint] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.promptCacheBreakpoint] with a well-typed
                     * [PromptCacheBreakpoint] value instead. This method is primarily for setting
                     * the field to an undocumented or not yet supported value.
                     */
                    fun promptCacheBreakpoint(
                        promptCacheBreakpoint: JsonField<PromptCacheBreakpoint>
                    ) = apply { this.promptCacheBreakpoint = promptCacheBreakpoint }

                    fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                        this.additionalProperties.clear()
                        putAllAdditionalProperties(additionalProperties)
                    }

                    fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                        additionalProperties.put(key, value)
                    }

                    fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                        apply {
                            this.additionalProperties.putAll(additionalProperties)
                        }

                    fun removeAdditionalProperty(key: String) = apply {
                        additionalProperties.remove(key)
                    }

                    fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                        keys.forEach(::removeAdditionalProperty)
                    }

                    /**
                     * Returns an immutable instance of [ComputerScreenshot].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     *
                     * The following fields are required:
                     * ```java
                     * .detail()
                     * .fileId()
                     * .imageUrl()
                     * ```
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): ComputerScreenshot =
                        ComputerScreenshot(
                            checkRequired("detail", detail),
                            checkRequired("fileId", fileId),
                            checkRequired("imageUrl", imageUrl),
                            type,
                            promptCacheBreakpoint,
                            additionalProperties.toMutableMap(),
                        )
                }

                private var validated: Boolean = false

                /**
                 * Validates that the types of all values in this object match their expected types
                 * recursively.
                 *
                 * This method is _not_ forwards compatible with new types from the API for existing
                 * fields.
                 *
                 * @throws OpenAIInvalidDataException if any value type in this object doesn't match
                 *   its expected type.
                 */
                fun validate(): ComputerScreenshot = apply {
                    if (validated) {
                        return@apply
                    }

                    detail().validate()
                    fileId()
                    imageUrl()
                    _type().let {
                        if (it != JsonValue.from("computer_screenshot")) {
                            throw OpenAIInvalidDataException("'type' is invalid, received $it")
                        }
                    }
                    promptCacheBreakpoint().ifPresent { it.validate() }
                    validated = true
                }

                fun isValid(): Boolean =
                    try {
                        validate()
                        true
                    } catch (e: OpenAIInvalidDataException) {
                        false
                    }

                /**
                 * Returns a score indicating how many valid values are contained in this object
                 * recursively.
                 *
                 * Used for best match union deserialization.
                 */
                @JvmSynthetic
                internal fun validity(): Int =
                    (detail.asKnown().getOrNull()?.validity() ?: 0) +
                        (if (fileId.asKnown().isPresent) 1 else 0) +
                        (if (imageUrl.asKnown().isPresent) 1 else 0) +
                        type.let { if (it == JsonValue.from("computer_screenshot")) 1 else 0 } +
                        (promptCacheBreakpoint.asKnown().getOrNull()?.validity() ?: 0)

                /**
                 * The detail level of the screenshot image to be sent to the model. One of `high`,
                 * `low`, `auto`, or `original`. Defaults to `auto`.
                 */
                class Detail
                @JsonCreator
                private constructor(private val value: JsonField<String>) : Enum {

                    /**
                     * Returns this class instance's raw value.
                     *
                     * This is usually only useful if this instance was deserialized from data that
                     * doesn't match any known member, and you want to know that value. For example,
                     * if the SDK is on an older version than the API, then the API may respond with
                     * new members that the SDK is unaware of.
                     */
                    @com.fasterxml.jackson.annotation.JsonValue
                    fun _value(): JsonField<String> = value

                    companion object {

                        @JvmField val LOW = of("low")

                        @JvmField val HIGH = of("high")

                        @JvmField val AUTO = of("auto")

                        @JvmField val ORIGINAL = of("original")

                        @JvmStatic fun of(value: String) = Detail(JsonField.of(value))
                    }

                    /** An enum containing [Detail]'s known values. */
                    enum class Known {
                        LOW,
                        HIGH,
                        AUTO,
                        ORIGINAL,
                    }

                    /**
                     * An enum containing [Detail]'s known values, as well as an [_UNKNOWN] member.
                     *
                     * An instance of [Detail] can contain an unknown value in a couple of cases:
                     * - It was deserialized from data that doesn't match any known member. For
                     *   example, if the SDK is on an older version than the API, then the API may
                     *   respond with new members that the SDK is unaware of.
                     * - It was constructed with an arbitrary value using the [of] method.
                     */
                    enum class Value {
                        LOW,
                        HIGH,
                        AUTO,
                        ORIGINAL,
                        /**
                         * An enum member indicating that [Detail] was instantiated with an unknown
                         * value.
                         */
                        _UNKNOWN,
                    }

                    /**
                     * Returns an enum member corresponding to this class instance's value, or
                     * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                     *
                     * Use the [known] method instead if you're certain the value is always known or
                     * if you want to throw for the unknown case.
                     */
                    fun value(): Value =
                        when (this) {
                            LOW -> Value.LOW
                            HIGH -> Value.HIGH
                            AUTO -> Value.AUTO
                            ORIGINAL -> Value.ORIGINAL
                            else -> Value._UNKNOWN
                        }

                    /**
                     * Returns an enum member corresponding to this class instance's value.
                     *
                     * Use the [value] method instead if you're uncertain the value is always known
                     * and don't want to throw for the unknown case.
                     *
                     * @throws OpenAIInvalidDataException if this class instance's value is a not a
                     *   known member.
                     */
                    fun known(): Known =
                        when (this) {
                            LOW -> Known.LOW
                            HIGH -> Known.HIGH
                            AUTO -> Known.AUTO
                            ORIGINAL -> Known.ORIGINAL
                            else -> throw OpenAIInvalidDataException("Unknown Detail: $value")
                        }

                    /**
                     * Returns this class instance's primitive wire representation.
                     *
                     * This differs from the [toString] method because that method is primarily for
                     * debugging and generally doesn't throw.
                     *
                     * @throws OpenAIInvalidDataException if this class instance's value does not
                     *   have the expected primitive type.
                     */
                    fun asString(): String =
                        _value().asString().orElseThrow {
                            OpenAIInvalidDataException("Value is not a String")
                        }

                    private var validated: Boolean = false

                    /**
                     * Validates that the types of all values in this object match their expected
                     * types recursively.
                     *
                     * This method is _not_ forwards compatible with new types from the API for
                     * existing fields.
                     *
                     * @throws OpenAIInvalidDataException if any value type in this object doesn't
                     *   match its expected type.
                     */
                    fun validate(): Detail = apply {
                        if (validated) {
                            return@apply
                        }

                        known()
                        validated = true
                    }

                    fun isValid(): Boolean =
                        try {
                            validate()
                            true
                        } catch (e: OpenAIInvalidDataException) {
                            false
                        }

                    /**
                     * Returns a score indicating how many valid values are contained in this object
                     * recursively.
                     *
                     * Used for best match union deserialization.
                     */
                    @JvmSynthetic
                    internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is Detail && value == other.value
                    }

                    override fun hashCode() = value.hashCode()

                    override fun toString() = value.toString()
                }

                /**
                 * Marks the exact end of a reusable prompt prefix. The breakpoint inherits its TTL
                 * from the request's `prompt_cache_options.ttl`; the boundary is not rounded to a
                 * token block.
                 */
                class PromptCacheBreakpoint
                @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                private constructor(
                    private val mode: JsonValue,
                    private val additionalProperties: MutableMap<String, JsonValue>,
                ) {

                    @JsonCreator
                    private constructor(
                        @JsonProperty("mode") @ExcludeMissing mode: JsonValue = JsonMissing.of()
                    ) : this(mode, mutableMapOf())

                    /**
                     * The breakpoint mode. Always `explicit`.
                     *
                     * Expected to always return the following:
                     * ```java
                     * JsonValue.from("explicit")
                     * ```
                     *
                     * However, this method can be useful for debugging and logging (e.g. if the
                     * server responded with an unexpected value).
                     */
                    @JsonProperty("mode") @ExcludeMissing fun _mode(): JsonValue = mode

                    @JsonAnySetter
                    private fun putAdditionalProperty(key: String, value: JsonValue) {
                        additionalProperties.put(key, value)
                    }

                    @JsonAnyGetter
                    @ExcludeMissing
                    fun _additionalProperties(): Map<String, JsonValue> =
                        Collections.unmodifiableMap(additionalProperties)

                    fun toBuilder() = Builder().from(this)

                    companion object {

                        /**
                         * Returns a mutable builder for constructing an instance of
                         * [PromptCacheBreakpoint].
                         */
                        @JvmStatic fun builder() = Builder()
                    }

                    /** A builder for [PromptCacheBreakpoint]. */
                    class Builder internal constructor() {

                        private var mode: JsonValue = JsonValue.from("explicit")
                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        @JvmSynthetic
                        internal fun from(promptCacheBreakpoint: PromptCacheBreakpoint) = apply {
                            mode = promptCacheBreakpoint.mode
                            additionalProperties =
                                promptCacheBreakpoint.additionalProperties.toMutableMap()
                        }

                        /**
                         * Sets the field to an arbitrary JSON value.
                         *
                         * It is usually unnecessary to call this method because the field defaults
                         * to the following:
                         * ```java
                         * JsonValue.from("explicit")
                         * ```
                         *
                         * This method is primarily for setting the field to an undocumented or not
                         * yet supported value.
                         */
                        fun mode(mode: JsonValue) = apply { this.mode = mode }

                        fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                            apply {
                                this.additionalProperties.clear()
                                putAllAdditionalProperties(additionalProperties)
                            }

                        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                            additionalProperties.put(key, value)
                        }

                        fun putAllAdditionalProperties(
                            additionalProperties: Map<String, JsonValue>
                        ) = apply { this.additionalProperties.putAll(additionalProperties) }

                        fun removeAdditionalProperty(key: String) = apply {
                            additionalProperties.remove(key)
                        }

                        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                            keys.forEach(::removeAdditionalProperty)
                        }

                        /**
                         * Returns an immutable instance of [PromptCacheBreakpoint].
                         *
                         * Further updates to this [Builder] will not mutate the returned instance.
                         */
                        fun build(): PromptCacheBreakpoint =
                            PromptCacheBreakpoint(mode, additionalProperties.toMutableMap())
                    }

                    private var validated: Boolean = false

                    /**
                     * Validates that the types of all values in this object match their expected
                     * types recursively.
                     *
                     * This method is _not_ forwards compatible with new types from the API for
                     * existing fields.
                     *
                     * @throws OpenAIInvalidDataException if any value type in this object doesn't
                     *   match its expected type.
                     */
                    fun validate(): PromptCacheBreakpoint = apply {
                        if (validated) {
                            return@apply
                        }

                        _mode().let {
                            if (it != JsonValue.from("explicit")) {
                                throw OpenAIInvalidDataException("'mode' is invalid, received $it")
                            }
                        }
                        validated = true
                    }

                    fun isValid(): Boolean =
                        try {
                            validate()
                            true
                        } catch (e: OpenAIInvalidDataException) {
                            false
                        }

                    /**
                     * Returns a score indicating how many valid values are contained in this object
                     * recursively.
                     *
                     * Used for best match union deserialization.
                     */
                    @JvmSynthetic
                    internal fun validity(): Int =
                        mode.let { if (it == JsonValue.from("explicit")) 1 else 0 }

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is PromptCacheBreakpoint &&
                            mode == other.mode &&
                            additionalProperties == other.additionalProperties
                    }

                    private val hashCode: Int by lazy { Objects.hash(mode, additionalProperties) }

                    override fun hashCode(): Int = hashCode

                    override fun toString() =
                        "PromptCacheBreakpoint{mode=$mode, additionalProperties=$additionalProperties}"
                }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is ComputerScreenshot &&
                        detail == other.detail &&
                        fileId == other.fileId &&
                        imageUrl == other.imageUrl &&
                        type == other.type &&
                        promptCacheBreakpoint == other.promptCacheBreakpoint &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(
                        detail,
                        fileId,
                        imageUrl,
                        type,
                        promptCacheBreakpoint,
                        additionalProperties,
                    )
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "ComputerScreenshot{detail=$detail, fileId=$fileId, imageUrl=$imageUrl, type=$type, promptCacheBreakpoint=$promptCacheBreakpoint, additionalProperties=$additionalProperties}"
            }

            /**
             * Opaque encrypted content that Responses API decrypts inside trusted model execution.
             */
            class EncryptedContent
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val encryptedContent: JsonField<String>,
                private val type: JsonValue,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("encrypted_content")
                    @ExcludeMissing
                    encryptedContent: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                ) : this(encryptedContent, type, mutableMapOf())

                /**
                 * Opaque encrypted content.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun encryptedContent(): String = encryptedContent.getRequired("encrypted_content")

                /**
                 * The type of the input item. Always `encrypted_content`.
                 *
                 * Expected to always return the following:
                 * ```java
                 * JsonValue.from("encrypted_content")
                 * ```
                 *
                 * However, this method can be useful for debugging and logging (e.g. if the server
                 * responded with an unexpected value).
                 */
                @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

                /**
                 * Returns the raw JSON value of [encryptedContent].
                 *
                 * Unlike [encryptedContent], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("encrypted_content")
                @ExcludeMissing
                fun _encryptedContent(): JsonField<String> = encryptedContent

                @JsonAnySetter
                private fun putAdditionalProperty(key: String, value: JsonValue) {
                    additionalProperties.put(key, value)
                }

                @JsonAnyGetter
                @ExcludeMissing
                fun _additionalProperties(): Map<String, JsonValue> =
                    Collections.unmodifiableMap(additionalProperties)

                fun toBuilder() = Builder().from(this)

                companion object {

                    /**
                     * Returns a mutable builder for constructing an instance of [EncryptedContent].
                     *
                     * The following fields are required:
                     * ```java
                     * .encryptedContent()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [EncryptedContent]. */
                class Builder internal constructor() {

                    private var encryptedContent: JsonField<String>? = null
                    private var type: JsonValue = JsonValue.from("encrypted_content")
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(encryptedContent: EncryptedContent) = apply {
                        this.encryptedContent = encryptedContent.encryptedContent
                        type = encryptedContent.type
                        additionalProperties = encryptedContent.additionalProperties.toMutableMap()
                    }

                    /** Opaque encrypted content. */
                    fun encryptedContent(encryptedContent: String) =
                        encryptedContent(JsonField.of(encryptedContent))

                    /**
                     * Sets [Builder.encryptedContent] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.encryptedContent] with a well-typed [String]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun encryptedContent(encryptedContent: JsonField<String>) = apply {
                        this.encryptedContent = encryptedContent
                    }

                    /**
                     * Sets the field to an arbitrary JSON value.
                     *
                     * It is usually unnecessary to call this method because the field defaults to
                     * the following:
                     * ```java
                     * JsonValue.from("encrypted_content")
                     * ```
                     *
                     * This method is primarily for setting the field to an undocumented or not yet
                     * supported value.
                     */
                    fun type(type: JsonValue) = apply { this.type = type }

                    fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                        this.additionalProperties.clear()
                        putAllAdditionalProperties(additionalProperties)
                    }

                    fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                        additionalProperties.put(key, value)
                    }

                    fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                        apply {
                            this.additionalProperties.putAll(additionalProperties)
                        }

                    fun removeAdditionalProperty(key: String) = apply {
                        additionalProperties.remove(key)
                    }

                    fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                        keys.forEach(::removeAdditionalProperty)
                    }

                    /**
                     * Returns an immutable instance of [EncryptedContent].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     *
                     * The following fields are required:
                     * ```java
                     * .encryptedContent()
                     * ```
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): EncryptedContent =
                        EncryptedContent(
                            checkRequired("encryptedContent", encryptedContent),
                            type,
                            additionalProperties.toMutableMap(),
                        )
                }

                private var validated: Boolean = false

                /**
                 * Validates that the types of all values in this object match their expected types
                 * recursively.
                 *
                 * This method is _not_ forwards compatible with new types from the API for existing
                 * fields.
                 *
                 * @throws OpenAIInvalidDataException if any value type in this object doesn't match
                 *   its expected type.
                 */
                fun validate(): EncryptedContent = apply {
                    if (validated) {
                        return@apply
                    }

                    encryptedContent()
                    _type().let {
                        if (it != JsonValue.from("encrypted_content")) {
                            throw OpenAIInvalidDataException("'type' is invalid, received $it")
                        }
                    }
                    validated = true
                }

                fun isValid(): Boolean =
                    try {
                        validate()
                        true
                    } catch (e: OpenAIInvalidDataException) {
                        false
                    }

                /**
                 * Returns a score indicating how many valid values are contained in this object
                 * recursively.
                 *
                 * Used for best match union deserialization.
                 */
                @JvmSynthetic
                internal fun validity(): Int =
                    (if (encryptedContent.asKnown().isPresent) 1 else 0) +
                        type.let { if (it == JsonValue.from("encrypted_content")) 1 else 0 }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is EncryptedContent &&
                        encryptedContent == other.encryptedContent &&
                        type == other.type &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(encryptedContent, type, additionalProperties)
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "EncryptedContent{encryptedContent=$encryptedContent, type=$type, additionalProperties=$additionalProperties}"
            }
        }

        /** The agent that produced this item. */
        class Agent
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val agentName: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("agent_name")
                @ExcludeMissing
                agentName: JsonField<String> = JsonMissing.of()
            ) : this(agentName, mutableMapOf())

            /**
             * The canonical name of the agent that produced this item.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun agentName(): String = agentName.getRequired("agent_name")

            /**
             * Returns the raw JSON value of [agentName].
             *
             * Unlike [agentName], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("agent_name")
            @ExcludeMissing
            fun _agentName(): JsonField<String> = agentName

            @JsonAnySetter
            private fun putAdditionalProperty(key: String, value: JsonValue) {
                additionalProperties.put(key, value)
            }

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> =
                Collections.unmodifiableMap(additionalProperties)

            fun toBuilder() = Builder().from(this)

            companion object {

                /**
                 * Returns a mutable builder for constructing an instance of [Agent].
                 *
                 * The following fields are required:
                 * ```java
                 * .agentName()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Agent]. */
            class Builder internal constructor() {

                private var agentName: JsonField<String>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(agent: Agent) = apply {
                    agentName = agent.agentName
                    additionalProperties = agent.additionalProperties.toMutableMap()
                }

                /** The canonical name of the agent that produced this item. */
                fun agentName(agentName: String) = agentName(JsonField.of(agentName))

                /**
                 * Sets [Builder.agentName] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.agentName] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun agentName(agentName: JsonField<String>) = apply { this.agentName = agentName }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [Agent].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .agentName()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Agent =
                    Agent(
                        checkRequired("agentName", agentName),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
            fun validate(): Agent = apply {
                if (validated) {
                    return@apply
                }

                agentName()
                validated = true
            }

            fun isValid(): Boolean =
                try {
                    validate()
                    true
                } catch (e: OpenAIInvalidDataException) {
                    false
                }

            /**
             * Returns a score indicating how many valid values are contained in this object
             * recursively.
             *
             * Used for best match union deserialization.
             */
            @JvmSynthetic
            internal fun validity(): Int = (if (agentName.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Agent &&
                    agentName == other.agentName &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(agentName, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Agent{agentName=$agentName, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is AgentMessage &&
                id == other.id &&
                author == other.author &&
                content == other.content &&
                recipient == other.recipient &&
                type == other.type &&
                agent == other.agent &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(id, author, content, recipient, type, agent, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "AgentMessage{id=$id, author=$author, content=$content, recipient=$recipient, type=$type, agent=$agent, additionalProperties=$additionalProperties}"
    }

    class MultiAgentCall
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val action: JsonField<Action>,
        private val arguments: JsonField<String>,
        private val callId: JsonField<String>,
        private val type: JsonValue,
        private val agent: JsonField<Agent>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("action") @ExcludeMissing action: JsonField<Action> = JsonMissing.of(),
            @JsonProperty("arguments")
            @ExcludeMissing
            arguments: JsonField<String> = JsonMissing.of(),
            @JsonProperty("call_id") @ExcludeMissing callId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("agent") @ExcludeMissing agent: JsonField<Agent> = JsonMissing.of(),
        ) : this(id, action, arguments, callId, type, agent, mutableMapOf())

        /**
         * The unique ID of the multi-agent call item.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun id(): String = id.getRequired("id")

        /**
         * The multi-agent action to execute.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun action(): Action = action.getRequired("action")

        /**
         * The JSON string of arguments generated for the action.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun arguments(): String = arguments.getRequired("arguments")

        /**
         * The unique ID linking this call to its output.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun callId(): String = callId.getRequired("call_id")

        /**
         * The type of the multi-agent call. Always `multi_agent_call`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("multi_agent_call")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * The agent that produced this item.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun agent(): Optional<Agent> = agent.getOptional("agent")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [action].
         *
         * Unlike [action], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("action") @ExcludeMissing fun _action(): JsonField<Action> = action

        /**
         * Returns the raw JSON value of [arguments].
         *
         * Unlike [arguments], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("arguments") @ExcludeMissing fun _arguments(): JsonField<String> = arguments

        /**
         * Returns the raw JSON value of [callId].
         *
         * Unlike [callId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("call_id") @ExcludeMissing fun _callId(): JsonField<String> = callId

        /**
         * Returns the raw JSON value of [agent].
         *
         * Unlike [agent], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("agent") @ExcludeMissing fun _agent(): JsonField<Agent> = agent

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [MultiAgentCall].
             *
             * The following fields are required:
             * ```java
             * .id()
             * .action()
             * .arguments()
             * .callId()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [MultiAgentCall]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var action: JsonField<Action>? = null
            private var arguments: JsonField<String>? = null
            private var callId: JsonField<String>? = null
            private var type: JsonValue = JsonValue.from("multi_agent_call")
            private var agent: JsonField<Agent> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(multiAgentCall: MultiAgentCall) = apply {
                id = multiAgentCall.id
                action = multiAgentCall.action
                arguments = multiAgentCall.arguments
                callId = multiAgentCall.callId
                type = multiAgentCall.type
                agent = multiAgentCall.agent
                additionalProperties = multiAgentCall.additionalProperties.toMutableMap()
            }

            /** The unique ID of the multi-agent call item. */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /** The multi-agent action to execute. */
            fun action(action: Action) = action(JsonField.of(action))

            /**
             * Sets [Builder.action] to an arbitrary JSON value.
             *
             * You should usually call [Builder.action] with a well-typed [Action] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun action(action: JsonField<Action>) = apply { this.action = action }

            /** The JSON string of arguments generated for the action. */
            fun arguments(arguments: String) = arguments(JsonField.of(arguments))

            /**
             * Sets [Builder.arguments] to an arbitrary JSON value.
             *
             * You should usually call [Builder.arguments] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun arguments(arguments: JsonField<String>) = apply { this.arguments = arguments }

            /** The unique ID linking this call to its output. */
            fun callId(callId: String) = callId(JsonField.of(callId))

            /**
             * Sets [Builder.callId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.callId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun callId(callId: JsonField<String>) = apply { this.callId = callId }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("multi_agent_call")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

            /** The agent that produced this item. */
            fun agent(agent: Agent) = agent(JsonField.of(agent))

            /**
             * Sets [Builder.agent] to an arbitrary JSON value.
             *
             * You should usually call [Builder.agent] with a well-typed [Agent] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun agent(agent: JsonField<Agent>) = apply { this.agent = agent }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            /**
             * Returns an immutable instance of [MultiAgentCall].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .id()
             * .action()
             * .arguments()
             * .callId()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): MultiAgentCall =
                MultiAgentCall(
                    checkRequired("id", id),
                    checkRequired("action", action),
                    checkRequired("arguments", arguments),
                    checkRequired("callId", callId),
                    type,
                    agent,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
        fun validate(): MultiAgentCall = apply {
            if (validated) {
                return@apply
            }

            id()
            action().validate()
            arguments()
            callId()
            _type().let {
                if (it != JsonValue.from("multi_agent_call")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
            agent().ifPresent { it.validate() }
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: OpenAIInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (if (id.asKnown().isPresent) 1 else 0) +
                (action.asKnown().getOrNull()?.validity() ?: 0) +
                (if (arguments.asKnown().isPresent) 1 else 0) +
                (if (callId.asKnown().isPresent) 1 else 0) +
                type.let { if (it == JsonValue.from("multi_agent_call")) 1 else 0 } +
                (agent.asKnown().getOrNull()?.validity() ?: 0)

        /** The multi-agent action to execute. */
        class Action @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

            /**
             * Returns this class instance's raw value.
             *
             * This is usually only useful if this instance was deserialized from data that doesn't
             * match any known member, and you want to know that value. For example, if the SDK is
             * on an older version than the API, then the API may respond with new members that the
             * SDK is unaware of.
             */
            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val SPAWN_AGENT = of("spawn_agent")

                @JvmField val INTERRUPT_AGENT = of("interrupt_agent")

                @JvmField val LIST_AGENTS = of("list_agents")

                @JvmField val SEND_MESSAGE = of("send_message")

                @JvmField val FOLLOWUP_TASK = of("followup_task")

                @JvmField val WAIT_AGENT = of("wait_agent")

                @JvmStatic fun of(value: String) = Action(JsonField.of(value))
            }

            /** An enum containing [Action]'s known values. */
            enum class Known {
                SPAWN_AGENT,
                INTERRUPT_AGENT,
                LIST_AGENTS,
                SEND_MESSAGE,
                FOLLOWUP_TASK,
                WAIT_AGENT,
            }

            /**
             * An enum containing [Action]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Action] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                SPAWN_AGENT,
                INTERRUPT_AGENT,
                LIST_AGENTS,
                SEND_MESSAGE,
                FOLLOWUP_TASK,
                WAIT_AGENT,
                /**
                 * An enum member indicating that [Action] was instantiated with an unknown value.
                 */
                _UNKNOWN,
            }

            /**
             * Returns an enum member corresponding to this class instance's value, or
             * [Value._UNKNOWN] if the class was instantiated with an unknown value.
             *
             * Use the [known] method instead if you're certain the value is always known or if you
             * want to throw for the unknown case.
             */
            fun value(): Value =
                when (this) {
                    SPAWN_AGENT -> Value.SPAWN_AGENT
                    INTERRUPT_AGENT -> Value.INTERRUPT_AGENT
                    LIST_AGENTS -> Value.LIST_AGENTS
                    SEND_MESSAGE -> Value.SEND_MESSAGE
                    FOLLOWUP_TASK -> Value.FOLLOWUP_TASK
                    WAIT_AGENT -> Value.WAIT_AGENT
                    else -> Value._UNKNOWN
                }

            /**
             * Returns an enum member corresponding to this class instance's value.
             *
             * Use the [value] method instead if you're uncertain the value is always known and
             * don't want to throw for the unknown case.
             *
             * @throws OpenAIInvalidDataException if this class instance's value is a not a known
             *   member.
             */
            fun known(): Known =
                when (this) {
                    SPAWN_AGENT -> Known.SPAWN_AGENT
                    INTERRUPT_AGENT -> Known.INTERRUPT_AGENT
                    LIST_AGENTS -> Known.LIST_AGENTS
                    SEND_MESSAGE -> Known.SEND_MESSAGE
                    FOLLOWUP_TASK -> Known.FOLLOWUP_TASK
                    WAIT_AGENT -> Known.WAIT_AGENT
                    else -> throw OpenAIInvalidDataException("Unknown Action: $value")
                }

            /**
             * Returns this class instance's primitive wire representation.
             *
             * This differs from the [toString] method because that method is primarily for
             * debugging and generally doesn't throw.
             *
             * @throws OpenAIInvalidDataException if this class instance's value does not have the
             *   expected primitive type.
             */
            fun asString(): String =
                _value().asString().orElseThrow {
                    OpenAIInvalidDataException("Value is not a String")
                }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
            fun validate(): Action = apply {
                if (validated) {
                    return@apply
                }

                known()
                validated = true
            }

            fun isValid(): Boolean =
                try {
                    validate()
                    true
                } catch (e: OpenAIInvalidDataException) {
                    false
                }

            /**
             * Returns a score indicating how many valid values are contained in this object
             * recursively.
             *
             * Used for best match union deserialization.
             */
            @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Action && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        /** The agent that produced this item. */
        class Agent
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val agentName: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("agent_name")
                @ExcludeMissing
                agentName: JsonField<String> = JsonMissing.of()
            ) : this(agentName, mutableMapOf())

            /**
             * The canonical name of the agent that produced this item.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun agentName(): String = agentName.getRequired("agent_name")

            /**
             * Returns the raw JSON value of [agentName].
             *
             * Unlike [agentName], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("agent_name")
            @ExcludeMissing
            fun _agentName(): JsonField<String> = agentName

            @JsonAnySetter
            private fun putAdditionalProperty(key: String, value: JsonValue) {
                additionalProperties.put(key, value)
            }

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> =
                Collections.unmodifiableMap(additionalProperties)

            fun toBuilder() = Builder().from(this)

            companion object {

                /**
                 * Returns a mutable builder for constructing an instance of [Agent].
                 *
                 * The following fields are required:
                 * ```java
                 * .agentName()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Agent]. */
            class Builder internal constructor() {

                private var agentName: JsonField<String>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(agent: Agent) = apply {
                    agentName = agent.agentName
                    additionalProperties = agent.additionalProperties.toMutableMap()
                }

                /** The canonical name of the agent that produced this item. */
                fun agentName(agentName: String) = agentName(JsonField.of(agentName))

                /**
                 * Sets [Builder.agentName] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.agentName] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun agentName(agentName: JsonField<String>) = apply { this.agentName = agentName }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [Agent].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .agentName()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Agent =
                    Agent(
                        checkRequired("agentName", agentName),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
            fun validate(): Agent = apply {
                if (validated) {
                    return@apply
                }

                agentName()
                validated = true
            }

            fun isValid(): Boolean =
                try {
                    validate()
                    true
                } catch (e: OpenAIInvalidDataException) {
                    false
                }

            /**
             * Returns a score indicating how many valid values are contained in this object
             * recursively.
             *
             * Used for best match union deserialization.
             */
            @JvmSynthetic
            internal fun validity(): Int = (if (agentName.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Agent &&
                    agentName == other.agentName &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(agentName, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Agent{agentName=$agentName, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is MultiAgentCall &&
                id == other.id &&
                action == other.action &&
                arguments == other.arguments &&
                callId == other.callId &&
                type == other.type &&
                agent == other.agent &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(id, action, arguments, callId, type, agent, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "MultiAgentCall{id=$id, action=$action, arguments=$arguments, callId=$callId, type=$type, agent=$agent, additionalProperties=$additionalProperties}"
    }

    class MultiAgentCallOutput
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val action: JsonField<Action>,
        private val callId: JsonField<String>,
        private val output: JsonField<List<BetaResponseOutputText>>,
        private val type: JsonValue,
        private val agent: JsonField<Agent>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("action") @ExcludeMissing action: JsonField<Action> = JsonMissing.of(),
            @JsonProperty("call_id") @ExcludeMissing callId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("output")
            @ExcludeMissing
            output: JsonField<List<BetaResponseOutputText>> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("agent") @ExcludeMissing agent: JsonField<Agent> = JsonMissing.of(),
        ) : this(id, action, callId, output, type, agent, mutableMapOf())

        /**
         * The unique ID of the multi-agent call output item.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun id(): String = id.getRequired("id")

        /**
         * The multi-agent action that produced this result.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun action(): Action = action.getRequired("action")

        /**
         * The unique ID of the multi-agent call.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun callId(): String = callId.getRequired("call_id")

        /**
         * Text output returned by the multi-agent action.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun output(): List<BetaResponseOutputText> = output.getRequired("output")

        /**
         * The type of the multi-agent result. Always `multi_agent_call_output`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("multi_agent_call_output")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * The agent that produced this item.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun agent(): Optional<Agent> = agent.getOptional("agent")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [action].
         *
         * Unlike [action], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("action") @ExcludeMissing fun _action(): JsonField<Action> = action

        /**
         * Returns the raw JSON value of [callId].
         *
         * Unlike [callId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("call_id") @ExcludeMissing fun _callId(): JsonField<String> = callId

        /**
         * Returns the raw JSON value of [output].
         *
         * Unlike [output], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("output")
        @ExcludeMissing
        fun _output(): JsonField<List<BetaResponseOutputText>> = output

        /**
         * Returns the raw JSON value of [agent].
         *
         * Unlike [agent], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("agent") @ExcludeMissing fun _agent(): JsonField<Agent> = agent

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [MultiAgentCallOutput].
             *
             * The following fields are required:
             * ```java
             * .id()
             * .action()
             * .callId()
             * .output()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [MultiAgentCallOutput]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var action: JsonField<Action>? = null
            private var callId: JsonField<String>? = null
            private var output: JsonField<MutableList<BetaResponseOutputText>>? = null
            private var type: JsonValue = JsonValue.from("multi_agent_call_output")
            private var agent: JsonField<Agent> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(multiAgentCallOutput: MultiAgentCallOutput) = apply {
                id = multiAgentCallOutput.id
                action = multiAgentCallOutput.action
                callId = multiAgentCallOutput.callId
                output = multiAgentCallOutput.output.map { it.toMutableList() }
                type = multiAgentCallOutput.type
                agent = multiAgentCallOutput.agent
                additionalProperties = multiAgentCallOutput.additionalProperties.toMutableMap()
            }

            /** The unique ID of the multi-agent call output item. */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /** The multi-agent action that produced this result. */
            fun action(action: Action) = action(JsonField.of(action))

            /**
             * Sets [Builder.action] to an arbitrary JSON value.
             *
             * You should usually call [Builder.action] with a well-typed [Action] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun action(action: JsonField<Action>) = apply { this.action = action }

            /** The unique ID of the multi-agent call. */
            fun callId(callId: String) = callId(JsonField.of(callId))

            /**
             * Sets [Builder.callId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.callId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun callId(callId: JsonField<String>) = apply { this.callId = callId }

            /** Text output returned by the multi-agent action. */
            fun output(output: List<BetaResponseOutputText>) = output(JsonField.of(output))

            /**
             * Sets [Builder.output] to an arbitrary JSON value.
             *
             * You should usually call [Builder.output] with a well-typed
             * `List<BetaResponseOutputText>` value instead. This method is primarily for setting
             * the field to an undocumented or not yet supported value.
             */
            fun output(output: JsonField<List<BetaResponseOutputText>>) = apply {
                this.output = output.map { it.toMutableList() }
            }

            /**
             * Adds a single [BetaResponseOutputText] to [Builder.output].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addOutput(output: BetaResponseOutputText) = apply {
                this.output =
                    (this.output ?: JsonField.of(mutableListOf())).also {
                        checkKnown("output", it).add(output)
                    }
            }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("multi_agent_call_output")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

            /** The agent that produced this item. */
            fun agent(agent: Agent) = agent(JsonField.of(agent))

            /**
             * Sets [Builder.agent] to an arbitrary JSON value.
             *
             * You should usually call [Builder.agent] with a well-typed [Agent] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun agent(agent: JsonField<Agent>) = apply { this.agent = agent }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            /**
             * Returns an immutable instance of [MultiAgentCallOutput].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .id()
             * .action()
             * .callId()
             * .output()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): MultiAgentCallOutput =
                MultiAgentCallOutput(
                    checkRequired("id", id),
                    checkRequired("action", action),
                    checkRequired("callId", callId),
                    checkRequired("output", output).map { it.toImmutable() },
                    type,
                    agent,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
        fun validate(): MultiAgentCallOutput = apply {
            if (validated) {
                return@apply
            }

            id()
            action().validate()
            callId()
            output().forEach { it.validate() }
            _type().let {
                if (it != JsonValue.from("multi_agent_call_output")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
            agent().ifPresent { it.validate() }
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: OpenAIInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (if (id.asKnown().isPresent) 1 else 0) +
                (action.asKnown().getOrNull()?.validity() ?: 0) +
                (if (callId.asKnown().isPresent) 1 else 0) +
                (output.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                type.let { if (it == JsonValue.from("multi_agent_call_output")) 1 else 0 } +
                (agent.asKnown().getOrNull()?.validity() ?: 0)

        /** The multi-agent action that produced this result. */
        class Action @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

            /**
             * Returns this class instance's raw value.
             *
             * This is usually only useful if this instance was deserialized from data that doesn't
             * match any known member, and you want to know that value. For example, if the SDK is
             * on an older version than the API, then the API may respond with new members that the
             * SDK is unaware of.
             */
            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val SPAWN_AGENT = of("spawn_agent")

                @JvmField val INTERRUPT_AGENT = of("interrupt_agent")

                @JvmField val LIST_AGENTS = of("list_agents")

                @JvmField val SEND_MESSAGE = of("send_message")

                @JvmField val FOLLOWUP_TASK = of("followup_task")

                @JvmField val WAIT_AGENT = of("wait_agent")

                @JvmStatic fun of(value: String) = Action(JsonField.of(value))
            }

            /** An enum containing [Action]'s known values. */
            enum class Known {
                SPAWN_AGENT,
                INTERRUPT_AGENT,
                LIST_AGENTS,
                SEND_MESSAGE,
                FOLLOWUP_TASK,
                WAIT_AGENT,
            }

            /**
             * An enum containing [Action]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Action] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                SPAWN_AGENT,
                INTERRUPT_AGENT,
                LIST_AGENTS,
                SEND_MESSAGE,
                FOLLOWUP_TASK,
                WAIT_AGENT,
                /**
                 * An enum member indicating that [Action] was instantiated with an unknown value.
                 */
                _UNKNOWN,
            }

            /**
             * Returns an enum member corresponding to this class instance's value, or
             * [Value._UNKNOWN] if the class was instantiated with an unknown value.
             *
             * Use the [known] method instead if you're certain the value is always known or if you
             * want to throw for the unknown case.
             */
            fun value(): Value =
                when (this) {
                    SPAWN_AGENT -> Value.SPAWN_AGENT
                    INTERRUPT_AGENT -> Value.INTERRUPT_AGENT
                    LIST_AGENTS -> Value.LIST_AGENTS
                    SEND_MESSAGE -> Value.SEND_MESSAGE
                    FOLLOWUP_TASK -> Value.FOLLOWUP_TASK
                    WAIT_AGENT -> Value.WAIT_AGENT
                    else -> Value._UNKNOWN
                }

            /**
             * Returns an enum member corresponding to this class instance's value.
             *
             * Use the [value] method instead if you're uncertain the value is always known and
             * don't want to throw for the unknown case.
             *
             * @throws OpenAIInvalidDataException if this class instance's value is a not a known
             *   member.
             */
            fun known(): Known =
                when (this) {
                    SPAWN_AGENT -> Known.SPAWN_AGENT
                    INTERRUPT_AGENT -> Known.INTERRUPT_AGENT
                    LIST_AGENTS -> Known.LIST_AGENTS
                    SEND_MESSAGE -> Known.SEND_MESSAGE
                    FOLLOWUP_TASK -> Known.FOLLOWUP_TASK
                    WAIT_AGENT -> Known.WAIT_AGENT
                    else -> throw OpenAIInvalidDataException("Unknown Action: $value")
                }

            /**
             * Returns this class instance's primitive wire representation.
             *
             * This differs from the [toString] method because that method is primarily for
             * debugging and generally doesn't throw.
             *
             * @throws OpenAIInvalidDataException if this class instance's value does not have the
             *   expected primitive type.
             */
            fun asString(): String =
                _value().asString().orElseThrow {
                    OpenAIInvalidDataException("Value is not a String")
                }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
            fun validate(): Action = apply {
                if (validated) {
                    return@apply
                }

                known()
                validated = true
            }

            fun isValid(): Boolean =
                try {
                    validate()
                    true
                } catch (e: OpenAIInvalidDataException) {
                    false
                }

            /**
             * Returns a score indicating how many valid values are contained in this object
             * recursively.
             *
             * Used for best match union deserialization.
             */
            @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Action && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        /** The agent that produced this item. */
        class Agent
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val agentName: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("agent_name")
                @ExcludeMissing
                agentName: JsonField<String> = JsonMissing.of()
            ) : this(agentName, mutableMapOf())

            /**
             * The canonical name of the agent that produced this item.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun agentName(): String = agentName.getRequired("agent_name")

            /**
             * Returns the raw JSON value of [agentName].
             *
             * Unlike [agentName], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("agent_name")
            @ExcludeMissing
            fun _agentName(): JsonField<String> = agentName

            @JsonAnySetter
            private fun putAdditionalProperty(key: String, value: JsonValue) {
                additionalProperties.put(key, value)
            }

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> =
                Collections.unmodifiableMap(additionalProperties)

            fun toBuilder() = Builder().from(this)

            companion object {

                /**
                 * Returns a mutable builder for constructing an instance of [Agent].
                 *
                 * The following fields are required:
                 * ```java
                 * .agentName()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Agent]. */
            class Builder internal constructor() {

                private var agentName: JsonField<String>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(agent: Agent) = apply {
                    agentName = agent.agentName
                    additionalProperties = agent.additionalProperties.toMutableMap()
                }

                /** The canonical name of the agent that produced this item. */
                fun agentName(agentName: String) = agentName(JsonField.of(agentName))

                /**
                 * Sets [Builder.agentName] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.agentName] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun agentName(agentName: JsonField<String>) = apply { this.agentName = agentName }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [Agent].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .agentName()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Agent =
                    Agent(
                        checkRequired("agentName", agentName),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
            fun validate(): Agent = apply {
                if (validated) {
                    return@apply
                }

                agentName()
                validated = true
            }

            fun isValid(): Boolean =
                try {
                    validate()
                    true
                } catch (e: OpenAIInvalidDataException) {
                    false
                }

            /**
             * Returns a score indicating how many valid values are contained in this object
             * recursively.
             *
             * Used for best match union deserialization.
             */
            @JvmSynthetic
            internal fun validity(): Int = (if (agentName.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Agent &&
                    agentName == other.agentName &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(agentName, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Agent{agentName=$agentName, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is MultiAgentCallOutput &&
                id == other.id &&
                action == other.action &&
                callId == other.callId &&
                output == other.output &&
                type == other.type &&
                agent == other.agent &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(id, action, callId, output, type, agent, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "MultiAgentCallOutput{id=$id, action=$action, callId=$callId, output=$output, type=$type, agent=$agent, additionalProperties=$additionalProperties}"
    }

    class AdditionalTools
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val role: JsonField<Role>,
        private val tools: JsonField<List<BetaTool>>,
        private val type: JsonValue,
        private val agent: JsonField<Agent>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("role") @ExcludeMissing role: JsonField<Role> = JsonMissing.of(),
            @JsonProperty("tools")
            @ExcludeMissing
            tools: JsonField<List<BetaTool>> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("agent") @ExcludeMissing agent: JsonField<Agent> = JsonMissing.of(),
        ) : this(id, role, tools, type, agent, mutableMapOf())

        /**
         * The unique ID of the additional tools item.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun id(): String = id.getRequired("id")

        /**
         * The role that provided the additional tools.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun role(): Role = role.getRequired("role")

        /**
         * The additional tool definitions made available at this item.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun tools(): List<BetaTool> = tools.getRequired("tools")

        /**
         * The type of the item. Always `additional_tools`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("additional_tools")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * The agent that produced this item.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun agent(): Optional<Agent> = agent.getOptional("agent")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [role].
         *
         * Unlike [role], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("role") @ExcludeMissing fun _role(): JsonField<Role> = role

        /**
         * Returns the raw JSON value of [tools].
         *
         * Unlike [tools], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("tools") @ExcludeMissing fun _tools(): JsonField<List<BetaTool>> = tools

        /**
         * Returns the raw JSON value of [agent].
         *
         * Unlike [agent], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("agent") @ExcludeMissing fun _agent(): JsonField<Agent> = agent

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [AdditionalTools].
             *
             * The following fields are required:
             * ```java
             * .id()
             * .role()
             * .tools()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [AdditionalTools]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var role: JsonField<Role>? = null
            private var tools: JsonField<MutableList<BetaTool>>? = null
            private var type: JsonValue = JsonValue.from("additional_tools")
            private var agent: JsonField<Agent> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(additionalTools: AdditionalTools) = apply {
                id = additionalTools.id
                role = additionalTools.role
                tools = additionalTools.tools.map { it.toMutableList() }
                type = additionalTools.type
                agent = additionalTools.agent
                additionalProperties = additionalTools.additionalProperties.toMutableMap()
            }

            /** The unique ID of the additional tools item. */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /** The role that provided the additional tools. */
            fun role(role: Role) = role(JsonField.of(role))

            /**
             * Sets [Builder.role] to an arbitrary JSON value.
             *
             * You should usually call [Builder.role] with a well-typed [Role] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun role(role: JsonField<Role>) = apply { this.role = role }

            /** The additional tool definitions made available at this item. */
            fun tools(tools: List<BetaTool>) = tools(JsonField.of(tools))

            /**
             * Sets [Builder.tools] to an arbitrary JSON value.
             *
             * You should usually call [Builder.tools] with a well-typed `List<BetaTool>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun tools(tools: JsonField<List<BetaTool>>) = apply {
                this.tools = tools.map { it.toMutableList() }
            }

            /**
             * Adds a single [BetaTool] to [tools].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addTool(tool: BetaTool) = apply {
                tools =
                    (tools ?: JsonField.of(mutableListOf())).also {
                        checkKnown("tools", it).add(tool)
                    }
            }

            /** Alias for calling [addTool] with `BetaTool.ofFunction(function)`. */
            fun addTool(function: BetaFunctionTool) = addTool(BetaTool.ofFunction(function))

            /** Alias for calling [addTool] with `BetaTool.ofFileSearch(fileSearch)`. */
            fun addTool(fileSearch: BetaFileSearchTool) = addTool(BetaTool.ofFileSearch(fileSearch))

            /**
             * Alias for calling [addTool] with the following:
             * ```java
             * BetaFileSearchTool.builder()
             *     .vectorStoreIds(vectorStoreIds)
             *     .build()
             * ```
             */
            fun addFileSearchTool(vectorStoreIds: List<String>) =
                addTool(BetaFileSearchTool.builder().vectorStoreIds(vectorStoreIds).build())

            /** Alias for calling [addTool] with `BetaTool.ofComputer(computer)`. */
            fun addTool(computer: BetaComputerTool) = addTool(BetaTool.ofComputer(computer))

            /**
             * Alias for calling [addTool] with `BetaTool.ofComputerUsePreview(computerUsePreview)`.
             */
            fun addTool(computerUsePreview: BetaComputerUsePreviewTool) =
                addTool(BetaTool.ofComputerUsePreview(computerUsePreview))

            /** Alias for calling [addTool] with `BetaTool.ofWebSearch(webSearch)`. */
            fun addTool(webSearch: BetaWebSearchTool) = addTool(BetaTool.ofWebSearch(webSearch))

            /** Alias for calling [addTool] with `BetaTool.ofMcp(mcp)`. */
            fun addTool(mcp: BetaTool.Mcp) = addTool(BetaTool.ofMcp(mcp))

            /**
             * Alias for calling [addTool] with the following:
             * ```java
             * BetaTool.Mcp.builder()
             *     .serverLabel(serverLabel)
             *     .build()
             * ```
             */
            fun addMcpTool(serverLabel: String) =
                addTool(BetaTool.Mcp.builder().serverLabel(serverLabel).build())

            /** Alias for calling [addTool] with `BetaTool.ofCodeInterpreter(codeInterpreter)`. */
            fun addTool(codeInterpreter: BetaTool.CodeInterpreter) =
                addTool(BetaTool.ofCodeInterpreter(codeInterpreter))

            /**
             * Alias for calling [addTool] with the following:
             * ```java
             * BetaTool.CodeInterpreter.builder()
             *     .container(container)
             *     .build()
             * ```
             */
            fun addCodeInterpreterTool(container: BetaTool.CodeInterpreter.Container) =
                addTool(BetaTool.CodeInterpreter.builder().container(container).build())

            /**
             * Alias for calling [addCodeInterpreterTool] with
             * `BetaTool.CodeInterpreter.Container.ofString(string)`.
             */
            fun addCodeInterpreterTool(string: String) =
                addCodeInterpreterTool(BetaTool.CodeInterpreter.Container.ofString(string))

            /**
             * Alias for calling [addCodeInterpreterTool] with
             * `BetaTool.CodeInterpreter.Container.ofCodeInterpreterToolAuto(codeInterpreterToolAuto)`.
             */
            fun addCodeInterpreterTool(
                codeInterpreterToolAuto: BetaTool.CodeInterpreter.Container.CodeInterpreterToolAuto
            ) =
                addCodeInterpreterTool(
                    BetaTool.CodeInterpreter.Container.ofCodeInterpreterToolAuto(
                        codeInterpreterToolAuto
                    )
                )

            /** Alias for calling [addTool] with `BetaTool.ofProgrammaticToolCalling()`. */
            fun addToolProgrammaticToolCalling() = addTool(BetaTool.ofProgrammaticToolCalling())

            /** Alias for calling [addTool] with `BetaTool.ofImageGeneration(imageGeneration)`. */
            fun addTool(imageGeneration: BetaTool.ImageGeneration) =
                addTool(BetaTool.ofImageGeneration(imageGeneration))

            /** Alias for calling [addTool] with `BetaTool.ofLocalShell()`. */
            fun addToolLocalShell() = addTool(BetaTool.ofLocalShell())

            /** Alias for calling [addTool] with `BetaTool.ofShell(shell)`. */
            fun addTool(shell: BetaFunctionShellTool) = addTool(BetaTool.ofShell(shell))

            /** Alias for calling [addTool] with `BetaTool.ofCustom(custom)`. */
            fun addTool(custom: BetaCustomTool) = addTool(BetaTool.ofCustom(custom))

            /**
             * Alias for calling [addTool] with the following:
             * ```java
             * BetaCustomTool.builder()
             *     .name(name)
             *     .build()
             * ```
             */
            fun addCustomTool(name: String) = addTool(BetaCustomTool.builder().name(name).build())

            /** Alias for calling [addTool] with `BetaTool.ofNamespace(namespace)`. */
            fun addTool(namespace: BetaNamespaceTool) = addTool(BetaTool.ofNamespace(namespace))

            /** Alias for calling [addTool] with `BetaTool.ofToolSearch(toolSearch)`. */
            fun addTool(toolSearch: BetaToolSearchTool) = addTool(BetaTool.ofToolSearch(toolSearch))

            /** Alias for calling [addTool] with `BetaTool.ofWebSearchPreview(webSearchPreview)`. */
            fun addTool(webSearchPreview: BetaWebSearchPreviewTool) =
                addTool(BetaTool.ofWebSearchPreview(webSearchPreview))

            /** Alias for calling [addTool] with `BetaTool.ofApplyPatch(applyPatch)`. */
            fun addTool(applyPatch: BetaApplyPatchTool) = addTool(BetaTool.ofApplyPatch(applyPatch))

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("additional_tools")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

            /** The agent that produced this item. */
            fun agent(agent: Agent) = agent(JsonField.of(agent))

            /**
             * Sets [Builder.agent] to an arbitrary JSON value.
             *
             * You should usually call [Builder.agent] with a well-typed [Agent] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun agent(agent: JsonField<Agent>) = apply { this.agent = agent }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            /**
             * Returns an immutable instance of [AdditionalTools].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .id()
             * .role()
             * .tools()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): AdditionalTools =
                AdditionalTools(
                    checkRequired("id", id),
                    checkRequired("role", role),
                    checkRequired("tools", tools).map { it.toImmutable() },
                    type,
                    agent,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
        fun validate(): AdditionalTools = apply {
            if (validated) {
                return@apply
            }

            id()
            role().validate()
            tools().forEach { it.validate() }
            _type().let {
                if (it != JsonValue.from("additional_tools")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
            agent().ifPresent { it.validate() }
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: OpenAIInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (if (id.asKnown().isPresent) 1 else 0) +
                (role.asKnown().getOrNull()?.validity() ?: 0) +
                (tools.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                type.let { if (it == JsonValue.from("additional_tools")) 1 else 0 } +
                (agent.asKnown().getOrNull()?.validity() ?: 0)

        /** The role that provided the additional tools. */
        class Role @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

            /**
             * Returns this class instance's raw value.
             *
             * This is usually only useful if this instance was deserialized from data that doesn't
             * match any known member, and you want to know that value. For example, if the SDK is
             * on an older version than the API, then the API may respond with new members that the
             * SDK is unaware of.
             */
            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val UNKNOWN = of("unknown")

                @JvmField val USER = of("user")

                @JvmField val ASSISTANT = of("assistant")

                @JvmField val SYSTEM = of("system")

                @JvmField val CRITIC = of("critic")

                @JvmField val DISCRIMINATOR = of("discriminator")

                @JvmField val DEVELOPER = of("developer")

                @JvmField val TOOL = of("tool")

                @JvmStatic fun of(value: String) = Role(JsonField.of(value))
            }

            /** An enum containing [Role]'s known values. */
            enum class Known {
                UNKNOWN,
                USER,
                ASSISTANT,
                SYSTEM,
                CRITIC,
                DISCRIMINATOR,
                DEVELOPER,
                TOOL,
            }

            /**
             * An enum containing [Role]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Role] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                UNKNOWN,
                USER,
                ASSISTANT,
                SYSTEM,
                CRITIC,
                DISCRIMINATOR,
                DEVELOPER,
                TOOL,
                /** An enum member indicating that [Role] was instantiated with an unknown value. */
                _UNKNOWN,
            }

            /**
             * Returns an enum member corresponding to this class instance's value, or
             * [Value._UNKNOWN] if the class was instantiated with an unknown value.
             *
             * Use the [known] method instead if you're certain the value is always known or if you
             * want to throw for the unknown case.
             */
            fun value(): Value =
                when (this) {
                    UNKNOWN -> Value.UNKNOWN
                    USER -> Value.USER
                    ASSISTANT -> Value.ASSISTANT
                    SYSTEM -> Value.SYSTEM
                    CRITIC -> Value.CRITIC
                    DISCRIMINATOR -> Value.DISCRIMINATOR
                    DEVELOPER -> Value.DEVELOPER
                    TOOL -> Value.TOOL
                    else -> Value._UNKNOWN
                }

            /**
             * Returns an enum member corresponding to this class instance's value.
             *
             * Use the [value] method instead if you're uncertain the value is always known and
             * don't want to throw for the unknown case.
             *
             * @throws OpenAIInvalidDataException if this class instance's value is a not a known
             *   member.
             */
            fun known(): Known =
                when (this) {
                    UNKNOWN -> Known.UNKNOWN
                    USER -> Known.USER
                    ASSISTANT -> Known.ASSISTANT
                    SYSTEM -> Known.SYSTEM
                    CRITIC -> Known.CRITIC
                    DISCRIMINATOR -> Known.DISCRIMINATOR
                    DEVELOPER -> Known.DEVELOPER
                    TOOL -> Known.TOOL
                    else -> throw OpenAIInvalidDataException("Unknown Role: $value")
                }

            /**
             * Returns this class instance's primitive wire representation.
             *
             * This differs from the [toString] method because that method is primarily for
             * debugging and generally doesn't throw.
             *
             * @throws OpenAIInvalidDataException if this class instance's value does not have the
             *   expected primitive type.
             */
            fun asString(): String =
                _value().asString().orElseThrow {
                    OpenAIInvalidDataException("Value is not a String")
                }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
            fun validate(): Role = apply {
                if (validated) {
                    return@apply
                }

                known()
                validated = true
            }

            fun isValid(): Boolean =
                try {
                    validate()
                    true
                } catch (e: OpenAIInvalidDataException) {
                    false
                }

            /**
             * Returns a score indicating how many valid values are contained in this object
             * recursively.
             *
             * Used for best match union deserialization.
             */
            @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Role && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        /** The agent that produced this item. */
        class Agent
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val agentName: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("agent_name")
                @ExcludeMissing
                agentName: JsonField<String> = JsonMissing.of()
            ) : this(agentName, mutableMapOf())

            /**
             * The canonical name of the agent that produced this item.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun agentName(): String = agentName.getRequired("agent_name")

            /**
             * Returns the raw JSON value of [agentName].
             *
             * Unlike [agentName], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("agent_name")
            @ExcludeMissing
            fun _agentName(): JsonField<String> = agentName

            @JsonAnySetter
            private fun putAdditionalProperty(key: String, value: JsonValue) {
                additionalProperties.put(key, value)
            }

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> =
                Collections.unmodifiableMap(additionalProperties)

            fun toBuilder() = Builder().from(this)

            companion object {

                /**
                 * Returns a mutable builder for constructing an instance of [Agent].
                 *
                 * The following fields are required:
                 * ```java
                 * .agentName()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Agent]. */
            class Builder internal constructor() {

                private var agentName: JsonField<String>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(agent: Agent) = apply {
                    agentName = agent.agentName
                    additionalProperties = agent.additionalProperties.toMutableMap()
                }

                /** The canonical name of the agent that produced this item. */
                fun agentName(agentName: String) = agentName(JsonField.of(agentName))

                /**
                 * Sets [Builder.agentName] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.agentName] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun agentName(agentName: JsonField<String>) = apply { this.agentName = agentName }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [Agent].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .agentName()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Agent =
                    Agent(
                        checkRequired("agentName", agentName),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
            fun validate(): Agent = apply {
                if (validated) {
                    return@apply
                }

                agentName()
                validated = true
            }

            fun isValid(): Boolean =
                try {
                    validate()
                    true
                } catch (e: OpenAIInvalidDataException) {
                    false
                }

            /**
             * Returns a score indicating how many valid values are contained in this object
             * recursively.
             *
             * Used for best match union deserialization.
             */
            @JvmSynthetic
            internal fun validity(): Int = (if (agentName.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Agent &&
                    agentName == other.agentName &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(agentName, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Agent{agentName=$agentName, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is AdditionalTools &&
                id == other.id &&
                role == other.role &&
                tools == other.tools &&
                type == other.type &&
                agent == other.agent &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(id, role, tools, type, agent, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "AdditionalTools{id=$id, role=$role, tools=$tools, type=$type, agent=$agent, additionalProperties=$additionalProperties}"
    }

    class Program
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val callId: JsonField<String>,
        private val code: JsonField<String>,
        private val fingerprint: JsonField<String>,
        private val type: JsonValue,
        private val agent: JsonField<Agent>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("call_id") @ExcludeMissing callId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("code") @ExcludeMissing code: JsonField<String> = JsonMissing.of(),
            @JsonProperty("fingerprint")
            @ExcludeMissing
            fingerprint: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("agent") @ExcludeMissing agent: JsonField<Agent> = JsonMissing.of(),
        ) : this(id, callId, code, fingerprint, type, agent, mutableMapOf())

        /**
         * The unique ID of the program item.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun id(): String = id.getRequired("id")

        /**
         * The stable call ID of the program item.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun callId(): String = callId.getRequired("call_id")

        /**
         * The JavaScript source executed by programmatic tool calling.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun code(): String = code.getRequired("code")

        /**
         * Opaque program replay fingerprint that must be round-tripped.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun fingerprint(): String = fingerprint.getRequired("fingerprint")

        /**
         * The type of the item. Always `program`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("program")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * The agent that produced this item.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun agent(): Optional<Agent> = agent.getOptional("agent")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [callId].
         *
         * Unlike [callId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("call_id") @ExcludeMissing fun _callId(): JsonField<String> = callId

        /**
         * Returns the raw JSON value of [code].
         *
         * Unlike [code], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("code") @ExcludeMissing fun _code(): JsonField<String> = code

        /**
         * Returns the raw JSON value of [fingerprint].
         *
         * Unlike [fingerprint], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("fingerprint")
        @ExcludeMissing
        fun _fingerprint(): JsonField<String> = fingerprint

        /**
         * Returns the raw JSON value of [agent].
         *
         * Unlike [agent], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("agent") @ExcludeMissing fun _agent(): JsonField<Agent> = agent

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [Program].
             *
             * The following fields are required:
             * ```java
             * .id()
             * .callId()
             * .code()
             * .fingerprint()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Program]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var callId: JsonField<String>? = null
            private var code: JsonField<String>? = null
            private var fingerprint: JsonField<String>? = null
            private var type: JsonValue = JsonValue.from("program")
            private var agent: JsonField<Agent> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(program: Program) = apply {
                id = program.id
                callId = program.callId
                code = program.code
                fingerprint = program.fingerprint
                type = program.type
                agent = program.agent
                additionalProperties = program.additionalProperties.toMutableMap()
            }

            /** The unique ID of the program item. */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /** The stable call ID of the program item. */
            fun callId(callId: String) = callId(JsonField.of(callId))

            /**
             * Sets [Builder.callId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.callId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun callId(callId: JsonField<String>) = apply { this.callId = callId }

            /** The JavaScript source executed by programmatic tool calling. */
            fun code(code: String) = code(JsonField.of(code))

            /**
             * Sets [Builder.code] to an arbitrary JSON value.
             *
             * You should usually call [Builder.code] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun code(code: JsonField<String>) = apply { this.code = code }

            /** Opaque program replay fingerprint that must be round-tripped. */
            fun fingerprint(fingerprint: String) = fingerprint(JsonField.of(fingerprint))

            /**
             * Sets [Builder.fingerprint] to an arbitrary JSON value.
             *
             * You should usually call [Builder.fingerprint] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun fingerprint(fingerprint: JsonField<String>) = apply {
                this.fingerprint = fingerprint
            }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("program")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

            /** The agent that produced this item. */
            fun agent(agent: Agent) = agent(JsonField.of(agent))

            /**
             * Sets [Builder.agent] to an arbitrary JSON value.
             *
             * You should usually call [Builder.agent] with a well-typed [Agent] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun agent(agent: JsonField<Agent>) = apply { this.agent = agent }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            /**
             * Returns an immutable instance of [Program].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .id()
             * .callId()
             * .code()
             * .fingerprint()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Program =
                Program(
                    checkRequired("id", id),
                    checkRequired("callId", callId),
                    checkRequired("code", code),
                    checkRequired("fingerprint", fingerprint),
                    type,
                    agent,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
        fun validate(): Program = apply {
            if (validated) {
                return@apply
            }

            id()
            callId()
            code()
            fingerprint()
            _type().let {
                if (it != JsonValue.from("program")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
            agent().ifPresent { it.validate() }
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: OpenAIInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (if (id.asKnown().isPresent) 1 else 0) +
                (if (callId.asKnown().isPresent) 1 else 0) +
                (if (code.asKnown().isPresent) 1 else 0) +
                (if (fingerprint.asKnown().isPresent) 1 else 0) +
                type.let { if (it == JsonValue.from("program")) 1 else 0 } +
                (agent.asKnown().getOrNull()?.validity() ?: 0)

        /** The agent that produced this item. */
        class Agent
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val agentName: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("agent_name")
                @ExcludeMissing
                agentName: JsonField<String> = JsonMissing.of()
            ) : this(agentName, mutableMapOf())

            /**
             * The canonical name of the agent that produced this item.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun agentName(): String = agentName.getRequired("agent_name")

            /**
             * Returns the raw JSON value of [agentName].
             *
             * Unlike [agentName], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("agent_name")
            @ExcludeMissing
            fun _agentName(): JsonField<String> = agentName

            @JsonAnySetter
            private fun putAdditionalProperty(key: String, value: JsonValue) {
                additionalProperties.put(key, value)
            }

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> =
                Collections.unmodifiableMap(additionalProperties)

            fun toBuilder() = Builder().from(this)

            companion object {

                /**
                 * Returns a mutable builder for constructing an instance of [Agent].
                 *
                 * The following fields are required:
                 * ```java
                 * .agentName()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Agent]. */
            class Builder internal constructor() {

                private var agentName: JsonField<String>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(agent: Agent) = apply {
                    agentName = agent.agentName
                    additionalProperties = agent.additionalProperties.toMutableMap()
                }

                /** The canonical name of the agent that produced this item. */
                fun agentName(agentName: String) = agentName(JsonField.of(agentName))

                /**
                 * Sets [Builder.agentName] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.agentName] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun agentName(agentName: JsonField<String>) = apply { this.agentName = agentName }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [Agent].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .agentName()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Agent =
                    Agent(
                        checkRequired("agentName", agentName),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
            fun validate(): Agent = apply {
                if (validated) {
                    return@apply
                }

                agentName()
                validated = true
            }

            fun isValid(): Boolean =
                try {
                    validate()
                    true
                } catch (e: OpenAIInvalidDataException) {
                    false
                }

            /**
             * Returns a score indicating how many valid values are contained in this object
             * recursively.
             *
             * Used for best match union deserialization.
             */
            @JvmSynthetic
            internal fun validity(): Int = (if (agentName.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Agent &&
                    agentName == other.agentName &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(agentName, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Agent{agentName=$agentName, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Program &&
                id == other.id &&
                callId == other.callId &&
                code == other.code &&
                fingerprint == other.fingerprint &&
                type == other.type &&
                agent == other.agent &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(id, callId, code, fingerprint, type, agent, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Program{id=$id, callId=$callId, code=$code, fingerprint=$fingerprint, type=$type, agent=$agent, additionalProperties=$additionalProperties}"
    }

    class ProgramOutput
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val callId: JsonField<String>,
        private val result: JsonField<String>,
        private val status: JsonField<Status>,
        private val type: JsonValue,
        private val agent: JsonField<Agent>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("call_id") @ExcludeMissing callId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("result") @ExcludeMissing result: JsonField<String> = JsonMissing.of(),
            @JsonProperty("status") @ExcludeMissing status: JsonField<Status> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("agent") @ExcludeMissing agent: JsonField<Agent> = JsonMissing.of(),
        ) : this(id, callId, result, status, type, agent, mutableMapOf())

        /**
         * The unique ID of the program output item.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun id(): String = id.getRequired("id")

        /**
         * The call ID of the program item.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun callId(): String = callId.getRequired("call_id")

        /**
         * The result produced by the program item.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun result(): String = result.getRequired("result")

        /**
         * The terminal status of the program output item.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun status(): Status = status.getRequired("status")

        /**
         * The type of the item. Always `program_output`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("program_output")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * The agent that produced this item.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun agent(): Optional<Agent> = agent.getOptional("agent")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [callId].
         *
         * Unlike [callId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("call_id") @ExcludeMissing fun _callId(): JsonField<String> = callId

        /**
         * Returns the raw JSON value of [result].
         *
         * Unlike [result], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("result") @ExcludeMissing fun _result(): JsonField<String> = result

        /**
         * Returns the raw JSON value of [status].
         *
         * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<Status> = status

        /**
         * Returns the raw JSON value of [agent].
         *
         * Unlike [agent], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("agent") @ExcludeMissing fun _agent(): JsonField<Agent> = agent

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [ProgramOutput].
             *
             * The following fields are required:
             * ```java
             * .id()
             * .callId()
             * .result()
             * .status()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ProgramOutput]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var callId: JsonField<String>? = null
            private var result: JsonField<String>? = null
            private var status: JsonField<Status>? = null
            private var type: JsonValue = JsonValue.from("program_output")
            private var agent: JsonField<Agent> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(programOutput: ProgramOutput) = apply {
                id = programOutput.id
                callId = programOutput.callId
                result = programOutput.result
                status = programOutput.status
                type = programOutput.type
                agent = programOutput.agent
                additionalProperties = programOutput.additionalProperties.toMutableMap()
            }

            /** The unique ID of the program output item. */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /** The call ID of the program item. */
            fun callId(callId: String) = callId(JsonField.of(callId))

            /**
             * Sets [Builder.callId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.callId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun callId(callId: JsonField<String>) = apply { this.callId = callId }

            /** The result produced by the program item. */
            fun result(result: String) = result(JsonField.of(result))

            /**
             * Sets [Builder.result] to an arbitrary JSON value.
             *
             * You should usually call [Builder.result] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun result(result: JsonField<String>) = apply { this.result = result }

            /** The terminal status of the program output item. */
            fun status(status: Status) = status(JsonField.of(status))

            /**
             * Sets [Builder.status] to an arbitrary JSON value.
             *
             * You should usually call [Builder.status] with a well-typed [Status] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun status(status: JsonField<Status>) = apply { this.status = status }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("program_output")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

            /** The agent that produced this item. */
            fun agent(agent: Agent) = agent(JsonField.of(agent))

            /**
             * Sets [Builder.agent] to an arbitrary JSON value.
             *
             * You should usually call [Builder.agent] with a well-typed [Agent] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun agent(agent: JsonField<Agent>) = apply { this.agent = agent }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            /**
             * Returns an immutable instance of [ProgramOutput].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .id()
             * .callId()
             * .result()
             * .status()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ProgramOutput =
                ProgramOutput(
                    checkRequired("id", id),
                    checkRequired("callId", callId),
                    checkRequired("result", result),
                    checkRequired("status", status),
                    type,
                    agent,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
        fun validate(): ProgramOutput = apply {
            if (validated) {
                return@apply
            }

            id()
            callId()
            result()
            status().validate()
            _type().let {
                if (it != JsonValue.from("program_output")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
            agent().ifPresent { it.validate() }
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: OpenAIInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (if (id.asKnown().isPresent) 1 else 0) +
                (if (callId.asKnown().isPresent) 1 else 0) +
                (if (result.asKnown().isPresent) 1 else 0) +
                (status.asKnown().getOrNull()?.validity() ?: 0) +
                type.let { if (it == JsonValue.from("program_output")) 1 else 0 } +
                (agent.asKnown().getOrNull()?.validity() ?: 0)

        /** The terminal status of the program output item. */
        class Status @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

            /**
             * Returns this class instance's raw value.
             *
             * This is usually only useful if this instance was deserialized from data that doesn't
             * match any known member, and you want to know that value. For example, if the SDK is
             * on an older version than the API, then the API may respond with new members that the
             * SDK is unaware of.
             */
            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val COMPLETED = of("completed")

                @JvmField val INCOMPLETE = of("incomplete")

                @JvmStatic fun of(value: String) = Status(JsonField.of(value))
            }

            /** An enum containing [Status]'s known values. */
            enum class Known {
                COMPLETED,
                INCOMPLETE,
            }

            /**
             * An enum containing [Status]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Status] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                COMPLETED,
                INCOMPLETE,
                /**
                 * An enum member indicating that [Status] was instantiated with an unknown value.
                 */
                _UNKNOWN,
            }

            /**
             * Returns an enum member corresponding to this class instance's value, or
             * [Value._UNKNOWN] if the class was instantiated with an unknown value.
             *
             * Use the [known] method instead if you're certain the value is always known or if you
             * want to throw for the unknown case.
             */
            fun value(): Value =
                when (this) {
                    COMPLETED -> Value.COMPLETED
                    INCOMPLETE -> Value.INCOMPLETE
                    else -> Value._UNKNOWN
                }

            /**
             * Returns an enum member corresponding to this class instance's value.
             *
             * Use the [value] method instead if you're uncertain the value is always known and
             * don't want to throw for the unknown case.
             *
             * @throws OpenAIInvalidDataException if this class instance's value is a not a known
             *   member.
             */
            fun known(): Known =
                when (this) {
                    COMPLETED -> Known.COMPLETED
                    INCOMPLETE -> Known.INCOMPLETE
                    else -> throw OpenAIInvalidDataException("Unknown Status: $value")
                }

            /**
             * Returns this class instance's primitive wire representation.
             *
             * This differs from the [toString] method because that method is primarily for
             * debugging and generally doesn't throw.
             *
             * @throws OpenAIInvalidDataException if this class instance's value does not have the
             *   expected primitive type.
             */
            fun asString(): String =
                _value().asString().orElseThrow {
                    OpenAIInvalidDataException("Value is not a String")
                }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
            fun validate(): Status = apply {
                if (validated) {
                    return@apply
                }

                known()
                validated = true
            }

            fun isValid(): Boolean =
                try {
                    validate()
                    true
                } catch (e: OpenAIInvalidDataException) {
                    false
                }

            /**
             * Returns a score indicating how many valid values are contained in this object
             * recursively.
             *
             * Used for best match union deserialization.
             */
            @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Status && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        /** The agent that produced this item. */
        class Agent
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val agentName: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("agent_name")
                @ExcludeMissing
                agentName: JsonField<String> = JsonMissing.of()
            ) : this(agentName, mutableMapOf())

            /**
             * The canonical name of the agent that produced this item.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun agentName(): String = agentName.getRequired("agent_name")

            /**
             * Returns the raw JSON value of [agentName].
             *
             * Unlike [agentName], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("agent_name")
            @ExcludeMissing
            fun _agentName(): JsonField<String> = agentName

            @JsonAnySetter
            private fun putAdditionalProperty(key: String, value: JsonValue) {
                additionalProperties.put(key, value)
            }

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> =
                Collections.unmodifiableMap(additionalProperties)

            fun toBuilder() = Builder().from(this)

            companion object {

                /**
                 * Returns a mutable builder for constructing an instance of [Agent].
                 *
                 * The following fields are required:
                 * ```java
                 * .agentName()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Agent]. */
            class Builder internal constructor() {

                private var agentName: JsonField<String>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(agent: Agent) = apply {
                    agentName = agent.agentName
                    additionalProperties = agent.additionalProperties.toMutableMap()
                }

                /** The canonical name of the agent that produced this item. */
                fun agentName(agentName: String) = agentName(JsonField.of(agentName))

                /**
                 * Sets [Builder.agentName] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.agentName] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun agentName(agentName: JsonField<String>) = apply { this.agentName = agentName }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [Agent].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .agentName()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Agent =
                    Agent(
                        checkRequired("agentName", agentName),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
            fun validate(): Agent = apply {
                if (validated) {
                    return@apply
                }

                agentName()
                validated = true
            }

            fun isValid(): Boolean =
                try {
                    validate()
                    true
                } catch (e: OpenAIInvalidDataException) {
                    false
                }

            /**
             * Returns a score indicating how many valid values are contained in this object
             * recursively.
             *
             * Used for best match union deserialization.
             */
            @JvmSynthetic
            internal fun validity(): Int = (if (agentName.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Agent &&
                    agentName == other.agentName &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(agentName, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Agent{agentName=$agentName, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ProgramOutput &&
                id == other.id &&
                callId == other.callId &&
                result == other.result &&
                status == other.status &&
                type == other.type &&
                agent == other.agent &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(id, callId, result, status, type, agent, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ProgramOutput{id=$id, callId=$callId, result=$result, status=$status, type=$type, agent=$agent, additionalProperties=$additionalProperties}"
    }

    /** An image generation request made by the model. */
    class ImageGenerationCall
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val result: JsonField<String>,
        private val status: JsonField<Status>,
        private val type: JsonValue,
        private val agent: JsonField<Agent>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("result") @ExcludeMissing result: JsonField<String> = JsonMissing.of(),
            @JsonProperty("status") @ExcludeMissing status: JsonField<Status> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("agent") @ExcludeMissing agent: JsonField<Agent> = JsonMissing.of(),
        ) : this(id, result, status, type, agent, mutableMapOf())

        /**
         * The unique ID of the image generation call.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun id(): String = id.getRequired("id")

        /**
         * The generated image encoded in base64.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun result(): Optional<String> = result.getOptional("result")

        /**
         * The status of the image generation call.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun status(): Status = status.getRequired("status")

        /**
         * The type of the image generation call. Always `image_generation_call`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("image_generation_call")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * The agent that produced this item.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun agent(): Optional<Agent> = agent.getOptional("agent")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [result].
         *
         * Unlike [result], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("result") @ExcludeMissing fun _result(): JsonField<String> = result

        /**
         * Returns the raw JSON value of [status].
         *
         * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<Status> = status

        /**
         * Returns the raw JSON value of [agent].
         *
         * Unlike [agent], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("agent") @ExcludeMissing fun _agent(): JsonField<Agent> = agent

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [ImageGenerationCall].
             *
             * The following fields are required:
             * ```java
             * .id()
             * .result()
             * .status()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ImageGenerationCall]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var result: JsonField<String>? = null
            private var status: JsonField<Status>? = null
            private var type: JsonValue = JsonValue.from("image_generation_call")
            private var agent: JsonField<Agent> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(imageGenerationCall: ImageGenerationCall) = apply {
                id = imageGenerationCall.id
                result = imageGenerationCall.result
                status = imageGenerationCall.status
                type = imageGenerationCall.type
                agent = imageGenerationCall.agent
                additionalProperties = imageGenerationCall.additionalProperties.toMutableMap()
            }

            /** The unique ID of the image generation call. */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /** The generated image encoded in base64. */
            fun result(result: String?) = result(JsonField.ofNullable(result))

            /** Alias for calling [Builder.result] with `result.orElse(null)`. */
            fun result(result: Optional<String>) = result(result.getOrNull())

            /**
             * Sets [Builder.result] to an arbitrary JSON value.
             *
             * You should usually call [Builder.result] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun result(result: JsonField<String>) = apply { this.result = result }

            /** The status of the image generation call. */
            fun status(status: Status) = status(JsonField.of(status))

            /**
             * Sets [Builder.status] to an arbitrary JSON value.
             *
             * You should usually call [Builder.status] with a well-typed [Status] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun status(status: JsonField<Status>) = apply { this.status = status }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("image_generation_call")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

            /** The agent that produced this item. */
            fun agent(agent: Agent?) = agent(JsonField.ofNullable(agent))

            /** Alias for calling [Builder.agent] with `agent.orElse(null)`. */
            fun agent(agent: Optional<Agent>) = agent(agent.getOrNull())

            /**
             * Sets [Builder.agent] to an arbitrary JSON value.
             *
             * You should usually call [Builder.agent] with a well-typed [Agent] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun agent(agent: JsonField<Agent>) = apply { this.agent = agent }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            /**
             * Returns an immutable instance of [ImageGenerationCall].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .id()
             * .result()
             * .status()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ImageGenerationCall =
                ImageGenerationCall(
                    checkRequired("id", id),
                    checkRequired("result", result),
                    checkRequired("status", status),
                    type,
                    agent,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
        fun validate(): ImageGenerationCall = apply {
            if (validated) {
                return@apply
            }

            id()
            result()
            status().validate()
            _type().let {
                if (it != JsonValue.from("image_generation_call")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
            agent().ifPresent { it.validate() }
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: OpenAIInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (if (id.asKnown().isPresent) 1 else 0) +
                (if (result.asKnown().isPresent) 1 else 0) +
                (status.asKnown().getOrNull()?.validity() ?: 0) +
                type.let { if (it == JsonValue.from("image_generation_call")) 1 else 0 } +
                (agent.asKnown().getOrNull()?.validity() ?: 0)

        /** The status of the image generation call. */
        class Status @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

            /**
             * Returns this class instance's raw value.
             *
             * This is usually only useful if this instance was deserialized from data that doesn't
             * match any known member, and you want to know that value. For example, if the SDK is
             * on an older version than the API, then the API may respond with new members that the
             * SDK is unaware of.
             */
            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val IN_PROGRESS = of("in_progress")

                @JvmField val COMPLETED = of("completed")

                @JvmField val GENERATING = of("generating")

                @JvmField val FAILED = of("failed")

                @JvmStatic fun of(value: String) = Status(JsonField.of(value))
            }

            /** An enum containing [Status]'s known values. */
            enum class Known {
                IN_PROGRESS,
                COMPLETED,
                GENERATING,
                FAILED,
            }

            /**
             * An enum containing [Status]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Status] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                IN_PROGRESS,
                COMPLETED,
                GENERATING,
                FAILED,
                /**
                 * An enum member indicating that [Status] was instantiated with an unknown value.
                 */
                _UNKNOWN,
            }

            /**
             * Returns an enum member corresponding to this class instance's value, or
             * [Value._UNKNOWN] if the class was instantiated with an unknown value.
             *
             * Use the [known] method instead if you're certain the value is always known or if you
             * want to throw for the unknown case.
             */
            fun value(): Value =
                when (this) {
                    IN_PROGRESS -> Value.IN_PROGRESS
                    COMPLETED -> Value.COMPLETED
                    GENERATING -> Value.GENERATING
                    FAILED -> Value.FAILED
                    else -> Value._UNKNOWN
                }

            /**
             * Returns an enum member corresponding to this class instance's value.
             *
             * Use the [value] method instead if you're uncertain the value is always known and
             * don't want to throw for the unknown case.
             *
             * @throws OpenAIInvalidDataException if this class instance's value is a not a known
             *   member.
             */
            fun known(): Known =
                when (this) {
                    IN_PROGRESS -> Known.IN_PROGRESS
                    COMPLETED -> Known.COMPLETED
                    GENERATING -> Known.GENERATING
                    FAILED -> Known.FAILED
                    else -> throw OpenAIInvalidDataException("Unknown Status: $value")
                }

            /**
             * Returns this class instance's primitive wire representation.
             *
             * This differs from the [toString] method because that method is primarily for
             * debugging and generally doesn't throw.
             *
             * @throws OpenAIInvalidDataException if this class instance's value does not have the
             *   expected primitive type.
             */
            fun asString(): String =
                _value().asString().orElseThrow {
                    OpenAIInvalidDataException("Value is not a String")
                }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
            fun validate(): Status = apply {
                if (validated) {
                    return@apply
                }

                known()
                validated = true
            }

            fun isValid(): Boolean =
                try {
                    validate()
                    true
                } catch (e: OpenAIInvalidDataException) {
                    false
                }

            /**
             * Returns a score indicating how many valid values are contained in this object
             * recursively.
             *
             * Used for best match union deserialization.
             */
            @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Status && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        /** The agent that produced this item. */
        class Agent
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val agentName: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("agent_name")
                @ExcludeMissing
                agentName: JsonField<String> = JsonMissing.of()
            ) : this(agentName, mutableMapOf())

            /**
             * The canonical name of the agent that produced this item.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun agentName(): String = agentName.getRequired("agent_name")

            /**
             * Returns the raw JSON value of [agentName].
             *
             * Unlike [agentName], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("agent_name")
            @ExcludeMissing
            fun _agentName(): JsonField<String> = agentName

            @JsonAnySetter
            private fun putAdditionalProperty(key: String, value: JsonValue) {
                additionalProperties.put(key, value)
            }

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> =
                Collections.unmodifiableMap(additionalProperties)

            fun toBuilder() = Builder().from(this)

            companion object {

                /**
                 * Returns a mutable builder for constructing an instance of [Agent].
                 *
                 * The following fields are required:
                 * ```java
                 * .agentName()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Agent]. */
            class Builder internal constructor() {

                private var agentName: JsonField<String>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(agent: Agent) = apply {
                    agentName = agent.agentName
                    additionalProperties = agent.additionalProperties.toMutableMap()
                }

                /** The canonical name of the agent that produced this item. */
                fun agentName(agentName: String) = agentName(JsonField.of(agentName))

                /**
                 * Sets [Builder.agentName] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.agentName] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun agentName(agentName: JsonField<String>) = apply { this.agentName = agentName }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [Agent].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .agentName()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Agent =
                    Agent(
                        checkRequired("agentName", agentName),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
            fun validate(): Agent = apply {
                if (validated) {
                    return@apply
                }

                agentName()
                validated = true
            }

            fun isValid(): Boolean =
                try {
                    validate()
                    true
                } catch (e: OpenAIInvalidDataException) {
                    false
                }

            /**
             * Returns a score indicating how many valid values are contained in this object
             * recursively.
             *
             * Used for best match union deserialization.
             */
            @JvmSynthetic
            internal fun validity(): Int = (if (agentName.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Agent &&
                    agentName == other.agentName &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(agentName, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Agent{agentName=$agentName, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ImageGenerationCall &&
                id == other.id &&
                result == other.result &&
                status == other.status &&
                type == other.type &&
                agent == other.agent &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(id, result, status, type, agent, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ImageGenerationCall{id=$id, result=$result, status=$status, type=$type, agent=$agent, additionalProperties=$additionalProperties}"
    }

    /** A tool call to run a command on the local shell. */
    class LocalShellCall
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val action: JsonField<Action>,
        private val callId: JsonField<String>,
        private val status: JsonField<Status>,
        private val type: JsonValue,
        private val agent: JsonField<Agent>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("action") @ExcludeMissing action: JsonField<Action> = JsonMissing.of(),
            @JsonProperty("call_id") @ExcludeMissing callId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("status") @ExcludeMissing status: JsonField<Status> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("agent") @ExcludeMissing agent: JsonField<Agent> = JsonMissing.of(),
        ) : this(id, action, callId, status, type, agent, mutableMapOf())

        /**
         * The unique ID of the local shell call.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun id(): String = id.getRequired("id")

        /**
         * Execute a shell command on the server.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun action(): Action = action.getRequired("action")

        /**
         * The unique ID of the local shell tool call generated by the model.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun callId(): String = callId.getRequired("call_id")

        /**
         * The status of the local shell call.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun status(): Status = status.getRequired("status")

        /**
         * The type of the local shell call. Always `local_shell_call`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("local_shell_call")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * The agent that produced this item.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun agent(): Optional<Agent> = agent.getOptional("agent")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [action].
         *
         * Unlike [action], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("action") @ExcludeMissing fun _action(): JsonField<Action> = action

        /**
         * Returns the raw JSON value of [callId].
         *
         * Unlike [callId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("call_id") @ExcludeMissing fun _callId(): JsonField<String> = callId

        /**
         * Returns the raw JSON value of [status].
         *
         * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<Status> = status

        /**
         * Returns the raw JSON value of [agent].
         *
         * Unlike [agent], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("agent") @ExcludeMissing fun _agent(): JsonField<Agent> = agent

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [LocalShellCall].
             *
             * The following fields are required:
             * ```java
             * .id()
             * .action()
             * .callId()
             * .status()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [LocalShellCall]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var action: JsonField<Action>? = null
            private var callId: JsonField<String>? = null
            private var status: JsonField<Status>? = null
            private var type: JsonValue = JsonValue.from("local_shell_call")
            private var agent: JsonField<Agent> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(localShellCall: LocalShellCall) = apply {
                id = localShellCall.id
                action = localShellCall.action
                callId = localShellCall.callId
                status = localShellCall.status
                type = localShellCall.type
                agent = localShellCall.agent
                additionalProperties = localShellCall.additionalProperties.toMutableMap()
            }

            /** The unique ID of the local shell call. */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /** Execute a shell command on the server. */
            fun action(action: Action) = action(JsonField.of(action))

            /**
             * Sets [Builder.action] to an arbitrary JSON value.
             *
             * You should usually call [Builder.action] with a well-typed [Action] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun action(action: JsonField<Action>) = apply { this.action = action }

            /** The unique ID of the local shell tool call generated by the model. */
            fun callId(callId: String) = callId(JsonField.of(callId))

            /**
             * Sets [Builder.callId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.callId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun callId(callId: JsonField<String>) = apply { this.callId = callId }

            /** The status of the local shell call. */
            fun status(status: Status) = status(JsonField.of(status))

            /**
             * Sets [Builder.status] to an arbitrary JSON value.
             *
             * You should usually call [Builder.status] with a well-typed [Status] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun status(status: JsonField<Status>) = apply { this.status = status }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("local_shell_call")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

            /** The agent that produced this item. */
            fun agent(agent: Agent?) = agent(JsonField.ofNullable(agent))

            /** Alias for calling [Builder.agent] with `agent.orElse(null)`. */
            fun agent(agent: Optional<Agent>) = agent(agent.getOrNull())

            /**
             * Sets [Builder.agent] to an arbitrary JSON value.
             *
             * You should usually call [Builder.agent] with a well-typed [Agent] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun agent(agent: JsonField<Agent>) = apply { this.agent = agent }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            /**
             * Returns an immutable instance of [LocalShellCall].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .id()
             * .action()
             * .callId()
             * .status()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): LocalShellCall =
                LocalShellCall(
                    checkRequired("id", id),
                    checkRequired("action", action),
                    checkRequired("callId", callId),
                    checkRequired("status", status),
                    type,
                    agent,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
        fun validate(): LocalShellCall = apply {
            if (validated) {
                return@apply
            }

            id()
            action().validate()
            callId()
            status().validate()
            _type().let {
                if (it != JsonValue.from("local_shell_call")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
            agent().ifPresent { it.validate() }
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: OpenAIInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (if (id.asKnown().isPresent) 1 else 0) +
                (action.asKnown().getOrNull()?.validity() ?: 0) +
                (if (callId.asKnown().isPresent) 1 else 0) +
                (status.asKnown().getOrNull()?.validity() ?: 0) +
                type.let { if (it == JsonValue.from("local_shell_call")) 1 else 0 } +
                (agent.asKnown().getOrNull()?.validity() ?: 0)

        /** Execute a shell command on the server. */
        class Action
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val command: JsonField<List<String>>,
            private val env: JsonField<Env>,
            private val type: JsonValue,
            private val timeoutMs: JsonField<Long>,
            private val user: JsonField<String>,
            private val workingDirectory: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("command")
                @ExcludeMissing
                command: JsonField<List<String>> = JsonMissing.of(),
                @JsonProperty("env") @ExcludeMissing env: JsonField<Env> = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                @JsonProperty("timeout_ms")
                @ExcludeMissing
                timeoutMs: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("user") @ExcludeMissing user: JsonField<String> = JsonMissing.of(),
                @JsonProperty("working_directory")
                @ExcludeMissing
                workingDirectory: JsonField<String> = JsonMissing.of(),
            ) : this(command, env, type, timeoutMs, user, workingDirectory, mutableMapOf())

            /**
             * The command to run.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun command(): List<String> = command.getRequired("command")

            /**
             * Environment variables to set for the command.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun env(): Env = env.getRequired("env")

            /**
             * The type of the local shell action. Always `exec`.
             *
             * Expected to always return the following:
             * ```java
             * JsonValue.from("exec")
             * ```
             *
             * However, this method can be useful for debugging and logging (e.g. if the server
             * responded with an unexpected value).
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

            /**
             * Optional timeout in milliseconds for the command.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun timeoutMs(): Optional<Long> = timeoutMs.getOptional("timeout_ms")

            /**
             * Optional user to run the command as.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun user(): Optional<String> = user.getOptional("user")

            /**
             * Optional working directory to run the command in.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun workingDirectory(): Optional<String> =
                workingDirectory.getOptional("working_directory")

            /**
             * Returns the raw JSON value of [command].
             *
             * Unlike [command], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("command")
            @ExcludeMissing
            fun _command(): JsonField<List<String>> = command

            /**
             * Returns the raw JSON value of [env].
             *
             * Unlike [env], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("env") @ExcludeMissing fun _env(): JsonField<Env> = env

            /**
             * Returns the raw JSON value of [timeoutMs].
             *
             * Unlike [timeoutMs], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("timeout_ms")
            @ExcludeMissing
            fun _timeoutMs(): JsonField<Long> = timeoutMs

            /**
             * Returns the raw JSON value of [user].
             *
             * Unlike [user], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("user") @ExcludeMissing fun _user(): JsonField<String> = user

            /**
             * Returns the raw JSON value of [workingDirectory].
             *
             * Unlike [workingDirectory], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("working_directory")
            @ExcludeMissing
            fun _workingDirectory(): JsonField<String> = workingDirectory

            @JsonAnySetter
            private fun putAdditionalProperty(key: String, value: JsonValue) {
                additionalProperties.put(key, value)
            }

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> =
                Collections.unmodifiableMap(additionalProperties)

            fun toBuilder() = Builder().from(this)

            companion object {

                /**
                 * Returns a mutable builder for constructing an instance of [Action].
                 *
                 * The following fields are required:
                 * ```java
                 * .command()
                 * .env()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Action]. */
            class Builder internal constructor() {

                private var command: JsonField<MutableList<String>>? = null
                private var env: JsonField<Env>? = null
                private var type: JsonValue = JsonValue.from("exec")
                private var timeoutMs: JsonField<Long> = JsonMissing.of()
                private var user: JsonField<String> = JsonMissing.of()
                private var workingDirectory: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(action: Action) = apply {
                    command = action.command.map { it.toMutableList() }
                    env = action.env
                    type = action.type
                    timeoutMs = action.timeoutMs
                    user = action.user
                    workingDirectory = action.workingDirectory
                    additionalProperties = action.additionalProperties.toMutableMap()
                }

                /** The command to run. */
                fun command(command: List<String>) = command(JsonField.of(command))

                /**
                 * Sets [Builder.command] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.command] with a well-typed `List<String>` value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun command(command: JsonField<List<String>>) = apply {
                    this.command = command.map { it.toMutableList() }
                }

                /**
                 * Adds a single [String] to [Builder.command].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addCommand(command: String) = apply {
                    this.command =
                        (this.command ?: JsonField.of(mutableListOf())).also {
                            checkKnown("command", it).add(command)
                        }
                }

                /** Environment variables to set for the command. */
                fun env(env: Env) = env(JsonField.of(env))

                /**
                 * Sets [Builder.env] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.env] with a well-typed [Env] value instead. This
                 * method is primarily for setting the field to an undocumented or not yet supported
                 * value.
                 */
                fun env(env: JsonField<Env>) = apply { this.env = env }

                /**
                 * Sets the field to an arbitrary JSON value.
                 *
                 * It is usually unnecessary to call this method because the field defaults to the
                 * following:
                 * ```java
                 * JsonValue.from("exec")
                 * ```
                 *
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun type(type: JsonValue) = apply { this.type = type }

                /** Optional timeout in milliseconds for the command. */
                fun timeoutMs(timeoutMs: Long?) = timeoutMs(JsonField.ofNullable(timeoutMs))

                /**
                 * Alias for [Builder.timeoutMs].
                 *
                 * This unboxed primitive overload exists for backwards compatibility.
                 */
                fun timeoutMs(timeoutMs: Long) = timeoutMs(timeoutMs as Long?)

                /** Alias for calling [Builder.timeoutMs] with `timeoutMs.orElse(null)`. */
                fun timeoutMs(timeoutMs: Optional<Long>) = timeoutMs(timeoutMs.getOrNull())

                /**
                 * Sets [Builder.timeoutMs] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.timeoutMs] with a well-typed [Long] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun timeoutMs(timeoutMs: JsonField<Long>) = apply { this.timeoutMs = timeoutMs }

                /** Optional user to run the command as. */
                fun user(user: String?) = user(JsonField.ofNullable(user))

                /** Alias for calling [Builder.user] with `user.orElse(null)`. */
                fun user(user: Optional<String>) = user(user.getOrNull())

                /**
                 * Sets [Builder.user] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.user] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun user(user: JsonField<String>) = apply { this.user = user }

                /** Optional working directory to run the command in. */
                fun workingDirectory(workingDirectory: String?) =
                    workingDirectory(JsonField.ofNullable(workingDirectory))

                /**
                 * Alias for calling [Builder.workingDirectory] with
                 * `workingDirectory.orElse(null)`.
                 */
                fun workingDirectory(workingDirectory: Optional<String>) =
                    workingDirectory(workingDirectory.getOrNull())

                /**
                 * Sets [Builder.workingDirectory] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.workingDirectory] with a well-typed [String]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun workingDirectory(workingDirectory: JsonField<String>) = apply {
                    this.workingDirectory = workingDirectory
                }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [Action].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .command()
                 * .env()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Action =
                    Action(
                        checkRequired("command", command).map { it.toImmutable() },
                        checkRequired("env", env),
                        type,
                        timeoutMs,
                        user,
                        workingDirectory,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
            fun validate(): Action = apply {
                if (validated) {
                    return@apply
                }

                command()
                env().validate()
                _type().let {
                    if (it != JsonValue.from("exec")) {
                        throw OpenAIInvalidDataException("'type' is invalid, received $it")
                    }
                }
                timeoutMs()
                user()
                workingDirectory()
                validated = true
            }

            fun isValid(): Boolean =
                try {
                    validate()
                    true
                } catch (e: OpenAIInvalidDataException) {
                    false
                }

            /**
             * Returns a score indicating how many valid values are contained in this object
             * recursively.
             *
             * Used for best match union deserialization.
             */
            @JvmSynthetic
            internal fun validity(): Int =
                (command.asKnown().getOrNull()?.size ?: 0) +
                    (env.asKnown().getOrNull()?.validity() ?: 0) +
                    type.let { if (it == JsonValue.from("exec")) 1 else 0 } +
                    (if (timeoutMs.asKnown().isPresent) 1 else 0) +
                    (if (user.asKnown().isPresent) 1 else 0) +
                    (if (workingDirectory.asKnown().isPresent) 1 else 0)

            /** Environment variables to set for the command. */
            class Env
            @JsonCreator
            private constructor(
                @com.fasterxml.jackson.annotation.JsonValue
                private val additionalProperties: Map<String, JsonValue>
            ) {

                @JsonAnyGetter
                @ExcludeMissing
                fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                fun toBuilder() = Builder().from(this)

                companion object {

                    /** Returns a mutable builder for constructing an instance of [Env]. */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Env]. */
                class Builder internal constructor() {

                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(env: Env) = apply {
                        additionalProperties = env.additionalProperties.toMutableMap()
                    }

                    fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                        this.additionalProperties.clear()
                        putAllAdditionalProperties(additionalProperties)
                    }

                    fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                        additionalProperties.put(key, value)
                    }

                    fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                        apply {
                            this.additionalProperties.putAll(additionalProperties)
                        }

                    fun removeAdditionalProperty(key: String) = apply {
                        additionalProperties.remove(key)
                    }

                    fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                        keys.forEach(::removeAdditionalProperty)
                    }

                    /**
                     * Returns an immutable instance of [Env].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     */
                    fun build(): Env = Env(additionalProperties.toImmutable())
                }

                private var validated: Boolean = false

                /**
                 * Validates that the types of all values in this object match their expected types
                 * recursively.
                 *
                 * This method is _not_ forwards compatible with new types from the API for existing
                 * fields.
                 *
                 * @throws OpenAIInvalidDataException if any value type in this object doesn't match
                 *   its expected type.
                 */
                fun validate(): Env = apply {
                    if (validated) {
                        return@apply
                    }

                    validated = true
                }

                fun isValid(): Boolean =
                    try {
                        validate()
                        true
                    } catch (e: OpenAIInvalidDataException) {
                        false
                    }

                /**
                 * Returns a score indicating how many valid values are contained in this object
                 * recursively.
                 *
                 * Used for best match union deserialization.
                 */
                @JvmSynthetic
                internal fun validity(): Int =
                    additionalProperties.count { (_, value) ->
                        !value.isNull() && !value.isMissing()
                    }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Env && additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

                override fun hashCode(): Int = hashCode

                override fun toString() = "Env{additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Action &&
                    command == other.command &&
                    env == other.env &&
                    type == other.type &&
                    timeoutMs == other.timeoutMs &&
                    user == other.user &&
                    workingDirectory == other.workingDirectory &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(
                    command,
                    env,
                    type,
                    timeoutMs,
                    user,
                    workingDirectory,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Action{command=$command, env=$env, type=$type, timeoutMs=$timeoutMs, user=$user, workingDirectory=$workingDirectory, additionalProperties=$additionalProperties}"
        }

        /** The status of the local shell call. */
        class Status @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

            /**
             * Returns this class instance's raw value.
             *
             * This is usually only useful if this instance was deserialized from data that doesn't
             * match any known member, and you want to know that value. For example, if the SDK is
             * on an older version than the API, then the API may respond with new members that the
             * SDK is unaware of.
             */
            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val IN_PROGRESS = of("in_progress")

                @JvmField val COMPLETED = of("completed")

                @JvmField val INCOMPLETE = of("incomplete")

                @JvmStatic fun of(value: String) = Status(JsonField.of(value))
            }

            /** An enum containing [Status]'s known values. */
            enum class Known {
                IN_PROGRESS,
                COMPLETED,
                INCOMPLETE,
            }

            /**
             * An enum containing [Status]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Status] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                IN_PROGRESS,
                COMPLETED,
                INCOMPLETE,
                /**
                 * An enum member indicating that [Status] was instantiated with an unknown value.
                 */
                _UNKNOWN,
            }

            /**
             * Returns an enum member corresponding to this class instance's value, or
             * [Value._UNKNOWN] if the class was instantiated with an unknown value.
             *
             * Use the [known] method instead if you're certain the value is always known or if you
             * want to throw for the unknown case.
             */
            fun value(): Value =
                when (this) {
                    IN_PROGRESS -> Value.IN_PROGRESS
                    COMPLETED -> Value.COMPLETED
                    INCOMPLETE -> Value.INCOMPLETE
                    else -> Value._UNKNOWN
                }

            /**
             * Returns an enum member corresponding to this class instance's value.
             *
             * Use the [value] method instead if you're uncertain the value is always known and
             * don't want to throw for the unknown case.
             *
             * @throws OpenAIInvalidDataException if this class instance's value is a not a known
             *   member.
             */
            fun known(): Known =
                when (this) {
                    IN_PROGRESS -> Known.IN_PROGRESS
                    COMPLETED -> Known.COMPLETED
                    INCOMPLETE -> Known.INCOMPLETE
                    else -> throw OpenAIInvalidDataException("Unknown Status: $value")
                }

            /**
             * Returns this class instance's primitive wire representation.
             *
             * This differs from the [toString] method because that method is primarily for
             * debugging and generally doesn't throw.
             *
             * @throws OpenAIInvalidDataException if this class instance's value does not have the
             *   expected primitive type.
             */
            fun asString(): String =
                _value().asString().orElseThrow {
                    OpenAIInvalidDataException("Value is not a String")
                }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
            fun validate(): Status = apply {
                if (validated) {
                    return@apply
                }

                known()
                validated = true
            }

            fun isValid(): Boolean =
                try {
                    validate()
                    true
                } catch (e: OpenAIInvalidDataException) {
                    false
                }

            /**
             * Returns a score indicating how many valid values are contained in this object
             * recursively.
             *
             * Used for best match union deserialization.
             */
            @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Status && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        /** The agent that produced this item. */
        class Agent
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val agentName: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("agent_name")
                @ExcludeMissing
                agentName: JsonField<String> = JsonMissing.of()
            ) : this(agentName, mutableMapOf())

            /**
             * The canonical name of the agent that produced this item.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun agentName(): String = agentName.getRequired("agent_name")

            /**
             * Returns the raw JSON value of [agentName].
             *
             * Unlike [agentName], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("agent_name")
            @ExcludeMissing
            fun _agentName(): JsonField<String> = agentName

            @JsonAnySetter
            private fun putAdditionalProperty(key: String, value: JsonValue) {
                additionalProperties.put(key, value)
            }

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> =
                Collections.unmodifiableMap(additionalProperties)

            fun toBuilder() = Builder().from(this)

            companion object {

                /**
                 * Returns a mutable builder for constructing an instance of [Agent].
                 *
                 * The following fields are required:
                 * ```java
                 * .agentName()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Agent]. */
            class Builder internal constructor() {

                private var agentName: JsonField<String>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(agent: Agent) = apply {
                    agentName = agent.agentName
                    additionalProperties = agent.additionalProperties.toMutableMap()
                }

                /** The canonical name of the agent that produced this item. */
                fun agentName(agentName: String) = agentName(JsonField.of(agentName))

                /**
                 * Sets [Builder.agentName] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.agentName] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun agentName(agentName: JsonField<String>) = apply { this.agentName = agentName }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [Agent].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .agentName()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Agent =
                    Agent(
                        checkRequired("agentName", agentName),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
            fun validate(): Agent = apply {
                if (validated) {
                    return@apply
                }

                agentName()
                validated = true
            }

            fun isValid(): Boolean =
                try {
                    validate()
                    true
                } catch (e: OpenAIInvalidDataException) {
                    false
                }

            /**
             * Returns a score indicating how many valid values are contained in this object
             * recursively.
             *
             * Used for best match union deserialization.
             */
            @JvmSynthetic
            internal fun validity(): Int = (if (agentName.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Agent &&
                    agentName == other.agentName &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(agentName, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Agent{agentName=$agentName, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is LocalShellCall &&
                id == other.id &&
                action == other.action &&
                callId == other.callId &&
                status == other.status &&
                type == other.type &&
                agent == other.agent &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(id, action, callId, status, type, agent, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "LocalShellCall{id=$id, action=$action, callId=$callId, status=$status, type=$type, agent=$agent, additionalProperties=$additionalProperties}"
    }

    /** The output of a local shell tool call. */
    class LocalShellCallOutput
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val output: JsonField<String>,
        private val type: JsonValue,
        private val agent: JsonField<Agent>,
        private val status: JsonField<Status>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("output") @ExcludeMissing output: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("agent") @ExcludeMissing agent: JsonField<Agent> = JsonMissing.of(),
            @JsonProperty("status") @ExcludeMissing status: JsonField<Status> = JsonMissing.of(),
        ) : this(id, output, type, agent, status, mutableMapOf())

        /**
         * The unique ID of the local shell tool call generated by the model.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun id(): String = id.getRequired("id")

        /**
         * A JSON string of the output of the local shell tool call.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun output(): String = output.getRequired("output")

        /**
         * The type of the local shell tool call output. Always `local_shell_call_output`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("local_shell_call_output")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * The agent that produced this item.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun agent(): Optional<Agent> = agent.getOptional("agent")

        /**
         * The status of the item. One of `in_progress`, `completed`, or `incomplete`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun status(): Optional<Status> = status.getOptional("status")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [output].
         *
         * Unlike [output], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("output") @ExcludeMissing fun _output(): JsonField<String> = output

        /**
         * Returns the raw JSON value of [agent].
         *
         * Unlike [agent], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("agent") @ExcludeMissing fun _agent(): JsonField<Agent> = agent

        /**
         * Returns the raw JSON value of [status].
         *
         * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<Status> = status

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [LocalShellCallOutput].
             *
             * The following fields are required:
             * ```java
             * .id()
             * .output()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [LocalShellCallOutput]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var output: JsonField<String>? = null
            private var type: JsonValue = JsonValue.from("local_shell_call_output")
            private var agent: JsonField<Agent> = JsonMissing.of()
            private var status: JsonField<Status> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(localShellCallOutput: LocalShellCallOutput) = apply {
                id = localShellCallOutput.id
                output = localShellCallOutput.output
                type = localShellCallOutput.type
                agent = localShellCallOutput.agent
                status = localShellCallOutput.status
                additionalProperties = localShellCallOutput.additionalProperties.toMutableMap()
            }

            /** The unique ID of the local shell tool call generated by the model. */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /** A JSON string of the output of the local shell tool call. */
            fun output(output: String) = output(JsonField.of(output))

            /**
             * Sets [Builder.output] to an arbitrary JSON value.
             *
             * You should usually call [Builder.output] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun output(output: JsonField<String>) = apply { this.output = output }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("local_shell_call_output")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

            /** The agent that produced this item. */
            fun agent(agent: Agent?) = agent(JsonField.ofNullable(agent))

            /** Alias for calling [Builder.agent] with `agent.orElse(null)`. */
            fun agent(agent: Optional<Agent>) = agent(agent.getOrNull())

            /**
             * Sets [Builder.agent] to an arbitrary JSON value.
             *
             * You should usually call [Builder.agent] with a well-typed [Agent] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun agent(agent: JsonField<Agent>) = apply { this.agent = agent }

            /** The status of the item. One of `in_progress`, `completed`, or `incomplete`. */
            fun status(status: Status?) = status(JsonField.ofNullable(status))

            /** Alias for calling [Builder.status] with `status.orElse(null)`. */
            fun status(status: Optional<Status>) = status(status.getOrNull())

            /**
             * Sets [Builder.status] to an arbitrary JSON value.
             *
             * You should usually call [Builder.status] with a well-typed [Status] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun status(status: JsonField<Status>) = apply { this.status = status }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            /**
             * Returns an immutable instance of [LocalShellCallOutput].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .id()
             * .output()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): LocalShellCallOutput =
                LocalShellCallOutput(
                    checkRequired("id", id),
                    checkRequired("output", output),
                    type,
                    agent,
                    status,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
        fun validate(): LocalShellCallOutput = apply {
            if (validated) {
                return@apply
            }

            id()
            output()
            _type().let {
                if (it != JsonValue.from("local_shell_call_output")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
            agent().ifPresent { it.validate() }
            status().ifPresent { it.validate() }
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: OpenAIInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (if (id.asKnown().isPresent) 1 else 0) +
                (if (output.asKnown().isPresent) 1 else 0) +
                type.let { if (it == JsonValue.from("local_shell_call_output")) 1 else 0 } +
                (agent.asKnown().getOrNull()?.validity() ?: 0) +
                (status.asKnown().getOrNull()?.validity() ?: 0)

        /** The agent that produced this item. */
        class Agent
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val agentName: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("agent_name")
                @ExcludeMissing
                agentName: JsonField<String> = JsonMissing.of()
            ) : this(agentName, mutableMapOf())

            /**
             * The canonical name of the agent that produced this item.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun agentName(): String = agentName.getRequired("agent_name")

            /**
             * Returns the raw JSON value of [agentName].
             *
             * Unlike [agentName], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("agent_name")
            @ExcludeMissing
            fun _agentName(): JsonField<String> = agentName

            @JsonAnySetter
            private fun putAdditionalProperty(key: String, value: JsonValue) {
                additionalProperties.put(key, value)
            }

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> =
                Collections.unmodifiableMap(additionalProperties)

            fun toBuilder() = Builder().from(this)

            companion object {

                /**
                 * Returns a mutable builder for constructing an instance of [Agent].
                 *
                 * The following fields are required:
                 * ```java
                 * .agentName()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Agent]. */
            class Builder internal constructor() {

                private var agentName: JsonField<String>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(agent: Agent) = apply {
                    agentName = agent.agentName
                    additionalProperties = agent.additionalProperties.toMutableMap()
                }

                /** The canonical name of the agent that produced this item. */
                fun agentName(agentName: String) = agentName(JsonField.of(agentName))

                /**
                 * Sets [Builder.agentName] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.agentName] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun agentName(agentName: JsonField<String>) = apply { this.agentName = agentName }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [Agent].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .agentName()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Agent =
                    Agent(
                        checkRequired("agentName", agentName),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
            fun validate(): Agent = apply {
                if (validated) {
                    return@apply
                }

                agentName()
                validated = true
            }

            fun isValid(): Boolean =
                try {
                    validate()
                    true
                } catch (e: OpenAIInvalidDataException) {
                    false
                }

            /**
             * Returns a score indicating how many valid values are contained in this object
             * recursively.
             *
             * Used for best match union deserialization.
             */
            @JvmSynthetic
            internal fun validity(): Int = (if (agentName.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Agent &&
                    agentName == other.agentName &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(agentName, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Agent{agentName=$agentName, additionalProperties=$additionalProperties}"
        }

        /** The status of the item. One of `in_progress`, `completed`, or `incomplete`. */
        class Status @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

            /**
             * Returns this class instance's raw value.
             *
             * This is usually only useful if this instance was deserialized from data that doesn't
             * match any known member, and you want to know that value. For example, if the SDK is
             * on an older version than the API, then the API may respond with new members that the
             * SDK is unaware of.
             */
            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val IN_PROGRESS = of("in_progress")

                @JvmField val COMPLETED = of("completed")

                @JvmField val INCOMPLETE = of("incomplete")

                @JvmStatic fun of(value: String) = Status(JsonField.of(value))
            }

            /** An enum containing [Status]'s known values. */
            enum class Known {
                IN_PROGRESS,
                COMPLETED,
                INCOMPLETE,
            }

            /**
             * An enum containing [Status]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Status] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                IN_PROGRESS,
                COMPLETED,
                INCOMPLETE,
                /**
                 * An enum member indicating that [Status] was instantiated with an unknown value.
                 */
                _UNKNOWN,
            }

            /**
             * Returns an enum member corresponding to this class instance's value, or
             * [Value._UNKNOWN] if the class was instantiated with an unknown value.
             *
             * Use the [known] method instead if you're certain the value is always known or if you
             * want to throw for the unknown case.
             */
            fun value(): Value =
                when (this) {
                    IN_PROGRESS -> Value.IN_PROGRESS
                    COMPLETED -> Value.COMPLETED
                    INCOMPLETE -> Value.INCOMPLETE
                    else -> Value._UNKNOWN
                }

            /**
             * Returns an enum member corresponding to this class instance's value.
             *
             * Use the [value] method instead if you're uncertain the value is always known and
             * don't want to throw for the unknown case.
             *
             * @throws OpenAIInvalidDataException if this class instance's value is a not a known
             *   member.
             */
            fun known(): Known =
                when (this) {
                    IN_PROGRESS -> Known.IN_PROGRESS
                    COMPLETED -> Known.COMPLETED
                    INCOMPLETE -> Known.INCOMPLETE
                    else -> throw OpenAIInvalidDataException("Unknown Status: $value")
                }

            /**
             * Returns this class instance's primitive wire representation.
             *
             * This differs from the [toString] method because that method is primarily for
             * debugging and generally doesn't throw.
             *
             * @throws OpenAIInvalidDataException if this class instance's value does not have the
             *   expected primitive type.
             */
            fun asString(): String =
                _value().asString().orElseThrow {
                    OpenAIInvalidDataException("Value is not a String")
                }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
            fun validate(): Status = apply {
                if (validated) {
                    return@apply
                }

                known()
                validated = true
            }

            fun isValid(): Boolean =
                try {
                    validate()
                    true
                } catch (e: OpenAIInvalidDataException) {
                    false
                }

            /**
             * Returns a score indicating how many valid values are contained in this object
             * recursively.
             *
             * Used for best match union deserialization.
             */
            @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Status && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is LocalShellCallOutput &&
                id == other.id &&
                output == other.output &&
                type == other.type &&
                agent == other.agent &&
                status == other.status &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(id, output, type, agent, status, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "LocalShellCallOutput{id=$id, output=$output, type=$type, agent=$agent, status=$status, additionalProperties=$additionalProperties}"
    }

    /** A list of tools available on an MCP server. */
    class McpListTools
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val serverLabel: JsonField<String>,
        private val tools: JsonField<List<Tool>>,
        private val type: JsonValue,
        private val agent: JsonField<Agent>,
        private val error: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("server_label")
            @ExcludeMissing
            serverLabel: JsonField<String> = JsonMissing.of(),
            @JsonProperty("tools") @ExcludeMissing tools: JsonField<List<Tool>> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("agent") @ExcludeMissing agent: JsonField<Agent> = JsonMissing.of(),
            @JsonProperty("error") @ExcludeMissing error: JsonField<String> = JsonMissing.of(),
        ) : this(id, serverLabel, tools, type, agent, error, mutableMapOf())

        /**
         * The unique ID of the list.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun id(): String = id.getRequired("id")

        /**
         * The label of the MCP server.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun serverLabel(): String = serverLabel.getRequired("server_label")

        /**
         * The tools available on the server.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun tools(): List<Tool> = tools.getRequired("tools")

        /**
         * The type of the item. Always `mcp_list_tools`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("mcp_list_tools")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * The agent that produced this item.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun agent(): Optional<Agent> = agent.getOptional("agent")

        /**
         * Error message if the server could not list tools.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun error(): Optional<String> = error.getOptional("error")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [serverLabel].
         *
         * Unlike [serverLabel], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("server_label")
        @ExcludeMissing
        fun _serverLabel(): JsonField<String> = serverLabel

        /**
         * Returns the raw JSON value of [tools].
         *
         * Unlike [tools], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("tools") @ExcludeMissing fun _tools(): JsonField<List<Tool>> = tools

        /**
         * Returns the raw JSON value of [agent].
         *
         * Unlike [agent], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("agent") @ExcludeMissing fun _agent(): JsonField<Agent> = agent

        /**
         * Returns the raw JSON value of [error].
         *
         * Unlike [error], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("error") @ExcludeMissing fun _error(): JsonField<String> = error

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [McpListTools].
             *
             * The following fields are required:
             * ```java
             * .id()
             * .serverLabel()
             * .tools()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [McpListTools]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var serverLabel: JsonField<String>? = null
            private var tools: JsonField<MutableList<Tool>>? = null
            private var type: JsonValue = JsonValue.from("mcp_list_tools")
            private var agent: JsonField<Agent> = JsonMissing.of()
            private var error: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(mcpListTools: McpListTools) = apply {
                id = mcpListTools.id
                serverLabel = mcpListTools.serverLabel
                tools = mcpListTools.tools.map { it.toMutableList() }
                type = mcpListTools.type
                agent = mcpListTools.agent
                error = mcpListTools.error
                additionalProperties = mcpListTools.additionalProperties.toMutableMap()
            }

            /** The unique ID of the list. */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /** The label of the MCP server. */
            fun serverLabel(serverLabel: String) = serverLabel(JsonField.of(serverLabel))

            /**
             * Sets [Builder.serverLabel] to an arbitrary JSON value.
             *
             * You should usually call [Builder.serverLabel] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun serverLabel(serverLabel: JsonField<String>) = apply {
                this.serverLabel = serverLabel
            }

            /** The tools available on the server. */
            fun tools(tools: List<Tool>) = tools(JsonField.of(tools))

            /**
             * Sets [Builder.tools] to an arbitrary JSON value.
             *
             * You should usually call [Builder.tools] with a well-typed `List<Tool>` value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun tools(tools: JsonField<List<Tool>>) = apply {
                this.tools = tools.map { it.toMutableList() }
            }

            /**
             * Adds a single [Tool] to [tools].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addTool(tool: Tool) = apply {
                tools =
                    (tools ?: JsonField.of(mutableListOf())).also {
                        checkKnown("tools", it).add(tool)
                    }
            }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("mcp_list_tools")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

            /** The agent that produced this item. */
            fun agent(agent: Agent?) = agent(JsonField.ofNullable(agent))

            /** Alias for calling [Builder.agent] with `agent.orElse(null)`. */
            fun agent(agent: Optional<Agent>) = agent(agent.getOrNull())

            /**
             * Sets [Builder.agent] to an arbitrary JSON value.
             *
             * You should usually call [Builder.agent] with a well-typed [Agent] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun agent(agent: JsonField<Agent>) = apply { this.agent = agent }

            /** Error message if the server could not list tools. */
            fun error(error: String?) = error(JsonField.ofNullable(error))

            /** Alias for calling [Builder.error] with `error.orElse(null)`. */
            fun error(error: Optional<String>) = error(error.getOrNull())

            /**
             * Sets [Builder.error] to an arbitrary JSON value.
             *
             * You should usually call [Builder.error] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun error(error: JsonField<String>) = apply { this.error = error }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            /**
             * Returns an immutable instance of [McpListTools].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .id()
             * .serverLabel()
             * .tools()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): McpListTools =
                McpListTools(
                    checkRequired("id", id),
                    checkRequired("serverLabel", serverLabel),
                    checkRequired("tools", tools).map { it.toImmutable() },
                    type,
                    agent,
                    error,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
        fun validate(): McpListTools = apply {
            if (validated) {
                return@apply
            }

            id()
            serverLabel()
            tools().forEach { it.validate() }
            _type().let {
                if (it != JsonValue.from("mcp_list_tools")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
            agent().ifPresent { it.validate() }
            error()
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: OpenAIInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (if (id.asKnown().isPresent) 1 else 0) +
                (if (serverLabel.asKnown().isPresent) 1 else 0) +
                (tools.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                type.let { if (it == JsonValue.from("mcp_list_tools")) 1 else 0 } +
                (agent.asKnown().getOrNull()?.validity() ?: 0) +
                (if (error.asKnown().isPresent) 1 else 0)

        /** A tool available on an MCP server. */
        class Tool
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val inputSchema: JsonValue,
            private val name: JsonField<String>,
            private val annotations: JsonValue,
            private val description: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("input_schema")
                @ExcludeMissing
                inputSchema: JsonValue = JsonMissing.of(),
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
                @JsonProperty("annotations")
                @ExcludeMissing
                annotations: JsonValue = JsonMissing.of(),
                @JsonProperty("description")
                @ExcludeMissing
                description: JsonField<String> = JsonMissing.of(),
            ) : this(inputSchema, name, annotations, description, mutableMapOf())

            /**
             * The JSON schema describing the tool's input.
             *
             * This arbitrary value can be deserialized into a custom type using the `convert`
             * method:
             * ```java
             * MyClass myObject = tool.inputSchema().convert(MyClass.class);
             * ```
             */
            @JsonProperty("input_schema")
            @ExcludeMissing
            fun _inputSchema(): JsonValue = inputSchema

            /**
             * The name of the tool.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun name(): String = name.getRequired("name")

            /**
             * Additional annotations about the tool.
             *
             * This arbitrary value can be deserialized into a custom type using the `convert`
             * method:
             * ```java
             * MyClass myObject = tool.annotations().convert(MyClass.class);
             * ```
             */
            @JsonProperty("annotations") @ExcludeMissing fun _annotations(): JsonValue = annotations

            /**
             * The description of the tool.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun description(): Optional<String> = description.getOptional("description")

            /**
             * Returns the raw JSON value of [name].
             *
             * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

            /**
             * Returns the raw JSON value of [description].
             *
             * Unlike [description], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("description")
            @ExcludeMissing
            fun _description(): JsonField<String> = description

            @JsonAnySetter
            private fun putAdditionalProperty(key: String, value: JsonValue) {
                additionalProperties.put(key, value)
            }

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> =
                Collections.unmodifiableMap(additionalProperties)

            fun toBuilder() = Builder().from(this)

            companion object {

                /**
                 * Returns a mutable builder for constructing an instance of [Tool].
                 *
                 * The following fields are required:
                 * ```java
                 * .inputSchema()
                 * .name()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Tool]. */
            class Builder internal constructor() {

                private var inputSchema: JsonValue? = null
                private var name: JsonField<String>? = null
                private var annotations: JsonValue = JsonMissing.of()
                private var description: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(tool: Tool) = apply {
                    inputSchema = tool.inputSchema
                    name = tool.name
                    annotations = tool.annotations
                    description = tool.description
                    additionalProperties = tool.additionalProperties.toMutableMap()
                }

                /** The JSON schema describing the tool's input. */
                fun inputSchema(inputSchema: JsonValue) = apply { this.inputSchema = inputSchema }

                /** The name of the tool. */
                fun name(name: String) = name(JsonField.of(name))

                /**
                 * Sets [Builder.name] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.name] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun name(name: JsonField<String>) = apply { this.name = name }

                /** Additional annotations about the tool. */
                fun annotations(annotations: JsonValue) = apply { this.annotations = annotations }

                /** The description of the tool. */
                fun description(description: String?) =
                    description(JsonField.ofNullable(description))

                /** Alias for calling [Builder.description] with `description.orElse(null)`. */
                fun description(description: Optional<String>) =
                    description(description.getOrNull())

                /**
                 * Sets [Builder.description] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.description] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun description(description: JsonField<String>) = apply {
                    this.description = description
                }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [Tool].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .inputSchema()
                 * .name()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Tool =
                    Tool(
                        checkRequired("inputSchema", inputSchema),
                        checkRequired("name", name),
                        annotations,
                        description,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
            fun validate(): Tool = apply {
                if (validated) {
                    return@apply
                }

                name()
                description()
                validated = true
            }

            fun isValid(): Boolean =
                try {
                    validate()
                    true
                } catch (e: OpenAIInvalidDataException) {
                    false
                }

            /**
             * Returns a score indicating how many valid values are contained in this object
             * recursively.
             *
             * Used for best match union deserialization.
             */
            @JvmSynthetic
            internal fun validity(): Int =
                (if (name.asKnown().isPresent) 1 else 0) +
                    (if (description.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Tool &&
                    inputSchema == other.inputSchema &&
                    name == other.name &&
                    annotations == other.annotations &&
                    description == other.description &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(inputSchema, name, annotations, description, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Tool{inputSchema=$inputSchema, name=$name, annotations=$annotations, description=$description, additionalProperties=$additionalProperties}"
        }

        /** The agent that produced this item. */
        class Agent
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val agentName: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("agent_name")
                @ExcludeMissing
                agentName: JsonField<String> = JsonMissing.of()
            ) : this(agentName, mutableMapOf())

            /**
             * The canonical name of the agent that produced this item.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun agentName(): String = agentName.getRequired("agent_name")

            /**
             * Returns the raw JSON value of [agentName].
             *
             * Unlike [agentName], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("agent_name")
            @ExcludeMissing
            fun _agentName(): JsonField<String> = agentName

            @JsonAnySetter
            private fun putAdditionalProperty(key: String, value: JsonValue) {
                additionalProperties.put(key, value)
            }

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> =
                Collections.unmodifiableMap(additionalProperties)

            fun toBuilder() = Builder().from(this)

            companion object {

                /**
                 * Returns a mutable builder for constructing an instance of [Agent].
                 *
                 * The following fields are required:
                 * ```java
                 * .agentName()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Agent]. */
            class Builder internal constructor() {

                private var agentName: JsonField<String>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(agent: Agent) = apply {
                    agentName = agent.agentName
                    additionalProperties = agent.additionalProperties.toMutableMap()
                }

                /** The canonical name of the agent that produced this item. */
                fun agentName(agentName: String) = agentName(JsonField.of(agentName))

                /**
                 * Sets [Builder.agentName] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.agentName] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun agentName(agentName: JsonField<String>) = apply { this.agentName = agentName }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [Agent].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .agentName()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Agent =
                    Agent(
                        checkRequired("agentName", agentName),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
            fun validate(): Agent = apply {
                if (validated) {
                    return@apply
                }

                agentName()
                validated = true
            }

            fun isValid(): Boolean =
                try {
                    validate()
                    true
                } catch (e: OpenAIInvalidDataException) {
                    false
                }

            /**
             * Returns a score indicating how many valid values are contained in this object
             * recursively.
             *
             * Used for best match union deserialization.
             */
            @JvmSynthetic
            internal fun validity(): Int = (if (agentName.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Agent &&
                    agentName == other.agentName &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(agentName, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Agent{agentName=$agentName, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is McpListTools &&
                id == other.id &&
                serverLabel == other.serverLabel &&
                tools == other.tools &&
                type == other.type &&
                agent == other.agent &&
                error == other.error &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(id, serverLabel, tools, type, agent, error, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "McpListTools{id=$id, serverLabel=$serverLabel, tools=$tools, type=$type, agent=$agent, error=$error, additionalProperties=$additionalProperties}"
    }

    /** A request for human approval of a tool invocation. */
    class McpApprovalRequest
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val arguments: JsonField<String>,
        private val name: JsonField<String>,
        private val serverLabel: JsonField<String>,
        private val type: JsonValue,
        private val agent: JsonField<Agent>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("arguments")
            @ExcludeMissing
            arguments: JsonField<String> = JsonMissing.of(),
            @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            @JsonProperty("server_label")
            @ExcludeMissing
            serverLabel: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("agent") @ExcludeMissing agent: JsonField<Agent> = JsonMissing.of(),
        ) : this(id, arguments, name, serverLabel, type, agent, mutableMapOf())

        /**
         * The unique ID of the approval request.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun id(): String = id.getRequired("id")

        /**
         * A JSON string of arguments for the tool.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun arguments(): String = arguments.getRequired("arguments")

        /**
         * The name of the tool to run.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun name(): String = name.getRequired("name")

        /**
         * The label of the MCP server making the request.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun serverLabel(): String = serverLabel.getRequired("server_label")

        /**
         * The type of the item. Always `mcp_approval_request`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("mcp_approval_request")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * The agent that produced this item.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun agent(): Optional<Agent> = agent.getOptional("agent")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [arguments].
         *
         * Unlike [arguments], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("arguments") @ExcludeMissing fun _arguments(): JsonField<String> = arguments

        /**
         * Returns the raw JSON value of [name].
         *
         * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

        /**
         * Returns the raw JSON value of [serverLabel].
         *
         * Unlike [serverLabel], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("server_label")
        @ExcludeMissing
        fun _serverLabel(): JsonField<String> = serverLabel

        /**
         * Returns the raw JSON value of [agent].
         *
         * Unlike [agent], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("agent") @ExcludeMissing fun _agent(): JsonField<Agent> = agent

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [McpApprovalRequest].
             *
             * The following fields are required:
             * ```java
             * .id()
             * .arguments()
             * .name()
             * .serverLabel()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [McpApprovalRequest]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var arguments: JsonField<String>? = null
            private var name: JsonField<String>? = null
            private var serverLabel: JsonField<String>? = null
            private var type: JsonValue = JsonValue.from("mcp_approval_request")
            private var agent: JsonField<Agent> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(mcpApprovalRequest: McpApprovalRequest) = apply {
                id = mcpApprovalRequest.id
                arguments = mcpApprovalRequest.arguments
                name = mcpApprovalRequest.name
                serverLabel = mcpApprovalRequest.serverLabel
                type = mcpApprovalRequest.type
                agent = mcpApprovalRequest.agent
                additionalProperties = mcpApprovalRequest.additionalProperties.toMutableMap()
            }

            /** The unique ID of the approval request. */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /** A JSON string of arguments for the tool. */
            fun arguments(arguments: String) = arguments(JsonField.of(arguments))

            /**
             * Sets [Builder.arguments] to an arbitrary JSON value.
             *
             * You should usually call [Builder.arguments] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun arguments(arguments: JsonField<String>) = apply { this.arguments = arguments }

            /** The name of the tool to run. */
            fun name(name: String) = name(JsonField.of(name))

            /**
             * Sets [Builder.name] to an arbitrary JSON value.
             *
             * You should usually call [Builder.name] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun name(name: JsonField<String>) = apply { this.name = name }

            /** The label of the MCP server making the request. */
            fun serverLabel(serverLabel: String) = serverLabel(JsonField.of(serverLabel))

            /**
             * Sets [Builder.serverLabel] to an arbitrary JSON value.
             *
             * You should usually call [Builder.serverLabel] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun serverLabel(serverLabel: JsonField<String>) = apply {
                this.serverLabel = serverLabel
            }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("mcp_approval_request")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

            /** The agent that produced this item. */
            fun agent(agent: Agent?) = agent(JsonField.ofNullable(agent))

            /** Alias for calling [Builder.agent] with `agent.orElse(null)`. */
            fun agent(agent: Optional<Agent>) = agent(agent.getOrNull())

            /**
             * Sets [Builder.agent] to an arbitrary JSON value.
             *
             * You should usually call [Builder.agent] with a well-typed [Agent] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun agent(agent: JsonField<Agent>) = apply { this.agent = agent }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            /**
             * Returns an immutable instance of [McpApprovalRequest].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .id()
             * .arguments()
             * .name()
             * .serverLabel()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): McpApprovalRequest =
                McpApprovalRequest(
                    checkRequired("id", id),
                    checkRequired("arguments", arguments),
                    checkRequired("name", name),
                    checkRequired("serverLabel", serverLabel),
                    type,
                    agent,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
        fun validate(): McpApprovalRequest = apply {
            if (validated) {
                return@apply
            }

            id()
            arguments()
            name()
            serverLabel()
            _type().let {
                if (it != JsonValue.from("mcp_approval_request")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
            agent().ifPresent { it.validate() }
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: OpenAIInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (if (id.asKnown().isPresent) 1 else 0) +
                (if (arguments.asKnown().isPresent) 1 else 0) +
                (if (name.asKnown().isPresent) 1 else 0) +
                (if (serverLabel.asKnown().isPresent) 1 else 0) +
                type.let { if (it == JsonValue.from("mcp_approval_request")) 1 else 0 } +
                (agent.asKnown().getOrNull()?.validity() ?: 0)

        /** The agent that produced this item. */
        class Agent
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val agentName: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("agent_name")
                @ExcludeMissing
                agentName: JsonField<String> = JsonMissing.of()
            ) : this(agentName, mutableMapOf())

            /**
             * The canonical name of the agent that produced this item.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun agentName(): String = agentName.getRequired("agent_name")

            /**
             * Returns the raw JSON value of [agentName].
             *
             * Unlike [agentName], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("agent_name")
            @ExcludeMissing
            fun _agentName(): JsonField<String> = agentName

            @JsonAnySetter
            private fun putAdditionalProperty(key: String, value: JsonValue) {
                additionalProperties.put(key, value)
            }

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> =
                Collections.unmodifiableMap(additionalProperties)

            fun toBuilder() = Builder().from(this)

            companion object {

                /**
                 * Returns a mutable builder for constructing an instance of [Agent].
                 *
                 * The following fields are required:
                 * ```java
                 * .agentName()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Agent]. */
            class Builder internal constructor() {

                private var agentName: JsonField<String>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(agent: Agent) = apply {
                    agentName = agent.agentName
                    additionalProperties = agent.additionalProperties.toMutableMap()
                }

                /** The canonical name of the agent that produced this item. */
                fun agentName(agentName: String) = agentName(JsonField.of(agentName))

                /**
                 * Sets [Builder.agentName] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.agentName] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun agentName(agentName: JsonField<String>) = apply { this.agentName = agentName }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [Agent].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .agentName()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Agent =
                    Agent(
                        checkRequired("agentName", agentName),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
            fun validate(): Agent = apply {
                if (validated) {
                    return@apply
                }

                agentName()
                validated = true
            }

            fun isValid(): Boolean =
                try {
                    validate()
                    true
                } catch (e: OpenAIInvalidDataException) {
                    false
                }

            /**
             * Returns a score indicating how many valid values are contained in this object
             * recursively.
             *
             * Used for best match union deserialization.
             */
            @JvmSynthetic
            internal fun validity(): Int = (if (agentName.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Agent &&
                    agentName == other.agentName &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(agentName, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Agent{agentName=$agentName, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is McpApprovalRequest &&
                id == other.id &&
                arguments == other.arguments &&
                name == other.name &&
                serverLabel == other.serverLabel &&
                type == other.type &&
                agent == other.agent &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(id, arguments, name, serverLabel, type, agent, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "McpApprovalRequest{id=$id, arguments=$arguments, name=$name, serverLabel=$serverLabel, type=$type, agent=$agent, additionalProperties=$additionalProperties}"
    }

    /** A response to an MCP approval request. */
    class McpApprovalResponse
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val approvalRequestId: JsonField<String>,
        private val approve: JsonField<Boolean>,
        private val type: JsonValue,
        private val agent: JsonField<Agent>,
        private val reason: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("approval_request_id")
            @ExcludeMissing
            approvalRequestId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("approve") @ExcludeMissing approve: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("agent") @ExcludeMissing agent: JsonField<Agent> = JsonMissing.of(),
            @JsonProperty("reason") @ExcludeMissing reason: JsonField<String> = JsonMissing.of(),
        ) : this(id, approvalRequestId, approve, type, agent, reason, mutableMapOf())

        /**
         * The unique ID of the approval response
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun id(): String = id.getRequired("id")

        /**
         * The ID of the approval request being answered.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun approvalRequestId(): String = approvalRequestId.getRequired("approval_request_id")

        /**
         * Whether the request was approved.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun approve(): Boolean = approve.getRequired("approve")

        /**
         * The type of the item. Always `mcp_approval_response`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("mcp_approval_response")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * The agent that produced this item.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun agent(): Optional<Agent> = agent.getOptional("agent")

        /**
         * Optional reason for the decision.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun reason(): Optional<String> = reason.getOptional("reason")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [approvalRequestId].
         *
         * Unlike [approvalRequestId], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("approval_request_id")
        @ExcludeMissing
        fun _approvalRequestId(): JsonField<String> = approvalRequestId

        /**
         * Returns the raw JSON value of [approve].
         *
         * Unlike [approve], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("approve") @ExcludeMissing fun _approve(): JsonField<Boolean> = approve

        /**
         * Returns the raw JSON value of [agent].
         *
         * Unlike [agent], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("agent") @ExcludeMissing fun _agent(): JsonField<Agent> = agent

        /**
         * Returns the raw JSON value of [reason].
         *
         * Unlike [reason], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("reason") @ExcludeMissing fun _reason(): JsonField<String> = reason

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [McpApprovalResponse].
             *
             * The following fields are required:
             * ```java
             * .id()
             * .approvalRequestId()
             * .approve()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [McpApprovalResponse]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var approvalRequestId: JsonField<String>? = null
            private var approve: JsonField<Boolean>? = null
            private var type: JsonValue = JsonValue.from("mcp_approval_response")
            private var agent: JsonField<Agent> = JsonMissing.of()
            private var reason: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(mcpApprovalResponse: McpApprovalResponse) = apply {
                id = mcpApprovalResponse.id
                approvalRequestId = mcpApprovalResponse.approvalRequestId
                approve = mcpApprovalResponse.approve
                type = mcpApprovalResponse.type
                agent = mcpApprovalResponse.agent
                reason = mcpApprovalResponse.reason
                additionalProperties = mcpApprovalResponse.additionalProperties.toMutableMap()
            }

            /** The unique ID of the approval response */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /** The ID of the approval request being answered. */
            fun approvalRequestId(approvalRequestId: String) =
                approvalRequestId(JsonField.of(approvalRequestId))

            /**
             * Sets [Builder.approvalRequestId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.approvalRequestId] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun approvalRequestId(approvalRequestId: JsonField<String>) = apply {
                this.approvalRequestId = approvalRequestId
            }

            /** Whether the request was approved. */
            fun approve(approve: Boolean) = approve(JsonField.of(approve))

            /**
             * Sets [Builder.approve] to an arbitrary JSON value.
             *
             * You should usually call [Builder.approve] with a well-typed [Boolean] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun approve(approve: JsonField<Boolean>) = apply { this.approve = approve }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("mcp_approval_response")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

            /** The agent that produced this item. */
            fun agent(agent: Agent?) = agent(JsonField.ofNullable(agent))

            /** Alias for calling [Builder.agent] with `agent.orElse(null)`. */
            fun agent(agent: Optional<Agent>) = agent(agent.getOrNull())

            /**
             * Sets [Builder.agent] to an arbitrary JSON value.
             *
             * You should usually call [Builder.agent] with a well-typed [Agent] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun agent(agent: JsonField<Agent>) = apply { this.agent = agent }

            /** Optional reason for the decision. */
            fun reason(reason: String?) = reason(JsonField.ofNullable(reason))

            /** Alias for calling [Builder.reason] with `reason.orElse(null)`. */
            fun reason(reason: Optional<String>) = reason(reason.getOrNull())

            /**
             * Sets [Builder.reason] to an arbitrary JSON value.
             *
             * You should usually call [Builder.reason] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun reason(reason: JsonField<String>) = apply { this.reason = reason }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            /**
             * Returns an immutable instance of [McpApprovalResponse].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .id()
             * .approvalRequestId()
             * .approve()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): McpApprovalResponse =
                McpApprovalResponse(
                    checkRequired("id", id),
                    checkRequired("approvalRequestId", approvalRequestId),
                    checkRequired("approve", approve),
                    type,
                    agent,
                    reason,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
        fun validate(): McpApprovalResponse = apply {
            if (validated) {
                return@apply
            }

            id()
            approvalRequestId()
            approve()
            _type().let {
                if (it != JsonValue.from("mcp_approval_response")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
            agent().ifPresent { it.validate() }
            reason()
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: OpenAIInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (if (id.asKnown().isPresent) 1 else 0) +
                (if (approvalRequestId.asKnown().isPresent) 1 else 0) +
                (if (approve.asKnown().isPresent) 1 else 0) +
                type.let { if (it == JsonValue.from("mcp_approval_response")) 1 else 0 } +
                (agent.asKnown().getOrNull()?.validity() ?: 0) +
                (if (reason.asKnown().isPresent) 1 else 0)

        /** The agent that produced this item. */
        class Agent
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val agentName: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("agent_name")
                @ExcludeMissing
                agentName: JsonField<String> = JsonMissing.of()
            ) : this(agentName, mutableMapOf())

            /**
             * The canonical name of the agent that produced this item.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun agentName(): String = agentName.getRequired("agent_name")

            /**
             * Returns the raw JSON value of [agentName].
             *
             * Unlike [agentName], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("agent_name")
            @ExcludeMissing
            fun _agentName(): JsonField<String> = agentName

            @JsonAnySetter
            private fun putAdditionalProperty(key: String, value: JsonValue) {
                additionalProperties.put(key, value)
            }

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> =
                Collections.unmodifiableMap(additionalProperties)

            fun toBuilder() = Builder().from(this)

            companion object {

                /**
                 * Returns a mutable builder for constructing an instance of [Agent].
                 *
                 * The following fields are required:
                 * ```java
                 * .agentName()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Agent]. */
            class Builder internal constructor() {

                private var agentName: JsonField<String>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(agent: Agent) = apply {
                    agentName = agent.agentName
                    additionalProperties = agent.additionalProperties.toMutableMap()
                }

                /** The canonical name of the agent that produced this item. */
                fun agentName(agentName: String) = agentName(JsonField.of(agentName))

                /**
                 * Sets [Builder.agentName] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.agentName] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun agentName(agentName: JsonField<String>) = apply { this.agentName = agentName }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [Agent].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .agentName()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Agent =
                    Agent(
                        checkRequired("agentName", agentName),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
            fun validate(): Agent = apply {
                if (validated) {
                    return@apply
                }

                agentName()
                validated = true
            }

            fun isValid(): Boolean =
                try {
                    validate()
                    true
                } catch (e: OpenAIInvalidDataException) {
                    false
                }

            /**
             * Returns a score indicating how many valid values are contained in this object
             * recursively.
             *
             * Used for best match union deserialization.
             */
            @JvmSynthetic
            internal fun validity(): Int = (if (agentName.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Agent &&
                    agentName == other.agentName &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(agentName, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Agent{agentName=$agentName, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is McpApprovalResponse &&
                id == other.id &&
                approvalRequestId == other.approvalRequestId &&
                approve == other.approve &&
                type == other.type &&
                agent == other.agent &&
                reason == other.reason &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(id, approvalRequestId, approve, type, agent, reason, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "McpApprovalResponse{id=$id, approvalRequestId=$approvalRequestId, approve=$approve, type=$type, agent=$agent, reason=$reason, additionalProperties=$additionalProperties}"
    }

    /** An invocation of a tool on an MCP server. */
    class McpCall
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val arguments: JsonField<String>,
        private val name: JsonField<String>,
        private val serverLabel: JsonField<String>,
        private val type: JsonValue,
        private val agent: JsonField<Agent>,
        private val approvalRequestId: JsonField<String>,
        private val error: JsonField<String>,
        private val output: JsonField<String>,
        private val status: JsonField<Status>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("arguments")
            @ExcludeMissing
            arguments: JsonField<String> = JsonMissing.of(),
            @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            @JsonProperty("server_label")
            @ExcludeMissing
            serverLabel: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("agent") @ExcludeMissing agent: JsonField<Agent> = JsonMissing.of(),
            @JsonProperty("approval_request_id")
            @ExcludeMissing
            approvalRequestId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("error") @ExcludeMissing error: JsonField<String> = JsonMissing.of(),
            @JsonProperty("output") @ExcludeMissing output: JsonField<String> = JsonMissing.of(),
            @JsonProperty("status") @ExcludeMissing status: JsonField<Status> = JsonMissing.of(),
        ) : this(
            id,
            arguments,
            name,
            serverLabel,
            type,
            agent,
            approvalRequestId,
            error,
            output,
            status,
            mutableMapOf(),
        )

        /**
         * The unique ID of the tool call.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun id(): String = id.getRequired("id")

        /**
         * A JSON string of the arguments passed to the tool.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun arguments(): String = arguments.getRequired("arguments")

        /**
         * The name of the tool that was run.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun name(): String = name.getRequired("name")

        /**
         * The label of the MCP server running the tool.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun serverLabel(): String = serverLabel.getRequired("server_label")

        /**
         * The type of the item. Always `mcp_call`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("mcp_call")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * The agent that produced this item.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun agent(): Optional<Agent> = agent.getOptional("agent")

        /**
         * Unique identifier for the MCP tool call approval request. Include this value in a
         * subsequent `mcp_approval_response` input to approve or reject the corresponding tool
         * call.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun approvalRequestId(): Optional<String> =
            approvalRequestId.getOptional("approval_request_id")

        /**
         * The error from the tool call, if any.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun error(): Optional<String> = error.getOptional("error")

        /**
         * The output from the tool call.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun output(): Optional<String> = output.getOptional("output")

        /**
         * The status of the tool call. One of `in_progress`, `completed`, `incomplete`, `calling`,
         * or `failed`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun status(): Optional<Status> = status.getOptional("status")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [arguments].
         *
         * Unlike [arguments], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("arguments") @ExcludeMissing fun _arguments(): JsonField<String> = arguments

        /**
         * Returns the raw JSON value of [name].
         *
         * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

        /**
         * Returns the raw JSON value of [serverLabel].
         *
         * Unlike [serverLabel], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("server_label")
        @ExcludeMissing
        fun _serverLabel(): JsonField<String> = serverLabel

        /**
         * Returns the raw JSON value of [agent].
         *
         * Unlike [agent], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("agent") @ExcludeMissing fun _agent(): JsonField<Agent> = agent

        /**
         * Returns the raw JSON value of [approvalRequestId].
         *
         * Unlike [approvalRequestId], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("approval_request_id")
        @ExcludeMissing
        fun _approvalRequestId(): JsonField<String> = approvalRequestId

        /**
         * Returns the raw JSON value of [error].
         *
         * Unlike [error], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("error") @ExcludeMissing fun _error(): JsonField<String> = error

        /**
         * Returns the raw JSON value of [output].
         *
         * Unlike [output], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("output") @ExcludeMissing fun _output(): JsonField<String> = output

        /**
         * Returns the raw JSON value of [status].
         *
         * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<Status> = status

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [McpCall].
             *
             * The following fields are required:
             * ```java
             * .id()
             * .arguments()
             * .name()
             * .serverLabel()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [McpCall]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var arguments: JsonField<String>? = null
            private var name: JsonField<String>? = null
            private var serverLabel: JsonField<String>? = null
            private var type: JsonValue = JsonValue.from("mcp_call")
            private var agent: JsonField<Agent> = JsonMissing.of()
            private var approvalRequestId: JsonField<String> = JsonMissing.of()
            private var error: JsonField<String> = JsonMissing.of()
            private var output: JsonField<String> = JsonMissing.of()
            private var status: JsonField<Status> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(mcpCall: McpCall) = apply {
                id = mcpCall.id
                arguments = mcpCall.arguments
                name = mcpCall.name
                serverLabel = mcpCall.serverLabel
                type = mcpCall.type
                agent = mcpCall.agent
                approvalRequestId = mcpCall.approvalRequestId
                error = mcpCall.error
                output = mcpCall.output
                status = mcpCall.status
                additionalProperties = mcpCall.additionalProperties.toMutableMap()
            }

            /** The unique ID of the tool call. */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /** A JSON string of the arguments passed to the tool. */
            fun arguments(arguments: String) = arguments(JsonField.of(arguments))

            /**
             * Sets [Builder.arguments] to an arbitrary JSON value.
             *
             * You should usually call [Builder.arguments] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun arguments(arguments: JsonField<String>) = apply { this.arguments = arguments }

            /** The name of the tool that was run. */
            fun name(name: String) = name(JsonField.of(name))

            /**
             * Sets [Builder.name] to an arbitrary JSON value.
             *
             * You should usually call [Builder.name] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun name(name: JsonField<String>) = apply { this.name = name }

            /** The label of the MCP server running the tool. */
            fun serverLabel(serverLabel: String) = serverLabel(JsonField.of(serverLabel))

            /**
             * Sets [Builder.serverLabel] to an arbitrary JSON value.
             *
             * You should usually call [Builder.serverLabel] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun serverLabel(serverLabel: JsonField<String>) = apply {
                this.serverLabel = serverLabel
            }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("mcp_call")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

            /** The agent that produced this item. */
            fun agent(agent: Agent?) = agent(JsonField.ofNullable(agent))

            /** Alias for calling [Builder.agent] with `agent.orElse(null)`. */
            fun agent(agent: Optional<Agent>) = agent(agent.getOrNull())

            /**
             * Sets [Builder.agent] to an arbitrary JSON value.
             *
             * You should usually call [Builder.agent] with a well-typed [Agent] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun agent(agent: JsonField<Agent>) = apply { this.agent = agent }

            /**
             * Unique identifier for the MCP tool call approval request. Include this value in a
             * subsequent `mcp_approval_response` input to approve or reject the corresponding tool
             * call.
             */
            fun approvalRequestId(approvalRequestId: String?) =
                approvalRequestId(JsonField.ofNullable(approvalRequestId))

            /**
             * Alias for calling [Builder.approvalRequestId] with `approvalRequestId.orElse(null)`.
             */
            fun approvalRequestId(approvalRequestId: Optional<String>) =
                approvalRequestId(approvalRequestId.getOrNull())

            /**
             * Sets [Builder.approvalRequestId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.approvalRequestId] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun approvalRequestId(approvalRequestId: JsonField<String>) = apply {
                this.approvalRequestId = approvalRequestId
            }

            /** The error from the tool call, if any. */
            fun error(error: String?) = error(JsonField.ofNullable(error))

            /** Alias for calling [Builder.error] with `error.orElse(null)`. */
            fun error(error: Optional<String>) = error(error.getOrNull())

            /**
             * Sets [Builder.error] to an arbitrary JSON value.
             *
             * You should usually call [Builder.error] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun error(error: JsonField<String>) = apply { this.error = error }

            /** The output from the tool call. */
            fun output(output: String?) = output(JsonField.ofNullable(output))

            /** Alias for calling [Builder.output] with `output.orElse(null)`. */
            fun output(output: Optional<String>) = output(output.getOrNull())

            /**
             * Sets [Builder.output] to an arbitrary JSON value.
             *
             * You should usually call [Builder.output] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun output(output: JsonField<String>) = apply { this.output = output }

            /**
             * The status of the tool call. One of `in_progress`, `completed`, `incomplete`,
             * `calling`, or `failed`.
             */
            fun status(status: Status) = status(JsonField.of(status))

            /**
             * Sets [Builder.status] to an arbitrary JSON value.
             *
             * You should usually call [Builder.status] with a well-typed [Status] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun status(status: JsonField<Status>) = apply { this.status = status }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            /**
             * Returns an immutable instance of [McpCall].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .id()
             * .arguments()
             * .name()
             * .serverLabel()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): McpCall =
                McpCall(
                    checkRequired("id", id),
                    checkRequired("arguments", arguments),
                    checkRequired("name", name),
                    checkRequired("serverLabel", serverLabel),
                    type,
                    agent,
                    approvalRequestId,
                    error,
                    output,
                    status,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
        fun validate(): McpCall = apply {
            if (validated) {
                return@apply
            }

            id()
            arguments()
            name()
            serverLabel()
            _type().let {
                if (it != JsonValue.from("mcp_call")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
            agent().ifPresent { it.validate() }
            approvalRequestId()
            error()
            output()
            status().ifPresent { it.validate() }
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: OpenAIInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (if (id.asKnown().isPresent) 1 else 0) +
                (if (arguments.asKnown().isPresent) 1 else 0) +
                (if (name.asKnown().isPresent) 1 else 0) +
                (if (serverLabel.asKnown().isPresent) 1 else 0) +
                type.let { if (it == JsonValue.from("mcp_call")) 1 else 0 } +
                (agent.asKnown().getOrNull()?.validity() ?: 0) +
                (if (approvalRequestId.asKnown().isPresent) 1 else 0) +
                (if (error.asKnown().isPresent) 1 else 0) +
                (if (output.asKnown().isPresent) 1 else 0) +
                (status.asKnown().getOrNull()?.validity() ?: 0)

        /** The agent that produced this item. */
        class Agent
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val agentName: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("agent_name")
                @ExcludeMissing
                agentName: JsonField<String> = JsonMissing.of()
            ) : this(agentName, mutableMapOf())

            /**
             * The canonical name of the agent that produced this item.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun agentName(): String = agentName.getRequired("agent_name")

            /**
             * Returns the raw JSON value of [agentName].
             *
             * Unlike [agentName], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("agent_name")
            @ExcludeMissing
            fun _agentName(): JsonField<String> = agentName

            @JsonAnySetter
            private fun putAdditionalProperty(key: String, value: JsonValue) {
                additionalProperties.put(key, value)
            }

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> =
                Collections.unmodifiableMap(additionalProperties)

            fun toBuilder() = Builder().from(this)

            companion object {

                /**
                 * Returns a mutable builder for constructing an instance of [Agent].
                 *
                 * The following fields are required:
                 * ```java
                 * .agentName()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Agent]. */
            class Builder internal constructor() {

                private var agentName: JsonField<String>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(agent: Agent) = apply {
                    agentName = agent.agentName
                    additionalProperties = agent.additionalProperties.toMutableMap()
                }

                /** The canonical name of the agent that produced this item. */
                fun agentName(agentName: String) = agentName(JsonField.of(agentName))

                /**
                 * Sets [Builder.agentName] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.agentName] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun agentName(agentName: JsonField<String>) = apply { this.agentName = agentName }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [Agent].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .agentName()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Agent =
                    Agent(
                        checkRequired("agentName", agentName),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
            fun validate(): Agent = apply {
                if (validated) {
                    return@apply
                }

                agentName()
                validated = true
            }

            fun isValid(): Boolean =
                try {
                    validate()
                    true
                } catch (e: OpenAIInvalidDataException) {
                    false
                }

            /**
             * Returns a score indicating how many valid values are contained in this object
             * recursively.
             *
             * Used for best match union deserialization.
             */
            @JvmSynthetic
            internal fun validity(): Int = (if (agentName.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Agent &&
                    agentName == other.agentName &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(agentName, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Agent{agentName=$agentName, additionalProperties=$additionalProperties}"
        }

        /**
         * The status of the tool call. One of `in_progress`, `completed`, `incomplete`, `calling`,
         * or `failed`.
         */
        class Status @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

            /**
             * Returns this class instance's raw value.
             *
             * This is usually only useful if this instance was deserialized from data that doesn't
             * match any known member, and you want to know that value. For example, if the SDK is
             * on an older version than the API, then the API may respond with new members that the
             * SDK is unaware of.
             */
            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val IN_PROGRESS = of("in_progress")

                @JvmField val COMPLETED = of("completed")

                @JvmField val INCOMPLETE = of("incomplete")

                @JvmField val CALLING = of("calling")

                @JvmField val FAILED = of("failed")

                @JvmStatic fun of(value: String) = Status(JsonField.of(value))
            }

            /** An enum containing [Status]'s known values. */
            enum class Known {
                IN_PROGRESS,
                COMPLETED,
                INCOMPLETE,
                CALLING,
                FAILED,
            }

            /**
             * An enum containing [Status]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Status] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                IN_PROGRESS,
                COMPLETED,
                INCOMPLETE,
                CALLING,
                FAILED,
                /**
                 * An enum member indicating that [Status] was instantiated with an unknown value.
                 */
                _UNKNOWN,
            }

            /**
             * Returns an enum member corresponding to this class instance's value, or
             * [Value._UNKNOWN] if the class was instantiated with an unknown value.
             *
             * Use the [known] method instead if you're certain the value is always known or if you
             * want to throw for the unknown case.
             */
            fun value(): Value =
                when (this) {
                    IN_PROGRESS -> Value.IN_PROGRESS
                    COMPLETED -> Value.COMPLETED
                    INCOMPLETE -> Value.INCOMPLETE
                    CALLING -> Value.CALLING
                    FAILED -> Value.FAILED
                    else -> Value._UNKNOWN
                }

            /**
             * Returns an enum member corresponding to this class instance's value.
             *
             * Use the [value] method instead if you're uncertain the value is always known and
             * don't want to throw for the unknown case.
             *
             * @throws OpenAIInvalidDataException if this class instance's value is a not a known
             *   member.
             */
            fun known(): Known =
                when (this) {
                    IN_PROGRESS -> Known.IN_PROGRESS
                    COMPLETED -> Known.COMPLETED
                    INCOMPLETE -> Known.INCOMPLETE
                    CALLING -> Known.CALLING
                    FAILED -> Known.FAILED
                    else -> throw OpenAIInvalidDataException("Unknown Status: $value")
                }

            /**
             * Returns this class instance's primitive wire representation.
             *
             * This differs from the [toString] method because that method is primarily for
             * debugging and generally doesn't throw.
             *
             * @throws OpenAIInvalidDataException if this class instance's value does not have the
             *   expected primitive type.
             */
            fun asString(): String =
                _value().asString().orElseThrow {
                    OpenAIInvalidDataException("Value is not a String")
                }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
            fun validate(): Status = apply {
                if (validated) {
                    return@apply
                }

                known()
                validated = true
            }

            fun isValid(): Boolean =
                try {
                    validate()
                    true
                } catch (e: OpenAIInvalidDataException) {
                    false
                }

            /**
             * Returns a score indicating how many valid values are contained in this object
             * recursively.
             *
             * Used for best match union deserialization.
             */
            @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Status && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is McpCall &&
                id == other.id &&
                arguments == other.arguments &&
                name == other.name &&
                serverLabel == other.serverLabel &&
                type == other.type &&
                agent == other.agent &&
                approvalRequestId == other.approvalRequestId &&
                error == other.error &&
                output == other.output &&
                status == other.status &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                id,
                arguments,
                name,
                serverLabel,
                type,
                agent,
                approvalRequestId,
                error,
                output,
                status,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "McpCall{id=$id, arguments=$arguments, name=$name, serverLabel=$serverLabel, type=$type, agent=$agent, approvalRequestId=$approvalRequestId, error=$error, output=$output, status=$status, additionalProperties=$additionalProperties}"
    }
}
