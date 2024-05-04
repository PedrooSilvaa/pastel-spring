package com.edu.senaisp.Pastel.repository;

import com.edu.senaisp.Pastel.model.Pastel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Repository
public class PastelRepository implements ICrud {

    private final String qrSelect = "SELECT ID, SABOR FROM PASTEL;";
    private final String qrSelectById = "SELECT ID, SABOR FROM PASTEL WHERE ID = ?;";
    private final String qrInsert = "INSERT INTO PASTEL(ID, SABOR) VALUES (DEFAULT, ?);";
    private final String qrUpdate = "UPDATE PASTEL SET SABOR = ? WHERE ID = ?;";
    private final String qrDelete = "DELETE FROM PASTEL WHERE ID = ?;";

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Pastel> list() {
        return jdbcTemplate.query(qrSelect, (rs, rowNum) -> {
                return new Pastel(rs.getInt("id"),
                        rs.getString("sabor"));
        });
    }

    @Override
    public Pastel findById(int id) {

        Object[] params = {id};

        return jdbcTemplate.queryForObject(qrSelectById,
                params,
                (rs, rowNum) -> {
            return new Pastel(rs.getInt("id"),
                    rs.getString("sabor"));
        });
    }

    @Override
    public List<Pastel> insert(Pastel pastel) {
        Object[] params = {pastel.getSabor()};
        jdbcTemplate.update(qrInsert, params);
        return list();
    }

    @Override
    public Pastel update(Pastel pastel, int id) {

        Object[] params = {pastel.getSabor(), id};

        jdbcTemplate.update(qrUpdate, params);

        return findById(id);
    }

    @Override
    public void delete(int id) {

        Object[] params = {id};

        jdbcTemplate.update(qrDelete, params);

    }
}
