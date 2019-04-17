package ac.za.cput.factory;

import ac.za.cput.domain.Session;
import ac.za.cput.util.Misc;

public class SessionFactory {


    public static Session getSession(String sessionDuration, String sessionType) {

        return new Session.Builder().sessionDuration(sessionDuration)
                .sessionType(sessionType)
                .build();
    }
}