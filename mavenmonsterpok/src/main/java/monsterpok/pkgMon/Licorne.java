/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monsterpok.pkgMon;

import java.util.ArrayList;
import java.util.List;
import monsterpok.pkgAtt.*;


/**
 *
 * @author Naillik
 */
public class Licorne extends Monster {

    public Licorne() {
        super("Licorne", 30, new Type("nature"),listAttack());
    }
    private static List<Attack> listAttack()
    {
        List<Attack> l = new ArrayList<>();
        l.add(new AttNormal("Corn",5));      
        l.add(new AttSpe("Spiky torn",10,new Type("nature")));        
        l.add(new AttHealth("Fairy Wind",8));
                
                
        return l; 
    }
    
}
