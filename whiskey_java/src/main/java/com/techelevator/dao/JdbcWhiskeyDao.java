package com.techelevator.dao;

import com.techelevator.model.Whiskey;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JdbcWhiskeyDao implements WhiskeyDao{
    /**
     *  instantiate JdbcTemplate class for storing PostgreSQL syntax
     */
    private JdbcTemplate jdbcTemplate;
    public JdbcWhiskeyDao(JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;}

    /**
     * get all saved whisky information from DB
     * @return Whiskey List from DB
     */
    @Override
    public List<Whiskey> findAll() {
        List<Whiskey> whiskeyList = new ArrayList<>();
        String sql = "SELECT * from whiskey";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()) {
            Whiskey whiskey = mapRowToWhiskey(results);
            whiskeyList.add(whiskey);
        }
        return whiskeyList;
    }

    @Override
    public Whiskey findWhiskeyById(int id) {

        String sql = "SELECT * from whiskey WHERE id =?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        if(results.next()) {
            Whiskey whiskey = mapRowToWhiskey(results);
            return whiskey;
        }else{
        throw new RuntimeException("Id " + id + " was not found." );
        }
    }

    /**
     * put the information of created whiskey object from user
     * @param whiskey
     * @return whiskey object
     */
    @Override
    public Whiskey createWhiskey(Whiskey whiskey) {
    String sql = "INSERT INTO whiskey (name, distiller, type, region, volume, proof, aged, price) " +
                 "VALUES(?,?,?,?,?,?,?,?) RETURNING id";
    Integer id = 0;
    jdbcTemplate.queryForObject(sql, Integer.class, whiskey.getName(), whiskey.getDistiller(),
                            whiskey.getType(), whiskey.getRegion(), whiskey.getVolume(), whiskey.getProof(), whiskey.getAged(), whiskey.getPrice());
    whiskey.setId(id);
        return whiskey;
    }

    /**
     * update DB with whiskey id and new volume
     * @param id
     * @param volume
     */
    @Override
    public void updateVolume(int id, int volume) {
        String sql = "UPDATE whiskey SET volume = ? WHERE id = ?";
        jdbcTemplate.update(sql, volume, id);
    }

    /**
     * store each information and set it for a new object
     * @param rs
     * @return created whiskey object
     */
    public Whiskey mapRowToWhiskey(SqlRowSet rs) {
        Whiskey whiskey = new Whiskey();
        whiskey.setId(rs.getInt("id"));
        whiskey.setName(rs.getString("name"));
        whiskey.setDistiller(rs.getString("distiller"));
        whiskey.setType(rs.getString("type"));
        whiskey.setRegion(rs.getString("region"));
        whiskey.setVolume(rs.getInt("volume"));
        whiskey.setProof(rs.getInt("proof"));
        whiskey.setAged(rs.getInt("aged"));
        whiskey.setPrice(rs.getBigDecimal("price"));
        return whiskey;
    }
}
