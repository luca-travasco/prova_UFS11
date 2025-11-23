package com.mycompany.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Test;

public class AppTest 
{
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void testLibroCreation() {
        Libro libro = new Libro("The Hitchhiker's Guide to the Galaxy", "Douglas Adams", 193);
        assertEquals("The Hitchhiker's Guide to the Galaxy", libro.getTitolo());
        assertEquals("Douglas Adams", libro.getAutore());
        assertEquals(193, libro.getPagine());
        assertFalse(libro.isInPrestito());
    }

    @Test
    public void testSetInPrestito() {
        Libro libro = new Libro("The Hitchhiker's Guide to the Galaxy", "Douglas Adams", 193);
        libro.setInPrestito(true);
        assertTrue(libro.isInPrestito());
        libro.setInPrestito(false);
        assertFalse(libro.isInPrestito());
    }

    @Test
    public void testSetDataRestituzione() {
        Libro libro = new Libro("The Hitchhiker's Guide to the Galaxy", "Douglas Adams", 193);
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        libro.setDataRestituzione(tomorrow);
        assertEquals(tomorrow, libro.getDataRestituzione());
    }
}

