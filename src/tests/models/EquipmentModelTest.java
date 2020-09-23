package models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EquipmentModelTest {

    private EquipmentModel equipmentModel;
    private String id;
    private String type;
    private boolean needsRepair;

    @BeforeEach
    void beforeTests() {
        this.id = getRandomString(20);
        this.type = getRandomString(20);
        this.needsRepair = Math.random() > 0.5;
        equipmentModel = new EquipmentModel(this.id, this.type, this.needsRepair);
    }

    @Test
    void getId() {
        assertEquals(id, equipmentModel.getId(), "Asserting that equipment.getId returns correct result");
    }

    @Test
    void getType() {
        assertEquals(type, equipmentModel.getType(), "Asserting that equipment.getType returns correct result");
    }

    @Test
    void isNeedsRepair() {
        assertEquals(needsRepair, equipmentModel.isNeedsRepair(), "Asserting that equipment.isNeedsRepair returns correct result");
    }

    @Test
    void setId() {
        String newId = getRandomString(22);
        equipmentModel.setId(newId);
        assertEquals(newId, equipmentModel.getId(), "Asserting that equipment.setId correctly mutates the id");
    }

    @Test
    void setType() {
    }

    @Test
    void setNeedsRepair() {
    }

    static String getRandomString(int n) {
        // choose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                    = (int)(AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }
}