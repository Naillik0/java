/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monsterpok.pkgPlay;
import monsterpok.pkgMon.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * @author Naillik
 */


public class IAplayer extends Player {
    
    private static IAplayer iaplayer;
    
    public static IAplayer getInstance() {
    if (iaplayer == null) {
    iaplayer = new IAplayer();
    }
        return iaplayer;
    }
    
    private IAplayer(){};
   
    
    @Override
    public void selectMonster(){
        int select = -1;
        int ms = 0;
        List<Integer> slot = new ArrayList();
        for(Monster m : this.myMonsters)
        {
            if(!m.isDead())slot.add(ms);
            ms ++;
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(IAplayer.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Selecting ...");
        }
        while(select == -1)
        {
            int v = getRandom(0,ms-1);
            if (v > ms || v < 1 || !slot.contains(v-1)) {
               // System.out.println("Not Isabelle");
            } else select = v-1;  
        }
        this.mySelection = this.myMonsters.get(select);
    }
    
    private static int getRandom(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
