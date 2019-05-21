package ac.za.cput.service;

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
public class LocationServiceImplTest {

    private LocationRepositoryImpl repository;
    private Location location;

    private Location getSaved(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = LocationRepositoryImpl.getRepository();
        this.location = LocationFactory.getLocation("","");
    }

    @Test
    public void a_create() {
        Location created = this.repository.create(this.location);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.location);
    }

    @Test
    public void c_update() {
        String newLocationName = "Library";
        Location updated = new Location.Builder().copy(getSaved()).locationName(newLocationName).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newLocationName, updated.getLocationName());
    }

    @Test
    public void e_delete() {
        Location saved = getSaved();
        this.repository.delete(saved.getLocationName());
        d_getAll();
    }

    @Test
    public void b_read() {
        Location saved = getSaved();
        Location read = this.repository.read(saved.getLocationName());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        Set<Location> locations = this.repository.getAll();
        System.out.println("In getall, all = " + locations);
    }
}