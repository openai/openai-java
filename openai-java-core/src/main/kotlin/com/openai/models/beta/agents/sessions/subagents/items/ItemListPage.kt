// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.sessions.subagents.items

import com.openai.core.AutoPager
import com.openai.core.Page
import com.openai.core.checkRequired
import com.openai.models.beta.agents.AgentCloseSubagentCallItem
import com.openai.models.beta.agents.AgentCommandExecutionItem
import com.openai.models.beta.agents.AgentCreateSubagentCallItem
import com.openai.models.beta.agents.AgentFunctionCallItem
import com.openai.models.beta.agents.AgentInterruptSubagentCallItem
import com.openai.models.beta.agents.AgentMcpCallItem
import com.openai.models.beta.agents.AgentReasoningItem
import com.openai.models.beta.agents.AgentResumeSubagentCallItem
import com.openai.models.beta.agents.AgentSendSubagentInputCallItem
import com.openai.models.beta.agents.AgentSessionItem
import com.openai.models.beta.agents.AgentSessionMessage
import com.openai.models.beta.agents.AgentWaitForSubagentsCallItem
import com.openai.models.beta.agents.AgentWebSearchCallItem
import com.openai.services.blocking.beta.agents.sessions.subagents.ItemService
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** @see ItemService.list */
class ItemListPage
private constructor(
    private val service: ItemService,
    private val params: ItemListParams,
    private val response: ItemListPageResponse,
) : Page<AgentSessionItem> {

    /**
     * Delegates to [ItemListPageResponse], but gracefully handles missing data.
     *
     * @see ItemListPageResponse.data
     */
    fun data(): List<AgentSessionItem> =
        response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [ItemListPageResponse], but gracefully handles missing data.
     *
     * @see ItemListPageResponse.hasMore
     */
    fun hasMore(): Optional<Boolean> = response._hasMore().getOptional("has_more")

    override fun items(): List<AgentSessionItem> = data()

    override fun hasNextPage(): Boolean = items().isNotEmpty()

    fun nextPageParams(): ItemListParams =
        params
            .toBuilder()
            .after(
                items()
                    .last()
                    .accept(
                        object : AgentSessionItem.Visitor<Optional<String>> {
                            override fun visitMessage(
                                message: AgentSessionMessage
                            ): Optional<String> = message._id().getOptional("id")

                            override fun visitReasoning(
                                reasoning: AgentReasoningItem
                            ): Optional<String> = reasoning._id().getOptional("id")

                            override fun visitFunctionCall(
                                functionCall: AgentFunctionCallItem
                            ): Optional<String> = functionCall._id().getOptional("id")

                            override fun visitFunctionCallOutput(
                                functionCallOutput: AgentSessionItem.FunctionCallOutput
                            ): Optional<String> = functionCallOutput._id().getOptional("id")

                            override fun visitAgentMessage(
                                agentMessage: AgentSessionItem.AgentMessage
                            ): Optional<String> = agentMessage._id().getOptional("id")

                            override fun visitMcpCall(mcpCall: AgentMcpCallItem): Optional<String> =
                                mcpCall._id().getOptional("id")

                            override fun visitWebSearchCall(
                                webSearchCall: AgentWebSearchCallItem
                            ): Optional<String> = webSearchCall._id().getOptional("id")

                            override fun visitCommandExecution(
                                commandExecution: AgentCommandExecutionItem
                            ): Optional<String> = commandExecution._id().getOptional("id")

                            override fun visitCreateSubagentCall(
                                createSubagentCall: AgentCreateSubagentCallItem
                            ): Optional<String> = createSubagentCall._id().getOptional("id")

                            override fun visitSendSubagentInputCall(
                                sendSubagentInputCall: AgentSendSubagentInputCallItem
                            ): Optional<String> = sendSubagentInputCall._id().getOptional("id")

                            override fun visitResumeSubagentCall(
                                resumeSubagentCall: AgentResumeSubagentCallItem
                            ): Optional<String> = resumeSubagentCall._id().getOptional("id")

                            override fun visitWaitForSubagentsCall(
                                waitForSubagentsCall: AgentWaitForSubagentsCallItem
                            ): Optional<String> = waitForSubagentsCall._id().getOptional("id")

                            override fun visitInterruptSubagentCall(
                                interruptSubagentCall: AgentInterruptSubagentCallItem
                            ): Optional<String> = interruptSubagentCall._id().getOptional("id")

                            override fun visitCloseSubagentCall(
                                closeSubagentCall: AgentCloseSubagentCallItem
                            ): Optional<String> = closeSubagentCall._id().getOptional("id")
                        }
                    )
            )
            .build()

    override fun nextPage(): ItemListPage = service.list(nextPageParams())

    fun autoPager(): AutoPager<AgentSessionItem> = AutoPager.from(this)

    /** The parameters that were used to request this page. */
    fun params(): ItemListParams = params

    /** The response that this page was parsed from. */
    fun response(): ItemListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ItemListPage].
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

    /** A builder for [ItemListPage]. */
    class Builder internal constructor() {

        private var service: ItemService? = null
        private var params: ItemListParams? = null
        private var response: ItemListPageResponse? = null

        @JvmSynthetic
        internal fun from(itemListPage: ItemListPage) = apply {
            service = itemListPage.service
            params = itemListPage.params
            response = itemListPage.response
        }

        fun service(service: ItemService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: ItemListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: ItemListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [ItemListPage].
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
        fun build(): ItemListPage =
            ItemListPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ItemListPage &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() = "ItemListPage{service=$service, params=$params, response=$response}"
}
