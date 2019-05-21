package ac.za.cput.service;

import ac.za.cput.domain.Session;

import java.util.Set;

public interface SessionService extends IService<Session, String> {
    Set<Session> getAll();
}