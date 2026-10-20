// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.core.http

import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.MultipartField
import com.openai.core.jsonMapper
import java.io.ByteArrayOutputStream
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MultipartEncodingTest {
    @Test
    fun typedPartsPreserveJsonNullAndOmission() {
        val mapper = jsonMapper()
        val offer = "v=0\r\ns=Unicode π\r\n"
        val encodings =
            mapOf(
                "offer" to ("application/sdp" to false),
                "settings" to ("application/json" to true),
            )
        for (settings in
            listOf(
                JsonValue.from(mapOf("future" to listOf(false, null, "π"))),
                JsonValue.from(null),
                JsonMissing.of(),
            )) {
            val fields =
                encodeMultipartFields(
                    mapper,
                    mapOf(
                        "offer" to MultipartField.of(offer),
                        "settings" to MultipartField.of(settings),
                    ),
                    encodings,
                )
            val body = multipartFormData(mapper, fields)
            val output = ByteArrayOutputStream()
            body.writeTo(output)
            val wire = output.toString("UTF-8")
            assertThat(wire).contains("Content-Type: application/sdp\r\n\r\n$offer\r\n")
            assertThat(wire).doesNotContain("filename=")
            if (settings.isMissing()) {
                assertThat(fields).doesNotContainKey("settings")
            } else {
                assertThat(wire).contains("Content-Type: application/json")
                assertThat(
                        mapper.readTree(fields.getValue("settings").value.asKnown().get() as String)
                    )
                    .isEqualTo(
                        mapper.valueToTree<com.fasterxml.jackson.databind.JsonNode>(settings)
                    )
            }
            assertThat(body.repeatable()).isTrue()
            assertThat(body.contentLength()).isEqualTo(output.size().toLong())
            val retry = ByteArrayOutputStream()
            body.writeTo(retry)
            assertThat(retry.toByteArray()).isEqualTo(output.toByteArray())
        }
    }
}
