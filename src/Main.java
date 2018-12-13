import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        FileParser fp = new FileParser("C:\\Users\\TEMP\\IdeaProjects\\Test2\\storage.test");
        while((line = br.readLine()) != null){
            List<String> arg = new ArrayList<>();
            if(line.contains(" ")){
                arg = Arrays.asList(line.split(" "));
            }
            if(line.startsWith("read")){
                String key = line.substring(5);
                if(arg.get(1).equals("keys")){
                    key = line.substring(10);
                    System.out.println(fp.getKeys(key).toString());
                } else {
                    System.out.println(fp.get(key));
                }
            }
            String pipeline = (String)fp.get("pipelines:greeting");
            String[] p = pipeline.split("-");
            String[] s = p[0].split(",");
            for(int i = 0; i < s.length; i++){
                if(line.equalsIgnoreCase(s[i])){
                    System.out.println(p[1]);
                }
            }
        }
    }
}
