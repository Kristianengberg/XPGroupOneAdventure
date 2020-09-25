package sample;

import models.EquipmentModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InMemoryEquipmentDb implements IEquipmentRepo{
    private List<EquipmentModel> inMemoryEquipment;
    private Object EquipmentModel;

    public InMemoryEquipmentDb() {
        this.inMemoryEquipment = new ArrayList<EquipmentModel>(
        Arrays.asList(
                new EquipmentModel("gk1", "Gokart", false),
                new EquipmentModel("gk2", "Gokart", false),
                new EquipmentModel("gk3", "Gokart", true)
        )
        );
    }



    @Override
    public EquipmentModel read(String id) {
        for(EquipmentModel equip : inMemoryEquipment) {
            if(equip.getId() == id) {
                return (models.EquipmentModel) EquipmentModel;
            }
        }
        return null;
    }

    @Override
    public List<EquipmentModel> readAll() {
        return inMemoryEquipment;
    }
}
