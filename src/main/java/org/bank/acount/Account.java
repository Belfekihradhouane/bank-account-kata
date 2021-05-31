package org.bank.acount;
import lombok.Data;

@Data
public class Account {
    private Amount balance = Amount.of(0);

    public void depositAmount(Amount amount) {
        if (amount.isNegative()) {
            throw new IllegalArgumentException("invalid amount " + amount);
        }
        this.balance = balance.plus(amount);
    }

    public Amount getBalance() {
        return this.balance;
    }

}

