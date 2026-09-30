// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SetupCommandParamTest {

    @Test
    fun create() {
        val setupCommandParam = SetupCommandParam.builder().command("command").cwd("cwd").build()

        assertThat(setupCommandParam.command()).isEqualTo("command")
        assertThat(setupCommandParam.cwd()).contains("cwd")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val setupCommandParam = SetupCommandParam.builder().command("command").cwd("cwd").build()

        val roundtrippedSetupCommandParam =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(setupCommandParam),
                jacksonTypeRef<SetupCommandParam>(),
            )

        assertThat(roundtrippedSetupCommandParam).isEqualTo(setupCommandParam)
    }
}
