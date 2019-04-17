package ac.za.cput.domain;



public class Supervisor {

    private String supervisorLevel, supervisorName;

    private Supervisor() {
    }

    private Supervisor(Builder builder) {
        this.supervisorLevel = builder.supervisorLevel;
        this.supervisorName = builder.supervisorName;
    }

    public String getsupervisorLevel() {
        return supervisorLevel;
    }

    public String getSupervisorName() {
        return supervisorName;
    }

    public static class Builder{

        private String supervisorLevel, supervisorName;

        public Builder supervisorLevel(String supervisorLevel) {
            this.supervisorLevel = supervisorLevel;
            return this;
        }

        public Builder supervisorName(String supervisorName) {
            this.supervisorName = supervisorName;
            return this;
        }

        public Supervisor build() {
            return new Supervisor(this);
        }
    }

    @Override
    public String toString() {
        return "Supervisor{" +
                "supervisorLevel='" + supervisorLevel + '\'' +
                ", supervisorName='" + supervisorName + '\'' +
                '}';
    }
}