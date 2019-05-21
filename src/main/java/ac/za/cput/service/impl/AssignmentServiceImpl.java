package ac.za.cput.service.impl;

import ac.za.cput.Repository.AccountRepository;
import ac.za.cput.Repository.AssignmentRepository;
import ac.za.cput.Repository.impl.AccountRepositoryImpl;
import ac.za.cput.Repository.impl.AssignmentRepositoryImpl;
import ac.za.cput.Repository.impl.AssistantRepositoryImpl;
import ac.za.cput.domain.Account;
import ac.za.cput.domain.Assignment;
import ac.za.cput.service.AccountService;
import ac.za.cput.service.AssignmentService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AssignmentServiceImpl implements AssignmentService {

    private static AssignmentServiceImpl service = null;
    private AssignmentRepository repository;

    private AssignmentServiceImpl() {
        this.repository = AssignmentRepositoryImpl.getRepository();
    }

    public static AssignmentServiceImpl getService(){
        if (service == null) service = new AssignmentServiceImpl();
        return service;
    }

    @Override
    public Assignment create(Assignment assignment) {
        return this.repository.create(assignment);
    }

    @Override
    public Assignment update(Assignment assignment) {
        return this.repository.update(assignment);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Assignment read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Assignment> getAll() {
        return this.repository.getAll();
    }
}