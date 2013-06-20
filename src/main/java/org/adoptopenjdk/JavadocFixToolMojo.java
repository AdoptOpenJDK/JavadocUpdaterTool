package org.adoptopenjdk;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

/**
 * @author Olivier Lamy
 */
@Mojo( name = "fixjavadoc" )
public class JavadocFixToolMojo
    extends AbstractMojo
{

    @Parameter( defaultValue = "${project.reporting.outputDirectory}" )
    private String directory;

    @Parameter( defaultValue = "true" )
    private boolean recurse = true;

    @Parameter( defaultValue = "false" )
    private boolean doPatch;

    @Override
    public void execute()
        throws MojoExecutionException, MojoFailureException
    {
        getLog().info(
            "JavadocFixToolMojo proceed directory: '" + directory + "', recurse: '" + recurse + "', doPatch: '"
                + doPatch + "'" );
        new JavadocFixTool( doPatch, recurse ).proceed( directory );
    }
}
