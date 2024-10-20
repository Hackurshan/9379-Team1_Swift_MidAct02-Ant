package kyu7_8;

public class greeter {
  public static String greet(String name) {
        
    if(name.equals("Johnny")){
      return "Hello, my love!";
    }
    return String.format("Hello, %s!", name);
  }
}
