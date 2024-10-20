import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args) {

        final SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Movie.class)
                .addAnnotatedClass(Actor.class)
                .addAnnotatedClass(Genre.class)
                .buildSessionFactory();


    }
}