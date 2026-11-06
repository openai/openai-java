package com.openai.services

import com.github.tomakehurst.wiremock.client.WireMock.absent
import com.github.tomakehurst.wiremock.client.WireMock.delete
import com.github.tomakehurst.wiremock.client.WireMock.equalTo
import com.github.tomakehurst.wiremock.client.WireMock.equalToJson
import com.github.tomakehurst.wiremock.client.WireMock.get
import com.github.tomakehurst.wiremock.client.WireMock.getRequestedFor
import com.github.tomakehurst.wiremock.client.WireMock.okJson
import com.github.tomakehurst.wiremock.client.WireMock.post
import com.github.tomakehurst.wiremock.client.WireMock.postRequestedFor
import com.github.tomakehurst.wiremock.client.WireMock.reset
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo
import com.github.tomakehurst.wiremock.client.WireMock.urlPathEqualTo
import com.github.tomakehurst.wiremock.client.WireMock.verify
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.models.admin.organization.externalkeys.ExternalKeyCreateParams.Body
import com.openai.models.admin.organization.externalkeys.ExternalKeyListParams
import java.util.concurrent.TimeUnit
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.parallel.ResourceLock

@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class ExternalKeysContractTest {
    private val path = "/organization/external_keys"
    private val key =
        """{"id":"key_1","object":"organization.external_key","type":"aws","name":"Example","created_at":1,"workspace_id":"org_1","api_project_ids":[]}"""

    private fun syncClient(info: WireMockRuntimeInfo) =
        OpenAIOkHttpClient.builder()
            .baseUrl(info.httpBaseUrl)
            .apiKey("project-key")
            .adminApiKey("admin-key")
            .maxRetries(0)
            .build()

    private fun asyncClient(info: WireMockRuntimeInfo) =
        OpenAIOkHttpClientAsync.builder()
            .baseUrl(info.httpBaseUrl)
            .apiKey("project-key")
            .adminApiKey("admin-key")
            .maxRetries(0)
            .build()

    @Test
    fun providerBodiesUseAdminAuth(info: WireMockRuntimeInfo) {
        val cases =
            listOf(
                Body.ofAws(
                    Body.Aws.builder()
                        .name("Example")
                        .externalId("org_1")
                        .kmsArn("arn:key")
                        .roleArn("arn:role")
                        .build()
                ) to
                    """{"type":"aws","name":"Example","external_id":"org_1","kms_arn":"arn:key","role_arn":"arn:role"}""",
                Body.ofGcp(
                    Body.Gcp.builder()
                        .name("Example")
                        .audience("org_1")
                        .kmsProjectId("project")
                        .kmsKeyLocation("global")
                        .kmsKeyRingName("ring")
                        .kmsKeyName("key")
                        .kmsKeyVersion("7")
                        .workloadIdentityPoolId("pool")
                        .workloadIdentityProjectNumber("123")
                        .workloadIdentityProviderId("provider")
                        .purpose(Body.Gcp.Purpose.PSP_DECRYPTION)
                        .build()
                ) to
                    """{"type":"gcp","name":"Example","audience":"org_1","kms_project_id":"project","kms_key_location":"global","kms_key_ring_name":"ring","kms_key_name":"key","kms_key_version":"7","workload_identity_pool_id":"pool","workload_identity_project_number":"123","workload_identity_provider_id":"provider","purpose":"psp_decryption"}""",
                Body.ofAzure(
                    Body.Azure.builder()
                        .name("Example")
                        .tenantId("tenant")
                        .vaultUri("https://vault.example")
                        .keyName("key")
                        .keyVersion("version")
                        .purpose(Body.Azure.Purpose.PSP_DECRYPTION)
                        .build()
                ) to
                    """{"type":"azure","name":"Example","tenant_id":"tenant","vault_uri":"https://vault.example","key_name":"key","key_version":"version","purpose":"psp_decryption"}""",
            )
        val sync = syncClient(info)
        val async = asyncClient(info)
        try {
            for ((body, json) in cases) {
                reset()
                stubFor(
                    post(urlEqualTo(path))
                        .withRequestBody(equalToJson(json))
                        .willReturn(okJson(key))
                )
                assertThat(sync.admin().organization().externalKeys().create(body).id())
                    .isEqualTo("key_1")
                assertThat(
                        async
                            .admin()
                            .organization()
                            .externalKeys()
                            .create(body)
                            .get(10, TimeUnit.SECONDS)
                            .id()
                    )
                    .isEqualTo("key_1")
                verify(
                    2,
                    postRequestedFor(urlEqualTo(path))
                        .withHeader("Authorization", equalTo("Bearer admin-key"))
                        .withRequestBody(equalToJson(json)),
                )
            }
        } finally {
            async.close()
            sync.close()
        }
    }

    @Test
    fun filteredPagesKeepPurposeAndAdvanceAfter(info: WireMockRuntimeInfo) {
        val params =
            ExternalKeyListParams.builder()
                .purpose(ExternalKeyListParams.Purpose.PSP_DECRYPTION)
                .limit(1L)
                .build()
        stubFor(
            get(urlPathEqualTo(path))
                .withQueryParam("after", absent())
                .willReturn(okJson("""{"data":[$key],"has_more":true,"last_id":"key_1"}"""))
        )
        stubFor(
            get(urlPathEqualTo(path))
                .withQueryParam("after", equalTo("key_1"))
                .willReturn(
                    okJson(
                        """{"data":[${key.replace("key_1", "key_2")}],"has_more":false,"last_id":"key_2"}"""
                    )
                )
        )
        val sync = syncClient(info)
        try {
            val keys =
                sync.admin().organization().externalKeys().list(params).autoPager().map { it.id() }
            assertThat(keys).containsExactly("key_1", "key_2")
        } finally {
            sync.close()
        }
        val async = asyncClient(info)
        try {
            val first =
                async.admin().organization().externalKeys().list(params).get(10, TimeUnit.SECONDS)
            assertThat(first.items().map { it.id() }).containsExactly("key_1")
            val second = first.nextPage().get(10, TimeUnit.SECONDS)
            assertThat(second.items().map { it.id() }).containsExactly("key_2")
            assertThat(second.hasNextPage()).isFalse()
        } finally {
            async.close()
        }
        verify(
            4,
            getRequestedFor(urlPathEqualTo(path))
                .withQueryParam("purpose", equalTo("psp_decryption"))
                .withQueryParam("limit", equalTo("1"))
                .withHeader("Authorization", equalTo("Bearer admin-key")),
        )
        verify(2, getRequestedFor(urlPathEqualTo(path)).withQueryParam("after", equalTo("key_1")))
    }

    @Test
    fun lifecycleReturnsFullDeletedKey(info: WireMockRuntimeInfo) {
        val url = "$path/key_1"
        stubFor(
            get(urlEqualTo(url))
                .withHeader("Authorization", equalTo("Bearer admin-key"))
                .willReturn(okJson(key))
        )
        stubFor(
            delete(urlEqualTo(url))
                .withHeader("Authorization", equalTo("Bearer admin-key"))
                .willReturn(
                    okJson(
                        key.replace(
                            "organization.external_key",
                            "organization.external_key.deleted",
                        )
                    )
                )
        )
        stubFor(
            post(urlEqualTo("$url/validate"))
                .withHeader("Authorization", equalTo("Bearer admin-key"))
                .willReturn(okJson("""{"status":"valid"}"""))
        )
        val sync = syncClient(info)
        try {
            val keys = sync.admin().organization().externalKeys()
            assertThat(keys.retrieve("key_1").id()).isEqualTo("key_1")
            assertThat(keys.validate("key_1").status()).isEqualTo("valid")
            val deleted = keys.delete("key_1")
            assertThat(deleted.id()).isEqualTo("key_1")
            assertThat(deleted.workspaceId()).isEqualTo("org_1")
            assertThat(deleted.object_()).isEqualTo("organization.external_key.deleted")
        } finally {
            sync.close()
        }
        val async = asyncClient(info)
        try {
            val keys = async.admin().organization().externalKeys()
            assertThat(keys.retrieve("key_1").get(10, TimeUnit.SECONDS).id()).isEqualTo("key_1")
            assertThat(keys.validate("key_1").get(10, TimeUnit.SECONDS).status()).isEqualTo("valid")
            assertThat(keys.delete("key_1").get(10, TimeUnit.SECONDS).workspaceId())
                .isEqualTo("org_1")
        } finally {
            async.close()
        }
    }
}
