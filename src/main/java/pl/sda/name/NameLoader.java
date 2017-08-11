package pl.sda.name;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by RENT on 2017-08-11.
 */
@Component
public class NameLoader {
    private ResourceLoader resourceLoader;
    private List<String> stringList;

    @Autowired
    public NameLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @PostConstruct
    public void loadFile() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:imiona.txt");
        Scanner scanner = new Scanner(resource.getFile());
        stringList = new ArrayList<>();
        while (scanner.hasNext()) {
            stringList.add(scanner.nextLine().trim());
        }
        scanner.close();
    }

    public List<String> getStringList() {
        return stringList;
    }


}
