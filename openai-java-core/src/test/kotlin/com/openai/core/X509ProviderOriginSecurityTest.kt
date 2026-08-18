package com.openai.core

import com.openai.auth.WorkloadIdentity
import com.openai.core.http.HttpClient
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.never
import org.mockito.kotlin.verify

internal class X509ProviderOriginSecurityTest {

    @ParameterizedTest
    @ValueSource(
        strings =
            [
                "https://bedrock-mantle.us-east-1.api.aws/openai/v1",
                "https://BEDROCK-MANTLE.US-EAST-1.API.AWS./openai/v1",
                "https://bedrock-runtime.us-east-1.amazonaws.com/openai/v1",
                "https://bedrock-runtime-fips.us-east-1.amazonaws.com/openai/v1",
                "https://bedrock-runtime.us-east-1.api.aws/openai/v1",
                "https://bedrock-runtime-fips.us-east-1.api.aws/openai/v1",
                "https://bedrock-runtime.eusc-de-east-1.amazonaws.eu/openai/v1",
                "https://bedrock-runtime-fips.eusc-de-east-1.api.amazonwebservices.eu/openai/v1",
                "https://bedrock-runtime.cn-north-1.amazonaws.com.cn/openai/v1",
                "https://bedrock-runtime.cn-north-1.api.amazonwebservices.com.cn/openai/v1",
                "https://bedrock-runtime.us-iso-east-1.c2s.ic.gov/openai/v1",
                "https://bedrock-runtime.us-isob-east-1.sc2s.sgov.gov/openai/v1",
                "https://bedrock-runtime.eu-isoe-west-1.cloud.adc-e.uk/openai/v1",
                "https://bedrock-runtime.us-isof-south-1.csp.hci.ic.gov/openai/v1",
                "https://bedrock-runtime.us-east-1.amazonaws.com.:443/openai/v1",
            ]
    )
    fun rejectsCanonicalBedrockEndpointsBeforeTokenExchange(baseUrl: String) {
        val httpClient = mock<HttpClient>()

        val thrown =
            assertThrows<IllegalArgumentException> {
                ClientOptions.builder()
                    .httpClient(httpClient)
                    .baseUrl(baseUrl)
                    .workloadIdentity(
                        WorkloadIdentity.x509Builder()
                            .identityProviderId("idp_test")
                            .serviceAccountId("svc_acct_test")
                            .build()
                    )
                    .build()
            }

        assertThat(thrown)
            .hasMessage("X.509 workload identity cannot be used with Amazon Bedrock endpoints")
        verify(httpClient, never()).execute(any(), any())
        verify(httpClient, never()).executeAsync(any(), any())
    }

    @ParameterizedTest
    @ValueSource(
        strings =
            [
                "https://bedrock-mantle.us-east-1.api.aws/openai/v1",
                "https://bedrock-runtime.us-east-1.amazonaws.com/openai/v1",
            ]
    )
    fun preservesApiKeyAndExistingWorkloadIdentityOnBedrock(baseUrl: String) {
        val httpClient = mock<HttpClient>()
        val apiKeyOptions =
            ClientOptions.builder()
                .httpClient(httpClient)
                .baseUrl(baseUrl)
                .apiKey("api-key")
                .build()
        val legacyWorkloadOptions =
            ClientOptions.builder()
                .httpClient(httpClient)
                .baseUrl(baseUrl)
                .workloadIdentity(
                    WorkloadIdentity.builder()
                        .identityProviderId("idp_test")
                        .serviceAccountId("svc_acct_test")
                        .provider(mock())
                        .build()
                )
                .build()

        assertThat(apiKeyOptions.baseUrl()).isEqualTo(baseUrl)
        assertThat(legacyWorkloadOptions.baseUrl()).isEqualTo(baseUrl)
    }
}
