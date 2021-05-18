package Lesson_15;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class NumberAnalyzerTest {

    @Mock
    private static NumberInterface mockedNumbers;

    @BeforeAll
    public static void beforeMethod()
    {
        mockedNumbers = Mockito.mock(NumberInterface.class);
    }

    @RepeatedTest(100)
    public void testGreater(RepetitionInfo repetitionInfo) {
        float a = repetitionInfo.getCurrentRepetition() % 10;
        float b = repetitionInfo.getCurrentRepetition() / 10;

        System.out.println("Repetition #" + repetitionInfo.getCurrentRepetition() + " a = " + a + " b = " + b);

        float max;
        if (a>b) max = a;
        else max = b;
        assertEquals(max, NumberAnalyzer.greater(a,b));

    }

    @Test
    public void testQuadratic()
    {
        assertEquals(-1, NumberAnalyzer.quadraticCalculateX1(8,4,-4));
        assertEquals(0.5, NumberAnalyzer.quadraticCalculateX2(8,4,-4));
    }

    @Test
    public void TestMock()
    {
        Mockito.when(mockedNumbers.GetAnswerToAllQuestions()).thenReturn(42);
        assertEquals(42,mockedNumbers.GetAnswerToAllQuestions());
        System.out.println(mockedNumbers.GetAnswerToAllQuestions());
    }

    @Test
    void failTest()
    {
        fail("Failed test");
    }

    @Test
    @Disabled("Disabled test")
    void skipTest()
    {
        //not executed
    }

    @Test
    @DisplayName("Factorial test")
    void factorialTest()
    {
        assertEquals(120,NumberAnalyzer.fact(5));
        assertEquals(1,NumberAnalyzer.fact(1));
        assertEquals(1,NumberAnalyzer.fact(0));
    }

    @ParameterizedTest
    @ValueSource(ints = {100,123,9001})
    void reverseTest(int v)
    {
        String str = new Integer(v).toString();
        StringBuilder sb = new StringBuilder(str);
        int vr = Integer.parseInt(sb.reverse().toString());
        assertEquals(vr,NumberAnalyzer.reverse(v));
    }
}