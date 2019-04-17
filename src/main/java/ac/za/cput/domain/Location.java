package ac.za.cput.domain;



public class Location {

    private String locationId, locationName;

    private Location() {
    }

    private Location(Builder builder) {
        this.locationId = builder.locationId;
        this.locationName = builder.locationName;
    }

    public String getLocationId() {
        return locationId;
    }

    public String getLocationName() {
        return locationName;
    }

    public static class Builder{

        private String locationId, locationName;

        public Builder locationId(String locationId) {
            this.locationId = locationId;
            return this;
        }

        public Builder locationName(String locationName) {
            this.locationName = locationName;
            return this;
        }

        public Location build() {
            return new Location(this);
        }
    }

    @Override
    public String toString() {
        return "Location{" +
                "locationId='" + locationId + '\'' +
                ", locationName='" + locationName + '\'' +
                '}';
    }
}