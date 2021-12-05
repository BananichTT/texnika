/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.texnika.db;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author buldi
 */
public class TovarTest {
    public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_texnika_jar_1.0-SNAPSHOTPU");
    public static EntityManager em = emf.createEntityManager();
    
    public TovarTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }


    
    @Test
    public void testGetName() {
        System.out.println("getName");
        Query q = em.createNamedQuery("Tovar.findByIdTovar");

        q.setParameter("idTovar", 1);
        Tovar t = (Tovar) q.getSingleResult();
        String expResult = "Mixer";
        
        String result = t.getName();
        assertEquals(expResult, result);
 
    }
    
    @Test
    public void testAddTovar() throws Exception {
        Tovar t = new Tovar();
        t.setName("TeaPot");
        t.setType("Kitchen");
        t.setCost("2000");
        
        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();
    }

}
