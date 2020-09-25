package sample;

import models.EquipmentModel;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EquipmentTest {

    private Object EquipmentModel;

    @Test
    public void testAll() {
        int actual = 2;
        int expected = 2;

        assertEquals(actual, expected);
    }

    @Test
    public void testString() {
        String actual = "Hey you";
        String expected = "Hey you";

        assertEquals(actual, expected);
    }

    @Test
    public EquipmentModel readEquipment() {
        ArrayList<EquipmentModel> equipment = new ArrayList<>();
        equipment.add(new EquipmentModel("gk1", "Gokart", false ));
        equipment.add(new EquipmentModel("gk2", "Gokart", false ));
        equipment.add(new EquipmentModel("gk3", "Gokart", false ));
        equipment.add(new EquipmentModel("gk4", "Gokart", false ));
        return equipment.get(0);
    }

    @Test
    public List readEquip(List<EquipmentModel> em)  {
            em.add(new EquipmentModel("gk1", "Gokart", false ));
            List actual = em;

        EquipmentTest readEquipTest = new EquipmentTest();
            List result = readEquipTest.readEquip(em);
            assertEquals(actual, result);


        return em;
    }

    @Test
    public void readEquipment123(){
        EquipmentModel eqip = new EquipmentModel("1","sumo",true);
        String expected = "1" + " " + "sumo" + " " + "true";
        String actual = eqip.readEquipment();

        assertEquals(expected,actual);
    }

}