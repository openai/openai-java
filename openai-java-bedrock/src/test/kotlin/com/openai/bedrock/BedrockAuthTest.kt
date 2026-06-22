package com.openai.bedrock

import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpRequestBody
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIException
import java.io.OutputStream
import java.nio.file.Files
import java.nio.file.Path
import java.time.Clock
import java.time.Instant
import java.time.ZoneOffset
import java.util.concurrent.atomic.AtomicInteger
import java.util.function.Supplier
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.io.TempDir
import org.junit.jupiter.api.parallel.ResourceLock
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials
import software.amazon.awssdk.auth.credentials.AwsCredentials
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider
import software.amazon.awssdk.regions.Region

internal class BedrockAuthTest {

    @Test
    fun sigV4MatchesSharedFixture() {
        val fixture =
            javaClass.getResourceAsStream("/fixtures/bedrock/v1/sigv4.json").use { input ->
                jsonMapper().readTree(input)
            }
        val credentials = fixture["credentials"]
        val expected = fixture["expected"]
        val requestFixture = fixture["request"]
        val configuration =
            options(
                    awsRegion = fixture["region"].asText(),
                    awsAccessKeyId = credentials["accessKeyId"].asText(),
                    awsSecretAccessKey = credentials["secretAccessKey"].asText(),
                    awsSessionToken = credentials["sessionToken"].asText(),
                    clock =
                        Clock.fixed(Instant.parse(fixture["signingDate"].asText()), ZoneOffset.UTC),
                )
                .resolve(getenv = { null }, regionProvider = { null })

        val signed =
            configuration.authenticator.authenticate(
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl("https://bedrock-mantle.us-east-1.api.aws/openai/v1")
                    .addPathSegment("responses")
                    .putHeader("Content-Type", requestFixture["contentType"].asText())
                    .body(StringBody(requestFixture["body"].asText()))
                    .build()
            )

        assertThat(signed.headers.values("X-Amz-Date")).containsExactly(expected["date"].asText())
        assertThat(signed.headers.values("X-Amz-Content-Sha256"))
            .containsExactly(expected["payloadHash"].asText())
        assertThat(signed.headers.values("X-Amz-Security-Token"))
            .containsExactly(credentials["sessionToken"].asText())
        assertThat(signed.headers.values("Authorization"))
            .containsExactly(expected["authorization"].asText())
    }

    @Test
    @ResourceLock("aws-system-properties")
    fun namedProfileReadsSharedCredentialsFile(@TempDir directory: Path) {
        val credentialsFile = directory.resolve("credentials")
        Files.write(
            credentialsFile,
            """
            [fixture]
            aws_access_key_id = FILEACCESSKEY
            aws_secret_access_key = filesecret
            aws_session_token = file-session-token
            """
                .trimIndent()
                .toByteArray(),
        )
        val previous = System.getProperty("aws.sharedCredentialsFile")
        System.setProperty("aws.sharedCredentialsFile", credentialsFile.toString())

        try {
            val configuration =
                options(awsRegion = "us-east-1", awsProfile = "fixture")
                    .resolve(
                        getenv = { name ->
                            if (name == ENV_BEARER_TOKEN) "ignored-environment-bearer" else null
                        },
                        regionProvider = { null },
                    )
            val signed = configuration.authenticator.authenticate(request())

            assertThat(signed.headers.values("Authorization").single())
                .contains("Credential=FILEACCESSKEY/")
            assertThat(signed.headers.values("X-Amz-Security-Token"))
                .containsExactly("file-session-token")
        } finally {
            if (previous == null) System.clearProperty("aws.sharedCredentialsFile")
            else System.setProperty("aws.sharedCredentialsFile", previous)
        }
    }

