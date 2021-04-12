package helpers;

public class StringSplitter {
    public static String[] split(String string) {
        if (string == null) return new String[]{""};
        string = string
                .replaceAll("[-_.]", " ")
                .replaceAll("\\s+", " ");
        return string.split("(?<=\\p{Lu}| )(?=\\p{Lu}\\p{Ll})|(?<=[^\\p{Lu}])(?=\\p{Lu}| )");
    }

    public static String[] splitLines(String rawLines) {
        if (rawLines == null) return new String[]{""};
        rawLines = rawLines
                    .replaceAll("[^\\S\\r\\n]{3,}", "")
                    .replaceAll("\t", "");
        return rawLines.split("\n");
    }
}
