package ie.gmit.sw.ds.dao;

import ie.gmit.sw.ds.domain.WordEntity;

import java.util.concurrent.ConcurrentHashMap;

// Singleton
public class DictionaryStorage {

    private static DictionaryStorage instance;

    // Concurrent Hashmap is thread safe collection
    private static final ConcurrentHashMap<String, WordEntity> dictionary= new ConcurrentHashMap<>();

    // Initialize hashmap from physical storage data
    private DictionaryStorage() {
    }

    public static DictionaryStorage getInstance() {
        if(instance == null){
            instance = new DictionaryStorage();

            dictionary.put("remote", new WordEntity("remote", "Denoting a device which can only be accessed by means of a network."));
            dictionary.put("facade", new WordEntity("facade", "Facade pattern hides the complexities of the system and provides an interface to the client using which the client can access the system."));
            dictionary.put("singleton", new WordEntity("singleton","An object that encapsulates own construction to ensure that only one of it's kind is created throughout application lifecycle."));
            dictionary.put("factory", new WordEntity("factory", "Object that encapsulated creation logic of an objects of one or more family types."));
            dictionary.put("command", new WordEntity("command","Encapsulates a request as an object, thereby letting you to parameterize clients with different requests, queue, or log requests, and support undoable operations."));

        }
        return instance;
    }

    public WordEntity searchWord(String word){

        if(dictionary.containsKey(word)){
            return dictionary.get(word);
        }
        // return if dictionary does not contain word
        return new WordEntity(word, "Word not found");
    }

    public void createWord(String word, String description){
        dictionary.put(word, new WordEntity(word, description));
    }

    public void deleteWord(String word){
        dictionary.remove(word);
    }

    public void modifyWord(String word, String description){
        dictionary.replace(word , new WordEntity(word, description));
    }

}
