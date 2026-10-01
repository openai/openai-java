package com.openai.helpers.beta.agents

import com.fasterxml.jackson.annotation.JsonClassDescription
import com.fasterxml.jackson.annotation.JsonTypeName
import com.fasterxml.jackson.databind.JsonNode
import com.openai.core.jsonMapper
import com.openai.models.beta.agents.sessions.SessionCreateParams
import com.openai.models.responses.ResponseCreateParams
import io.swagger.v3.oas.annotations.media.ArraySchema
import io.swagger.v3.oas.annotations.media.Schema
import java.util.Optional
import java.util.concurrent.CompletableFuture
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

internal class AgentFunctionToolTest {
    @JsonTypeName("lookup_item")
    @JsonClassDescription("Look up a catalog item.")
    class LookupItem(val itemId: String)

    class Lookup(val itemId: String)

    class PublicFields {
        @JvmField var itemId: String? = null
    }

    class NestedFields {
        @JvmField var item: PublicFields? = null
        @JvmField var others: List<PublicFields>? = null
    }

    class OptionalFields {
        @JvmField var itemId: Optional<String> = Optional.empty()
    }

    enum class ItemId {
        ITEM_A,
        ITEM_B,
    }

    class LimitedAmount(@get:Schema(maximum = "10") val amount: Int)

    class RestrictedAddress(@get:Schema(pattern = "^item-") val address: String)

    class LimitedItems(@get:ArraySchema(maxItems = 1) val items: List<String>)

    class FormattedAddress(@get:Schema(format = "email") val address: String)

    class NestedConstraint(val items: List<LimitedAmount>)

    class EnumItemId(val itemId: ItemId)

    class AllowedItemId(@get:Schema(allowableValues = ["ITEM_A", "ITEM_B"]) val itemId: String)

    class ConstantItemId(@get:Schema(allowableValues = ["ITEM_A"]) val itemId: String)

    class KeywordFields(val maximum: String, val pattern: String, val maxItems: Int)

    private class CatalogActions(private val catalogId: String) {
        fun lookup(args: LookupItem): Map<String, String> =
            mapOf("type" to "lookup", "content" to args.itemId, "catalogId" to catalogId)
    }

    @Test
    fun bindsApplicationActionWithoutExposingDependencies() {
        val catalog = CatalogActions("test-catalog")
        val tool = AgentFunctionTool.of(LookupItem::class.java, catalog::lookup)
        val definition = jsonMapper().valueToTree<JsonNode>(tool.definition().validate())
        SessionCreateParams.Agent.builder().addTool(tool.definition()).build().validate()
        assertThat(tool.definition().asFunction().parameters()._additionalProperties())
            .containsKey("properties")
        assertThat(tool.name()).isEqualTo("lookup_item")
        assertThat(definition.path("type").asText()).isEqualTo("function")
        assertThat(definition.path("description").asText()).isEqualTo("Look up a catalog item.")
        assertThat(definition.has("function")).isFalse()
        assertThat(
                definition.path("parameters").path("properties").fieldNames().asSequence().toList()
            )
            .containsExactly("itemId")
        assertThat(definition.path("parameters").path("required").map { it.asText() })
            .containsExactly("itemId")
        assertThat(definition.path("parameters").path("additionalProperties").asBoolean()).isFalse()
        assertThat(tool.handler().apply(mapOf("itemId" to "ITEM_A")))
            .isEqualTo(
                mapOf("type" to "lookup", "content" to "ITEM_A", "catalogId" to "test-catalog")
            )
    }

    @Test
    fun supportsUnannotatedClassesAndAsyncStages() {
        val pending = CompletableFuture<String>()
        val tool =
            AgentFunctionTool.ofAsync(Lookup::class.java) { args ->
                assertThat(args.itemId).isEqualTo("ITEM_A")
                pending
            }
        assertThat(tool.name()).isEqualTo("Lookup")
        tool.definition().validate()
        assertThat(tool.handler().apply(mapOf("itemId" to "ITEM_A"))).isSameAs(pending)
    }

