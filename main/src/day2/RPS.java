package day2;

import java.io.*;

public class RPS {

    public static void main(String[] args) throws IOException {

        // Open the file
        FileInputStream fstream = new FileInputStream("main/src/day2/adventofcode.com_2022_day_2_input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        String strLine;
        int totalScore = 0;

        //Read File Line By Line
        while ((strLine = br.readLine()) != null)   {
            // Print the content on the console
            System.out.println (strLine);
            String opponentsChoice = strLine.substring(0, 1);
            String myChoice = strLine.substring(strLine.length() - 1);
            totalScore += getMatchScore(opponentsChoice, myChoice);
        }

        //Close the input stream
        fstream.close();

        System.out.println(totalScore);
    }

    public static int getMatchScore(String opponentsChoice, String myChoice) {
        return switch (opponentsChoice) {
            case "A" -> switch (myChoice) {
                case "X" -> 3;
                case "Y" -> 4;
                case "Z" -> 8;
                default -> 0;
            };
            case "B" -> switch (myChoice) {
                case "X" -> 1;
                case "Y" -> 5;
                case "Z" -> 9;
                default -> 0;
            };
            case "C" -> switch (myChoice) {
                case "X" -> 2;
                case "Y" -> 6;
                case "Z" -> 7;
                default -> 0;
            };
            default -> 0;
        };
    }

    public static int getChoiceScore(String myChoice) {
        return switch (myChoice) {
            case "X" -> 1;
            case "Y" -> 2;
            case "Z" -> 3;
            default -> 0;
        };
    }
}
