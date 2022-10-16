package com.example.spring.Toolkit.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.json.Cookie;
import org.json.HTTP;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
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
    /*
    [
        true,
        "lorem ipsum",
        {
            "city": "chicago",
            "name": "jon doe",
            "age": "22"
        }
    ]
    */


    @Test
    void Creating_JSONArray_Directly_From_JSONString() {
        JSONArray ja = new JSONArray("[true, \"lorem ipsum\", 215]");
        System.out.println(ja);
    }


    @Test
    void Creating_JSONArray_Directly_From_a_Collection() {
        List<String> list = new ArrayList<>();
        list.add("California");
        list.add("Texas");
        list.add("Hawaii");
        list.add("Alaska");

        JSONArray ja = new JSONArray(list);
        // ["California","Texas","Hawaii","Alaska"]
    }


    @Test
    void JSONTokener() {
        JSONTokener jt = new JSONTokener("lorem");

        while(jt.more()) {
            System.out.println(String.valueOf(jt.next()));
        }
    }


    @Test
    void Converting_a_Cookie_String_into_a_JSONObject() {
        String cookie = "username=John Doe; expires=Thu, 18 Dec 2013 12:00:00 UTC; path=/";
        JSONObject cookieJO = Cookie.toJSONObject(cookie);
        System.out.println(cookieJO);
    }


    @Test
    void Converting_a_JSONObject_into_Cookie_String() {
        String cookie = "username=John Doe; expires=Thu, 18 Dec 2013 12:00:00 UTC; path=/";
        JSONObject cookieJO = Cookie.toJSONObject(cookie);
        String cookieStr = Cookie.toString(cookieJO);
        System.out.println(cookieStr);
    }


    @Test
    void Converting_JSONObject_to_HTTP_Header() {
        JSONObject jo = new JSONObject();
        jo.put("Method", "POST");
        jo.put("Request-URI", "https://www.example.com/");
        jo.put("HTTP-Version", "HTTP/1.1");
        String httpStr = HTTP.toString(jo);
        System.out.println(httpStr);
    }

    @Test
    void Converting_HTTP_Header_String_Back_to_JSONObject() {
        JSONObject obj = HTTP.toJSONObject("POST \"http://www.example.com/\" HTTP/1.1");
        System.out.println(obj);
    }
}

