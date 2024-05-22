package com.example.waste_recycle.pak;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Transactional
public class RecyclingProgramService {
    @Autowired
    private RecyclingProgramRepository recyclingProgramRepository;

    public RecyclingProgram getRecyclingProgramById(Long id) {
        return recyclingProgramRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Recycling Program not found"));
    }

    public List<RecyclingProgram> getAllRecyclingPrograms() {
        return recyclingProgramRepository.findAll();
    }

    public RecyclingProgram create(RecyclingProgram recyclingProgram) {
        validateRecyclingProgram(recyclingProgram);
        return recyclingProgramRepository.save(recyclingProgram);
    }

    public RecyclingProgram update(RecyclingProgram recyclingProgram) {
        if (recyclingProgram.getId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Recycling Program ID must not be null");
        }
        validateRecyclingProgram(recyclingProgram);
        return recyclingProgramRepository.save(recyclingProgram);
    }

    public void delete(Long id) {
        if (!recyclingProgramRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Recycling Program not found");
        }
        recyclingProgramRepository.deleteById(id);
    }

    private void validateRecyclingProgram(RecyclingProgram recyclingProgram) {
        if (recyclingProgram.getProgramName() == null || recyclingProgram.getProgramName().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Program Name must not be empty");
        }
        if (recyclingProgram.getDescription() == null || recyclingProgram.getDescription().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Description must not be empty");
        }
    }
}
