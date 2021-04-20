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
public class AttNormal extends Attack {
     private boolean enemi;
    public AttNormal(String named, int deg) {
        super(named, deg, new Type("neutre"));
        enemi = true;
    }
    
}
