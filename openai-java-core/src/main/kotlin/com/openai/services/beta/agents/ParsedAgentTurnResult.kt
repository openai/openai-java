package com.openai.services.beta.agents

/** A typed beta Agents answer alongside its original completed turn and messages. */
class ParsedAgentTurnResult<T : Any>
internal constructor(private val rawResult: AgentTurnResult, private val outputParsed: T) {
    fun outputParsed(): T = outputParsed

    fun rawResult(): AgentTurnResult = rawResult

    fun outputText(): String = rawResult.outputText()

    fun messages() = rawResult.messages()

    fun turn() = rawResult.turn()

    fun sessionId(): String = rawResult.sessionId()

    fun turnId(): String = rawResult.turnId()
}
