# Security Policy

## Reporting a vulnerability

Please report security vulnerabilities privately through OpenAI's
[coordinated vulnerability disclosure process](https://openai.com/policies/coordinated-vulnerability-disclosure-policy).
For questions about that process, contact disclosure@openai.com.

Do not report security vulnerabilities through public GitHub issues, pull requests, or discussions.

This policy covers source code in this repository and the official `com.openai`
Maven artifacts `openai-java`, `openai-java-core`,
`openai-java-client-okhttp`, and `openai-java-bedrock`. Supported releases are
described in the [Java version support policy](docs/version-support-policy.md).

## What to include

When reporting a vulnerability, include:

- The affected package or product and version, or the affected Git commit.
- A clear description of the security impact.
- Sanitized reproduction steps or a minimal proof of concept using fake credentials.
- Relevant Java runtime, operating system, and integration details, such as
  OkHttp or Amazon Bedrock.
- Any known mitigations or workarounds.

Do not include live credentials, API keys, customer data, or unredacted sensitive logs.

Also redact access tokens, authorization headers, webhook secrets, AWS credentials,
Sonatype tokens, and private signing keys before submitting a report.

## Coordinated disclosure

Please give the maintainers a reasonable opportunity to investigate and address the issue before public disclosure.

Thank you for helping us keep this SDK and the systems it interacts with secure.

## Gradle Build Cache Trust

The Kotlin Gradle plugin used to build this SDK is affected by
[CVE-2026-53914](https://github.com/advisories/GHSA-r937-wjx7-w2jp), which can
execute code when malicious Kotlin build-cache metadata is deserialized. This is
a build-tooling vulnerability; the affected plugin is not published as an SDK
runtime dependency.

The primary trust boundary is enforced by GitHub's cache service, not by code
from a pull request. GitHub scopes every `pull_request` cache write to
`refs/pull/<number>/merge`. These runs
cannot write to the default-branch cache scope, and their entries cannot be
restored by `main`, other pull requests, or privileged release workflows. See
[GitHub's dependency cache access restrictions](https://docs.github.com/en/actions/reference/workflows-and-actions/dependency-caching#restrictions-for-accessing-a-cache).

Pull-request CI additionally requests read-only cross-run Gradle caches, but this
input and its proposed tests are not a security boundary: an untrusted author can
change either without bypassing GitHub's server-enforced cache scope. Changes to
trusted default-branch workflows must pass the repository's externally enforced
ruleset and the base branch's CODEOWNERS approval before they can affect trusted
`push`, scheduled, or manual workflows.

Compilation outputs are shared only between jobs in the same unprivileged
workflow run and attempt through an immutable artifact, identified by the
producing job's artifact ID and rejected if its SHA-256 digest does not match.
These artifacts must never be restored by release, signing, or other
secret-bearing jobs.

Maven Central publishing instead creates a new, private Gradle User Home for
each workflow run and attempt, refuses an existing directory or symbolic link,
and disables all cross-run Gradle cache restoration and saving. Gradle invocations
within the publishing job still reuse the trusted cache created by that job.
This boundary assumes an ephemeral GitHub-hosted runner or an equivalently
isolated, trusted self-hosted runner; it cannot protect a runner that untrusted
code has already compromised.

The first upstream fix is Kotlin `2.4.20-Beta1`; while no stable patched release
is available, the production compiler must not be upgraded to that beta solely to
close this alert. Cache isolation reduces the exposure but does not fix the
vulnerable plugin: malicious trusted inputs, compromised upstream dependencies,
or a compromised runner remain risks. Once a stable Kotlin release at or above
`2.4.20` is available, upgrade both Kotlin plugin declarations in `buildSrc`,
review Gradle and embedded Kotlin compatibility, and rerun publishing, Jackson
compatibility, and the Java 8 consumer/runtime compatibility matrix before
removing the temporary risk acceptance.