    @Test
    fun parsingFailsBeforeCallingApplication() {
        var invocations = 0
        val tool =
            AgentFunctionTool.of(LookupItem::class.java) {
                invocations++
                "unused"
            }
        for (arguments in listOf(emptyMap(), mapOf("itemId" to emptyList<String>()))) {
            assertThatThrownBy { tool.handler().apply(arguments) }
                .hasMessageContaining("parameter shape")
        }
        assertThat(invocations).isZero()
    }

    @Test
    fun publicFieldsCannotDefaultOrCoerceBeforeApplicationCalls() {
        var invocations = 0
        val tool =
            AgentFunctionTool.of(NestedFields::class.java) {
                invocations++
                "unused"
            }
        for (item in
            listOf(
                emptyMap(),
                mapOf("itemId" to null),
                mapOf("itemId" to 123),
                mapOf("itemId" to "ITEM_A", "extra" to true),
            )) {
            assertThatThrownBy {
                    tool.handler().apply(mapOf("item" to item, "others" to emptyList<Any>()))
                }
                .isInstanceOf(IllegalArgumentException::class.java)
            assertThatThrownBy {
                    tool
                        .handler()
                        .apply(
                            mapOf("item" to mapOf("itemId" to "ITEM_A"), "others" to listOf(item))
                        )
                }
                .isInstanceOf(IllegalArgumentException::class.java)
        }
        assertThat(invocations).isZero()
        tool
            .handler()
            .apply(
                mapOf(
                    "item" to mapOf("itemId" to "ITEM_A"),
                    "others" to listOf(mapOf("itemId" to "ITEM_B")),
                )
            )
        assertThat(invocations).isEqualTo(1)
    }

    @Test
    fun optionalArgumentsAllowExplicitNull() {
        val tool = AgentFunctionTool.of(OptionalFields::class.java) { it.itemId.orElse("none") }
        assertThat(tool.handler().apply(mapOf("itemId" to null))).isEqualTo("none")
        assertThat(tool.handler().apply(mapOf("itemId" to "ITEM_A"))).isEqualTo("ITEM_A")
        assertThatThrownBy { tool.handler().apply(emptyMap()) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun rejectsParameterClassesThatCannotReceiveObjectArguments() {
        for (type in listOf(String::class.java, Array<String>::class.java, ItemId::class.java)) {
            assertThatThrownBy { AgentFunctionTool.of(type) { "unused" } }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessageContaining("object class")
        }
    }

    @Test
    fun preservesResponsesConstraintsForTheApiAndApplication() {
        for (type in
            listOf(
                LimitedAmount::class.java,
                RestrictedAddress::class.java,
                LimitedItems::class.java,
                FormattedAddress::class.java,
                NestedConstraint::class.java,
            )) {
            val tool = AgentFunctionTool.of(type) { "unused" }
            val responses =
                ResponseCreateParams.builder().addTool(type).build().tools().get().single()
            assertThat(jsonMapper().valueToTree<JsonNode>(tool.definition()).path("parameters"))
                .isEqualTo(jsonMapper().valueToTree<JsonNode>(responses).path("parameters"))
        }
        val limited =
            AgentFunctionTool.of(LimitedAmount::class.java) {
                require(it.amount <= 10) { "Application limit exceeded" }
                it.amount
            }
        assertThat(limited.handler().apply(mapOf("amount" to 10))).isEqualTo(10)
        assertThatThrownBy { limited.handler().apply(mapOf("amount" to 11)) }
            .hasMessageContaining("Application limit exceeded")
        val tool = AgentFunctionTool.of(KeywordFields::class.java) { it.maximum }
        assertThat(
                tool
                    .handler()
                    .apply(mapOf("maximum" to "limit", "pattern" to "text", "maxItems" to 1))
            )
            .isEqualTo("limit")
    }

    @Test
    fun enforcesEnumAndConstantValuesBeforeCallingApplication() {
        var invocations = 0
        for (type in
            listOf(EnumItemId::class.java, AllowedItemId::class.java, ConstantItemId::class.java)) {
            val tool =
                AgentFunctionTool.of(type) {
                    invocations++
                    "valid"
                }
            assertThat(tool.handler().apply(mapOf("itemId" to "ITEM_A"))).isEqualTo("valid")
            assertThatThrownBy { tool.handler().apply(mapOf("itemId" to "invalid")) }
                .hasMessageContaining("parameter shape")
        }
        assertThat(invocations).isEqualTo(3)
    }
}
