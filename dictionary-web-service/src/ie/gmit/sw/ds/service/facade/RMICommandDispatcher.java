package ie.gmit.sw.ds.service.facade;

import ie.gmit.sw.ds.service.domain.DictionaryJob;
import ie.gmit.sw.ds.service.facade.commands.RMICommandFactory;
import ie.gmit.sw.ds.service.facade.commands.RMICommandTypes;

public class RMICommandDispatcher {

    private RMICommandFactory  commandFactory = RMICommandFactory.getInstance();

    private DictionaryJob job;


    public void execute(RMICommandTypes type){

        DictionaryCommand command = commandFactory.createRmiCommand(type);
        this.job.setJobType(type);

        this.job = command.execute(this.job);
    }

    public DictionaryJob getJob() {
        return job;
    }

    public void setJob(DictionaryJob job) {
        this.job = job;
    }
}
