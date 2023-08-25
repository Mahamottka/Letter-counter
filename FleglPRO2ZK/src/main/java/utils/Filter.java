package utils;

import model.Znak;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Filter {
    public Filter() {
    }

    public static List<Znak> countLetters(List<String> letters) {
        Map<String, Integer> letterCounts = new HashMap<>();

        for (String letter : letters) {
            String trimmedLetter = letter.trim();
            int count = letterCounts.getOrDefault(trimmedLetter, 0);
            letterCounts.put(trimmedLetter, count + 1);
        }

        List<Znak> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : letterCounts.entrySet()) {
            String name = entry.getKey();
            int count = entry.getValue();
            result.add(new Znak(name, count));
        }

        //System.out.println(result.toString());
        //System.out.println(result.size());
        return result;
    }

}

