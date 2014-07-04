package pl.allegro.itm.confitura;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class JarBox implements Iterable<Jar> {

    private final List<Jar> jars = new ArrayList<>();
    
    public JarBox() {
    }
    
    public JarBox(Collection<Jar> jars) {
        this.jars.addAll(jars);
    }
    
    public JarBox add(Jar jar) {
        this.jars.add(jar);
        return this;
    }
    
    public int size() {
        return jars.size();
    }
    
    @Override
    public Iterator<Jar> iterator() {
        return Collections.unmodifiableCollection(jars).iterator();
    }
}
