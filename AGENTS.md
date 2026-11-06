# Agent instructions

Read [CONTRIBUTING.md](CONTRIBUTING.md) and [SECURITY.md](SECURITY.md) before changes. `.castiron.stats.yml` records generation metadata.

## Generated-file ownership

Follow [Generated-file ownership](CONTRIBUTING.md#generated-file-ownership) before editing SDK files.

## Security requirements

Apply [Security expectations](CONTRIBUTING.md#security-expectations) for credentials, diagnostics, dependency/build integrity, action pins, publishing permissions, security review, and private disclosure. Additional requirements:

- Ordinary unit/PR tests must be offline and credential-free. Explicitly opt-in live integration tests (e.g. `BedrockRuntimeLiveTest`) may use dedicated least-privilege credentials and synthetic inputs; never log credentials or customer data.
- Keep cookie headers and sensitive data out of default/uncontrolled traces as well as logs, errors, and test output. Preserve documented `OpenAIServiceException.body()`, API-error/validation messages, and explicitly enabled `DEBUG` request/response body logging. Warn before enabling sensitive diagnostics; use sanitized fixtures and redact before forwarding to untrusted sinks.
- Review download scripts and pinned Action updates; avoid untrusted artifacts, repositories, or executable installation hooks. Disable persisted checkout credentials; keep GitHub App tokens within protected release/publishing environments.
- Security-focused review also covers base URLs, proxies, header forwarding, Jackson serialization/polymorphic types, and publication logic. Use boundary-appropriate regression coverage: JUnit/WireMock for SDK behavior; workflow, Gradle, or shell checks for signing/release/publication.

## Large-payload compatibility

Large `application/json` bodies and streaming events are normal Responses, Chat Completions, and other API output. Do not add arbitrary fixed body/event/line limits as security or efficiency fixes. Any new rejection limit requires an explicit owner-approved API contract and review of supported payloads/transports. Preserve longstanding dependency limits unless changing them is explicitly in scope. Prefer incremental processing, amortized-linear buffering, timely cleanup, and caller cancellation.

Use deterministic public-entrypoint tests with large synthetic in-memory payloads supported by recent SDK releases, not committed captures/live image generation. High memory use is intentional: do not shrink payloads or raise client limits to pass tests. Cover the main JSON/streaming categories; run large cases sequentially. Fixture sizes are regression probes, not new API maxima.
