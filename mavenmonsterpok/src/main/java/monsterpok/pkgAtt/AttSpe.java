/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monsterpok.pkgAtt;

/**
 *
 * @author Naillik
 */
public class AttSpe extends Attack {
    private boolean enemi;
    public AttSpe(String named, int deg, Type type) {
        super(named, deg, type);
        enemi = true;
    }
    
}
