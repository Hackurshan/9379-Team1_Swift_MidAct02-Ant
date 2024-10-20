package kyu1_2;

import java.util.*;
import java.util.function.BiFunction;
import java.util.regex.*;

public class MathEvaluator {

    private static final Map<String, BiFunction<Double, Double, Double>> OPS = new HashMap<>();

    static {
        OPS.put("*", (a, b) -> a * b);
        OPS.put("/", (a, b) -> a / b);
        OPS.put("-", (a, b) -> a - b);
        OPS.put("+", (a, b) -> a + b);
    }

    public static double calculate(String expression) {
        List<String> tokens = tokenize(expression);
        return parseAddSub(tokens, 0)[0];
    }

    private static List<String> tokenize(String expression) {
        List<String> tokens = new ArrayList<>();
        Matcher matcher = Pattern.compile("[.\\d]+|[()+*/-]").matcher(expression);
        while (matcher.find()) {
            tokens.add(matcher.group());
        }
        return tokens;
    }

    private static double[] parseAddSub(List<String> tokens, int iTok) {
        double[] result = parseMulDiv(tokens, iTok);
        double v = result[0];
        iTok = (int) result[1];

        while (iTok < tokens.size() && !tokens.get(iTok).equals(")")) {
            String tok = tokens.get(iTok);
            if (tok.equals("-") || tok.equals("+")) {
                double[] result2 = parseMulDiv(tokens, iTok + 1);
                double v2 = result2[0];
                iTok = (int) result2[1];
                v = OPS.get(tok).apply(v, v2);
            }
        }
        return new double[]{v, iTok};
    }

    private static double[] parseMulDiv(List<String> tokens, int iTok) {
        double[] result = parseTerm(tokens, iTok);
        double v = result[0];
        iTok = (int) result[1];

        while (iTok < tokens.size() && (tokens.get(iTok).equals("*") || tokens.get(iTok).equals("/"))) {
            String op = tokens.get(iTok);
            double[] result2 = parseTerm(tokens, iTok + 1);
            double v2 = result2[0];
            iTok = (int) result2[1];
            v = OPS.get(op).apply(v, v2);
        }
        return new double[]{v, iTok};
    }

    private static double[] parseTerm(List<String> tokens, int iTok) {
        String tok = tokens.get(iTok);
        double v;

        if (tok.equals("(")) {
            double[] result = parseAddSub(tokens, iTok + 1);
            v = result[0];
            iTok = (int) result[1];
            if (iTok < tokens.size() && !tokens.get(iTok).equals(")")) {
                throw new IllegalArgumentException("Mismatched parentheses");
            }
            iTok++;
        } else if (tok.equals("-")) {
            double[] result = parseTerm(tokens, iTok + 1);
            v = -result[0];
            iTok = (int) result[1];
        } else {
            v = Double.parseDouble(tok);
            iTok++;
        }
        return new double[]{v, iTok};
    }
}

