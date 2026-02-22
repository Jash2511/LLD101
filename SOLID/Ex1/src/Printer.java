public class Printer implements PrintRecord{

    @Override
    public void printdetails(StudentRecord student , StudentRepository db) {
        System.out.println("OK: created student " + student.id);
        System.out.println("Saved. Total students: " + db.count());
        System.out.println("CONFIRMATION:");
        System.out.println(student);
    }

}
