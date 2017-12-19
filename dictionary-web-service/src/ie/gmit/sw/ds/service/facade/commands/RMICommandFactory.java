package ie.gmit.sw.ds.service.facade.commands;

import ie.gmit.sw.ds.service.facade.DictionaryCommand;

public class RMICommandFactory {

    private static RMICommandFactory instance;

    private RMICommandFactory() {
    }

    public static RMICommandFactory getInstance() {
        // Lazy instantiation
        if(instance == null){
            instance = new RMICommandFactory();
        }
        return instance;
    }


    public DictionaryCommand createRmiCommand(RMICommandTypes type){

        if(type == RMICommandTypes.QUEUE_REQUEST_CMD){
            return new SearchDictionaryCommand();
        } else {
            return new RetrieveResultsCommand();
        }
    }
}
