package com.abinj.datanucleusmongo.application;

import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Environment;

/**
 * Created by dxuser on 8/2/17.
 */
public class MainApplication extends Application {

    public static final void main(String[] args) throws Exception {
        new MainApplication().run(args);
    }

    @Override
    public void run(Configuration configuration, Environment environment) throws Exception {

    }
}
