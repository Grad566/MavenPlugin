package org.plugin;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.project.MavenProject;
import org.apache.maven.model.Developer;

import java.util.List;

@Mojo(name = "developer-info", defaultPhase = LifecyclePhase.INITIALIZE)
public class DeveloperInfoMojo extends AbstractMojo {

    @Parameter(defaultValue = "${project}", required = true)
    private MavenProject project;

    public void execute() {
        getLog().info("Developer Information:");

        List<Developer> developers = project.getDevelopers();
        if (developers != null && !developers.isEmpty()) {
            for (Developer developer : developers) {
                getLog().info("Name: " + developer.getName());
                getLog().info("Email: " + developer.getEmail());
                getLog().info("URL: " + developer.getUrl());
                getLog().info("Roles: " + developer.getRoles());
                getLog().info("Timezone: " + developer.getTimezone());
                getLog().info("Organization: " + developer.getOrganization());
            }
        } else {
            getLog().info("No developers found.");
        }
    }
}

