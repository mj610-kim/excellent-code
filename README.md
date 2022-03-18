# Code review agent 22-08차 팀 프로젝트

## Table of contents
- [개발 환경](#development-environment)
- [Brach policy](#branch-policy)
- [Commit message policy](#commit-message-policy)
  - [General rules](#commit-message-general-rules)
  - [Format](#commit-message-format)
  - [Header format](#commit-message-header-format)
  - [Body format](#commit-message-body-format)
  - [Footer format](#commit-message-footer-format)
  - [Example](#commit-message-example)
  - [References](#commit-message-policy-references)
- [Coding style](#coding-style)
- [평가 방식](#evaluation)
- [요구 사항](#project-requirements)
  - [프로그램 기능](#program-features)
  - [명령어의 형식](#command-format)
- [제약 사항](#constraints)
- [입출력](#input-output)

## <a name="development-environment"></a>개발 환경

Java 8을 기준으로 개발한다.

## <a name="branch-policy"></a>Branch policy

Branch policy는 기본적으로 [git-flow](https://nvie.com/posts/a-successful-git-branching-model/) 방식을 따른다.

- `main`: 제품으로 출시될 수 있는 브랜치 (버젼 tag를 지정한다)
- `develop`: 다음 출시 버젼을 준비하는 브랜치
- `feature/xxxx`: 기능을 개발하는 브랜치
- `bugfix/xxxx`: 버그수정을 개발하는 브랜치
- `refactoring/xxxx`: 리팩토링 작업을 진행하는 브랜치
- `hotfix`: 출시 버젼에서 발생한 버그를 수정하는 브랜치

git-flow와 다른 점은 아래에 명시한다:

### `release` 브랜치는 사용하지 않는다
Unit test는 `develop` TDD로 브랜치에서 계속 진행하며, integration test 등은 불필요하기 때문에 `release` 브랜치는 브랜치 정책에 불필요하고 복잡도만 증가한다. 그렇기 때문에 `release` 브랜치는 사용하지 않으며, `develop` 브랜치에서 바로 `main` 브랜치로 반영한다.

## <a name="commit-message-policy"></a>Commit message policy

### <a name="commit-message-general-rules"></a>General rules

1. `header`와 `body`는 빈 줄로 분리한다
2. `header`의 글자수는 70으로 제한한다
3. `header`의 `summary`의 첫 글자는 대문자를 사용하지 않는다
4. `header`의 `summary`에 마침표를 사용하지 않는다
5. `header`의 `summary`는 명령문을 사용한다
6. `body`는 "어떻게"가 아닌 "왜"를 기술한다
7. 커밋은 stable한 단일 변경사항으로 만든다

### <a name="commit-message-format"></a>Format

커밋 메세지에는 `header`, `body`, 그리고 `footer`가 있다.

```
<header>
<BLANK LINE>
<body>
<BLANK LINE>
<footer>
```

`header`는 필수이고 [commit message header format](#commit-meesage-header-format) 형식을 따른다.

`body`는 필수이고 [commit message body format](#commit-message-body-format) 형식을 따른다.

`footer` 필수가 아니고, [commit message footer format](#commit-message-footer-format) 형식을 따른다.

### <a name="commit-message-header-format"></a>Header format

```
<type>: <summary>
  │       │
  │       └─⫸ Summary in present tense. Not capitalized. No period at the end.
  │
  └─⫸ Commit Type: build|ci|docs|feat|fix|perf|refactor|test
```

#### Type

`type`은 다음 중 하나다:

- `build`: Changes that affect the build system or external dependencies
- `ci`: Changes to our CI configuration files and scripts
- `docs`: Documentation-only changes
- `feat`: A new feature
- `fix`: A bug fix
- `perf`: A code change that improves performance
- `refactor`: A code change that neither fixes a bug nor adds a feature
- `test`: Adding missing tests or correcting existing tests

#### Summary

`summary`는 간단명료하게 변경사항을 설명한다:

- 현재형, 명령문을 사용한다: "changes", "changed"가 아닌 "change"
- 첫 글자는 대문자를 사용하지 않는다
- 마침표를 사용하지 않는다

### <a name="commit-message-body-format"></a>Body format

`body`는 현재형, 명령문을 사용한다. 코드 변경이 필요한 이유를 설명하며, 이전과 어떻게 달라졌는지 서술한다.

### <a name="commit-message-footer-format"></a>Footer format

`footer`는 breaking change 정보와 deprecation 정보를 포함할 수 있다. 또한 GitHub issues, Jira tickets, 그리고 밀접한 연관이 있는 다른 PR 정보를 포함할 수 있다.

For example:

```
BREAKING CHANGE: <breaking change summary>
<BLANK LINE>
<breaking change description + migration instructions>
<BLANK LINE>
<BLANK LINE>
Fixes #<issue number>
```

or

```
DEPRECATED: <what is deprecated>
<BLANK LINE>
<deprecation description + recommended update path>
<BLANK LINE>
<BLANK LINE>
Closes #<pr number>
```

### <a name="commit-message-example"></a>Example

```
feat: Summarize changes in around 50 characters or less

More detailed explanatory text, if necessary. Wrap it to about 72
characters or so. In some contexts, the first line is treated as the
subject of the commit and the rest of the text as the body. The
blank line separating the summary from the body is critical (unless
you omit the body entirely); various tools like `log`, `shortlog`
and `rebase` can get confused if you run the two together.

Explain the problem that this commit is solving. Focus on why you
are making this change as opposed to how (the code explains that).
Are there side effects or other unintuitive consequences of this
change? Here's the place to explain them.

Further paragraphs come after blank lines.

 - Bullet points are okay, too

 - Typically a hyphen or asterisk is used for the bullet, preceded
   by a single space, with blank lines in between, but conventions
   vary here

If you use an issue tracker, put references to them at the bottom,
like this:

Resolves: #123
See also: #456, #789
```

### <a name="commit-message-policy-references"></a>References

- https://cbea.ms/git-commit/
- https://www.conventionalcommits.org/en/v1.0.0/
- https://github.com/angular/angular/blob/master/CONTRIBUTING.md#commit-header
- https://pages.nist.gov/dioptra/dev-guide/contributing-commit-styleguide.html

---

## <a name="coding-style"></a>Coding style

Coding style은 기본적으로 [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html)를 따른다.

Google Java Style Guide와 다른 점은 아래에 명시한다:

### Block indentation

Block indentation은 `+2 spaces` 대신 `+4 spaces`로 한다

### Indent continuation lines

Indent continuation은 `at least +4 spaces` 대신 `at least +8 spaces`로 한다

## <a name="evaluation"></a>평가 방식

평가 방식은 팀 프로젝트 PPT를 참고 부탁드립니다

## <a name="project-requirements"></a>요구 사항

### <a name="program-features"></a>프로그램 기능

| 정보명 | 설명 | Column 명 |
|-------------|-------------|-------------|
| 사원 번호 | 8자리 숫자로 구성<br/>맨 앞 두 자리는 입사 년도를 의미<br/>69XXXXXX(1969년)~21XXXXXX(2021년) | `employeeNum` |
| 성명 | 최대 15자리로 구성 (이름과 성이 띄어쓰기로 구분)<br/>영어 대문자로만 구성 | `name` |
| 경력개발단계 | `CL1`, `CL2`, `CL3`, `CL4` | `cl` |
| 전화번호 | 010-XXXX-XXXX 형식으로 구성<br/>(앞자리는 010으로 고정) | `phoneNum` |
| 생년월일 | YYYYMMDD 형식으로 구성 | `birthday` |
| Certi |`ADV`, `PRO`, `EX`로 구성 | `certi` |

### <a name="command-format"></a>명령어의 형식

| 명령어 | 설명 |
|-------------|-------------|
| `ADD` | 새로운 사원 정보를 추가한다 |
| `DEL` | 조건에 부합하는 사원 정보를 삭제한다 |
| `SCH` | 조건에 부합하는 사원 정보를 검색한다 |
| `MOD` | 조건에 부합하는 사원 정보를 수정한다 |

| 옵션 1 | 설명 |
|-------------|-------------|
| `-p` | 출력 옵션이 적용되면 조건에 부합하는 record를 줄 단위로 출력한다 |

| 옵션 2 | 설명 |
|-------------|-------------|
| `-f` / `-l` | `-f`: 성명의 이름으로 검색 / `-l`: record를 줄 단위로 출력한다 |
| `-m` / `-l` | `-m`: 전화번호 중간 자리로 검색 / `-l`: 전화번호 뒷자리로 검색 |
| `-y` / `-m` / `-d` | `-y`: 생년월일의 연도로 검색 / `-m`: 생년월일의 월로 검색 / `-d`: 생년월일의 일로 검색 |

| 옵션 3 | 설명 |
|-------------|-------------|
| | 현재 사용하지 않음 |

## <a name="constraints"></a>제약 사항

- Standard library와 test framework만 사용 가능하다
- 최소한 10만개의 데이터 record가 처리 될 수 있어야 한다
  - `ADD`를 통한 10만개의 데이터 입력 후 수정/삭제/검색 기능의 동작)

## <a name="input-output"></a>입출력

- Input/output 형태는 `txt` 파일이며, input file을 read하여, output file을 생성한다
- `main` 함수의 argument (parameter)로 input file과 output file을 받는다
  - ex) `EmployeeManagement.exe input.txt output.txt`

