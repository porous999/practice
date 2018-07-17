package Extra.Utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class JsonExample {

    private static void readJson() throws IOException, org.json.simple.parser.ParseException {

        File inJsonFile = new File("/home/tanmays/temp/app-list-fun/apiresponse.json");
        //File inJsonFile = new File("/home/tanmays/temp/app-list-fun/apiresponse-new.json");
        Scanner myScanner = new Scanner(inJsonFile);
        String apiResponseString = myScanner.nextLine();
        System.out.println(apiResponseString);
        JSONObject apiJson = (JSONObject) new JSONParser().parse(apiResponseString);

        JSONArray appsArray = (JSONArray) apiJson.get("app-by-bytes-series");
        Set<String> appSet = new TreeSet<String>();
        JSONObject tempJsonObject;
        JSONArray tempAppListArray;
        for (Object eachTSObj : appsArray) {
            tempJsonObject = (JSONObject) eachTSObj;
            System.out.println("Time: " + tempJsonObject.get("time"));
            tempAppListArray = (JSONArray) tempJsonObject.get("app-list");
            for (Object eachApp : tempAppListArray) {
                tempJsonObject = (JSONObject) eachApp;
                appSet.add((String) tempJsonObject.get("app"));
                System.out.println(" " + tempJsonObject.get("app") + " " + tempJsonObject.get("rt"));

            }
        }
        System.out.println(appSet.size() + " = " + appSet);
    }
}
