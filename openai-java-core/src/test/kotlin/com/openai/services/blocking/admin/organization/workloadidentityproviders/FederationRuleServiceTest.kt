// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.blocking.admin.organization.workloadidentityproviders

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.core.JsonValue
import com.openai.models.admin.organization.workloadidentityproviders.federationrules.FederationRuleCreateParams
import com.openai.models.admin.organization.workloadidentityproviders.federationrules.FederationRuleDeleteParams
import com.openai.models.admin.organization.workloadidentityproviders.federationrules.FederationRuleRetrieveParams
import com.openai.models.admin.organization.workloadidentityproviders.federationrules.FederationRuleUpdateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class FederationRuleServiceTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val federationRuleService =
            client.admin().organization().workloadIdentityProviders().federationRules()

        val federationRule =
            federationRuleService.create(
                FederationRuleCreateParams.builder()
                    .workloadIdentityProviderId("x")
                    .attributeMatchers(
                        FederationRuleCreateParams.AttributeMatchers.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .projectId("x")
                    .serviceAccountId("x")
                    .description("description")
                    .enabled(true)
                    .name("name")
                    .restrictedPermissions(listOf("string"))
                    .build()
            )

        federationRule.validate()
    }

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val federationRuleService =
            client.admin().organization().workloadIdentityProviders().federationRules()

        val federationRule =
            federationRuleService.retrieve(
                FederationRuleRetrieveParams.builder()
                    .workloadIdentityProviderId("x")
                    .workloadIdentityFederationRuleId("x")
                    .build()
            )

        federationRule.validate()
    }

    @Test
    fun update() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val federationRuleService =
            client.admin().organization().workloadIdentityProviders().federationRules()

        val federationRule =
            federationRuleService.update(
                FederationRuleUpdateParams.builder()
                    .workloadIdentityProviderId("x")
                    .workloadIdentityFederationRuleId("x")
                    .attributeMatchers(
                        FederationRuleUpdateParams.AttributeMatchers.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .description("description")
                    .enabled(true)
                    .name("name")
                    .permissionsDefaultPermissionsParam()
                    .build()
            )

        federationRule.validate()
    }

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val federationRuleService =
            client.admin().organization().workloadIdentityProviders().federationRules()

        val page = federationRuleService.list("x")

        page.response().validate()
    }

    @Test
    fun delete() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val federationRuleService =
            client.admin().organization().workloadIdentityProviders().federationRules()

        val federationRuleDeleted =
            federationRuleService.delete(
                FederationRuleDeleteParams.builder()
                    .workloadIdentityProviderId("x")
                    .workloadIdentityFederationRuleId("x")
                    .build()
            )

        federationRuleDeleted.validate()
    }
}
