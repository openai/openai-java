// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class BetaToolTest {

    @Test
    fun ofFunction() {
        val function =
            BetaFunctionTool.builder()
                .name("name")
                .parameters(
                    BetaFunctionTool.Parameters.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .strict(true)
                .addAllowedCaller(BetaFunctionTool.AllowedCaller.DIRECT)
                .deferLoading(true)
                .description("description")
                .outputSchema(
                    BetaFunctionTool.OutputSchema.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .build()

        val betaTool = BetaTool.ofFunction(function)

        assertThat(betaTool.function()).contains(function)
        assertThat(betaTool.fileSearch()).isEmpty
        assertThat(betaTool.computer()).isEmpty
        assertThat(betaTool.computerUsePreview()).isEmpty
        assertThat(betaTool.webSearch()).isEmpty
        assertThat(betaTool.mcp()).isEmpty
        assertThat(betaTool.codeInterpreter()).isEmpty
        assertThat(betaTool.programmaticToolCalling()).isEmpty
        assertThat(betaTool.imageGeneration()).isEmpty
        assertThat(betaTool.localShell()).isEmpty
        assertThat(betaTool.shell()).isEmpty
        assertThat(betaTool.custom()).isEmpty
        assertThat(betaTool.namespace()).isEmpty
        assertThat(betaTool.toolSearch()).isEmpty
        assertThat(betaTool.webSearchPreview()).isEmpty
        assertThat(betaTool.applyPatch()).isEmpty
    }

    @Test
    fun ofFunctionRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaTool =
            BetaTool.ofFunction(
                BetaFunctionTool.builder()
                    .name("name")
                    .parameters(
                        BetaFunctionTool.Parameters.builder()
                            .putAdditionalProperty("foo", JsonValue.from("bar"))
                            .build()
                    )
                    .strict(true)
                    .addAllowedCaller(BetaFunctionTool.AllowedCaller.DIRECT)
                    .deferLoading(true)
                    .description("description")
                    .outputSchema(
                        BetaFunctionTool.OutputSchema.builder()
                            .putAdditionalProperty("foo", JsonValue.from("bar"))
                            .build()
                    )
                    .build()
            )

        val roundtrippedBetaTool =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaTool),
                jacksonTypeRef<BetaTool>(),
            )

        assertThat(roundtrippedBetaTool).isEqualTo(betaTool)
    }

    @Test
    fun ofFileSearch() {
        val fileSearch =
            BetaFileSearchTool.builder()
                .addVectorStoreId("string")
                .filters(
                    BetaFileSearchTool.Filters.ComparisonFilter.builder()
                        .key("key")
                        .type(BetaFileSearchTool.Filters.ComparisonFilter.Type.EQ)
                        .value("string")
                        .build()
                )
                .maxNumResults(0L)
                .rankingOptions(
                    BetaFileSearchTool.RankingOptions.builder()
                        .hybridSearch(
                            BetaFileSearchTool.RankingOptions.HybridSearch.builder()
                                .embeddingWeight(0.0)
                                .textWeight(0.0)
                                .build()
                        )
                        .ranker(BetaFileSearchTool.RankingOptions.Ranker.AUTO)
                        .scoreThreshold(0.0)
                        .build()
                )
                .build()

        val betaTool = BetaTool.ofFileSearch(fileSearch)

        assertThat(betaTool.function()).isEmpty
        assertThat(betaTool.fileSearch()).contains(fileSearch)
        assertThat(betaTool.computer()).isEmpty
        assertThat(betaTool.computerUsePreview()).isEmpty
        assertThat(betaTool.webSearch()).isEmpty
        assertThat(betaTool.mcp()).isEmpty
        assertThat(betaTool.codeInterpreter()).isEmpty
        assertThat(betaTool.programmaticToolCalling()).isEmpty
        assertThat(betaTool.imageGeneration()).isEmpty
        assertThat(betaTool.localShell()).isEmpty
        assertThat(betaTool.shell()).isEmpty
        assertThat(betaTool.custom()).isEmpty
        assertThat(betaTool.namespace()).isEmpty
        assertThat(betaTool.toolSearch()).isEmpty
        assertThat(betaTool.webSearchPreview()).isEmpty
        assertThat(betaTool.applyPatch()).isEmpty
    }

    @Test
    fun ofFileSearchRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaTool =
            BetaTool.ofFileSearch(
                BetaFileSearchTool.builder()
                    .addVectorStoreId("string")
                    .filters(
                        BetaFileSearchTool.Filters.ComparisonFilter.builder()
                            .key("key")
                            .type(BetaFileSearchTool.Filters.ComparisonFilter.Type.EQ)
                            .value("string")
                            .build()
                    )
                    .maxNumResults(0L)
                    .rankingOptions(
                        BetaFileSearchTool.RankingOptions.builder()
                            .hybridSearch(
                                BetaFileSearchTool.RankingOptions.HybridSearch.builder()
                                    .embeddingWeight(0.0)
                                    .textWeight(0.0)
                                    .build()
                            )
                            .ranker(BetaFileSearchTool.RankingOptions.Ranker.AUTO)
                            .scoreThreshold(0.0)
                            .build()
                    )
                    .build()
            )

        val roundtrippedBetaTool =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaTool),
                jacksonTypeRef<BetaTool>(),
            )

        assertThat(roundtrippedBetaTool).isEqualTo(betaTool)
    }

    @Test
    fun ofComputer() {
        val computer = BetaComputerTool.builder().build()

        val betaTool = BetaTool.ofComputer(computer)

        assertThat(betaTool.function()).isEmpty
        assertThat(betaTool.fileSearch()).isEmpty
        assertThat(betaTool.computer()).contains(computer)
        assertThat(betaTool.computerUsePreview()).isEmpty
        assertThat(betaTool.webSearch()).isEmpty
        assertThat(betaTool.mcp()).isEmpty
        assertThat(betaTool.codeInterpreter()).isEmpty
        assertThat(betaTool.programmaticToolCalling()).isEmpty
        assertThat(betaTool.imageGeneration()).isEmpty
        assertThat(betaTool.localShell()).isEmpty
        assertThat(betaTool.shell()).isEmpty
        assertThat(betaTool.custom()).isEmpty
        assertThat(betaTool.namespace()).isEmpty
        assertThat(betaTool.toolSearch()).isEmpty
        assertThat(betaTool.webSearchPreview()).isEmpty
        assertThat(betaTool.applyPatch()).isEmpty
    }

    @Test
    fun ofComputerRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaTool = BetaTool.ofComputer(BetaComputerTool.builder().build())

        val roundtrippedBetaTool =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaTool),
                jacksonTypeRef<BetaTool>(),
            )

        assertThat(roundtrippedBetaTool).isEqualTo(betaTool)
    }

    @Test
    fun ofComputerUsePreview() {
        val computerUsePreview =
            BetaComputerUsePreviewTool.builder()
                .displayHeight(0L)
                .displayWidth(0L)
                .environment(BetaComputerUsePreviewTool.Environment.WINDOWS)
                .build()

        val betaTool = BetaTool.ofComputerUsePreview(computerUsePreview)

        assertThat(betaTool.function()).isEmpty
        assertThat(betaTool.fileSearch()).isEmpty
        assertThat(betaTool.computer()).isEmpty
        assertThat(betaTool.computerUsePreview()).contains(computerUsePreview)
        assertThat(betaTool.webSearch()).isEmpty
        assertThat(betaTool.mcp()).isEmpty
        assertThat(betaTool.codeInterpreter()).isEmpty
        assertThat(betaTool.programmaticToolCalling()).isEmpty
        assertThat(betaTool.imageGeneration()).isEmpty
        assertThat(betaTool.localShell()).isEmpty
        assertThat(betaTool.shell()).isEmpty
        assertThat(betaTool.custom()).isEmpty
        assertThat(betaTool.namespace()).isEmpty
        assertThat(betaTool.toolSearch()).isEmpty
        assertThat(betaTool.webSearchPreview()).isEmpty
        assertThat(betaTool.applyPatch()).isEmpty
    }

    @Test
    fun ofComputerUsePreviewRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaTool =
            BetaTool.ofComputerUsePreview(
                BetaComputerUsePreviewTool.builder()
                    .displayHeight(0L)
                    .displayWidth(0L)
                    .environment(BetaComputerUsePreviewTool.Environment.WINDOWS)
                    .build()
            )

        val roundtrippedBetaTool =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaTool),
                jacksonTypeRef<BetaTool>(),
            )

        assertThat(roundtrippedBetaTool).isEqualTo(betaTool)
    }

    @Test
    fun ofWebSearch() {
        val webSearch =
            BetaWebSearchTool.builder()
                .type(BetaWebSearchTool.Type.WEB_SEARCH)
                .filters(BetaWebSearchTool.Filters.builder().addAllowedDomain("string").build())
                .searchContextSize(BetaWebSearchTool.SearchContextSize.LOW)
                .userLocation(
                    BetaWebSearchTool.UserLocation.builder()
                        .city("city")
                        .country("country")
                        .region("region")
                        .timezone("timezone")
                        .type(BetaWebSearchTool.UserLocation.Type.APPROXIMATE)
                        .build()
                )
                .build()

        val betaTool = BetaTool.ofWebSearch(webSearch)

        assertThat(betaTool.function()).isEmpty
        assertThat(betaTool.fileSearch()).isEmpty
        assertThat(betaTool.computer()).isEmpty
        assertThat(betaTool.computerUsePreview()).isEmpty
        assertThat(betaTool.webSearch()).contains(webSearch)
        assertThat(betaTool.mcp()).isEmpty
        assertThat(betaTool.codeInterpreter()).isEmpty
        assertThat(betaTool.programmaticToolCalling()).isEmpty
        assertThat(betaTool.imageGeneration()).isEmpty
        assertThat(betaTool.localShell()).isEmpty
        assertThat(betaTool.shell()).isEmpty
        assertThat(betaTool.custom()).isEmpty
        assertThat(betaTool.namespace()).isEmpty
        assertThat(betaTool.toolSearch()).isEmpty
        assertThat(betaTool.webSearchPreview()).isEmpty
        assertThat(betaTool.applyPatch()).isEmpty
    }

    @Test
    fun ofWebSearchRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaTool =
            BetaTool.ofWebSearch(
                BetaWebSearchTool.builder()
                    .type(BetaWebSearchTool.Type.WEB_SEARCH)
                    .filters(BetaWebSearchTool.Filters.builder().addAllowedDomain("string").build())
                    .searchContextSize(BetaWebSearchTool.SearchContextSize.LOW)
                    .userLocation(
                        BetaWebSearchTool.UserLocation.builder()
                            .city("city")
                            .country("country")
                            .region("region")
                            .timezone("timezone")
                            .type(BetaWebSearchTool.UserLocation.Type.APPROXIMATE)
                            .build()
                    )
                    .build()
            )

        val roundtrippedBetaTool =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaTool),
                jacksonTypeRef<BetaTool>(),
            )

        assertThat(roundtrippedBetaTool).isEqualTo(betaTool)
    }

    @Test
    fun ofMcp() {
        val mcp =
            BetaTool.Mcp.builder()
                .serverLabel("server_label")
                .addAllowedCaller(BetaTool.Mcp.AllowedCaller.DIRECT)
                .allowedToolsOfMcp(listOf("string"))
                .authorization("authorization")
                .connectorId(BetaTool.Mcp.ConnectorId.CONNECTOR_DROPBOX)
                .deferLoading(true)
                .headers(
                    BetaTool.Mcp.Headers.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .requireApproval(BetaTool.Mcp.RequireApproval.McpToolApprovalSetting.ALWAYS)
                .serverDescription("server_description")
                .serverUrl("https://example.com")
                .tunnelId("tunnel_210b9798ad53ecc4y69z31e1071cx03v")
                .build()

        val betaTool = BetaTool.ofMcp(mcp)

        assertThat(betaTool.function()).isEmpty
        assertThat(betaTool.fileSearch()).isEmpty
        assertThat(betaTool.computer()).isEmpty
        assertThat(betaTool.computerUsePreview()).isEmpty
        assertThat(betaTool.webSearch()).isEmpty
        assertThat(betaTool.mcp()).contains(mcp)
        assertThat(betaTool.codeInterpreter()).isEmpty
        assertThat(betaTool.programmaticToolCalling()).isEmpty
        assertThat(betaTool.imageGeneration()).isEmpty
        assertThat(betaTool.localShell()).isEmpty
        assertThat(betaTool.shell()).isEmpty
        assertThat(betaTool.custom()).isEmpty
        assertThat(betaTool.namespace()).isEmpty
        assertThat(betaTool.toolSearch()).isEmpty
        assertThat(betaTool.webSearchPreview()).isEmpty
        assertThat(betaTool.applyPatch()).isEmpty
    }

    @Test
    fun ofMcpRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaTool =
            BetaTool.ofMcp(
                BetaTool.Mcp.builder()
                    .serverLabel("server_label")
                    .addAllowedCaller(BetaTool.Mcp.AllowedCaller.DIRECT)
                    .allowedToolsOfMcp(listOf("string"))
                    .authorization("authorization")
                    .connectorId(BetaTool.Mcp.ConnectorId.CONNECTOR_DROPBOX)
                    .deferLoading(true)
                    .headers(
                        BetaTool.Mcp.Headers.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .requireApproval(BetaTool.Mcp.RequireApproval.McpToolApprovalSetting.ALWAYS)
                    .serverDescription("server_description")
                    .serverUrl("https://example.com")
                    .tunnelId("tunnel_210b9798ad53ecc4y69z31e1071cx03v")
                    .build()
            )

        val roundtrippedBetaTool =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaTool),
                jacksonTypeRef<BetaTool>(),
            )

        assertThat(roundtrippedBetaTool).isEqualTo(betaTool)
    }

    @Test
    fun ofCodeInterpreter() {
        val codeInterpreter =
            BetaTool.CodeInterpreter.builder()
                .container("string")
                .addAllowedCaller(BetaTool.CodeInterpreter.AllowedCaller.DIRECT)
                .build()

        val betaTool = BetaTool.ofCodeInterpreter(codeInterpreter)

        assertThat(betaTool.function()).isEmpty
        assertThat(betaTool.fileSearch()).isEmpty
        assertThat(betaTool.computer()).isEmpty
        assertThat(betaTool.computerUsePreview()).isEmpty
        assertThat(betaTool.webSearch()).isEmpty
        assertThat(betaTool.mcp()).isEmpty
        assertThat(betaTool.codeInterpreter()).contains(codeInterpreter)
        assertThat(betaTool.programmaticToolCalling()).isEmpty
        assertThat(betaTool.imageGeneration()).isEmpty
        assertThat(betaTool.localShell()).isEmpty
        assertThat(betaTool.shell()).isEmpty
        assertThat(betaTool.custom()).isEmpty
        assertThat(betaTool.namespace()).isEmpty
        assertThat(betaTool.toolSearch()).isEmpty
        assertThat(betaTool.webSearchPreview()).isEmpty
        assertThat(betaTool.applyPatch()).isEmpty
    }

    @Test
    fun ofCodeInterpreterRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaTool =
            BetaTool.ofCodeInterpreter(
                BetaTool.CodeInterpreter.builder()
                    .container("string")
                    .addAllowedCaller(BetaTool.CodeInterpreter.AllowedCaller.DIRECT)
                    .build()
            )

        val roundtrippedBetaTool =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaTool),
                jacksonTypeRef<BetaTool>(),
            )

        assertThat(roundtrippedBetaTool).isEqualTo(betaTool)
    }

    @Test
    fun ofProgrammaticToolCalling() {
        val betaTool = BetaTool.ofProgrammaticToolCalling()

        assertThat(betaTool.function()).isEmpty
        assertThat(betaTool.fileSearch()).isEmpty
        assertThat(betaTool.computer()).isEmpty
        assertThat(betaTool.computerUsePreview()).isEmpty
        assertThat(betaTool.webSearch()).isEmpty
        assertThat(betaTool.mcp()).isEmpty
        assertThat(betaTool.codeInterpreter()).isEmpty
        assertThat(betaTool.programmaticToolCalling())
            .contains(JsonValue.from(mapOf("type" to "programmatic_tool_calling")))
        assertThat(betaTool.imageGeneration()).isEmpty
        assertThat(betaTool.localShell()).isEmpty
        assertThat(betaTool.shell()).isEmpty
        assertThat(betaTool.custom()).isEmpty
        assertThat(betaTool.namespace()).isEmpty
        assertThat(betaTool.toolSearch()).isEmpty
        assertThat(betaTool.webSearchPreview()).isEmpty
        assertThat(betaTool.applyPatch()).isEmpty
    }

    @Test
    fun ofProgrammaticToolCallingRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaTool = BetaTool.ofProgrammaticToolCalling()

        val roundtrippedBetaTool =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaTool),
                jacksonTypeRef<BetaTool>(),
            )

        assertThat(roundtrippedBetaTool).isEqualTo(betaTool)
    }

    @Test
    fun ofImageGeneration() {
        val imageGeneration =
            BetaTool.ImageGeneration.builder()
                .action(BetaTool.ImageGeneration.Action.GENERATE)
                .background(BetaTool.ImageGeneration.Background.TRANSPARENT)
                .inputFidelity(BetaTool.ImageGeneration.InputFidelity.HIGH)
                .inputImageMask(
                    BetaTool.ImageGeneration.InputImageMask.builder()
                        .fileId("file_id")
                        .imageUrl("image_url")
                        .build()
                )
                .model(BetaTool.ImageGeneration.Model.GPT_IMAGE_1)
                .moderation(BetaTool.ImageGeneration.Moderation.AUTO)
                .outputCompression(0L)
                .outputFormat(BetaTool.ImageGeneration.OutputFormat.PNG)
                .partialImages(0L)
                .quality(BetaTool.ImageGeneration.Quality.LOW)
                .size(BetaTool.ImageGeneration.Size._1024X1024)
                .build()

        val betaTool = BetaTool.ofImageGeneration(imageGeneration)

        assertThat(betaTool.function()).isEmpty
        assertThat(betaTool.fileSearch()).isEmpty
        assertThat(betaTool.computer()).isEmpty
        assertThat(betaTool.computerUsePreview()).isEmpty
        assertThat(betaTool.webSearch()).isEmpty
        assertThat(betaTool.mcp()).isEmpty
        assertThat(betaTool.codeInterpreter()).isEmpty
        assertThat(betaTool.programmaticToolCalling()).isEmpty
        assertThat(betaTool.imageGeneration()).contains(imageGeneration)
        assertThat(betaTool.localShell()).isEmpty
        assertThat(betaTool.shell()).isEmpty
        assertThat(betaTool.custom()).isEmpty
        assertThat(betaTool.namespace()).isEmpty
        assertThat(betaTool.toolSearch()).isEmpty
        assertThat(betaTool.webSearchPreview()).isEmpty
        assertThat(betaTool.applyPatch()).isEmpty
    }

    @Test
    fun ofImageGenerationRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaTool =
            BetaTool.ofImageGeneration(
                BetaTool.ImageGeneration.builder()
                    .action(BetaTool.ImageGeneration.Action.GENERATE)
                    .background(BetaTool.ImageGeneration.Background.TRANSPARENT)
                    .inputFidelity(BetaTool.ImageGeneration.InputFidelity.HIGH)
                    .inputImageMask(
                        BetaTool.ImageGeneration.InputImageMask.builder()
                            .fileId("file_id")
                            .imageUrl("image_url")
                            .build()
                    )
                    .model(BetaTool.ImageGeneration.Model.GPT_IMAGE_1)
                    .moderation(BetaTool.ImageGeneration.Moderation.AUTO)
                    .outputCompression(0L)
                    .outputFormat(BetaTool.ImageGeneration.OutputFormat.PNG)
                    .partialImages(0L)
                    .quality(BetaTool.ImageGeneration.Quality.LOW)
                    .size(BetaTool.ImageGeneration.Size._1024X1024)
                    .build()
            )

        val roundtrippedBetaTool =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaTool),
                jacksonTypeRef<BetaTool>(),
            )

        assertThat(roundtrippedBetaTool).isEqualTo(betaTool)
    }

    @Test
    fun ofLocalShell() {
        val betaTool = BetaTool.ofLocalShell()

        assertThat(betaTool.function()).isEmpty
        assertThat(betaTool.fileSearch()).isEmpty
        assertThat(betaTool.computer()).isEmpty
        assertThat(betaTool.computerUsePreview()).isEmpty
        assertThat(betaTool.webSearch()).isEmpty
        assertThat(betaTool.mcp()).isEmpty
        assertThat(betaTool.codeInterpreter()).isEmpty
        assertThat(betaTool.programmaticToolCalling()).isEmpty
        assertThat(betaTool.imageGeneration()).isEmpty
        assertThat(betaTool.localShell()).contains(JsonValue.from(mapOf("type" to "local_shell")))
        assertThat(betaTool.shell()).isEmpty
        assertThat(betaTool.custom()).isEmpty
        assertThat(betaTool.namespace()).isEmpty
        assertThat(betaTool.toolSearch()).isEmpty
        assertThat(betaTool.webSearchPreview()).isEmpty
        assertThat(betaTool.applyPatch()).isEmpty
    }

    @Test
    fun ofLocalShellRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaTool = BetaTool.ofLocalShell()

        val roundtrippedBetaTool =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaTool),
                jacksonTypeRef<BetaTool>(),
            )

        assertThat(roundtrippedBetaTool).isEqualTo(betaTool)
    }

    @Test
    fun ofShell() {
        val shell =
            BetaFunctionShellTool.builder()
                .addAllowedCaller(BetaFunctionShellTool.AllowedCaller.DIRECT)
                .environment(
                    BetaContainerAuto.builder()
                        .addFileId("file-123")
                        .memoryLimit(BetaContainerAuto.MemoryLimit._1G)
                        .networkPolicy(BetaContainerNetworkPolicyDisabled.builder().build())
                        .addSkill(
                            BetaSkillReference.builder().skillId("x").version("version").build()
                        )
                        .build()
                )
                .build()

        val betaTool = BetaTool.ofShell(shell)

        assertThat(betaTool.function()).isEmpty
        assertThat(betaTool.fileSearch()).isEmpty
        assertThat(betaTool.computer()).isEmpty
        assertThat(betaTool.computerUsePreview()).isEmpty
        assertThat(betaTool.webSearch()).isEmpty
        assertThat(betaTool.mcp()).isEmpty
        assertThat(betaTool.codeInterpreter()).isEmpty
        assertThat(betaTool.programmaticToolCalling()).isEmpty
        assertThat(betaTool.imageGeneration()).isEmpty
        assertThat(betaTool.localShell()).isEmpty
        assertThat(betaTool.shell()).contains(shell)
        assertThat(betaTool.custom()).isEmpty
        assertThat(betaTool.namespace()).isEmpty
        assertThat(betaTool.toolSearch()).isEmpty
        assertThat(betaTool.webSearchPreview()).isEmpty
        assertThat(betaTool.applyPatch()).isEmpty
    }

    @Test
    fun ofShellRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaTool =
            BetaTool.ofShell(
                BetaFunctionShellTool.builder()
                    .addAllowedCaller(BetaFunctionShellTool.AllowedCaller.DIRECT)
                    .environment(
                        BetaContainerAuto.builder()
                            .addFileId("file-123")
                            .memoryLimit(BetaContainerAuto.MemoryLimit._1G)
                            .networkPolicy(BetaContainerNetworkPolicyDisabled.builder().build())
                            .addSkill(
                                BetaSkillReference.builder().skillId("x").version("version").build()
                            )
                            .build()
                    )
                    .build()
            )

        val roundtrippedBetaTool =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaTool),
                jacksonTypeRef<BetaTool>(),
            )

        assertThat(roundtrippedBetaTool).isEqualTo(betaTool)
    }

    @Test
    fun ofCustom() {
        val custom =
            BetaCustomTool.builder()
                .name("name")
                .addAllowedCaller(BetaCustomTool.AllowedCaller.DIRECT)
                .deferLoading(true)
                .description("description")
                .formatText()
                .build()

        val betaTool = BetaTool.ofCustom(custom)

        assertThat(betaTool.function()).isEmpty
        assertThat(betaTool.fileSearch()).isEmpty
        assertThat(betaTool.computer()).isEmpty
        assertThat(betaTool.computerUsePreview()).isEmpty
        assertThat(betaTool.webSearch()).isEmpty
        assertThat(betaTool.mcp()).isEmpty
        assertThat(betaTool.codeInterpreter()).isEmpty
        assertThat(betaTool.programmaticToolCalling()).isEmpty
        assertThat(betaTool.imageGeneration()).isEmpty
        assertThat(betaTool.localShell()).isEmpty
        assertThat(betaTool.shell()).isEmpty
        assertThat(betaTool.custom()).contains(custom)
        assertThat(betaTool.namespace()).isEmpty
        assertThat(betaTool.toolSearch()).isEmpty
        assertThat(betaTool.webSearchPreview()).isEmpty
        assertThat(betaTool.applyPatch()).isEmpty
    }

    @Test
    fun ofCustomRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaTool =
            BetaTool.ofCustom(
                BetaCustomTool.builder()
                    .name("name")
                    .addAllowedCaller(BetaCustomTool.AllowedCaller.DIRECT)
                    .deferLoading(true)
                    .description("description")
                    .formatText()
                    .build()
            )

        val roundtrippedBetaTool =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaTool),
                jacksonTypeRef<BetaTool>(),
            )

        assertThat(roundtrippedBetaTool).isEqualTo(betaTool)
    }

    @Test
    fun ofNamespace() {
        val namespace =
            BetaNamespaceTool.builder()
                .description("x")
                .name("x")
                .addTool(
                    BetaNamespaceTool.Tool.Function.builder()
                        .name("name")
                        .addAllowedCaller(BetaNamespaceTool.Tool.Function.AllowedCaller.DIRECT)
                        .deferLoading(true)
                        .description("description")
                        .outputSchema(
                            BetaNamespaceTool.Tool.Function.OutputSchema.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .parameters(JsonValue.from(mapOf<String, Any>()))
                        .strict(true)
                        .build()
                )
                .build()

        val betaTool = BetaTool.ofNamespace(namespace)

        assertThat(betaTool.function()).isEmpty
        assertThat(betaTool.fileSearch()).isEmpty
        assertThat(betaTool.computer()).isEmpty
        assertThat(betaTool.computerUsePreview()).isEmpty
        assertThat(betaTool.webSearch()).isEmpty
        assertThat(betaTool.mcp()).isEmpty
        assertThat(betaTool.codeInterpreter()).isEmpty
        assertThat(betaTool.programmaticToolCalling()).isEmpty
        assertThat(betaTool.imageGeneration()).isEmpty
        assertThat(betaTool.localShell()).isEmpty
        assertThat(betaTool.shell()).isEmpty
        assertThat(betaTool.custom()).isEmpty
        assertThat(betaTool.namespace()).contains(namespace)
        assertThat(betaTool.toolSearch()).isEmpty
        assertThat(betaTool.webSearchPreview()).isEmpty
        assertThat(betaTool.applyPatch()).isEmpty
    }

    @Test
    fun ofNamespaceRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaTool =
            BetaTool.ofNamespace(
                BetaNamespaceTool.builder()
                    .description("x")
                    .name("x")
                    .addTool(
                        BetaNamespaceTool.Tool.Function.builder()
                            .name("name")
                            .addAllowedCaller(BetaNamespaceTool.Tool.Function.AllowedCaller.DIRECT)
                            .deferLoading(true)
                            .description("description")
                            .outputSchema(
                                BetaNamespaceTool.Tool.Function.OutputSchema.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                                    .build()
                            )
                            .parameters(JsonValue.from(mapOf<String, Any>()))
                            .strict(true)
                            .build()
                    )
                    .build()
            )

        val roundtrippedBetaTool =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaTool),
                jacksonTypeRef<BetaTool>(),
            )

        assertThat(roundtrippedBetaTool).isEqualTo(betaTool)
    }

    @Test
    fun ofToolSearch() {
        val toolSearch =
            BetaToolSearchTool.builder()
                .description("description")
                .execution(BetaToolSearchTool.Execution.SERVER)
                .parameters(JsonValue.from(mapOf<String, Any>()))
                .build()

        val betaTool = BetaTool.ofToolSearch(toolSearch)

        assertThat(betaTool.function()).isEmpty
        assertThat(betaTool.fileSearch()).isEmpty
        assertThat(betaTool.computer()).isEmpty
        assertThat(betaTool.computerUsePreview()).isEmpty
        assertThat(betaTool.webSearch()).isEmpty
        assertThat(betaTool.mcp()).isEmpty
        assertThat(betaTool.codeInterpreter()).isEmpty
        assertThat(betaTool.programmaticToolCalling()).isEmpty
        assertThat(betaTool.imageGeneration()).isEmpty
        assertThat(betaTool.localShell()).isEmpty
        assertThat(betaTool.shell()).isEmpty
        assertThat(betaTool.custom()).isEmpty
        assertThat(betaTool.namespace()).isEmpty
        assertThat(betaTool.toolSearch()).contains(toolSearch)
        assertThat(betaTool.webSearchPreview()).isEmpty
        assertThat(betaTool.applyPatch()).isEmpty
    }

    @Test
    fun ofToolSearchRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaTool =
            BetaTool.ofToolSearch(
                BetaToolSearchTool.builder()
                    .description("description")
                    .execution(BetaToolSearchTool.Execution.SERVER)
                    .parameters(JsonValue.from(mapOf<String, Any>()))
                    .build()
            )

        val roundtrippedBetaTool =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaTool),
                jacksonTypeRef<BetaTool>(),
            )

        assertThat(roundtrippedBetaTool).isEqualTo(betaTool)
    }

    @Test
    fun ofWebSearchPreview() {
        val webSearchPreview =
            BetaWebSearchPreviewTool.builder()
                .type(BetaWebSearchPreviewTool.Type.WEB_SEARCH_PREVIEW)
                .addSearchContentType(BetaWebSearchPreviewTool.SearchContentType.TEXT)
                .searchContextSize(BetaWebSearchPreviewTool.SearchContextSize.LOW)
                .userLocation(
                    BetaWebSearchPreviewTool.UserLocation.builder()
                        .city("city")
                        .country("country")
                        .region("region")
                        .timezone("timezone")
                        .build()
                )
                .build()

        val betaTool = BetaTool.ofWebSearchPreview(webSearchPreview)

        assertThat(betaTool.function()).isEmpty
        assertThat(betaTool.fileSearch()).isEmpty
        assertThat(betaTool.computer()).isEmpty
        assertThat(betaTool.computerUsePreview()).isEmpty
        assertThat(betaTool.webSearch()).isEmpty
        assertThat(betaTool.mcp()).isEmpty
        assertThat(betaTool.codeInterpreter()).isEmpty
        assertThat(betaTool.programmaticToolCalling()).isEmpty
        assertThat(betaTool.imageGeneration()).isEmpty
        assertThat(betaTool.localShell()).isEmpty
        assertThat(betaTool.shell()).isEmpty
        assertThat(betaTool.custom()).isEmpty
        assertThat(betaTool.namespace()).isEmpty
        assertThat(betaTool.toolSearch()).isEmpty
        assertThat(betaTool.webSearchPreview()).contains(webSearchPreview)
        assertThat(betaTool.applyPatch()).isEmpty
    }

    @Test
    fun ofWebSearchPreviewRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaTool =
            BetaTool.ofWebSearchPreview(
                BetaWebSearchPreviewTool.builder()
                    .type(BetaWebSearchPreviewTool.Type.WEB_SEARCH_PREVIEW)
                    .addSearchContentType(BetaWebSearchPreviewTool.SearchContentType.TEXT)
                    .searchContextSize(BetaWebSearchPreviewTool.SearchContextSize.LOW)
                    .userLocation(
                        BetaWebSearchPreviewTool.UserLocation.builder()
                            .city("city")
                            .country("country")
                            .region("region")
                            .timezone("timezone")
                            .build()
                    )
                    .build()
            )

        val roundtrippedBetaTool =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaTool),
                jacksonTypeRef<BetaTool>(),
            )

        assertThat(roundtrippedBetaTool).isEqualTo(betaTool)
    }

    @Test
    fun ofApplyPatch() {
        val applyPatch =
            BetaApplyPatchTool.builder()
                .addAllowedCaller(BetaApplyPatchTool.AllowedCaller.DIRECT)
                .build()

        val betaTool = BetaTool.ofApplyPatch(applyPatch)

        assertThat(betaTool.function()).isEmpty
        assertThat(betaTool.fileSearch()).isEmpty
        assertThat(betaTool.computer()).isEmpty
        assertThat(betaTool.computerUsePreview()).isEmpty
        assertThat(betaTool.webSearch()).isEmpty
        assertThat(betaTool.mcp()).isEmpty
        assertThat(betaTool.codeInterpreter()).isEmpty
        assertThat(betaTool.programmaticToolCalling()).isEmpty
        assertThat(betaTool.imageGeneration()).isEmpty
        assertThat(betaTool.localShell()).isEmpty
        assertThat(betaTool.shell()).isEmpty
        assertThat(betaTool.custom()).isEmpty
        assertThat(betaTool.namespace()).isEmpty
        assertThat(betaTool.toolSearch()).isEmpty
        assertThat(betaTool.webSearchPreview()).isEmpty
        assertThat(betaTool.applyPatch()).contains(applyPatch)
    }

    @Test
    fun ofApplyPatchRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaTool =
            BetaTool.ofApplyPatch(
                BetaApplyPatchTool.builder()
                    .addAllowedCaller(BetaApplyPatchTool.AllowedCaller.DIRECT)
                    .build()
            )

        val roundtrippedBetaTool =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaTool),
                jacksonTypeRef<BetaTool>(),
            )

        assertThat(roundtrippedBetaTool).isEqualTo(betaTool)
    }

    enum class IncompatibleJsonShapeTestCase(val value: JsonValue) {
        BOOLEAN(JsonValue.from(false)),
        STRING(JsonValue.from("invalid")),
        INTEGER(JsonValue.from(-1)),
        FLOAT(JsonValue.from(3.14)),
        ARRAY(JsonValue.from(listOf("invalid", "array"))),
    }

    @ParameterizedTest
    @EnumSource
    fun incompatibleJsonShapeDeserializesToUnknown(testCase: IncompatibleJsonShapeTestCase) {
        val betaTool = jsonMapper().convertValue(testCase.value, jacksonTypeRef<BetaTool>())

        val e = assertThrows<OpenAIInvalidDataException> { betaTool.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
