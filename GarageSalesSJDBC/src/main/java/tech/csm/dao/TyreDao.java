package tech.csm.dao;

import tech.csm.model.Tyre;

import java.util.List;

public interface TyreDao {
    Tyre getTyreById(int tyreId);
    List<Tyre> getAllTyres();
}
