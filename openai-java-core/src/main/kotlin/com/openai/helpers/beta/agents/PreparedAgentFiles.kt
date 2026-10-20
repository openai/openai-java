package com.openai.helpers.beta.agents

import com.openai.models.beta.agents.HostedEnvironmentFileParam
import java.util.Collections

/** Uploaded inputs for a beta Agents hosted environment; cleanup remains explicit. */
class PreparedAgentFiles internal constructor(files: List<HostedEnvironmentFileParam>) {
    private val files = Collections.unmodifiableList(files.toList())

    fun files(): List<HostedEnvironmentFileParam> = files

    fun uploadedFileIds(): List<String> =
        Collections.unmodifiableList(files.map { it.asFileId().fileId() })
}
