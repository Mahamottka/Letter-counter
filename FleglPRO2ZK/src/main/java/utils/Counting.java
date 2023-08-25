package utils;

import model.Znak;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Counting {
    private double abs, rel;
    public Counting() {
    }
    public List<Znak> countFinal (List<Znak> listWCount, List<String> listRaw){
        List<Znak> result = new ArrayList<>();
        for (int i = 0; i < listWCount.size(); i++) {
            abs = listWCount.get(i).getPocet();
            System.out.println(listRaw.size());
            rel = (abs/ listRaw.size())*(double)100;
            Znak znak = new Znak(listWCount.get(i).getNazev(),(int) abs, rel);
            result.add(znak);
        }

        return result;
    }
}
