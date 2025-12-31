# Step 7: Enum and Extended Todo Models

**사전 지식**:
- Step 5 내용: 클래스 분리, 패키지 구조
- 기본 클래스 정의 이해

**학습 목표**:
- enum(열거형) 정의 및 활용
- Todo 클래스에 새로운 필드 추가 (id, category, priority, dueDate, createdAt)
- enum을 사용한 타입 안전성 확보

**핵심 내용**:
- `enum` 키워드로 열거형 정의
- enum에 필드, 생성자, 메서드 추가
- `values()`, `valueOf()`, `ordinal()` 메서드
- 사용자 입력(숫자)을 enum으로 변환
- ID 자동 생성 패턴 (static 카운터)

**실습 과제**:
1. Category enum 정의 (WORK, STUDY, PERSONAL, HEALTH, OTHER)
2. Priority enum 정의 (LOW, MEDIUM, HIGH)
3. Todo 클래스에 category, priority, id 필드 추가
4. 등록 시 구분/중요도 선택 입력 구현

**산출물**:
- [ ] Category.java enum 파일
- [ ] Priority.java enum 파일
- [ ] 확장된 Todo.java 클래스
- [ ] enum 기반 입력 처리 동작

---

## 내용 정리

<details>
<summary><strong>📘 enum(열거형) 개념</strong></summary>

**enum이란?**
- 미리 정의된 **상수들의 집합**
- 타입 안전성 제공 (잘못된 값 입력 방지)
- 관련된 상수들을 하나의 타입으로 그룹화

**기본 enum 정의**:
```java
public enum Category {
    WORK,      // 업무
    STUDY,     // 학습
    PERSONAL,  // 개인
    HEALTH,    // 건강
    OTHER      // 기타
}
```

**enum 사용**:
```java
Category cat = Category.WORK;

// switch와 함께 사용
switch (cat) {
    case WORK:
        System.out.println("업무");
        break;
    case STUDY:
        System.out.println("학습");
        break;
    // ...
}
```

**왜 enum을 사용하는가?**
```java
// ❌ 문자열 사용 - 오타 가능, 타입 안전하지 않음
String category = "WORKK";  // 오타 발견 어려움

// ✅ enum 사용 - 컴파일 시점에 오류 감지
Category category = Category.WORKK;  // 컴파일 에러!
```

</details>

<details>
<summary><strong>📘 enum에 필드와 메서드 추가</strong></summary>

**Category enum 완성본**:
```java
public enum Category {
    WORK("업무"),
    STUDY("학습"),
    PERSONAL("개인"),
    HEALTH("건강"),
    OTHER("기타");

    private final String displayName;  // 한글 표시명

    // 생성자 (private만 가능)
    Category(String displayName) {
        this.displayName = displayName;
    }

    // Getter
    public String getDisplayName() {
        return displayName;
    }

    // 숫자로 enum 찾기 (1부터 시작)
    public static Category fromNumber(int number) {
        if (number < 1 || number > values().length) {
            throw new IllegalArgumentException("잘못된 구분 번호: " + number);
        }
        return values()[number - 1];
    }
}
```

**Priority enum 완성본**:
```java
public enum Priority {
    LOW(1, "낮음", "★☆☆"),
    MEDIUM(2, "보통", "★★☆"),
    HIGH(3, "높음", "★★★");

    private final int level;
    private final String displayName;
    private final String stars;

    Priority(int level, String displayName, String stars) {
        this.level = level;
        this.displayName = displayName;
        this.stars = stars;
    }

    public int getLevel() { return level; }
    public String getDisplayName() { return displayName; }
    public String getStars() { return stars; }

    // 숫자로 enum 찾기
    public static Priority fromLevel(int level) {
        for (Priority p : values()) {
            if (p.level == level) {
                return p;
            }
        }
        throw new IllegalArgumentException("잘못된 중요도: " + level);
    }
}
```

</details>

<details>
<summary><strong>📘 enum 주요 메서드</strong></summary>

