# Live API migration on next

This describes planned source changes for the next major version. It is not a
release announcement and does not change the current stable release.

## Decision item messages

`DecisionItemCreateEvent.Item` and `DecisionItemCreatedEvent.Item` become typed
unions. Code using their old `builder()` and nested `Type.MESSAGE` must instead
construct a concrete message, such as `DecisionUserMessage`, and pass it to the
event builder. The event identifiers and surrounding client/server event APIs
remain available. The same change applies when those events are carried through
fork or sideband connections.

## Delegation questions

`DecisionsDelegationUpdateConfig.Question` is replaced by the shared
`DecisionQuestion` type. Construct a `DecisionQuestion.Choice`, `.Predicate`, or
`.Score`, then pass it to `addQuestion`. This lets delegation updates reuse the
same question types as other Decisions requests. The questions list retains its
missing/null/list handling.

## Compatibility coverage

The next branch's compatibility policy records only these intentional source
changes. Curated copies of the nine affected consumer tests preserve their
other API expressions, including event variants, accessors, roundtrip calls,
and omitted-list behavior. Only the replaced constructors use wire-shaped
values in those compile-only fixtures. Current SDK tests continue to exercise
typed construction and runtime behavior.

The ordinary compatibility workflow still reads its policy from the target
branch. This policy must be reviewed and merged separately before the SDK API
change; the SDK candidate cannot approve its own exception. No CI job or
required status is disabled.
