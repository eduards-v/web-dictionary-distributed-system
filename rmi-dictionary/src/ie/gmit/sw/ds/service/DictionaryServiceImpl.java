package ie.gmit.sw.ds.service;

import ie.gmit.sw.ds.dao.DictionaryStorage;
import ie.gmit.sw.ds.service.rmi.DictionaryService;
import ie.gmit.sw.ds.service.rmi.RemoteWordEntity;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class DictionaryServiceImpl extends UnicastRemoteObject implements DictionaryService{

    private static final long serialVersionUID = 2L;

    public DictionaryServiceImpl() throws RemoteException {
    }

    @Override
    public RemoteWordEntity lookup(String word) throws RemoteException {
        DictionaryStorage storage = DictionaryStorage.getInstance();

        return new RemoteWordEntityImpl(storage.searchWord(word));
    }
}