**values() - 모든 상수 배열 반환**:
```java
Category[] categories = Category.values();
for (Category c : categories) {
    System.out.println(c.name() + ": " + c.getDisplayName());
}
// 출력:
// WORK: 업무
// STUDY: 학습
// PERSONAL: 개인
// HEALTH: 건강
// OTHER: 기타
```

**valueOf() - 이름으로 enum 찾기**:
```java
Category cat = Category.valueOf("WORK");  // Category.WORK 반환
Category wrong = Category.valueOf("work"); // IllegalArgumentException!
```

**ordinal() - 순서 번호 (0부터 시작)**:
```java
Category.WORK.ordinal();    // 0
Category.STUDY.ordinal();   // 1
Category.PERSONAL.ordinal(); // 2
```

**name() - enum 상수 이름 문자열**:
```java
Category.WORK.name();  // "WORK"
```

</details>

<details>
<summary><strong>📘 확장된 Todo 클래스</strong></summary>

**기능 명세서 기반 Todo.java**:
```java
package com.example.todo.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Todo {
    private static int idCounter = 1;  // ID 자동 생성용

    private int id;
    private String title;
    private Category category;
    private Priority priority;
    private LocalDate dueDate;
    private int hours;
    private boolean done;
    private LocalDateTime createdAt;

    // 생성자
    public Todo(String title, Category category, Priority priority,
                LocalDate dueDate, int hours) {
        this.id = idCounter++;
        this.title = title;
        this.category = category;
        this.priority = priority;
        this.dueDate = dueDate;
        this.hours = hours;
        this.done = false;
        this.createdAt = LocalDateTime.now();
    }

    // Getter/Setter 메서드들
    public int getId() { return id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }
    public Priority getPriority() { return priority; }
    public void setPriority(Priority priority) { this.priority = priority; }
    public LocalDate getDueDate() { return dueDate; }
    public void setDueDate(LocalDate dueDate) { this.dueDate = dueDate; }
    public int getHours() { return hours; }
    public void setHours(int hours) { this.hours = hours; }
    public boolean isDone() { return done; }
    public void setDone(boolean done) { this.done = done; }
    public LocalDateTime getCreatedAt() { return createdAt; }

    // ID 카운터 리셋 (파일 로드 시 사용)
    public static void resetIdCounter(int nextId) {
        idCounter = nextId;
    }
}
```

</details>

<details>
<summary><strong>📘 사용자 입력을 enum으로 변환</strong></summary>

**구분 입력 처리**:
```java
private Category readCategory(BufferedReader reader) throws IOException {
    while (true) {
        System.out.println("구분 선택:");
        Category[] categories = Category.values();
        for (int i = 0; i < categories.length; i++) {
            System.out.printf("%d: %s%n", i + 1, categories[i].getDisplayName());
        }
        System.out.print("선택 > ");

        try {
            int num = Integer.parseInt(reader.readLine());
            return Category.fromNumber(num);
        } catch (NumberFormatException e) {
            System.out.println("[오류] 숫자를 입력해주세요.");
        } catch (IllegalArgumentException e) {
            System.out.println("[오류] " + e.getMessage());
        }
    }
}
```

**중요도 입력 처리**:
```java
private Priority readPriority(BufferedReader reader) throws IOException {
    while (true) {
        System.out.print("중요도 (1:낮음 / 2:보통 / 3:높음) > ");

        try {
            int level = Integer.parseInt(reader.readLine());
            return Priority.fromLevel(level);
        } catch (NumberFormatException e) {
            System.out.println("[오류] 숫자를 입력해주세요.");
        } catch (IllegalArgumentException e) {
            System.out.println("[오류] 중요도는 1~3 사이의 숫자를 입력해주세요.");
        }
    }
}
```

</details>

---

## 연습 문제

### 연습: enum 기본 개념

**문제 1**: 다음 요구사항을 만족하는 코드를 작성하세요.

**요구사항**:
- `Category`라는 이름의 열거형(enum)을 정의합니다
- 상수: WORK, STUDY, PERSONAL, HEALTH, OTHER

**실행 결과**:
```
WORK
STUDY
```

