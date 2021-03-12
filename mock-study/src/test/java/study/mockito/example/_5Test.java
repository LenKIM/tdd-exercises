package study.mockito.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import study.mockito.example.fixture.MyDictionary;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

/**
 * Mocking Exception Throwing using Mockito
 */
@ExtendWith(MockitoExtension.class)
public class _5Test {

    @Test
    void whenConfigNonVoidReTurnMethodToThrowEx_thenExIsThrown() {
        MyDictionary dickMock = mock(MyDictionary.class);
        when(dickMock.getMeaning(anyString())).thenThrow(NullPointerException.class);

        assertThrows(NullPointerException.class, () -> {
            dickMock.getMeaning("word");
        });
    }

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

    @Test
    void givenSpy_whenConfigNonVoidReturnMethodToThrowEx_thenExIsThrown() {
        MyDictionary dict = new MyDictionary();
        MyDictionary spy = spy(dict);
        when(spy.getMeaning(anyString())).thenThrow(NullPointerException.class);

        assertThrows(NullPointerException.class, () -> {
            spy.getMeaning("word");
        });
    }
}
