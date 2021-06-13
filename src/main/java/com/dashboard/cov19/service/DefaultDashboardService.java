package com.dashboard.cov19.service;

import com.dashboard.cov19.entity.CovidCase;
import com.dashboard.cov19.model.RegionViewModel;
import com.dashboard.cov19.repository.CovidCaseRepository;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
        Map<String, RegionViewModel> countryVise = new HashMap<>();
        allCovidCases.forEach(covidCase -> processCovidCase(countryVise, covidCase, covidCase.getCountry()));
        return countryVise.values();
    }

    @Override
    public Collection<RegionViewModel> getAllStates(String country) {
        List<CovidCase> byCountry = covidCaseRepository.findByCountry(country);
        Map<String, RegionViewModel> stateVise = new HashMap<>();
        byCountry.forEach(covidCase -> processCovidCase(stateVise, covidCase, covidCase.getState()));
        return stateVise.values();
    }

    @Override
    public RegionViewModel getTodaysData() {
        long milliSeconds = ZonedDateTime.now().toInstant().toEpochMilli();
        List<CovidCase> todaysCases = covidCaseRepository.findByConfirmationDateOrDateOfClosure(new Date(milliSeconds), new Date(milliSeconds));

        Map<String, Integer> todaysData = calculateTodaysData(todaysCases);
        return createRegionModel(todaysData);
    }

    @Override
    public RegionViewModel getTodaysDataForCountry(String country) {
        long milliSeconds = ZonedDateTime.now().toInstant().toEpochMilli();
        Date currentDate = new Date(milliSeconds);
        List<CovidCase> todaysCases = covidCaseRepository.findByCountry(country);
        List<CovidCase> filteredCases = todaysCases.stream().filter(covidCase -> filterByCurrentDate(currentDate, covidCase)).collect(Collectors.toList());
        Map<String, Integer> todaysData = calculateTodaysData(filteredCases);
        return createRegionModel(todaysData);
    }

    private boolean filterByCurrentDate(Date currentDate, CovidCase covidCase) {
        Date confirmationDate = covidCase.getConfirmationDate();
        boolean isConfirmationDateSame = confirmationDate != null && confirmationDate.toString().equals(currentDate.toString());
        Date dateOfClosure = covidCase.getDateOfClosure();
        boolean isClosureDateSame = dateOfClosure != null && dateOfClosure.toString().equals(dateOfClosure.toString());
        return isConfirmationDateSame || isClosureDateSame;
    }

    private Map<String, Integer> calculateTodaysData(List<CovidCase> todaysCases) {
        Map<String, Integer> todaysData = new HashMap<>();
        for (CovidCase todaysCase : todaysCases) {
            String status = todaysCase.getStatus();
            if (todaysData.containsKey(status)) {
                int newValue = todaysData.get(status) + 1;
                todaysData.put(status, newValue);
            } else {
                todaysData.put(status, 1);
            }
        }
        return todaysData;
    }

    private RegionViewModel createRegionModel(Map<String, Integer> todaysData) {
        RegionViewModel viewModel = new RegionViewModel();
        for (String status : todaysData.keySet()) {
            Integer count = todaysData.get(status);
            if (STATUS_ACTIVE.equals(status)) {
                viewModel.setActive(count);
            } else if (STATUS_RECOVERED.equals(status)) {
                viewModel.setRecovered(count);
            } else {
                viewModel.setDeceased(count);
            }
        }
        return viewModel;
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
