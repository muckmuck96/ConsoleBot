import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        FileParser fp = new FileParser("C:\\Users\\TEMP\\IdeaProjects\\Test2\\storage.test");
        while((line = br.readLine()) != null){
            String pipetype = fp.contains(line, false, "greeting");
            String pipeline = (String)fp.get("pipelines:" + pipetype);
            if(pipeline == null){
                System.out.println("Das habe ich nicht verstanden!");
                continue;
            }
            String[] p = pipeline.split("-");
            String[] s = p[0].split(",");
            for(int i = 0; i < s.length; i++){
                if(line.equalsIgnoreCase(s[i])){
                    String[] q = p[1].split(",");
                    System.out.println(q[ThreadLocalRandom.current().nextInt(0, q.length)]);
                }
            }
        }
    }
}
