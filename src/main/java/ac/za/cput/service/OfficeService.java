package ac.za.cput.service;

import ac.za.cput.domain.Office;

import java.util.Set;

public interface OfficeService extends IService<Office, String> {
    Set<Office> getAll();
}
