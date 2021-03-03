package com.mycompany.ag2c.service;

import com.mycompany.ag2c.entity.Materiaux;
import com.mycompany.ag2c.repository.MateriauxRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MateriauxService {

    @Autowired
    MateriauxRepositoryInterface materiauxRepositoryInterface;

    //GETTER
    public MateriauxRepositoryInterface getMateriauxRepositoryInterface() {
        return materiauxRepositoryInterface;
    }

    //SETTER
    public void setMateriauxRepositoryInterface(MateriauxRepositoryInterface materiauxRepositoryInterface) {
        this.materiauxRepositoryInterface = materiauxRepositoryInterface;
    }

    //METHODES
    public void registerMateriau (Materiaux materiau){
        materiauxRepositoryInterface.add(materiau);
    }

    public List<Materiaux> list(){
        return materiauxRepositoryInterface.list();
    }

    public Materiaux getById(int id){
        System.out.println("materiaux service ok");
        return materiauxRepositoryInterface.getById(id);
    }

    public void updateMateriaux(Materiaux materiau){
       materiauxRepositoryInterface.updateMateriaux(materiau);
    }

}
