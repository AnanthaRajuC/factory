package pl.com.bottega.factory.demand.forecasting;

import lombok.AllArgsConstructor;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.SortedMap;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

@AllArgsConstructor
public class Document {

    private final Instant created;
    private final String refNo;
    private final SortedMap<LocalDate, Demand> demands;

    List<DailyDemand.Result> forEachStartingFrom(LocalDate date, BiFunction<LocalDate, Demand, DailyDemand.Result> f) {
        return demands.entrySet().stream()
                .filter(e -> !e.getKey().isBefore(date))
                .map(e -> f.apply(e.getKey(), e.getValue()))
                .collect(Collectors.toList());
    }

    public String getRefNo() {
        return refNo;
    }
}
