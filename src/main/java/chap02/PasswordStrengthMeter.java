package chap02;

public class PasswordStrengthMeter {
    public PassWordStrength meter(String s) {
        if (s == null || s.isEmpty()) return PassWordStrength.INVALID;

        int metCounts = 0;

        boolean lengthEnough = s.length() >= 8;
        if (lengthEnough) metCounts++;

        boolean containsNumber = meetsContainingNumberCriteria(s);
        if(containsNumber) metCounts++;

        boolean containsUpp = meetsContainingUppercaseCriteria(s);
        if (containsUpp) metCounts++;

        if (metCounts <= 1) {
            return PassWordStrength.WEAK;
        }

        if (metCounts == 2) {
            return PassWordStrength.NORMAL;
        }

        return PassWordStrength.STRONG;
    }

    private boolean meetsContainingUppercaseCriteria(String s) {
        for (char ch: s.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                return true;
            }
        }
        return false;
    }

    private boolean meetsContainingNumberCriteria(String s) {
        for (char ch: s.toCharArray()) {
            if (ch >= '0' && ch <= '9') {
                return true;
            }
        }
        return false;
    }
}
