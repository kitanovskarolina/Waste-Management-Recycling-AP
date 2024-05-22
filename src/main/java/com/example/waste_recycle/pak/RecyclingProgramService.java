package com.example.waste_recycle.pak;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class RecyclingProgramService {
    @Autowired
    private RecyclingProgramRepository recyclingProgramRepository;
    public RecyclingProgram getRecyclingProgramById(Long id) {
        return recyclingProgramRepository.findById(id).orElseThrow(() -> new RuntimeException("Recycling Program not found"));
    }

    public List<RecyclingProgram> getAllRecyclingPrograms() {
        return recyclingProgramRepository.findAll();
    }

    public RecyclingProgram create(RecyclingProgram recyclingProgram) {
        return recyclingProgramRepository.save(recyclingProgram);
    }

    public RecyclingProgram update(RecyclingProgram recyclingProgram) {
        return recyclingProgramRepository.save(recyclingProgram);
    }

    public void delete(Long id) {
        recyclingProgramRepository.deleteById(id);
    }

}
