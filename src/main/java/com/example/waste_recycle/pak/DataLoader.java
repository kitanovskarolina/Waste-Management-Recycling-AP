package com.example.waste_recycle.pak;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataLoader {
    @Autowired
    private WasteCollectionRouteService wasteCollectionRouteService;

    @Autowired
    private RecyclingProgramService recyclingProgramService;

    @PostConstruct
    public void loadData() {
        loadWasteCollectionRoutes();
        loadRecyclingPrograms();
    }

    private void loadWasteCollectionRoutes() {
        WasteCollectionRoute route1 = new WasteCollectionRoute();
        route1.setRouteName("Downtown Route");
        route1.setSchedule("Every Monday at 6:00 AM");
        route1.setWasteType("General Waste");
        wasteCollectionRouteService.create(route1);

        WasteCollectionRoute route2 = new WasteCollectionRoute();
        route2.setRouteName("Uptown Route");
        route2.setSchedule("Every Wednesday at 7:00 AM");
        route2.setWasteType("Recyclable Waste");
        wasteCollectionRouteService.create(route2);

        WasteCollectionRoute route3 = new WasteCollectionRoute();
        route3.setRouteName("Suburban Route");
        route3.setSchedule("Every Friday at 8:00 AM");
        route3.setWasteType("Organic Waste");
        wasteCollectionRouteService.create(route3);
    }

    private void loadRecyclingPrograms() {
        RecyclingProgram program1 = new RecyclingProgram();
        program1.setProgramName("Paper Recycling");
        program1.setDescription("Collect and recycle paper products.");
        recyclingProgramService.create(program1);

        RecyclingProgram program2 = new RecyclingProgram();
        program2.setProgramName("Plastic Recycling");
        program2.setDescription("Collect and recycle plastic products.");
        recyclingProgramService.create(program2);

        RecyclingProgram program3 = new RecyclingProgram();
        program3.setProgramName("E-Waste Recycling");
        program3.setDescription("Collect and recycle electronic waste.");
        recyclingProgramService.create(program3);
    }
}
