package chap02;

import chap02.PassWordStrength;
import chap02.PasswordStrengthMeter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PasswordStrengthMeterTest {
    PasswordStrengthMeter meter = new PasswordStrengthMeter();

    @Test
    void 모든_규칙을_중족하면_강함을_리턴함() {
        PassWordStrength result1 = meter.meter("ab121@AB");
        assertEquals(PassWordStrength.STRONG, result1);
        PassWordStrength result2 = meter.meter("abc1Addq");
        assertEquals(PassWordStrength.STRONG, result2);
    }

    @Test
    void meetsOtherCriteria_except_for_Length_Then_Normal() {
        PassWordStrength result1 = meter.meter("ab121@A");
        assertEquals(PassWordStrength.NORMAL, result1);
    }

    @Test
    void meetsOtherCriteria_except_for_number_Then_Normal() {
        PassWordStrength result = meter.meter("abcdAasd");
        assertEquals(PassWordStrength.NORMAL, result);
    }

    @Test
    void nullInput_Then_Invalid() {
        PassWordStrength result = meter.meter(null);
        assertEquals(PassWordStrength.INVALID, result);
    }

    @Test
    void emptyInput_Then_Invalid() {
        PassWordStrength result = meter.meter("");
        assertEquals(PassWordStrength.INVALID, result);
    }

    @Test
    void meetsOtherCriteria_except_for_Uppercase_Then_Normal() {
        PassWordStrength result = meter.meter("asdf1asd");
        assertEquals(PassWordStrength.NORMAL, result);
    }

    @Test
    void meetsOnlyLengthCriteria_Then_Week() {
        PassWordStrength result = meter.meter("asdfasdf");
        assertEquals(PassWordStrength.WEAK, result);
    }

    @Test
    void meetsOnlyNumCriteria_Then_Week() {
        PassWordStrength result = meter.meter("1s");
        assertEquals(PassWordStrength.WEAK, result);
    }

    @Test
    void meetsOnlyUpperCriteria_Then_Week() {
        PassWordStrength result = meter.meter("Aasd");
        assertEquals(PassWordStrength.WEAK, result);
    }

    @Test
    void meetsNoCriteria_Then_Weak() {
        PassWordStrength result = meter.meter("asd");
        assertEquals(PassWordStrength.WEAK, result);
    }


}
