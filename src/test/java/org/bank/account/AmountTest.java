package org.bank.account;

import org.bank.acount.Amount;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class AmountTest {

    private Amount firstAmount ;
    private Amount secondAmount;
    private Amount total;


    @Test
    public void should_total_up_amounts() {
        firstAmount = Amount.of(40);
        secondAmount = Amount.of(60);
        total = firstAmount.plus(secondAmount);
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
    @Test
    public void should_return_negative_amount_value() {
        final var amount = Amount.of(200);
        assertThat(amount.negate()).isEqualTo(Amount.of(-200));

    }

    @Test
    public void should_return_positif_amount_value() {
        final var amount = Amount.of(-200);
        assertThat(amount.negate()).isEqualTo(Amount.of(200));

    }


}
