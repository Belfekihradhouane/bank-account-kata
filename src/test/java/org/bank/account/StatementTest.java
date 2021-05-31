package org.bank.account;
import org.bank.acount.Amount;
import org.bank.acount.Statement;
import org.bank.acount.StatementLine;
import org.bank.acount.Transaction;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class StatementTest {
    @Test
    public void should_print_All_statmentLine() {

        final var statement = new Statement();

        final var firstStatementLine = new StatementLine(new Transaction(Amount.of(1000),
                LocalDate.of(2021, 3, 10)), Amount.of(2000));
        final var secondStatementLine = new StatementLine(new Transaction(Amount.of(300),
                LocalDate.of(2021, 3, 20)), Amount.of(1500));
        final var thirdStatementLine = new StatementLine(new Transaction(Amount.of(-100),
                LocalDate.of(2021, 4, 10)), Amount.of(1200));

        statement.addStatmentLine(firstStatementLine);
        statement.addStatmentLine(secondStatementLine);
        statement.addStatmentLine(thirdStatementLine);


        final var expectedStatement = "date | amount | balance" + "\n" +
                "2021-03-10 | 1000,00 | 2000,00" + "\n" +
                "2021-03-20 | 300,00 | 1500,00" + "\n" +
                "2021-04-10 | -100,00 | 1200,00" + "\n";

        final var resultStatement = new StringBuilder();

        statement.printTo(statementline -> resultStatement.append(statementline).append("\n"));

        assertThat(resultStatement.toString()).isEqualTo(expectedStatement);


    }

}
