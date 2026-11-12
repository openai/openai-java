package com.openai.helpers

import com.openai.core.JsonValue
import com.openai.models.live.ResponsesDelegationConfig
import java.io.File
import java.nio.file.Path
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.io.TempDir

class LiveMcpChoiceMigrationTest {
    @Test
    fun javaConsumerCanReadAndWriteOptionalNames(@TempDir directory: Path) {
        val classpath =
            listOf(
                    ResponsesDelegationConfig::class.java,
                    JsonValue::class.java,
                    Metadata::class.java,
                )
                .map { File(it.protectionDomain.codeSource.location.toURI()).path }
                .distinct()
                .joinToString(File.pathSeparator)
        compileJava(
            directory,
            "consumer",
            "McpConsumer",
            """
            import com.openai.models.live.ResponsesDelegationConfig.ToolChoice;
            import com.openai.models.live.ResponsesDelegationUpdateConfig;
            import java.util.Optional;

            public class McpConsumer {
                public static Optional<String> name() {
                    ToolChoice.LiveMcpToolChoiceParam.Builder mcp =
                        ToolChoice.LiveMcpToolChoiceParam.builder().serverLabel("calendar");
                    mcp.build();
                    mcp.name(Optional.empty()).build();
                    return ToolChoice.ofLiveMcpToolChoiceParam(mcp.name("list_events").build())
                        .asLiveMcpToolChoiceParam().name();
                }

                public static Optional<String> allowedName() {
                    return ResponsesDelegationUpdateConfig.ToolChoice.LiveAllowedToolsChoiceParam
                        .builder().addMcpTool("calendar").build().toolsOrThrow().get(0).asMcp().name();
                }
            }
            """
                .trimIndent(),
            classpath,
        )
    }
}
