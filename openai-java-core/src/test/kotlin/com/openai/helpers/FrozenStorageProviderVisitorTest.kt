package com.openai.helpers

import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.models.admin.organization.auditlogs.AuditLogListResponse
import com.openai.models.admin.organization.externalstorage.ExternalStorageConfiguration
import com.openai.models.admin.organization.externalstorage.ExternalStorageCreateParams
import java.lang.reflect.Modifier
import java.lang.reflect.Proxy
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class FrozenStorageProviderVisitorTest {

    @ParameterizedTest
    @ValueSource(
        classes =
            [
                ExternalStorageConfiguration.Provider::class,
                ExternalStorageCreateParams.Provider::class,
                AuditLogListResponse.ExternalStorageRegistered.Data.Provider::class,
            ]
    )
    fun preservesPublishedCallbacksAndRoutesLaterProvidersToUnknown(provider: Class<*>) {
        val accept = provider.methods.single { it.name == "accept" }
        val visitorType = accept.parameterTypes.single()
        val abstractCallbacks = visitorType.methods.filter { Modifier.isAbstract(it.modifiers) }
        assertThat(abstractCallbacks.map { it.name })
            .containsExactlyInAnyOrder("visitAws", "visitAzure")

        val visitor =
            Proxy.newProxyInstance(visitorType.classLoader, arrayOf(visitorType)) { _, method, args
                ->
                if (method.name == "unknown") args.single() else method.name
            }
        val mapper = jsonMapper()
        for (type in listOf("aws", "azure", "gcp", "oci", "future")) {
            val json = """{"type":"$type","extra":{"keep":true}}"""
            val decoded = mapper.readValue(json, provider)
            if (type != "future") {
                val accessor = "is" + type.replaceFirstChar { it.uppercaseChar() }
                assertThat(provider.getMethod(accessor).invoke(decoded)).isEqualTo(true)
            }
            val expected =
                when (type) {
                    "aws" -> "visitAws"
                    "azure" -> "visitAzure"
                    else -> mapper.readValue(json, JsonValue::class.java)
                }
            assertThat(accept.invoke(decoded, visitor)).isEqualTo(expected)
        }
    }
}
