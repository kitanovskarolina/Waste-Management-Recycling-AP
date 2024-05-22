package com.example.waste_recycle.pak;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Transactional
public class WasteCollectionRouteService {
    @Autowired
    private WasteCollectionRouteRepository wasteCollectionRouteRepository;

    public WasteCollectionRoute getWasteCollectionRouteById(Long id) {
        return wasteCollectionRouteRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Waste Collection Route not found"));
    }

    public List<WasteCollectionRoute> getAllWasteCollectionRoutes() {
        return wasteCollectionRouteRepository.findAll();
    }

    public WasteCollectionRoute create(WasteCollectionRoute wasteCollectionRoute) {
        validateWasteCollectionRoute(wasteCollectionRoute);
        return wasteCollectionRouteRepository.save(wasteCollectionRoute);
    }

    public WasteCollectionRoute update(WasteCollectionRoute wasteCollectionRoute) {
        if (wasteCollectionRoute.getId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Waste Collection Route ID must not be null");
        }
        validateWasteCollectionRoute(wasteCollectionRoute);
        return wasteCollectionRouteRepository.save(wasteCollectionRoute);
    }

    public void delete(Long id) {
        if (!wasteCollectionRouteRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Waste Collection Route not found");
        }
        wasteCollectionRouteRepository.deleteById(id);
    }

    private void validateWasteCollectionRoute(WasteCollectionRoute wasteCollectionRoute) {
        if (wasteCollectionRoute.getRouteName() == null || wasteCollectionRoute.getRouteName().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Route Name must not be empty");
        }
        if (wasteCollectionRoute.getSchedule() == null || wasteCollectionRoute.getSchedule().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Schedule must not be empty");
        }
        if (wasteCollectionRoute.getWasteType() == null || wasteCollectionRoute.getWasteType().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Waste Type must not be empty");
        }
    }
}
