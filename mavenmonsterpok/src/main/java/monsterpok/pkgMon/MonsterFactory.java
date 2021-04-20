/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monsterpok.pkgMon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Naillik
 */
public class MonsterFactory {

    private enum listNom {
        Licorne ,
        Dauphin,
        Dragon
    }
    private enum typeglobal {
        Licorne ,
        Dauphin,
        Dragon
    }
    private enum forceNiveau {
        Licorne ,
        Dauphin,
        Dragon
    }
    
    public static Monster create(listNom nom)
    {
        switch(nom)
        {
            case Licorne :
                return new Licorne();
            case Dauphin :
                return new Dauphin();    
            case Dragon :
                return new Dragon();
            default : return new Licorne();
        }
    }
    
    public static List<Monster> createList(int nb)
    {
        List<Monster> l = new ArrayList();
        for(int i =0;i<nb;i++)
        {
           l.add(create(randomNom())); 
        }
        return l;
    }
    private static final List<listNom> VALUES =
    Collections.unmodifiableList(Arrays.asList(listNom.values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static listNom randomNom()  {
    return VALUES.get(RANDOM.nextInt(SIZE));
  }
    
    public static List<String> listNomString() {
        List<String> l= new ArrayList(); 
        for (listNom b : listNom.values()) {
            l.add(b.name());
        }
        return l;
    }
    public static void info() {
        System.out.println("");
    }

    public static List<Monster> createTeam() {
        return (List<Monster>) new Licorne();
    }
}
