package org.example;

import java.io.FileWriter;
import java.io.IOException;

public class WriteInJson {
    public void writeInJson(String json){
       String jsonVar=json;
       String file="journal.json";
        try {
            FileWriter fileWriter=new FileWriter(file);
            fileWriter.write(json);
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
