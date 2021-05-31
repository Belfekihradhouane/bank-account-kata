package org.bank.account;

import org.bank.acount.Account;
import org.bank.acount.Amount;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AccountTest {

    @Test
    public void should_deposit_one_amount() {
        final var account = new Account();
        final var amount = Amount.of(200);
        account.depositAmount(amount);
        assertThat(account.getBalance()).isEqualTo(Amount.of(200));
    }

    @Test
    public void should_deposit_multiple_amounts() {
        final var account = new Account();
        final var amounts = Arrays.asList(
                Amount.of(250),
                Amount.of(50),
                Amount.of(100)
        );
        amounts.forEach(account::depositAmount);
        assertThat(account.getBalance()).isEqualTo(Amount.of(400));
    }

    @Test
    public void should_deposit_non_negative_amount() {
        final var account = new Account();
        final var amount = Amount.of(-100);
        assertThatThrownBy(() -> account.depositAmount(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    public void should_withdraw_one_amount() {
        final var account = new Account();
        final var amount = Amount.of(200);
        account.withdraw(amount);
        assertThat(account.getBalance()).isEqualTo(Amount.of(-200));
    }

    @Test
    public void should_withdraw_multiple_amounts() {
        final var account = new Account();
        final var amounts = Arrays.asList(
                Amount.of(250),
                Amount.of(50),
                Amount.of(100)
        );
        amounts.forEach(account::withdraw);
        assertThat(account.getBalance()).isEqualTo(Amount.of(-400));
    }

    @Test
    public void should_withdraw_non_negative_amount() {
        final var account = new Account();
        final var amount = Amount.of(-100);
        assertThatThrownBy(() -> account.withdraw(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }


}
