package org.spbstu.aleksandrov;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GrepTest {

    @Test
    public void grep() {
        assertTrue(new Grep("Great Britian").grep(false, false, false, "Great"));
        assertFalse(new Grep("Great Britian").grep(false, false, false, "great"));
        assertTrue(new Grep("Great Britian").grep(false, true, false, "great"));
        assertFalse(new Grep("Great Britian").grep(true, false, false, "Great"));
        assertFalse(new Grep("GrEat Britian").grep(false, false, true, "great"));
        assertTrue(new Grep("GrEat Britian").grep(false, true, true, "great"));
        assertFalse(new Grep("Great Britian").grep(true, true, true, "great"));
    }
}
