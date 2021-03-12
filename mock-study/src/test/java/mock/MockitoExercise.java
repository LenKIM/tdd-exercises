package mock;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.verification.VerificationMode;

import java.util.List;

import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class MockitoExercise  {

    @BeforeAll
    static void beforeAll() {

    }

    @Test
    void name() {
        List<Integer> mock = mock(List.class);
        mock.add(1);
        mock.add(2);

        verify(mock, times(1)).add(1);
        verify(mock, never()).add(3);
    }

    @Test
    void argumentMatcher() {
        List<Integer> mock = mock(List.class);
        mock.add(1);
        mock.add(2);

        verify(mock, times(5)).add(any());
    }
}
