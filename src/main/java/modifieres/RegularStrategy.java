package modifieres;

import helpers.StringSplitter;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class RegularStrategy implements Strategy {

    Pattern newlinesPattern = Pattern.compile("\n");

    @Override
    public String generateDeclaration(String variableValue) {
        Matcher variableValueMatcher = newlinesPattern.matcher(variableValue);
        if(variableValueMatcher.find()) {
            String[] lines = StringSplitter.splitLines(variableValue);
            return Arrays.stream(lines)
                    .map(this::createSingleDeclaration)
                    .collect(Collectors.joining("\n\t", "\t", "\n"));
        } else {
            return createSingleDeclaration(variableValue);
        }
    }

    private String createSingleDeclaration(String variableValue) {
        String variable = variableValue.replaceAll("[\"]", "");
        String variableName = Arrays.stream(StringSplitter.split(variable))
                .map(String::trim)
                .map(String::toUpperCase)
                .filter(it -> !it.isBlank())
                .collect(Collectors.joining("_"));

        return String.format("public static final String %s = \"%s\";", variableName, variable);
    }
}
