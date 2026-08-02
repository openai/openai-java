// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.usage

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class UsageCostsResponseTest {

    @Test
    fun parsesStringEncodedCostAmounts() {
        val response =
            jsonMapper()
                .readValue(
                    """
                    {
                      "data": [
                        {
                          "end_time": 1,
                          "results": [
                            {
                              "object": "organization.costs.result",
                              "amount": {"value": "0E-6176", "currency": "usd"}
                            },
                            {
                              "object": "organization.costs.result",
                              "amount": {
                                "value": "0.003627500000000000000000000000000000",
                                "currency": "usd"
                              }
                            }
                          ],
                          "start_time": 0
                        }
                      ],
                      "has_more": false,
                      "object": "page"
                    }
                    """
                        .trimIndent(),
                    jacksonTypeRef<UsageCostsResponse>(),
                )

        val amounts =
            response.data().single().results().map {
                it.asOrganizationCosts().amount().get().value().get()
            }

        assertThat(amounts).containsExactly(0.0, 0.0036275)
    }

    @ParameterizedTest
    @ValueSource(strings = ["not-a-number", "1f", "0x1.0p0", " 1 ", "01", "+1"])
    fun rejectsInvalidStringEncodedCostAmount(invalidValue: String) {
        val response =
            jsonMapper()
                .readValue(
                    """
                    {
                      "data": [
                        {
                          "end_time": 1,
                          "results": [
                            {
                              "object": "organization.costs.result",
                              "amount": {"value": "$invalidValue", "currency": "usd"}
                            }
                          ],
                          "start_time": 0
                        }
                      ],
                      "has_more": false,
                      "object": "page"
                    }
                    """
                        .trimIndent(),
                    jacksonTypeRef<UsageCostsResponse>(),
                )

        val amount =
            response.data().single().results().single().asOrganizationCosts().amount().get()

        assertThatThrownBy { amount.value() }.isInstanceOf(OpenAIInvalidDataException::class.java)
    }

    @Test
    fun create() {
        val usageCostsResponse =
            UsageCostsResponse.builder()
                .addData(
                    UsageCostsResponse.Data.builder()
                        .endTime(0L)
                        .addResult(
                            UsageCostsResponse.Data.Result.OrganizationUsageCompletionsResult
                                .builder()
                                .inputTokens(0L)
                                .numModelRequests(0L)
                                .outputTokens(0L)
                                .apiKeyId("api_key_id")
                                .batch(true)
                                .inputAudioTokens(0L)
                                .inputCacheWriteTokens(0L)
                                .inputCachedAudioTokens(0L)
                                .inputCachedImageTokens(0L)
                                .inputCachedTextTokens(0L)
                                .inputCachedTokens(0L)
                                .inputImageTokens(0L)
                                .inputTextTokens(0L)
                                .inputUncachedTokens(0L)
                                .model("model")
                                .outputAudioTokens(0L)
                                .outputImageTokens(0L)
                                .outputTextTokens(0L)
                                .projectId("project_id")
                                .serviceTier("service_tier")
                                .userId("user_id")
                                .build()
                        )
                        .startTime(0L)
                        .build()
                )
                .hasMore(true)
                .nextPage("next_page")
                .build()

        assertThat(usageCostsResponse.data())
            .containsExactly(
                UsageCostsResponse.Data.builder()
                    .endTime(0L)
                    .addResult(
                        UsageCostsResponse.Data.Result.OrganizationUsageCompletionsResult.builder()
                            .inputTokens(0L)
                            .numModelRequests(0L)
                            .outputTokens(0L)
                            .apiKeyId("api_key_id")
                            .batch(true)
                            .inputAudioTokens(0L)
                            .inputCacheWriteTokens(0L)
                            .inputCachedAudioTokens(0L)
                            .inputCachedImageTokens(0L)
                            .inputCachedTextTokens(0L)
                            .inputCachedTokens(0L)
                            .inputImageTokens(0L)
                            .inputTextTokens(0L)
                            .inputUncachedTokens(0L)
                            .model("model")
                            .outputAudioTokens(0L)
                            .outputImageTokens(0L)
                            .outputTextTokens(0L)
                            .projectId("project_id")
                            .serviceTier("service_tier")
                            .userId("user_id")
                            .build()
                    )
                    .startTime(0L)
                    .build()
            )
        assertThat(usageCostsResponse.hasMore()).isEqualTo(true)
        assertThat(usageCostsResponse.nextPage()).contains("next_page")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val usageCostsResponse =
            UsageCostsResponse.builder()
                .addData(
                    UsageCostsResponse.Data.builder()
                        .endTime(0L)
                        .addResult(
                            UsageCostsResponse.Data.Result.OrganizationUsageCompletionsResult
                                .builder()
                                .inputTokens(0L)
                                .numModelRequests(0L)
                                .outputTokens(0L)
                                .apiKeyId("api_key_id")
                                .batch(true)
                                .inputAudioTokens(0L)
                                .inputCacheWriteTokens(0L)
                                .inputCachedAudioTokens(0L)
                                .inputCachedImageTokens(0L)
                                .inputCachedTextTokens(0L)
                                .inputCachedTokens(0L)
                                .inputImageTokens(0L)
                                .inputTextTokens(0L)
                                .inputUncachedTokens(0L)
                                .model("model")
                                .outputAudioTokens(0L)
                                .outputImageTokens(0L)
                                .outputTextTokens(0L)
                                .projectId("project_id")
                                .serviceTier("service_tier")
                                .userId("user_id")
                                .build()
                        )
                        .startTime(0L)
                        .build()
                )
                .hasMore(true)
                .nextPage("next_page")
                .build()

        val roundtrippedUsageCostsResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(usageCostsResponse),
                jacksonTypeRef<UsageCostsResponse>(),
            )

        assertThat(roundtrippedUsageCostsResponse).isEqualTo(usageCostsResponse)
    }
}
