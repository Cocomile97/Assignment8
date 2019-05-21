package ac.za.cput.service;

import ac.za.cput.domain.Project;

import java.util.Set;

public interface ProjectService extends IService<Project, String> {
    Set<Project> getAll();
}
