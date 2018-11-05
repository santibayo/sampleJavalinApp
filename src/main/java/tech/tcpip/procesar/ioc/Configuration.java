package tech.tcpip.procesar.ioc;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tech.tcpip.procesar.operations.Command;
import tech.tcpip.procesar.operations.ProcesarCommand;

public class Configuration extends AbstractModule {
    private final Logger logger = LoggerFactory.getLogger(Configuration.class);
    @Override
    protected void configure() {

    }

    @Provides
    @Singleton
    public Command getCommand(){
        return new ProcesarCommand();
    }



}
