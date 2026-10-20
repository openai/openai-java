package com.openai.core

import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.admin.organization.projects.apikeys.ApiKeyUpdateParams
import java.util.Optional
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

/** The legacy typed expiry API is required even though the request's wire field is optional. */
internal class ApiKeyExpiryContractTest {
    private val mapper = jsonMapper()

    @Test
    fun outerAndBodyKeepPrimitiveGettersAndBoxedOptionalAliases() {
        for (type in listOf(ApiKeyUpdateParams::class.java, ApiKeyUpdateParams.Body::class.java)) {
            assertThat(type.getMethod("expiresInSeconds").returnType)
                .isEqualTo(Long::class.javaPrimitiveType)
            assertThat(type.getMethod("expiresInSecondsOptional").genericReturnType.typeName)
                .isEqualTo("java.util.Optional<java.lang.Long>")
            assertThat(type.getMethod("_expiresInSeconds").genericReturnType.typeName)
                .isEqualTo("com.openai.core.JsonField<java.lang.Long>")
        }
        for (type in
            listOf(
                ApiKeyUpdateParams.Builder::class.java,
                ApiKeyUpdateParams.Body.Builder::class.java,
            )) {
            assertThat(type.getMethod("expiresInSeconds", Long::class.javaPrimitiveType).returnType)
                .isEqualTo(type)
            assertThat(type.getMethod("expiresInSeconds", JsonField::class.java).returnType)
                .isEqualTo(type)
        }
    }

    @Test
    fun scopeOnlyBuildersLeaveExpiryMissingWithoutCallingItsSetter() {
        val params =
            ApiKeyUpdateParams.builder()
                .projectId("project_test")
                .addScope("api.files.read")
                .build()
        val body = ApiKeyUpdateParams.Body.builder().addScope("api.files.read").build()
        assertThat(params._body()).isEqualTo(body)
        assertThat(params._expiresInSeconds().isMissing()).isTrue()
        assertThat(body._expiresInSeconds().isMissing()).isTrue()
        assertThat(params.expiresInSecondsOptional()).isEmpty()
        assertThat(body.expiresInSecondsOptional()).isEmpty()
        assertInvalid("`expires_in_seconds` is not set") { params.expiresInSeconds() }
        assertInvalid("`expires_in_seconds` is not set") { body.expiresInSeconds() }
        assertThat(body.validate()).isSameAs(body)
        assertThat(body.isValid()).isTrue()
        assertThat(mapper.readTree(mapper.writeValueAsString(body)))
            .isEqualTo(mapper.readTree("""{"scopes":["api.files.read"]}"""))
    }

    @Test
    fun missingAndExplicitNullRemainDistinctWhileTheirOptionalAliasesAndValidationAcceptBoth() {
        for ((raw, diagnostic) in
            listOf(
                JsonMissing.of() to "`expires_in_seconds` is not set",
                JsonNull.of() to "`expires_in_seconds` is null",
            )) {
            val params =
                ApiKeyUpdateParams.builder()
                    .projectId("project_test")
                    .expiresInSeconds(raw)
                    .addScope("api.files.read")
                    .build()
            val body = params._body()
            assertThat(body._expiresInSeconds()).isEqualTo(raw)
            assertThat(params._expiresInSeconds()).isEqualTo(raw)
            assertThat(params.expiresInSecondsOptional()).isEmpty()
            assertThat(body.expiresInSecondsOptional()).isEmpty()
            assertInvalid(diagnostic) { params.expiresInSeconds() }
            assertInvalid(diagnostic) { body.expiresInSeconds() }
            // Preserve existing client validation, including its acceptance of explicit JSON null.
            assertThat(body.validate()).isSameAs(body)
            assertThat(body.isValid()).isTrue()
            val json = mapper.readTree(mapper.writeValueAsString(body))
            assertThat(json.path("scopes").get(0).asText()).isEqualTo("api.files.read")
            assertThat(json.has("expires_in_seconds")).isEqualTo(raw.isNull())
            if (raw.isNull()) assertThat(json.get("expires_in_seconds").isNull).isTrue()
            assertThat(
                    ApiKeyUpdateParams.Body.builder()
                        .expiresInSeconds(raw)
                        .addScope("api.files.read")
                        .build()
                )
                .isEqualTo(body)
        }
    }

