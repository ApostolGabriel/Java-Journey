package chapter1;

import java.util.HashMap;

/**
 * 1.5 Prefer dependency injection over hardwiring resources
 * <p>
 *     Static utility classes and singletons are inappropriate for classes whose behavior is parameterized
 *     by an underlying resource.
 * </p>
 * <p>
 *     The ability to support multiple instances of a class is required, each of which uses the resource
 *     desired by the client. A simple pattern that satisfies the behavior is to pass the resource into the constructor
 *     when creating a new instance.
 * </p>
 * <p>
 *     Mosaic create(Supplier<? extends Tile> tileFactory) { ... }  - Factory Method pattern to constrain factory type's parameter to be any subclass of Tile.
 * </p>
 * <p>
 *     Dependency injection greatly improves flexibility and testability, but can clutter up large projects, which typically contain thousands of dependencies.
 *     Clutter can be eliminated using frameworks like Dagger, Guice, or <b>Spring</b>.
 * </p>
 */
public class DependencyInjectionOverHardwire {
    public static void main(String[] args) {
        HashMap<String, String> wordDefinitions = new HashMap<>();
        wordDefinitions.put("dumb", "stupid");
        wordDefinitions.put("rich", "has money");
        Lexicon english = new Lexicon(wordDefinitions);
        SpellChecker spellChecker = new SpellChecker(english);
        System.out.println(spellChecker.isValid("dumb"));
    }
}
