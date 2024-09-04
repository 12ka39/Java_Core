package com.example.demo.imgboard;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImgboardDao extends JpaRepository<Imgboard, Integer> {

}
