// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.async.admin.organization.workloadidentityproviders

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.core.JsonValue
import com.openai.models.admin.organization.workloadidentityproviders.federationrules.FederationRuleCreateParams
import com.openai.models.admin.organization.workloadidentityproviders.federationrules.FederationRuleDeleteParams
import com.openai.models.admin.organization.workloadidentityproviders.federationrules.FederationRuleRetrieveParams
import com.openai.models.admin.organization.workloadidentityproviders.federationrules.FederationRuleUpdateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class FederationRuleServiceAsyncTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val federationRuleServiceAsync =
            client.admin().organization().workloadIdentityProviders().federationRules()

        val federationRuleFuture =
            federationRuleServiceAsync.create(
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

        val federationRule = federationRuleFuture.get()
        federationRule.validate()
    }

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val federationRuleServiceAsync =
            client.admin().organization().workloadIdentityProviders().federationRules()

        val federationRuleFuture =
            federationRuleServiceAsync.retrieve(
                FederationRuleRetrieveParams.builder()
                    .workloadIdentityProviderId("x")
                    .workloadIdentityFederationRuleId("x")
                    .build()
            )

        val federationRule = federationRuleFuture.get()
        federationRule.validate()
    }

    @Test
    fun update() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val federationRuleServiceAsync =
            client.admin().organization().workloadIdentityProviders().federationRules()

        val federationRuleFuture =
            federationRuleServiceAsync.update(
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

        val federationRule = federationRuleFuture.get()
        federationRule.validate()
    }

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val federationRuleServiceAsync =
            client.admin().organization().workloadIdentityProviders().federationRules()

        val pageFuture = federationRuleServiceAsync.list("x")

        val page = pageFuture.get()
        page.response().validate()
    }

    @Test
    fun delete() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val federationRuleServiceAsync =
            client.admin().organization().workloadIdentityProviders().federationRules()

        val federationRuleDeletedFuture =
            federationRuleServiceAsync.delete(
                FederationRuleDeleteParams.builder()
                    .workloadIdentityProviderId("x")
                    .workloadIdentityFederationRuleId("x")
                    .build()
            )

        val federationRuleDeleted = federationRuleDeletedFuture.get()
        federationRuleDeleted.validate()
    }
}
