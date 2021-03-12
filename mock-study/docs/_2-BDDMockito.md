# BDDMockito 이해하기

BDD 는 테스트 코드를 좀더 자연스럽게, 사람이 읽을 수 있는 언어로서 행동에 초점을 맞쳐서 만들수 있도록 도와줍니다.

BDD 는 명백하게 Arrange, Act, Assert

- *given* some preconditions (Arrange)
- *when* an action occurs (Act)
- *then* verifty the output (Assert)



그럼 Mockito 와 BDDMockito 의 차이점은?

전통적인 Mocking 방식은 `*when(obj)*.*then\*()* in the Arrange step.`

```java
when(null).thenReturn(null);
verify(null);

BDDMockito.given(null).willReturn(null);
BDDMockito.then(null);

```

