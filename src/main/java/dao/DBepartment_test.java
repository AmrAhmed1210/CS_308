package dao;

import models.department_test;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class DBepartment_test {
    public List<department_test> get(){
        try(Session session=DBConfig.SESSION_FACTORY.openSession()){
            return session.createQuery("from department_test", department_test.class).list();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }
    public department_test get(Integer id) {

        try (Session session = DBConfig.SESSION_FACTORY.openSession()) {

            return session.get(department_test.class, id);

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

        return null;
    }
    public Integer insert(department_test departmenttest) {

        Transaction transaction = null;
        int id = 0;

        try (Session session = DBConfig.SESSION_FACTORY.openSession()) {

            transaction = session.beginTransaction();

            id = (Integer) session.save(departmenttest);

            transaction.commit();

        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println(ex.getMessage());
        }

        return id;
    }
    public void update(department_test departmenttest) {

        Transaction transaction = null;

        try (Session session = DBConfig.SESSION_FACTORY.openSession()) {

            transaction = session.beginTransaction();

            session.update(departmenttest);

            transaction.commit();

        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println(ex.getMessage());
        }
    }
    public void delete(Integer id) {
        Transaction transaction = null;

        try (Session session = DBConfig.SESSION_FACTORY.openSession()) {

            transaction = session.beginTransaction();

            department_test courses = session.get(department_test.class, id);
            if (courses != null) {
                session.delete(courses);
            } else {
                System.out.println("Student not found with ID: " + id);
            }

            transaction.commit();

        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println(ex.getMessage());
        }
    }

}
