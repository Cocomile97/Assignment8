package ac.za.cput.domain;



public class Degree {

    private String degreeLevel, degreeName;

    private Degree() {
    }

    private Degree(Builder builder) {
        this.degreeLevel = builder.degreeLevel;
        this.degreeName = builder.degreeName;
    }

    public String getDegreeLevel() {
        return degreeLevel;
    }

    public String getDegreeName() {
        return degreeName;
    }

    public static class Builder{

        private String degreeLevel, degreeName;

        public Builder degreeLevel(String degreeLevel) {
            this.degreeLevel = degreeLevel;
            return this;
        }

        public Builder degreeName(String degreeName) {
            this.degreeName = degreeName;
            return this;
        }

        public Degree.Builder copy (Degree degree){
            this.degreeLevel = degree.degreeLevel;
            this.degreeName = degree.degreeName;

            return this;
        }
        public Degree build() {
            return new Degree(this);
        }
    }

    @Override
    public String toString() {
        return "Degree{" +
                "degreeLevel='" + degreeLevel + '\'' +
                ", degreeName='" + degreeName + '\'' +
                '}';
    }
}