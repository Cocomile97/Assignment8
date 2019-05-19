package ac.za.cput.Repository.impl;

import ac.za.cput.Repository.CourseRepository;
import ac.za.cput.Repository.DeptRepository;
import ac.za.cput.domain.Course;
import ac.za.cput.domain.Dept;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeptRepositoryImpl implements DeptRepository {

    private static DeptRepositoryImpl repository = null;
    private Set<Dept> depts;

    private DeptRepositoryImpl(){
        this.depts = new HashSet();
    }

    private Dept findDept(String deptId) {
        return this.depts.stream()
                .filter(dept -> dept.getDeptId().trim().equals(deptId))
                .findAny()
                .orElse(null);
    }

    public static DeptRepositoryImpl getRepository(){
        if (repository == null) repository = new DeptRepositoryImpl();
        return repository;
    }


    public Dept create(Dept dept){
        this.depts.add(dept);
        return dept;
    }

    public Dept read(final String deptId){
        Dept dept= findDept(deptId);
        return dept;
    }

    public void delete(String deptId) {
        Dept dept = findDept(deptId);
        if (dept != null) this.depts.remove(dept);
    }

    public Dept update(Dept dept){
        Dept toDelete = findDept(dept.getDeptId());
        if(toDelete != null) {
            this.depts.remove(toDelete);
            return create(dept);
        }
        return null;
    }


    public Set<Dept> getAll(){
        return this.depts;
    }
}
