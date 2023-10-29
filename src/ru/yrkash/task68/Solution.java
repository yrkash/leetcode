package ru.yrkash.task68;


import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<String> fullJustify(String[] words, int maxWidth) {
        int length = words.length;
        int counter = 0;
        int curLengthOfStr = 0;
        List<String> result = new ArrayList<>();
        while (counter < length) {
            StrBuilder strBuilder = new StrBuilder(maxWidth);
            curLengthOfStr += words [counter].length();
            strBuilder.add(words[counter]);
            counter++;
            while (curLengthOfStr < maxWidth) {
                if (counter == length) break;
                curLengthOfStr += words[counter].length() + 1;
                if (curLengthOfStr > maxWidth) break;
                strBuilder.add(words[counter]);
                counter++;
            }
            if (counter == length) {
                result.add(strBuilder.build(true));
            } else {
                result.add(strBuilder.build());
                curLengthOfStr = 0;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        String[] words1 = {"What","must","be","acknowledgment","shall","be"};
//        StrBuilder stringBuilder = new StrBuilder(15);
//        stringBuilder.add("This");
//        stringBuilder.add("is");
//        stringBuilder.add("an");
        List<String> result = solution.fullJustify(words1, 16);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}
