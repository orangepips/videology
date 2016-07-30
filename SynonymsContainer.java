import java.util.List;

/**
 * Aggregation of all known synonyms for a given word broken down by the part of speech and affinity.
 */
interface SynonymsContainer {
    /**
     * How closely related a given word is to the original word used.
     */
    enum Affinity {
        STRONG,
        MEDIUM,
        WEAK
    }

    enum PartOfSpeech {
        ADJECTIVE,
        ADVERB,
        NOUN,
        VERB
    }

    interface Synonym {
        Affinity getAffinity();

        String getWord();
    }

    interface Context {
        /**
         * Phrase to contextualize the usage of the synonyms
         * @return phrase to contextualize usage
         */
        String getDescription();

        PartOfSpeech getPartOfSpeech();

        /**
         * Synonyms in order of affinity from strong to weak
         * @return synonyms in order of affinity
         */
        List<Synonym> getSynonyms();
    }

    /**
     * Get the word synonyms were put into the container for
     * @return the word used to populate this container
     */
    String getWord();

    /**
     * Gets all contexts in order of most to least common usage
     * @return all contexts in order of most to least common usage
     */
    List<Context> getContexts();

    /**
     * Get all contexts in order of most to least common usage for the given part of speech
     * @param partOfSpeech part of speech to get synonyms for
     * @return contexts for all synonynms for a given part of speech 
     */
    Context getContexts(PartOfSpeech partOfSpeech);
}
