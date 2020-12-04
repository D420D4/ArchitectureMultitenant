package com.surf.surf.repository;


import com.surf.surf.model.Surfeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurfeurRepository  extends JpaRepository<Surfeur, Long> {
}
