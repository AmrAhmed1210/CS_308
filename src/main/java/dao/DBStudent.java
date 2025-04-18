package dao;

import models.Student;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class DBStudent {
    public List<Student> get(){
        try(Session session=DBConfig.SESSION_FACTORY.openSession()){
            return session.createQuery("from Student",Student.class).list();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }
    public Student get(Integer id) {

        try (Session session = DBConfig.SESSION_FACTORY.openSession()) {

            return session.get(Student.class, id);

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

        return null;
    }
    public Integer insert(Student student) {

        Transaction transaction = null;
        int id = 0;

        try (Session session = DBConfig.SESSION_FACTORY.openSession()) {

            transaction = session.beginTransaction();

            id = (Integer) session.save(student);

            transaction.commit();

        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println(ex.getMessage());
        }

        return id;
    }
    public void update(Student student) {

        Transaction transaction = null;

        try (Session session = DBConfig.SESSION_FACTORY.openSession()) {

            transaction = session.beginTransaction();

            session.update(student);

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

            Student student = session.get(Student.class, id);
            if (student != null) {
                session.delete(student);
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
