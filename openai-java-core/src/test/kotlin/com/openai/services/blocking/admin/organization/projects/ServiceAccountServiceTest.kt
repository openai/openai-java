// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.admin.organization.projects

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.models.admin.organization.projects.serviceaccounts.ServiceAccountCreateParams
import com.openai.models.admin.organization.projects.serviceaccounts.ServiceAccountDeleteParams
import com.openai.models.admin.organization.projects.serviceaccounts.ServiceAccountRetrieveParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class ServiceAccountServiceTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val serviceAccountService = client.admin().organization().projects().serviceAccounts()

        val serviceAccount =
            serviceAccountService.create(
                ServiceAccountCreateParams.builder().projectId("project_id").name("name").build()
            )

        serviceAccount.validate()
    }

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val serviceAccountService = client.admin().organization().projects().serviceAccounts()

        val projectServiceAccount =
            serviceAccountService.retrieve(
                ServiceAccountRetrieveParams.builder()
                    .projectId("project_id")
                    .serviceAccountId("service_account_id")
                    .build()
            )

        projectServiceAccount.validate()
    }

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val serviceAccountService = client.admin().organization().projects().serviceAccounts()

        val page = serviceAccountService.list("project_id")

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
        val serviceAccountService = client.admin().organization().projects().serviceAccounts()

        val serviceAccount =
            serviceAccountService.delete(
                ServiceAccountDeleteParams.builder()
                    .projectId("project_id")
                    .serviceAccountId("service_account_id")
                    .build()
            )

        serviceAccount.validate()
    }
}
