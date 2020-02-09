package edu.hm.hafner.warningsngui.ui.table.build;

import io.jenkins.plugins.datatables.api.TableColumn;
import io.jenkins.plugins.datatables.api.TableModel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Configures the structure for the table that contains the builds statistics.
 *
 * @author Deniz Mardin
 */
public class BuildTableModel extends TableModel {


    private final BuildRepositoryStatistics buildRepositoryStatistics;

    /**
     * Creates a new instance of {@link BuildTableModel}.
     *
     * @param buildRepositoryStatistics the repository with the build statistics
     */
    public BuildTableModel(BuildRepositoryStatistics buildRepositoryStatistics) {
        this.buildRepositoryStatistics = buildRepositoryStatistics;
    }

    /**
     * Returns the id of the {@link BuildTableModel}.
     *
     * @return the id of the {@link BuildTableModel}
     */
    @Override
    public String getId() {
        return "builds";
    }

    /**
     * Provides the configured columns of the {@link BuildTableModel}.
     *
     * @return the columns of the table
     */
    @Override
    public List<TableColumn> getColumns() {
        List<TableColumn> columns = new ArrayList<>();
        columns.add(new TableColumn("Build Number","buildNumber"));
        columns.add(new TableColumn("Url","buildUrl"));

        return columns;
    }

    /**
     * Provides the rows for the {@link BuildTableModel}.
     *
     * @return the rows of the table
     */
    @Override
    public List<Object> getRows() {
        return buildRepositoryStatistics.getBuildStatistics().stream().map(BuildTableModel.BuildsRow::new).collect(Collectors.toList());
    }

    /**
     * A single line in the table that contains the statistics of a build.
     */
    public static class BuildsRow {

        private final BuildStatistics buildStatistics;

        /**
         * Creates a new instance of a {@link BuildTableModel.BuildsRow}
         *
         * @param buildStatistics the build statistic for one line
         */
        BuildsRow(final BuildStatistics buildStatistics){
            this.buildStatistics = buildStatistics;
        }

        /**
         * Returns the build number of the build.
         *
         * @return the name
         */
        public int getBuildNumber() {
            return buildStatistics.getBuildNumber();
        }

        /**
         * Returns the url of the build.
         *
         * @return the url
         */
        public String getBuildUrl() {
            return buildStatistics.getBuildUrl();
        }
    }
}
