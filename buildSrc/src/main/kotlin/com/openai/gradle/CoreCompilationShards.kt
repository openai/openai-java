package com.openai.gradle

import java.io.Serializable
import org.gradle.api.file.FileTreeElement
import org.gradle.api.specs.Spec

enum class CoreCompilationShard(val id: String) {
    RUNTIME("runtime"),
    MODELS_COMMON("models-common"),
    MODELS_ADMIN("models-admin"),
    MODELS_BETA_RESPONSES("models-beta-responses"),
    MODELS_BETA("models-beta"),
    MODELS_GENERAL("models-general"),
    MODELS_REALTIME("models-realtime"),
    MODELS_EVALS("models-evals"),
    CLIENT_BASE("client-base"),
    SERVICES_ADMIN("services-admin"),
    SERVICES_BETA("services-beta"),
    SERVICES_RESPONSES("services-responses"),
    SERVICES_GENERAL("services-general");

    val projectName: String
        get() = "${CoreCompilationShards.PROJECT_PREFIX}$id"

    val dependencies: List<CoreCompilationShard>
        get() =
            when (this) {
                RUNTIME -> emptyList()
                MODELS_COMMON -> listOf(RUNTIME)
                MODELS_ADMIN,
                MODELS_BETA_RESPONSES,
                MODELS_BETA,
                MODELS_GENERAL,
                MODELS_EVALS -> listOf(MODELS_COMMON)
                MODELS_REALTIME -> listOf(MODELS_COMMON, MODELS_GENERAL)
                CLIENT_BASE -> listOf(MODELS_COMMON)
                SERVICES_ADMIN -> listOf(CLIENT_BASE, MODELS_ADMIN)
                SERVICES_BETA -> listOf(CLIENT_BASE, MODELS_BETA, MODELS_BETA_RESPONSES)
                SERVICES_RESPONSES -> listOf(CLIENT_BASE, MODELS_REALTIME)
                SERVICES_GENERAL -> listOf(CLIENT_BASE, MODELS_GENERAL, MODELS_EVALS)
            }

    fun transitiveDependencies(): List<CoreCompilationShard> {
        val transitiveDependencies = linkedSetOf<CoreCompilationShard>()

        fun collect(shard: CoreCompilationShard) {
            shard.dependencies.forEach(::collect)
            transitiveDependencies.add(shard)
        }

        dependencies.forEach(::collect)
        return transitiveDependencies.toList()
    }
}

/**
 * Stable source partitions for the generated core library.
 *
 * Generated sources stay in `openai-java-core` so code generation remains unchanged. The internal
 * shard projects compile subsets of that tree and `openai-java-core` embeds their outputs in its
 * published jar.
 */
object CoreCompilationShards {
    const val PROJECT_PREFIX = "openai-java-core-"

