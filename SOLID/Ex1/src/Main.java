public class Main {
    public static void main(String[] args) {
        System.out.println("=== Student Onboarding ===");
        StudentRepository db = new FakeDb();
        validator vl = new NormalValidate() ;
        Parser ps = new NormalParsing() ;
        PrintRecord pr = new Printer() ;
        OnboardingService svc = new OnboardingService(db , ps , vl , pr);

        String raw = "name=Riya;email=riya@sst.edu;phone=9876543210;program=CSE";
        svc.registerFromRawInput(raw);

        System.out.println();
        System.out.println("-- DB DUMP --");
        System.out.print(TextTable.render3(db));
    }
}
