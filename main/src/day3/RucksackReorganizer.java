package day3;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class RucksackReorganizer {
    public static void main(String[] args) throws IOException {
        // Open the file
        FileInputStream fstream = new FileInputStream("main/src/day3/adventofcode.com_2022_day_3_input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        String strLine;
        int totalScore = 0;
        ArrayList<String> sackList = new ArrayList<>();

        //Read File Line By Line
        while ((strLine = br.readLine()) != null)   {
            sackList.add(strLine);
        }

        for (int i = 0; i < sackList.size(); i += 3) {
            String firstRucksack = sackList.get(i);
            String secondRucksack = sackList.get(i + 1);
            String thirdRucksack = sackList.get(i + 2);

            char c = findEqualCharacter(firstRucksack, secondRucksack, thirdRucksack);
            totalScore += getPriority(c);
        }

        //Close the input stream
        fstream.close();
        System.out.println(totalScore);

    }

    public static int getPriority(char c) {
        if (Character.isLowerCase(c)) {
            return Character.getNumericValue(c) - 9;
        }
        return Character.getNumericValue(c) + 17;
    }

    public static char findEqualCharacter(String str1, String str2, String str3) {
        for (char c : str1.toCharArray()) {
            if (str2.indexOf(c) != -1 && str3.indexOf(c) != -1) {
                return c;
            }
        }
        return '\0';
    }
}
