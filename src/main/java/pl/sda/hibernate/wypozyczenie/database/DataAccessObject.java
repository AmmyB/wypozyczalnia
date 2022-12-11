package pl.sda.hibernate.wypozyczenie.database;

import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DataAccessObject<T> {

    public void insert(T obiektDoWstawieniaDoBazy) {
        try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            session.persist(obiektDoWstawieniaDoBazy); // SAVE

            transaction.commit();
        } catch (Exception e) {
            System.err.println("Blad " + e);
        }

    }

    public List<T> findAll(Class<T> tClass) {
        List<T> list = new ArrayList<>();
        try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()) {
            TypedQuery<T> zapytanie = session.createQuery("FROM " + tClass.getName(), tClass);
            list.addAll(zapytanie.getResultList());
        } catch (Exception e) {
            System.err.println("Blad " + e);
        }
        return list;
    }

    public Optional<T> find(Class<T> tClass, Long id) {
        try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()) {
        T encja = session.get(tClass, id);
        return Optional.ofNullable(encja);
        } catch (Exception ioe) {
            System.err.println("Blad " + ioe);
        }
    return Optional.empty();
    }



    public boolean delete(Class<T> tClass, Long id) {
        try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            T encja = session.get(tClass, id);
            if (encja == null) {
                return false;
            }
            session.remove(encja);
            transaction.commit();
            return true;
        } catch (Exception e) {
            System.err.println("Blad " + e);
        }
        return false;
    }



    public void update(Class<T> tClass, Integer id, T obiektDoWstawieniaDoBazy){
        try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();

            T encja = session.get(tClass, id);
            if (encja == null) {
                System.err.println(tClass.getName() + " o podanym id nie istnieje");
                return;

            }
            session.merge(obiektDoWstawieniaDoBazy);
            transaction.commit();
        } catch (Exception e) {
            System.err.println("Blad " + e);
        }
    }
    public boolean exists(Class<T> tClass, Long id) {
        try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()) {
            T encja = session.get(tClass, id);
            if (encja == null) {
                return false;
            }
        } catch (Exception e) {
            System.err.println("Błąd: " + e);
        }
        return true;
    }
}
