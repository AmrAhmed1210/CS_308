
import dao.DBStudent;
import java.util.List;
import dao.DBepartment_test;
import models.Student;
import java.util.Date;
import models.department_test;

public class StudentApp {
    public static void main(String[] args) {
        DBStudent dbStudent = new DBStudent();

        //------------------print all data---------------------//
        List<Student> studentList = dbStudent.get();
        for (Student e : studentList) {
            System.out.println(e.toString());
            System.out.println(e.getDepartmenTtest());
        }
//        //------------------print by id -----------------------//
//        System.out.println(dbStudent.get(1));
////        //------------------insert----------------------------//
//        Student student1 = new Student();
//        student1.setName("Omer Ahmed");
//        student1.setAge(20);
//        student1.setAddress("Cairo");
//        student1.setJoinedDate(new Date());
//        try {
//            int id = dbStudent.insert(student1);
//            System.out.println("inserted in ID = " + id);
//        } catch (Exception e) {
//            System.err.println(e.getMessage());
//        }

////        //------------------update----------------------------//
//        Student student2 = dbStudent.get(3);
//        if (student2 != null) {
//            student2.setName("Mustafa");
//            try {
//                dbStudent.update(student2);
//                System.out.println("updated.");
//            } catch (Exception e) {
//                System.err.println(e.getMessage());
//            }
//        }
//        //------------------delete----------------------------//
//        dbStudent.delete(2);
//        System.out.println("Student deleted.");
    }
}
