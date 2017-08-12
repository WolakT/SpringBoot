package pl.sda.name;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by RENT on 2017-08-11.
 */

@Component
public class NameService {
    private NameLoader nameLoader;

    @Autowired
    public NameService(NameLoader nameLoader){
        this.nameLoader = nameLoader;
    }
    public List<String> getAll(){
        return nameLoader.getStringList();
    }

    public List<String> getFemale(){
        List<String> list = nameLoader.getStringList();
        return list.stream().filter(s ->
            s.substring(s.length()-1).equalsIgnoreCase("a"))
                .collect(Collectors.toList());

    }
    Predicate<String> isFemale= s-> s.substring(s.length()-1).equalsIgnoreCase("a");

    public List<String> getMale(){
        List<String> list = nameLoader.getStringList();
        return list.stream().filter(isFemale.negate())
                .collect(Collectors.toList());
    }

    public List<String> getNthLength(int length){
        List<String> list = nameLoader.getStringList();
        return list.stream().filter(s-> s.length()==length)
                .collect(Collectors.toList());
    }
    public List<String> getNamesContaining(String letters){
        List<String> list = nameLoader.getStringList();
        return list.stream().filter((s -> s.contains(letters))).collect(Collectors.toList());
    }

    public List<String> getNamesWithSubstring(String subString){
        List<String> list = nameLoader.getStringList();
        return list.stream().filter(s->s.contains(subString)).collect(Collectors.toList());
    }
}
