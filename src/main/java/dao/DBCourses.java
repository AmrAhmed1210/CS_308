package dao;

import models.courses;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class DBCourses {
    public List<courses> get(){
        try(Session session=DBConfig.SESSION_FACTORY.openSession()){
            return session.createQuery("from courses",courses.class).list();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }
    public courses get(Integer id) {

        try (Session session = DBConfig.SESSION_FACTORY.openSession()) {

            return session.get(courses.class, id);

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

        return null;
    }
    public Integer insert(courses courses) {

        Transaction transaction = null;
        int id = 0;

        try (Session session = DBConfig.SESSION_FACTORY.openSession()) {

            transaction = session.beginTransaction();

            id = (Integer) session.save(courses);

            transaction.commit();

        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println(ex.getMessage());
        }

        return id;
    }
    public void update(courses courses) {

        Transaction transaction = null;

        try (Session session = DBConfig.SESSION_FACTORY.openSession()) {

            transaction = session.beginTransaction();

            session.update(courses);

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

            courses courses = session.get(courses.class, id);
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
