package study.mockito.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import study.mockito.example.fixture.MyList;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * When / Then 학습
 */
@ExtendWith(MockitoExtension.class)
public class _6Test {

    @Test
    void configure_simple_return_behavior_for_mock() {

        MyList listMock = Mockito.mock(MyList.class);
        when(listMock.add(anyString())).thenReturn(false);

        boolean abc = listMock.add("ABC");
        assertFalse(abc);
    }

    @Test
    void configure_return_behavior_for_mock_in_an_alternative_way() {

        MyList listMock = Mockito.mock(MyList.class);
        doReturn(false).when(listMock).add(anyString());

        boolean abc = listMock.add("ABC");
        assertFalse(abc);
    }

    @Test
    void givenMethodIsConfiguredToThrowException_whenCallingMethod_thenExceptionIsThrown() {

        MyList listMock = Mockito.mock(MyList.class);
        when(listMock.add(anyString())).thenThrow(IllegalStateException.class);
        assertThrows(IllegalStateException.class, () -> {
            listMock.add("ABC");
        });
    }

    @Test
    void behaviorOfAMethodVoidReturnType() {
        MyList listMock = Mockito.mock(MyList.class);
        doThrow(NullPointerException.class).when(listMock).clear();
        assertThrows(NullPointerException.class, listMock::clear);
    }

    @Test
    void configure_the_behavior_of_multiple_calls() {
        MyList listMock = mock(MyList.class);
        when(listMock.add(anyString()))
                .thenReturn(false)
                .thenThrow(IllegalStateException.class);

        assertFalse(listMock.add("abc"));
        assertThrows(IllegalStateException.class, () -> {
            listMock.add("abc");
        });
    }

    /**
     * Spy
     */
    @Test
    void configure_the_behavior_of_a_spy() {
        final MyList instance = new MyList();
        final MyList spy = spy(instance);
        doThrow(NullPointerException.class).when(spy).size();
        assertThrows(NullPointerException.class, () -> {
            spy.size();
        });
    }

    @Test
    void configure_method_to_call_the_real_underlying_method_on_a_mock() {

        final MyList mock = mock(MyList.class);
        when(mock.size()).thenCallRealMethod();
        assertEquals(mock.size(), 1);
    }

    /**
     * Verify
     */
    @Test
    void verify_simple_invocation_on_mock() {
        List<String> mockList = mock(MyList.class);
        mockList.size();

        verify(mockList).size();
    }

    @Test
    void verify_number_of_interactions_with_mock() {

        List<String> mockList = mock(MyList.class);
        mockList.size();

        verify(mockList, times(1)).size();

        List<String> mockList2 = mock(MyList.class);
        verifyNoInteractions(mockList2);

        List<String> mockList3 = mock(MyList.class);
        verify(mockList3, times(0)).size();

        List<String> mockList4 = mock(MyList.class);
        mockList4.size();
        mockList4.clear();
        verify(mockList4).size();
        verify(mockList4).clear();
        verifyNoMoreInteractions(mockList4);

        /////////////////////////////////////

        List<String> mockedList = mock(MyList.class);
        mockedList.size();
        mockedList.add("a parameter");
        mockedList.clear();

        InOrder inOrder = Mockito.inOrder(mockedList);
        inOrder.verify(mockedList).size();
        inOrder.verify(mockedList).add("a parameter");
        inOrder.verify(mockedList).clear();

        /////////////////////////////////////

        List<String> mockList5 = mock(MyList.class);
        mockList5.size();
        verify(mockList5, never()).clear();

        /////////////////////////////////////

        List<String> mockList6 = mock(MyList.class);

        mockList6.clear();
        mockList6.clear();
        mockList6.clear();
        mockList6.clear();

        verify(mockList6, atLeast(1)).clear();
        verify(mockList6, atMost(10)).clear();

        //////////////////////////////////

        List<String> mockedList7 = mock(MyList.class);
        mockedList7.add("test");
        verify(mockedList7).add("test");
    }

    @Test
    void any_argument_with_verify() {

        List<String> mockList = mock(MyList.class);
        mockList.add("test");
        verify(mockList).add(anyString());
    }

    @Test
    void argument_capture() {
        List<String> mockedList = mock(MyList.class);
        ArrayList<String> c = new ArrayList<>();
        c.add("TTTT");
        mockedList.addAll(c);

        ArgumentCaptor<List> argumentCaptor = ArgumentCaptor.forClass(List.class);
        verify(mockedList).addAll(argumentCaptor.capture());
        List<String> captureArgu = argumentCaptor.getValue();
        assertEquals(captureArgu.get(0),"TTTT");
    }
}
