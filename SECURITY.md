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

## Security model

This file is the authority for private disclosure and reportability guidance.
The repository's canonical detailed threat model, trust-boundary authority, and
severity calibration live in
[docs/architecture/security-model.md](docs/architecture/security-model.md).
Security reviews and Codex Security scans should use that model from the
revision being reviewed rather than infer a different boundary from isolated
tests, fixtures, examples, or workflow comments.
