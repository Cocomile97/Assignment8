package ac.za.cput.factory;

import ac.za.cput.domain.Assistant;
import ac.za.cput.util.Misc;

public class AssistantFactory {

    public static Assistant getAssistant(String assistantFirstName, String assistantLastName, int age) {
        return new Assistant.Builder().age(age)
                .assistantFirstName(assistantFirstName)
                .assistantLastName(assistantLastName)
                .assistantId(Misc.generateId())
                .build();
    }
}