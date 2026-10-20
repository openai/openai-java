package com.openai.models.beta.agents

/** Pure conveniences for already received session messages. */
object AgentSessionMessages {
    /** Concatenates output_text blocks in order, without phase filtering or network requests. */
    @JvmStatic
    fun outputText(message: AgentSessionMessage): String =
        message.content().filter { it.isOutputText() }.joinToString("") { it.asOutputText().text() }
}
