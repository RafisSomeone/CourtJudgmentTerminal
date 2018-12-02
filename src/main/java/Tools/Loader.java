package Tools;

import Files.ItemInside.Files;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public abstract class Loader {
    private File catalog;
    protected List<Files> loadedFiles = new ArrayList<Files>();


    public void load(String path) throws FileNotFoundException {
        catalog = new File(path);
        String[] files = catalog.list();
        Gson gson = new Gson();

        for (String name: files) {


            String filePath = this.catalog.getPath() + "\\" +name;
           loadedFiles.add( gson.fromJson(new FileReader(filePath), Files.class));

            System.out.println(filePath);






        }

    }

}

