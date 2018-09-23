import java.math.BigDecimal;

public class Starter {

    public static void main(String[] args) {
        Calculator calculator = new Calculator(new BigDecimal("15500"), new BigDecimal("12000"));
        System.out.println(calculator.calculate());
    }
}
