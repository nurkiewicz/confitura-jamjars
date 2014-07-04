package pl.allegro.itm.confitura

import spock.lang.Specification

class JamJarsTest extends Specification {

    def JamJars jamJars = new JamJars()
    
    def "should not pack stale jams into boxes"() {
        given:
        Shelf shelf = new Shelf(Jar.stale(""))
        
        when:
        def boxes = jamJars.giveMeMyJars([shelf], 1)
        
        then:
        boxes.isEmpty()
    }
    
    def "should limit amount of jars per box"() {
        given:
        Shelf shelf = new Shelf(Jar.fresh("A"), Jar.fresh("B"), Jar.fresh("C"))
        
        when:
        def boxes = jamJars.giveMeMyJars([shelf], 2)
        
        then:
        boxes.size() == 2
        boxes*.size() == [2, 1]
    }
    
    def "should sort jars by flavor name in reverse order"() {
        given:
        Shelf shelf = new Shelf(Jar.fresh("A"), Jar.fresh("B"), Jar.fresh("C"))

        when:
        List<JarBox> boxes = jamJars.giveMeMyJars([shelf], 3)

        then:
        boxes[0]*.flavor() == ["C", "B", "A"]
    }
}

