package com.example.demo.util;

import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;


public abstract class JSONUtilis {
    private JSONUtilis(){
    }

    public static JSONArray read(String fileName, String key) {

        String jsonString = null;
        try {
            jsonString = FileUtils.readFileToString(new File(fileName), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        JSONObject jsonObject = new JSONObject(jsonString);

        return jsonObject.getJSONArray(key);
    }

    public static ArrayList<String> parse(JSONArray jsonArray) {

        ArrayList<String> arrayList = new ArrayList<>();
        for(int i = 0; i<jsonArray.length(); i++) {
            arrayList.add(jsonArray.optString(i));
        }

        return arrayList;
    }

}
