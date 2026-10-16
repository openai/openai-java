package com.openai.models.admin.organization.projects.apikeys

import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

internal class ApiKeyUpdateScopeBuilderTest {
    private fun builder() = ApiKeyUpdateParams.builder().projectId("proj_test").apiKeyId("key_test")

    @Test
    fun appendToCopiedExpiryOnlyParams() {
        val original = builder().expiresInSeconds(60L).build()
        val updated = original.toBuilder().addScope("api.all.read").build()

        assertThat(original._body()._scopes().isMissing()).isTrue()
        assertCombinedUpdate(updated)
    }

    @Test
    fun appendToSuppliedExpiryOnlyBody() {
        val original = ApiKeyUpdateParams.Body.builder().expiresInSeconds(60L).build()
        val updated = builder().body(original).addScope("api.all.read").build()

        assertThat(original._scopes().isMissing()).isTrue()
        assertCombinedUpdate(updated)
    }

    @Test
    fun copiedEmptyScopesStayPresentAndCanBeAppended() {
        val original = builder().expiresInSeconds(60L).scopes(emptyList()).build()
        val copied = original.toBuilder().build()
        assertThat(jsonMapper().readTree(jsonMapper().writeValueAsString(copied._body())))
            .isEqualTo(jsonMapper().readTree("""{"expires_in_seconds":60,"scopes":[]}"""))

        assertCombinedUpdate(original.toBuilder().addScope("api.all.read").build())
        assertCombinedUpdate(builder().body(original._body()).addScope("api.all.read").build())
        assertThat(original.scopes()).contains(emptyList())
    }

    @Test
    fun copiedNullScopesRemainNullAndRejectAppend() {
        val original = builder().expiresInSeconds(60L).scopes(JsonValue.from(null)).build()
        assertThat(original.toBuilder().build()._body()._scopes().isNull()).isTrue()
        assertThat(builder().body(original._body()).build()._body()._scopes().isNull()).isTrue()
        assertThatThrownBy { original.toBuilder().addScope("api.all.read") }
            .isInstanceOf(IllegalStateException::class.java)
        assertThatThrownBy { builder().body(original._body()).addScope("api.all.read") }
            .isInstanceOf(IllegalStateException::class.java)
    }

    @Test
    fun copiedIncompatibleScopesRejectAppend() {
        val original = builder().expiresInSeconds(60L).scopes(JsonValue.from("invalid")).build()
        assertThatThrownBy { original.toBuilder().addScope("api.all.read") }
            .isInstanceOf(IllegalStateException::class.java)
        assertThatThrownBy { builder().body(original._body()).addScope("api.all.read") }
            .isInstanceOf(IllegalStateException::class.java)
    }

    private fun assertCombinedUpdate(params: ApiKeyUpdateParams) {
        params._body().validate()
        assertThat(params.expiresInSeconds()).isEqualTo(60L)
        assertThat(params._body().expiresInSeconds()).isEqualTo(60L)
        assertThat(jsonMapper().readTree(jsonMapper().writeValueAsString(params._body())))
            .isEqualTo(
                jsonMapper().readTree("""{"expires_in_seconds":60,"scopes":["api.all.read"]}""")
            )
    }
}
