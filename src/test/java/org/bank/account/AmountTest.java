package org.bank.account;

import org.bank.acount.Amount;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class AmountTest {

    @Test
    public void should_total_up_amounts() {
        final var firstAmount = Amount.of(40);
        final var secondAmount = Amount.of(60);
        final var total = firstAmount.plus(secondAmount);
        assertThat(total).isEqualTo(Amount.of(100));
    }

    @Test
    public void should_be_negative() {
        final var amount = Amount.of(-50);
        assertThat(amount.isNegative()).isTrue();
    }

    @Test
    public void should_be_positive() {
        final var amount = Amount.of(50);
        assertThat(amount.isNegative()).isFalse();
    }
}
