
import com.ships.Objects.Employee;
import junit.framework.TestCase;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;



public class AppTest extends TestCase {

    public void testApp() {
//        SessionFactory sessionFactory = new Configuration().configure()
//                .buildSessionFactory();
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//        //session.get

//        Employee user = new Employee("alex", "shalin");
//        session.save(user);
//       Employee user1 = new Employee("alex", "shalin");
//        session.getTransaction().commit();
//        List<Employee> list = session.createCriteria(Employee.class).list();
//        for (Employee j:list) {
//
//            System.out.println(j.getId()+" "+j.getLogin()+" "+j.getPassword());
//            if(j.getLogin()==user1.getLogin() && j.getPassword()==user1.getPassword()){
//                System.out.println("Login good");
//            }
//            else System.out.println("Login bad");
//        }
//
//        session.close();
    }
}