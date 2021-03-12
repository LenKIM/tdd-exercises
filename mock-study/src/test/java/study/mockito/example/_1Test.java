package study.mockito.example;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;
import org.mockito.junit.jupiter.MockitoExtension;
import study.mockito.example.fixture.MyDictionary;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@ExtendWith(MockitoExtension.class)
class _1Test {

    @Mock
    Map<String, String> wordMap;

    MyDictionary spyDic;

    @BeforeEach
    void setUp() {
//        MockitoAnnotations.openMocks(this);
        spyDic = Mockito.spy(new MyDictionary(wordMap));

    }

//    @Test
//    void whenNotUseMockAnnotation_thenCorrect() {
//        List mockList = mock(ArrayList.class);
//
//        mockList.add("one");
//        verify(mockList).add("one");
//        assertEquals(0, mockList.size());
//
//        when(mockedList.size()).thenReturn(100);
//        assertEquals(100, mockedList.size());
//    }
//
//    @Mock
//    List<String> mockedList;
//
//    @Test
//    void whenNotUseMockAnnotation_thenMockIsInjected() {
//        List mockList = mock(ArrayList.class);
//
//        mockList.add("one");
//        verify(mockList).add("one");
//        assertEquals(0, mockList.size());
//
//        when(mockedList.size()).thenReturn(100);
//        assertEquals(100, mockedList.size());
//    }
//
//    @Test
//    void whenNotUseSpyAnnotation_thenCorrect() {
//        List<String> spyList = Mockito.spy(new ArrayList<>());
//        spyList.add("one");
//        spyList.add("two");
//
//        verify(spyList).add("one");
//        verify(spyList).add("two");
//
//        assertEquals(2, spyList.size());
//
//        doReturn(100).when(spyList).size();
//        when(spyList.size()).thenReturn(100);
//        assertEquals(100, spiedList.size());
//
//    }
//
//    @Spy
//    List<String> spiedList = new ArrayList<>();
//
//    @Test
//    void whenUseSpyAnnotation_thenSpyIsInjectedCorrectly() {
//        spiedList.add("one");
//        spiedList.add("two");
//
//        verify(spiedList).add("one");
//        verify(spiedList).add("two");
//
//        assertEquals(2, spiedList.size());
//
//        doReturn(100).when(spiedList).size();
//        when(spiedList.size()).thenReturn(100);
//        assertEquals(100, spiedList.size());
//    }
//
    @Test
    void whenNotUseCaptorAnnotation_thenCorrect() {
        List mockList = Mockito.mock(List.class);
        ArgumentCaptor<String> arg = ArgumentCaptor.forClass(String.class);

        mockList.add("one");
        verify(mockList).add(arg.capture());
        assertEquals("one", arg.getValue());
    }

    @Mock
    List<String> mockedList;

    @Captor
    ArgumentCaptor<String> argCaptor;

    @Test
    void whenUseCaptorAnnotation_thenTheSam() {
        mockedList.add("one");
        verify(mockedList).add(argCaptor.capture());

        assertEquals("one", argCaptor.getValue());
    }
    
//    @Mock
//    Map<String, String> wordMap;
//
//    @InjectMocks
//    MyDictionary dic = new MyDictionary();



    @Test
    void whenUseInjectMocksAnnotation_thenCorrect() {
        Mockito.when(wordMap.get("aWord")).thenReturn("aMeaning");

        assertEquals("aMeaning", spyDic.getMeaning("aWord"));
    }

//    @Spy
//    MyDictionary spyDic = new MyDictionary();
//
//    @Test
//    void whenUseInjectMocksAnnotation_thenCorrect() throws Exception {
//        Mockito.when(wordMap.get("aWord")).thenReturn("aMeaning");
//
//        assertEquals("aMeaning", spyDic.getMeaning("aWord"));
//    }
}