    private val runtimeSources =
        setOf(
            "com/openai/auth/TokenExchangeResponse.kt",
            "com/openai/azure/AzureOpenAIServiceVersion.kt",
            "com/openai/azure/AzureUrlCategory.kt",
            "com/openai/azure/AzureUrlPathMode.kt",
            "com/openai/azure/credential/AzureApiKeyCredential.kt",
            "com/openai/core/AutoPager.kt",
            "com/openai/core/AutoPagerAsync.kt",
            "com/openai/core/BaseDeserializer.kt",
            "com/openai/core/BaseSerializer.kt",
            "com/openai/core/Check.kt",
            "com/openai/core/DefaultSleeper.kt",
            "com/openai/core/JsonSchemaLocalValidation.kt",
            "com/openai/core/JsonSchemaValidator.kt",
            "com/openai/core/LogLevel.kt",
            "com/openai/core/ObjectMappers.kt",
            "com/openai/core/Page.kt",
            "com/openai/core/PageAsync.kt",
            "com/openai/core/PhantomReachable.kt",
            "com/openai/core/PhantomReachableExecutorService.kt",
            "com/openai/core/PhantomReachableSleeper.kt",
            "com/openai/core/SecurityOptions.kt",
            "com/openai/core/Sleeper.kt",
            "com/openai/core/Timeout.kt",
            "com/openai/core/Utils.kt",
            "com/openai/core/Values.kt",
            "com/openai/core/http/AsyncStreamResponse.kt",
            "com/openai/core/http/HttpMethod.kt",
            "com/openai/core/http/HttpRequestBody.kt",
            "com/openai/core/http/PhantomReachableClosingAsyncStreamResponse.kt",
            "com/openai/core/http/PhantomReachableClosingStreamResponse.kt",
            "com/openai/core/http/SseMessage.kt",
            "com/openai/core/http/StreamResponse.kt",
            "com/openai/credential/BearerTokenCredential.kt",
            "com/openai/credential/Credential.kt",
            "com/openai/errors/InvalidWebhookSignatureException.kt",
            "com/openai/errors/OpenAIException.kt",
            "com/openai/errors/OpenAIInvalidDataException.kt",
            "com/openai/errors/OpenAIIoException.kt",
            "com/openai/errors/OpenAIRetryableException.kt",
            "com/openai/errors/SubjectTokenProviderException.kt",
        )

    private val clientBaseSources =
        setOf(
            "com/openai/core/CancellableFuture.kt",
            "com/openai/core/ClientOptions.kt",
            "com/openai/core/PrepareRequest.kt",
            "com/openai/core/Properties.kt",
            "com/openai/core/RequestOptions.kt",
            "com/openai/core/http/AuthenticatingHttpClient.kt",
            "com/openai/core/http/HttpClient.kt",
            "com/openai/core/http/LoggingHttpClient.kt",
            "com/openai/core/http/PhantomReachableClosingHttpClient.kt",
            "com/openai/core/http/RetryingHttpClient.kt",
            "com/openai/core/http/WorkloadIdentityHttpClient.kt",
        )

    val projectNames: List<String> = CoreCompilationShard.values().map { it.projectName }

    fun isShardProject(projectName: String): Boolean = projectName in projectNames

    fun shardForProject(projectName: String): CoreCompilationShard =
        checkNotNull(CoreCompilationShard.values().find { it.projectName == projectName }) {
            "$projectName is not a core compilation shard"
        }

    fun versionPolicyProjectName(projectName: String): String =
        if (isShardProject(projectName)) "openai-java-core" else projectName

    /** Returns null for sources compiled by the final `openai-java-core` client layer. */
    fun shardFor(relativePath: String): CoreCompilationShard? {
        val candidate = relativePath.replace('\\', '/')
        val packagePathIndex = candidate.indexOf("com/openai/")
        if (packagePathIndex < 0 || !candidate.endsWith(".kt")) return null
        val path = candidate.substring(packagePathIndex)

        if (path in runtimeSources) return CoreCompilationShard.RUNTIME

        if (path.startsWith("com/openai/models/")) {
            if (path.endsWith("Page.kt") || path.endsWith("PageAsync.kt")) {
                return serviceShardFor(path)
            }

            return when {
                path.substringAfter("com/openai/models/").contains('/').not() ->
                    CoreCompilationShard.MODELS_COMMON
                path.startsWith("com/openai/models/responses/") ->
                    CoreCompilationShard.MODELS_COMMON
                path.startsWith("com/openai/models/chat/") -> CoreCompilationShard.MODELS_COMMON
                path.startsWith("com/openai/models/completions/") ->
                    CoreCompilationShard.MODELS_COMMON
                path.startsWith("com/openai/models/admin/") -> CoreCompilationShard.MODELS_ADMIN
                path.startsWith("com/openai/models/beta/responses/") ->
                    CoreCompilationShard.MODELS_BETA_RESPONSES
                path.startsWith("com/openai/models/beta/") -> CoreCompilationShard.MODELS_BETA
                path.startsWith("com/openai/models/realtime/") ->
                    CoreCompilationShard.MODELS_REALTIME
                path.startsWith("com/openai/models/evals/") -> CoreCompilationShard.MODELS_EVALS
                path.startsWith("com/openai/models/graders/") -> CoreCompilationShard.MODELS_EVALS
                path.startsWith("com/openai/models/finetuning/") ->
                    CoreCompilationShard.MODELS_EVALS
                else -> CoreCompilationShard.MODELS_GENERAL
            }
        }

        if (path.startsWith("com/openai/services/")) return serviceShardFor(path)
        if (path in clientBaseSources) return CoreCompilationShard.CLIENT_BASE
        if (path.startsWith("com/openai/auth/")) return CoreCompilationShard.CLIENT_BASE
        if (path == "com/openai/azure/HttpRequestBuilderExtensions.kt") {
            return CoreCompilationShard.CLIENT_BASE
        }
        if (path == "com/openai/credential/WorkloadIdentityCredential.kt") {
            return CoreCompilationShard.CLIENT_BASE
        }

        if (
            path.startsWith("com/openai/core/") ||
                path.startsWith("com/openai/errors/") ||
                path.startsWith("com/openai/azure/") ||
                path.startsWith("com/openai/credential/")
        ) {
            return CoreCompilationShard.MODELS_COMMON
        }

        return null
    }

