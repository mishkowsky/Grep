package org.spbstu.aleksandrov;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

interface Finder {
    boolean grep(boolean invert, boolean register, boolean regex, String word);
}

public class Grep implements Finder {

    private final String line;

    public Grep(String line) {
        this.line = line;
    }

    public boolean grep(boolean invert, boolean register, boolean regex, String word) {

        String lowLine = line;
        boolean needToPrint;
        Pattern p;

        if (regex) {
            if (register) p = Pattern.compile(word, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
            else p = Pattern.compile(word);
            Matcher m = p.matcher(lowLine);
            needToPrint = m.find() ^ invert;
        } else {
            if (register) {
                word = word.toLowerCase();
                lowLine = line.toLowerCase();
            }
            needToPrint = lowLine.contains(word) ^ invert;
        }

        return needToPrint;
    }
}
