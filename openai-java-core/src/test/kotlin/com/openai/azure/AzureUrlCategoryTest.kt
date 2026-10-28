package com.openai.azure

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AzureUrlCategoryTest {
    @Test
    fun autoUsesThePathBeforeQueryAndFragment() {
        for (host in
            listOf(
                "region.openai.azure.com",
                "region.services.ai.azure.com",
                "region.azure-api.net",
                "region.cognitiveservices.azure.com",
            )) {
            for (suffix in listOf("?tenant=base", "/?api-version=fixture", "/#region")) {
                val url = "https://$host/openai/v1$suffix"
                assertThat(AzureUrlCategory.categorizeBaseUrl(url, AzureUrlPathMode.AUTO))
                    .isEqualTo(AzureUrlCategory.AZURE_UNIFIED)
                assertThat(AzureUrlCategory.categorizeBaseUrl(url, AzureUrlPathMode.LEGACY))
                    .isEqualTo(AzureUrlCategory.AZURE_LEGACY)
            }
            for (suffix in listOf("?next=/openai/v1", "#/openai/v1")) {
                assertThat(
                        AzureUrlCategory.categorizeBaseUrl(
                            "https://$host/openai$suffix",
                            AzureUrlPathMode.AUTO,
                        )
                    )
                    .isEqualTo(AzureUrlCategory.AZURE_UNIFIED)
            }
            assertThat(
                    AzureUrlCategory.categorizeBaseUrl(
                        "https://$host/openai/openai%2fv1",
                        AzureUrlPathMode.AUTO,
                    )
                )
                .isEqualTo(AzureUrlCategory.AZURE_LEGACY)
        }
        assertThat(
                AzureUrlCategory.categorizeBaseUrl(
                    "https://region.openai.azure.com.example/openai/v1?tenant=base",
                    AzureUrlPathMode.AUTO,
                )
            )
            .isEqualTo(AzureUrlCategory.NON_AZURE)
    }

    @Test
    fun isAzure() {
        assertThat(AzureUrlCategory.AZURE_LEGACY.isAzure()).isTrue()
        assertThat(AzureUrlCategory.AZURE_UNIFIED.isAzure()).isTrue()
        assertThat(AzureUrlCategory.NON_AZURE.isAzure()).isFalse()
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
