import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ProcessInputFile {

    private final String fileName;
    private final int fileSize;

    ProcessInputFile(String fileName, int fileSize) {

        this.fileName = fileName;
        this.fileSize = fileSize;
    }


    public Integer[] getInteger()
    {
        Integer[] input = new Integer[fileSize];
        int i = 0;

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = bufferedReader.readLine()) != null)
            {
                input[i++] = Integer.parseInt(line);
            }
        }catch (IOException io){
            io.printStackTrace();
        }

        return input;
    }
}