```java
// 여기에 Category enum을 정의하세요

public class Main {
    public static void main(String[] args) {
        Category c1 = Category.WORK;
        Category c2 = Category.STUDY;
        System.out.println(c1);
        System.out.println(c2);
    }
}
```

<details>
<summary><strong>정답 보기</strong></summary>

```java
public enum Category {
    WORK,
    STUDY,
    PERSONAL,
    HEALTH,
    OTHER
}

public class Main {
    public static void main(String[] args) {
        Category c1 = Category.WORK;
        Category c2 = Category.STUDY;
        System.out.println(c1);
        System.out.println(c2);
    }
}
```

**설명**: `enum` 키워드로 열거형을 정의합니다. enum 상수는 쉼표로 구분합니다.

</details>

---

**문제 2**: 다음 실행 결과가 나오도록 코드를 작성하세요.

**요구사항**:
- Category enum과 switch문을 사용합니다
- `Category.STUDY`를 변수에 저장합니다
- switch문으로 카테고리에 따라 한글 이름을 출력합니다
- WORK → "업무", STUDY → "학습", 그 외 → "기타"

**실행 결과**:
```
학습
```

```java
// Category enum 정의 (WORK, STUDY, PERSONAL, HEALTH, OTHER)

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성하세요
    }
}
```

<details>
<summary><strong>정답 보기</strong></summary>

```java
enum Category {
    WORK, STUDY, PERSONAL, HEALTH, OTHER
}

public class Main {
    public static void main(String[] args) {
        Category cat = Category.STUDY;

        switch (cat) {
            case WORK:
                System.out.println("업무");
                break;
            case STUDY:
                System.out.println("학습");
                break;
            default:
                System.out.println("기타");
        }
    }
}
```

**설명**: `cat`이 `Category.STUDY`이므로 `case STUDY`가 실행됩니다.

</details>

---

**문제 3**: 다음 실행 결과가 나오도록 코드를 작성하세요.

**배경 설명**:
문자열로 카테고리를 관리하면 오타가 있어도 컴파일 시 오류가 발생하지 않습니다:
```java
String category = "WORKK";  // 오타지만 컴파일 됨
```

enum을 사용하면 존재하지 않는 값을 사용할 때 컴파일 에러가 발생합니다.

**요구사항**:
- Category enum (WORK, STUDY, PERSONAL)을 정의합니다
- WORK 카테고리를 변수에 저장하고 출력합니다
- enum을 사용하여 타입 안전성을 확보합니다

**실행 결과**:
```
카테고리: WORK
```

```java
// 여기에 코드를 작성하세요
```

<details>
<summary><strong>정답 보기</strong></summary>

```java
enum Category {
    WORK, STUDY, PERSONAL
}

public class Main {
    public static void main(String[] args) {
        Category category = Category.WORK;
        System.out.println("카테고리: " + category);
    }
}
```

**설명**: enum을 사용하면 `Category.WORKK`처럼 존재하지 않는 값을 사용할 때 **컴파일 에러**가 발생하여 오타를 미리 방지할 수 있습니다.

</details>

---

### 연습: enum에 필드와 메서드 추가

**문제 4**: 다음 실행 결과가 나오도록 코드를 작성하세요.

**요구사항**:
- Category enum을 정의합니다
- 상수: WORK, STUDY, PERSONAL
- 각 상수에 한글 표시명(displayName)을 저장합니다
  - WORK="업무", STUDY="학습", PERSONAL="개인"
- `getDisplayName()` 메서드로 한글명을 반환합니다

**실행 결과**:
```
업무
학습
```

```java
// 여기에 Category enum을 정의하세요

public class Main {
    public static void main(String[] args) {
        Category c1 = Category.WORK;
        Category c2 = Category.STUDY;
        System.out.println(c1.getDisplayName());
        System.out.println(c2.getDisplayName());
    }
}
```

<details>
<summary><strong>정답 보기</strong></summary>

```java
enum Category {
    WORK("업무"),
    STUDY("학습"),
    PERSONAL("개인");

    private final String displayName;

    Category(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}

public class Main {
    public static void main(String[] args) {
        Category c1 = Category.WORK;
        Category c2 = Category.STUDY;
        System.out.println(c1.getDisplayName());
        System.out.println(c2.getDisplayName());
    }
}
```

