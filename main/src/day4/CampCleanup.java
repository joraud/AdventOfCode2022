package day4;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class CampCleanup {
    public static void main(String[] args) throws IOException {
        // Open the file
        FileInputStream fstream = new FileInputStream("main/src/day4/adventofcode.com_2022_day_4_input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        String strLine;
        int totalScore = 0;

        //Read File Line By Line
        while ((strLine = br.readLine()) != null) {
            ArrayList<Integer> numbers = getNumbers(strLine);
            if ((numbers.get(1) >= numbers.get(2) && numbers.get(1) <= numbers.get(3))  ||
                (numbers.get(3) >= numbers.get(0) && numbers.get(3) <= numbers.get(1))) {
                totalScore += 1;
                System.out.println(numbers);
            }
        }

        //Close the input stream
        fstream.close();
        System.out.println(totalScore);
    }
    public static ArrayList<Integer> getNumbers(String str) {
        String[] numbersAsString = str.split("[,-]");
        return Arrays.stream(numbersAsString)
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
