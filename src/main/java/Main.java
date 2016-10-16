import entity.Student;
import entity.StudentResult;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myManager");
        EntityManager em = emf.createEntityManager();

        EntityTransaction et = em.getTransaction();
        try {
            et.begin();

            Student student = em.find(Student.class, 1);
            student.setFirstName("Максим");
            em.merge(student);
            student = em.find(Student.class, 1);
            student.print();

            student = em.find(Student.class, 1);
            student.setFirstName("Иван");
            em.merge(student);
            student = em.find(Student.class, 1);
            student.print();

            Set<StudentResult> studentResults = student.getStudentResults();
            studentResults.forEach(StudentResult::print);

            student = new Student();
            student.setFirstName("Петя");
            student.setLastName("Петров");
            Calendar birthDate = Calendar.getInstance();
            birthDate.set(2010, Calendar.APRIL, 20);
            student.setBirthDate(birthDate);
            student.setSex(true);
            student.setHostelLive(false);
            em.persist(student);

            List<Student> studentList = em.createQuery("SELECT c FROM Student c", Student.class).getResultList();
            studentList.forEach(Student::print);
            et.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }

    }
}
