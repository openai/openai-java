#!/usr/bin/env bash

set -euo pipefail

usage() {
  echo "Usage: $0 <source-directory> <release-tag> [expected-sha]" >&2
  exit 2
}

if [[ "$#" -lt 2 || "$#" -gt 3 || -z "${GITHUB_OUTPUT:-}" || -z "${GITHUB_REPOSITORY:-}" ]]; then
  usage
fi

readonly source_directory=$1
readonly release_tag=$2
readonly expected_sha=${3:-}
script_directory="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
readonly script_directory

if [[ ! "$release_tag" =~ ^v[0-9]+\.[0-9]+\.[0-9]+(-[0-9A-Za-z.-]+)?$ ]]; then
  echo "::error title=Invalid release tag::Expected a semantic version tag such as v4.47.0"
  exit 1
fi
if [[ -n "$expected_sha" && ! "$expected_sha" =~ ^[0-9a-f]{40}$ ]]; then
  echo "::error title=Invalid release commit::Release automation returned an invalid commit SHA"
  exit 1
fi

cd "$source_directory"

source_sha="$(git rev-parse HEAD)"
tag_sha="$(git rev-parse "refs/tags/$release_tag^{commit}")"
if [[ "$source_sha" != "$tag_sha" ]]; then
  echo "::error title=Release tag mismatch::$release_tag resolves to $tag_sha, but $source_sha was checked out"
  exit 1
fi
if [[ -n "$expected_sha" && "$source_sha" != "$expected_sha" ]]; then
  echo "::error title=Release commit mismatch::$release_tag resolves to $source_sha, expected $expected_sha"
  exit 1
fi
if ! git rev-parse --verify refs/remotes/origin/main >/dev/null; then
  echo "::error title=Missing main branch::The release checkout did not fetch origin/main"
  exit 1
fi
if ! git merge-base --is-ancestor "$source_sha" refs/remotes/origin/main; then
  echo "::error title=Untrusted release source::$release_tag is not an ancestor of main"
  exit 1
fi

release_json="$(gh api "repos/$GITHUB_REPOSITORY/releases/tags/$release_tag")"
release_draft="$(jq -r '.draft' <<< "$release_json")"
release_target="$(jq -er '.target_commitish' <<< "$release_json")"
if [[ "$release_draft" != "false" ]]; then
  echo "::error title=Invalid GitHub release::$release_tag must be a published release"
  exit 1
fi
if [[ "$release_target" != "$source_sha" ]]; then
  echo "::error title=GitHub release mismatch::$release_tag targets $release_target, expected $source_sha"
  exit 1
fi

build_versions=()
while IFS= read -r build_version; do
  build_versions+=("$build_version")
done < <(
  sed -n \
    's/^[[:space:]]*version = "\([^"]*\)" \/\/ x-release-please-version$/\1/p' \
    build.gradle.kts
)
if [[ "${#build_versions[@]}" -ne 1 ]]; then
  echo "::error title=Invalid Gradle version::Expected one x-release-please-version marker"
  exit 1
fi

version="${build_versions[0]}"
manifest_version="$(jq -er '.["."]' .release-please-manifest.json)"
if [[ "$release_tag" != "v$version" || "$manifest_version" != "$version" ]]; then
  echo "::error title=Release version mismatch::Tag $release_tag, Gradle $version, manifest $manifest_version"
  exit 1
fi

artifacts=()
while IFS= read -r build_file; do
  if grep -Fq 'id("openai.publish")' "$build_file"; then
    artifacts+=("$(basename "$(dirname "$build_file")")")
  fi
done < <(find . -mindepth 2 -maxdepth 2 -type f -name build.gradle.kts | sort)
if [[ "${#artifacts[@]}" -eq 0 ]]; then
  echo "::error title=No publications::The release contains no openai.publish projects"
  exit 1
fi
for artifact in "${artifacts[@]}"; do
  if [[ ! "$artifact" =~ ^[0-9A-Za-z._-]+$ ]]; then
    echo "::error title=Invalid artifact ID::$artifact is not safe to publish"
    exit 1
  fi
done
artifacts_csv="$(IFS=,; echo "${artifacts[*]}")"

{
  echo "source_sha=$source_sha"
  echo "release_tag=$release_tag"
  echo "version=$version"
  echo "artifacts=$artifacts_csv"
} >> "$GITHUB_OUTPUT"

bash "$script_directory/maven-central-release.sh" check "$version" "$artifacts_csv"
