package org.spbstu.aleksandrov;

import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GrepTest {

    Grep grep = new Grep("input\\input.txt");

    @Test
    public void grep() throws IOException {
        assertEquals(List.of("Her demands removal brought minuter raising invited mayor."),
                grep.grep(false, false, false, "mayor"));
        assertEquals(List.of("Small she six yet table china. And bed make say been then dine mrs."),
                grep.grep(true, false, false, "o"));
        assertEquals(List.of("Contented consisted continual curiosity contained get tree."),
                grep.grep(false, true, true, "\\bcuriosity\\b"));
        assertEquals(List.of(), grep.grep(false, false, false, "1"));
        assertEquals(List.of("Her demands removal brought minuter raising invited mayor.",
                "Contented consisted continual curiosity contained get tree.",
                "Small she six yet table china. And bed make say been then dine mrs."),
                grep.grep(true, true, true, "\\bso\\b"));
    }
}
