package sample;

import models.EquipmentModel;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryEquipmentDbTest {
    String id;
    String type;
    boolean needsRepair;
    private Object InMemoryEquipmentDb;

    @Test
    void testRead() {
        ArrayList<EquipmentModel> equipment1 = new ArrayList<>();
        InMemoryEquipmentDb inMemoryEquipmentDb = new InMemoryEquipmentDb();



        Object actual = inMemoryEquipmentDb.read("gk2");
        Object expected =  "EquipmentModel{" + "id: " + "gk1" + " type: " + "Gokart" + " needs repair: " + "false" + "}";

        assertEquals(expected, actual);
        //assertEquals(actual, equipment1);
    }

    @Test
    void readAll() {
    }
}