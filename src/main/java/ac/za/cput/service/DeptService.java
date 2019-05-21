package ac.za.cput.service;

import ac.za.cput.domain.Dept;

import java.util.Set;

public interface DeptService extends IService<Dept, String> {
    Set<Dept> getAll();
}