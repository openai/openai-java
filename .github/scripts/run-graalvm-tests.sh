#!/usr/bin/env bash
set -euo pipefail

# Run from the verified release checkout. It may predate the split test compilers.
available_tasks="$(./gradlew :openai-java-core:tasks --all --console=plain)"
skip_optional_compilers=()
while IFS= read -r task; do
  skip_optional_compilers+=(-x ":openai-java-core:$task")
done < <(awk '/^compile(BetaModel|AdminModel|ModelGroup[0-9]+|ServiceGroup[0-9]+|SharedFixture)TestKotlin([[:space:]]|$)/ { print $1 }' <<< "$available_tasks")

# Classes were compiled before switching to GraalVM. Only run the tracing tests.
./gradlew :openai-java-core:test \
  -x compileJava -x compileTestJava -x compileKotlin -x compileTestKotlin \
  "${skip_optional_compilers[@]}" -PgraalvmAgent
