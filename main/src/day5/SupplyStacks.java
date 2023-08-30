package day5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SupplyStacks {
    public static void main(String[] args) throws IOException {
        // Open the file
        FileInputStream fstream = new FileInputStream("main/src/day5/adventofcode.com_2022_day_5_input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        String strLine;
        int lineIndex = 0;
        char[][] initialContainers = new char[8][9];
        char[][] containers = new char[0][0];
        boolean areContainersInitialized = false;

        while ((strLine = br.readLine()) != null) {
            if (lineIndex < 8) {
                List<Character> letters = extractLetters(strLine);
                for (int i = 0; i < letters.size(); i++) {
                    initialContainers[lineIndex][i] = letters.get(i);
                }
            } else if (lineIndex > 9) {
                if (!areContainersInitialized) {
                    containers = getContainers(initialContainers);
                    areContainersInitialized = true;
                }
                int[] numbers = extractNumbersFromString(strLine);

                int amount = numbers[0];
                int startNumber = numbers[1] - 1;
                int endNumber = numbers[2] - 1;

                for (int i = 0; i < amount; i++) {
                    char charToBeMoved = getAndRemoveCharacter(containers, startNumber);
                    int destinationIndex = getEmptyPlaceIndex(containers, endNumber);
                    containers[destinationIndex][endNumber] = charToBeMoved;

                    System.out.println(charToBeMoved);
                    System.out.println(destinationIndex);
                }
            }
            lineIndex++;

        }

        fstream.close();
        System.out.println(getAnswer(containers));
    }

    public static List<Character> extractLetters(String input) {
        List<Character> resultList = new ArrayList<>();
        for (int i = 1; i < input.length(); i += 4) {
            resultList.add(input.charAt(i));
        }

        return resultList;
    }

    public static int[] extractNumbersFromString(String input) {
        int[] numbers = new int[3];

        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(input);

        for (int i = 0; i < 3 && matcher.find(); i++) {
            numbers[i] = Integer.parseInt(matcher.group());
        }

        return numbers;
    }

    public static int getEmptyPlaceIndex(char[][] containers, int columnIndex) {
        for (int i = containers.length - 1; i >= 0; i--) {
            if (containers[i][columnIndex] == ' ') {
                return i;
            }
        }
        return 0;
    }

    public static char getAndRemoveCharacter(char[][] containers, int columnIndex) {
        for (int i = 0; i < containers.length; i++) {
            if (containers[i][columnIndex] != ' ') {
                char charToBeMoved = containers[i][columnIndex];
                containers[i][columnIndex] = ' ';
                return charToBeMoved;
            }
        }
        return 0;
    }

    public static char[][] getContainers(char[][] initialContainers) {
        char[][] combinedArray = new char[64][9];


        char[][] buffer = new char[56][9];
        for (int i = 0; i < 56; i++) {
            for (int j = 0; j < 9; j++) {
                buffer[i][j] = ' ';
            }
        }

        for (int i = 0; i < buffer.length; i++) {
            combinedArray[i] = buffer[i];
        }

        for (int i = 0; i < initialContainers.length; i++) {
            combinedArray[i + buffer.length] = initialContainers[i];
        }

        return combinedArray;
    }

    public static String getAnswer(char[][] containers) {
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            answer.append(getAndRemoveCharacter(containers, i));
        }
        return answer.toString();
    }
}
