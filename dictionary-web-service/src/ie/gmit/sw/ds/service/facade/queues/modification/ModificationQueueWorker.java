package ie.gmit.sw.ds.service.facade.queues.modification;

import ie.gmit.sw.ds.service.domain.DictionaryJob;
import ie.gmit.sw.ds.service.rmi.DictionaryService;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ModificationQueueWorker implements Runnable{

    private DictionaryJob job;
    private DictionaryService rmiDictionary;

    public ModificationQueueWorker(DictionaryJob job) {
        this.job = job;
        // setting up RMI communication interface
        try {
            this.rmiDictionary = (DictionaryService) Naming.lookup("rmi://127.0.0.1:1099/dictionaryService");
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        // RMI request to create new word.
        try {
            rmiDictionary.modify(job.getWord().getWord(), job.getWord().getDescription());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
