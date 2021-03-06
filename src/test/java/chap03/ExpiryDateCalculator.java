package chap03;

import java.time.LocalDate;
import java.time.YearMonth;

public class ExpiryDateCalculator {

//    public LocalDate calculateExpiryDate(LocalDate billingDate, int payAmount) {
//        return billingDate.plusMonths(1);
//    }

    public LocalDate calculateExpiryDate(PayData payData) {
        int addedMonths = payData.getPayAmount() / 10000;
        if (payData.getFirstBillingDate() != null){
            LocalDate candidateExp = payData.getBillingDate().plusMonths(addedMonths);
            if (YearMonth.from(candidateExp).lengthOfMonth() < payData.getFirstBillingDate().getDayOfMonth()) {
                return candidateExp.withDayOfMonth(
                        YearMonth.from(candidateExp).lengthOfMonth()
                );
            }
            if (payData.getFirstBillingDate().getDayOfMonth() != candidateExp.getDayOfMonth()) {
                return candidateExp.withDayOfMonth(
                        payData.getFirstBillingDate().getDayOfMonth()
                );
            }
        }
        return payData.getBillingDate().plusMonths(addedMonths);
    }
}
