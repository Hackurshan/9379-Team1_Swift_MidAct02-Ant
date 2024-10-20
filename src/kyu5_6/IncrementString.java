package kyu5_6;

public class IncrementString {
  public static String incrementString(String str) {
        if (str.isEmpty()) {
            return "1";
        }
        char lastChar = str.charAt(str.length()-1);
        if (!Character.isDigit(lastChar)) {
            return str + "1";
        }
        String prefix = str.substring(0, str.length()-1);
        if (Character.digit(lastChar, 10) != 9) {
            return prefix + (char)(lastChar + 1);
        }

        return incrementString(prefix) + (char)(lastChar - 9);
  }
}
