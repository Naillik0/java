
package monsterpok.pkgAtt;


public abstract class Attack {

    private String Name;
    private int Degat;
    private Type myType;
    private boolean enemi;
    
    
    public Attack(String named, int deg, Type type){
        this.Name = named;
        this.Degat = deg;
        this.myType = type;
    }

    public Type getType()
    {
        return this.myType;
    }
    public int getDegat()
    {
        return this.Degat;
    }

    public String getName() {
        return this.Name;
    }
    
    public boolean getEnemi() {
        return this.enemi;
    }
}