    private fun serviceShardFor(path: String): CoreCompilationShard {
        val domain =
            when {
                path.startsWith("com/openai/models/") ->
                    path.substringAfter("com/openai/models/").substringBefore('/')
                path.startsWith("com/openai/services/async/") ->
                    serviceDomain(path.substringAfter("com/openai/services/async/"))
                path.startsWith("com/openai/services/blocking/") ->
                    serviceDomain(path.substringAfter("com/openai/services/blocking/"))
                path.startsWith("com/openai/services/") ->
                    serviceDomain(path.substringAfter("com/openai/services/"))
                else -> "general"
            }

        return when (domain) {
            "admin" -> CoreCompilationShard.SERVICES_ADMIN
            "beta" -> CoreCompilationShard.SERVICES_BETA
            "chat",
            "completions",
            "realtime",
            "responses" -> CoreCompilationShard.SERVICES_RESPONSES
            else -> CoreCompilationShard.SERVICES_GENERAL
        }
    }

    private fun serviceDomain(relativeServicePath: String): String {
        if (relativeServicePath.contains('/')) return relativeServicePath.substringBefore('/')

        return when {
            relativeServicePath.startsWith("AdminService") -> "admin"
            relativeServicePath.startsWith("BetaService") -> "beta"
            relativeServicePath.startsWith("ChatService") -> "chat"
            relativeServicePath.startsWith("CompletionService") -> "completions"
            relativeServicePath.startsWith("RealtimeService") -> "realtime"
            relativeServicePath.startsWith("ResponseService") -> "responses"
            relativeServicePath.startsWith("ResponseStream") -> "responses"
            else -> "general"
        }
    }
}

class CoreCompilationShardSpec(private val shard: CoreCompilationShard) :
    Spec<FileTreeElement>, Serializable {
    override fun isSatisfiedBy(element: FileTreeElement): Boolean =
        element.isDirectory ||
            CoreCompilationShards.shardFor(element.relativePath.pathString) == shard
}

class CoreCompilationClaimedSourceSpec : Spec<FileTreeElement>, Serializable {
    override fun isSatisfiedBy(element: FileTreeElement): Boolean =
        !element.isDirectory &&
            CoreCompilationShards.shardFor(element.relativePath.pathString) != null
}

class CoreCompilationClaimedSourceIncludeSpec : Spec<FileTreeElement>, Serializable {
    override fun isSatisfiedBy(element: FileTreeElement): Boolean =
        element.isDirectory ||
            CoreCompilationShards.shardFor(element.relativePath.pathString) != null
}
