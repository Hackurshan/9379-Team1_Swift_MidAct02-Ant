class Solution {
    public static String camelCase(String input) {
        String[] words = input.split("(?<!^)(?=[A-Z])");
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            output = output.append(words[i] + " ");
        }
        output = output.deleteCharAt(output.length()-1);
        return String.valueOf(output);
    }

    public static void main(String[] args) {
        System.out.println(camelCase(""));
    }
}
