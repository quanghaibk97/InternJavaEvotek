package evotek.edu;

import evotek.edu.model.Address;
import evotek.edu.model.Course;
import evotek.edu.model.Fresher;
import evotek.edu.model.Group;
import evotek.edu.model.Syllabus;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;


public class Management {

  public static void main(String[] args) {
//    createCourseSyllabuses();
//    getCourseSyllabuses(1);
//    createFresher();
//    createFresherAndGroup();
    createGroup();
    showFirstLevel();
//    deleteGroupUsingHQL();
//    useCriteria();
//    getGroup();
    ConnectionUtil.getSessionFactory().close();
//    sessionFactory.close();

  }

  private static void showFirstLevel() {
    SessionFactory sessionFactory = ConnectionUtil.getSessionFactory();
    try {
      Session session = sessionFactory.openSession();
      session.beginTransaction();
      Group group = (Group) session.get(Group.class, 1);
      System.out.println(group);
      session.getTransaction().commit();
      session.close();

      session = sessionFactory.openSession();
      session.beginTransaction();
      group = null;
      group = (Group) session.get(Group.class, 1);
      System.out.println(group);
      session.getTransaction().commit();
      session.close();


    } catch (Exception e) {
      System.out.println(e.toString());
    }
  }

  private static void useNameQuery() {
    SessionFactory sessionFactory = ConnectionUtil.getSessionFactory();
    try {
      Session session = sessionFactory.openSession();
      session.beginTransaction();
      Query query = session.getNamedQuery(Constants.GROUP_BY_NAME);
      query.setParameter("name", "Java Group");
      System.out.println(query.list());


    } catch (Exception e) {
      System.out.println(e.toString());
    }
  }

  private static void useCriteria() {
    SessionFactory sessionFactory = ConnectionUtil.getSessionFactory();
    try {
      Session session = sessionFactory.openSession();
      session.beginTransaction();
      Criteria groupCriteria = session.createCriteria(Group.class);
//      groupCriteria.add(
//          Restrictions.or(Restrictions.eq("id", 1),
//              Restrictions.like("name", "Java%")));
//      groupCriteria.add(Restrictions.eq("id", 1));
//      groupCriteria.add(Restrictions.like("name", "Java%"));
      SimpleExpression eq = Restrictions.eq("id", 1);
      SimpleExpression like = Restrictions.like("name", "Java%");
      LogicalExpression le = Restrictions.or(eq, like);
      groupCriteria.add(le);
      System.out.println(groupCriteria.list());

    } catch (Exception e) {
      System.out.println(e.toString());
    }
  }

  private static void deleteGroupUsingHQL() {
    SessionFactory sessionFactory = ConnectionUtil.getSessionFactory();
    try {
      Session session = sessionFactory.openSession();
      session.beginTransaction();
      String queryStr = "delete from Group where id = :id";
      Query query = session.createQuery(queryStr);
      query.setParameter("id", 1);
      int result = query.executeUpdate();
      System.out.println(result);
      session.getTransaction().commit();

    } catch (Exception e) {
      System.out.println(e.toString());
    }
  }

  private static void updateGroupUsingHQL() {
    SessionFactory sessionFactory = ConnectionUtil.getSessionFactory();
    try {
      Session session = sessionFactory.openSession();
      session.beginTransaction();
      String queryStr = "update Group set name = :name where id = :id";
      Query query = session.createQuery(queryStr);
      query.setParameter("id", 1);
      query.setParameter("name", "Funny Java Group");
      int result = query.executeUpdate();
      System.out.println(result);
      session.getTransaction().commit();

    } catch (Exception e) {
      System.out.println(e.toString());
    }
  }

  private static void queryGroupUsingHQL() {
    SessionFactory sessionFactory = ConnectionUtil.getSessionFactory();
    try {
      Session session = sessionFactory.openSession();
      session.beginTransaction();
      String queryStr = "Select name FROM Group where id = :id and name like :name";
      Query query = session.createQuery(queryStr);
      query.setParameter("id", 1);
      query.setParameter("name", "Java%");
      List<Group> groups = (List<Group>) query.list();
      System.out.println(groups);

    } catch (Exception e) {
      System.out.println(e.toString());
    }
  }

