package src.Extra.Utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

public class ReadAllSparkOut {

    @SuppressWarnings("I know them all")
    public static void getAllJsonTogether() throws IOException {

        File inputMessageDir = new File("/home/tanmays/temp/15116/sparkout/allmessages");
        File outJsonFile = new File("/home/tanmays/temp/15116/allmessages.json");
        FileWriter outFileWriter = new FileWriter(outJsonFile);
        FileReader myFileReader;
        BufferedReader myBufferedReader;
        JSONObject myJsonObject;
        int filecount = 1;
        int allFileCount = inputMessageDir.listFiles().length;
        System.out.println("File count: " + allFileCount);
        for (File eachFile : inputMessageDir.listFiles()) {
            int msgcount = 1;
            myFileReader = new FileReader(eachFile);
            myBufferedReader = new BufferedReader(myFileReader);
            //System.out.println("Reading file num " + filecount++ + " : " + eachFile);
            String eachline = myBufferedReader.readLine();
            while (null != eachline) {
                try {
                    myJsonObject = (JSONObject) new JSONParser().parse(eachline);
                    if (myJsonObject.containsKey("Type")) {
                        long i = (long) myJsonObject.get("Type");
                        if (i == 1L || i == 2L || i == 8L || i == 13L || i == 14L || i == 16L) {
                            //System.out.println(myJsonObject);
                            System.out.println("Writing for file " + filecount + "/" + allFileCount + " message #" + msgcount++);
                            outFileWriter.write(myJsonObject.toString() + "\n");
                        }
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                eachline = myBufferedReader.readLine();
            }
            filecount++;
        }
        outFileWriter.close();
    }

    public static void main(String[] args) throws IOException, ParseException {
        // TODO Auto-generated method stub

        getAllJsonTogether();
    }
}
