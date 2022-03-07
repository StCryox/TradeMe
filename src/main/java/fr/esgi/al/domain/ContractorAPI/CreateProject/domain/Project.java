package fr.esgi.al.domain.ContractorAPI.CreateProject.domain;

public class Project {
    private final ProjectId projectId;
    private final String projectName;

    public Project(ProjectId projectId, String projectName) {
        this.projectId = projectId;
        this.projectName = projectName;
    }

    public ProjectId getProjectId() {
        return projectId;
    }

    public String getProjectName() {
        return projectName;
    }
}
