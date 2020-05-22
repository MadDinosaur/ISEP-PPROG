/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.model;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author bdian
 */
public class ProcessoSeriacaoTest {
    
    public ProcessoSeriacaoTest() {
    }

    /**
     * Test of addParticipante method, of class ProcessoSeriacao.
     */
    @Test
    public void testAddParticipante() {
        System.out.println("addParticipante");
        Colaborador part = null;
        ProcessoSeriacao instance = null;
        boolean expResult = false;
        boolean result = instance.addParticipante(part);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ordenar method, of class ProcessoSeriacao.
     */
    @Test
    public void testOrdenar() {
        System.out.println("ordenar");
        ProcessoSeriacao instance = null;
        instance.ordenar();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
