package test;


import dssc.calculator.StringCalculator;
import org.junit.jupiter.api.Test;

import static junit.framework.TestCase.fail;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddNumbersTest {

    @Test
    void emptyString(){
        assertEquals(0, StringCalculator.add(""));
        assertThat(StringCalculator.add(""), is(0));
    }

    @Test
    void oneNumber(){
        assertEquals(1, StringCalculator.add("1"));
    }
    @Test
    void TwoNumbers(){
        assertThat(StringCalculator.add("1,2"), is(3));
    }

    @Test
    void anyNumbers() { assertThat(StringCalculator.add("1,2,3,4"), is(10)); }

    @Test
    void newLine() { assertThat(StringCalculator.add("1\n2"), is(3)); }

    @Test
    void anyDelimiter () {assertThat(StringCalculator.add("//;\n1;2"), is(3));}

    @Test
    void noNegativeAccepted(){
        try{
            StringCalculator.add("1,2,-3");
            fail("Exception expected");
        } catch (RuntimeException ex){

        }
    }

    @Test
    void ignoreOneThousand(){
        assertThat(StringCalculator.add("2,1000"), is(2));
    }

    @Test
    void anyLengthOfDelimiter(){
        assertThat(StringCalculator.add("//:::\n1:::2"), is(3));
    }
}

