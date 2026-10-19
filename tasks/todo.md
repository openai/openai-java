# Java generated/custom transition tasks

See [the measured plan and per-file inventory](plan.md). User authorization covers
implementation and PR submission; normal review and compiler-before-promotion
gates remain in effect. No developer-facing breaking changes are allowed.

## Foundation

- [x] Verify current public generated snapshot and measure every mixed file.
- [x] Classify runtime, models, services, tests, and tooling with exact patch counts.
- [x] Record compiler ownership, compatibility gates, parallel work and dependencies.
- [x] Publish inventory/plan PR and record its URL here.
- [ ] Add full public/protected JAR API comparison and previously compiled consumer
  linkage coverage before broad model/service regeneration. Preserve existing
  compatibility policy and test manifests. Verify deliberate binary incompatibility
  is caught and unchanged artifacts pass.
  Supplemental comparator and 13 synthetic javac/JVM fixtures are submitted in
  #1236; actual selected-release SDK consumer/runtime validation remains required.

## Independent initial slices

- [ ] C1: Generate telemetry provenance bridge in the OpenAI profile. Preserve
  Stainless fixtures. Verify both clients and explicit headers/clones/toggles;
  submit compiler Delta, merge, then regenerate SDK. Target: 2 files / 4 lines.
- [ ] C2: Generate async multipart mapping from semantic facts. Preserve runtime
  ownership and old fixture profile. Enumerate newly affected endpoints and test
  cancellation/cleanup/error boundaries before promotion. Submit separate compiler
  Delta; SDK regeneration depends on compiler merge and runtime validation.
- [ ] C13: Restore exact generated tooling comment; verify Python AST equivalence,
  offline reporter/budget tests and unchanged gate behavior. Separate SDK PR.
- [ ] C12: Move handwritten credential diagnostic assertions into the existing
  handwritten regression suite and restore generated smoke test. Preserve every
  assertion; run both focused test classes. Separate SDK PR.

## Model and parameter slices

- [ ] C5: Preserve legacy api-key expiry and additional-property accessors with
  typed facts, roundtrips and old-consumer linkage. Separate accessor contracts
  from enum/factory aliases; no return-type or missing/null behavior changes.
- [ ] C6: Preserve embedding List<Float> public API with base64 storage/decoding;
  test both encodings and omitted defaults before compiler adoption.
- [ ] C7: Generate backward-compatible union visitor defaults. Run old visitor
  fixtures and unknown/new-variant tests; preserve aliases and JSON representation.
- [ ] C8: Generate existing diagnostic redaction using sensitivity facts. Coordinate
  with C7 in shared union templates; run raw-JSON/visitor/diagnostic tests and obtain
  security-focused maintainer review before promotion.
- [ ] C4: Generate structured-output builder/service overloads as thin helper
  delegates. Preserve JVM descriptors and defaults; run manifest, whole-JAR and
  Java/Kotlin consumer checks. Coordinate shared model templates with C5-C8.

## Service and generated-test slices

- [ ] C3: Generate audio response-format handler dispatch; run existing audio media
  tests for blocking/async, text/JSON, validation and closure. Depends on C2 method
  view integration; no multipart lifecycle regression.
- [ ] C9: Generate existing Responses WebSocket bridges and stream validation;
  run lifecycle, cancellation, large-payload and old service-implementation tests.
  Coordinate ResponseService interface with C4.
- [ ] C10: Generate Agent session/tool-handler delegates and retry-stable environment
  idempotency. Preserve unsupported-service messages, executor and terminal behavior.
  Verify agent orchestration/pagination/credential suites.
- [ ] C11: Generate legacy beta Realtime subservice and current operation credential
  selection from authoritative inputs. Retain deprecated entrypoints and obtain
  security-focused review for auth changes.
- [ ] C14: Generate current WebhookVerificationParams entrypoints and verifier
  delegates. Preserve payload-byte, timestamp and parse behavior; run existing
  signature/unwrap suites and obtain security-focused review.
