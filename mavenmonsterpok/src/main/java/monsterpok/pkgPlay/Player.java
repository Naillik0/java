/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monsterpok.pkgPlay;
import monsterpok.pkgMon.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Naillik
 */

public class Player extends Result
{

    List<Monster> myMonsters = new ArrayList<>();
    Monster mySelection;
    private static Player player;
    private String myName;
    
    public static Player getInstance() {
    if (player == null) {
    player = new Player();
    }
        return player;
    }

    protected Player(){}
    
    public static int listRandom(int size){
        Random r = new Random();
        return r.nextInt((size - 1) + 1) + 0;
    }
    
   public void triMonster()
   {
       
       boolean end = false;
       do
       {
           end = true;
           for(int i =0; i < this.myMonsters.size()-1;i++)
           {
               int v = this.myMonsters.get(i).compareTo(this.myMonsters.get(i+1));
              
               if(v == -1)
               {
                   Monster m = this.myMonsters.get(i);
                   this.myMonsters.set(i, this.myMonsters.get(i+1));
                   this.myMonsters.set(i+1, m);
                   end = false;
               }
           }  
       }while(!end); 
   }

    public List<Monster> getMonsters() {
       return this.myMonsters;
    }

    public void setMonsters(List<Monster> l) {
        this.myMonsters = l;
    }

    public void selectMonster() throws IOException {
        int select = -1;
        int ms = 0;
        List<Integer> slot = new ArrayList();
        for(Monster m : this.myMonsters)
        {
            if(!m.isDead())slot.add(ms);
            ms ++;
            System.out.println("Monster " + ms + " : " + m.getName() + " / Life " + m.getPV() + "/" + m.getPVmax());
        }
        Scanner scanner = new Scanner( System.in );
        while(select ==-1)
        {
            int v = scanner.nextInt();
            if (v > ms || v < 1 || !slot.contains(v-1)) {
                System.out.println("Not Isabelle");
            } else select = v-1;  
        }
        this.mySelection = this.myMonsters.get(select);
        
    }

    public Monster getSelect() {
        return this.mySelection;
    }

    public boolean lost() {
        int nbMonster =0;
        int nbDead =0;
        for(Monster m : this.myMonsters)
        {
            if(m.isDead())nbDead++;
            nbMonster++;
        }
        return nbMonster == nbDead;
    }

    public void setName(String scanName) {
        this.myName = scanName;
    }
    public String getName() {
        return this.myName;
    }

    void monsterInfo() {
        int i =0;
        for(Monster m : this.myMonsters)
        {
            i++;
            System.out.println("Monster" + i + " : " + m.getName() + " type " + m.getTypeName());
        }
    }
   
 
}
