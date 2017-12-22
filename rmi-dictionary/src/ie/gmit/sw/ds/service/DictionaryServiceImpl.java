package ie.gmit.sw.ds.service;

import ie.gmit.sw.ds.dao.DictionaryStorage;
import ie.gmit.sw.ds.service.rmi.DictionaryService;
import ie.gmit.sw.ds.service.rmi.RemoteWordEntity;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class DictionaryServiceImpl extends UnicastRemoteObject implements DictionaryService{

    private static final long serialVersionUID = 2L;
    private DictionaryStorage storage = DictionaryStorage.getInstance();

    public DictionaryServiceImpl() throws RemoteException {
    }

    @Override
    public RemoteWordEntity lookup(String word) throws RemoteException {
        return new RemoteWordEntityImpl(storage.searchWord(word));
    }

    @Override
    public void create(String word, String description) throws RemoteException {
        storage.createWord(word, description);
        System.out.println("new word created: " + word);
    }

    @Override
    public void delete(String word) throws RemoteException {
        storage.deleteWord(word);
    }

    @Override
    public void modify(String word, String description) throws RemoteException {
        storage.modifyWord(word, description);
    }
}
