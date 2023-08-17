package day5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SupplyStacks {
    public static void main(String[] args) throws IOException {
        // Open the file
        FileInputStream fstream = new FileInputStream("main/src/day5/adventofcode.com_2022_day_5_input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        String strLine;
        int totalScore = 0;

        //Read File Line By Line
        while ((strLine = br.readLine()) != null) {

        }

        //Close the input stream
        fstream.close();
        System.out.println(totalScore);
    }
}
