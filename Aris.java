import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Aris {
    public static void main(String[] args){

        File inputFile;
        File outputFile;

        /* input variables */
        int m = -1; // research teams
        int n = -1; // execution windows
        List<Integer> processes = new ArrayList<>();

        /*output variables */
        int k = -1; // amount of completed processes
        int x = -1; // shortest program's amount of windows
        int y = -1; // longest program's amount of windows

        if (0 < args.length) {
            inputFile = new File(args[0]);

            /* Parse file */
            try {
                Scanner myReader = new Scanner(inputFile);
                int line = 0;
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    String[] parts = data.split(" ");
                    if (line == 0) {
                        n = Integer.parseInt(parts[0]);
                        m = Integer.parseInt(parts[1]);
                    } else if (line == 1) {
                        for (String part : parts) {
                            if (Integer.parseInt(part) <= m) {
                                processes.add(Integer.parseInt(part));
                            }
                            else {
                                throw new RuntimeException("Invalid Value For Execution Window " + part);
                            }
                        }
                    } else {
                        throw new RuntimeException("Invalid Input File");
                    }
                    line++;
                }
                myReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }

            /* Validate input values */
            if (m < 0 || m > 1000000) {
                throw new RuntimeException("Invalid Value For Research Teams");
            }
            if (n < 0 || n > 1000000) {
                throw new RuntimeException("Invalid Value For Execution Windows");
            }
            if (processes.size() > n) {
                throw new RuntimeException("Invalid Amount For Execution Windows");
            }

            /* Compute */
            Map<Integer, Integer> counters = new HashMap<>();
            for (int i = 1; i <=m ; i++) {
                counters.putIfAbsent(i, 0);
            }
            for (int index : processes) {
                counters.put(index, counters.get(index) + 1);
            }

            Collection<Integer> values = counters.values();
            k = m - values.stream().filter(i -> i == 0).toList().size();
            x = Collections.min(values.stream().filter(i -> i != 0).toList());
            y = Collections.max(values);

            /* Validate output */
            if (k < 0 || x < 0 || y < 0 || k > m) {
                throw new RuntimeException("Calculation failure");
            }

            /* Write result */
            outputFile = new File(args[1]);

            try {
                if (outputFile.createNewFile()) {
                    System.out.println("File created: " + outputFile.getName());
                } else {
                    System.out.println("File already exists.");
                }
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
            try {
                FileWriter myWriter = new FileWriter(outputFile);
                myWriter.write(k + " " + x + " " + y + " ");
                myWriter.close();
                System.out.println("Successfully wrote to the file.");
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }

        } else {
            System.err.println("Invalid arguments count: " + args.length);
            System.exit(-1);
        }
    }
}