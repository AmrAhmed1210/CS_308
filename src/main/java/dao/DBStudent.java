package dao;

import criteria.FilterQuery;
import criteria.Operator;
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

    public List<Student> get() {
        try (Session session = DBConfig.SESSION_FACTORY.openSession()) {
            return session.createQuery("from Student", Student.class).list();
        } catch (Exception ex) {
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

    public List<Student> getFilter(List<FilterQuery> filterQueries) {
        try (Session session = DBConfig.SESSION_FACTORY.openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Student> cr = cb.createQuery(Student.class);
            Root<Student> root = cr.from(Student.class);

            List<Predicate> predicates = new ArrayList<>();

            for (FilterQuery filterQuery : filterQueries) {
                switch (filterQuery.getOp()) {
                    case EQ:
                        predicates.add(cb.equal(
                                root.get(filterQuery.getAttributeName()),
                                filterQuery.getAttributeValue()
                        ));
                        break;
                    case GT:
                        if (filterQuery.getAttributeValue() instanceof Number) {
                            predicates.add(cb.gt(
                                    root.get(filterQuery.getAttributeName()),
                                    ((Number) filterQuery.getAttributeValue()).intValue()
                            ));
                        }
                        break;
                    case LT:
                        predicates.add(cb.lt(
                                root.get(filterQuery.getAttributeName()),
                                ((Number) filterQuery.getAttributeValue()).intValue()
                        ));
                        break;
                    case LIKE:
                        predicates.add(cb.like(
                                root.get(filterQuery.getAttributeName()),
                                "%" + filterQuery.getAttributeValue() + "%"
                        ));
                        break;
                    // Add other operators as needed
                }
            }

            if (!predicates.isEmpty()) {
                cr.select(root).where(cb.and(predicates.toArray(new Predicate[0])));
            } else {
                cr.select(root); // Return all if no filters
            }

            Query<Student> query = session.createQuery(cr);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }
    }
}
