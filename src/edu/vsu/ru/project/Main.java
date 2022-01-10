package edu.vsu.ru.project;

import ru.vsu.cs.util.SwingUtils;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {
    public static CmdParams parseArgs(String[] args) {
        CmdParams params = new CmdParams();
        if (args.length > 0) {
            if (args[0].equals("--help")) {
                params.help = true;
                return params;
            }

            for (int i = 1; i < args.length; i += 2) {
                if (args[i - 1].equals("-o")) {
                    params.outputFile = args[i];
                    continue;
                }

                if (args[i - 1].equals("-i")) {
                    params.inputFile = args[i];
                    continue;
                }
            }
        }
        return params;
    }

    public static void main(String[] args) throws IOException {
        CmdParams params = parseArgs(args);
        if (params.help) {
            PrintStream out = params.error ? System.err : System.out;
            out.println("Usage:");
            out.println("  <cmd> args <input-file> (<output-file>)");
            out.println("    -i  // transform");
            out.println("  <cmd> --help");
            out.println("  <cmd> --window  // show window");
            System.exit(params.error ? 1 : 0);
        }

        String str;
        if (params.inputFile != null) {
            str = SwingUtils.readStrFromFile(params.inputFile);
        } else {
            str = readFromConsole();
        }

        String longestSentence = LongestSentence.searchForLongestSentence(str);

        if (params.outputFile != null) {
            PrintStream out = new PrintStream(params.outputFile);
            out.println(longestSentence);
        } else {
            writeOnConsole(longestSentence);
        }
    }

    private static String readFromConsole() {
        System.out.println("Введите текст. Разделителями предложений служат знаки, такие как \".\" , \"!\" и \"?\".");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private static void writeOnConsole(String longestSentence) {
        System.out.println("Данное предложение является самым длинным: ");
        System.out.println(longestSentence);
    }

    public static class CmdParams {
        public String inputFile;
        public String outputFile;
        public boolean error;
        public boolean help;
    }
}
