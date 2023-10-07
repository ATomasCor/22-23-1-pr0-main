package edu.uoc.ds.adt;


import edu.uoc.ds.adt.sequential.Stack;
import edu.uoc.ds.adt.sequential.StackArrayImpl;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PR0Stack {
    public final int CAPACITY = 10;

    private Stack<LocalDate> stack;

    public PR0Stack() {
        newStack();
    }

    public void newStack() {
        stack = new StackArrayImpl<LocalDate>(CAPACITY);
    }


    public String clearAllStack() {
        StringBuilder sb = new StringBuilder();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM");
        while (!stack.isEmpty())
            sb.append(stack.pop().format(formatter)).append(", ");
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }

    public Stack<LocalDate> getStack() {
        return this.stack;
    }

    public void push(LocalDate d) {
        this.stack.push(d);
    }
}
