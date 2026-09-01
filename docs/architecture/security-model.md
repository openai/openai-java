# OpenAI Java SDK security model

This is the repository's single canonical detailed threat model. Use it for
security review and Codex Security scans of the revision being reviewed.
SECURITY.md remains the authority for private disclosure and reportability
instructions; this document is the authority for architecture, trust boundaries,
attacker capabilities, security objectives, and severity calibration.

## Overview

This repository publishes Java/Kotlin client libraries rather than a hosted
service. Applications use the transport-neutral core directly or through the
OkHttp transport to construct authenticated requests, send them to an
application-selected API endpoint, and parse ordinary JSON, streaming SSE, and
webhook responses. The optional Bedrock artifact selects and signs AWS/Bedrock
requests. API-side authentication, authorization, tenant isolation, quotas, and
webhook delivery are services outside this repository.

| Component | Purpose and important flow | Evidence |
| --- | --- | --- |
| openai-java-core | Transport-neutral client, generated services and models, request construction, authentication headers, retry/logging wrappers, JSON/SSE parsing, and webhook verification. | CONTRIBUTING.md:48-55; openai-java-core/src/main/kotlin/com/openai/client/OpenAIClientImpl.kt:57-140; openai-java-core/src/main/kotlin/com/openai/core/ClientOptions.kt:747-808 |
| openai-java-client-okhttp | Default HTTP transport, caller-configurable proxy, redirects, timeouts, TLS, and hostname verification. | CONTRIBUTING.md:56-59; openai-java-client-okhttp/src/main/kotlin/com/openai/client/okhttp/OpenAIOkHttpClient.kt:54-65; openai-java-client-okhttp/src/main/kotlin/com/openai/client/okhttp/OkHttpClient.kt:180-242 |
| openai-java | Umbrella artifact exposing core and OkHttp APIs without its own logic. | CONTRIBUTING.md:60-63; openai-java/build.gradle.kts:1-8 |
| openai-java-bedrock | Optional Bedrock endpoint selection and bearer or AWS SigV4 authentication. | CONTRIBUTING.md:60-63; openai-java-bedrock/src/main/kotlin/com/openai/bedrock/BedrockAuth.kt:64-215 |
| Build and release workflows | Unprivileged PR validation and separately gated main-only release/publish jobs. | .github/workflows/ci.yml:3-24; .github/workflows/create-releases.yml:3-25 |

Most SDK sources are generated, but generated and hand-written tracked files are
both repository source once reviewed and checked in. Generation ownership
affects maintenance, not runtime trust. (AGENTS.md:5-8;
openai-java-core/src/main/kotlin/com/openai/client/OpenAIClientImpl.kt:1-5)

### Maven artifact provenance

Official Maven Central releases include GitHub artifact attestations for the
openai-java, openai-java-core, openai-java-client-okhttp, and openai-java-bedrock
binary JARs. Each attestation binds an artifact's digest to the trusted release
workflow, source repository, and commit using short-lived GitHub OpenID Connect
credentials.

After downloading a published JAR from Maven Central, verify its provenance with:

    gh attestation verify path/to/openai-java-VERSION.jar -R openai/openai-java

Maven Central separately requires a publisher token and PGP signatures. Those
credentials remain restricted to the main-only publishing environment and are
not exposed to the attestation action.

