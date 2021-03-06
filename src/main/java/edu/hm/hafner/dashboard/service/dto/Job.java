package edu.hm.hafner.dashboard.service.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * DTO that represents a {@link Job}.
 */
public class Job {
    private int id;
    private String name;
    private String url;
    private String color;
    private String lastBuildStatus;
    private List<Build> builds;

    /**
     * Creates a new instance of a {@link Job}.
     */
    Job() {
        this.builds = new ArrayList<>();
    }

    /**
     * Creates a new instance of a {@link Job}.
     *
     * @param id              the id of the {@link Job}
     * @param name            the name of the {@link Job}
     * @param url             the url of the {@link Job}
     * @param lastBuildStatus the last build status of the {@link Job}
     */
    public Job(final int id, final String name, final String url, final String lastBuildStatus) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.lastBuildStatus = lastBuildStatus;
        this.builds = new ArrayList<>();
    }

    /**
     * Returns the name of the {@link Job}.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter to set the name of the {@link Job}.
     *
     * @param name the name
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Returns the url of the {@link Job}.
     *
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * Setter to set the url of the {@link Job}.
     *
     * @param url the url
     */
    public void setUrl(final String url) {
        this.url = url;
    }

    /**
     * Returns the color of the {@link Job}.
     *
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * Setter to set the color of the {@link Job}.
     *
     * @param color the color
     */
    public void setColor(final String color) {
        this.color = color;
    }

    /**
     * Returns the {@link Build}s of the {@link Job}.
     *
     * @return the {@link Build}s
     */
    public List<Build> getBuilds() {
        return builds;
    }

    /**
     * Setter to set the {@link Build}s of the {@link Job}.
     *
     * @param builds the {@link Build}s
     */
    public void setBuilds(final List<Build> builds) {
        this.builds = builds;
    }

    /**
     * Returns the last build status of the {@link Job}.
     *
     * @return the last build status
     */
    public String getLastBuildStatus() {
        return lastBuildStatus;
    }

    /**
     * Setter to set the last build status of the {@link Job}.
     *
     * @param lastBuildStatus the last build status
     */
    public void setLastBuildStatus(final String lastBuildStatus) {
        this.lastBuildStatus = lastBuildStatus;
    }

    /**
     * Returns the id of the {@link Job}.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Setter to set the id of the {@link Job}.
     *
     * @param id the id
     */
    public void setId(final int id) {
        this.id = id;
    }

    /**
     * Adds a given {@link Build} to the {@link Job}.
     *
     * @param build the {@link Build}
     * @return the added {@link Build}
     */
    public Build addBuild(final Build build) {
        getBuilds().add(build);
        build.setJob(this);

        return build;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Job job = (Job) o;

        if (id != job.id) {
            return false;
        }
        if (!name.equals(job.name)) {
            return false;
        }
        if (!url.equals(job.url)) {
            return false;
        }
        if (color != null ? !color.equals(job.color) : job.color != null) {
            return false;
        }
        if (!lastBuildStatus.equals(job.lastBuildStatus)) {
            return false;
        }
        return builds.equals(job.builds);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + url.hashCode();
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + lastBuildStatus.hashCode();
        result = 31 * result + builds.hashCode();
        return result;
    }
}
