package com.openai.azure

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class AzureUrlCategoryTest {

    @Test
    fun isAzure() {
        assertThat(AzureUrlCategory.AZURE_LEGACY.isAzure()).isTrue()
        assertThat(AzureUrlCategory.AZURE_UNIFIED.isAzure()).isTrue()
        assertThat(AzureUrlCategory.BEDROCK.isAzure()).isFalse()
        assertThat(AzureUrlCategory.NON_AZURE.isAzure()).isFalse()
    }

    @ParameterizedTest
    @ValueSource(
        strings =
            [
                "bedrock-mantle.us-east-1.api.aws",
                "BEDROCK-MANTLE.US-EAST-1.API.AWS.",
                "bedrock-runtime.us-east-1.amazonaws.com",
                "bedrock-runtime-fips.us-east-1.api.aws",
                "bedrock-runtime.eusc-de-east-1.amazonaws.eu",
                "bedrock-runtime-fips.eusc-de-east-1.api.amazonwebservices.eu",
                "bedrock-runtime.cn-north-1.api.amazonwebservices.com.cn",
                "bedrock-runtime.us-iso-east-1.c2s.ic.gov",
                "bedrock-runtime.us-isob-east-1.sc2s.sgov.gov",
                "bedrock-runtime.eu-isoe-west-1.cloud.adc-e.uk",
                "bedrock-runtime.us-isof-south-1.csp.hci.ic.gov",
            ]
    )
    fun categorizeBaseUrl_recognizesCanonicalBedrockEndpoints(host: String) {
        assertThat(
                AzureUrlCategory.categorizeBaseUrl("https://$host/openai/v1", AzureUrlPathMode.AUTO)
            )
            .isEqualTo(AzureUrlCategory.BEDROCK)
    }

    @Test
    fun categorizeBaseUrl_preservesCustomBedrockNamedGateway() {
        assertThat(
                AzureUrlCategory.categorizeBaseUrl(
                    "https://bedrock-runtime.us-east-1.customer.example/openai/v1",
                    AzureUrlPathMode.AUTO,
                )
            )
            .isEqualTo(AzureUrlCategory.NON_AZURE)
    }

    @Test
    fun categorizeBaseUrl_knownHosts() {
        // known legacy endpoint - no trailing slash - force configuration
        assertThat(
                AzureUrlCategory.categorizeBaseUrl(
                    "https://region.openai.azure.com",
                    AzureUrlPathMode.LEGACY,
                )
            )
            .isEqualTo(AzureUrlCategory.AZURE_LEGACY)

        assertThat(
                AzureUrlCategory.categorizeBaseUrl(
                    "https://region.openai.azure.com",
                    AzureUrlPathMode.UNIFIED,
                )
            )
            .isEqualTo(AzureUrlCategory.AZURE_UNIFIED)

        assertThat(
                AzureUrlCategory.categorizeBaseUrl(
                    "https://region.openai.azure.com",
                    AzureUrlPathMode.AUTO,
                )
            )
            .isEqualTo(AzureUrlCategory.AZURE_LEGACY)

        // known legacy endpoint - trailing slash - force configuration
        assertThat(
                AzureUrlCategory.categorizeBaseUrl(
                    "https://region.openai.azure.com/",
                    AzureUrlPathMode.LEGACY,
                )
            )
            .isEqualTo(AzureUrlCategory.AZURE_LEGACY)
        assertThat(
                AzureUrlCategory.categorizeBaseUrl(
                    "https://region.openai.azure.com/",
                    AzureUrlPathMode.UNIFIED,
                )
            )
            .isEqualTo(AzureUrlCategory.AZURE_UNIFIED)
        assertThat(
                AzureUrlCategory.categorizeBaseUrl(
                    "https://region.openai.azure.com/",
                    AzureUrlPathMode.AUTO,
                )
            )
            .isEqualTo(AzureUrlCategory.AZURE_LEGACY)

        // known unified endpoint -  forced into legacy - no trailing slash
        assertThat(
                AzureUrlCategory.categorizeBaseUrl(
                    "https://region.openai.azure.com/openai/v1",
                    AzureUrlPathMode.LEGACY,
                )
            )
            .isEqualTo(AzureUrlCategory.AZURE_LEGACY)
        assertThat(
                AzureUrlCategory.categorizeBaseUrl(
                    "https://region.openai.azure.com/openai/v1",
                    AzureUrlPathMode.UNIFIED,
                )
            )
            .isEqualTo(AzureUrlCategory.AZURE_UNIFIED)
        assertThat(
                AzureUrlCategory.categorizeBaseUrl(
                    "https://region.openai.azure.com/openai/v1",
                    AzureUrlPathMode.AUTO,
                )
            )
            .isEqualTo(AzureUrlCategory.AZURE_UNIFIED)

        // known legacy endpoint - forced into unified - no trailing slash
        assertThat(
                AzureUrlCategory.categorizeBaseUrl(
                    "https://region.services.ai.azure.com",
                    AzureUrlPathMode.LEGACY,
                )
            )
            .isEqualTo(AzureUrlCategory.AZURE_LEGACY)
        assertThat(
                AzureUrlCategory.categorizeBaseUrl(
                    "https://region.services.ai.azure.com",
                    AzureUrlPathMode.UNIFIED,
                )
            )
            .isEqualTo(AzureUrlCategory.AZURE_UNIFIED)
        assertThat(
                AzureUrlCategory.categorizeBaseUrl(
                    "https://region.services.ai.azure.com",
                    AzureUrlPathMode.AUTO,
                )
            )
            .isEqualTo(AzureUrlCategory.AZURE_LEGACY)

        // known legacy endpoint - forced into unified - trailing slash
        assertThat(
                AzureUrlCategory.categorizeBaseUrl(
                    "https://region.services.ai.azure.com/",
                    AzureUrlPathMode.LEGACY,
                )
            )
            .isEqualTo(AzureUrlCategory.AZURE_LEGACY)
        assertThat(
                AzureUrlCategory.categorizeBaseUrl(
                    "https://region.services.ai.azure.com/",
                    AzureUrlPathMode.UNIFIED,
                )
            )
            .isEqualTo(AzureUrlCategory.AZURE_UNIFIED)
        assertThat(
                AzureUrlCategory.categorizeBaseUrl(
                    "https://region.services.ai.azure.com/",
                    AzureUrlPathMode.AUTO,
                )
            )
            .isEqualTo(AzureUrlCategory.AZURE_LEGACY)

        // known unified endpoint - forced into legacy - no trailing slash
        assertThat(
                AzureUrlCategory.categorizeBaseUrl(
                    "https://region.services.ai.azure.com/openai/v1",
                    AzureUrlPathMode.LEGACY,
                )
            )
            .isEqualTo(AzureUrlCategory.AZURE_LEGACY)
        assertThat(
                AzureUrlCategory.categorizeBaseUrl(
                    "https://region.services.ai.azure.com/openai/v1",
                    AzureUrlPathMode.UNIFIED,
                )
            )
            .isEqualTo(AzureUrlCategory.AZURE_UNIFIED)
        assertThat(
                AzureUrlCategory.categorizeBaseUrl(
                    "https://region.services.ai.azure.com/openai/v1",
                    AzureUrlPathMode.AUTO,
                )
            )
            .isEqualTo(AzureUrlCategory.AZURE_UNIFIED)

        // known legacy endpoint - no trailing slash
        assertThat(
                AzureUrlCategory.categorizeBaseUrl(
                    "https://region.azure-api.net",
                    AzureUrlPathMode.LEGACY,
                )
            )
            .isEqualTo(AzureUrlCategory.AZURE_LEGACY)
        assertThat(
                AzureUrlCategory.categorizeBaseUrl(
                    "https://region.azure-api.net",
                    AzureUrlPathMode.UNIFIED,
                )
            )
            .isEqualTo(AzureUrlCategory.AZURE_UNIFIED)
        assertThat(
                AzureUrlCategory.categorizeBaseUrl(
                    "https://region.azure-api.net",
                    AzureUrlPathMode.AUTO,
                )
            )
            .isEqualTo(AzureUrlCategory.AZURE_LEGACY)

        // known legacy endpoint - trailing slash
        assertThat(
                AzureUrlCategory.categorizeBaseUrl(
                    "https://region.azure-api.net/",
                    AzureUrlPathMode.LEGACY,
                )
            )
            .isEqualTo(AzureUrlCategory.AZURE_LEGACY)
        assertThat(
                AzureUrlCategory.categorizeBaseUrl(
                    "https://region.azure-api.net/",
                    AzureUrlPathMode.UNIFIED,
                )
            )
            .isEqualTo(AzureUrlCategory.AZURE_UNIFIED)
        assertThat(
                AzureUrlCategory.categorizeBaseUrl(
                    "https://region.azure-api.net/",
                    AzureUrlPathMode.AUTO,
                )
            )
            .isEqualTo(AzureUrlCategory.AZURE_LEGACY)

        // known unified endpoint - no trailing slash
        assertThat(
                AzureUrlCategory.categorizeBaseUrl(
                    "https://region.azure-api.net/openai/v1",
                    AzureUrlPathMode.LEGACY,
                )
            )
            .isEqualTo(AzureUrlCategory.AZURE_LEGACY)
        assertThat(
                AzureUrlCategory.categorizeBaseUrl(
                    "https://region.azure-api.net/openai/v1",
                    AzureUrlPathMode.UNIFIED,
                )
            )
            .isEqualTo(AzureUrlCategory.AZURE_UNIFIED)
        assertThat(
                AzureUrlCategory.categorizeBaseUrl(
                    "https://region.azure-api.net/openai/v1",
                    AzureUrlPathMode.AUTO,
                )
            )
            .isEqualTo(AzureUrlCategory.AZURE_UNIFIED)

        // known legacy endpoint - no trailing slash
        assertThat(
                AzureUrlCategory.categorizeBaseUrl(
                    "https://region.cognitiveservices.azure.com",
                    AzureUrlPathMode.LEGACY,
                )
            )
            .isEqualTo(AzureUrlCategory.AZURE_LEGACY)
        assertThat(
                AzureUrlCategory.categorizeBaseUrl(
                    "https://region.cognitiveservices.azure.com",
                    AzureUrlPathMode.UNIFIED,
                )
            )
            .isEqualTo(AzureUrlCategory.AZURE_UNIFIED)
        assertThat(
                AzureUrlCategory.categorizeBaseUrl(
                    "https://region.cognitiveservices.azure.com",
                    AzureUrlPathMode.AUTO,
                )
            )
            .isEqualTo(AzureUrlCategory.AZURE_LEGACY)

        // known unified endpoint - trailing slash
        assertThat(
                AzureUrlCategory.categorizeBaseUrl(
                    "https://region.cognitiveservices.azure.com/",
                    AzureUrlPathMode.LEGACY,
                )
            )
            .isEqualTo(AzureUrlCategory.AZURE_LEGACY)
        assertThat(
                AzureUrlCategory.categorizeBaseUrl(
                    "https://region.cognitiveservices.azure.com/",
                    AzureUrlPathMode.UNIFIED,
                )
            )
            .isEqualTo(AzureUrlCategory.AZURE_UNIFIED)
        assertThat(
                AzureUrlCategory.categorizeBaseUrl(
                    "https://region.cognitiveservices.azure.com/",
                    AzureUrlPathMode.AUTO,
                )
            )
            .isEqualTo(AzureUrlCategory.AZURE_LEGACY)

        // known unified endpoint - no trailing slash
        assertThat(
                AzureUrlCategory.categorizeBaseUrl(
                    "https://region.cognitiveservices.azure.com/openai/v1",
                    AzureUrlPathMode.LEGACY,
                )
            )
            .isEqualTo(AzureUrlCategory.AZURE_LEGACY)
        assertThat(
                AzureUrlCategory.categorizeBaseUrl(
                    "https://region.cognitiveservices.azure.com/openai/v1",
                    AzureUrlPathMode.UNIFIED,
                )
            )
            .isEqualTo(AzureUrlCategory.AZURE_UNIFIED)
        assertThat(
                AzureUrlCategory.categorizeBaseUrl(
                    "https://region.cognitiveservices.azure.com/openai/v1",
                    AzureUrlPathMode.AUTO,
                )
            )
            .isEqualTo(AzureUrlCategory.AZURE_UNIFIED)
    }

    @Test
    fun categorizeBaseUrl_otherUrls() {
        assertThat(
                AzureUrlCategory.categorizeBaseUrl("https://example.com", AzureUrlPathMode.LEGACY)
            )
            .isEqualTo(AzureUrlCategory.AZURE_LEGACY)
        assertThat(
                AzureUrlCategory.categorizeBaseUrl("https://example.com", AzureUrlPathMode.UNIFIED)
            )
            .isEqualTo(AzureUrlCategory.AZURE_UNIFIED)
        assertThat(AzureUrlCategory.categorizeBaseUrl("https://example.com", AzureUrlPathMode.AUTO))
            .isEqualTo(AzureUrlCategory.NON_AZURE)

        assertThat(
                AzureUrlCategory.categorizeBaseUrl("https://example.com/", AzureUrlPathMode.LEGACY)
            )
            .isEqualTo(AzureUrlCategory.AZURE_LEGACY)
        assertThat(
                AzureUrlCategory.categorizeBaseUrl("https://example.com/", AzureUrlPathMode.UNIFIED)
            )
            .isEqualTo(AzureUrlCategory.AZURE_UNIFIED)
        assertThat(
                AzureUrlCategory.categorizeBaseUrl("https://example.com/", AzureUrlPathMode.AUTO)
            )
            .isEqualTo(AzureUrlCategory.NON_AZURE)

        assertThat(
                AzureUrlCategory.categorizeBaseUrl(
                    "https://example.com/openai/v1",
                    AzureUrlPathMode.LEGACY,
                )
            )
            .isEqualTo(AzureUrlCategory.AZURE_LEGACY)
        assertThat(
                AzureUrlCategory.categorizeBaseUrl(
                    "https://example.com/openai/v1",
                    AzureUrlPathMode.UNIFIED,
                )
            )
            .isEqualTo(AzureUrlCategory.AZURE_UNIFIED)
        assertThat(
                AzureUrlCategory.categorizeBaseUrl(
                    "https://example.com/openai/v1",
                    AzureUrlPathMode.AUTO,
                )
            )
            .isEqualTo(AzureUrlCategory.NON_AZURE)
    }
}
