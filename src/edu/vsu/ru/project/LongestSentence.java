package edu.vsu.ru.project;

import ru.vsu.cs.util.ListUtils;

import java.util.ArrayList;
import java.util.List;

public class LongestSentence {
    public static String searchForLongestSentence(String text) {
        List<String[]> word = splitText(text);
        List<String> sentenceMax = searchForSentence(word);
        return ListUtils.strListToStr(sentenceMax);
    }

    private static List<String[]> splitText(String text) {
        List<String> sentence = ListUtils.strArrayToList(text.split("[|.+|!+|?]"));

        List<String[]> words = new ArrayList<>();
        for (String i : sentence) {
            words.add(i.split(" "));
        }

        return deleteNullString(words);
    }

    private static List<String[]> deleteNullString(List<String[]> text) {
        List<String[]> words = new ArrayList<>();

        for (String[] i : text) {
            words.add(deleteNullStringArr(i));
        }

        return words;
    }

    private static String[] deleteNullStringArr(String[] sentence) {
        List<String> list = new ArrayList<>();

        for (String s : sentence) {
            if (!s.equals("")) {
                list.add(s);
            }
        }

        return ListUtils.strListToArr(list);
    }

    private static List<String> searchForSentence(List<String[]> text) {
        int maxL = 0;
        List<String> maxSentence = new ArrayList<>();

        for (String[] i : text) {
            if (i.length > maxL) {
                maxL = i.length;
                maxSentence = ListUtils.strArrayToList(i);
            }
        }

        return maxSentence;
    }
}

