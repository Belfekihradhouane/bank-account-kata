package org.bank.acount;
import lombok.Value;

import java.math.BigDecimal;
import static java.math.BigDecimal.ZERO;
@Value
public class Amount {
    BigDecimal value;

    public Amount(BigDecimal value) {
        this.value = value;
    }

    public Amount plus (Amount otherAmount) {
        final var value = this.value.add(otherAmount.value);
        return new Amount(value);
    }
    public Amount negate() {
        final var value = this.value.negate();
        return new Amount(value);
    }

    public boolean isNegative() {
        return this.value.compareTo(ZERO) < 0;
    }

    public static Amount of(double value) {
        return new Amount(new BigDecimal(value));
    }

}
