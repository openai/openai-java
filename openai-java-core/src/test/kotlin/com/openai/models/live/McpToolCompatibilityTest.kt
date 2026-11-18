package com.openai.models.live

import com.openai.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class McpToolCompatibilityTest {
    @Test
    fun releasedFactoriesAndHandlersStillProduceJson() {
        val expected = JsonValue.from(mapOf("type" to "mcp"))
        val create =
            ResponsesDelegationConfig.builder()
                .model("test-model")
                .addToolMcp()
                .build()
                .tools()
                .get()
                .single()
        val update =
            ResponsesDelegationUpdateConfig.builder().addToolMcp().build().tools().get().single()

        assertThat(create.asMcp()).isEqualTo(expected)
        assertThat(update.mcp()).contains(expected)
        assertThat(
                create.match(
                    ResponsesDelegationConfig.Tool.Handler.builder<JsonValue>().onMcp { it }.build()
                )
            )
            .isEqualTo(expected)
        assertThat(
                update.match(
                    ResponsesDelegationUpdateConfig.Tool.Handler.builder<JsonValue>()
                        .onMcp { it }
                        .build()
                )
            )
            .isEqualTo(expected)
    }

    @Test
    fun createAndUpdateAcceptTheSameTypedPayload() {
        val mcp = McpTool.builder().serverLabel("lookup").build()
        val create = ResponsesDelegationConfig.Tool.ofMcp(mcp)
        val update = ResponsesDelegationUpdateConfig.Tool.ofMcp(mcp)

        assertThat(create.asTypedMcp()).isEqualTo(mcp)
        assertThat(update.typedMcp()).contains(mcp)
        assertThat(create.asMcp()).isEqualTo(JsonValue.from(mcp))
        assertThat(
                update.match(
                    ResponsesDelegationUpdateConfig.Tool.Handler.builder<McpTool>()
                        .onTypedMcp { it }
                        .build()
                )
            )
            .isEqualTo(mcp)
    }
}
