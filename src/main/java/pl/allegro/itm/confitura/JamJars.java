package pl.allegro.itm.confitura;

import java.util.List;
import java.util.stream.*;
import java.util.*;
import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;
import com.google.common.collect.*;

public class JamJars {

    public List<JarBox> giveMeMyJars(List<Shelf> shelves, int jarsInBox) {
        List<Jar> jars = Lists.newArrayList(shelves)
            .stream()
            .flatMap(s -> Lists.newArrayList(s).stream())
            .filter(Jar::isFresh)
            .sorted(comparing(Jar::flavor).reversed())
            .collect(toList());
            
        return Lists.partition(jars, jarsInBox)
            .stream()
            .map(JarBox::new)
            .collect(toList());
            
    }

}
