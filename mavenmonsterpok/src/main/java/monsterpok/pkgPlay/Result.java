/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monsterpok.pkgPlay;
import monsterpok.pkgMon.*;
import java.util.List;

/**
 *
 * @author Naillik
 */
public class Result {

    
    public void displayMonsterRank(List<Monster> monsters){
        int i = 0;
        for (Monster m : monsters)
        {
            i++;
            System.out.println("Rank " + i + " : " + m.getName()
                                + " - Life " + m.getPV() + "/" + m.getPVmax()
                                + " - Damages deal " + m.damageDeal() 
                                + " - healing " + m.healthSomme());
        }
    }
    
}
