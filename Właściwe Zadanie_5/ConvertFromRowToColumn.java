/*
 authors: Wojciech Dołęga, Adam Ziętek
 */


import java.io.*;
import java.util.Objects;
import java.util.Scanner;

public class ConvertFromRowToColumn {
    private final String inputPath; // pathname of input txt file
    private final String outputPath; // pathname of output txt file
    private static String numbers; // string that contains read numbers

    public ConvertFromRowToColumn(String inputPath, String outputPath) {
        this.inputPath = inputPath;
        this.outputPath = outputPath;
    }

    public String getInputPath() {
        return inputPath;
    }

    public String getOutputPath() {
        return outputPath;
    }

    public static boolean pathValidator(String path) {
        return path.length() > 4 && path.endsWith(".txt");
    }

    public boolean checkLines(){
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(inputPath));
        } catch (FileNotFoundException ignored) {
            System.out.println("Nie znaleziono pliku!");
        }
        int lines = 0;
        while (true) {
            assert reader != null;
            try {
                if (reader.readLine() == null) break;
            } catch (IOException ignored) {
                System.out.println("Nie udało się odczytać pliku!");
            }
            lines++;
        }
        try {
            reader.close();
        } catch (IOException ignored) {

        }
        return lines <= 1;
    }

    public void read() {
        try {
            if (!pathValidator(inputPath)) {
                throw new IOException();
            }
            else if (!checkLines()) {
                throw new IOException();
            }
            else {
                Scanner inFile1 = new Scanner(new File(inputPath)).useDelimiter(",\\s*");
                numbers = inFile1.nextLine();
                inFile1.close();
            }
        } catch (IOException ignored) {
            System.out.println("Niewłaściwa nazwa pliku!");
        }
    }

    public static String convert() {
        return numbers.trim().replaceAll(" +", "\n");
    }

    public static String getValue(int index) {
        if (numbers.length() >= index + 1) {
            return Character.toString(numbers.charAt(index));
        }
        else {
            return "Podany indeks nie należy do napisu";
        }
    }

    public void write() {
        try {
            if (!pathValidator(outputPath)) {
                throw new IOException();
            }
            else {
                try {
                    PrintWriter outString = new PrintWriter(outputPath);
                    outString.println(convert());
                    outString.close();
                } catch (IOException ignored) {
                    System.out.println("Plik nie został zapisany!");
                }
            }
        } catch (IOException ignored) {
            System.out.println("Nie właściwa nazwa pliku!");
        }
    }

    @Override
    public String toString() {
        return "ConvertFromRowToColumn{" +
                "inputPath='" + inputPath + '\'' +
                ", outputPath='" + outputPath + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ConvertFromRowToColumn)) return false;
        ConvertFromRowToColumn convert = (ConvertFromRowToColumn) o;
        return getInputPath().equals(convert.getInputPath()) && getOutputPath().equals(convert.getOutputPath());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getInputPath(), getOutputPath());
    }

    public static void main(String[] args) {
        // W celu  korzystania z programu w konsoli kompilatora proszę usunąć komentarze z linijek 131-136 oraz zakomentować linijkę 137
        // W celu przetestowania funkcji w programie należy odkomentować linijki 140-154
        /*
        Scanner scan = new Scanner(System.in);
        String inPath = scan.nextLine();
        String outPath = scan.nextLine();
        ConvertFromRowToColumn converter = new ConvertFromRowToColumn(inPath, outPath);
         */
        ConvertFromRowToColumn converter = new ConvertFromRowToColumn(args[0], args[1]);
        converter.read();
        converter.write();
        /*
        System.out.println(converter.pathValidator(converter.getInputPath()));
        System.out.println(converter.checkLines());
        System.out.println(converter.pathValidator(converter.getOutputPath()));
        System.out.println(converter.convert());
        System.out.println(converter.getValue(1));
        System.out.println(converter.getValue(80));
        ConvertFromRowToColumn example = new ConvertFromRowToColumn("r", ".txt");
        System.out.println(example.pathValidator(example.getInputPath()));
        System.out.println(example.pathValidator(converter.getOutputPath()));
        System.out.println(example.convert());
        System.out.println(example.checkLines());
        example.read();
        example.write();
        */
    }
}
