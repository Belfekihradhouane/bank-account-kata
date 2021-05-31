package org.bank.account;

import org.bank.acount.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.time.LocalDate;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AccountTest {
    public Account account;
    public Statement statement;
    public Amount balance = Amount.of(0);

    @BeforeEach
    public void init() {
        statement = Mockito.mock(Statement.class);
        account = new Account(balance, statement);
    }


    @Test
    public void should_deposit_one_amount() {
        final var amount = Amount.of(200);
        final var date = LocalDate.now();
        account.depositAmount(amount, date);

        assertThat(account.getBalance()).isEqualTo(Amount.of(200));
    }

    @Test
    public void should_deposit_multiple_amounts() {
        final var date = LocalDate.now();
        final var amounts = Arrays.asList(
                Amount.of(250),
                Amount.of(50),
                Amount.of(100)
        );
        amounts.forEach(amount -> {
            account.depositAmount(amount, date);
        });

        assertThat(account.getBalance()).isEqualTo(Amount.of(400));
    }

    @Test
    public void should_deposit_non_negative_amount() {
        final var date = LocalDate.now();
        final var amount = Amount.of(-100);
        assertThatThrownBy(() -> account.depositAmount(amount,date))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    public void should_withdraw_one_amount() {
        final var date = LocalDate.now();
        final var amount = Amount.of(200);
        account.withdrawAmount(amount,date);
        assertThat(account.getBalance()).isEqualTo(Amount.of(-200));
    }

    @Test
    public void should_withdraw_multiple_amounts() {
        final var date = LocalDate.now();
        final var amounts = Arrays.asList(
                Amount.of(250),
                Amount.of(50),
                Amount.of(100)
        );
        amounts.forEach(amount -> {
            account.withdrawAmount(amount, date);
        });

        assertThat(account.getBalance()).isEqualTo(Amount.of(-400));
    }

    @Test
    public void should_withdraw_non_negative_amount() {
        final var date = LocalDate.now();
        final var amount = Amount.of(-100);
        assertThatThrownBy(() -> account.withdrawAmount(amount,date))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    public void should_save_deposit_transaction() {
        final var date = LocalDate.now();
        final var amount = Amount.of(200);
        account.depositAmount(amount, date);
        Mockito.verify(statement).addStatmentLine(new StatementLine(new Transaction(Amount.of(200), date), Amount.of(200)));
    }

    @Test
    public void should_save_withdraw_transaction() {
        final var date = LocalDate.now();
        final var amount = Amount.of(200);
        account.withdrawAmount(amount, date);
        Mockito.verify(statement).addStatmentLine(new StatementLine(new Transaction(Amount.of(-200), date), Amount.of(-200)));
    }


}
