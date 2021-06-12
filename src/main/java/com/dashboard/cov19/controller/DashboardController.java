package com.dashboard.cov19.controller;

import com.dashboard.cov19.model.RegionViewModel;
import com.dashboard.cov19.service.DashboardService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@CrossOrigin
@RequestMapping(value = "/dashboard")
public class DashboardController {

    private final DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @RequestMapping(value = "/countries")
    public Collection<RegionViewModel> getCountriesStats() {
        return dashboardService.getAllCountries();
    }
}
