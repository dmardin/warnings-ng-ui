package edu.hm.hafner.warningsngui.ui.echart;

import edu.hm.hafner.echarts.SeriesBuilder;
import edu.hm.hafner.warningsngui.service.dto.Build;
import edu.hm.hafner.warningsngui.service.dto.Result;

import java.util.HashMap;
import java.util.Map;

/**
 * Computes the size of new and fixed issues in sum.
 *
 * @author Deniz Mardin
 */
public class NewVersusFixedAggregatedSeriesBuilder extends SeriesBuilder<Build> {

    static final String NEW = "new";
    static final String FIXED = "fixed";

    @Override
    protected Map<String, Integer> computeSeries(final Build current) {
        Map<String, Integer> series = new HashMap<>();
        if(!current.getResults().isEmpty()) {
            int newWarnings = current.getResults().stream().mapToInt(Result::getNewSize).sum();
            int fixedWarnings = current.getResults().stream().mapToInt(Result::getFixedSize).sum();
            series.put(NEW, newWarnings);
            series.put(FIXED, fixedWarnings);
        }

        return series;
    }
}
