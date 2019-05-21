package ac.za.cput.repository;

import ac.za.cput.Repository.CourseRepository;
import ac.za.cput.Repository.LocationRepository;
import ac.za.cput.Repository.impl.CourseRepositoryImpl;
import ac.za.cput.Repository.impl.LocationRepositoryImpl;
import ac.za.cput.domain.Course;
import ac.za.cput.domain.Location;
import ac.za.cput.factory.CourseFactory;
import ac.za.cput.factory.LocationFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LocationRepositoryImplTest {

    private LocationRepository repository;
    private Location location;

    private Location getSavedLocation() {
        Set<Location> savedLocations = this.repository.getAll();
        return savedLocations.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = LocationRepositoryImpl.getRepository();
        this.location =  LocationFactory.getLocation("Test Course","");
    }

    @Test
    public void a_create() {
        Location created = this.repository.create(this.location);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.location);
    }

    @Test
    public void b_read() {
        Location savedLocations = getSavedLocation();
        System.out.println("In read, locationId = "+ savedLocations.getLocationId());
        Location read = this.repository.read(savedLocations.getLocationId());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedLocations, read);
    }

    @Test
    public void e_delete() {
        Location savedLocation = getSavedLocation();
        this.repository.delete(savedLocation.getLocationId());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newname = "New Test Course Name";
        Location location = new Location.Builder().copy(getSavedLocation()).locationId(newname).build();
        System.out.println("In update, about_to_updated = " + location);
        Location updated = this.repository.update(location);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newname, updated.getLocationId());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Location> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }
}
