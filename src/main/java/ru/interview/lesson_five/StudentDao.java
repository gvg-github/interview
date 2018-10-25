package ru.interview.lesson_five;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * @author Valeriy Gyrievskikh
 * @since 25.10.2018
 */
public class StudentDao implements InterfaceStudentDao {

    private Session currentSession;
    private Transaction currentTransaction;

    public StudentDao() {
    }

    public Session openCurrentSession() {
        currentSession = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        return currentSession;
    }

    public Session openCurrentSessionwithTransaction() {
        currentSession = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    public void closeCurrentSession() {
        currentSession.close();
    }

    public void closeCurrentSessionwithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }

    public Session getCurrentSession() {
        return currentSession;
    }

    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }

    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }

    public void persist(Student entity) {
        openCurrentSessionwithTransaction().save(entity);
        closeCurrentSessionwithTransaction();
    }

    public void update(Student entity) {
        openCurrentSessionwithTransaction().update(entity);
        closeCurrentSessionwithTransaction();
    }

    public Student findById(int id) {
        Student student = openCurrentSession().get(Student.class, id);
        return student;
    }

    public void delete(Student entity) {
        openCurrentSessionwithTransaction().delete(entity);
        closeCurrentSessionwithTransaction();
    }

    @SuppressWarnings("unchecked")
    public List<Student> findAll() {
        List<Student> students = (List<Student>)
                openCurrentSession().createQuery("From Student").list();
        return students;
    }

    public void deleteAll() {
        List<Student> entityList = findAll();
        for (Student entity : entityList) {
            delete(entity);
        }
    }
}
