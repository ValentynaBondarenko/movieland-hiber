package org.nomarchia.movieland.config;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.nomarchia.movieland.entity.Genre;
import org.nomarchia.movieland.entity.Movie;

@Slf4j
public class HibernateUtil {
    private static final SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration()
                    .addPackage("org.nomarchia.movieland.entity")
                    .addAnnotatedClass(Movie.class)
                    .addAnnotatedClass(Genre.class)
                    .buildSessionFactory();
        } catch (HibernateException e) {
            log.debug("Problem occurred during SessionFactory initialization, exception thrown: ", e);
            throw new ExceptionInInitializerError(e);
        }
    }

    public static Session getSession() {
        log.info("new session is to be opened in HibernateUtil");
        return sessionFactory.openSession();
    }
}
