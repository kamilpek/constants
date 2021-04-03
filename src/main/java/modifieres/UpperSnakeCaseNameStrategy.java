package modifieres;

import helpers.StringSplitter;

import java.util.Arrays;
import java.util.stream.Collectors;

public class UpperSnakeCaseNameStrategy implements Strategy {
    @Override
    public String generateDeclaration(String variableValue) {
        String variable = variableValue.replaceAll("[\"]", "");
        String variableName = Arrays.stream(StringSplitter.split(variable))
                .map(String::trim)
                .map(String::toUpperCase)
                .filter(it -> !it.isBlank())
                .collect(Collectors.joining("_"));

        return String.format("public static final String %s = \"%s\";", variableName, variable);
    }
}
