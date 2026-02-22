import java.util.Map;

public class NormalParsing implements Parser {

    @Override
    public void parse(String input , Map<String ,String > kv){

        String[] parts = input.split(";");
        for (String p : parts) {
            String[] t = p.split("=", 2);
            if (t.length == 2) kv.put(t[0].trim(), t[1].trim());

        }

    }
}
