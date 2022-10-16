package com.example.spring.Toolkit.JSONObject;

import java.util.HashMap;
import java.util.Map;


import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

/*
https://www.baeldung.com/java-org-json

*/
public class JsonDemo {
    public static void main(String[] args) {
        JSONObject jo = new JSONObject();
        jo.put("name", "jon doe");
        jo.put("age", "22");
        jo.put("city", "chicago");
        System.out.println(jo);
    }

    @Test
    public void Creating_JSON_From_Map() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "jon doe");
        map.put("age", "22");
        map.put("city", "chicago");
        JSONObject jo = new JSONObject(map);
        System.out.println(jo);
    }

    @Test
    public void Creating_JSONObject_From_JSONString() {
        JSONObject jo = new JSONObject(
                "{\"city\":\"San Jose\",\"name\":\"Jim Zhang\",\"age\":\"29\"}"
        );
        System.out.println(jo);
    }

    @Test
    public void Serialize_Java_Object_to_JSON() {
        DemoBean demo = new DemoBean();
        demo.setId(1);
        demo.setName("lorem ipsum");
        demo.setActive(true);

        JSONObject jo = new JSONObject(demo);
        System.out.println(jo);
    }

    @Test
    void Creating_JSONArray() {
        JSONArray ja = new JSONArray();
        ja.put(Boolean.TRUE);
        ja.put("lorem ipsum");

        JSONObject jo = new JSONObject();
        jo.put("name", "jon doe");
        jo.put("age", "22");
        jo.put("city", "chicago");

        ja.put(jo);
    }
}
