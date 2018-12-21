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
        boolean isThereJson=false;

        for (String name : files) {

            if(!name.contains(".json")) continue;
            isThereJson=true;
            String filePath = this.catalog.getPath() + "/" + name;

                loadedFiles.add(gson.fromJson(new FileReader(filePath), JudgeFile.class));




            System.out.println(name);


        }
        if(!isThereJson)throw new FileNotFoundException();
    }

    public List<JudgeFile> getBase(){
        return loadedFiles;


    }
    public void addToBase(JudgeFile judgeFile)
    {
        loadedFiles.add(judgeFile);
    }

}