package com.openai.auth

import com.fasterxml.jackson.databind.json.JsonMapper
import com.openai.core.http.HttpClient
import com.openai.errors.SubjectTokenProviderException
import java.io.IOException
import java.nio.file.Path
import java.nio.file.Paths
import java.util.concurrent.ExecutionException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.io.TempDir
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import org.mockito.kotlin.mock

internal class K8sServiceAccountTokenProviderTest {

    private fun SubjectTokenProvider.getToken(async: Boolean): String {
        val httpClient = mock<HttpClient>()
        val jsonMapper = JsonMapper()
        return if (async) getTokenAsync(httpClient, jsonMapper).get()
        else getToken(httpClient, jsonMapper)
    }

    private fun assertThrowsProviderException(
        async: Boolean,
        block: () -> Unit,
    ): SubjectTokenProviderException {
        return if (async) {
            val thrown = assertThrows<ExecutionException>(block)
            thrown.cause as SubjectTokenProviderException
        } else {
            assertThrows<SubjectTokenProviderException>(block)
        }
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun getToken_success(async: Boolean, @TempDir tempDir: Path) {
        val tokenFile = tempDir.resolve("token")
        val expectedToken = "test-k8s-service-account-token"
        tokenFile.toFile().writeText(expectedToken)

        val provider = K8sServiceAccountTokenProvider.builder().tokenPath(tokenFile).build()
        val token = provider.getToken(async)

        assertThat(token).isEqualTo(expectedToken)
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun getToken_successWithWhitespace(async: Boolean, @TempDir tempDir: Path) {
        val tokenFile = tempDir.resolve("token")
        val expectedToken = "test-token-with-whitespace"
        tokenFile.toFile().writeText("  $expectedToken\n\t")

        val provider = K8sServiceAccountTokenProvider.builder().tokenPath(tokenFile).build()
        val token = provider.getToken(async)

        assertThat(token).isEqualTo(expectedToken)
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun getToken_emptyToken(async: Boolean, @TempDir tempDir: Path) {
        val tokenFile = tempDir.resolve("token")
        tokenFile.toFile().writeText("")

        val provider = K8sServiceAccountTokenProvider.builder().tokenPath(tokenFile).build()
        val exception = assertThrowsProviderException(async) { provider.getToken(async) }

        assertThat(exception.provider).isEqualTo("kubernetes")
        assertThat(exception.message).contains("service account token is empty")
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun getToken_fileNotFound(async: Boolean) {
        val nonExistentPath = Paths.get("/nonexistent/path/to/token")

        val provider = K8sServiceAccountTokenProvider.builder().tokenPath(nonExistentPath).build()
        val exception = assertThrowsProviderException(async) { provider.getToken(async) }

        assertThat(exception.provider).isEqualTo("kubernetes")
        assertThat(exception.message).contains("failed to read service account token")
        assertThat(exception.message).contains(nonExistentPath.toString())
        assertThat(exception.cause).isInstanceOf(IOException::class.java)
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun getToken_fileIsDirectory(async: Boolean, @TempDir tempDir: Path) {
        val provider = K8sServiceAccountTokenProvider.builder().tokenPath(tempDir).build()
        val exception = assertThrowsProviderException(async) { provider.getToken(async) }

        assertThat(exception.provider).isEqualTo("kubernetes")
        assertThat(exception.message).contains("failed to read service account token")
        assertThat(exception.message).contains(tempDir.toString())
    }

    @Test
    fun builder_withDefaultPath() {
        val provider = K8sServiceAccountTokenProvider.builder().build()

        assertThat(provider).isNotNull
        assertThat(provider.tokenType()).isEqualTo(SubjectTokenType.JWT)
    }

    @Test
    fun builder_withCustomPath(@TempDir tempDir: Path) {
        val tokenFile = tempDir.resolve("custom-token")

        val provider = K8sServiceAccountTokenProvider.builder().tokenPath(tokenFile).build()

        assertThat(provider).isNotNull
        assertThat(provider.tokenType()).isEqualTo(SubjectTokenType.JWT)
    }
}
