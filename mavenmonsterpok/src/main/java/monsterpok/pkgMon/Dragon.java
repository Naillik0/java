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
public class Dragon extends Monster {
    public Dragon() {
        super("Dragon", 40, new Type("feu"),listAttack());
    }
     
    private static List<Attack> listAttack()
    {
        List<Attack> l = new ArrayList<>();
        l.add(new AttNormal("Tail",9));      
        l.add(new AttSpe("Fire breath",15,new Type("feu")));        
        l.add(new AttHealth("Scails up",5));
                
                
        return l; 
    }
}
