package ac.za.cput.domain;

public class Dept {

    private String deptId, deptName;

    private Dept(){}

    private Dept(Builder builder) {
        this.deptId = builder.deptId;
        this.deptName = builder.deptName;
    }

    public String getDeptId() {
        return deptId;
    }

    public String getDeptName() {
        return deptName;
    }
    public static class Builder{

        private String deptId, deptName;

        public Builder deptId(String deptId) {
            this.deptId = deptId;
            return this;
        }

        public Builder deptName(String deptName) {
            this.deptName = deptName;
            return this;
        }

        public Dept build() {
            return new Dept(this);
        }

    }
    @Override
    public String toString() {
        return "Dept{" +
                "deptId='" + deptId + '\'' +
                ", deptName='" + deptName + '\'' +
                '}';
    }
}
