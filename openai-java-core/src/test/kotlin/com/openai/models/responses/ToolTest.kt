// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.ComparisonFilter
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class ToolTest {

    @Test
    fun ofFunction() {
        val function =
            FunctionTool.builder()
                .name("name")
                .parameters(
                    FunctionTool.Parameters.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .strict(true)
                .deferLoading(true)
                .description("description")
                .build()

        val tool = Tool.ofFunction(function)

        assertThat(tool.function()).contains(function)
        assertThat(tool.fileSearch()).isEmpty
        assertThat(tool.computer()).isEmpty
        assertThat(tool.computerUsePreview()).isEmpty
        assertThat(tool.webSearch()).isEmpty
        assertThat(tool.mcp()).isEmpty
        assertThat(tool.codeInterpreter()).isEmpty
        assertThat(tool.imageGeneration()).isEmpty
        assertThat(tool.localShell()).isEmpty
        assertThat(tool.shell()).isEmpty
        assertThat(tool.custom()).isEmpty
        assertThat(tool.namespace()).isEmpty
        assertThat(tool.search()).isEmpty
        assertThat(tool.webSearchPreview()).isEmpty
        assertThat(tool.applyPatch()).isEmpty
    }

    @Test
    fun ofFunctionRoundtrip() {
        val jsonMapper = jsonMapper()
        val tool =
            Tool.ofFunction(
                FunctionTool.builder()
                    .name("name")
                    .parameters(
                        FunctionTool.Parameters.builder()
                            .putAdditionalProperty("foo", JsonValue.from("bar"))
                            .build()
                    )
                    .strict(true)
                    .deferLoading(true)
                    .description("description")
                    .build()
            )

        val roundtrippedTool =
            jsonMapper.readValue(jsonMapper.writeValueAsString(tool), jacksonTypeRef<Tool>())

        assertThat(roundtrippedTool).isEqualTo(tool)
    }

    @Test
    fun ofFileSearch() {
        val fileSearch =
            FileSearchTool.builder()
                .addVectorStoreId("string")
                .filters(
                    ComparisonFilter.builder()
                        .key("key")
                        .type(ComparisonFilter.Type.EQ)
                        .value("string")
                        .build()
                )
                .maxNumResults(0L)
                .rankingOptions(
                    FileSearchTool.RankingOptions.builder()
                        .hybridSearch(
                            FileSearchTool.RankingOptions.HybridSearch.builder()
                                .embeddingWeight(0.0)
                                .textWeight(0.0)
                                .build()
                        )
                        .ranker(FileSearchTool.RankingOptions.Ranker.AUTO)
                        .scoreThreshold(0.0)
                        .build()
                )
                .build()

        val tool = Tool.ofFileSearch(fileSearch)

        assertThat(tool.function()).isEmpty
        assertThat(tool.fileSearch()).contains(fileSearch)
        assertThat(tool.computer()).isEmpty
        assertThat(tool.computerUsePreview()).isEmpty
        assertThat(tool.webSearch()).isEmpty
        assertThat(tool.mcp()).isEmpty
        assertThat(tool.codeInterpreter()).isEmpty
        assertThat(tool.imageGeneration()).isEmpty
        assertThat(tool.localShell()).isEmpty
        assertThat(tool.shell()).isEmpty
        assertThat(tool.custom()).isEmpty
        assertThat(tool.namespace()).isEmpty
        assertThat(tool.search()).isEmpty
        assertThat(tool.webSearchPreview()).isEmpty
        assertThat(tool.applyPatch()).isEmpty
    }

    @Test
    fun ofFileSearchRoundtrip() {
        val jsonMapper = jsonMapper()
        val tool =
            Tool.ofFileSearch(
                FileSearchTool.builder()
                    .addVectorStoreId("string")
                    .filters(
                        ComparisonFilter.builder()
                            .key("key")
                            .type(ComparisonFilter.Type.EQ)
                            .value("string")
                            .build()
                    )
                    .maxNumResults(0L)
                    .rankingOptions(
                        FileSearchTool.RankingOptions.builder()
                            .hybridSearch(
                                FileSearchTool.RankingOptions.HybridSearch.builder()
                                    .embeddingWeight(0.0)
                                    .textWeight(0.0)
                                    .build()
                            )
                            .ranker(FileSearchTool.RankingOptions.Ranker.AUTO)
                            .scoreThreshold(0.0)
                            .build()
                    )
                    .build()
            )

        val roundtrippedTool =
            jsonMapper.readValue(jsonMapper.writeValueAsString(tool), jacksonTypeRef<Tool>())

        assertThat(roundtrippedTool).isEqualTo(tool)
    }

    @Test
    fun ofComputer() {
        val computer = ComputerTool.builder().build()

        val tool = Tool.ofComputer(computer)

        assertThat(tool.function()).isEmpty
        assertThat(tool.fileSearch()).isEmpty
        assertThat(tool.computer()).contains(computer)
        assertThat(tool.computerUsePreview()).isEmpty
        assertThat(tool.webSearch()).isEmpty
        assertThat(tool.mcp()).isEmpty
        assertThat(tool.codeInterpreter()).isEmpty
        assertThat(tool.imageGeneration()).isEmpty
        assertThat(tool.localShell()).isEmpty
        assertThat(tool.shell()).isEmpty
        assertThat(tool.custom()).isEmpty
        assertThat(tool.namespace()).isEmpty
        assertThat(tool.search()).isEmpty
        assertThat(tool.webSearchPreview()).isEmpty
        assertThat(tool.applyPatch()).isEmpty
    }

    @Test
    fun ofComputerRoundtrip() {
        val jsonMapper = jsonMapper()
        val tool = Tool.ofComputer(ComputerTool.builder().build())

        val roundtrippedTool =
            jsonMapper.readValue(jsonMapper.writeValueAsString(tool), jacksonTypeRef<Tool>())

        assertThat(roundtrippedTool).isEqualTo(tool)
    }

    @Test
    fun ofComputerUsePreview() {
        val computerUsePreview =
            ComputerUsePreviewTool.builder()
                .displayHeight(0L)
                .displayWidth(0L)
                .environment(ComputerUsePreviewTool.Environment.WINDOWS)
                .build()

        val tool = Tool.ofComputerUsePreview(computerUsePreview)

        assertThat(tool.function()).isEmpty
        assertThat(tool.fileSearch()).isEmpty
        assertThat(tool.computer()).isEmpty
        assertThat(tool.computerUsePreview()).contains(computerUsePreview)
        assertThat(tool.webSearch()).isEmpty
        assertThat(tool.mcp()).isEmpty
        assertThat(tool.codeInterpreter()).isEmpty
        assertThat(tool.imageGeneration()).isEmpty
        assertThat(tool.localShell()).isEmpty
        assertThat(tool.shell()).isEmpty
        assertThat(tool.custom()).isEmpty
        assertThat(tool.namespace()).isEmpty
        assertThat(tool.search()).isEmpty
        assertThat(tool.webSearchPreview()).isEmpty
        assertThat(tool.applyPatch()).isEmpty
    }

    @Test
    fun ofComputerUsePreviewRoundtrip() {
        val jsonMapper = jsonMapper()
        val tool =
            Tool.ofComputerUsePreview(
                ComputerUsePreviewTool.builder()
                    .displayHeight(0L)
                    .displayWidth(0L)
                    .environment(ComputerUsePreviewTool.Environment.WINDOWS)
                    .build()
            )

        val roundtrippedTool =
            jsonMapper.readValue(jsonMapper.writeValueAsString(tool), jacksonTypeRef<Tool>())

        assertThat(roundtrippedTool).isEqualTo(tool)
    }

    @Test
    fun ofWebSearch() {
        val webSearch =
            WebSearchTool.builder()
                .type(WebSearchTool.Type.WEB_SEARCH)
                .filters(WebSearchTool.Filters.builder().addAllowedDomain("string").build())
                .searchContextSize(WebSearchTool.SearchContextSize.LOW)
                .userLocation(
                    WebSearchTool.UserLocation.builder()
                        .city("city")
                        .country("country")
                        .region("region")
                        .timezone("timezone")
                        .type(WebSearchTool.UserLocation.Type.APPROXIMATE)
                        .build()
                )
                .build()

        val tool = Tool.ofWebSearch(webSearch)

        assertThat(tool.function()).isEmpty
        assertThat(tool.fileSearch()).isEmpty
        assertThat(tool.computer()).isEmpty
        assertThat(tool.computerUsePreview()).isEmpty
        assertThat(tool.webSearch()).contains(webSearch)
        assertThat(tool.mcp()).isEmpty
        assertThat(tool.codeInterpreter()).isEmpty
        assertThat(tool.imageGeneration()).isEmpty
        assertThat(tool.localShell()).isEmpty
        assertThat(tool.shell()).isEmpty
        assertThat(tool.custom()).isEmpty
        assertThat(tool.namespace()).isEmpty
        assertThat(tool.search()).isEmpty
        assertThat(tool.webSearchPreview()).isEmpty
        assertThat(tool.applyPatch()).isEmpty
    }

    @Test
    fun ofWebSearchRoundtrip() {
        val jsonMapper = jsonMapper()
        val tool =
            Tool.ofWebSearch(
                WebSearchTool.builder()
                    .type(WebSearchTool.Type.WEB_SEARCH)
                    .filters(WebSearchTool.Filters.builder().addAllowedDomain("string").build())
                    .searchContextSize(WebSearchTool.SearchContextSize.LOW)
                    .userLocation(
                        WebSearchTool.UserLocation.builder()
                            .city("city")
                            .country("country")
                            .region("region")
                            .timezone("timezone")
                            .type(WebSearchTool.UserLocation.Type.APPROXIMATE)
                            .build()
                    )
                    .build()
            )

        val roundtrippedTool =
            jsonMapper.readValue(jsonMapper.writeValueAsString(tool), jacksonTypeRef<Tool>())

        assertThat(roundtrippedTool).isEqualTo(tool)
    }

    @Test
    fun ofMcp() {
        val mcp =
            Tool.Mcp.builder()
                .serverLabel("server_label")
                .allowedToolsOfMcp(listOf("string"))
                .authorization("authorization")
                .connectorId(Tool.Mcp.ConnectorId.CONNECTOR_DROPBOX)
                .deferLoading(true)
                .headers(
                    Tool.Mcp.Headers.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .requireApproval(Tool.Mcp.RequireApproval.McpToolApprovalSetting.ALWAYS)
                .serverDescription("server_description")
                .serverUrl("https://example.com")
                .build()

        val tool = Tool.ofMcp(mcp)

        assertThat(tool.function()).isEmpty
        assertThat(tool.fileSearch()).isEmpty
        assertThat(tool.computer()).isEmpty
        assertThat(tool.computerUsePreview()).isEmpty
        assertThat(tool.webSearch()).isEmpty
        assertThat(tool.mcp()).contains(mcp)
        assertThat(tool.codeInterpreter()).isEmpty
        assertThat(tool.imageGeneration()).isEmpty
        assertThat(tool.localShell()).isEmpty
        assertThat(tool.shell()).isEmpty
        assertThat(tool.custom()).isEmpty
        assertThat(tool.namespace()).isEmpty
        assertThat(tool.search()).isEmpty
        assertThat(tool.webSearchPreview()).isEmpty
        assertThat(tool.applyPatch()).isEmpty
    }

    @Test
    fun ofMcpRoundtrip() {
        val jsonMapper = jsonMapper()
        val tool =
            Tool.ofMcp(
                Tool.Mcp.builder()
                    .serverLabel("server_label")
                    .allowedToolsOfMcp(listOf("string"))
                    .authorization("authorization")
                    .connectorId(Tool.Mcp.ConnectorId.CONNECTOR_DROPBOX)
                    .deferLoading(true)
                    .headers(
                        Tool.Mcp.Headers.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .requireApproval(Tool.Mcp.RequireApproval.McpToolApprovalSetting.ALWAYS)
                    .serverDescription("server_description")
                    .serverUrl("https://example.com")
                    .build()
            )

        val roundtrippedTool =
            jsonMapper.readValue(jsonMapper.writeValueAsString(tool), jacksonTypeRef<Tool>())

        assertThat(roundtrippedTool).isEqualTo(tool)
    }

    @Test
    fun ofCodeInterpreter() {
        val codeInterpreter = Tool.CodeInterpreter.builder().container("string").build()

        val tool = Tool.ofCodeInterpreter(codeInterpreter)

        assertThat(tool.function()).isEmpty
        assertThat(tool.fileSearch()).isEmpty
        assertThat(tool.computer()).isEmpty
        assertThat(tool.computerUsePreview()).isEmpty
        assertThat(tool.webSearch()).isEmpty
        assertThat(tool.mcp()).isEmpty
        assertThat(tool.codeInterpreter()).contains(codeInterpreter)
        assertThat(tool.imageGeneration()).isEmpty
        assertThat(tool.localShell()).isEmpty
        assertThat(tool.shell()).isEmpty
        assertThat(tool.custom()).isEmpty
        assertThat(tool.namespace()).isEmpty
        assertThat(tool.search()).isEmpty
        assertThat(tool.webSearchPreview()).isEmpty
        assertThat(tool.applyPatch()).isEmpty
    }

    @Test
    fun ofCodeInterpreterRoundtrip() {
        val jsonMapper = jsonMapper()
        val tool =
            Tool.ofCodeInterpreter(Tool.CodeInterpreter.builder().container("string").build())

        val roundtrippedTool =
            jsonMapper.readValue(jsonMapper.writeValueAsString(tool), jacksonTypeRef<Tool>())

        assertThat(roundtrippedTool).isEqualTo(tool)
    }

    @Test
    fun ofImageGeneration() {
        val imageGeneration =
            Tool.ImageGeneration.builder()
                .action(Tool.ImageGeneration.Action.GENERATE)
                .background(Tool.ImageGeneration.Background.TRANSPARENT)
                .inputFidelity(Tool.ImageGeneration.InputFidelity.HIGH)
                .inputImageMask(
                    Tool.ImageGeneration.InputImageMask.builder()
                        .fileId("file_id")
                        .imageUrl("image_url")
                        .build()
                )
                .model(Tool.ImageGeneration.Model.GPT_IMAGE_1)
                .moderation(Tool.ImageGeneration.Moderation.AUTO)
                .outputCompression(0L)
                .outputFormat(Tool.ImageGeneration.OutputFormat.PNG)
                .partialImages(0L)
                .quality(Tool.ImageGeneration.Quality.LOW)
                .size("size")
                .build()

        val tool = Tool.ofImageGeneration(imageGeneration)

        assertThat(tool.function()).isEmpty
        assertThat(tool.fileSearch()).isEmpty
        assertThat(tool.computer()).isEmpty
        assertThat(tool.computerUsePreview()).isEmpty
        assertThat(tool.webSearch()).isEmpty
        assertThat(tool.mcp()).isEmpty
        assertThat(tool.codeInterpreter()).isEmpty
        assertThat(tool.imageGeneration()).contains(imageGeneration)
        assertThat(tool.localShell()).isEmpty
        assertThat(tool.shell()).isEmpty
        assertThat(tool.custom()).isEmpty
        assertThat(tool.namespace()).isEmpty
        assertThat(tool.search()).isEmpty
        assertThat(tool.webSearchPreview()).isEmpty
        assertThat(tool.applyPatch()).isEmpty
    }

    @Test
    fun ofImageGenerationRoundtrip() {
        val jsonMapper = jsonMapper()
        val tool =
            Tool.ofImageGeneration(
                Tool.ImageGeneration.builder()
                    .action(Tool.ImageGeneration.Action.GENERATE)
                    .background(Tool.ImageGeneration.Background.TRANSPARENT)
                    .inputFidelity(Tool.ImageGeneration.InputFidelity.HIGH)
                    .inputImageMask(
                        Tool.ImageGeneration.InputImageMask.builder()
                            .fileId("file_id")
                            .imageUrl("image_url")
                            .build()
                    )
                    .model(Tool.ImageGeneration.Model.GPT_IMAGE_1)
                    .moderation(Tool.ImageGeneration.Moderation.AUTO)
                    .outputCompression(0L)
                    .outputFormat(Tool.ImageGeneration.OutputFormat.PNG)
                    .partialImages(0L)
                    .quality(Tool.ImageGeneration.Quality.LOW)
                    .size("size")
                    .build()
            )

        val roundtrippedTool =
            jsonMapper.readValue(jsonMapper.writeValueAsString(tool), jacksonTypeRef<Tool>())

        assertThat(roundtrippedTool).isEqualTo(tool)
    }

    @Test
    fun ofLocalShell() {
        val tool = Tool.ofLocalShell()

        assertThat(tool.function()).isEmpty
        assertThat(tool.fileSearch()).isEmpty
        assertThat(tool.computer()).isEmpty
        assertThat(tool.computerUsePreview()).isEmpty
        assertThat(tool.webSearch()).isEmpty
        assertThat(tool.mcp()).isEmpty
        assertThat(tool.codeInterpreter()).isEmpty
        assertThat(tool.imageGeneration()).isEmpty
        assertThat(tool.localShell()).contains(JsonValue.from(mapOf("type" to "local_shell")))
        assertThat(tool.shell()).isEmpty
        assertThat(tool.custom()).isEmpty
        assertThat(tool.namespace()).isEmpty
        assertThat(tool.search()).isEmpty
        assertThat(tool.webSearchPreview()).isEmpty
        assertThat(tool.applyPatch()).isEmpty
    }

    @Test
    fun ofLocalShellRoundtrip() {
        val jsonMapper = jsonMapper()
        val tool = Tool.ofLocalShell()

        val roundtrippedTool =
            jsonMapper.readValue(jsonMapper.writeValueAsString(tool), jacksonTypeRef<Tool>())

        assertThat(roundtrippedTool).isEqualTo(tool)
    }

    @Test
    fun ofShell() {
        val shell =
            FunctionShellTool.builder()
                .environment(
                    ContainerAuto.builder()
                        .addFileId("file-123")
                        .memoryLimit(ContainerAuto.MemoryLimit._1G)
                        .networkPolicy(ContainerNetworkPolicyDisabled.builder().build())
                        .addSkill(SkillReference.builder().skillId("x").version("version").build())
                        .build()
                )
                .build()

        val tool = Tool.ofShell(shell)

        assertThat(tool.function()).isEmpty
        assertThat(tool.fileSearch()).isEmpty
        assertThat(tool.computer()).isEmpty
        assertThat(tool.computerUsePreview()).isEmpty
        assertThat(tool.webSearch()).isEmpty
        assertThat(tool.mcp()).isEmpty
        assertThat(tool.codeInterpreter()).isEmpty
        assertThat(tool.imageGeneration()).isEmpty
        assertThat(tool.localShell()).isEmpty
        assertThat(tool.shell()).contains(shell)
        assertThat(tool.custom()).isEmpty
        assertThat(tool.namespace()).isEmpty
        assertThat(tool.search()).isEmpty
        assertThat(tool.webSearchPreview()).isEmpty
        assertThat(tool.applyPatch()).isEmpty
    }

    @Test
    fun ofShellRoundtrip() {
        val jsonMapper = jsonMapper()
        val tool =
            Tool.ofShell(
                FunctionShellTool.builder()
                    .environment(
                        ContainerAuto.builder()
                            .addFileId("file-123")
                            .memoryLimit(ContainerAuto.MemoryLimit._1G)
                            .networkPolicy(ContainerNetworkPolicyDisabled.builder().build())
                            .addSkill(
                                SkillReference.builder().skillId("x").version("version").build()
                            )
                            .build()
                    )
                    .build()
            )

        val roundtrippedTool =
            jsonMapper.readValue(jsonMapper.writeValueAsString(tool), jacksonTypeRef<Tool>())

        assertThat(roundtrippedTool).isEqualTo(tool)
    }

    @Test
    fun ofCustom() {
        val custom =
            CustomTool.builder()
                .name("name")
                .deferLoading(true)
                .description("description")
                .formatText()
                .build()

        val tool = Tool.ofCustom(custom)

        assertThat(tool.function()).isEmpty
        assertThat(tool.fileSearch()).isEmpty
        assertThat(tool.computer()).isEmpty
        assertThat(tool.computerUsePreview()).isEmpty
        assertThat(tool.webSearch()).isEmpty
        assertThat(tool.mcp()).isEmpty
        assertThat(tool.codeInterpreter()).isEmpty
        assertThat(tool.imageGeneration()).isEmpty
        assertThat(tool.localShell()).isEmpty
        assertThat(tool.shell()).isEmpty
        assertThat(tool.custom()).contains(custom)
        assertThat(tool.namespace()).isEmpty
        assertThat(tool.search()).isEmpty
        assertThat(tool.webSearchPreview()).isEmpty
        assertThat(tool.applyPatch()).isEmpty
    }

    @Test
    fun ofCustomRoundtrip() {
        val jsonMapper = jsonMapper()
        val tool =
            Tool.ofCustom(
                CustomTool.builder()
                    .name("name")
                    .deferLoading(true)
                    .description("description")
                    .formatText()
                    .build()
            )

        val roundtrippedTool =
            jsonMapper.readValue(jsonMapper.writeValueAsString(tool), jacksonTypeRef<Tool>())

        assertThat(roundtrippedTool).isEqualTo(tool)
    }

    @Test
    fun ofNamespace() {
        val namespace =
            NamespaceTool.builder()
                .description("x")
                .name("x")
                .addTool(
                    NamespaceTool.Tool.Function.builder()
                        .name("name")
                        .deferLoading(true)
                        .description("description")
                        .parameters(JsonValue.from(mapOf<String, Any>()))
                        .strict(true)
                        .build()
                )
                .build()

        val tool = Tool.ofNamespace(namespace)

        assertThat(tool.function()).isEmpty
        assertThat(tool.fileSearch()).isEmpty
        assertThat(tool.computer()).isEmpty
        assertThat(tool.computerUsePreview()).isEmpty
        assertThat(tool.webSearch()).isEmpty
        assertThat(tool.mcp()).isEmpty
        assertThat(tool.codeInterpreter()).isEmpty
        assertThat(tool.imageGeneration()).isEmpty
        assertThat(tool.localShell()).isEmpty
        assertThat(tool.shell()).isEmpty
        assertThat(tool.custom()).isEmpty
        assertThat(tool.namespace()).contains(namespace)
        assertThat(tool.search()).isEmpty
        assertThat(tool.webSearchPreview()).isEmpty
        assertThat(tool.applyPatch()).isEmpty
    }

    @Test
    fun ofNamespaceRoundtrip() {
        val jsonMapper = jsonMapper()
        val tool =
            Tool.ofNamespace(
                NamespaceTool.builder()
                    .description("x")
                    .name("x")
                    .addTool(
                        NamespaceTool.Tool.Function.builder()
                            .name("name")
                            .deferLoading(true)
                            .description("description")
                            .parameters(JsonValue.from(mapOf<String, Any>()))
                            .strict(true)
                            .build()
                    )
                    .build()
            )

        val roundtrippedTool =
            jsonMapper.readValue(jsonMapper.writeValueAsString(tool), jacksonTypeRef<Tool>())

        assertThat(roundtrippedTool).isEqualTo(tool)
    }

    @Test
    fun ofSearch() {
        val search =
            ToolSearchTool.builder()
                .description("description")
                .execution(ToolSearchTool.Execution.SERVER)
                .parameters(JsonValue.from(mapOf<String, Any>()))
                .build()

        val tool = Tool.ofSearch(search)

        assertThat(tool.function()).isEmpty
        assertThat(tool.fileSearch()).isEmpty
        assertThat(tool.computer()).isEmpty
        assertThat(tool.computerUsePreview()).isEmpty
        assertThat(tool.webSearch()).isEmpty
        assertThat(tool.mcp()).isEmpty
        assertThat(tool.codeInterpreter()).isEmpty
        assertThat(tool.imageGeneration()).isEmpty
        assertThat(tool.localShell()).isEmpty
        assertThat(tool.shell()).isEmpty
        assertThat(tool.custom()).isEmpty
        assertThat(tool.namespace()).isEmpty
        assertThat(tool.search()).contains(search)
        assertThat(tool.webSearchPreview()).isEmpty
        assertThat(tool.applyPatch()).isEmpty
    }

    @Test
    fun ofSearchRoundtrip() {
        val jsonMapper = jsonMapper()
        val tool =
            Tool.ofSearch(
                ToolSearchTool.builder()
                    .description("description")
                    .execution(ToolSearchTool.Execution.SERVER)
                    .parameters(JsonValue.from(mapOf<String, Any>()))
                    .build()
            )

        val roundtrippedTool =
            jsonMapper.readValue(jsonMapper.writeValueAsString(tool), jacksonTypeRef<Tool>())

        assertThat(roundtrippedTool).isEqualTo(tool)
    }

    @Test
    fun ofWebSearchPreview() {
        val webSearchPreview =
            WebSearchPreviewTool.builder()
                .type(WebSearchPreviewTool.Type.WEB_SEARCH_PREVIEW)
                .addSearchContentType(WebSearchPreviewTool.SearchContentType.TEXT)
                .searchContextSize(WebSearchPreviewTool.SearchContextSize.LOW)
                .userLocation(
                    WebSearchPreviewTool.UserLocation.builder()
                        .city("city")
                        .country("country")
                        .region("region")
                        .timezone("timezone")
                        .build()
                )
                .build()

        val tool = Tool.ofWebSearchPreview(webSearchPreview)

        assertThat(tool.function()).isEmpty
        assertThat(tool.fileSearch()).isEmpty
        assertThat(tool.computer()).isEmpty
        assertThat(tool.computerUsePreview()).isEmpty
        assertThat(tool.webSearch()).isEmpty
        assertThat(tool.mcp()).isEmpty
        assertThat(tool.codeInterpreter()).isEmpty
        assertThat(tool.imageGeneration()).isEmpty
        assertThat(tool.localShell()).isEmpty
        assertThat(tool.shell()).isEmpty
        assertThat(tool.custom()).isEmpty
        assertThat(tool.namespace()).isEmpty
        assertThat(tool.search()).isEmpty
        assertThat(tool.webSearchPreview()).contains(webSearchPreview)
        assertThat(tool.applyPatch()).isEmpty
    }

    @Test
    fun ofWebSearchPreviewRoundtrip() {
        val jsonMapper = jsonMapper()
        val tool =
            Tool.ofWebSearchPreview(
                WebSearchPreviewTool.builder()
                    .type(WebSearchPreviewTool.Type.WEB_SEARCH_PREVIEW)
                    .addSearchContentType(WebSearchPreviewTool.SearchContentType.TEXT)
                    .searchContextSize(WebSearchPreviewTool.SearchContextSize.LOW)
                    .userLocation(
                        WebSearchPreviewTool.UserLocation.builder()
                            .city("city")
                            .country("country")
                            .region("region")
                            .timezone("timezone")
                            .build()
                    )
                    .build()
            )

        val roundtrippedTool =
            jsonMapper.readValue(jsonMapper.writeValueAsString(tool), jacksonTypeRef<Tool>())

        assertThat(roundtrippedTool).isEqualTo(tool)
    }

    @Test
    fun ofApplyPatch() {
        val applyPatch = ApplyPatchTool.builder().build()

        val tool = Tool.ofApplyPatch(applyPatch)

        assertThat(tool.function()).isEmpty
        assertThat(tool.fileSearch()).isEmpty
        assertThat(tool.computer()).isEmpty
        assertThat(tool.computerUsePreview()).isEmpty
        assertThat(tool.webSearch()).isEmpty
        assertThat(tool.mcp()).isEmpty
        assertThat(tool.codeInterpreter()).isEmpty
        assertThat(tool.imageGeneration()).isEmpty
        assertThat(tool.localShell()).isEmpty
        assertThat(tool.shell()).isEmpty
        assertThat(tool.custom()).isEmpty
        assertThat(tool.namespace()).isEmpty
        assertThat(tool.search()).isEmpty
        assertThat(tool.webSearchPreview()).isEmpty
        assertThat(tool.applyPatch()).contains(applyPatch)
    }

    @Test
    fun ofApplyPatchRoundtrip() {
        val jsonMapper = jsonMapper()
        val tool = Tool.ofApplyPatch(ApplyPatchTool.builder().build())

        val roundtrippedTool =
            jsonMapper.readValue(jsonMapper.writeValueAsString(tool), jacksonTypeRef<Tool>())

        assertThat(roundtrippedTool).isEqualTo(tool)
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
        val tool = jsonMapper().convertValue(testCase.value, jacksonTypeRef<Tool>())

        val e = assertThrows<OpenAIInvalidDataException> { tool.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
