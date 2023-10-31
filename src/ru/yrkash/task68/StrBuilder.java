package ru.yrkash.task68;

import java.util.ArrayList;

public class StrBuilder {

    private ArrayList<String> strList = new ArrayList<>();
    private int width;

    public StrBuilder(int width) {
        this.width = width;
    }

    public void add(String str) {
        strList.add(str);
    }

    public String build() {
        if (strList.isEmpty()) return " ";
        StringBuilder result = new StringBuilder();
        int countOfSpaces = strList.size() - 1;
        if (countOfSpaces == 0) {
            result.append(strList.get(0));
            while (result.toString().length() < width) {
                result.append(" ");
            }
            return result.toString();
        }
        int lengthWords = (int) strList.stream()
                .flatMapToInt(CharSequence::chars)
                .count();
        int numberOfSpaces = this.width - lengthWords;
        int[] spaces = new int[countOfSpaces];
        int countOfMaxSpaces = numberOfSpaces % countOfSpaces;
        for (int i = 0; i < countOfMaxSpaces; i++) {
            spaces[i] = numberOfSpaces / countOfSpaces + 1;
        }
        for (int i = countOfMaxSpaces; i < countOfSpaces; i++) {
            spaces[i] = numberOfSpaces / countOfSpaces;
        }
        result.append(strList.get(0));
        for (int i = 0; i < countOfSpaces; i++) {
            for (int j = 0; j < spaces[i]; j++) {
                result.append(" ");
            }
            result.append(strList.get(i + 1));
        }
        return result.toString();
    }

    public String build(boolean flag) {
        if (flag) {
            StringBuilder result = new StringBuilder();
            result.append(strList.get(0));
            for (int i = 1; i < strList.size(); i++) {
                result.append(" ");
                result.append(strList.get(i));
            }
            while (result.toString().length() < width) {
                result.append(" ");
            }
            return result.toString();
        }
        return " ";
    }
}
