/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monsterpok.pkgMon;
import monsterpok.pkgAtt.*;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Naillik
 */
public class Dauphin extends Monster {
    public Dauphin() {
        super("Dauphin", 25, new Type("eau"),listAttack());
    }
    
    private static List<Attack> listAttack()
    {
        List<Attack> l = new ArrayList<>();
        l.add(new AttNormal("HeadTap",6));
        l.add(new AttNormal("Ball smash",12));        
        l.add(new AttSpe("water jet",8,new Type("eau")));        
        l.add(new AttHealth("Splash",10));
                
                
        return l; 
    }
}
