package dasturlash.uz;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        saveData();
        getStudentCourseList();
    }

    public static void getStudentCourseList() {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();

        Query<Object[]> query = session.createQuery("select sc.id, sc.score, sc.joinedDate, " +
                " s.id, s.name, s.surname, " +
                " c.id, c.title, c.price " +
                " from StudentCourseEntity sc " +
                " inner join sc.student s " +
                " inner join sc.course c ");
        List<Object[]> list = query.list();

        for (Object[] obj : list) {
            Integer id = (Integer) obj[0];
            Double score = (Double) obj[1];
            LocalDateTime joinedDate = (LocalDateTime) obj[2];

            Integer studentId = (Integer) obj[3];
            String studentName = (String) obj[4];
            String studentSurname = (String) obj[5];

            Integer courseId = (Integer) obj[6];
            String title = (String) obj[7];
            Double price = (Double) obj[8];

            System.out.println(id + " " + score + " " + joinedDate + " " + studentId + " " + studentName + " " + studentSurname + " " + courseId + " " + title + " " + price);
        }

        factory.close();
        session.close();
    }


    public static void saveData() {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();

        // students
        StudentEntity student1 = new StudentEntity();
        student1.setName("Ali");
        student1.setSurname("Aliyev");
        session.save(student1);

        StudentEntity student2 = new StudentEntity();
        student2.setName("Valish");
        student2.setSurname("Valiyev");
        session.save(student2);

        StudentEntity student3 = new StudentEntity();
        student3.setName("Toshmat");
        student3.setSurname("Toshmatov");
        session.save(student3);

        // course
        CourseEntity course1 = new CourseEntity();
        course1.setTitle("Java");
        course1.setPrice(25.0);
        session.save(course1);

        CourseEntity course2 = new CourseEntity();
        course2.setTitle("English");
        course2.setPrice(15.0);
        session.save(course2);

        // student course
        StudentCourseEntity sc1 = new StudentCourseEntity();
        sc1.setStudent(student1);
        sc1.setCourse(course1);
        sc1.setScore(5.0);
        sc1.setJoinedDate(LocalDateTime.now());
        session.save(sc1);

        StudentCourseEntity sc2 = new StudentCourseEntity();
        sc2.setStudent(student1);
        sc2.setCourse(course2);
        sc2.setScore(4.0);
        sc2.setJoinedDate(LocalDateTime.now());
        session.save(sc2);

        StudentCourseEntity sc3 = new StudentCourseEntity();
        sc3.setStudent(student2);
        sc3.setCourse(course1);
        sc3.setScore(4.5);
        sc3.setJoinedDate(LocalDateTime.now());
        session.save(sc3);

        StudentCourseEntity sc4 = new StudentCourseEntity();
        sc4.setStudent(student3);
        sc4.setCourse(course2);
        sc4.setScore(4.1);
        sc4.setJoinedDate(LocalDateTime.now());
        session.save(sc4);

        t.commit();

        factory.close();
        session.close();
    }
}