    @Test
    fun explicitAwsCredentialsTakePrecedenceOverEnvironmentBearer() {
        val configuration =
            options(
                    awsRegion = "us-east-1",
                    awsAccessKeyId = "AKIDEXAMPLE",
                    awsSecretAccessKey = "secret",
                )
                .resolve(
                    getenv = { name ->
                        if (name == ENV_BEARER_TOKEN) "environment-token" else null
                    },
                    regionProvider = { null },
                )

        val signed = configuration.authenticator.authenticate(request())

        assertThat(signed.headers.values("Authorization").single()).startsWith("AWS4-HMAC-SHA256")
    }

    @Test
    fun environmentBearerTakesPrecedenceOverDefaultChain() {
        val configuration =
            options(awsRegion = "us-east-1")
                .resolve(
                    getenv = { name ->
                        if (name == ENV_BEARER_TOKEN) "environment-token" else null
                    },
                    regionProvider = { null },
                )

        val authenticated = configuration.authenticator.authenticate(request())

        assertThat(authenticated.headers.values("Authorization"))
            .containsExactly("Bearer environment-token")
    }

    @Test
    fun tokenProviderResolvesFreshCredentialsAndReportsInvalidResults() {
        val calls = AtomicInteger()
        val configuration =
            options(
                    awsRegion = "us-east-1",
                    tokenProvider = Supplier { "token-${calls.incrementAndGet()}" },
                )
                .resolve(getenv = { null }, regionProvider = { null })

        assertThat(
                configuration.authenticator.authenticate(request()).headers.values("Authorization")
            )
            .containsExactly("Bearer token-1")
        assertThat(
                configuration.authenticator.authenticate(request()).headers.values("Authorization")
            )
            .containsExactly("Bearer token-2")

        val blankProvider =
            options(awsRegion = "us-east-1", tokenProvider = Supplier { " " })
                .resolve(getenv = { null }, regionProvider = { null })
        assertThatThrownBy { blankProvider.authenticator.authenticate(request()) }
            .isInstanceOf(OpenAIException::class.java)
            .hasMessageContaining("non-empty string")

        val failingProvider =
            options(
                    awsRegion = "us-east-1",
                    tokenProvider = Supplier { throw IllegalStateException("token failure") },
                )
                .resolve(getenv = { null }, regionProvider = { null })
        assertThatThrownBy { failingProvider.authenticator.authenticate(request()) }
            .isInstanceOf(OpenAIException::class.java)
            .hasMessageContaining("Failed to resolve a bearer credential")
            .hasCauseInstanceOf(IllegalStateException::class.java)
    }

    @Test
    fun environmentBearerReportsWhenCredentialDisappears() {
        val reads = AtomicInteger()
        val configuration =
            options(awsRegion = "us-east-1")
                .resolve(
                    getenv = { name ->
                        if (name == ENV_BEARER_TOKEN && reads.getAndIncrement() == 0) {
                            "short-lived-token"
                        } else {
                            null
                        }
                    },
                    regionProvider = { null },
                )

        assertThatThrownBy { configuration.authenticator.authenticate(request()) }
            .isInstanceOf(OpenAIException::class.java)
            .hasMessageContaining("Failed to resolve a bearer credential")
            .hasRootCauseMessage(
                "Could not find credentials for Bedrock. Set `AWS_BEARER_TOKEN_BEDROCK` or configure AWS credential authentication."
            )
    }

