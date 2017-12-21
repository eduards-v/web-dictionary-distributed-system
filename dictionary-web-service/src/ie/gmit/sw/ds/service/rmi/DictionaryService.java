package ie.gmit.sw.ds.service.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface DictionaryService extends Remote {

    RemoteWordEntity lookup(String word) throws RemoteException;
}
