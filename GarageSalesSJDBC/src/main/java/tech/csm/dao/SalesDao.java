package tech.csm.dao;

import tech.csm.model.Sales;

import java.util.List;

public interface SalesDao {
    // Returns the generated key if successful
    int addSale(Sales sale);
    // returns the number of rows updated if successful
    int updateSale(Sales sale);
    Sales getSaleById(int salesId);
    List<Sales> getAllSales();
    List<Sales> getAllSalesByGarageId(int garageId);
}

