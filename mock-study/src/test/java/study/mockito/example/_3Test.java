package study.mockito.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.MockSettings;
import org.mockito.Mockito;
import org.mockito.exceptions.verification.TooLittleActualInvocations;
import study.mockito.example.fixture.CustomAnswer;
import study.mockito.example.fixture.MyList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class _3Test {


    /**
     * 심플 Mockking
     */
    @Test
    void mockTest() {
        MyList listMock = mock(MyList.class);
        when(listMock.add(anyString())).thenReturn(false);

        boolean added = listMock.add("123");

        verify(listMock).add(anyString());
        assertEquals(added, false);
    }



//    @Test
//    void mocking_with_name() {
//        MyList listMock = mock(MyList.class, "myMockkk");
//        when(listMock.add(anyString())).thenReturn(false);
//
//        verify(listMock, times(2)).add(anyString());
//
//    }


    @Test
    void mocking_with_answer() {
        MyList listMock = mock(MyList.class, new CustomAnswer());
        boolean added = listMock.add("123");

        verify(listMock).add(anyString());
        assertFalse(added);

    }

    @Test
    void mocking_with_mockSettings() {
        MockSettings customSettings = withSettings().defaultAnswer(new CustomAnswer());

        MyList listMock = mock(MyList.class, customSettings);
        boolean add = listMock.add(anyString());
        verify(listMock).add(anyString());
        assertFalse(add);
    }
}
