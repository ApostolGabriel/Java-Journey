package chapter1;

import java.util.Map;

public class Lexicon {
    private final Map<String, String> wordDefinitions;

    public Lexicon(Map<String, String> wordDefinitions) {
        this.wordDefinitions = wordDefinitions;
    }

    public Map<String, String> getWordDefinitions() {
        return wordDefinitions;
    }
}
