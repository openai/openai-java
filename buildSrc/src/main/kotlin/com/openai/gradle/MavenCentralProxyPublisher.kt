package com.openai.gradle

import groovy.json.JsonSlurper
import java.net.URI
import java.net.URLDecoder
import java.net.URLEncoder
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpRequest.BodyPublishers
import java.net.http.HttpResponse.BodyHandlers
import java.nio.file.Files
import java.nio.file.Path
import java.security.MessageDigest
import java.time.Duration
import java.util.UUID
import java.util.zip.ZipEntry
import java.util.zip.ZipOutputStream
import org.gradle.api.GradleException
import org.gradle.api.Project
import org.gradle.api.publish.PublishingExtension
import org.gradle.api.publish.maven.MavenPublication

/** Release-only transport. Credentials stay in memory and uploads are never retried. */
class MavenCentralProxyPublisher(
    private val environment: Map<String, String> = System.getenv(),
    private val send: (URI, String?, HttpRequest.BodyPublisher?, String?) -> String = ::sendHttp,
    private val receipt: (String) -> Unit = ::record,
    private val clock: () -> Long = { System.nanoTime() / 1_000_000_000 },
    private val sleep: (Long) -> Unit = Thread::sleep,
) {
    private var accessToken = ""
    private var expiresAt = 0L

    internal fun token(): String {
        if (expiresAt > clock() + 60) return accessToken
        val tenant = UUID.fromString(environment.getValue("MAVEN_CENTRAL_AZURE_TENANT_ID"))
        val client = UUID.fromString(environment.getValue("MAVEN_CENTRAL_AZURE_CLIENT_ID"))
        val resource = environment.getValue("MAVEN_CENTRAL_AZURE_RESOURCE")
        check(resource.isNotBlank() && !resource.endsWith("/.default"))
        val endpoint = httpsUri(environment.getValue("ACTIONS_ID_TOKEN_REQUEST_URL"))
        check(endpoint.host.endsWith(".actions.githubusercontent.com"))
        val query =
            endpoint.rawQuery.orEmpty().split('&').filter {
                it.isNotEmpty() && URLDecoder.decode(it.substringBefore('='), "UTF-8") != "audience"
            } + "audience=${encode("api://AzureADTokenExchange") }"
        val oidcUri = URI(endpoint.toString().substringBefore('?') + "?" + query.joinToString("&"))
        val assertion =
            json(send(oidcUri, environment.getValue("ACTIONS_ID_TOKEN_REQUEST_TOKEN"), null, null))[
                "value"]
                as String
        val form =
            mapOf(
                    "client_id" to client.toString(),
                    "scope" to resource.trimEnd('/') + "/.default",
                    "grant_type" to "client_credentials",
                    "client_assertion_type" to
                        "urn:ietf:params:oauth:client-assertion-type:jwt-bearer",
                    "client_assertion" to assertion,
                )
                .entries
                .joinToString("&") { "${encode(it.key)}=${encode(it.value)}" }
        val response =
            json(
                send(
                    URI("https://login.microsoftonline.com/$tenant/oauth2/v2.0/token"),
                    null,
                    BodyPublishers.ofString(form),
                    "application/x-www-form-urlencoded",
                )
            )
        accessToken = response["access_token"] as String
        val lifetime = response["expires_in"].toString().toLong()
        check(accessToken.isNotEmpty() && lifetime > 0)
        expiresAt = clock() + lifetime
        return accessToken
    }

    internal fun publish(archive: Path) {
        val origin = httpsUri(environment.getValue("MAVEN_CENTRAL_AUTH_PROXY_URL"))
        check(origin.path in setOf("", "/") && origin.rawQuery == null)
        val base = origin.toString().trimEnd('/') + "/api/v1/publisher"
        val boundary = UUID.randomUUID().toString()
        val body =
            BodyPublishers.concat(
                BodyPublishers.ofString(
                    "--$boundary\r\nContent-Disposition: form-data; name=\"bundle\"; filename=\"bundle.zip\"\r\nContent-Type: application/octet-stream\r\n\r\n"
                ),
                BodyPublishers.ofFile(archive),
                BodyPublishers.ofString("\r\n--$boundary--\r\n"),
            )
        val credential = token()
        receipt(
            "Submitting Maven bundle. If no deployment ID follows, inspect Central Portal before retrying."
        )
        val deployment =
            try {
                UUID.fromString(
                    send(
                            URI("$base/upload?publishingType=USER_MANAGED"),
                            credential,
                            body,
                            "multipart/form-data; boundary=$boundary",
                        )
                        .trim()
                )
            } catch (_: Exception) {
                throw GradleException(
                    "Upload outcome unknown. Inspect Central Portal; do not automatically resubmit."
                )
            }
        receipt("Maven Central deployment ID: $deployment")
        val deadline = clock() + 15 * 60
        var released = false
        while (clock() < deadline) {
            val state =
                json(
                    send(URI("$base/status?id=$deployment"), token(), BodyPublishers.noBody(), null)
                )["deploymentState"]
            when (state) {
                "PUBLISHED" -> return
                "VALIDATED" ->
                    if (!released) {
                        send(
                            URI("$base/deployment/$deployment"),
                            token(),
                            BodyPublishers.noBody(),
                            null,
                        )
                        released = true
                    }
                "PENDING",
                "VALIDATING",
                "PUBLISHING" -> Unit
                else ->
                    throw GradleException(
                        "Central validation failed or returned an unknown state; inspect the deployment ID"
                    )
            }
            sleep(5000)
        }
        throw GradleException(
            "Central polling timed out; inspect the recorded deployment ID before retrying"
        )
    }

    internal data class Inventory(
        val files: Set<String>,
        val optionalMetadata: Set<String>,
        val attestedJars: Map<String, String>,
    )

    companion object {
        private val httpClient =
            HttpClient.newBuilder()
                .followRedirects(HttpClient.Redirect.NEVER)
                .connectTimeout(Duration.ofSeconds(30))
                .build()

        private fun encode(value: String) = URLEncoder.encode(value, "UTF-8")

        private fun json(value: String) = JsonSlurper().parseText(value) as Map<*, *>

        internal fun httpsUri(value: String): URI =
            URI(value).also {
                check(
                    it.scheme == "https" &&
                        !it.host.isNullOrEmpty() &&
                        it.rawUserInfo == null &&
                        it.rawFragment == null
                )
            }

        internal fun sendHttp(
            uri: URI,
            token: String?,
            body: HttpRequest.BodyPublisher?,
            contentType: String?,
        ): String {
            httpsUri(uri.toString())
            try {
                val request = HttpRequest.newBuilder(uri).timeout(Duration.ofSeconds(120))
                if (token != null) request.header("Authorization", "Bearer $token")
                if (contentType != null) request.header("Content-Type", contentType)
                if (body != null) request.POST(body)
                // A separate --no-daemon Gradle invocation owns this short-lived client.
                val response = httpClient.send(request.build(), BodyHandlers.ofString())
                if (response.statusCode() !in 200..299) {
                    throw GradleException(
                        "Publishing request returned HTTP ${response.statusCode()}; body suppressed"
                    )
                }
                return response.body()
            } catch (error: GradleException) {
                throw error
            } catch (_: Exception) {
                // Do not attach transport exceptions: they can include request credentials.
                throw GradleException("Publishing transport failed; reconcile before retrying")
            }
        }

        internal fun digest(path: Path, algorithm: String = "SHA-256"): String {
            val digest = MessageDigest.getInstance(algorithm)
            path.toFile().inputStream().use { input ->
                val buffer = ByteArray(64 * 1024)
                while (true) {
                    val count = input.read(buffer)
                    if (count < 0) break
                    digest.update(buffer, 0, count)
                }
            }
            return digest.digest().joinToString("") { "%02x".format(it) }
        }

        // Read the finalized publication model at task execution, not during configuration.
        internal fun inventory(projects: Iterable<Project>, version: String): Inventory {
            check(version.isNotBlank() && !version.endsWith("-SNAPSHOT"))
            val files = linkedSetOf<String>()
            val metadata = linkedSetOf<String>()
            val jars = linkedMapOf<String, String>()
            projects.forEach { project ->
                project.extensions
                    .findByType(PublishingExtension::class.java)
                    ?.publications
                    ?.withType(MavenPublication::class.java)
                    ?.forEach { publication ->
                        check(publication.version == version)
                        val prefix =
                            "${publication.groupId.replace('.', '/')}/${publication.artifactId}/$version/${publication.artifactId}-$version"
                        check(files.add("$prefix.pom"))
                        metadata.add("$prefix.module")
                        publication.artifacts.forEach { artifact ->
                            val classifier =
                                artifact.classifier
                                    ?.takeIf { it.isNotEmpty() }
                                    ?.let { "-$it" }
                                    .orEmpty()
                            val name = "$prefix$classifier.${artifact.extension}"
                            check(files.add(name))
                            if (artifact.extension == "jar" && classifier.isEmpty()) {
                                jars[name] =
                                    project.rootDir.canonicalFile
                                        .toPath()
                                        .relativize(artifact.file.canonicalFile.toPath())
                                        .toString()
                                        .replace('\\', '/')
                            }
                        }
                    }
            }
            check(files.isNotEmpty())
            (files + metadata).forEach { name ->
                check(
                    !Path.of(name).isAbsolute &&
                        name.split('/').none { it.isEmpty() || it == "." || it == ".." } &&
                        '\\' !in name
                )
            }
            return Inventory(files, metadata, jars)
        }

        internal fun bundle(
            staging: Path,
            output: Path,
            inventory: Inventory,
            provenance: Path,
            verifySignature: (Path) -> Boolean = { signature ->
                ProcessBuilder(
                        "gpg",
                        "--batch",
                        "--verify",
                        signature.toString(),
                        signature.toString().removeSuffix(".asc"),
                    )
                    .redirectOutput(ProcessBuilder.Redirect.DISCARD)
                    .redirectError(ProcessBuilder.Redirect.DISCARD)
                    .start()
                    .waitFor() == 0
            },
        ) {
            check(!Files.isSymbolicLink(staging) && Files.isDirectory(staging))
            val digests = linkedMapOf<String, String>()
            Files.readAllLines(provenance).forEach { line ->
                val parts = line.split("  ", limit = 2)
                check(parts.size == 2 && parts[0].matches(Regex("[0-9a-f]{64}")))
                check(digests.put(parts[1], parts[0]) == null)
            }
            val algorithms =
                mapOf(
                    "md5" to "MD5",
                    "sha1" to "SHA-1",
                    "sha256" to "SHA-256",
                    "sha512" to "SHA-512",
                )
            val required = mutableSetOf<String>()
            val allowed = mutableSetOf<String>()
            val jars = linkedMapOf<String, String>()
            inventory.files.forEach { required.addAll(listOf(it, "$it.asc")) }
            (inventory.files + inventory.optionalMetadata).forEach { name ->
                listOf(name, "$name.asc").forEach { file ->
                    allowed.add(file)
                    allowed.addAll(algorithms.keys.map { "$file.$it" })
                }
            }
            jars.putAll(inventory.attestedJars)
            check(digests.keys == jars.values.toSet())
            val files = linkedMapOf<String, Path>()
            Files.walk(staging).use { paths ->
                paths.forEach { path ->
                    check(!Files.isSymbolicLink(path))
                    if (
                        Files.isRegularFile(path) &&
                            !path.fileName.toString().startsWith("maven-metadata.xml")
                    ) {
                        val name = staging.relativize(path).toString().replace('\\', '/')
                        check(name in allowed && Files.size(path) > 0)
                        files[name] = path
                    }
                }
            }
            check(files.keys.containsAll(required))
            files.forEach { (name, path) ->
                val algorithm = algorithms[name.substringAfterLast('.')]
                if (algorithm != null) {
                    check(
                        digest(
                            path.resolveSibling(path.fileName.toString().substringBeforeLast('.')),
                            algorithm,
                        ) == Files.readString(path).trim().lowercase()
                    )
                } else if (!name.endsWith(".asc")) {
                    check("$name.asc" in files)
                }
                jars[name]?.let { check(digest(path) == digests[it]) }
                if (name.endsWith(".asc")) check(verifySignature(path))
            }
            ZipOutputStream(Files.newOutputStream(output)).use { zip ->
                files.toSortedMap().forEach { (name, path) ->
                    zip.putNextEntry(ZipEntry(name))
                    Files.copy(path, zip)
                    zip.closeEntry()
                }
            }
        }

        private fun record(message: String) {
            println(message)
            System.getenv("GITHUB_STEP_SUMMARY")?.let {
                Path.of(it).toFile().appendText("$message\n\n")
            }
        }

        fun run(root: Project) {
            val archive = Files.createTempFile("maven-release-", ".zip")
            try {
                check(System.getProperty("jdk.httpclient.redirects.retrylimit") == "1") {
                    "Start the uploader JVM with -Djdk.httpclient.redirects.retrylimit=1"
                }
                val environment = System.getenv()
                bundle(
                    root.layout.buildDirectory.dir("auth-proxy-staging").get().asFile.toPath(),
                    archive,
                    inventory(
                        root.allprojects,
                        environment.getValue("RELEASE_TAG").removePrefix("v"),
                    ),
                    Path.of(environment.getValue("RUNNER_TEMP"), "maven-artifact-provenance.sha256"),
                )
                record("Maven bundle SHA-256: ${digest(archive)}")
                MavenCentralProxyPublisher(environment).publish(archive)
            } catch (error: GradleException) {
                throw error
            } catch (_: Exception) {
                // Configuration, parser and subprocess exceptions can contain sensitive data.
                throw GradleException(
                    "Publishing failed. Inspect the deployment receipt and configuration before retrying."
                )
            } finally {
                Files.deleteIfExists(archive)
            }
        }
    }
}
