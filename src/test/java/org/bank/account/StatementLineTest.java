package org.bank.account;
import org.bank.acount.Amount;
import org.bank.acount.StatementLine;
import org.bank.acount.Transaction;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class StatementLineTest {
    private LocalDate date;
    private Transaction transaction;
    private StatementLine statementLine;

    @Test
    public void should_print_deposit_statementLine() {
        this.date = LocalDate.of(2021, 04, 11);
        this.transaction = new Transaction(Amount.of(200), date);
        this.statementLine = new StatementLine(transaction, Amount.of(400));
        statementLine.printTo((line) -> assertThat(line).isEqualTo("2021-04-11 | 200,00 | 400,00"));

    }

    @Test
    public void should_print_withdraw_statementLine() {
        this.date = LocalDate.of(2021, 04, 11);
        this.transaction = new Transaction(Amount.of(-200), date);
        this.statementLine = new StatementLine(transaction, Amount.of(400));
        statementLine.printTo((line) -> assertThat(line).isEqualTo("2021-04-11 | -200,00 | 400,00"));

    }

}
