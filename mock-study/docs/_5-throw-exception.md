## **1. Non-Void Return Type**

```java
@Test
void whenConfigNonVoidReTurnMethodToThrowEx_thenExIsThrown() {
  MyDictionary dickMock = mock(MyDictionary.class);
  when(dickMock.getMeaning(anyString())).thenThrow(NullPointerException.class);

  assertThrows(NullPointerException.class, () -> {
    dickMock.getMeaning("word");
  });
}
```

## 2.**Void Return Type**

```java
@Test
void whenConfigVoidReTurnMethodToThrowEx_thenExIsThrown() {
  MyDictionary dickMock = mock(MyDictionary.class);
  doThrow(IllegalStateException.class)
    .when(dickMock)
    .add(anyString(), anyString());

  assertThrows(IllegalStateException.class, () -> {
    dickMock.add("word", "mean");
  });
}
```

## 3.**Exception as an Object**

```java
@Test
void whenConfigNonVoidReturnMethodToThrowExWithNewExObj_thenExIsThrown() {
  MyDictionary dickMock = mock(MyDictionary.class);
  when(dickMock.getMeaning(anyString()))
    .thenThrow(new NullPointerException("err"));

  assertThrows(NullPointerException.class, () -> {
    dickMock.getMeaning("word");
  });
}
// or

@Test
void whenConfigVoidReturnMethodToThrowExWithNewExObj_thenExIsThrown() {
  MyDictionary dickMock = mock(MyDictionary.class);
  doThrow(new IllegalStateException("Error !!!"))
    .when(dickMock)
    .add(anyString(), anyString());
  assertThrows(IllegalStateException.class, () -> {
    dickMock.add("word", "meaning");
  });

}
```



## 4. Spy

```java
@Test
void givenSpy_whenConfigNonVoidReturnMethodToThrowEx_thenExIsThrown() {
  MyDictionary dict = new MyDictionary();
  MyDictionary spy = spy(dict);
  when(spy.getMeaning(anyString())).thenThrow(NullPointerException.class);

  assertThrows(NullPointerException.class, () -> {
    spy.getMeaning("word");
  });
}
```

