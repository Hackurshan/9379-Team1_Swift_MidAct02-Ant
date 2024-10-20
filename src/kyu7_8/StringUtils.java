package kyu7_8;
public class StringUtils {
  public static boolean isVowel(String s) {
    s = s.toLowerCase();
    String regex = "[aeiou]";
    if (s.length() > 1){
      return false;
    }
    if (s.matches(regex)){
      return true; 
    }
    return false;
  }
}
