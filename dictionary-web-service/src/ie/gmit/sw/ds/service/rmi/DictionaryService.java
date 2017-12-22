package ie.gmit.sw.ds.service.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface DictionaryService extends Remote {

    RemoteWordEntity lookup(String word) throws RemoteException;
    void create(String word, String description) throws RemoteException;
    void delete(String word) throws RemoteException;
    void modify(String word, String description) throws RemoteException;
}
