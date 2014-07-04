package pl.allegro.itm.confitura;

public class Jar {

    private final boolean fresh;

    private final String flavor;
    
    private Jar(boolean fresh, String flavor) {
        this.fresh = fresh;
        this.flavor = flavor;
    }
    
    public static Jar fresh(String flavor) {
        return new Jar(true, flavor);
    }
    
    public static Jar stale(String flavor) {
        return new Jar(false, flavor);
    }

    public String flavor() {
        return flavor;
    }
    
    public boolean isFresh() {
        return fresh;
    }
    
}
