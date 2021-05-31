package org.bank.acount;

import lombok.Value;

import lombok.Value;

import java.time.format.DateTimeFormatter;
import java.util.function.Consumer;

    @Value
    public class StatementLine {

        public static final String FORMAT = "%s | %.2f | %.2f";
        public static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        private Transaction transaction;
        private Amount balance;

        public void printTo(Consumer<String> printer) {
            final var date = dateTimeFormatter.format(this.transaction.getDate());
            final var amount = this.transaction.getAmount().getValue();
            final var balance = this.balance.getValue();
            final var line = String.format(FORMAT, date, amount, balance);
            printer.accept(line);
        }

    }
