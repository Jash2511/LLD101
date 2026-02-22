import java.util.*;

public class OnboardingService {
    private final StudentRepository db;
    private final Parser ps ;
    private final validator vl ;
    private PrintRecord pr ;

    public OnboardingService(StudentRepository db , Parser ps , validator vl , PrintRecord pr) {
        this.db = db ;
        this.ps = ps ;
        this.vl = vl ;
        this.pr = pr ;
    }

    // Intentionally violates SRP: parses + validates + creates ID + saves + prints.
    public void registerFromRawInput(String raw) {
        System.out.println("INPUT: " + raw);

        Map<String,String> kv = new LinkedHashMap<>();

        // passover raw input to ps so it be parsed as we want .
        ps.parse(raw , kv) ;

        String name = kv.getOrDefault("name", "");
        String email = kv.getOrDefault("email", "");
        String phone = kv.getOrDefault("phone", "");
        String program = kv.getOrDefault("program", "");

        // validation inline, printing inline
        if(!vl.validate(name , email , phone ,program)) return  ;

        String id = IdUtil.nextStudentId(db.count());
        StudentRecord rec = new StudentRecord(id, name, email, phone, program);

        db.save(rec);
        pr.printdetails(rec , db);
    }
}
