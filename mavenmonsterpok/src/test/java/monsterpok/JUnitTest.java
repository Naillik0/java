/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monsterpok;


import monsterpok.pkgAtt.Attack;
import monsterpok.pkgMon.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

/**
 *
 * @author Naillik
 */
public class JUnitTest {
    
    public JUnitTest() {
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }
 
   

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test 
    public void doDamage()
    {    
        Monster m = new Licorne();
        int lpdefault = m.getPV();
        m.Hit(5);
        
        assertEquals(m.getPV(), lpdefault - 5);
    }
    
    @Test 
    public void doHeal()
    {    
        Monster m = new Licorne();
        int lpdefault2 = m.getPV();
        List<Attack> att = m.getListAttack();
        int attHealth = 0;
        for(int i = 0; i < att.size() ;i++ )
        {
        	if(att.get(i).getEnemi() == false)
        	{
        		attHealth = i;
        	}
        }
        
        
        
        m.Hit(att.get(attHealth).getDegat());
        
        m.useAtt(m, attHealth);
        
        assertEquals(m.getPV(), lpdefault2);  
    }
    @Test 
    public void stopFight()
    {    
        Monster m1 = MonsterFactory.create(MonsterFactory.randomNom());
        Monster m2 = MonsterFactory.create(MonsterFactory.randomNom());
        do {
        	m1.useAtt(m2, m1.getRandomAtt());
        	m2.useAtt(m1, m2.getRandomAtt());
        }while(!m1.isDead() && !m2.isDead());
        
        assertEquals(true,m1.isDead() || m2.isDead());
    }
}
