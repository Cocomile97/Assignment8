package ac.za.cput.Repository.impl;
import ac.za.cput.Repository.ProjectRepository;
import ac.za.cput.domain.Project;
import ac.za.cput.factory.ProjectFactory;

import java.util.*;


public class ProjectRepositoryImpl implements ProjectRepository {

    private List <Project>listproject;

    private static ProjectRepositoryImpl repository = null;
    private Set<Project> project;

    private ProjectRepositoryImpl (){
        this.project = new HashSet<Project>();
    }

    public static ProjectRepositoryImpl getRepository(){
        if (repository == null) repository = new ProjectRepositoryImpl();
        return repository;
    }

    public Set<Project> getAll() {
        return project;
    }


    public Project create(Project project) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the project name: ");
        String name=input.nextLine().toUpperCase();
        System.out.println("Enter the project num : ");
        String num=input.nextLine();
        System.out.println("Enter the project type : ");
        String type=input.nextLine();


        project=ProjectFactory.getProject(num,type,name);

        this.project.add(project);
        System.out.println("Project created successfully");

        return project;
    }

    @Override
    public Project update(Project location) {
        return null;
    }

    @Override
    public void delete(String s) {

        listproject=new ArrayList<Project>(project);
        for (int i=0;i<listproject.size();i++){
            if (s.toUpperCase()==listproject.get(i).getProjectNum() ){
                project.remove(i);
            }
        }
        for(Project b : listproject)
            project.add(b);
    }

    @Override
    public Project read(String s) {
        Project b=null;
        listproject=new ArrayList<Project>(project);
        for (int i=0;i<listproject.size();i++){
            if (s==listproject.get(i).getProjectNum() ){
                b= listproject.get(i);
            }
        }
        return b;
    }
}
