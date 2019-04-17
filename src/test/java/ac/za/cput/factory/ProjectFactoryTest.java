package ac.za.cput.factory;

import ac.za.cput.domain.Project;
import org.junit.Assert;
import org.junit.Test;

public class ProjectFactoryTest {

    @Test
    public void getProject() {

        String num= "1";
        String type = "quiz";
        String name = "Sess";
        Project c = ProjectFactory.getProject(num,type,name);
        System.out.println(c);
        Assert.assertNotNull(c.getProjectName());
        Assert.assertNotNull(c.getProjectNum());
        Assert.assertNotNull(c.getProjectType());
    }
}
