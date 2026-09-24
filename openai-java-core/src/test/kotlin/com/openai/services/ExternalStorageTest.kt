package com.openai.services

import com.github.tomakehurst.wiremock.WireMockServer
import com.github.tomakehurst.wiremock.client.WireMock.*
import com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig
import com.openai.client.OpenAIClient
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.core.jsonMapper
import com.openai.models.admin.organization.externalstorage.ExternalStorageConfiguration
import com.openai.models.admin.organization.externalstorage.ExternalStorageCreateParams
import com.openai.models.admin.organization.externalstorage.ExternalStorageListParams
import java.util.concurrent.TimeUnit
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class ExternalStorageTest {
    private val server = WireMockServer(wireMockConfig().dynamicPort())
    private lateinit var client: OpenAIClient

    @BeforeEach
    fun setUp() {
        server.start()
        client = clientBuilder().build()
    }

    @AfterEach
    fun tearDown() {
        try {
            client.close()
        } finally {
            server.stop()
        }
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun createsAwsWithRequestFieldsAndAdminKey(async: Boolean) {
        server.stubFor(
            post(urlEqualTo(COLLECTION))
                .willReturn(okJson(configuration("store_aws", AWS_METADATA)))
        )
        val provider =
            ExternalStorageCreateParams.Provider.ofAws(
                ExternalStorageCreateParams.Provider.Aws.builder()
                    .bucket("synthetic-bucket")
                    .roleArn("arn:aws:iam::000000000000:role/sdk-test")
                    .build()
            )

        val result = create(provider, async)

        result.validate()
        assertThat(result.provider().asAws().externalId()).isEqualTo("synthetic-external-id")
        val json = jsonMapper().readTree(jsonMapper().writeValueAsString(result))
        assertThat(json.path("future_field").asBoolean()).isTrue()
        assertThat(json.path("provider").path("future_provider_field").asBoolean()).isTrue()
        verifyCreate(
            """{"type":"aws","bucket":"synthetic-bucket","role_arn":"arn:aws:iam::000000000000:role/sdk-test"}"""
        )
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun createsAzureWithRequestFieldsAndAdminKey(async: Boolean) {
        server.stubFor(
            post(urlEqualTo(COLLECTION))
                .willReturn(okJson(configuration("store_azure", AZURE_METADATA)))
        )
        val provider =
            ExternalStorageCreateParams.Provider.ofAzure(
                ExternalStorageCreateParams.Provider.Azure.builder()
                    .accountName("syntheticaccount")
                    .container("synthetic-container")
                    .resourceGroup("synthetic-rg")
                    .subscriptionId("00000000-0000-0000-0000-000000000000")
                    .tenantId("11111111-1111-1111-1111-111111111111")
                    .build()
            )

        val result = create(provider, async)

        result.validate()
        assertThat(result.provider().asAzure().region()).isEqualTo("eastus")
        verifyCreate(AZURE_REQUEST)
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun routesRetrieveDeleteAndValidateWithEscapedIds(async: Boolean) {
        val id = "store/with space?x#part"
        val path = "$COLLECTION/store%2Fwith%20space%3Fx%23part"
        server.stubFor(
            get(urlEqualTo(path)).willReturn(okJson(configuration("store_test", AWS_METADATA)))
        )
        server.stubFor(
            delete(urlEqualTo(path))
                .willReturn(
                    okJson(
                        """{"id":"store_test","object":"organization.external_storage.deleted","deleted":true}"""
                    )
                )
        )
        server.stubFor(
            post(urlEqualTo("$path/validate"))
                .willReturn(okJson(configuration("store_test", AWS_METADATA)))
        )

        if (async) {
            val service = client.async().admin().organization().externalStorage()
            assertThat(service.retrieve(id).get(TIMEOUT_SECONDS, TimeUnit.SECONDS).id())
                .isEqualTo("store_test")
            assertThat(service.delete(id).get(TIMEOUT_SECONDS, TimeUnit.SECONDS).deleted()).isTrue()
            assertThat(
                    service.validate(id).get(TIMEOUT_SECONDS, TimeUnit.SECONDS).status().asString()
                )
                .isEqualTo("validated")
        } else {
            val service = client.admin().organization().externalStorage()
            assertThat(service.retrieve(id).id()).isEqualTo("store_test")
            assertThat(service.delete(id).deleted()).isTrue()
            assertThat(service.validate(id).status().asString()).isEqualTo("validated")
        }

        server.verify(
            1,
            getRequestedFor(urlEqualTo(path)).withHeader("Authorization", equalTo(ADMIN_AUTH)),
        )
        server.verify(
            1,
            deleteRequestedFor(urlEqualTo(path)).withHeader("Authorization", equalTo(ADMIN_AUTH)),
        )
        server.verify(
            1,
            postRequestedFor(urlEqualTo("$path/validate"))
                .withHeader("Authorization", equalTo(ADMIN_AUTH))
                .withRequestBody(absent()),
        )
        assertThat(server.allServeEvents).hasSize(3)
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun paginatesWithAdminKeyAndPreservesFilters(async: Boolean) {
        val items = listOf("store_first", "store_second")
        for (index in 0..2) {
            val after = if (index == 0) absent() else equalTo(items[index - 1])
            val data = if (index == 2) "" else configuration(items[index], AWS_METADATA)
            val id = if (index == 2) "null" else "\"${items[index]}\""
            server.stubFor(
                get(urlPathEqualTo(COLLECTION))
                    .withQueryParam("after", after)
                    .willReturn(
                        okJson(
                            """{"object":"list","data":[$data],"has_more":${index == 0},"first_id":$id,"last_id":$id}"""
                        )
                    )
            )
        }
        val params =
            ExternalStorageListParams.builder()
                .projectId("proj_test")
                .order(ExternalStorageListParams.Order.ASC)
                .limit(1)
                .putAdditionalHeader("x-pagination-test", "preserved")
                .build()
        val ids = mutableListOf<String>()

        // Standard Java cursor pages terminate on the empty page after the final item.
        if (async) {
            client
                .async()
                .admin()
                .organization()
                .externalStorage()
                .list(params)
                .get(TIMEOUT_SECONDS, TimeUnit.SECONDS)
                .autoPager()
                .subscribe { item -> ids.add(item.id()) }
                .onCompleteFuture()
                .get(TIMEOUT_SECONDS, TimeUnit.SECONDS)
        } else {
            client.admin().organization().externalStorage().list(params).autoPager().forEach { item
                ->
                ids.add(item.id())
            }
        }

        assertThat(ids).containsExactlyElementsOf(items)
        server.verify(
            3,
            getRequestedFor(urlPathEqualTo(COLLECTION))
                .withQueryParam("project_id", equalTo("proj_test"))
                .withQueryParam("order", equalTo("asc"))
                .withQueryParam("limit", equalTo("1"))
                .withHeader("x-pagination-test", equalTo("preserved"))
                .withHeader("Authorization", equalTo(ADMIN_AUTH)),
        )
        assertThat(server.allServeEvents).hasSize(3)
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun preservesUnknownProviderStatusAndFields(async: Boolean) {
        val provider = """{"type":"future_provider","opaque":{"value":7}}"""
        server.stubFor(
            get(urlEqualTo("$COLLECTION/store_future"))
                .willReturn(okJson(configuration("store_future", provider, "future_status")))
        )

        val result =
            if (async) {
                client
                    .async()
                    .admin()
                    .organization()
                    .externalStorage()
                    .retrieve("store_future")
                    .get(TIMEOUT_SECONDS, TimeUnit.SECONDS)
            } else {
                client.admin().organization().externalStorage().retrieve("store_future")
            }

        assertThat(result.status().asString()).isEqualTo("future_status")
        val json = jsonMapper().readTree(jsonMapper().writeValueAsString(result))
        assertThat(json.path("provider")).isEqualTo(jsonMapper().readTree(provider))
        assertThat(json.path("future_field").asBoolean()).isTrue()
        server.verify(
            1,
            getRequestedFor(urlEqualTo("$COLLECTION/store_future"))
                .withHeader("Authorization", equalTo(ADMIN_AUTH)),
        )
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun rejectsMissingAdminKeyWithoutUsingProjectKey(async: Boolean) {
        val unprivileged = clientBuilder().adminApiKey(null).build()
        try {
            assertThatThrownBy {
                    if (async) {
                        unprivileged
                            .async()
                            .admin()
                            .organization()
                            .externalStorage()
                            .retrieve("store_test")
                            .get(TIMEOUT_SECONDS, TimeUnit.SECONDS)
                    } else {
                        unprivileged.admin().organization().externalStorage().retrieve("store_test")
                    }
                }
                .isInstanceOf(IllegalStateException::class.java)
                .hasMessageContaining("requires adminApiKey")
            assertThat(server.allServeEvents).isEmpty()
        } finally {
            unprivileged.close()
        }
    }

    private fun create(
        provider: ExternalStorageCreateParams.Provider,
        async: Boolean,
    ): ExternalStorageConfiguration {
        val params =
            ExternalStorageCreateParams.builder().projectId("proj_test").provider(provider).build()
        return if (async) {
            client
                .async()
                .admin()
                .organization()
                .externalStorage()
                .create(params)
                .get(TIMEOUT_SECONDS, TimeUnit.SECONDS)
        } else {
            client.admin().organization().externalStorage().create(params)
        }
    }

    private fun verifyCreate(provider: String) {
        server.verify(
            1,
            postRequestedFor(urlEqualTo(COLLECTION))
                .withHeader("Authorization", equalTo(ADMIN_AUTH))
                .withRequestBody(equalToJson("""{"project_id":"proj_test","provider":$provider}""")),
        )
        assertThat(server.allServeEvents).hasSize(1)
    }

    private fun clientBuilder() =
        OpenAIOkHttpClient.builder()
            .baseUrl(server.baseUrl() + "/v1")
            .apiKey("fake-project-key")
            .adminApiKey("fake-admin-key")
            .maxRetries(0)

    private fun configuration(id: String, provider: String, status: String = "validated") =
        """{"id":"$id","object":"organization.external_storage","created_at":1,"project_id":"proj_test","geography":"us","provider":$provider,"status":"$status","future_field":true}"""

    private companion object {
        const val COLLECTION = "/v1/organization/external_storage"
        const val ADMIN_AUTH = "Bearer fake-admin-key"
        const val TIMEOUT_SECONDS = 30L
        const val AWS_METADATA =
            """{"type":"aws","account_id":"000000000000","bucket":"synthetic-bucket","external_id":"synthetic-external-id","region":"us-east-1","role_arn":"arn:aws:iam::000000000000:role/sdk-test","future_provider_field":true}"""
        const val AZURE_REQUEST =
            """{"type":"azure","tenant_id":"11111111-1111-1111-1111-111111111111","subscription_id":"00000000-0000-0000-0000-000000000000","resource_group":"synthetic-rg","account_name":"syntheticaccount","container":"synthetic-container"}"""
        const val AZURE_METADATA =
            """{"type":"azure","tenant_id":"11111111-1111-1111-1111-111111111111","subscription_id":"00000000-0000-0000-0000-000000000000","resource_group":"synthetic-rg","account_name":"syntheticaccount","container":"synthetic-container","region":"eastus"}"""
    }
}
