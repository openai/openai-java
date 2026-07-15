// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses.inputitems

import com.openai.core.AutoPager
import com.openai.core.Page
import com.openai.core.checkRequired
import com.openai.models.beta.responses.BetaResponseApplyPatchToolCall
import com.openai.models.beta.responses.BetaResponseApplyPatchToolCallOutput
import com.openai.models.beta.responses.BetaResponseCodeInterpreterToolCall
import com.openai.models.beta.responses.BetaResponseCompactionItem
import com.openai.models.beta.responses.BetaResponseComputerToolCall
import com.openai.models.beta.responses.BetaResponseComputerToolCallOutputItem
import com.openai.models.beta.responses.BetaResponseCustomToolCallItem
import com.openai.models.beta.responses.BetaResponseCustomToolCallOutputItem
import com.openai.models.beta.responses.BetaResponseFileSearchToolCall
import com.openai.models.beta.responses.BetaResponseFunctionShellToolCall
import com.openai.models.beta.responses.BetaResponseFunctionShellToolCallOutput
import com.openai.models.beta.responses.BetaResponseFunctionToolCallItem
import com.openai.models.beta.responses.BetaResponseFunctionToolCallOutputItem
import com.openai.models.beta.responses.BetaResponseFunctionWebSearch
import com.openai.models.beta.responses.BetaResponseInputMessageItem
import com.openai.models.beta.responses.BetaResponseItem
import com.openai.models.beta.responses.BetaResponseOutputMessage
import com.openai.models.beta.responses.BetaResponseReasoningItem
import com.openai.models.beta.responses.BetaResponseToolSearchCall
import com.openai.models.beta.responses.BetaResponseToolSearchOutputItem
import com.openai.services.blocking.beta.responses.InputItemService
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** @see InputItemService.list */
class InputItemListPage
private constructor(
    private val service: InputItemService,
    private val params: InputItemListParams,
    private val response: BetaResponseItemList,
) : Page<BetaResponseItem> {

    /**
     * Delegates to [BetaResponseItemList], but gracefully handles missing data.
     *
     * @see BetaResponseItemList.data
     */
    fun data(): List<BetaResponseItem> =
        response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [BetaResponseItemList], but gracefully handles missing data.
     *
     * @see BetaResponseItemList.hasMore
     */
    fun hasMore(): Optional<Boolean> = response._hasMore().getOptional("has_more")

    override fun items(): List<BetaResponseItem> = data()

    override fun hasNextPage(): Boolean = items().isNotEmpty()

    fun nextPageParams(): InputItemListParams =
        params
            .toBuilder()
            .after(
                items()
                    .last()
                    .accept(
                        object : BetaResponseItem.Visitor<Optional<String>> {
                            override fun visitBetaResponseInputMessageItem(
                                betaResponseInputMessageItem: BetaResponseInputMessageItem
                            ): Optional<String> =
                                betaResponseInputMessageItem._id().getOptional("id")

                            override fun visitBetaResponseOutputMessage(
                                betaResponseOutputMessage: BetaResponseOutputMessage
                            ): Optional<String> = betaResponseOutputMessage._id().getOptional("id")

                            override fun visitFileSearchCall(
                                fileSearchCall: BetaResponseFileSearchToolCall
                            ): Optional<String> = fileSearchCall._id().getOptional("id")

                            override fun visitComputerCall(
                                computerCall: BetaResponseComputerToolCall
                            ): Optional<String> = computerCall._id().getOptional("id")

                            override fun visitComputerCallOutput(
                                computerCallOutput: BetaResponseComputerToolCallOutputItem
                            ): Optional<String> = computerCallOutput._id().getOptional("id")

                            override fun visitWebSearchCall(
                                webSearchCall: BetaResponseFunctionWebSearch
                            ): Optional<String> = webSearchCall._id().getOptional("id")

                            override fun visitFunctionCall(
                                functionCall: BetaResponseFunctionToolCallItem
                            ): Optional<String> = functionCall._id().getOptional("id")

                            override fun visitFunctionCallOutput(
                                functionCallOutput: BetaResponseFunctionToolCallOutputItem
                            ): Optional<String> = functionCallOutput._id().getOptional("id")

                            override fun visitAgentMessage(
                                agentMessage: BetaResponseItem.AgentMessage
                            ): Optional<String> = agentMessage._id().getOptional("id")

                            override fun visitMultiAgentCall(
                                multiAgentCall: BetaResponseItem.MultiAgentCall
                            ): Optional<String> = multiAgentCall._id().getOptional("id")

                            override fun visitMultiAgentCallOutput(
                                multiAgentCallOutput: BetaResponseItem.MultiAgentCallOutput
                            ): Optional<String> = multiAgentCallOutput._id().getOptional("id")

                            override fun visitToolSearchCall(
                                toolSearchCall: BetaResponseToolSearchCall
                            ): Optional<String> = toolSearchCall._id().getOptional("id")

                            override fun visitToolSearchOutput(
                                toolSearchOutput: BetaResponseToolSearchOutputItem
                            ): Optional<String> = toolSearchOutput._id().getOptional("id")

                            override fun visitAdditionalTools(
                                additionalTools: BetaResponseItem.AdditionalTools
                            ): Optional<String> = additionalTools._id().getOptional("id")

                            override fun visitReasoning(
                                reasoning: BetaResponseReasoningItem
                            ): Optional<String> = reasoning._id().getOptional("id")

                            override fun visitProgram(
                                program: BetaResponseItem.Program
                            ): Optional<String> = program._id().getOptional("id")

                            override fun visitProgramOutput(
                                programOutput: BetaResponseItem.ProgramOutput
                            ): Optional<String> = programOutput._id().getOptional("id")

                            override fun visitCompaction(
                                compaction: BetaResponseCompactionItem
                            ): Optional<String> = compaction._id().getOptional("id")

                            override fun visitImageGenerationCall(
                                imageGenerationCall: BetaResponseItem.ImageGenerationCall
                            ): Optional<String> = imageGenerationCall._id().getOptional("id")

                            override fun visitCodeInterpreterCall(
                                codeInterpreterCall: BetaResponseCodeInterpreterToolCall
                            ): Optional<String> = codeInterpreterCall._id().getOptional("id")

                            override fun visitLocalShellCall(
                                localShellCall: BetaResponseItem.LocalShellCall
                            ): Optional<String> = localShellCall._id().getOptional("id")

                            override fun visitLocalShellCallOutput(
                                localShellCallOutput: BetaResponseItem.LocalShellCallOutput
                            ): Optional<String> = localShellCallOutput._id().getOptional("id")

                            override fun visitShellCall(
                                shellCall: BetaResponseFunctionShellToolCall
                            ): Optional<String> = shellCall._id().getOptional("id")

                            override fun visitShellCallOutput(
                                shellCallOutput: BetaResponseFunctionShellToolCallOutput
                            ): Optional<String> = shellCallOutput._id().getOptional("id")

                            override fun visitApplyPatchCall(
                                applyPatchCall: BetaResponseApplyPatchToolCall
                            ): Optional<String> = applyPatchCall._id().getOptional("id")

                            override fun visitApplyPatchCallOutput(
                                applyPatchCallOutput: BetaResponseApplyPatchToolCallOutput
                            ): Optional<String> = applyPatchCallOutput._id().getOptional("id")

                            override fun visitMcpListTools(
                                mcpListTools: BetaResponseItem.McpListTools
                            ): Optional<String> = mcpListTools._id().getOptional("id")

                            override fun visitMcpApprovalRequest(
                                mcpApprovalRequest: BetaResponseItem.McpApprovalRequest
                            ): Optional<String> = mcpApprovalRequest._id().getOptional("id")

                            override fun visitMcpApprovalResponse(
                                mcpApprovalResponse: BetaResponseItem.McpApprovalResponse
                            ): Optional<String> = mcpApprovalResponse._id().getOptional("id")

                            override fun visitMcpCall(
                                mcpCall: BetaResponseItem.McpCall
                            ): Optional<String> = mcpCall._id().getOptional("id")

                            override fun visitCustomToolCall(
                                customToolCall: BetaResponseCustomToolCallItem
                            ): Optional<String> = customToolCall._id().getOptional("id")

                            override fun visitCustomToolCallOutput(
                                customToolCallOutput: BetaResponseCustomToolCallOutputItem
                            ): Optional<String> = customToolCallOutput._id().getOptional("id")
                        }
                    )
            )
            .build()

    override fun nextPage(): InputItemListPage = service.list(nextPageParams())

    fun autoPager(): AutoPager<BetaResponseItem> = AutoPager.from(this)

    /** The parameters that were used to request this page. */
    fun params(): InputItemListParams = params

    /** The response that this page was parsed from. */
    fun response(): BetaResponseItemList = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [InputItemListPage].
         *
         * The following fields are required:
         * ```java
         * .service()
         * .params()
         * .response()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [InputItemListPage]. */
    class Builder internal constructor() {

        private var service: InputItemService? = null
        private var params: InputItemListParams? = null
        private var response: BetaResponseItemList? = null

        @JvmSynthetic
        internal fun from(inputItemListPage: InputItemListPage) = apply {
            service = inputItemListPage.service
            params = inputItemListPage.params
            response = inputItemListPage.response
        }

        fun service(service: InputItemService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: InputItemListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: BetaResponseItemList) = apply { this.response = response }

        /**
         * Returns an immutable instance of [InputItemListPage].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .service()
         * .params()
         * .response()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): InputItemListPage =
            InputItemListPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is InputItemListPage &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() =
        "InputItemListPage{service=$service, params=$params, response=$response}"
}
