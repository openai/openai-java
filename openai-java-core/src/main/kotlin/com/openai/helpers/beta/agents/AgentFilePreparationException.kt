package com.openai.helpers.beta.agents

import com.openai.errors.OpenAIException
import java.util.Collections

/** Known uploads are retained on preparation/staging failure for explicit cleanup or reuse. */
class AgentFilePreparationException
internal constructor(uploadedFileIds: List<String>, cause: Throwable) :
    OpenAIException("Could not prepare the Agents environment files", cause) {
    private val uploadedFileIds = Collections.unmodifiableList(uploadedFileIds.toList())

    fun uploadedFileIds(): List<String> = uploadedFileIds
}
