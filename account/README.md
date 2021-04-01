# 은행 계좌(Account) 클래스 만들기

## 은행 계좌 클래스

- 계좌 잔고 조회
- 입금/출력
- 예상 복리 이자(추가 개발)



"질문 > 응답 > 정제" 를 기억!

"질문"
1. 작성하고자 하는 메서드나 기능이 무엇인지 선별하고 작성 완료 조건을 정해서 실패하는 테스트 케이스를 작성하는 것

![image-20210309105258601](https://tva1.sinaimg.cn/mw1024/008eGmZEgy1godf181ovvj30fc07xjrv.jpg)

```java
public class AccountTest {
    
}
```



### 질문

빨간 줄이 표시된 부분을 먼저 만드는 이유는

```java
public class AccountTest {

    @Test
    void account_create() {
        //틀린 Account 를 만드는 이유는 테스트 케이스 작성 시 흐름을 잃지 않기 위해서
        Account account = new Account();
        if (account == null){
            throw new Exception("계좌 생성 실패!");
        }
    }
}
```

테스트 케이스 작성 시 흐름을 잃지 않기 위해서 입니다.



그다음 Run을 실행시키는 행위는 "코드가 예상대로 동작하는지 판단하기 위해서" 입니다.





### 응답

계좌 생성 메서드 생성

![image-20210309130157408](https://tva1.sinaimg.cn/mw1024/008eGmZEgy1godm7l5ozlj31y40d041n.jpg)



### 정제

- 소스의 가독성이 적절한가?
- 중복된 코드는 없는가?
- 이름이 잘못 부여된 메소드나 변수명은 없는가?
- 구조의 개선이 필요한 부분은 없는가?

위와 같은 질문을 해보면서, 안전그물(=앞서 작성한 테스트 케이스)에 의존해 소스를 가다듬는 단계가 정제 단계다. 지금은 원체 소심하게 진행했고, 단계 자체가 얼마 나아 가지 못했기 때문에 내용적으로는 별달리 정제할 것이 없다.



테스트 프레임워크를 활용해서 코드를 리팩토링하고,

> 저자의 한마디!
>
> 클래스 설계 시 속성을 먼저 고민해야 하지 않나?
>
> 클래스의 이름과 그 클래스의 동작이 정해졌다면 그 동작에 맞는 테스트를 작성하게 된다. 그런 데 우리는 흔히 클래스를 설계할 때 속성에 다소 집중해서 설계를 하는 경향이 있다. Account라 는 클래스를 만들기로 결정했다면, 그 다음엔 내부에 어떤 속성을 가져야 할까라는 고민을 시작 한다. ‘계좌 이름도 넣어야 할 것 같고, 고객 이름도 넣어야 할 것 같고… 아… 또 뭘 포함하고 있 어야 할까?’라는 고민을 한참 동안 하게 되기 십상이다. 클래스를 정의할 때 중요한 건 ‘속성’이 아니라 ‘동작’이다. ‘동작을 먼저 정하고, 그 동작에 필요한 속성을 고려한다’는 식으로 접근하는 편이, 불필요한 속성이 클래스 내에 섞여 들어가는 걸 줄여준다. 불필요하거나 자리를 잘못 잡 은 속성이 클래스에 포함되면 그 결과 또 다른 불필요한 동작이 클래스에 추가되어 클래스의 정 체성이나 모듈성을 훼손시킨다. 이를테면 위 예제에서 Account 클래스의 경우는 동작만 정했지 Account 클래스의 속성에 대해서는 고민하고 있지 않다. 진행해나가면서 필요하다면 추가할 예정이다.



~~Account 만들기 끝~~

- 잔고조회
- 입금
- 출력

남았음.

![image-20210309135100289](https://tva1.sinaimg.cn/mw1024/008eGmZEgy1godk6bzam8j30lv06eq3i.jpg)

```java
public class AccountTest {

    @Test
    void account_create() throws Exception {
        //틀린 Account 를 만드는 이유는 테스트 케이스 작성 시 흐름을 잃지 않기 위해서
        Account account = new Account();
        assertNotNull(account);
    }

    @Test
    void get_balance() throws Exception {

        Account account = new Account(10000);
        if (account.getBalance() != 10000){
            fail("Error");
        }

    }
}
```



이 상황에서 첫번째 예외 케이스에서 new Account() 부분에서 에러가 발생했다.

이 때 **테스트 케이스** 자체가 바로 "Account 클래스의 구조에 대해 조금 생각해보자" 라고 개발자에게 말을 걸고 있다.

이게 바로 TDD의 긍정적인 부가효과 중 하나이다.



> 테스트 케이스가 가치를 지니기 위해서는, 어떠한 경우에도 테스트 케이스 그 자체는 정상적으로 끝까지 수행돼야 한다. 그래서 단정문을 실행한 결과 실제값이 예상값과 다르다는 신호인 실 패가 나오도록 테스트 케이스를 작성해야 한다. 일반적으로 오류는 작성자가 의도하지 않은 예 상치 못한 실패(unexpected failure)를 뜻하며, 이 경우 테스트 케이스 자체에 문제가 있음을 시 사한다. 따라서 본인이 작성한 테스트 케이스에 오류(Errors)로 인한 실패가 발생하고 있다면, 빠른 시일 내에 실패(Failures)로 카운트될 수 있게 만들어야 한다.



![image-20210309135932043](https://tva1.sinaimg.cn/mw1024/008eGmZEgy1godkf8ceisj30ll063aal.jpg)

일단 실패하니까, 성공 케이스를 하드코딩으로 넣자.

```java
public class Account {

    public Account(int amount) {

    }


    public int getBalance() {
        return 10000;
    }
}
```

**테스트 케이스를 엉성하게 만들면 테스트 자체를 신뢰할 수 없게 된다.**

그러므로, 테스트 케이스를 통한 제품 코드 구현을 하드 코딩으로 시작하는 것도 괜찮은 출발점이라 할 수 있다.



그 뒤로 신뢰할 수 없는 테스트 자체를 신뢰할 수 있게 만들기 위해서 테스트 케이스를 추가하자.

```java
    @Test
    void get_balance() throws Exception {

        Account account = new Account(10000);
        if (account.getBalance() != 10000){
            fail("Error");
        }
        account = new Account(1000);
        if (account.getBalance() != 1000){
            fail("Error");
        }

        account = new Account(0);
        if (account.getBalance() != 0){
            fail("Error");
        }
    }
```



```java
public class Account {

    private int balance;

    public Account(int amount) {
        this.balance = amount;
    }

    public int getBalance() {
        return this.balance;
    }
}
```

![image-20210309140701442](https://tva1.sinaimg.cn/mw1024/008eGmZEgy1godm7fbw2mj30lv0610t4.jpg)

예제에서는 JUnit4로 테스트 프레임워크로 만들었지만, 나는 처음부터 사용해서 수정할 만한 내용이 없음.



![image-20210309140938000](https://tva1.sinaimg.cn/mw1024/008eGmZEgy1godm7ckqblj30lp08dmy7.jpg)

역시나 테스트 코드부터 만들자.

```java
    @Test
    void deposit() {
        Account account = new Account(10000);
        account.deposit(1000);
        assertEquals(11000, account.getBalance());
    }

    @Test
    void deposit() {
        Account account = new Account(10000);
        account.withdraw(1000);
        assertEquals(11000, account.getBalance());
    }
```

그 뒤로 Quick Fix로 두 개의 메소드를 자동으로 만들자.

```java
public class Account {

    private int balance;

    public Account(int amount) {
        this.balance = amount;
    }

    public int getBalance() {
        return this.balance;
    }

    public void deposit(int i) {
    }

    public void withdraw(int i) {
    }
}

```

![image-20210309141530713](https://tva1.sinaimg.cn/mw1024/008eGmZEgy1godkw3iblvj32r00nq7b6.jpg)



![image-20210309141614660](https://tva1.sinaimg.cn/mw1024/008eGmZEgy1godm78x89yj30lf092wez.jpg)



```java
public class Account {

    private int balance;

    public Account(int amount) {
        this.balance = amount;
    }

    public int getBalance() {
        return this.balance;
    }

    public void deposit(int money) {
        this.balance += money;
    }

    public void withdraw(int money) {
        this.balance -= money;
    }
}
```



이제, Account 클래스의 소스를 다듬어요!

```java
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {
    private Account account;

    @BeforeEach
    void setUp() {
        account = new Account(10000);
    }

    @Test
    void account_create() throws Exception {
        //틀린 Account 를 만드는 이유는 테스트 케이스 작성 시 흐름을 잃지 않기 위해서
//        account = new Account(10000);
        assertNotNull(account);
    }

    @Test
    void get_balance() throws Exception {

//        account = new Account(10000);
        if (account.getBalance() != 10000){
            fail("Error");
        }
        account = new Account(1000);
        if (account.getBalance() != 1000){
            fail("Error");
        }

        account = new Account(0);
        if (account.getBalance() != 0){
            fail("Error");
        }
    }

    @Test
    void deposit() {
//        account = new Account(10000);
        account.deposit(1000);
        assertEquals(11000, account.getBalance());
    }

    @Test
    void withdraw() {
//        account = new Account(10000);
        account.withdraw(1000);
        assertEquals(9000, account.getBalance());
    }
}
```
