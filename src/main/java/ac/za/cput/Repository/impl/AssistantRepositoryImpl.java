package ac.za.cput.Repository.impl;

import ac.za.cput.Repository.AssistantRepository;
import ac.za.cput.Repository.CourseRepository;
import ac.za.cput.domain.Assistant;
import ac.za.cput.domain.Course;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AssistantRepositoryImpl implements AssistantRepository {

    private static AssistantRepositoryImpl repository = null;
    private Set<Assistant> assistants;

    private AssistantRepositoryImpl(){
        this.assistants = new HashSet();
    }

    private Assistant findAssistant(String assistantId) {
        return this.assistants.stream()
                .filter(assistant -> assistant.getAssistanttId().trim().equals(assistantId))
                .findAny()
                .orElse(null);
    }

    public static AssistantRepositoryImpl getRepository(){
        if (repository == null) repository = new AssistantRepositoryImpl();
        return repository;
    }


    public Assistant create(Assistant assistant){
        this.assistants.add(assistant);
        return assistant;
    }

    public Assistant read(final String assistantId){
        Assistant assistant = findAssistant(assistantId);
        return assistant;
    }

    public void delete(String assistantId) {
        Assistant assistant = findAssistant(assistantId);
        if (assistant != null) this.assistants.remove(assistant);
    }

    public Assistant update(Assistant assistant){
        Assistant toDelete = findAssistant(assistant.getAssistanttId());
        if(toDelete != null) {
            this.assistants.remove(toDelete);
            return create(assistant);
        }
        return null;
    }


    public Set<Assistant> getAll(){
        return this.assistants;
    }
}
