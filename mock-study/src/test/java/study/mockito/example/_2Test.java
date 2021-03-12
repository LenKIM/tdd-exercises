package study.mockito.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import study.mockito.example.fixture.PhoneBookRepository;
import study.mockito.example.fixture.PhoneBookService;

import static org.mockito.BDDMockito.*;

@ExtendWith(MockitoExtension.class)
public class _2Test {

    @Test
    void name() {
        when(null).thenReturn(null);
        verify(null);

        given(null).willReturn(null);
        then(null);
    }

    @Mock
    PhoneBookRepository phoneBookRepository;
    @Mock
    PhoneBookService phoneBookService;

    @Test
    void bdd_mockito() {

        String momContactName = "";
        String xContactName = "";
        String momPhoneNumber = "";

        given(phoneBookRepository.contains(momContactName))
                .willReturn(false);

        phoneBookService.register(xContactName, "");

        then(phoneBookRepository)
                .should(never())
                .insert(momContactName, momPhoneNumber);
    }
}
