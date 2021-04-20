/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monsterpok.pkgPlay;

import monsterpok.pkgMon.MonsterFactory;

/**
 *
 * @author Naillik
 */
public class GameState {

    
    private static GameState gameState;

    public static GameState getInstance() {
        if (gameState == null) {
            gameState = new GameState();
        }
        return gameState;
    }

    public enum State{
        Intro,
        Menu,
        Figth,
        Move
    }
    private GameState() {};
    
    
    State gs = State.Intro;
    Player player = Player.getInstance();
    
    
    
    public void start(){
        switch(gs){
            case Intro :
                System.out.println("Welcome to MonsterPok projet");
                System.out.println("what is your name");
                player.setName(gameState.scanName());
                System.out.println(player.getName() + ", what a great name");
                System.out.println("now choose your monsters in this list");
                System.out.println("");
                MonsterFactory.info();
                System.out.println("");
                player.setMonsters(MonsterFactory.createTeam());
                System.out.println("");
                System.out.println("Your team is ready, you have :");
                player.monsterInfo();
                System.out.println("");
                System.out.println("You are ready now go and travel far");
                gs = State.Move;
            break;
            case Menu :
            break;
            case Figth :
            break;
            case Move:
                
            break;
        }
    }
    
    
    private String scanName()
    {
        return "";
    }
    
}
