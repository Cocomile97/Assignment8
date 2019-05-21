package ac.za.cput.service;

import ac.za.cput.domain.Degree;

import java.util.Set;

public interface DegreeService extends IService<Degree, String> {
    Set<Degree> getAll();
}
