import java.math.BigDecimal;

public enum RateLevel {

    LEVEL1, LEVEL2, LEVEL3, LEVEL4, LEVEL5, LEVEL6, LEVEL7;

    static RateLevel levelJudge(BigDecimal amount) {
        if (amount.compareTo(new BigDecimal("3000")) < 1) {
            return LEVEL1;
        } else if (amount.compareTo(new BigDecimal("12000")) < 1) {
            return LEVEL2;
        }  else if (amount.compareTo(new BigDecimal("25000")) < 1) {
            return LEVEL3;
        } else if (amount.compareTo(new BigDecimal("35000")) < 1) {
            return LEVEL4;
        } else if (amount.compareTo(new BigDecimal("55000")) < 1) {
            return LEVEL5;
        } else if (amount.compareTo(new BigDecimal("80000")) < 1) {
            return LEVEL6;
        } else {
            return LEVEL7;
        }
    }
}
