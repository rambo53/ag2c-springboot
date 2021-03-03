package com.mycompany.ag2c.repository;

import com.mycompany.ag2c.entity.Materiaux;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MateriauxRepository implements MateriauxRepositoryInterface{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Value("${movies.file.location}")
    private File file;

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }


    public Materiaux getById(int id) {
        System.out.println("ok repository getById");
        return jdbcTemplate.queryForObject("SELECT ID,NOM,PRIX,STOCK FROM MATERIAUX WHERE ID=?",new Object[] {id},(rs,rowNum) -> new Materiaux(rs.getInt("ID"),rs.getString("NOM"),rs.getFloat("PRIX"),
                rs.getInt("STOCK")));
    }


    @Override
    public Materiaux add(Materiaux materiau) {
        KeyHolder kh= new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps=connection.prepareStatement("INSERT INTO MATERIAUX(NOM,PRIX,STOCK) VALUES(?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, materiau.getNom());
            ps.setFloat(2, materiau.getPrix());
            ps.setInt(3, materiau.getStock());
            return ps;

        },kh);

        materiau.setId(kh.getKey().intValue());
        System.out.println("materiaux enregistré");
        return materiau;
    }


    @Override
    public List<Materiaux> list() {
        System.out.println("ok repository");
        return jdbcTemplate.query("SELECT ID,NOM,PRIX,STOCK FROM MATERIAUX",(rs,rowNum) -> new Materiaux(rs.getInt("ID"),rs.getString("NOM"),
                rs.getFloat("PRIX"),rs.getInt("STOCK")));
    }

    public void updateMateriaux(Materiaux materiau){
        System.out.println("update ok");

        jdbcTemplate.update(connection -> {
            PreparedStatement ps=connection.prepareStatement("UPDATE MATERIAUX SET NOM=?,PRIX=?,STOCK=? WHERE ID=?",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, materiau.getNom());
            ps.setFloat(2, materiau.getPrix());
            ps.setInt(3, materiau.getStock());
            ps.setInt(4,materiau.getId());
            return ps;

        });



    }
}
