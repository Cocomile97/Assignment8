package ac.za.cput.factory;

import ac.za.cput.domain.Degree;
import ac.za.cput.util.Misc;

public class DegreeFactory {


    public static Degree getDegree(String degreeLevel, String degreeName) {

        return new Degree.Builder().degreeLevel(degreeLevel)
                .degreeName(degreeName)
                .build();
    }
}