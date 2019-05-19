package ac.za.cput.Repository.impl;

import ac.za.cput.Repository.CourseRepository;
import ac.za.cput.Repository.LocationRepository;
import ac.za.cput.Repository.ProjectRepository;
import ac.za.cput.domain.Course;
import ac.za.cput.domain.Location;
import ac.za.cput.domain.Project;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProjectRepositoryImpl implements ProjectRepository {

    private static ProjectRepositoryImpl repository = null;
    private Set<Project> projects;

    private ProjectRepositoryImpl(){
        this.projects = new HashSet();
    }

    private Project findProject(String projectName) {
        return this.projects.stream()
                .filter(project -> project.getProjectName().trim().equals(projectName))
                .findAny()
                .orElse(null);
    }

    public static ProjectRepositoryImpl getRepository(){
        if (repository == null) repository = new ProjectRepositoryImpl();
        return repository;
    }


    public Project create(Project project){
        this.projects.add(project);
        return project;
    }

    public Project read(final String projectName){
        Project project = findProject(projectName);
        return project;
    }

    public void delete(String projectName) {
        Project project = findProject(projectName);
        if (project != null) this.projects.remove(project);
    }

    public Project update(Project project){
        Project toDelete = findProject(project.getProjectName());
        if(toDelete != null) {
            this.projects.remove(toDelete);
            return create(project);
        }
        return null;
    }


    public Set<Project> getAll(){
        return this.projects;
    }
}
