package org.spbstu.aleksandrov;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GrepTest {

    @Test
    public void grep() {

        Grep grep = new Grep("Great Britian");
        Grep ruGrep = new Grep("Ярославль");
        Grep r = new Grep("ё%4!V-_ДЁzжЛw+uvF(Жrйh*эЩR=№:\"т}ы@]Эц\"gфtj&Иsd1Я~{Jbя");

        assertTrue(grep.grep(false, false, false, "Great"));
        assertFalse(grep.grep(false, false, false, "great"));
        assertTrue(grep.grep(false, true, false, "great"));
        assertFalse(grep.grep(true, false, false, "Great"));
        assertFalse(new Grep("GrEat Britian").grep(false, false, true, "great"));
        assertTrue(new Grep("GrEat Britian").grep(false, true, true, "great"));
        assertFalse(grep.grep(true, true, true, "great"));
        assertTrue(ruGrep.grep(false, true, true, "яро"));
        assertTrue(r.grep(false, false, true, "w.+?d"));
        assertTrue(r.grep(false, true, true, "W.+?\\я"));

    }
}
