package ac.za.cput.service;

import ac.za.cput.domain.Year;

import java.util.Set;

public interface YearService extends IService<Year, String> {
    Set<Year> getAll();
}