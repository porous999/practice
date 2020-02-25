package Extra.Utils;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Logger;

public class JsonExample {
    
    private static final Logger jsonExampleLogger = Logger.getLogger(JsonExample.class.getSimpleName());

    private static void readJson(String jsonPath) {

        String logStr = "";

        File inJsonFile = new File(jsonPath);
        try (Scanner myScanner = new Scanner(inJsonFile);) {
            String apiResponseString = myScanner.nextLine();
            jsonExampleLogger.info(apiResponseString);
            JSONObject apiJson = null;

            apiJson = JSON.parseObject(apiResponseString);

            jsonExampleLogger.info(apiJson.toJSONString());
        } catch (IOException e) {
            jsonExampleLogger.severe("IO Excep - " + e);
        }
    }

    public static void main(String[] args) {
        JsonExample.readJson("/home/tanmays/temp/29023/dns_0.txt");
    }
}
