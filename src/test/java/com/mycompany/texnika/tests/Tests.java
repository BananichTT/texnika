/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.texnika.tests;

import com.mycompany.texnika.db.Tovar;
import com.mycompany.texnika.db.User;
import com.mycompany.texnika.db.UserRole;
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
public class Tests {
    public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_texnika_jar_1.0-SNAPSHOTPU");
    public static EntityManager em = emf.createEntityManager();
    
    public Tests() {
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
    public void test() {
        System.out.println("getName");
        Query q = em.createNamedQuery("User.findByLogin");

        q.setParameter("login", "san");
        User user = (User) q.getSingleResult();
        UserRole role = user.getRoleId();
        
        String expResult = "user";
        
        String result = role.getRoleName();
        assertEquals(expResult, result);
 
    }

}
