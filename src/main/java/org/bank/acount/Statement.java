package org.bank.acount;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

public class Statement {

    public static final String STATEMENT_HEADER = "date | amount | balance";

    private List<StatementLine> statementLines = new LinkedList<>();

    public void addStatmentLine(StatementLine statementLine) {
        this.statementLines.add(statementLine);
    }

    public void printTo(Consumer<String> printer) {
        printer.accept(STATEMENT_HEADER);
        this.statementLines.forEach(statementLine -> statementLine.printTo(printer));
    }


}

