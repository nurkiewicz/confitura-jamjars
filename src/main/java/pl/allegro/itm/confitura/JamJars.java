package pl.allegro.itm.confitura;

import java.util.List;

public class JamJars {

    public List<JarBox> giveMeMyJars(List<Shelf> shelves, int jarsInBox) {
        List<Jar> jars = Lists.newArrayList(shelves)
            .stream()
            .flatMap(s -> Lists.newArrayList(s).stream())
            .filter(Jar::isFresh)
            .sorted(comparing(Jar::flavour).reversed())
            .collect(toList());
            
        return Lists.partition(jars, jarsInBox)
            .stream()
            .map(JarBox::new)
            .collect(toList());
            
    }

}
