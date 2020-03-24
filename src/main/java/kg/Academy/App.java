package kg.Academy;

import kg.Academy.entities.Championship;
import kg.Academy.entities.Country;
import kg.Academy.entities.SportKind;
import kg.Academy.entities.Team;
import kg.Academy.util.HibernateUtil;
import org.hibernate.Session;

public class App {
    public static void main(String[] args) {
        Country country = new Country(1,"A");
        create(country);
        SportKind  sportKind = new SportKind(1, "B");
        create(sportKind);
        Team team = new Team(1,"C", "Street", "www.d.kg", sportKind);
        create(team);
        Championship championship = new Championship(1,"D",sportKind,country);
        HibernateUtil.shutDown();
    }

    public static <T> void create(T entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(entity);
        session.getTransaction().commit();
        session.close();
        System.out.println("Создали запись успешно");
    }
}
