package com.maranellored.dropwizard.test;

import com.offbytwo.jenkins.JenkinsServer;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Environment;
import java.net.URI;
import java.net.URL;

public class ExampleApplication extends Application<Configuration> {

  public static void main(String[] args) throws Exception {
      new ExampleApplication().run(args);
    }


  @Override
  public void run(Configuration configuration, Environment environment) throws Exception {
    ClassLoader classLoader = getClass().getClassLoader();
    URL resource = classLoader.getResource("org/apache/http/message/BasicLineFormatter.class");
    System.out.println(resource);

    JenkinsServer jenkins =
        new JenkinsServer(new URI("https://test.jenkins.com"), "user", "password");

    // This code does nothing
    //environment.jersey().register(jenkins);
  }

}