| Deployment or workflow | Resource or capability | Configuration and precedence | Safe effective value or location | Readers, writers, or recipients | Enforcing control | Evidence or unknowns |
| --- | --- | --- | --- | --- | --- | --- |
| Normal SDK client | API destination and credentials | Builder setters and fromEnv() apply in call order; within fromEnv(), system properties take precedence over environment variables | Default https://api.openai.com/v1; caller may select another base URL | Configured API host receives request data and credentials | Embedding application owns configuration; SDK constructs auth headers | openai-java-core/src/main/kotlin/com/openai/core/ClientOptions.kt:151-172; openai-java-core/src/main/kotlin/com/openai/core/ClientOptions.kt:601-665; openai-java-core/src/main/kotlin/com/openai/core/ClientOptions.kt:828-876 |
| Generic workload identity | Subject token and exchanged access token | Caller-selected provider; Kubernetes provider defaults its token path | Fixed exchange URL https://auth.openai.com/oauth/token; Kubernetes default /var/run/secrets/kubernetes.io/serviceaccount/token | Auth endpoint, then configured API host | Provider selection and auth wrapper | openai-java-core/src/main/kotlin/com/openai/auth/WorkloadIdentityAuth.kt:24-34; openai-java-core/src/main/kotlin/com/openai/auth/K8sServiceAccountTokenProvider.kt:14-60; openai-java-core/src/main/kotlin/com/openai/core/http/WorkloadIdentityHttpClient.kt:13-54 |
| X.509 workload identity | Caller-held private-key capability | Caller supplies a fixed-alias key manager | Approved issuer and mTLS API HTTPS hosts | mtls.auth.openai.com and approved mTLS API hosts | HTTPS/443 allowlist, fixed alias, direct connection, redirects disabled | openai-java-client-okhttp/src/main/kotlin/com/openai/client/okhttp/X509Transport.kt:17-28; openai-java-client-okhttp/src/main/kotlin/com/openai/client/okhttp/X509Transport.kt:110-145; openai-java-client-okhttp/src/main/kotlin/com/openai/client/okhttp/X509WorkloadIdentityAuthenticator.kt:61-75 |
| Bedrock client | Bearer credential or AWS signing capability | Explicit options, environment, profile/provider, or AWS default chain | Explicit base URL or derived regional /openai/v1 endpoint | Configured or derived Bedrock host | Auth-mode exclusivity and canonical endpoint checks | openai-java-bedrock/src/main/kotlin/com/openai/bedrock/BedrockAuth.kt:64-215; openai-java-bedrock/src/main/kotlin/com/openai/bedrock/BedrockAuth.kt:303-318 |
| PR and merge-queue CI | Cross-run Gradle cache and same-run build output | Cache is read-only outside default branch; build job uploads exact-run artifact | GitHub-scoped cache plus artifact ID/digest-bound handoff | Jobs in the same unprivileged run | GitHub cache scope; immutable artifact and digest mismatch rejection | .github/workflows/ci.yml:8-20; .github/workflows/ci.yml:92-124; .github/workflows/ci.yml:152-166 |
| Maven Central publish | Release source, private Gradle home, publishing secrets, and attestation authority | Verified source SHA/tag; publish environment injects secrets only in publish job | runner.temp/trusted-release-gradle-run_id-run_attempt, created fresh with mode 700; cross-run cache disabled | Publish job, Maven Central, and GitHub attestation service | Main/release gating, protected environment, source verification, isolated cache | .github/workflows/create-releases.yml:241-290; .github/workflows/create-releases.yml:324-424; .github/workflows/create-releases.yml:426-469 |

## Threat model, trust boundaries, and assumptions

### Protected assets and security objectives

- API and admin keys, webhook secrets, AWS credentials and signatures,
  workload-identity subject/access tokens, X.509 private-key capabilities,
  customer request/response bodies, and destination integrity must not reach an
  unauthorized network destination or uncontrolled diagnostic sink.
- Independently mutable API responses, SSE events, and webhook bytes must remain
  data until the relevant parser, validation, or webhook signature boundary has
  accepted them. The default mapper disables broad scalar coercion and automatic
  property discovery. (openai-java-core/src/main/kotlin/com/openai/core/ObjectMappers.kt:34-116)
- Webhook payloads must be authenticated before typed parsing: required headers,
  timestamp tolerance, HMAC-SHA256, and timing-safe comparison precede unwrap
  JSON parsing. (openai-java-core/src/main/kotlin/com/openai/services/WebhookVerification.kt:19-99;
  openai-java-core/src/main/kotlin/com/openai/services/blocking/WebhookServiceImpl.kt:26-51)
  The timestamp tolerance bounds freshness; the SDK does not deduplicate
  accepted webhook IDs, so replay deduplication remains the embedding
  application's responsibility.
- Large JSON bodies and streaming events are supported API contracts. Reviews
  should prefer incremental processing, cleanup, and cancellation; a large
  payload is not by itself hostile or malformed. (AGENTS.md:49-66)
- Main-branch integrity, protected release credentials, GPG signing material,
  OIDC attestation authority, artifact/source binding, and Gradle cache isolation
  must remain unreachable from unmerged PR code.

### Actors, capabilities, and boundaries

- An SDK caller controls model parameters, request bodies, local files or
  streams supplied for uploads, and client configuration such as base URL,
  credentials, custom headers, JSON mapper, transport, proxy, TLS, redirects,
  logging, retries, and timeouts. These are caller-authorized capabilities, not
  attacker input by default. They become a real boundary when an embedding
  application lets a lower-trust actor mutate them independently.
