/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.Collection;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.StoredProcedureQuery;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author CHAFFORT
 */
public class ProjetTest {

    private static EntityManager em;

    @BeforeClass
    public static void setUp() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Projet_collaboratif");
        em = factory.createEntityManager();
    }

    @Before
    public void reinit() {
        StoredProcedureQuery query = em.createStoredProcedureQuery("jeux_de_tests");
        query.execute();
    }

    @Test
    public void testInsert() {
        Date now = new Date();
        Date dateLimite = new Date();
        dateLimite.setTime(dateLimite.getTime() + 3600);
        Formateur formateur = new Formateur(1);
        Session session = new Session(1);
        Projet projet = new Projet("un titre", "un sujet", now, dateLimite, formateur, session);
        em.getTransaction().begin();
        em.persist(projet);
        em.getTransaction().commit();
    }

}
