# tutorial-tdd-java
## TDD 예제
두 개의 날짜 (YYYYMMDD) 의 일 수 차이를 구하는 프로그램을 TDD 로 작성한다.
- 결과 = 절대값 (첫 번째 날짜의 총 일수 - 두번째 날짜의 총 일 수)
- 예시
  - 20070515 sub 20070501 = 14 
  - 20070501 sub 20070515 = 14

윤달을 주의해야한다.

## TDD 는 테스트해야할 목록을 작성하는 것부터 시작한다.
#### 할 일
- 두 날짜의 차이 일자를 구한다.
- 특정 일자의 총 일수를 구한다.
- 전년도까지의 총 일수를 구한다.
- 전월까지의 총 일수를 구한다.
- 해당일자까지의 총 일수를 구한다.
- 예시
  - 20070525 날짜의 총 일수 = 0년 부터 2006년까지의 총 일수 + 2007년 1월 부터 4월 까지의 총 일수 + 15

## Junit
### Junit 골격
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
### junit 프레임워크 규칙
- 테스트 코드는 junit 프레임워크에 포함돼있는 TestCase 클래스를 extends 해서 작성한다.
- 메서드 이름이 test 로 시작하는 메서드는 자동으로 실행된다.

### 프로젝트에서 사용할 TestCase 메서드
- assertEquals(a, b)
  - a 와 b 가 같은지 확인
- assertTrue(a)
  - a 가 참인지 확인
- assertFalse(a)
  - a 가 거짓인지 확인