    @Test
    fun endpointResolutionUsesExplicitThenEnvironmentThenRegionalDefault() {
        val explicit =
            options(
                    awsRegion = "us-east-1",
                    baseUrl = "https://explicit.example.com/openai/v1/",
                    apiKey = "token",
                )
                .resolve(
                    getenv = { name ->
                        if (name == ENV_BASE_URL) "https://environment.example.com" else null
                    },
                    regionProvider = { null },
                )
        val environment =
            options(awsRegion = "us-east-1", apiKey = "token")
                .resolve(
                    getenv = { name ->
                        if (name == ENV_BASE_URL) "https://environment.example.com/" else null
                    },
                    regionProvider = { null },
                )
        val regional =
            options(awsRegion = "us-east-1", apiKey = "token")
                .resolve(getenv = { null }, regionProvider = { null })
        val awsRegionEnvironment =
            options(apiKey = "token")
                .resolve(
                    getenv = { name -> if (name == "AWS_REGION") "us-west-2" else null },
                    regionProvider = { null },
                )
        val defaultRegionEnvironment =
            options(apiKey = "token")
                .resolve(
                    getenv = { name -> if (name == "AWS_DEFAULT_REGION") "eu-central-1" else null },
                    regionProvider = { null },
                )
        val providerRegion =
            options(apiKey = "token")
                .resolve(getenv = { null }, regionProvider = { Region.of("ap-southeast-2") })

        assertThat(explicit.baseUrl).isEqualTo("https://explicit.example.com/openai/v1")
        assertThat(environment.baseUrl).isEqualTo("https://environment.example.com")
        assertThat(regional.baseUrl).isEqualTo("https://bedrock-mantle.us-east-1.api.aws/openai/v1")
        assertThat(awsRegionEnvironment.baseUrl)
            .isEqualTo("https://bedrock-mantle.us-west-2.api.aws/openai/v1")
        assertThat(defaultRegionEnvironment.baseUrl)
            .isEqualTo("https://bedrock-mantle.eu-central-1.api.aws/openai/v1")
        assertThat(providerRegion.baseUrl)
            .isEqualTo("https://bedrock-mantle.ap-southeast-2.api.aws/openai/v1")
    }

    @Test
    fun skipAuthPassesThroughSameOriginAndRejectsDifferentOrigin() {
        val configuration =
            options(baseUrl = "https://bedrock.example.com/openai/v1", skipAuth = true)
                .resolve(getenv = { null }, regionProvider = { null })
        val sameOrigin =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .baseUrl("https://bedrock.example.com/openai/v1")
                .addPathSegment("responses")
                .build()
        val differentOrigin =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .baseUrl("https://other.example.com/openai/v1")
                .addPathSegment("responses")
                .build()

        assertThat(configuration.authenticator.authenticate(sameOrigin)).isSameAs(sameOrigin)
        assertThatThrownBy { configuration.authenticator.authenticate(differentOrigin) }
            .isInstanceOf(OpenAIException::class.java)
            .hasMessageContaining("different origin")
    }

    @Test
    fun signingIncludesBodyContentTypeAndQueryParameters() {
        val configuration =
            options(
                    awsRegion = "us-east-1",
                    awsAccessKeyId = "AKIDEXAMPLE",
                    awsSecretAccessKey = "secret",
                    clock = Clock.fixed(Instant.parse("2026-06-01T12:34:56Z"), ZoneOffset.UTC),
                )
                .resolve(getenv = { null }, regionProvider = { null })

        fun signed(queryValue: String) =
            configuration.authenticator.authenticate(
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl("https://bedrock-mantle.us-east-1.api.aws/openai/v1")
                    .addPathSegment("responses")
                    .putQueryParam("preview", queryValue)
                    .body(StringBody("{}"))
                    .build()
            )

        val first = signed("one")
        val second = signed("two")

        assertThat(first.headers.values("Content-Type")).containsExactly("application/json")
        assertThat(first.headers.values("Authorization").single())
            .isNotEqualTo(second.headers.values("Authorization").single())
    }

    @Test
    fun rejectsCustomAuthorizationHeader() {
        val configuration =
            options(awsRegion = "us-east-1", apiKey = "token")
                .resolve(getenv = { null }, regionProvider = { null })
        val request = request().toBuilder().putHeader("Authorization", "Bearer custom").build()

        assertThatThrownBy { configuration.authenticator.authenticate(request) }
            .isInstanceOf(OpenAIException::class.java)
            .hasMessageContaining("custom `Authorization` header")
    }

    @Test
    fun rejectsCanonicalEndpointRegionMismatch() {
        val configuration =
            options(
                    awsRegion = "us-west-2",
                    baseUrl = "https://bedrock-mantle.us-east-1.api.aws/openai/v1",
                    awsAccessKeyId = "access",
                    awsSecretAccessKey = "secret",
                )
                .resolve(getenv = { null }, regionProvider = { null })

        assertThatThrownBy { configuration.authenticator.authenticate(request()) }
            .isInstanceOf(OpenAIException::class.java)
            .hasMessageContaining("does not match the SigV4 region")
    }

