package com.example.waste_recycle.pak;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("waste")
public class WasteCollectionRouteController {
    @Autowired
    private WasteCollectionRouteService wasteCollectionRouteService;

    @GetMapping
    public List<WasteCollectionRoute> findAll() {
        return wasteCollectionRouteService.getAllWasteCollectionRoutes();
    }

    @GetMapping("/{id}")
    public WasteCollectionRoute findById(@PathVariable("id") Long id) {
        return wasteCollectionRouteService.getWasteCollectionRouteById(id);
    }

    @PostMapping
    public WasteCollectionRoute create(@RequestBody WasteCollectionRoute wasteCollectionRoute) {
        return wasteCollectionRouteService.create(wasteCollectionRoute);
    }

    @PutMapping
    public WasteCollectionRoute update(@RequestBody WasteCollectionRoute wasteCollectionRoute) {
        return wasteCollectionRouteService.update(wasteCollectionRoute);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        wasteCollectionRouteService.delete(id);
    }

}