  private static void getGroup() {
    SessionFactory sessionFactory = ConnectionUtil.getSessionFactory();
    try {
      Session session = sessionFactory.openSession();
      session.beginTransaction();
      Group javaGroup = (Group) session.get(Group.class, 1);
      System.out.println(javaGroup);
      javaGroup.setName("New Java Group");
      session.delete(javaGroup);
      session.getTransaction().commit();
    } catch (Exception e) {
      System.out.println(e.toString());
    }
  }

  private static void createGroup() {
    SessionFactory sessionFactory = ConnectionUtil.getSessionFactory();
    try {
      Session session = sessionFactory.openSession();
      session.beginTransaction();
      Group javaGroup = new Group("Java Group");
      Group jsGroup = new Group("JavaScrip Group");
      session.save(jsGroup);
      session.save(javaGroup);
      session.getTransaction().commit();

    } catch (Exception e) {
      System.out.println(e.toString());
    }
  }

  private static void createFresherAndGroup() {
    Fresher fresher1 = new Fresher();
    Fresher fresher2 = new Fresher();
    Set<Fresher> freshers = new HashSet<>();
    Group group1 = new Group();
    Group group2 = new Group();
    Set<Group> groups = new HashSet<>();

    freshers.add(fresher1);
    freshers.add(fresher2);
    groups.add(group1);
    groups.add(group2);

    fresher1.setName("Fresher 1");
    fresher2.setName("Fresher 2");
    group1.setName("Group1");
    group2.setName("Group2");
    fresher1.setGroups(groups);
    fresher2.setGroups(groups);
    group1.setFreshers(freshers);
    group2.setFreshers(freshers);

    SessionFactory sessionFactory = ConnectionUtil.getSessionFactory();
    try {
      Session session = sessionFactory.openSession();
      session.beginTransaction();
      session.save(fresher1);
      session.save(fresher2);
      session.save(group1);
      session.save(group2);
      session.getTransaction().commit();
    } catch (Exception e) {
      System.out.println(e.toString());
    }
  }

  private static void createFresherAndCourse() {
    List<Course> courses = new ArrayList<>();
    courses.add(new Course("Java"));
    courses.add(new Course("Hibernate"));
    Fresher fresher = new Fresher("Ducky", courses);
    SessionFactory sessionFactory = ConnectionUtil.getSessionFactory();
    try {
      Session session = sessionFactory.openSession();
      session.beginTransaction();
      for (Course course : courses) {
        session.save(course);
      }
      session.save(fresher);
      session.getTransaction().commit();
    } catch (Exception e) {
      System.out.println(e.toString());
    }
  }

  private static void createFresherAndAddress() {
    Address address = new Address("Duy Tan", "Cau Giay");
    Fresher fresher = new Fresher("Ducky", address);
    SessionFactory sessionFactory = ConnectionUtil.getSessionFactory();
    try {
      Session session = sessionFactory.openSession();
      session.beginTransaction();
      session.save(address);
      session.save(fresher);
      session.getTransaction().commit();
    } catch (Exception e) {
      System.out.println(e.toString());
    }
  }

  private static void createFresher() {
    Address address = new Address("Duy Tan", "Cau Giay");
    Fresher fresher = new Fresher("Ducky", address);
    SessionFactory sessionFactory = ConnectionUtil.getSessionFactory();
    try {
      Session session = sessionFactory.openSession();
      session.beginTransaction();
      session.save(address);
      session.save(fresher);
      session.getTransaction().commit();
    } catch (Exception e) {
      System.out.println(e.toString());
    }
  }

  private static void getCourseSyllabuses(int id) {
    SessionFactory sessionFactory = ConnectionUtil.getSessionFactory();
    try {
      Session session = sessionFactory.openSession();
      session.beginTransaction();
      Course course = (Course) session.get(Course.class, id);
      System.out.println(course.getName());
      session.getTransaction().commit();
      session.close();
      System.out.println(course.getSyllabuses());
    } catch (Exception e) {
      System.out.println(e.toString());
    }
  }

  private static void createCourseSyllabuses() {
    List<Syllabus> syllabuses = new ArrayList<Syllabus>();
    syllabuses.add(new Syllabus("Hibernate Online content", 30));
    syllabuses.add(new Syllabus("Hibernate Offline content", 50));
    Course course = new Course("Hibernate", new Date(), syllabuses);
    SessionFactory sessionFactory = ConnectionUtil.getSessionFactory();
    try {
      Session session = sessionFactory.openSession();
      session.beginTransaction();
      session.save(course);
      session.getTransaction().commit();
    } catch (Exception e) {
      System.out.println(e.toString());
    }
  }

}
