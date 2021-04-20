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
public class Type {
        private enum enumType{
            feu,
            eau,
            nature,
            neutre
        }
    
        private enumType myTypeEn;
        public Type(String n){
            switch(n)
            {
                case "feu" :
                    myTypeEn = enumType.feu;
                    break;
                case "eau" :
                    myTypeEn= enumType.eau;
                    break;
                case "nature" :
                    myTypeEn= enumType.nature;
                    break;
                default:
                    myTypeEn= enumType.neutre;
                    break;
            }
            
        }
        public enumType getTypeEnum()
        {
            return this.myTypeEn;
        }
        public String getTypeStr(){
            switch(this.myTypeEn)
            {
                case feu :
                    return ("feu");
                case eau :
                    return ("eau");
                case nature :
                    return ("nature");
                case neutre :
                    return ("neutre");
            }
            return "invalide";
        }
        
        public static double compareType(Type attType, Type enemiType){
            //equal
            switch(attType.getTypeEnum())
            {
                case feu :
                    switch(enemiType.getTypeEnum())
                    {
                        case feu :
                           return 1;
                        case eau :
                            return 0.5;
                        case nature :
                            return 2;
                        default:
                            return 1;
                    }
                   
                case eau :
                    switch(enemiType.getTypeEnum())
                    {
                        case feu :
                           return 2;
                        case eau :
                            return 1;
                        case nature :
                            return 0.5;
                        default:
                            return 1;
                    }
                    
                case nature :
                    switch(enemiType.getTypeEnum())
                    {
                        case feu :
                           return 0.5;
                        case eau :
                            return 2;
                        case nature :
                            return 1;
                        default:
                            return 1;
                    }
                default :
                   return 1;
                    
                    
            }
            //return 0;
            
        }
}
