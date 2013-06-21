Description:
------------

This is a community copy of Oracle's JavadocUpdaterTool to address a security vulnerability 
http://www.oracle.com/technetwork/java/javase/downloads/java-doc-updater-tool-1955731.html

To address the security alert CVE-2013-1571, this tool is intended to repair-in-place, 
the HTML files generated by the javadoc tool versions 5u45, 6u45, 7u21 and earlier. 

System requirements:
--------------------

This tool can be run on Windows, Solaris, Linux and Mac OS X operating systems 
for which an official Oracle JRE version is available. Oracle JRE v. 1.7 or greater 
is required.

To scan the javadoc tree for applicable files, the user must have read access to the  
directory it resides in and to all its sub directories. 

To fix the  applicable files, the user running the tool must have read and write 
permissions to the files as well as to the directories that contain these files.

Usage:
------

To run the tool, the user must know the location of the java executable 
and the location of the directory where the javadoc tree resides.

To scan for potential vulnerabilities, run the following command from the 
directory in which the JavadocPatchTool.jar file is located:

java -jar JavadocPatchTool.jar -R -C <Path_to_Javadoc>

where <Path_to_Javadoc> is the path to the directory where the potentially 
vulnerable javadoc tree resides. If the tool finds any applicable HTML files, 
it will print out a list of such files.

To fix a single applicable file, run the following command:

java -jar JavadocPatchTool.jar <Path_to_folder>

where <Path_to_folder> is the path to the directory which contains the applicable file. 

To fix all the applicable files in the tree, run the following command:

java -jar JavadocPatchTool.jar -R <Path_to_Javadoc>

Build it:
------

git clone https://github.com/olamy/JavadocUpdaterTool.git && cd JavadocUpdaterTool

mvn clean install

java -jar target/javadoc-updater-maven-plugin-0.1-SNAPSHOT.jar -R -C <Path_to_Javadoc>

Maven Usage:
------

      <plugin>
        <groupId>org.olamy.maven.plugins</groupId>
        <artifactId>javadoc-updater-maven-plugin</artifactId>
        <version>0.1-SNAPSHOT</version>
        <executions>
          <execution>
            <phase>site</phase>
            <goals>
              <goal>fixjavadoc</goal>
            </goals>
            <configuration>
              <!-- by default check target/site if apidocs are not here change the value
              <directory>${project.reporting.outputDirectory}</directory>
              -->
            </configuration>
          </execution>
        </executions>
      </plugin>

