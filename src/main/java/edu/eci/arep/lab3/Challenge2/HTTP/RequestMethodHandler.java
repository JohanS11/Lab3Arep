package edu.eci.arep.lab3.Challenge2.HTTP;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class RequestMethodHandler {

    private static Map<String, BiFunction<HandleRequest,HandleResponse,String>> ep = new HashMap<>();

    public static void get(String path, BiFunction<HandleRequest, HandleResponse,String> f){
        ep.put("GET"+path,f);
        System.out.println("asdsadadasdsa");
        System.out.println("GET"+path);
    }

    public static void post(String path, BiFunction<HandleRequest,HandleResponse,String> f){
        ep.put("POST"+path,f);}

    public static HandleResponse exec(HandleRequest request){
        String k = request.getMethod()+request.getPath();
        System.out.println("KKKKKKKKKKK"+k);
        System.out.println("Hello worll------------");
        if (ep.containsKey(k)){
            HandleResponse response = new HandleResponse();
            response.setBody(ep.get(k).apply(request,response));
            return response;
        }
        else{
            //System.out.println(k);
            return null;
        }
    }
}