**설명**: enum도 필드, 생성자, 메서드를 가질 수 있습니다. enum 생성자는 항상 private입니다.

</details>

---

**문제 5**: Priority enum을 정의하세요. 각 상수는 level(int)과 displayName(String)을 가집니다.

- LOW: level=1, displayName="낮음"
- MEDIUM: level=2, displayName="보통"
- HIGH: level=3, displayName="높음"

<details>
<summary><strong>정답 보기</strong></summary>

```java
public enum Priority {
    LOW(1, "낮음"),
    MEDIUM(2, "보통"),
    HIGH(3, "높음");

    private final int level;
    private final String displayName;

    Priority(int level, String displayName) {
        this.level = level;
        this.displayName = displayName;
    }

    public int getLevel() {
        return level;
    }

    public String getDisplayName() {
        return displayName;
    }
}
```

</details>

---

### 연습: enum 메서드 (values, valueOf, ordinal)

**문제 6**: 다음 실행 결과가 나오도록 코드를 작성하세요.

**요구사항**:
- Category enum (WORK, STUDY, PERSONAL, HEALTH, OTHER)을 정의합니다
- `values()` 메서드로 모든 상수를 배열로 가져옵니다
- 반복문으로 각 상수의 순서번호(`ordinal()`)와 이름(`name()`)을 출력합니다

**실행 결과**:
```
0: WORK
1: STUDY
2: PERSONAL
3: HEALTH
4: OTHER
```

```java
// 여기에 코드를 작성하세요
```

<details>
<summary><strong>정답 보기</strong></summary>

```java
enum Category {
    WORK, STUDY, PERSONAL, HEALTH, OTHER
}

public class Main {
    public static void main(String[] args) {
        Category[] categories = Category.values();
        for (Category c : categories) {
            System.out.println(c.ordinal() + ": " + c.name());
        }
    }
}
```

**설명**:
- `values()`: 모든 enum 상수를 배열로 반환
- `ordinal()`: 선언 순서 (0부터 시작)
- `name()`: enum 상수 이름을 문자열로 반환

</details>

---

**문제 7**: 다음 실행 결과가 나오도록 코드를 작성하세요.

**배경 설명**:
`valueOf()` 메서드는 문자열로 enum 상수를 찾습니다. 단, 대소문자를 구분합니다:
- `Category.valueOf("WORK")` → 정상 동작
- `Category.valueOf("work")` → IllegalArgumentException 발생

**요구사항**:
- Category enum (WORK, STUDY, PERSONAL)을 정의합니다
- `valueOf()` 메서드로 "STUDY" 문자열에서 enum을 찾습니다
- 찾은 enum 상수를 출력합니다

**실행 결과**:
```
STUDY
```

```java
// 여기에 코드를 작성하세요
```

<details>
<summary><strong>정답 보기</strong></summary>

```java
enum Category {
    WORK, STUDY, PERSONAL
}

public class Main {
    public static void main(String[] args) {
        Category cat = Category.valueOf("STUDY");
        System.out.println(cat);
    }
}
```

**설명**: `valueOf()`는 대소문자를 구분합니다. "work"를 사용하면 `IllegalArgumentException`이 발생합니다.

</details>

---

**문제 8**: 숫자(1~5)를 입력받아 Category로 변환하는 `fromNumber(int number)` 메서드를 완성하세요.

```java
public enum Category {
    WORK("업무"),
    STUDY("학습"),
    PERSONAL("개인"),
    HEALTH("건강"),
    OTHER("기타");

    // ... 기존 코드 생략

    public static Category fromNumber(int number) {
        // 여기에 코드 작성
        // 1 → WORK, 2 → STUDY, ... 5 → OTHER
    }
}
```

<details>
<summary><strong>정답 보기</strong></summary>

```java
public static Category fromNumber(int number) {
    if (number < 1 || number > values().length) {
        throw new IllegalArgumentException("잘못된 구분 번호: " + number);
    }
    return values()[number - 1];
}
```

**사용 예**:
```java
Category cat = Category.fromNumber(2);  // STUDY
```

