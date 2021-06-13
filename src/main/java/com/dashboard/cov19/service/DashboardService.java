package com.dashboard.cov19.service;

import com.dashboard.cov19.model.RegionViewModel;

import java.util.Collection;

public interface DashboardService {
    Collection<RegionViewModel> getAllCountries();

    Collection<RegionViewModel> getAllStates(String country);

    RegionViewModel getTodaysData();

    RegionViewModel getTodaysDataForCountry(String country);
}
