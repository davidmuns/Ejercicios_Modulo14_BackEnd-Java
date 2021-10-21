package com.m14nivel1.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.m14nivel1.entities.Cuadro;


@Repository
public interface ICuadroDAO extends JpaRepository<Cuadro, Long>{

}
