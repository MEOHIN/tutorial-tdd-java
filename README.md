# tutorial-tdd-java
## TDD
1. 테스트 코드
2. 테스트를 통과하는 코드 작성
3. 리팩토링

#### TDD 예제
두 개의 날짜 (YYYYMMDD) 의 일 수 차이를 구하는 프로그램을 TDD 로 작성한다.
- 결과 = 절대값 (첫 번째 날짜의 총 일수 - 두번째 날짜의 총 일 수)
- 예시
  - 20070515 sub 20070501 = 14 
  - 20070501 sub 20070515 = 14

윤달을 주의해야한다.

### TDD 는 테스트할 목록부터 작성한다.
#### 할 일
- 두 날짜의 차이 일자를 구한다.
- 특정 일자의 총 일수를 구한다.
- 윤년을 확인한다
  - 윤년은 4로 나누어 떨어지면서 100으로 나누어 떨어지지 않는다. 단, 400으로 나누어 떨어지는 해는 윤년이다.
- 전년도까지의 총 일수를 구한다.
- 전월까지의 총 일수를 구한다.
- 해당일자까지의 총 일수를 구한다.

예시
- 20070525 날짜의 총 일수 = 0년 부터 2006년까지의 총 일수 + 2007년 1월 부터 4월 까지의 총 일수 + 15

### Junit
#### Junit 골격
```java
import junit.framework.TestCase;

public class SubDataTest extends TestCase {
  public static void main(String[] args) {
    junit.textui.TestRunner.run(SubDataTest.class);
  }
  public void test1() {
      // 생략
  }
}
```
#### junit 프레임워크 규칙
- 테스트 코드는 junit 프레임워크에 포함돼있는 TestCase 클래스를 extends 해서 작성한다.
- 메서드 이름이 test 로 시작하는 메서드는 자동으로 실행된다.

#### 프로젝트에서 사용할 TestCase 메서드
- assertEquals(a, b)
  - a 와 b 가 같은지 확인
- assertTrue(a)
  - a 가 참인지 확인
- assertFalse(a)
  - a 가 거짓인지 확인

## TDD 는 테스트가 실패할 경우에만 실제 코드를 작성한다.
```java
import junit.framework.TestCase;

public class SubDateTest extends TestCase {
  public static void main(String[] args) {
    junit.textui.TestRunner.run(SubDateTest.class);
  }
  public void testGetYearDay(){
    assertEquals(0,SubDate.getYearDay(1));
    assertEquals(365,SubDate.getYearDay(2));
  }
}
```
```java
public class SubDate {
  public static int getYearDay(int year) {
    if (year==1 ) return 0;
    else return 365;
  }
}
```
- 켄트벡(Kent Beck)은 테스트를 재빠르게 통과하기 위해서는 어떤 죄악(?)을 저질러도 상관없다고 했다.
  - 테스트를 통과만 한다면 상관없다.
  - TDD 사이클에 의해 결국에는 당연한 코드로 변경되기 때문이다.

## 테스트를 쉽게 통과할 수 있는 지 판단한다.
만약 테스트를 통과하기 어렵다고 느낀다면 미루어 두거나, 좀 더 쉬운 테스트 코드로 변환해야 한다.

## 리팩토링
- 데이터 중복을 제거한다.