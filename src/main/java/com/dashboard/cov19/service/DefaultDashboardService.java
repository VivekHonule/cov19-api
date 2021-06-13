package com.dashboard.cov19.service;

import com.dashboard.cov19.entity.CovidCase;
import com.dashboard.cov19.model.RegionViewModel;
import com.dashboard.cov19.repository.CovidCaseRepository;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class DefaultDashboardService implements DashboardService {

    public static final String STATUS_ACTIVE = "Active";
    public static final String STATUS_RECOVERED = "Recovered";
    public static final String STATUS_DECEASED = "Deceased";

    private final CovidCaseRepository covidCaseRepository;

    public DefaultDashboardService(CovidCaseRepository covidCaseRepository) {
        this.covidCaseRepository = covidCaseRepository;
    }

    @Override
    public Collection<RegionViewModel> getAllCountries() {
        List<CovidCase> allCovidCases = covidCaseRepository.findAll();
        Map<String, RegionViewModel> countryWise = new HashMap<>();
        allCovidCases.forEach(covidCase -> processCovidCase(countryWise, covidCase, covidCase.getCountry()));
        return countryWise.values();
    }

    @Override
    public Collection<RegionViewModel> getAllStates(String country) {
        List<CovidCase> byCountry = covidCaseRepository.findByCountry(country);
        Map<String, RegionViewModel> stateWise = new HashMap<>();
        byCountry.forEach(covidCase -> processCovidCase(stateWise, covidCase, covidCase.getState()));
        return stateWise.values();
    }

    private void processCovidCase(Map<String, RegionViewModel> countryWise, CovidCase covidCase, String region) {
        if (countryWise.containsKey(region)) {
            RegionViewModel model = countryWise.get(region);
            updateRegionModel(covidCase, model);
        } else {
            RegionViewModel model = new RegionViewModel();
            model.setName(region);
            updateRegionModel(covidCase, model);
            countryWise.put(region, model);
        }
    }

    private void updateRegionModel(CovidCase covidCase, RegionViewModel model) {
        switch (covidCase.getStatus().trim()) {
            case STATUS_ACTIVE:
                model.setActive(model.getActive() + 1);
                model.setConfirmed(model.getConfirmed() + 1);
                break;
            case STATUS_RECOVERED:
                model.setRecovered(model.getRecovered() + 1);
                model.setConfirmed(model.getConfirmed() + 1);
                break;
            case STATUS_DECEASED:
                model.setDeceased(model.getDeceased() + 1);
                model.setConfirmed(model.getConfirmed() + 1);
                break;
        }
    }
}
