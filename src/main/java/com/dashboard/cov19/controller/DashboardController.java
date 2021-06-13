package com.dashboard.cov19.controller;

import com.dashboard.cov19.model.RegionViewModel;
import com.dashboard.cov19.service.DashboardService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@CrossOrigin
@RequestMapping(value = "/dashboard")
public class DashboardController {

    private final DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @RequestMapping(value = "/countries", method = RequestMethod.GET)
    public Collection<RegionViewModel> getCountriesStats() {
        return dashboardService.getAllCountries();
    }

    @RequestMapping(value = "/states/{name}", method = RequestMethod.GET)
    public Collection<RegionViewModel> getStatesStats(@PathVariable("name") String country) {
        return dashboardService.getAllStates(country);
    }
}
