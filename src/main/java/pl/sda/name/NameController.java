package pl.sda.name;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.hello.Greeting;

import java.util.List;

/**
 * Created by RENT on 2017-08-11.
 */

@RestController
public class NameController {


    @Autowired
    private NameService nameService;

    @RequestMapping("names/all")
    public List<String> getStringList() {return nameService.getAll();}

    @RequestMapping("names/female")
    public List<String> getFemale(){return nameService.getFemale();}

    @RequestMapping("names/male")
    public List<String> getMale() {return  nameService.getMale();}

    @RequestMapping("/names")
    public List<String> getNthName(@RequestParam(value = "length",defaultValue = "5") int length){
        return nameService.getNthLength(length);
    }

    @RequestMapping("/names/content")
    public List<String> getNamesContaining(@RequestParam(value="contains",defaultValue = "a")String contains){
        return nameService.getNamesContaining(contains);
    }
    @RequestMapping("/names/{subString}")
    public List<String> getNamesWithSubstring(@PathVariable("subString") String subString){
        return nameService.getNamesWithSubstring(subString);
    }
//    @RequestMapping("/greeting")
//    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
//        return new Greeting(counter.incrementAndGet(),
//                String.format(template, name));
//    }


}
