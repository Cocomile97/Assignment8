package ac.za.cput.factory;

import ac.za.cput.domain.Supervisor;
import ac.za.cput.util.Misc;

public class SupervisorFactory {


    public static Supervisor getSupervisor(String supervisorLevel, String supervisorName) {

        return new Supervisor.Builder().supervisorLevel(supervisorLevel)
                .supervisorName(supervisorName)
                .build();
    }
}