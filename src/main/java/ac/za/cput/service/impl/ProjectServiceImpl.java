package ac.za.cput.service.impl;

import ac.za.cput.Repository.CourseRepository;
import ac.za.cput.Repository.ProjectRepository;
import ac.za.cput.Repository.impl.CourseRepositoryImpl;
import ac.za.cput.Repository.impl.ProjectRepositoryImpl;
import ac.za.cput.domain.Course;
import ac.za.cput.domain.Project;
import ac.za.cput.service.CourseService;
import ac.za.cput.service.ProjectService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ProjectServiceImpl implements ProjectService {

    private static ProjectServiceImpl service = null;
    private ProjectRepository repository;

    private ProjectServiceImpl() {
        this.repository = ProjectRepositoryImpl.getRepository();
    }

    public static ProjectServiceImpl getService(){
        if (service == null) service = new ProjectServiceImpl();
        return service;
    }
    @Override
    public Project create(Project project) {
        return this.repository.create(project);
    }

    @Override
    public Project update(Project project) {
        return this.repository.update(project);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Project read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Project> getAll() {
        return this.repository.getAll();
    }
}