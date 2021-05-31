package org.bank.acount;
import lombok.Data;

@Data
public class Account {
    private Amount balance = Amount.of(0);

    public void depositAmount(Amount amount) {
        verifyNotNegativeAmountValue(amount);
        this.balance = balance.plus(amount);
    }

    public Amount getBalance() {
        return this.balance;
    }

    public void withdraw(Amount amount) {
        verifyNotNegativeAmountValue(amount);
        this.balance = balance.minus(amount);

    }


    private void verifyNotNegativeAmountValue(Amount amount) {
        if (amount.isNegative()) {
            throw new IllegalArgumentException("invalid amount " + amount);
        }


    }
}
