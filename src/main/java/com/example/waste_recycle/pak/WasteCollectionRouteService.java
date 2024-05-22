package com.example.waste_recycle.pak;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class WasteCollectionRouteService {
    @Autowired
    private WasteCollectionRouteRepository wasteCollectionRouteRepository;
    public WasteCollectionRoute getWasteCollectionRouteById(Long id){
        return wasteCollectionRouteRepository.findById(id).orElseThrow(() -> new RuntimeException("Waste Collection Route not found"));
    }

    public List<WasteCollectionRoute> getAllWasteCollectionRoutes() {
        return wasteCollectionRouteRepository.findAll();
    }

    public WasteCollectionRoute create(WasteCollectionRoute wasteCollectionRoute) {
        return wasteCollectionRouteRepository.save(wasteCollectionRoute);
    }

    public WasteCollectionRoute update(WasteCollectionRoute wasteCollectionRoute) {
        return wasteCollectionRouteRepository.save(wasteCollectionRoute);
    }

    public void delete(Long id) {
        wasteCollectionRouteRepository.deleteById(id);
    }
}
