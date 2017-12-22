package ie.gmit.sw.ds.service.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteWordEntity extends Remote{

    String getWord() throws RemoteException;
    String getDescription() throws RemoteException;
    void setWord(String word) throws RemoteException;
    void setDescription(String description) throws RemoteException;
}
