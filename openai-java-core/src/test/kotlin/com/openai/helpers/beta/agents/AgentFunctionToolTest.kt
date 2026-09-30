package com.openai.helpers.beta.agents

import com.fasterxml.jackson.annotation.JsonClassDescription
import com.fasterxml.jackson.annotation.JsonTypeName
import com.fasterxml.jackson.databind.JsonNode
import com.openai.core.jsonMapper
import com.openai.models.beta.agents.sessions.SessionCreateParams
import io.swagger.v3.oas.annotations.media.ArraySchema
import io.swagger.v3.oas.annotations.media.Schema
import java.util.Optional
import java.util.concurrent.CompletableFuture
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

internal class AgentFunctionToolTest {
    @JsonTypeName("wallet_balance")
    @JsonClassDescription("Look up a wallet balance.")
    class Balance(val asset: String)

    class Lookup(val orderId: String)

    class PublicFields {
        @JvmField var asset: String? = null
    }

    class NestedFields {
        @JvmField var wallet: PublicFields? = null
        @JvmField var others: List<PublicFields>? = null
    }

    class OptionalFields {
        @JvmField var asset: Optional<String> = Optional.empty()
    }

    enum class Asset {
        ETH,
        BTC,
    }

    class LimitedAmount(@get:Schema(maximum = "10") val amount: Int)

    class RestrictedAddress(@get:Schema(pattern = "^0x") val address: String)

    class LimitedAssets(@get:ArraySchema(maxItems = 1) val assets: List<String>)

    class FormattedAddress(@get:Schema(format = "email") val address: String)

    class NestedConstraint(val wallets: List<LimitedAmount>)

    class EnumAsset(val asset: Asset)

    class AllowedAsset(@get:Schema(allowableValues = ["ETH", "BTC"]) val asset: String)

    class ConstantAsset(@get:Schema(allowableValues = ["ETH"]) val asset: String)

    class KeywordFields(val maximum: String, val pattern: String, val maxItems: Int)

    private class WalletActions(private val network: String) {
        fun balance(args: Balance): Map<String, String> =
            mapOf("type" to "balance", "content" to args.asset, "network" to network)
    }

    @Test
    fun bindsApplicationActionWithoutExposingDependencies() {
        val wallet = WalletActions("test-network")
        val tool = AgentFunctionTool.of(Balance::class.java, wallet::balance)
        val definition = jsonMapper().valueToTree<JsonNode>(tool.definition().validate())
        SessionCreateParams.Agent.builder().addTool(tool.definition()).build().validate()
        assertThat(tool.definition().asFunction().parameters()._additionalProperties())
            .containsKey("properties")
        assertThat(tool.name()).isEqualTo("wallet_balance")
        assertThat(definition.path("type").asText()).isEqualTo("function")
        assertThat(definition.path("description").asText()).isEqualTo("Look up a wallet balance.")
        assertThat(definition.has("function")).isFalse()
        assertThat(
                definition.path("parameters").path("properties").fieldNames().asSequence().toList()
            )
            .containsExactly("asset")
        assertThat(definition.path("parameters").path("required").map { it.asText() })
            .containsExactly("asset")
        assertThat(definition.path("parameters").path("additionalProperties").asBoolean()).isFalse()
        assertThat(tool.handler().apply(mapOf("asset" to "ETH")))
            .isEqualTo(mapOf("type" to "balance", "content" to "ETH", "network" to "test-network"))
    }

    @Test
    fun supportsUnannotatedClassesAndAsyncStages() {
        val pending = CompletableFuture<String>()
        val tool =
            AgentFunctionTool.ofAsync(Lookup::class.java) { args ->
                assertThat(args.orderId).isEqualTo("A123")
                pending
            }
        assertThat(tool.name()).isEqualTo("Lookup")
        tool.definition().validate()
        assertThat(tool.handler().apply(mapOf("orderId" to "A123"))).isSameAs(pending)
    }

    @Test
    fun parsingFailsBeforeCallingApplication() {
        var invocations = 0
        val tool =
            AgentFunctionTool.of(Balance::class.java) {
                invocations++
                "unused"
            }
        for (arguments in listOf(emptyMap(), mapOf("asset" to emptyList<String>()))) {
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
        for (wallet in
            listOf(
                emptyMap(),
                mapOf("asset" to null),
                mapOf("asset" to 123),
                mapOf("asset" to "ETH", "extra" to true),
            )) {
            assertThatThrownBy {
                    tool.handler().apply(mapOf("wallet" to wallet, "others" to emptyList<Any>()))
                }
                .isInstanceOf(IllegalArgumentException::class.java)
            assertThatThrownBy {
                    tool
                        .handler()
                        .apply(
                            mapOf("wallet" to mapOf("asset" to "ETH"), "others" to listOf(wallet))
                        )
                }
                .isInstanceOf(IllegalArgumentException::class.java)
        }
        assertThat(invocations).isZero()
        tool
            .handler()
            .apply(
                mapOf(
                    "wallet" to mapOf("asset" to "ETH"),
                    "others" to listOf(mapOf("asset" to "BTC")),
                )
            )
        assertThat(invocations).isEqualTo(1)
    }

    @Test
    fun optionalArgumentsAllowExplicitNull() {
        val tool = AgentFunctionTool.of(OptionalFields::class.java) { it.asset.orElse("none") }
        assertThat(tool.handler().apply(mapOf("asset" to null))).isEqualTo("none")
        assertThat(tool.handler().apply(mapOf("asset" to "ETH"))).isEqualTo("ETH")
        assertThatThrownBy { tool.handler().apply(emptyMap()) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun rejectsParameterClassesThatCannotReceiveObjectArguments() {
        for (type in listOf(String::class.java, Array<String>::class.java, Asset::class.java)) {
            assertThatThrownBy { AgentFunctionTool.of(type) { "unused" } }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessageContaining("object class")
        }
    }

    @Test
    fun rejectsUnenforcedConstraintsBeforeBinding() {
        for (type in
            listOf(
                LimitedAmount::class.java,
                RestrictedAddress::class.java,
                LimitedAssets::class.java,
                FormattedAddress::class.java,
                NestedConstraint::class.java,
            )) {
            assertThatThrownBy { AgentFunctionTool.of(type) { "unused" } }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessageContaining("does not support schema constraint")
                .hasMessageContaining("validate it in your callback")
        }
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
            listOf(EnumAsset::class.java, AllowedAsset::class.java, ConstantAsset::class.java)) {
            val tool =
                AgentFunctionTool.of(type) {
                    invocations++
                    "valid"
                }
            assertThat(tool.handler().apply(mapOf("asset" to "ETH"))).isEqualTo("valid")
            assertThatThrownBy { tool.handler().apply(mapOf("asset" to "invalid")) }
                .hasMessageContaining("parameter shape")
        }
        assertThat(invocations).isEqualTo(3)
    }
}
