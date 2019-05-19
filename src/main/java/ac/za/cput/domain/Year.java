package ac.za.cput.domain;



public class Year {

    private String yearNum;

    private Year() {
    }

    private Year(Builder builder) {
        this.yearNum = builder.yearNum;
    }

    public String getyearNum() {
        return yearNum;
    }

    public static class Builder{

        private String yearNum;


        public Builder yearNum(String yearNum) {
            this.yearNum = yearNum;
            return this;
        }
        public Year.Builder copy (Year year){
            this.yearNum = year.yearNum;

            return this;
        }
        public Year build() {
            return new Year(this);
        }
    }

    @Override
    public String toString() {
        return "Year{" +
                ", degreeName='" + yearNum + '\'' +
                '}';
    }
}