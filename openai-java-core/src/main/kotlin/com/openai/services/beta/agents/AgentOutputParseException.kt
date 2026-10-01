package com.openai.services.beta.agents

import com.openai.errors.OpenAIException

/** The hosted turn completed, but its answer could not be parsed to the configured Java type. */
class AgentOutputParseException internal constructor(private val rawResult: AgentTurnResult) :
    OpenAIException("Could not parse the completed Agents output") {
    fun rawResult(): AgentTurnResult = rawResult
}
