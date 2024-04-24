package com.dicoding.junittest

import java.util.Stack

/**
 * Utilitas kalkulator yang menyediakan metode untuk menghitung ekspresi aritmatika.
 */
object CalculatorUtil {

    /**
     * Menghitung hasil dari ekspresi aritmatika.
     *
     * @param expression ekspresi aritmatika dalam bentuk string.
     * @return hasil perhitungan ekspresi aritmatika.
     */
    fun calculate(expression: String): Int {
        val postfix = infixToPostfix(expression)
        return evaluatePostfix(postfix)
    }

    /**
     * Mengubah ekspresi aritmatika infix menjadi postfix.
     *
     * @param expression ekspresi aritmatika infix.
     * @return ekspresi aritmatika dalam bentuk postfix.
     */
    private fun infixToPostfix(expression: String): String {
        val output = StringBuilder()
        val stack = Stack<Char>()

        for (token in expression) {
            when {
                token.isDigit() -> output.append(token)
                token == '(' -> stack.push(token)
                token == ')' -> {
                    while (stack.isNotEmpty() && stack.peek() != '(') {
                        output.append(stack.pop())
                    }
                    stack.pop() // Pop '(' from stack
                }
                "+-*/".contains(token) -> {
                    while (stack.isNotEmpty() && precedence(stack.peek()) >= precedence(token)) {
                        output.append(stack.pop())
                    }
                    stack.push(token)
                }
            }
        }

        while (stack.isNotEmpty()) {
            output.append(stack.pop())
        }

        return output.toString()
    }

    /**
     * Menentukan tingkat precedensi dari operator.
     *
     * @param operator operator aritmatika.
     * @return tingkat precedensi operator.
     */
    private fun precedence(operator: Char): Int {
        return when (operator) {
            '+', '-' -> 1
            '*', '/' -> 2
            else -> 0
        }
    }

    /**
     * Mengevaluasi ekspresi aritmatika dalam bentuk postfix.
     *
     * @param expression ekspresi aritmatika dalam bentuk postfix.
     * @return hasil perhitungan ekspresi aritmatika.
     */
    private fun evaluatePostfix(expression: String): Int {
        val stack = Stack<Int>()

        for (token in expression) {
            if (token.isDigit()) {
                stack.push(token.toString().toInt())
            } else {
                val operand2 = stack.pop()
                val operand1 = stack.pop()
                val result = when (token) {
                    '+' -> operand1 + operand2
                    '-' -> operand1 - operand2
                    '*' -> operand1 * operand2
                    '/' -> {
                        if (operand2 == 0) throw ArithmeticException("Division by zero")
                        else operand1 / operand2
                    }
                    else -> throw IllegalArgumentException("Invalid operator: $token")
                }
                stack.push(result)
            }
        }

        return stack.pop()
    }
}

