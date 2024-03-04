package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class gradesheetTest {

    @Test
    void gradeTestAplus() {
        gradesheet gs=new gradesheet();
        assertEquals("A+",gs.gradecalculator(100));

    }

    @Test
    void gradeTestA() {
        gradesheet gs=new gradesheet();
        assertNotEquals("A+",gs.gradecalculator(80));

    }

    @Test
    void gradeTestAminus() {
        gradesheet gs=new gradesheet();
        assertEquals("A-",gs.gradecalculator(70));

    }


    @Test
    void gradeTestB() {
        gradesheet gs=new gradesheet();
        assertEquals("A+",gs.gradecalculator(100));

    }

    @Test
    void gradeTestBminus() {
        gradesheet gs=new gradesheet();
        assertEquals("A+",gs.gradecalculator(100));

    }

    @Test
    void gradeTestF() {
        gradesheet gs=new gradesheet();
        assertEquals("A+",gs.gradecalculator(100));

    }
}