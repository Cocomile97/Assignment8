package ac.za.cput.factory;

import ac.za.cput.domain.Office;
import ac.za.cput.util.Misc;

public class OfficeFactory {


    public static Office getOffice(String officeName,String id) {
        return new Office.Builder()
                .officeId(id)
                .officeName(officeName)
                .build();
    }
}