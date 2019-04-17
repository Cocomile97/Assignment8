package ac.za.cput.factory;

import ac.za.cput.domain.Dept;
import ac.za.cput.util.Misc;

public class DeptFactory {


    public static Dept getDept(String deptName,String id) {
        return new Dept.Builder().deptId(id)
                .deptName(deptName)
                .build();
    }
}