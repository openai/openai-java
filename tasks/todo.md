# Java generated/custom transition tasks

See [the measured plan and per-file inventory](plan.md). User authorization covers
implementation and PR submission; normal review and compiler-before-promotion
gates remain in effect. No developer-facing breaking changes are allowed.

## Delivery ceilings

The clarified limits are ten public Java SDK PRs, ten compiler Deltas and
unlimited internal generation PRs. Six public PRs and six Deltas already exist;
[the consolidated delivery plan](plan.md#execution-and-parallelism) reserves the
remaining four public slots and four compiler slots. Workstream checkboxes are
implementation and verification steps, not permission for unbounded micro-PRs.

- [x] Allocate the existing reviews and the remaining public/compiler capacity.
- [ ] Complete #1239 expiry regressions/plan through normal fresh exact-head gates.
- [ ] Finish shared typed policies in existing Delta 2566856.
- [ ] Finish multipart/audio integration in existing Delta 2565512.
- [ ] Finish legacy model/accessor consumers in existing Delta 2566858.
- [ ] Complete C1's existing Delta 2565485 human helper-contract review.
- [ ] Publish complete remaining compiler bundles within the four reserved slots.
- [ ] After compiler merge, use normal internal checkpoints and public promotion
  for consolidated SDK batches within the four reserved public slots.
- [ ] Keep all code/test/inventory work in public slots 7–9; reserve slot 10 for
  an optional policy-only zero-budget/strict activation after trusted zero.

## Foundation

- [x] Verify current public generated snapshot and measure every mixed file.
- [x] Classify runtime, models, services, tests, and tooling with exact patch counts.
- [x] Record compiler ownership, compatibility gates, parallel work and dependencies.
- [x] Publish inventory/plan PR and record its URL here.
- [ ] Add full public/protected JAR API comparison and previously compiled consumer
  linkage coverage before broad model/service regeneration. Preserve existing
  compatibility policy and test manifests. Verify deliberate binary incompatibility
  is caught and unchanged artifacts pass.
  Supplemental comparator and 24 synthetic javac/JVM tests merged in #1236;
  actual selected-release SDK consumer/runtime validation remains required.

## Independent initial slices

- [ ] C1: Generate telemetry provenance bridge in the OpenAI profile. Preserve
  Stainless fixtures. Verify both clients and explicit headers/clones/toggles;
  submit compiler Delta, merge, then regenerate SDK. Target: 2 files / 4 lines.
- [ ] C2: Generate async multipart mapping from semantic facts. Preserve runtime
  ownership and old fixture profile. Enumerate newly affected endpoints and test
  cancellation/cleanup/error boundaries before promotion. Keep implementation in existing Delta 2565512; SDK regeneration depends on
  compiler merge and runtime validation.
- [x] C13: Restore exact generated tooling comment; verify Python AST equivalence,
  offline reporter/budget tests and unchanged gate behavior. Already delivered in its existing SDK PR.
- [x] C12: Move handwritten credential diagnostic assertions into the existing
  handwritten regression suite and restore generated smoke test. Preserve every
  assertion; run both focused test classes. Already delivered in its existing SDK PR.

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
  Use feature-sized commits inside the allocated compiler bundles. No new disabled
  coverage, redundant giant fixtures or weaker assertions.

## Integrated landing checkpoint

- [ ] Compiler implementation and focused tests reviewed; immutable fixtures pass.
- [ ] Draft output reviewed against shipped SDK; public APIs/behavior preserved.
- [ ] Compiler merged before promotion; generation used verified merged binary.
- [ ] SDK checks, security review where applicable, and normal approval satisfied.
- [ ] Trusted report shows actual mixed-file/line reduction; refresh inventory.

## Completion

- [ ] All generated-owned files match verified generation, including tests/tooling.
- [ ] Regeneration is repeatable; handwritten runtime and regression tests retained.
- [ ] Zero mixed files and zero custom patch lines verified on merged SDK main.
- [ ] Keep the existing budget unchanged; do not add a budget-policy PR to this transition.

## PR/Delta ledger

State captured on 2026-10-19 after all four initial SDK PRs merged. This ledger is an
audit snapshot, not merge authorization: re-read the live head, complete feedback,
required reviews and checks before acting. Approval/CI on an older head never
stands in for validation of a newer candidate.

Both cleanup merges are verified on SDK commit
`d445a6a2db03d6f0979efb2d8355452029f08a00`: **97 mixed files / 2,025 patch
lines** (1,328 additions + 697 deletions), with 97 remaining customizations
unchanged and two removed. Generated snapshot hashes were verified. Reproduce
with the trusted reporter, then total its patch using `git apply --numstat`:

```sh
python3 scripts/castiron/custom_code_report.py report \
  --base caa95e12459e3cca6e85403dd3727f5eacd9a9d5 \
  --head d445a6a2db03d6f0979efb2d8355452029f08a00 \
  --fetch --require-head-hash --public --out /tmp/java-transition-merged
git apply --numstat /tmp/java-transition-merged/custom-code.patch
```

| Slice | Review | Head | Validation and state |
| --- | --- | --- | --- |
| Inventory and plan | [Java #1234](https://github.com/openai/openai-java/pull/1234) | `7df7cd08e45d1f583783676995e32bc15902d110` | **Merged** as `1499ace53dda09c46af2feb693a876c7b6eed890`; current-head approvals, CI and automated reviews completed before protected queue. Original 99-file audit retained. Conductor verified post-merge push CI, examples smoke and release checks succeeded: [run 39318380957](https://github.com/openai/openai-java/actions/runs/39318380957) |
| C13 generated comment | [Java #1235](https://github.com/openai/openai-java/pull/1235) | `e2040c78ea4816e81adcfe647939e707c0af2ed9` | **Merged** as `479972a1ee2a7cd181f67f478c95aad9d1d1e261` on 2026-10-19; markstuart-oai approval and protected queue completed. 95 Python tests pass (one existing skip), Ruff passes, AST unchanged; slice removes one mixed file / two patch lines |
| C1 User-Agent compiler | Compiler Delta 2565485 | `d9b3b86accb2846e27d7440f755e6871d217f0d1` | Open; 789 renderer tests passed / eight existing ignored, including both profiles/modes and complete client-body comparisons. Nine-line cross-profile test expectation repair preserves immutable fixtures. Both actual drafted client sources compile against shipped SDK and pass 92 cases / 128 loopback requests with class-location checks. Client-family JVM comparison: 116 classfiles per side, four exported API classes, zero potential incompatibilities. Normal hooks pass; required human helper-contract review and current-head hosted checks remain gates. No compiler merge or SDK promotion |
| Supplemental JVM comparator | [Java #1236](https://github.com/openai/openai-java/pull/1236) | `77eb7b8ac74f918d702706162f3b3d3448822565` | **Merged** as `19d2967ca52b91c108e76da84f9dcff441a17f17`; all actionable feedback addressed, 24 offline javac/JVM tests and current-head approvals/CI/automated reviews completed before protected queue. Retains public/protected declarations through hidden in-JAR ancestors; ZIP input errors and modifier/interface obligations are covered. Conservative declaration/external-ancestor limits remain documented. Separate post-merge failure and bounded diagnostic rerun are recorded below; no SDK APIs/runtime, dependencies, policy or generation ownership changed |
| C12 credential assertion ownership | [Java #1237](https://github.com/openai/openai-java/pull/1237) | `baf96b579753c40e62003dd435c096ebda23abc0` | **Merged** as `d445a6a2db03d6f0979efb2d8355452029f08a00`; approval and protected queue completed. All 24 focused tests pass with zero failures/errors/skips; production shards compile; every exact assertion retained; slice removes one mixed file / four patch lines. Conductor verified post-merge checks all green: [run 39312222532](https://github.com/openai/openai-java/actions/runs/39312222532) |
| C2 async multipart compiler | Compiler Delta 2565512 | `55424d34eac7b5cb00802b483b15d40fabc6d25e` | Draft; prior renderer suite 791 passed / eight ignored, four focused regressions passed; typed/nullable-Void/raw/streaming Kotlin probes remain separate evidence. Actual generated sources for five additional service groups compile and pass 62 lifecycle cases: original cancellation/error/transport coverage plus typed success, raw ownership, malformed JSON and read failures. Independent test-tooling review and normal hooks pass. The 248-service draft covers all 12 groups; audio format/streaming integration and complete rollout validation remain required. Expected five-file / 53-line reduction is not landed |

### Separate post-merge validation

On merge `19d2967ca52b91c108e76da84f9dcff441a17f17`, #1236 post-merge
[run 39318051617](https://github.com/openai/openai-java/actions/runs/39318051617)
failed in the existing translation WebSocket test
`TranslationConnectionTest.blockedCleanupsOfOtherSocketsDoNotHoldAnIndependentFinishDeadline`:
its outer wait timed out while expecting the wrapped finish-timeout exception.
The test and relevant runtime sources are unchanged by this tooling-only PR.
Ten direct invocations and all 42 methods under concurrent JUnit execution passed
with their original deadlines and assertions; the standalone JVM exited normally.
Those results do not establish the hosted root cause or classify the test as flaky.
After a freshness/deduplication check, one normal failed-job rerun requested
attempt 2. Conductor verified that [attempt 2 succeeded](https://github.com/openai/openai-java/actions/runs/39318051617/attempts/2)
on the same merge commit and that release succeeded. Examples smoke remains
cancelled: this is CI recovery, not an all-checks-green claim. The initial
failure and root-cause limits above remain recorded; no source edits or timeout
changes were made. #1234's successful post-merge checks are a separate result.
#1235 post-merge verification is not recorded complete in this checkpoint.

### Next typed compiler foundations

C3 audio response-adapter facts are published as Compiler Delta 2566856, head
`50487874ebbe2a6709d87753033a6061abf0a3e9`. Three compiler tests and one
configuration test pass; an actual 23-component transcription reference-closure
probe validates the explicit binding against current source shapes. SDK JSON,
absent serialization and inactive profile/target behavior are preserved. Root
review found no blockers and normal hooks passed; hosted checks and normal
review remain required. No authoritative input binding is activated and no
renderer or SDK output changes. Helper structure/ABI and full runtime behavior
remain dependent-renderer acceptance gates.

C5a legacy-accessor policies are published as Compiler Delta 2566858, head
`32cf1f48b5266483525b53b995b1d0c51e6b4737`. Both compiler tests and all
75 OAS-transform tests pass, including exact render-input comparisons for the
11 inactive target/profile combinations. A negative control catches disabled
`compile_paths` validation. Independent review and normal hooks pass; hosted
checks and normal review remain required. There is no active production policy
or renderer/SDK output change. The fallible source-shape preflight applies to
`compile_paths`; in-memory APIs still need dependent activation validation.
Future rendering must reject unmatched/ambiguous provenance and allocated
JVM-name/signature collisions.

Both foundations preserve existing SDK-owned helper behavior and explicit
source provenance. Renderer consumers and authoritative input bindings follow
in dependent slices; none of this work counts as landed SDK reduction.

Record exact current heads when acting on CI or review events. Never record a
proposed reduction as landed merely because its compiler change exists or CI is
green. Publish follow-up bundles only within the separately reserved public SDK and compiler limits.

On 2026-10-19 Conductor verified this chat owns Java PRs 1234–1237 and registered
routing. One combined root `#sdk-reviews` post is edited in place as heads and
review states change; the initial SDK review requests are complete, and the post
records their distinct post-merge states plus the required C1 compiler review. Pending approval is a normal wait; rely on Conductor
notifications rather than polling or duplicating review posts. No merge or queue
enrollment is implied by green CI.

## Consolidation checkpoint (2026-10-19)

#1238 merged through the protected queue as
`b79d85f90c13c9cdc6d536b29704dfc50e8f9df8` from head
`0429eb4a5d288deb540d000ec16fa567b97d1598`. Conductor verified all post-merge
push workflows succeeded, including [CI run 39327996521](https://github.com/openai/openai-java/actions/runs/39327996521)
and examples smoke. Its separate pre-merge OkTest passed 236/236.

#1239 was temporarily held as draft under the earlier combined ten-review
interpretation. The user clarified ten public SDK PRs plus ten compiler Deltas,
with internal generation PRs unlimited. #1239 can proceed as the test/plan PR;
rollout batches use normal supported promotion. Its earlier head
`73a90a7ffddb7a69f5396906cfe4072da1155a55` had successful CI; its separate
OkTest failure belongs to superseded head `8ecd5c0`, not that newer head. New
head changes still require fresh review and checks; no merge is implied here.

The local audio draft passed a full-current-input comparison: 3,794 rendered
paths, exactly four changed transcription/translation implementations; SDK JSON
and other facts unchanged, transcription SSE byte-identical. Exact full-source
output passed all 79 transcription and 98 translation tests, and eight public
JVM surfaces match shipped classes. The translation tests now exercise generated
translation implementations, superseding the earlier shipped-only control.

C5a's full-source output changed only ApiKeyUpdateParams and its test; its exact
candidate passed frozen Java/Kotlin consumers and seven handwritten JUnit tests.
Additional-property, embedding, visitor/diagnostic and service helper work remains
in progress. No generated SDK output has been promoted; final integration,
whole-artifact acceptance and zero-debt verification are still required.
