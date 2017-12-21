package ie.gmit.sw.ds.service;

import ie.gmit.sw.ds.domain.WordEntity;
import ie.gmit.sw.ds.service.rmi.RemoteWordEntity;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.server.Unreferenced;

public class RemoteWordEntityImpl extends UnicastRemoteObject implements RemoteWordEntity, Unreferenced {

    private static final long serialVersionUID = 1L;
    private WordEntity word;


    public RemoteWordEntityImpl(WordEntity word) throws RemoteException {
        this.word =  word;
    }

    @Override
    public String getWord() throws RemoteException {
        return word.getWord();
    }

    @Override
    public String getDescription() throws RemoteException {
        return word.getDescription();
    }

    @Override
    public void unreferenced() {
        System.out.println( "RemoteMessageImpl: unreferenced() called.");
    }
}
