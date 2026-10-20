# Agent instructions

Read [CONTRIBUTING.md](CONTRIBUTING.md) and [SECURITY.md](SECURITY.md) before making changes.

Most SDK sources are generated; `.castiron.stats.yml` records generation metadata. Check whether the
generator owns the code you are changing, preserve existing generated behavior, and update the
authoritative source when it is available. The `openai-java-example/` directory is not modified by
the generator.

## Custom-code budget

Follow [the custom-code guidance](scripts/castiron/CUSTOM_CODE.md). Budget changes
belong in a separate PR containing only `.castiron-ratchet.json`, with an explicit justification
in the PR description. Increases require a **human approving review** before merging.
Agents may investigate and draft proposals, but must not approve budget increases
(including through a human's credentials) or bypass the gate. Do not weaken
counting, broaden exclusions, or alter generation metadata to make a change pass.
The checker and effective budget come from main, not the PR. Keep default CODEOWNERS.

## Security requirements

- Never commit OpenAI API keys, bearer tokens, AWS/Bedrock credentials, Sonatype tokens, GPG private
  keys or passphrases, or any other secrets. Read credentials from environment variables such as
  `OPENAI_API_KEY`; use obviously fake values in examples, JUnit/WireMock fixtures, recordings, and
  snapshots. Keep ordinary unit and pull-request tests offline and free of real credentials.
  Purpose-built, explicitly opt-in live integration tests such as `BedrockRuntimeLiveTest` may use
  dedicated, least-privilege credentials and synthetic inputs; never log credentials or customer
  data.
- Keep credentials, authorization or cookie headers, signed requests, and real customer data out of
  default or uncontrolled logs, errors, traces, and test output. Preserve documented diagnostics,
  including `OpenAIServiceException.body()`, API-error and validation messages, and explicitly
  enabled `DEBUG` request/response body logging. Warn before enabling sensitive diagnostics, use
  sanitized fixtures, and redact before forwarding data to untrusted sinks.
- Review direct and transitive Maven dependencies, Gradle plugins and repositories, the Gradle
  wrapper and distribution integrity, dependency locks, and build/install/download scripts before
  changing them. Avoid untrusted artifacts, repositories, and executable installation hooks.
- Pin third-party GitHub Actions to full immutable commit SHAs and review updates. Keep workflow and
  publishing permissions minimal, disable persisted checkout credentials, never expose secrets to
  untrusted pull requests, and keep GitHub App tokens, Sonatype credentials, and GPG signing material
  within their protected release or publishing environments.
- Require security-focused review for changes to API-key or Bedrock/AWS authentication; OkHttp
  transport, base URLs, redirects, proxies, TLS, or header forwarding; file uploads and path
  handling; Jackson serialization/deserialization or polymorphic types; and signing, release, or
  publication logic. Add focused, boundary-appropriate regression coverage: JUnit/WireMock tests for
  SDK behavior and workflow, Gradle, or shell checks for signing, release, and publication logic.
- Report suspected vulnerabilities privately through [SECURITY.md](SECURITY.md). Do not open public
  issues, discussions, or pull requests containing vulnerability details or secrets.

## Large-payload compatibility

Treat large payloads as a normal API contract, not evidence of malformed or
hostile input. Responses, Chat Completions, and other APIs can legitimately
return large `application/json` bodies and streaming events. Do not introduce
new arbitrary fixed limits on bodies, events, or lines as a security or efficiency fix.
Prefer incremental processing, amortized-linear buffering, timely cleanup, and
caller cancellation. Any new rejection limit needs an explicit, owner-approved
API contract and a review of existing supported payloads and transports.
Preserve longstanding dependency limits unless changing them is explicitly in scope;
regression fixtures should exercise payloads supported by recent SDK releases.

Protect this behavior with focused, deterministic public-entrypoint tests using
large synthetic payloads generated in memory, not committed captures or live
image generation. Their high memory use is intentional: do not shrink the
payloads or raise client limits to make the tests pass. Keep coverage to the main
JSON and streaming categories, and run large cases sequentially to keep peak
memory reasonable. The fixture size is a regression probe, not a new API maximum.
