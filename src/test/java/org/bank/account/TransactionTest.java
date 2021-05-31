package org.bank.account;
import org.bank.acount.Amount;
import org.bank.acount.Transaction;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class TransactionTest {
    @Test
    public void should_amountAfterTransaction_deposit() {
        final var amount = Amount.of(200);
        final var transaction = new Transaction(Amount.of(100), LocalDate.now());
        assertThat(transaction.amountAfterTransaction(amount)).isEqualTo(Amount.of(300));
    }

    @Test
    public void should_amountAfterTransaction_withdraw() {
        final var amount = Amount.of(200);
        final var transaction = new Transaction(Amount.of(-100), LocalDate.now());
        assertThat(transaction.amountAfterTransaction(amount)).isEqualTo(Amount.of(100));
    }

}
