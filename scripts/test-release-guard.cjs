'use strict';

const assert = require('node:assert/strict');
const fs = require('node:fs');
const os = require('node:os');
const path = require('node:path');
const { spawnSync } = require('node:child_process');
const { test } = require('node:test');

const repository = 'openai/openai-java';
const branch = 'release-please--branches--main--changes--next';
const workflow = fs.readFileSync(path.join(__dirname, '../.github/workflows/create-releases.yml'), 'utf8');
const step = workflow.split('      - name: Check for a legacy release PR\n')[1]?.split('\n      - name:')[0];
assert.ok(step, 'Release workflow must retain the legacy PR guard');
const script = step.split('        run: |\n')[1]?.replace(/^          /gm, '');
assert.ok(script, 'Legacy PR guard must have an executable script');

function pr(overrides = {}) {
  return {
    number: 42,
    html_url: 'https://github.com/openai/openai-java/pull/42',
    state: 'open',
    base: { ref: 'main' },
    head: { ref: branch, repo: { full_name: repository } },
    ...overrides,
  };
}

// Emulate GitHub's query filtering and page boundaries; jq and the workflow's
// shell run unchanged. No real credentials, GitHub calls, or release actions.
const fakeGh = String.raw`#!/usr/bin/env node
const fs = require('node:fs');
const { spawnSync } = require('node:child_process');
const args = process.argv.slice(2);
const fixture = JSON.parse(fs.readFileSync(process.env.GH_FIXTURE, 'utf8'));
const value = (flag) => args[args.indexOf(flag) + 1];
if (fixture.error && !fixture.failAfterPage) { console.error('Synthetic API failure'); process.exit(1); }
let prs = fixture.prs;
if (args[0] === 'api') {
  if (value('--method') !== 'GET' || !args.includes('repos/openai/openai-java/pulls')) process.exit(2);
  const fields = Object.fromEntries(args.flatMap((arg, i) => arg === '-f' ? [args[i + 1].split('=')] : []));
  prs = prs.filter((pr) => (!fields.state || pr.state === fields.state) && (!fields.base || pr.base.ref === fields.base));
  const size = Number(fields.per_page || 30);
  const pages = [];
  for (let i = 0; i < prs.length; i += size) pages.push(prs.slice(i, i + size));
  if (!pages.length) pages.push([]);
  const output = args.includes('--paginate') && !fixture.failAfterPage ? pages : pages.slice(0, 1);
  process.stdout.write(output.map((page) => JSON.stringify(page)).join('\n'));
  if (fixture.error) { console.error('Synthetic API failure'); process.exitCode = 1; }
} else if (args[0] === 'pr' && args[1] === 'list') {
  prs = prs.filter((pr) => pr.state === value('--state') && pr.head.ref === value('--head'));
  prs = prs.slice(0, args.includes('--limit') ? Number(value('--limit')) : 30);
  const result = spawnSync('jq', ['-c', value('--jq')], {
    input: JSON.stringify(prs.map((pr) => ({ number: pr.number, url: pr.html_url }))), encoding: 'utf8',
  });
  process.stdout.write(result.stdout);
  process.exitCode = result.status;
} else process.exit(2);
`;

function run(prs, extra = {}) {
  const temp = fs.mkdtempSync(path.join(os.tmpdir(), 'release-guard-'));
  try {
    fs.writeFileSync(path.join(temp, 'gh'), fakeGh, { mode: 0o755 });
    const fixture = path.join(temp, 'fixture.json');
    fs.writeFileSync(fixture, JSON.stringify({ prs, ...extra }));
    const result = spawnSync('/bin/bash', ['--noprofile', '--norc', '-c', script], {
      encoding: 'utf8',
      timeout: 10000,
      env: {
        PATH: `${temp}:${process.env.PATH}`,
        GH_FIXTURE: fixture,
        GITHUB_REPOSITORY: repository,
        LEGACY_RELEASE_BRANCH: branch,
      },
    });
    assert.ifError(result.error);
    return result;
  } finally {
    fs.rmSync(temp, { recursive: true, force: true });
  }
}

const fork = pr({ number: 99, html_url: 'https://github.com/openai/openai-java/pull/99', head: { ref: branch, repo: { full_name: 'contributor/openai-java' } } });
for (const [name, prs] of [
  ['fork using the legacy branch', [fork]],
  ['same-owner fork using the legacy branch', [pr({ head: { ref: branch, repo: { full_name: 'openai/other-repo' } } })]],
  ['wrong base', [pr({ base: { ref: 'next' } })]],
  ['closed legacy PR', [pr({ state: 'closed' })]],
  ['unrelated branch', [pr({ head: { ref: 'feature', repo: { full_name: repository } } })]],
  ['deleted head repository', [pr({ head: { ref: branch, repo: null } })]],
  ['no PRs', []],
]) {
  test(`${name} does not block a release`, () => {
    const result = run(prs);
    assert.equal(result.status, 0, result.stdout + result.stderr);
    assert.doesNotMatch(result.stdout, /::error::/);
  });
}

for (const [name, prs] of [
  ['genuine legacy PR', [pr()]],
  ['genuine legacy PR beyond the first page', [...Array(101).fill(fork), pr()]],
]) {
  test(`${name} blocks a release with its URL`, () => {
    const result = run(prs);
    assert.equal(result.status, 1, result.stdout + result.stderr);
    assert.match(result.stdout, /Merge or close legacy release PR #42/);
    assert.ok(result.stdout.includes(pr().html_url), result.stdout);
  });
}

for (const failAfterPage of [false, true]) {
  test(`API failure ${failAfterPage ? 'after a page' : 'before results'} stops the guard`, () => {
    const result = run([fork], { error: true, failAfterPage });
    assert.equal(result.status, 1, result.stdout + result.stderr);
    assert.doesNotMatch(result.stdout, /Merge or close legacy release PR/);
    assert.match(result.stderr, /Synthetic API failure/);
  });
}
