package ac.za.cput.factory;

import ac.za.cput.domain.Dept;
import org.junit.Assert;
import org.junit.Test;

public class DeptFactoryTest {

    @Test
    public void getDept() {

        String name = "Information Technology";
        String id="A";
        Dept a = DeptFactory.getDept(name,id);
        System.out.println(a);
        Assert.assertEquals( "A",a.getDeptId());
    }
}
