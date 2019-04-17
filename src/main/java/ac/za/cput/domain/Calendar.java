package ac.za.cput.domain;



public class Calendar {

    private String calendarType, calendarName;

    private Calendar() {
    }

    private Calendar(Builder builder) {
        this.calendarType = builder.calendarType;
        this.calendarName = builder.calendarName;
    }

    public String getCalendarType() {
        return calendarType;
    }

    public String getCalendarName() {
        return calendarName;
    }

    public static class Builder{

        private String calendarType, calendarName;

        public Builder calendarType(String calendarType) {
            this.calendarType = calendarType;
            return this;
        }

        public Builder calendarName(String calendarName) {
            this.calendarName = calendarName;
            return this;
        }

        public Calendar build() {
            return new Calendar(this);
        }
    }

    @Override
    public String toString() {
        return "Calendar{" +
                "calendarType='" + calendarType + '\'' +
                ", calendarName='" + calendarName + '\'' +
                '}';
    }
}