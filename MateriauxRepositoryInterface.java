package com.mycompany.ag2c.repository;

import com.mycompany.ag2c.entity.Materiaux;

import java.util.List;

public interface MateriauxRepositoryInterface {
    Materiaux add (Materiaux materiau);
    List<Materiaux> list();
    Materiaux getById(int id);
    void updateMateriaux(Materiaux materiau);
}
