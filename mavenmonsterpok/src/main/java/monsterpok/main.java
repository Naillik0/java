/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monsterpok;

import monsterpok.pkgMon.*;
import monsterpok.pkgPlay.*;
import java.io.IOException;
import static java.lang.Math.abs;
import java.util.concurrent.TimeUnit;
/**
 *
 * @author Naillik
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        // TODO code application logic here
        
       
       
        Player player1 = Player.getInstance();
        player1.setMonsters(MonsterFactory.createList(3));

        
        IAplayer player2 = IAplayer.getInstance();
        player2.setMonsters(MonsterFactory.createList(3));
        
        
        
        int c;
        int monsterNumber = 0;
        int[] playerScore = {0,0};
        int dam = 0;
        while(!player1.lost() && !player2.lost()){
            
            System.out.println("Battle number " + monsterNumber + "----------");
            
            System.out.println("Player 1 select is monster");
            player1.selectMonster();
            Monster p1M = player1.getSelect();
            System.out.println("Player 1 go for " + player1.getSelect().getName());
            System.out.println("");
            
            
            System.out.println("Player 2 select is monster");
            player2.selectMonster();
            Monster p2M = player2.getSelect();
            System.out.println("Player 2 go for " + p2M.getName());
            System.out.println("");
            
            int turn = 0;
            while(!p1M.isDead() && !p2M.isDead())
            {
                turn ++;
                System.out.println("Turn number " + turn + " ----------");
                System.out.println("");
                TimeUnit.SECONDS.sleep(2);
                System.out.println("");
                System.out.println("Player 1 :");
                System.out.println("Attack :");
                c = p1M.chooseAttack();
                System.out.println("");
                System.out.println(p1M.getName() + " use " + p1M.getAttack(c).getName());
                TimeUnit.SECONDS.sleep(1);
                if(p1M.getAttack(c).getEnemi())
                {
                    dam = p1M.useAtt(p2M,c);
                    System.out.println(p2M.getName() + " lose " + dam);
                    System.out.println(p2M.getName() +" " + p2M.getPV() + "PV");
                }
                else
                {
                    dam = p1M.useAtt(p1M,c);
                    System.out.println(p1M.getName() + " health " + abs(dam));
                    System.out.println(p1M.getName() +" " + p1M.getPV() + "PV");
                }
                TimeUnit.SECONDS.sleep(1);
                if(p2M.isDead())break;
                TimeUnit.SECONDS.sleep(1);
                System.out.println("");
                System.out.println("Player 2 :");
                c = p2M.getRandomAtt();
                System.out.println(p2M.getName() + " use " + p2M.getAttack(c).getName());
                TimeUnit.SECONDS.sleep(1);
                if(p2M.getAttack(c).getEnemi())
                {
                    dam = p2M.useAtt(p1M,c);
                    System.out.println(p1M.getName() + " lose " + dam);
                    System.out.println(p1M.getName() +" " + p1M.getPV() + "PV");
                }
                else 
                {
                    dam = p2M.useAtt(p2M,c);
                    System.out.println(p2M.getName() + " health " + abs(dam));
                    System.out.println(p2M.getName() +" " + p2M.getPV() + "PV");
                }
                System.out.println("");
                TimeUnit.SECONDS.sleep(1);
            }
            System.out.println("");
            System.out.println("Fight over : ");
            TimeUnit.SECONDS.sleep(3);
            if(p2M.isDead())
            {
                System.out.println("Winner of the Fight " + monsterNumber + " is PLAYER 1");
                playerScore[0] ++;
            }
            else 
            {
                System.out.println("Winner of the Fight " + monsterNumber + " is PLAYER 2");
                playerScore[1] ++;
            }
            monsterNumber ++;
            System.out.println("");
        }
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Player 1 win " + playerScore[0] + " / Player 2 win " + playerScore[1]);
        System.out.println("THE WINNER IS ...");
        if(playerScore[0] > playerScore[1])System.out.println("PLAYER 1");
        else if (playerScore[0] < playerScore[1])System.out.println("PLAYER 2");
        else System.out.println("DRAW");
        TimeUnit.SECONDS.sleep(3);
        
        System.out.println("");
        System.out.println("Result :");
        System.out.println("");
        System.out.println("Player 1 :");
        player1.triMonster();
        player1.displayMonsterRank(player1.getMonsters());
        System.out.println("");
        System.out.println("Player 2 :");
        player2.triMonster();
        player2.displayMonsterRank(player2.getMonsters());
        
        
        /*List<String> monsterExist = new ArrayList<>();
        monsterExist.add("Dragon");
        monsterExist.add("Licorne");       
        monsterExist.add("Dauphin");
               
        Player PLAYER = new Player(monsterExist);
        
        PLAYER.selectMyMonster();*/
        
        
    }
    
  
}