- [ ] C12: Emit deterministic streaming/server fixtures and canonical model samples;
  retain response fixture consolidation and independent pagination WireMock suite.
  Split into feature-sized PRs with matching model/service slices. No new disabled
  coverage, redundant giant fixtures or weaker assertions.

## Per-slice landing checkpoint

- [ ] Compiler implementation and focused tests reviewed; immutable fixtures pass.
- [ ] Draft output reviewed against shipped SDK; public APIs/behavior preserved.
- [ ] Compiler merged before promotion; generation used verified merged binary.
- [ ] SDK checks, security review where applicable, and normal approval satisfied.
- [ ] Trusted report shows actual mixed-file/line reduction; refresh inventory.

## Completion

- [ ] All generated-owned files match verified generation, including tests/tooling.
- [ ] Regeneration is repeatable; handwritten runtime and regression tests retained.
- [ ] Zero mixed files and zero custom patch lines verified on merged SDK main.
- [ ] Submit any budget decrease/strict policy activation as its own policy-only PR.

## PR/Delta ledger

| Slice | Review | Head | Validation and state |
| --- | --- | --- | --- |
| Inventory and plan | [Java #1234](https://github.com/openai/openai-java/pull/1234) | Initial `f76f0730dcce87a1de5a5b58614f59c24552b3f9`; subsequent documentation commits remain on the same PR | 99 rows checked against committed blobs and verified reporter; open for review; no SDK changes |
| C13 generated comment | [Java #1235](https://github.com/openai/openai-java/pull/1235) | `e2040c78ea4816e81adcfe647939e707c0af2ed9` | 95 Python tests pass (one existing skip), Ruff passes, AST unchanged, verified report 99→98 files and 2,031→2,029 lines; Conductor verified current-head CI green; root SDK review requested; approval still required |
| C1 User-Agent compiler | Compiler Delta 2565485 | `ecfc447de4083f1458c0df48544b2db419ad01a2` | 5 client renderer tests pass, both profiles/modes covered, full client output equality except intended setter/header, intact push hooks pass; open, SDK team review requested, no approval; compiler merge and SDK regeneration still required |
| Supplemental JVM comparator | [Java #1236](https://github.com/openai/openai-java/pull/1236) | `c390d4476ce3eca7352fe064ba492fbe39ac44f0` | 15 javac/JVM tests pass; both P2 findings fixed with six regression cases failing before repair; lint/format and independent review pass; review-body disposition posted and existing root request refreshed; earlier green CI belongs to 8e455813, fresh-head CI/review required; no production or generated changes |
| C12 credential assertion ownership | [Java #1237](https://github.com/openai/openai-java/pull/1237) | `baf96b579753c40e62003dd435c096ebda23abc0` | Ready for review; 24 focused tests pass with zero failures/errors/skips; production shards compile; every exact assertion retained; verified report 99→98 files and 2,031→2,027 lines; SDK team review requested |
| C2 async multipart compiler | Compiler Delta 2565512 | `0e5d4607f264812270396db68111298a363f52a0` | Draft; prior full renderer suite 791 passed / 8 ignored, final 4 focused regressions pass; typed/nullable-Void/raw/streaming Kotlin probes pass against current runtime; 248-service draft covers all 12 groups; expected 5 files / 53 lines; audio handler integration and newly affected endpoint lifecycle verification still required |

Record exact current heads when acting on CI or review events. Never record a
proposed reduction as landed merely because its compiler change exists or CI is
green. Compiler and SDK follow-up reviews will be added as they are published.

On 2026-10-19 Conductor verified this chat owns Java PRs 1234–1237 and registered
routing. After checking for existing requests, one combined root `#sdk-reviews`
post requested reviews of the exact green heads of 1235 and 1236. Pending approval
is a normal wait; rely on Conductor notifications rather than polling or duplicating
review posts. No merge or queue enrollment is implied by green CI.
