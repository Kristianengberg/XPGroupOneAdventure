package ActivityPackage;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ActivityTest {

    @Test
    void readActivity() {
        Activity sumo = new Activity("sumo",200,16,150);
        assertEquals("Type: sumo, Price: 200.0, Age: 16, Height: 150", sumo.readActivity());
    }
}