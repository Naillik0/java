
package monsterpok.pkgMon;

import static java.lang.Math.abs;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import monsterpok.pkgAtt.*;


public class Monster implements Comparable<Monster>{
    
    private String Name;
    private int PV;
    private Type myType;
    private List<Attack> myAttacks;
    private int PVmax;
    private int attDeal = 0;
    private int healthSomme = 0;
    
    public Monster(String named,int life,Type tp,List<Attack> att){
        this.Name = named;
        this.PV = life;
        this.PVmax = life;
        this.myType = tp;
        this.myAttacks = att;
    }
   
    public String getName()
    {
        return this.Name;
    }
    public int getPV()
    {
        return this.PV;
    }
    public Type getType()
    {
        return this.myType;
    }
    public String getTypeName()
    {
        return this.myType.getTypeStr();
    }
    
    public void Hit(int damage)
    {
        PV -= damage;
        if(PV<0)PV = 0;
        if(PV>PVmax)PV = PVmax;
    }
    public boolean isDead()
    {
        return PV == 0;
    }

    public int useAtt(Monster enemi, int num) 
    {
        Attack a = this.myAttacks.get(num);
        
        double weakDeg = Type.compareType(a.getType(), enemi.getType());
        enemi.Hit((int)(a.getDegat() * weakDeg));
        if(a.getEnemi())this.attDeal += (a.getDegat() * weakDeg);
        else this.healthSomme += -1*(a.getDegat() * weakDeg);
        return (int)(a.getDegat() * weakDeg);
        
    }
    
     public int chooseAttack() 
    {
        int select = -1;
        int as = 0;
        //List<Integer> slot = new ArrayList();
        for(Attack a : this.myAttacks)
        {
            //if(!m.isDead())slot.add(ms);
            as ++;
            if(a instanceof AttNormal)System.out.println(as + " : " + a.getName() + " - Attack normal " + a.getDegat() + " dmg / " + a.getType().getTypeStr());
            else if(a instanceof AttSpe)System.out.println(as + " : " + a.getName() + " - Attack special " + a.getDegat() + " dmg / " + a.getType().getTypeStr());
            else System.out.println(as + " : " + a.getName() + " / healing " + abs(a.getDegat())+ " hp");
            
        }
        Scanner scanner = new Scanner( System.in );
        while(select ==-1)
        {
            int v = scanner.nextInt();
            if (v > as || v < 1) {
                System.out.println("Not Isabelle");
            } else select = v-1;  
        }
        return select;
    }
    
    public Attack getAttack(int num) 
    {
         return this.myAttacks.get(num);
    }
    
    public List<Attack> getListAttack() 
    {
         return this.myAttacks;
    }
    
    
    // Function select an element base on index  
    // and return an element 
    public int getRandomAtt() 
    { 
        Random rand = new Random(); 
        return rand.nextInt(myAttacks.size()); 
    } 

    public int damageDeal() {
        return this.attDeal;
      
    }

    public int healthSomme() {
        return this.healthSomme;
       
    }

    public int getPVmax() {
        return this.PVmax;
        
    }
    @Override
    public int compareTo(Monster m)
    {
        if(this.PV + this.damageDeal() + this.healthSomme > m.getPV() + m.healthSomme() + m.damageDeal())return 1;
        if(this.PV + this.damageDeal() + this.healthSomme  < m.getPV() + m.healthSomme() + m.damageDeal())return -1;
        return 0;
    }

}

