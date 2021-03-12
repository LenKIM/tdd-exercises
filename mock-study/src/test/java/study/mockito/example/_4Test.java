package study.mockito.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import study.mockito.example.fixture.PhoneBookRepository;
import study.mockito.example.fixture.PhoneBookService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.AdditionalMatchers.or;
import static org.mockito.Mockito.*;

/**
 * ArgumentMatcher 와 ArgumentCaptor 의 차이점은 무엇인가?
 */
@ExtendWith(MockitoExtension.class)
public class _4Test {

//    @Mock
//    PhoneBookService phoneBookService;

    @Test
    void name() {
        when(phoneBookService.search(anyString())).thenReturn("flower");
    }

    @Test
    void matcher_multiple_parameter_test() {
        when(phoneBookService.search(eq("aa"), anyString(), anyString())).thenReturn("flower");

        String search = phoneBookService.search("aa", "bb", "cc");
        assertEquals(search, "flower");
    }

    @Test
    void matcher_or_and_operator() {
        when(phoneBookService.search("aa")).thenReturn("flower");

        String search = phoneBookService.search("aa");
        assertEquals(search, "flower");

        verify(phoneBookService).search(or(eq("aa"), endsWith("a")));
    }

    @Mock
    PhoneBookRepository phoneBookRepository;

    @InjectMocks
    PhoneBookService phoneBookService;

    @Captor
    ArgumentCaptor<String> captor;

    @Test
    public void argument_captor_test() throws Exception {
        String name = "Len";
        String phone = "123123";

        phoneBookService.register(name, phone);

        verify(phoneBookRepository).contains(captor.capture());
        String value = captor.getValue();
        System.out.println(value);
        assertEquals("Len", value);
    }
}
