package kyu5_6;

public class SpinWords {

  public String spinWords(String sentence) {
    
    // variables
    StringBuilder sb = new StringBuilder();
    String [] splitSentence = sentence.split(" ");
    
    // algorithm
    for (String word : splitSentence) {
      if (word.length() > 4) {
        sb.append(new StringBuilder(word).reverse().toString() + " ");
      } 
      else {
        sb.append(word + " ");
      }
    }
    return sb.toString().trim();
  }
}