- An API, webhook sender, network peer, proxy, or compromised upstream response
  can supply bytes independently of the checkout. JSON, SSE, webhook, header,
  redirect, and error-body handling are therefore real parser and sensitive-sink
  boundaries. (openai-java-core/src/main/kotlin/com/openai/core/handlers/SseHandler.kt:19-60;
  openai-java-core/src/main/kotlin/com/openai/core/http/SseMessage.kt:42-63)
- A pull-request author controls the candidate tracked checkout, including
  examples, tests, fixtures, generated files, build scripts, and workflow edits.
  Ordinary PR CI intentionally executes that checkout with repository-code
  authority. Running those tracked executable files does not grant the author a
  new privilege, and their contents are not a separate lower-trust input
  relative to the job already executing the PR. This does not suppress a
  boundary where independently mutable data enters a parser/evaluator, where
  runtime/network data reaches a sensitive sink, or where PR-controlled code can
  reach protected CI or release credentials.
- Candidate Git objects can still be lower-trust data when a separately
  privileged workflow evaluates them. The workflow_run custom-code workflow
  checks out trusted main, computes from current PR Git objects, and freshness
  checks the exact head before publishing status; breaking that evaluator boundary
  remains a security finding. (.github/workflows/castiron-custom-code-comment.yml:34-57;
  .github/workflows/castiron-custom-code-comment.yml:74-98;
  .github/workflows/castiron-custom-code-comment.yml:128-181)
- Merged, reviewed repository source intentionally executes with trusted
  build/release authority. The security boundary is externally enforced branch
  governance, CODEOWNERS/rulesets, verified release selection, and protected
  environments—not an imagined sandbox around checked-in source.

### Gradle cache accepted risk and assumptions

