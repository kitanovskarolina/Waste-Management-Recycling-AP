package com.example.waste_recycle.pak;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("recycling")
public class RecyclingProgramController {
    @Autowired

    private RecyclingProgramService recyclingProgramService;

    @GetMapping
    public List<RecyclingProgram> findAll() {
        return recyclingProgramService.getAllRecyclingPrograms();
    }

    @GetMapping("/{id}")
    public RecyclingProgram findById(@PathVariable("id") Long id) {
        return recyclingProgramService.getRecyclingProgramById(id);
    }

    @PostMapping
    public RecyclingProgram create(@RequestBody RecyclingProgram recyclingProgram) {
        return recyclingProgramService.create(recyclingProgram);
    }

    @PutMapping
    public RecyclingProgram update(@RequestBody RecyclingProgram recyclingProgram) {
        return recyclingProgramService.update(recyclingProgram);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        recyclingProgramService.delete(id);
    }
}
