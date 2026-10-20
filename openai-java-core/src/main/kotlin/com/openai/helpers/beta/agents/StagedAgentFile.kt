package com.openai.helpers.beta.agents

import com.openai.models.beta.agents.environments.files.EnvironmentFile

/** A Files API upload and its staged beta Agents environment file. */
class StagedAgentFile
internal constructor(private val uploadedFileId: String, private val file: EnvironmentFile) {
    fun uploadedFileId(): String = uploadedFileId

    fun file(): EnvironmentFile = file
}
