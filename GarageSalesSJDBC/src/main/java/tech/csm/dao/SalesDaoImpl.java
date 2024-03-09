package tech.csm.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import tech.csm.model.Sales;

import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class SalesDaoImpl implements SalesDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int addSale(Sales sale) {
        // Create a SimpleJdbcCall object
        SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("db_operations")
                .declareParameters(
                        new SqlParameter("action", Types.VARCHAR),
                        new SqlParameter("table_name", Types.VARCHAR),
                        new SqlParameter("garage_id", Types.INTEGER),
                        new SqlParameter("tyre_id", Types.INTEGER),
                        new SqlParameter("sales_id", Types.INTEGER),
                        new SqlParameter("sales_date", Types.DATE),
                        new SqlParameter("sales_quantity", Types.INTEGER)
                );

        // Create a map of input parameters
        Map<String, Object> inputParams = new HashMap<>();
        inputParams.put("action", "CREATE");
        inputParams.put("table_name", "sales");
        inputParams.put("garage_id", sale.getGarage().getGarageId());
        inputParams.put("tyre_id", sale.getTyre().getTyreId());
        inputParams.put("sales_id", sale.getSalesId());
        inputParams.put("sales_date", sale.getSalesDate());
        inputParams.put("sales_quantity", sale.getSalesQuantity());

        // Execute the stored procedure with the input parameters
        call.execute(inputParams);
        return 1;
    }

    @Override
    public int updateSale(Sales sale) {
        return 0;
    }

    @Override
    public Sales getSaleById(int salesId) {
        return null;
    }

    @Override
    public List<Sales> getAllSales() {
        return null;
    }

    @Override
    public List<Sales> getAllSalesByGarageId(int garageId) {
        return null;
    }
}