The Kotlin Gradle plugin used by this repository is affected by
[CVE-2026-53914](https://github.com/advisories/GHSA-r937-wjx7-w2jp), a
build-tooling issue not published as an SDK runtime dependency. The first
upstream fix is Kotlin 2.4.20-Beta1; production must not move to that beta
solely for this alert. Once a stable Kotlin release at or above 2.4.20 is
available, upgrade both Kotlin plugin declarations in buildSrc and rerun
publishing, Jackson compatibility, and Java 8 consumer/runtime compatibility
coverage before removing this temporary risk acceptance.

The relevant boundary is GitHub's server-enforced cache scope: pull-request
writes are confined to `refs/pull/<number>/merge`. They cannot write to the default-branch cache scope
or populate privileged release cache scopes, and PR/merge-queue jobs request
cross-run caches read-only. Same-run compilation output is passed only through
an immutable artifact identified by the producing job's artifact ID and rejected
on digest mismatch. Publishing creates a fresh private Gradle User Home,
refuses an existing path or symlink, and disables cross-run restore/save.
(.github/workflows/ci.yml:8-20; .github/workflows/ci.yml:104-129;
.github/workflows/ci.yml:152-166; .github/workflows/create-releases.yml:273-290)

This model assumes GitHub cache scoping, repository rulesets/CODEOWNERS, and
protected environments are externally enforced, and that the configured runner
is GitHub-hosted or equivalently isolated. It does not protect a runner already
compromised before trusted code starts. These controls are documented repository
assumptions rather than facts independently verifiable from source.

Pull-request code and its proposed tests are not a security boundary relative to
the unprivileged job that intentionally executes them. Changes to trusted
default-branch workflows must pass the repository's externally enforced ruleset
and the base branch's CODEOWNERS approval. See
[GitHub's dependency cache access restrictions](https://docs.github.com/en/actions/reference/workflows-and-actions/dependency-caching#restrictions-for-accessing-a-cache).

### Codex Security cloud scan configuration

No repository-owned Codex Security cloud configuration or second threat-model
document is checked in. When a cloud scan can read the scanned revision, its
editable Markdown threat-model field should contain only a short pointer:
"Load docs/architecture/security-model.md from the scanned revision and use it
as the canonical detailed threat model." If the scan cannot read that revision
or the field is unavailable or not editable, report that exact blocker instead
of pasting or creating a duplicate model.

## Attack surface, mitigations, and attacker stories

These are review hypotheses, not confirmed findings.

| Priority | Scenario and capability gain | Prerequisites | Impact | Existing controls | Mitigation | Evidence |
| --- | --- | --- | --- | --- | --- | --- |
| High | PR-controlled code reaches protected release credentials or signing/attestation authority before merge/release governance. | A workflow trigger, checkout ref, artifact restore, or environment gate is weakened. | Credential theft or forged official artifacts. | Release is main/schedule/manual only, selects/verifies source, gates runtime compatibility, uses protected publish, and disables release cache reuse. | Preserve source binding, least permissions, environment protection, and no PR artifact/cache import. | .github/workflows/create-releases.yml:3-25; .github/workflows/create-releases.yml:90-164; .github/workflows/create-releases.yml:241-290; .github/workflows/create-releases.yml:426-469 |
| High | Untrusted webhook bytes are parsed or acted on without valid signature/freshness checks. | Embedding application exposes webhook ingress and relies on SDK verification. | Forged event acceptance. | Required headers, bounded timestamp tolerance, HMAC-SHA256, timing-safe compare, then parse; no replay deduplication. | Preserve verify-before-parse ordering and focused regression tests; embedding applications must deduplicate accepted webhook IDs when replay matters. | openai-java-core/src/main/kotlin/com/openai/services/WebhookVerification.kt:19-99; openai-java-core/src/main/kotlin/com/openai/services/blocking/WebhookServiceImpl.kt:33-41 |
| Medium | Independently mutable API/SSE JSON crosses a parser boundary and causes unsafe interpretation, resource exhaustion, or sensitive exception/log output. | Attacker controls an API/network response or configured proxy; sink is reachable in caller deployment. | Client failure, data exposure, or downstream misuse. | Strict mapper defaults, typed parsing, stream iteration, and explicit DEBUG diagnostics. | Keep parsing robust and large-payload-compatible; avoid treating model output as executable authority without caller controls. | openai-java-core/src/main/kotlin/com/openai/core/ObjectMappers.kt:34-116; openai-java-core/src/main/kotlin/com/openai/core/handlers/SseHandler.kt:19-60; AGENTS.md:49-66 |
| Medium | Credentials or customer payloads reach an unintended destination or uncontrolled log. | Lower-trust actor independently controls base URL/proxy/TLS/log sink, or diagnostics are enabled in an unsafe deployment. | Secret or customer-data disclosure. | Production URL default, caller-owned configuration, auth wrappers, and default sensitive-header redaction; DEBUG is explicit. | Preserve redaction and destination/TLS controls; document caller obligations. | openai-java-core/src/main/kotlin/com/openai/core/ClientOptions.kt:151-172; openai-java-core/src/main/kotlin/com/openai/core/ClientOptions.kt:601-665; openai-java-core/src/main/kotlin/com/openai/core/http/LoggingHttpClient.kt:24-48; openai-java-core/src/main/kotlin/com/openai/core/http/LoggingHttpClient.kt:91-142 |
| Medium | A separately privileged evaluator consumes mutable PR Git objects, artifacts, or cache entries as trusted code/data. | Privileged workflow reads candidate state without binding/ref validation. | Privilege crossing beyond ordinary PR CI. | Custom-code workflow checks out main, uses current PR objects, and freshness-checks exact head; PR cache scope remains isolated. | Preserve trusted checkout and exact-head/digest binding. | .github/workflows/castiron-custom-code-comment.yml:34-57; .github/workflows/castiron-custom-code-comment.yml:128-181; .github/workflows/ci.yml:120-129 |
| Low / not a boundary by itself | A PR changes a checked-in example, test, fixture, build script, or generated source and ordinary PR CI executes it. | The same PR author already controls the tracked executable checkout. | No new capability beyond the unprivileged PR job. | PR CI has read-only contents and no release credentials; cache scope is enforced outside PR code. | Investigate only if execution crosses an independent input or protected-authority boundary. | .github/workflows/ci.yml:8-20; .github/workflows/ci.yml:33-48; .github/workflows/ci.yml:92-107 |

## Severity calibration (critical, high, medium, low)

- Critical: a broadly reachable path from lower-trust input to compromise of
  official Maven artifacts, protected signing credentials, or many callers'
  secrets with no meaningful prerequisite. Changing tracked PR code that only
  executes in its own unprivileged PR job is not such a path.
- High: a realistic bypass of webhook authenticity, credential-destination
  integrity, or release/CI isolation that grants authority the attacker did not
  already possess. Required protected-environment access, trusted-runner
  compromise, or branch-governance bypass can lower confidence or severity.
- Medium: a deployment-dependent parser, proxy, logging, redirect, upload, or
  resource-handling flaw where independently mutable runtime data reaches a
  sensitive sink or meaningful denial of service. State the embedding
  application's exposure and caller-controlled configuration prerequisite.
- Low: narrow, self-only, or hard-to-reach defects with limited impact.
  Ordinary authorized SDK behavior, unsupported deployment assumptions, and
  execution of intentionally executable tracked repository code without an
  additional privilege gain are not security findings by themselves.
