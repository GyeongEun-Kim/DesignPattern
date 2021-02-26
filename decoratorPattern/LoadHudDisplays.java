package decoratorPattern;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class LoadHudDisplays implements LoadDisplayInterface {
    String fileName;

    LoadHudDisplays(String filename) {
        fileName = filename;
    }

    public ArrayList<String> load() {
        try {
            ArrayList<String> list = new ArrayList<>();
            BufferedReader r = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
            String s = r.readLine();
            while (s != null) {
                list.add(s);
                s = r.readLine();
            }
            return list;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}