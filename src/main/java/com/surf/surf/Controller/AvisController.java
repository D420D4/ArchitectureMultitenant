package com.surf.surf.Controller;

import com.surf.surf.exception.ResourceNotFoundException;
import com.surf.surf.model.Avis;
import com.surf.surf.repository.AvisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class AvisController {
    @Autowired
    private AvisRepository avisRepository;

    @GetMapping("/avis")
    public Page<Avis> getQuestions(Pageable pageable) {
        return avisRepository.findAll(pageable);
    }

    @PostMapping("/avis")
    public Avis createQuestion(@Valid @RequestBody Avis avis) {
        return avisRepository.save(avis);
    }

    @PutMapping("/avis/{avisId}")
    public Avis updateQuestion(@PathVariable Long avisId,
                                  @Valid @RequestBody Avis avisRequest) {
        return avisRepository.findById(avisId)
                .map(avis -> {
                    avis.setNote(avisRequest.getNote());
                    avis.setText(avisRequest.getText());
                    avis.setSurfeur(avisRequest.getSurfeur());
                    return avisRepository.save(avis);
                }).orElseThrow(() -> new ResourceNotFoundException("Avis not found with id " + avisId));
    }
}
