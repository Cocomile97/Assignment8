package ac.za.cput.service;

import ac.za.cput.domain.Assistant;

import java.util.Set;

public interface AssistantService extends IService<Assistant, String> {
    Set<Assistant> getAll();
}