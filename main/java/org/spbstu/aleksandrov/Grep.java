package org.spbstu.aleksandrov;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

interface Finder {
    List<String> grep(boolean invert, boolean register, boolean regex, String word) throws IOException;
}

public class Grep implements Finder {

    private final String inputFile;

    public Grep(String inputFile) {
        this.inputFile = inputFile;
    }

    public List<String> grep(boolean invert, boolean register, boolean regex, String word) throws IOException {
        ArrayList<String> list = new ArrayList<>();
        File file = new File(inputFile);
        FileReader FR = new FileReader(file);
        BufferedReader BR = new BufferedReader(FR);
        String line = BR.readLine();
        String lowLine;
        boolean needToPrint;
        while (line != null) {
            if (register) lowLine = line.toLowerCase(); else lowLine = line;
            if (regex) {
                Pattern p = Pattern.compile(word);
                Matcher m = p.matcher(lowLine);
                needToPrint = m.find()^invert;
            } else {
                needToPrint = lowLine.contains(word)^invert;
            }
            if (needToPrint) {
                list.add(line);
            }
            line = BR.readLine();
        }
        BR.close();
        FR.close();
        return list;
    }
}
