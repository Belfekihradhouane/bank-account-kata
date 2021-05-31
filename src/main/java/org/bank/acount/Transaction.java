package org.bank.acount;

import lombok.Value;

import java.time.LocalDate;

@Value
public class Transaction {
    Amount amount;
    LocalDate date;

    public Amount amountAfterTransaction(Amount amount) {
        return this.amount.plus(amount);
    }

}
