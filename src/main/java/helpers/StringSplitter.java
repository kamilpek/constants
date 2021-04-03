package helpers;

public class StringSplitter {
    public static String[] split(String string) {
        if (string == null) return new String[]{""};
        string = string
                .replaceAll("[-_.]", " ")
                .replaceAll("\\s+", " ");
        return string.split("(?<=\\p{Lu}| )(?=\\p{Lu}\\p{Ll})|(?<=[^\\p{Lu}])(?=\\p{Lu}| )");
    }
}
