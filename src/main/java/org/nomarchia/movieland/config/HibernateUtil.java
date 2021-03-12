package org.nomarchia.movieland.config;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.nomarchia.movieland.entity.Movie;

@Slf4j
public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new AnnotationConfiguration()
                    .addPackage("org.nomarchia.movieland.entity")
                    .addClass(Movie.class)
                    .configure().buildSessionFactory();
        } catch (HibernateException e) {
            log.debug("Problem occurred during SessionFactory initialization, exception thrown: ", e);
            throw new ExceptionInInitializerError(e);
        }
    }

    public static Session getSession() {
        return sessionFactory.openSession();
    }
}
