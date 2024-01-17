package com.example.intellektaspringwebex4.repositories;

import com.example.intellektaspringwebex4.models.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Objects;

@Repository
public class SalesRepository {

    private final JdbcTemplate jdbcTemplate;

    private RowMapper<Sale> saleRowMapper = (r, i) -> {
        Sale rowObject = new Sale();
        rowObject.setId(r.getInt(1));
        rowObject.setProduct_id(r.getString(2));
        rowObject.setStore_date(r.getDate(3));
        rowObject.setSales_date(r.getDate(4));
        rowObject.setPrice(r.getFloat(5));
        return rowObject;
    };

    @Autowired
    public SalesRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int count() {
        return jdbcTemplate.queryForObject("select count(*) from sales", Integer.class);
    }

    public List<Sale> findAllSales() {
        String sqlQuery = "SELECT * FROM sales";
        return jdbcTemplate.query(sqlQuery, saleRowMapper);
    }

    public void insertNewSale(Sale sale) {
        String sqlQuery = "INSERT INTO sales (product_id, store_date, sales_date, price) VALUES (?, ?, ?, ?)";
        try(PreparedStatement statement = Objects.requireNonNull(jdbcTemplate.getDataSource()).getConnection().prepareStatement(sqlQuery)) {
            statement.setString(1, sale.getProduct_id());
            statement.setDate(2, sale.getStore_date());
            statement.setDate(3, sale.getSales_date());
            statement.setFloat(4, sale.getPrice());
            jdbcTemplate.update(con -> statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
