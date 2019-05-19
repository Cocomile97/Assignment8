package ac.za.cput.domain;

public class Office {

    private String officeId, officeName;

    private Office(){}

    private Office(Builder builder) {
        this.officeId = builder.officeId;
        this.officeName = builder.officeName;
    }

    public String getOfficeId() {
        return officeId;
    }

    public String getOfficeName() {
        return officeName;
    }
    public static class Builder{

        private String officeId, officeName;

        public Builder officeId(String officeId) {
            this.officeId = officeId;
            return this;
        }

        public Builder officeName(String officeName) {
            this.officeName = officeName;
            return this;
        }
        public Office.Builder copy (Office office){
            this.officeId = office.officeId;
            this.officeName = office.officeName;

            return this;
        }

        public Office build() {
            return new Office(this);
        }

    }
    @Override
    public String toString() {
        return "Office{" +
                "officeId='" + officeId + '\'' +
                ", officeName='" + officeName + '\'' +
                '}';
    }
}
