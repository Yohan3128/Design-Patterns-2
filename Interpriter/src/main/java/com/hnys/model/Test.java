package com.hnys.model;

interface Expression {
    public int interpret();
}

class TerminalExpression implements Expression {

    private int value;

    public TerminalExpression(int value) {
        this.value = value;
    }

    @Override
    public int interpret() {
        return this.value;
    }
}

class NonTerminalExpression implements Expression {

    private Expression leftExpression;
    private Expression rightExpression;

    public NonTerminalExpression(Expression leftExpression, Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    @Override
    public int interpret() {
        return leftExpression.interpret() + rightExpression.interpret();
    }
}

public class Test {
    public static void main(String[] args) {

        Expression expression = new NonTerminalExpression(
                new TerminalExpression(5),
                new TerminalExpression(10)
        );
        Expression expression2 = new NonTerminalExpression(new NonTerminalExpression(
                new TerminalExpression(5),
                new TerminalExpression(10)
        ), new TerminalExpression(20));


        System.out.println(expression.interpret());
        System.out.println(expression2.interpret());
    }
}
