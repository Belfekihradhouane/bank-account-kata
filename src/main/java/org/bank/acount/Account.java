package org.bank.acount;
import lombok.Data;

import java.time.LocalDate;

@Data
public class Account {
    private Amount balance = Amount.of(0);
    private Statement statement;
    public Account(Amount balance, Statement statement) {
        this.balance = balance;
        this.statement = statement;
    }
    public Amount getBalance() {
        return this.balance;
    }

    public void depositAmount(Amount amount, LocalDate date) {
        verifyNotNegativeAmountValue(amount);
        save(amount, date);
    }

    public void withdrawAmount(Amount amount,LocalDate date) {
        verifyNotNegativeAmountValue(amount);
        save(amount.negate(), date);

    }


    private void verifyNotNegativeAmountValue(Amount amount) {
        if (amount.isNegative()) {
            throw new IllegalArgumentException("invalid amount " + amount);
        }

    }

    private void save(Amount amount, LocalDate date) {
        final var transaction = new Transaction(amount, date);
        this.balance = transaction.amountAfterTransaction(this.balance);
        final var statmentLine = new StatementLine(transaction, balance);
        this.statement.addStatmentLine(statmentLine);

    }

}