**설명**: `values()`는 배열을 반환하므로 인덱스 0부터 시작. 사용자 입력은 1부터이므로 `number - 1`을 사용합니다.

</details>

---

### 연습: 확장된 Todo 클래스

**문제 9**: 다음 실행 결과가 나오도록 코드를 작성하세요.

**요구사항**:
- Todo 클래스를 정의합니다
- `static` 변수 `idCounter`를 사용하여 ID를 자동 생성합니다
- 첫 번째 Todo는 id=1, 두 번째는 id=2, ...
- `getId()` 메서드로 ID를 반환합니다

**실행 결과**:
```
1
2
```

```java
// 여기에 Todo 클래스를 정의하세요

public class Main {
    public static void main(String[] args) {
        Todo todo1 = new Todo("공부");
        Todo todo2 = new Todo("운동");
        System.out.println(todo1.getId());
        System.out.println(todo2.getId());
    }
}
```

<details>
<summary><strong>정답 보기</strong></summary>

```java
class Todo {
    private static int idCounter = 1;

    private int id;
    private String title;

    public Todo(String title) {
        this.id = idCounter++;
        this.title = title;
    }

    public int getId() {
        return id;
    }
}

public class Main {
    public static void main(String[] args) {
        Todo todo1 = new Todo("공부");
        Todo todo2 = new Todo("운동");
        System.out.println(todo1.getId());
        System.out.println(todo2.getId());
    }
}
```

**설명**: `idCounter++`는 현재 값을 사용한 후 1을 증가시킵니다. `static` 변수는 클래스에 하나만 존재하여 모든 오브젝트가 공유합니다.

</details>

---

**문제 10**: 다음 실행 결과가 나오도록 코드를 작성하세요.

**요구사항**:
- Todo 클래스 (문제 9 참고)를 사용합니다
- 3개의 Todo 오브젝트를 생성합니다 (공부, 운동, 독서)
- 각 오브젝트의 ID를 출력합니다

**실행 결과**:
```
1
2
3
```

```java
// 여기에 코드를 작성하세요
```

<details>
<summary><strong>정답 보기</strong></summary>

```java
class Todo {
    private static int idCounter = 1;

    private int id;
    private String title;

    public Todo(String title) {
        this.id = idCounter++;
        this.title = title;
    }

    public int getId() {
        return id;
    }
}

public class Main {
    public static void main(String[] args) {
        Todo todo1 = new Todo("공부");
        Todo todo2 = new Todo("운동");
        Todo todo3 = new Todo("독서");

        System.out.println(todo1.getId());
        System.out.println(todo2.getId());
        System.out.println(todo3.getId());
    }
}
```

**설명**: `static` 변수 `idCounter`는 클래스에 하나만 존재하여 모든 오브젝트가 공유합니다. Todo가 생성될 때마다 1씩 증가합니다.

</details>

---

### 연습: enum과 Todo 통합

**문제 11**: 다음 실행 결과가 나오도록 코드를 작성하세요.

**요구사항**:
- Category enum (WORK="업무", STUDY="학습", PERSONAL="개인")을 정의합니다
- Priority enum (LOW=1, MEDIUM=2, HIGH=3)을 정의합니다
- Todo 클래스에 category와 priority 필드를 추가합니다
- Category는 `getDisplayName()`, Priority는 `getLevel()` 메서드를 가집니다

**실행 결과**:
```
학습
3
```

```java
// 여기에 코드를 작성하세요
// Category enum, Priority enum, Todo 클래스 정의

public class Main {
    public static void main(String[] args) {
        Todo todo = new Todo("Java 공부", Category.STUDY, Priority.HIGH);
        System.out.println(todo.getCategory().getDisplayName());
        System.out.println(todo.getPriority().getLevel());
    }
}
```

<details>
<summary><strong>정답 보기</strong></summary>

