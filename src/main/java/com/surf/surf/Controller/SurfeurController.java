package com.surf.surf.Controller;

import com.surf.surf.exception.ResourceNotFoundException;
import com.surf.surf.model.Surfeur;
import com.surf.surf.repository.SurfeurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class SurfeurController {

    @Autowired
    private SurfeurRepository surfeurRepository;

    @GetMapping("/surfeur")
    public Page<Surfeur> getQuestions(Pageable pageable) {
        return surfeurRepository.findAll(pageable);
    }

    @PostMapping("/surfeur")
    public Surfeur createQuestion(@Valid @RequestBody Surfeur surfeur) {
        return surfeurRepository.save(surfeur);
    }

    @PutMapping("/surfeur/{surfeurId}")
    public Surfeur updateQuestion(@PathVariable Long surfeurId,
                                   @Valid @RequestBody Surfeur surfeurRequest) {
        return surfeurRepository.findById(surfeurId)
                .map(surfeur -> {
                    surfeur.setName(surfeurRequest.getName());
                    surfeur.setNiveau(surfeurRequest.getNiveau());
                    surfeur.setDescription(surfeurRequest.getDescription());
                    return surfeurRepository.save(surfeur);
                }).orElseThrow(() -> new ResourceNotFoundException("Sufeur not found with id " + surfeurId));
    }


}
