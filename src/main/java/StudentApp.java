import criteria.FilterQuery;
import criteria.Operator;
import dao.DBConfig;
import dao.DBStudent;
import dao.DBepartment_test;
import models.Student;
import models.department_test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;

public class StudentApp {

    public static void testCache() {
        try (Session session = DBConfig.SESSION_FACTORY.openSession()) {
            System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
            System.out.println(session.get(Student.class, 1));
            System.out.println("----------------------------------------------------------------------------------------");
            System.out.println(session.get(Student.class, 2));
            System.out.println("----------------------------------------------------------------------------------------");
            System.out.println(session.get(Student.class, 1));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void testCache1() {
        try (Session session = DBConfig.SESSION_FACTORY.openSession()) {
            System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
            System.out.println(session.get(Student.class, 1));
            System.out.println("----------------------------------------------------------------------------------------");
            System.out.println(session.get(Student.class, 2));
            System.out.println("----------------------------------------------------------------------------------------");
            System.out.println(session.get(Student.class, 1));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {

        DBStudent dbStudent = new DBStudent();

        //------------------invoke---------------------//
//        testCache();
//        testCache1();

        //------------------use the function get filter--------------------//
        List<FilterQuery> filterQueries = new ArrayList<>();
        filterQueries.add(new FilterQuery("name", "Omer Ahmed", Operator.EQ));
        for (Student student : dbStudent.getFilter(filterQueries)) {
            System.out.println(student);
        }

        //------------------print all data---------------------//
//        List<Student> studentList = dbStudent.get();
//        for (Student e : studentList) {
//            System.out.println(e.getName().toString());
//            System.out.println(e.getDepartmenTtest());
//        }

        //------------------print by id -----------------------//
//        System.out.println(dbStudent.get(1));

        //------------------insert----------------------------//
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

        //------------------update----------------------------//
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

        //------------------delete----------------------------//
//        dbStudent.delete(2);
//        System.out.println("Student deleted.");
    }
}
