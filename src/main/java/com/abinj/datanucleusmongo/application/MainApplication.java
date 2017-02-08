package com.abinj.datanucleusmongo.application;

import com.abinj.datanucleusmongo.configuration.MainConfiguration;
import com.abinj.datanucleusmongo.resource.UserResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

/**
 * Created by dxuser on 8/2/17.
 */
public class MainApplication extends Application<MainConfiguration> {

    public static final void main(String[] args) throws Exception {
        new MainApplication().run(args);
    }

    @Override
    public void run(MainConfiguration mainConfiguration, Environment environment) throws Exception {
        environment.jersey().register(new UserResource());
    }
}
