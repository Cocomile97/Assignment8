package ac.za.cput.factory;

import ac.za.cput.domain.Project;
import ac.za.cput.util.Misc;

public class ProjectFactory {


    public static Project getProject(String projectName, String projectNum, String projectType) {

        return new Project.Builder().projectName(projectName)
                .projectNum(projectNum)
                .projectType(projectType)
                .build();
    }
}