package edu.hm.hafner.warningsngui.ui.table.issue;

import io.jenkins.plugins.datatables.api.TableModel;

import java.util.List;

/**
 * Model to view a table that contains the issues.
 *
 * @author Deniz Mardin
 */
public class IssueViewTable {

    private final IssueRepositoryStatistics issueRepositoryStatistics;

    /**
     * Creates a new instance of the {@link IssueViewTable}.
     *
     * @param issueRepositoryStatistics the repository with the issue statistics for the table
     */
    public IssueViewTable(IssueRepositoryStatistics issueRepositoryStatistics) {
        this.issueRepositoryStatistics = issueRepositoryStatistics;
    }

    /**
     * Returns the {@link IssueViewTable}.
     *
     * @param id the id of the table
     * @return the {@link IssueViewTable}
     */
    public TableModel getTableModel(String id) {
        IssueTableModel issueTableModel = new IssueTableModel(issueRepositoryStatistics);
        if(issueTableModel.getId().equals(id)){
            return issueTableModel;
        }
        else {
            throw new IllegalArgumentException(String.format("Needed id for this IssueTableModel is issues but currently used %s", id));
        }
    }

    /**
     * Returns the rows of the {@link IssueViewTable}.
     *
     * @param id the id of the {@link IssueViewTable}
     * @return the rows of the {@link IssueViewTable}
     */
    public List<Object> getTableRows(final String id) {
        return getTableModel(id).getRows();
    }
}