```java
enum Category {
    WORK("업무"), STUDY("학습"), PERSONAL("개인");

    private final String displayName;

    Category(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}

enum Priority {
    LOW(1), MEDIUM(2), HIGH(3);

    private final int level;

    Priority(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
}

class Todo {
    private String title;
    private Category category;
    private Priority priority;

    public Todo(String title, Category category, Priority priority) {
        this.title = title;
        this.category = category;
        this.priority = priority;
    }

    public Category getCategory() {
        return category;
    }

    public Priority getPriority() {
        return priority;
    }
}

public class Main {
    public static void main(String[] args) {
        Todo todo = new Todo("Java 공부", Category.STUDY, Priority.HIGH);
        System.out.println(todo.getCategory().getDisplayName());
        System.out.println(todo.getPriority().getLevel());
    }
}
```

**설명**:
- `todo.getCategory()` → `Category.STUDY`
- `Category.STUDY.getDisplayName()` → "학습"
- `todo.getPriority()` → `Priority.HIGH`
- `Priority.HIGH.getLevel()` → 3

</details>

---

**문제 12**: 다음 실행 결과가 나오도록 코드를 작성하세요.

**요구사항**:
- Category enum (WORK="업무", STUDY="학습", PERSONAL="개인", HEALTH="건강", OTHER="기타")을 정의합니다
- `fromNumber(int number)` 메서드를 추가합니다 (1→WORK, 2→STUDY, ...)
- 숫자 2를 입력하면 STUDY를 반환합니다

**실행 결과**:
```
선택: 학습
```

```java
// 여기에 Category enum을 정의하세요 (fromNumber 메서드 포함)

public class Main {
    public static void main(String[] args) {
        int num = 2;  // 사용자가 2를 입력했다고 가정
        Category category = Category.fromNumber(num);
        System.out.println("선택: " + category.getDisplayName());
    }
}
```

<details>
<summary><strong>정답 보기</strong></summary>

```java
enum Category {
    WORK("업무"),
    STUDY("학습"),
    PERSONAL("개인"),
    HEALTH("건강"),
    OTHER("기타");

    private final String displayName;

    Category(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static Category fromNumber(int number) {
        if (number < 1 || number > values().length) {
            throw new IllegalArgumentException("잘못된 구분 번호: " + number);
        }
        return values()[number - 1];
    }
}

public class Main {
    public static void main(String[] args) {
        int num = 2;
        Category category = Category.fromNumber(num);
        System.out.println("선택: " + category.getDisplayName());
    }
}
```

**설명**: `values()`는 배열을 반환하므로 인덱스 0부터 시작. 사용자 입력은 1부터이므로 `number - 1`을 사용합니다.

</details>

---

### 종합 연습

**문제 13**: 다음 요구사항을 만족하는 Status enum을 작성하세요.

요구사항:
- 상수: TODO, IN_PROGRESS, DONE
- 필드: displayName (한글명)
- TODO="할 일", IN_PROGRESS="진행 중", DONE="완료"
- getter 메서드 포함

<details>
<summary><strong>정답 보기</strong></summary>

```java
public enum Status {
    TODO("할 일"),
    IN_PROGRESS("진행 중"),
    DONE("완료");

    private final String displayName;

    Status(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
```

</details>

---

**문제 14**: Priority enum에 숫자로 Priority를 찾는 `fromLevel(int level)` 메서드를 구현하세요.

```java
public enum Priority {
    LOW(1, "낮음"),
    MEDIUM(2, "보통"),
    HIGH(3, "높음");

    private final int level;
    private final String displayName;

    // 생성자, getter 생략

    public static Priority fromLevel(int level) {
        // 여기에 코드 작성
        // level이 1이면 LOW, 2이면 MEDIUM, 3이면 HIGH 반환
        // 그 외의 값이면 IllegalArgumentException 발생
    }
}
```

<details>
<summary><strong>정답 보기</strong></summary>

```java
public static Priority fromLevel(int level) {
    for (Priority p : values()) {
        if (p.level == level) {
            return p;
        }
    }
    throw new IllegalArgumentException("잘못된 중요도: " + level);
}
```

**사용 예**:
```java
Priority p = Priority.fromLevel(2);  // MEDIUM
```

</details>

---

[← 이전: Step 6](step_06.md) | [목차](00.overview.md) | [다음: Step 8 →](step_08.md)