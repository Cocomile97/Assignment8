package ac.za.cput.service;

import ac.za.cput.domain.Class;

import java.util.Set;

public interface ClassService extends IService<Class, String> {
    Set<Class> getAll();
}
