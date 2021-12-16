package advent_of_code.day_10;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InputValidator {

    public char findIllegalCharacter(String expression) {
        return evaluateExpression(expression, '0');
    }

    //  {([(<{}[<>[]}>{[]{[(<()>
    public char evaluateExpression(String expression, char illegalSymbol) {
        if (illegalSymbol != 0) return illegalSymbol;
        if (expression.length() == 1) return 0;
        if (isClosingSymbol(expression.charAt(0))) return expression.charAt(0);

        for (int i = 1; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (isClosingSymbol(c)) {
                if (getOpeningSymbol(c) == expression.charAt(i - 1)) {
                    return evaluateExpression((expression.substring(0, i - 1) + expression.substring(i + 1)), illegalSymbol);
                } else return c;
            } else {
//                return evaluateExpression(expression.substring(i + 1), illegalSymbol);
            }
        }

        return 0;
    }

    private boolean isAnOpenExpression(int closingSymbolIndex) {
        return closingSymbolIndex == -1;
    }

    private char getClosingSymbol(char startingSymbol) {
        if (startingSymbol == '(') return ')';
        else return (char) (startingSymbol + 2);
    }

    private char getOpeningSymbol(char closingSymbol) {
        if (closingSymbol == ')') return '(';
        else return (char) (closingSymbol - 2);
    }

    private boolean isClosingSymbol(char candidate) {
        return candidate == ')' || candidate == ']' || candidate == '}' || candidate == '>';
    }

    public long completeLine(String expression, char illegalSymbol) {
        if (expression.length() == 1) return 0;

        for (int i = 1; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (isClosingSymbol(c)) {
                if (getOpeningSymbol(c) == expression.charAt(i - 1)) {
                    return completeLine((expression.substring(0, i - 1) + expression.substring(i + 1)), illegalSymbol);
                }
            }

        }
        return scoreIncompleteExpression(expression);
    }

    private long scoreIncompleteExpression(String expression) {
        System.out.println(expression);
        List<Character> completionSymbols = new ArrayList<>();
        for (int i = expression.length() - 1; i >= 0; i--) {
            char incompleteGroupSymbol = expression.charAt(i);
            char completingSymbol = getClosingSymbol(incompleteGroupSymbol);
            completionSymbols.add(completingSymbol);
        }

        long score = 0;
        for ( char completionSymbol: completionSymbols){
            score = score * 5;
            System.out.println(score);
            score += getSymbolScore(completionSymbol);
            System.out.println(score);
        }
        System.out.println(completionSymbols.stream().map(String::valueOf).collect(Collectors.joining()));
        System.out.println(score);
        return score;
    }

    private int getSymbolScore(char symbol) {
        System.out.println(symbol);
        System.out.println(switch(symbol) {
        case ')' -> 1;
        case ']' -> 2;
        case '}' -> 3;
        case '>' -> 4;
        default -> 0;
        });
        return switch (symbol) {
            case ')' -> 1;
            case ']' -> 2;
            case '}' -> 3;
            case '>' -> 4;
            default -> 0;
        };
    }
}