    @Test
    fun wrongTypeIsPreservedAsRawJsonAndRejectedByTypedAccessAndValidation() {
        val raw = JsonValue.from("unexpected")
        val params =
            ApiKeyUpdateParams.builder().projectId("project_test").expiresInSeconds(raw).build()
        val body = params._body()
        val diagnostic = "`expires_in_seconds` is invalid, received unexpected"
        assertThat(params._expiresInSeconds().asString()).contains("unexpected")
        assertThat(body._expiresInSeconds()).isEqualTo(raw)
        assertInvalid(diagnostic) { params.expiresInSeconds() }
        assertInvalid(diagnostic) { body.expiresInSeconds() }
        assertInvalid(diagnostic) { params.expiresInSecondsOptional() }
        assertInvalid(diagnostic) { body.expiresInSecondsOptional() }
        assertInvalid(diagnostic) { body.validate() }
        assertThat(body.isValid()).isFalse()
        assertThat(
                mapper.readTree(mapper.writeValueAsString(body)).get("expires_in_seconds").asText()
            )
            .isEqualTo("unexpected")
        assertThat(ApiKeyUpdateParams.Body.builder().expiresInSeconds(raw).build()).isEqualTo(body)
    }

    @Test
    fun numericBoundariesKeepTheirExistingValuesWithoutClientSideRangeValidation() {
        for (value in listOf(60L, 0L, -1L, Long.MIN_VALUE, Long.MAX_VALUE)) {
            val params =
                ApiKeyUpdateParams.builder()
                    .projectId("project_test")
                    .expiresInSeconds(value)
                    .build()
            val body = params._body()
            val outer: Long = params.expiresInSeconds()
            val inner: Long = body.expiresInSeconds()
            val alias: Optional<Long> = params.expiresInSecondsOptional()
            assertThat(outer).isEqualTo(value)
            assertThat(inner).isEqualTo(value)
            assertThat(alias).contains(value)
            assertThat(body.expiresInSecondsOptional()).contains(value)
            assertThat(body.validate()).isSameAs(body)
            assertThat(body.isValid()).isTrue()
            assertThat(params.toBuilder().expiresInSeconds(JsonField.of(value)).build())
                .isEqualTo(params)
            assertThat(ApiKeyUpdateParams.Body.builder().expiresInSeconds(value).build())
                .isEqualTo(body)
            assertThat(body.toBuilder().expiresInSeconds(JsonField.of(value)).build())
                .isEqualTo(body)
            assertThat(
                    mapper
                        .readTree(mapper.writeValueAsString(body))
                        .get("expires_in_seconds")
                        .longValue()
                )
                .isEqualTo(value)
        }
    }

    @Test
    fun jsonRoundTripsPreserveOmissionNullUnknownFieldsAndWrongTypes() {
        for (json in
            listOf(
                """{"scopes":["api.files.read"]}""",
                """{"expires_in_seconds":null,"scopes":[]}""",
                """{"expires_in_seconds":"unexpected","future":{"mode":"test"}}""",
                """{"expires_in_seconds":60,"future":[1,2]}""",
            )) {
            val body = mapper.readValue(json, ApiKeyUpdateParams.Body::class.java)
            assertThat(mapper.readTree(mapper.writeValueAsString(body)))
                .isEqualTo(mapper.readTree(json))
            val copy = body.toBuilder().build()
            assertThat(copy).isEqualTo(body).hasSameHashCodeAs(body)
            assertThat(copy.toString()).isEqualTo(body.toString())
            assertThat(copy._expiresInSeconds()).isEqualTo(body._expiresInSeconds())
            assertThat(copy._additionalProperties()).isEqualTo(body._additionalProperties())
        }
    }

    @Test
    fun builderCopiesPreserveRawExpiryAndDoNotShareMutableCollections() {
        val builder =
            ApiKeyUpdateParams.builder()
                .projectId("project_test")
                .expiresInSeconds(JsonValue.from("unexpected"))
                .addScope("api.files.read")
                .putAdditionalBodyProperty("future", JsonValue.from("original"))
        val original = builder.build()
        val copy = original.toBuilder().build()
        assertThat(copy).isEqualTo(original).hasSameHashCodeAs(original)
        assertThat(copy._expiresInSeconds()).isEqualTo(original._expiresInSeconds())
        assertThat(copy.toString()).isEqualTo(original.toString())
        builder
            .expiresInSeconds(60L)
            .addScope("api.all.read")
            .putAdditionalBodyProperty("future", JsonValue.from("changed"))
        val changed = copy.toBuilder().expiresInSeconds(90L).addScope("api.all.read").build()
        assertThat(original._expiresInSeconds().asString()).contains("unexpected")
        assertThat(original.scopes().get()).containsExactly("api.files.read")
        assertThat(original._additionalBodyProperties()["future"])
            .isEqualTo(JsonValue.from("original"))
        assertThat(copy).isEqualTo(original)
        assertThat(changed.expiresInSeconds()).isEqualTo(90L)
        assertThat(changed.scopes().get()).containsExactly("api.files.read", "api.all.read")
    }

    private fun assertInvalid(diagnostic: String, action: () -> Any?) {
        assertThatThrownBy { action() }
            .isInstanceOf(OpenAIInvalidDataException::class.java)
            .hasMessage(diagnostic)
    }
}
