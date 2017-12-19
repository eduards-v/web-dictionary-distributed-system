package ie.gmit.sw.ds.service.facade;

import ie.gmit.sw.ds.service.domain.DictionaryJob;

@FunctionalInterface
public interface DictionaryCommand {

    DictionaryJob execute(DictionaryJob job);
}