    @Test
    fun missingRegionIsActionable() {
        assertThatThrownBy {
                options(apiKey = "token").resolve(getenv = { null }, regionProvider = { null })
            }
            .isInstanceOf(OpenAIException::class.java)
            .hasMessageContaining("AWS region")
    }

    @Test
    fun rejectsPartialStaticCredentials() {
        assertThatThrownBy {
                options(awsRegion = "us-east-1", awsAccessKeyId = "access")
                    .resolve(getenv = { null }, regionProvider = { null })
            }
            .isInstanceOf(OpenAIException::class.java)
            .hasMessageContaining("both `awsAccessKeyId` and `awsSecretAccessKey`")
    }

    @Test
    fun rejectsConflictingExplicitAuthModes() {
        assertThatThrownBy {
                options(
                        awsRegion = "us-east-1",
                        apiKey = "bearer",
                        awsAccessKeyId = "access",
                        awsSecretAccessKey = "secret",
                    )
                    .resolve(getenv = { null }, regionProvider = { null })
            }
            .isInstanceOf(OpenAIException::class.java)
            .hasMessageContaining("mutually exclusive")
    }

    @Test
    fun rejectsEmptyAndAmbiguousConfiguration() {
        assertThatThrownBy {
                options(awsRegion = "us-east-1", apiKey = " ")
                    .resolve(getenv = { null }, regionProvider = { null })
            }
            .hasMessageContaining("bearer credential must not be empty")
        assertThatThrownBy {
                options(
                        awsRegion = "us-east-1",
                        apiKey = "token",
                        tokenProvider = Supplier { "token" },
                    )
                    .resolve(getenv = { null }, regionProvider = { null })
            }
            .hasMessageContaining("mutually exclusive")
        assertThatThrownBy {
                options(awsRegion = "us-east-1", awsProfile = " ")
                    .resolve(getenv = { null }, regionProvider = { null })
            }
            .hasMessageContaining("awsProfile")
        assertThatThrownBy {
                options(
                        awsRegion = "us-east-1",
                        awsAccessKeyId = "access",
                        awsSecretAccessKey = "secret",
                        awsProfile = "profile",
                    )
                    .resolve(getenv = { null }, regionProvider = { null })
            }
            .hasMessageContaining("exactly one explicit AWS mode")
        assertThatThrownBy {
                options(awsRegion = "us-east-1", apiKey = "token", skipAuth = true)
                    .resolve(getenv = { null }, regionProvider = { null })
            }
            .hasMessageContaining("skipAuth")
        assertThatThrownBy {
                options(
                        awsRegion = "us-east-1",
                        awsAccessKeyId = " ",
                        awsSecretAccessKey = "secret",
                    )
                    .resolve(getenv = { null }, regionProvider = { null })
            }
            .hasMessageContaining("non-empty")
        assertThatThrownBy {
                options(
                        awsRegion = "us-east-1",
                        awsAccessKeyId = "access",
                        awsSecretAccessKey = "secret",
                        awsSessionToken = " ",
                    )
                    .resolve(getenv = { null }, regionProvider = { null })
            }
            .hasMessageContaining("awsSessionToken")
        assertThatThrownBy {
                options(awsRegion = " ", apiKey = "token")
                    .resolve(getenv = { null }, regionProvider = { null })
            }
            .hasMessageContaining("awsRegion")
        assertThatThrownBy {
                options(baseUrl = "not a URL", apiKey = "token")
                    .resolve(getenv = { null }, regionProvider = { null })
            }
            .hasMessageContaining("valid HTTP URL")
    }

