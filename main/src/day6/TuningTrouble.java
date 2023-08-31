package day6;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class TuningTrouble {
    public static void main(String[] args) throws IOException {

        // Open the file
        FileInputStream fstream = new FileInputStream("main/src/day6/adventofcode.com_2022_day_6_input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        String strLine;
        ArrayList<Character> letterList = new ArrayList<>();

        while ((strLine = br.readLine()) != null)   {
            for (int i = 0; i < strLine.length(); i++) {
                char letter = strLine.charAt(i);
                if (i < 14) {
                    letterList.add(letterList.size(), letter);
                    if (i == 13 && areAllElementsUnique(letterList)) {
                        System.out.println(letterList);
                        System.out.println(i);
                        break;
                    }
                } else {
                    letterList.remove(0);
                    letterList.add(letterList.size(), letter);
                    if (areAllElementsUnique(letterList)) {
                        System.out.println(letterList);
                        System.out.println(i);
                        break;
                    }
                }
            }

        }

        //Close the input stream
        fstream.close();

    }

    public static boolean areAllElementsUnique(ArrayList<Character> letterList) {
        Set<Character> s = new HashSet<>(letterList);
        return (s.size() == letterList.size());
    }
}
