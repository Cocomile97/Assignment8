package ac.za.cput.domain;



public class Project {

    private String projectNum, projectName, projectType;

    private Project() {
    }

    private Project(Builder builder) {
        this.projectNum = builder.projectNum;
        this.projectName = builder.projectName;
        this.projectType = builder.projectType;
    }

    public String getProjectNum() {
        return projectNum;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getProjectType() {
        return projectType;
    }

    public static class Builder{

        private String projectNum, projectName, projectType;

        public Builder projectNum(String projectNum) {
            this.projectNum = projectNum;
            return this;
        }

        public Builder projectName(String projectName) {
            this.projectName = projectName;
            return this;
        }

        public Builder projectType(String projectType) {
            this.projectType = projectType;
            return this;
        }
        public Project.Builder copy (Project project){
            this.projectName = project.projectName;
            this.projectNum = project.projectNum;
            this.projectType = project. projectType;

            return this;
        }
        public Project build() {
            return new Project(this);
        }
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectNum='" + projectNum + '\'' +
                ", projectName='" + projectName + '\'' +
                ", projectType='" + projectType + '\'' +
                '}';
    }
}