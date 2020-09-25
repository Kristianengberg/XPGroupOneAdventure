package sample;

import models.EquipmentModel;

import java.util.List;

public interface IEquipmentRepo {

    public EquipmentModel read(String id);

    public List<EquipmentModel> readAll();
}
