import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Template {

    public static void main(String[] args) throws IOException {

        // Open the file
        FileInputStream fstream = new FileInputStream("main/src/dayX/adventofcode.com_2022_day_X_input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        String strLine;

        //Read File Line By Line
        while ((strLine = br.readLine()) != null)   {
            // Print the content on the console

        }

        //Close the input stream
        fstream.close();

    }
}
