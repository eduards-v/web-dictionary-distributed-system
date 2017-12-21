package ie.gmit.sw.ds;

import ie.gmit.sw.ds.service.DictionaryServiceImpl;
import ie.gmit.sw.ds.service.rmi.DictionaryService;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Runner {
    public static void main(String[] args) throws RemoteException, MalformedURLException {

        LocateRegistry.createRegistry(1099);
        DictionaryService dictionaryService = new DictionaryServiceImpl();

        Naming.rebind("dictionaryService", dictionaryService);

        System.out.println("Server ready.");

    }
}
