package ac.za.cput.factory;

import ac.za.cput.domain.Year;
import ac.za.cput.util.Misc;

public class YearFactory {


    public static Year getYear(String yearNum) {

        return new Year.Builder().yearNum(yearNum)
                .build();
    }
}