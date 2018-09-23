import java.math.BigDecimal;

public class Calculator {

    private BigDecimal salaryAmount;
    private BigDecimal socialSecurityBase;

    public Calculator(BigDecimal salaryAmount, BigDecimal socialSecurityBase) {
        this.salaryAmount = salaryAmount;
        this.socialSecurityBase = socialSecurityBase;
    }

    public BigDecimal calculate() {
        BigDecimal amountWithoutSS;
        BigDecimal highestSS = new BigDecimal(7500 * 3);
        if (socialSecurityBase.compareTo(highestSS) > 0) {
            amountWithoutSS = salaryAmount.subtract(highestSS.multiply(new BigDecimal("0.175")));
        } else {
            amountWithoutSS = salaryAmount.subtract(socialSecurityBase.multiply(new BigDecimal("0.175")));
        }
        BigDecimal amountForTax = amountWithoutSS.subtract(new BigDecimal("5000"));
        RateLevel rateLevel = RateLevel.levelJudge(amountForTax);
        return amountWithoutSS.subtract(taxCalculate(rateLevel, amountForTax));
    }

    protected BigDecimal taxCalculate(RateLevel rateLevel, BigDecimal amount) {
        switch (rateLevel) {
            case LEVEL1:
                return amount.multiply(new BigDecimal("0.03"));
            case LEVEL2:
                return amount.multiply(new BigDecimal("0.1")).subtract(new BigDecimal("210"));
            case LEVEL3:
                return amount.multiply(new BigDecimal("0.2")).subtract(new BigDecimal("1410"));
            case LEVEL4:
                return amount.multiply(new BigDecimal("0.25")).subtract(new BigDecimal("2660"));
            case LEVEL5:
                return amount.multiply(new BigDecimal("0.3")).subtract(new BigDecimal("4410"));
            case LEVEL6:
                return amount.multiply(new BigDecimal("0.35")).subtract(new BigDecimal("7160"));
            case LEVEL7:
                return amount.multiply(new BigDecimal("0.45")).subtract(new BigDecimal("15160"));
            default:
                throw new IllegalArgumentException();
        }
    }
}
