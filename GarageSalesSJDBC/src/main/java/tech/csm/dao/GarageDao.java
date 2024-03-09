package tech.csm.dao;

import tech.csm.model.Garage;

import java.util.List;

public interface GarageDao {
    List<Garage> getAllGarages();
    Garage getGarageById(int garageId);
}
