package Tools;

import Files.ItemInside.JudgeFile;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class DataBase {
    private File catalog;
    public List<JudgeFile> loadedFiles = new ArrayList<JudgeFile>();


    public void load(String path) throws FileNotFoundException {
        catalog = new File(path);
        String[] files = catalog.list();
        Gson gson = new Gson();

        for (String name : files) {


            String filePath = this.catalog.getPath() + "\\" + name;

                loadedFiles.add(gson.fromJson(new FileReader(filePath), JudgeFile.class));




            System.out.println(filePath);


        }

    }

    public List<JudgeFile> getBase(){
        return loadedFiles;


    }

}