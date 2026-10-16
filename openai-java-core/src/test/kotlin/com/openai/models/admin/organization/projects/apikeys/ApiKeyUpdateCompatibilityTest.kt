package com.openai.models.admin.organization.projects.apikeys

import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

internal class ApiKeyUpdateCompatibilityTest {
    private fun builder() = ApiKeyUpdateParams.builder().projectId("proj_test").apiKeyId("key_test")

    @Test
    fun expiryOnlyRetainsPrimitiveGettersAndWireBody() {
        val params = builder().expiresInSeconds(3600L).build()
        val ttl: Long = params.expiresInSeconds()
        val bodyTtl: Long = params._body().expiresInSeconds()
        assertThat(ttl).isEqualTo(3600L)
        assertThat(bodyTtl).isEqualTo(3600L)
        assertThat(params.expiresInSecondsOptional()).contains(3600L)
        assertThat(params._body().expiresInSecondsOptional()).contains(3600L)
        assertThat(ApiKeyUpdateParams::class.java.getMethod("expiresInSeconds").returnType)
            .isEqualTo(java.lang.Long.TYPE)
        assertThat(ApiKeyUpdateParams.Body::class.java.getMethod("expiresInSeconds").returnType)
            .isEqualTo(java.lang.Long.TYPE)
        assertThat(jsonMapper().readTree(jsonMapper().writeValueAsString(params._body())))
            .isEqualTo(jsonMapper().readTree("""{"expires_in_seconds":3600}"""))
        params._body().validate()
    }

    @Test
    fun scopeOnlyValidatesWithoutSendingExpiry() {
        val params = builder().addScope("api.all.read").build()
        params._body().validate()
        assertThat(params.expiresInSecondsOptional()).isEmpty()
        assertThat(params._body().expiresInSecondsOptional()).isEmpty()
        assertThatThrownBy { params.expiresInSeconds() }
            .isInstanceOf(OpenAIInvalidDataException::class.java)
        assertThatThrownBy { params._body().expiresInSeconds() }
            .isInstanceOf(OpenAIInvalidDataException::class.java)
        assertThat(jsonMapper().readTree(jsonMapper().writeValueAsString(params._body())))
            .isEqualTo(jsonMapper().readTree("""{"scopes":["api.all.read"]}"""))
    }

    @Test
    fun emptyScopesAndCombinedUpdatesPreserveWireValues() {
        val scopesOnly = builder().scopes(listOf()).build()
        scopesOnly._body().validate()
        assertThat(jsonMapper().readTree(jsonMapper().writeValueAsString(scopesOnly._body())))
            .isEqualTo(jsonMapper().readTree("""{"scopes":[]}"""))
        val combined = scopesOnly.toBuilder().expiresInSeconds(60L).build()
        combined._body().validate()
        assertThat(combined.expiresInSeconds()).isEqualTo(60L)
        assertThat(jsonMapper().readTree(jsonMapper().writeValueAsString(combined._body())))
            .isEqualTo(jsonMapper().readTree("""{"expires_in_seconds":60,"scopes":[]}"""))
    }

    @Test
    fun optionalValidationStillRejectsInvalidExpiryTypes() {
        val params = builder().expiresInSeconds(JsonValue.from("invalid")).build()
        assertThatThrownBy { params._body().validate() }
            .isInstanceOf(OpenAIInvalidDataException::class.java)
        assertThatThrownBy { params.expiresInSecondsOptional() }
            .isInstanceOf(OpenAIInvalidDataException::class.java)
    }
}
