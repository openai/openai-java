package com.openai.services.beta.agents

import com.openai.errors.OpenAIException

/** The hosted turn completed, but its answer could not be parsed to the configured Java type. */
class AgentOutputParseException
internal constructor(private val rawResult: AgentTurnResult, cause: Throwable) :
    OpenAIException("Could not parse the completed Agents output", cause) {
    fun rawResult(): AgentTurnResult = rawResult
}
