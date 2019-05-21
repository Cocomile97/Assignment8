package ac.za.cput.service;

import ac.za.cput.domain.Supervisor;

import java.util.Set;

public interface SupervisorService extends IService<Supervisor, String> {
    Set<Supervisor> getAll();
}