    @Test
    fun credentialProviderFailuresAreActionableAndProviderIsClosed() {
        val failingConfiguration =
            options(
                    awsRegion = "us-east-1",
                    awsCredentialsProvider =
                        AwsCredentialsProvider { throw IllegalStateException("credential failure") },
                )
                .resolve(getenv = { null }, regionProvider = { null })
        assertThatThrownBy { failingConfiguration.authenticator.authenticate(request()) }
            .isInstanceOf(OpenAIException::class.java)
            .hasMessageContaining("Failed to resolve AWS credentials")
            .hasCauseInstanceOf(IllegalStateException::class.java)

        val emptyCredentials =
            object : AwsCredentials {
                override fun accessKeyId(): String = ""

                override fun secretAccessKey(): String = ""
            }
        val invalidConfiguration =
            options(
                    awsRegion = "us-east-1",
                    awsCredentialsProvider = AwsCredentialsProvider { emptyCredentials },
                )
                .resolve(getenv = { null }, regionProvider = { null })
        assertThatThrownBy { invalidConfiguration.authenticator.authenticate(request()) }
            .isInstanceOf(OpenAIException::class.java)
            .hasMessageContaining("Failed to resolve AWS credentials")

        val closeableProvider = CloseableCredentialsProvider()
        val closeableConfiguration =
            options(awsRegion = "us-east-1", awsCredentialsProvider = closeableProvider)
                .resolve(getenv = { null }, regionProvider = { null })
        closeableConfiguration.authenticator.authenticate(request())
        closeableConfiguration.authenticator.close()

        assertThat(closeableProvider.closed).isTrue()
    }

    @Test
    fun rejectsNonReplayableRequestBodyBeforeCredentialResolution() {
        val configuration =
            options(
                    awsRegion = "us-east-1",
                    awsAccessKeyId = "AKIDEXAMPLE",
                    awsSecretAccessKey = "secret",
                )
                .resolve(getenv = { null }, regionProvider = { null })
        val request = request().toBuilder().body(StringBody("body", repeatable = false)).build()

        assertThatThrownBy { configuration.authenticator.authenticate(request) }
            .isInstanceOf(OpenAIException::class.java)
            .hasMessageContaining("replayable request body")
    }

    private fun request(): HttpRequest =
        HttpRequest.builder()
            .method(HttpMethod.POST)
            .baseUrl("https://bedrock-mantle.us-east-1.api.aws/openai/v1")
            .addPathSegment("responses")
            .putHeader("Content-Type", "application/json")
            .body(StringBody("{}"))
            .build()

    private fun options(
        awsRegion: String? = null,
        baseUrl: String? = null,
        apiKey: String? = null,
        tokenProvider: Supplier<String>? = null,
        awsAccessKeyId: String? = null,
        awsSecretAccessKey: String? = null,
        awsSessionToken: String? = null,
        awsProfile: String? = null,
        awsCredentialsProvider: AwsCredentialsProvider? = null,
        skipAuth: Boolean = false,
        clock: Clock = Clock.systemUTC(),
    ) =
        BedrockAuthOptions(
            awsRegion = awsRegion,
            baseUrl = baseUrl,
            apiKey = apiKey,
            tokenProvider = tokenProvider,
            awsAccessKeyId = awsAccessKeyId,
            awsSecretAccessKey = awsSecretAccessKey,
            awsSessionToken = awsSessionToken,
            awsProfile = awsProfile,
            awsCredentialsProvider = awsCredentialsProvider,
            skipAuth = skipAuth,
            clock = clock,
        )

    private class CloseableCredentialsProvider : AwsCredentialsProvider, AutoCloseable {
        var closed = false

        override fun resolveCredentials(): AwsCredentials =
            AwsBasicCredentials.create("CLOSEABLEACCESSKEY", "closeable-secret-key")

        override fun close() {
            closed = true
        }
    }

    private class StringBody(value: String, private val repeatable: Boolean = true) :
        HttpRequestBody {
        private val bytes = value.toByteArray()

        override fun writeTo(outputStream: OutputStream) = outputStream.write(bytes)

        override fun contentType(): String = "application/json"

        override fun contentLength(): Long = bytes.size.toLong()

        override fun repeatable(): Boolean = repeatable

        override fun close() {}
    }
}
