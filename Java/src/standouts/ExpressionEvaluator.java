package src.standouts;

import java.util.Stack;

/**
 * Created by tanny.
 */

public class ExpressionEvaluator {
    public static void main(String[] args) {
        String inputExpression;
        //Scanner inputExpressionScanner = new Scanner(System.in);
        //inputExpression = inputExpressionScanner.nextLine();
        inputExpression = "2+3*4*(13-3*(4/2-1))";
        inputExpression = "100 * ( 2 + 12 ) / 14";
        float expressionVal = calculateExpression(inputExpression);
        System.out.print(expressionVal);
    }

    private static float calculateExpression(String inputExpression) {

        // convert the expression string to char array
        char[] tokens = inputExpression.toCharArray();

        // we need two stacks - one to store the operands and one to store the operators
        Stack<Float> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {

            // if this token is an empty char, continue
            if (tokens[i] == ' ')
                continue;

            // if the ascii values of the tokens lie between 0 ~ 9, and make integers out of them
            if (tokens[i] >= '0' && tokens[i] <= '9') {

                // build a string of int by appending the successive integer chars
                StringBuilder tempStringBuffer = new StringBuilder();
                while (i < tokens.length && (tokens[i] >= '0' && tokens[i] <= '9')) {
                    tempStringBuffer.append(tokens[i++]);
                }
                i--;    // index moved one step ahead, need to bring it back

                // push the int to the operands stack
                operands.push(Float.parseFloat(tempStringBuffer.toString()));
            }

            // if it is a ( push it in the stack of operators
            else if (tokens[i] == '(') {
                operators.push(tokens[i]);
            }

            // start calculating only if it is a )
            else if (tokens[i] == ')') {

                while (operators.peek() != '(') {
                    char thisOperator = operators.pop();
                    float thisOperand = operands.pop();

                    // if last of the values, calculate the values
                    if (operators.peek() == '(') {
                        operands.push(calculateValue(thisOperator, thisOperand, operands.pop()));
                    }

                    // else check for precedence of operators
                    else if (hasPrecedence(thisOperator, operators.peek()))
                        operands.push(calculateValue(thisOperator, thisOperand, operands.pop()));
                    else {
                        // calculate the higher precedence operators and then push the lower precendence values in the stacks
                        operands.push(calculateValue(operators.pop(), operands.pop(), operands.pop()));
                        operands.push(thisOperand);
                        operators.push(thisOperator);
                    }
                }
                operators.pop();
            } else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '/' || tokens[i] == '*') {

                // calculate and push the value in the operands stack if this operator has higher precedence than the last operator
                if (!operators.empty() && hasPrecedence(tokens[i], operators.peek()))
                    operands.push(calculateValue(operators.pop(), operands.pop(), operands.pop()));

                // push the latest operator to the stack
                operators.push(tokens[i]);
            }

        }

        // calculate the rest of the operands operators stack
        while (!operators.empty())
            operands.push(calculateValue(operators.pop(), operands.pop(), operands.pop()));

        return operands.pop();
    }

    private static boolean hasPrecedence(char thisOperator, char nextOperator) {
        if (nextOperator == '(' || nextOperator == ')')
            return false;
        else if ((thisOperator == '*' || thisOperator == '/') && (nextOperator == '+'
                        || nextOperator == '-'))
            return false;
        else
            return true;
    }

    private static float calculateValue(char operator, float val2, float val1) {

        // calculate the value between two operands and operators
        float returnValue = 0;
        if (operator == '+')
            returnValue = val1 + val2;
        else if (operator == '-')
            returnValue = val1 - val2;
        else if (operator == '*')
            returnValue = val1 * val2;
        else if (operator == '/') {
            if (val2 != 0)
                returnValue = val1 / val2;
            else
                throw new ArithmeticException("Reached a divide by zero scenario!!");
        }
        return returnValue;
    }
}
