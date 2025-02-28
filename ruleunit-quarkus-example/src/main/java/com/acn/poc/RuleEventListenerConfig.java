package com.acn.poc;

import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.drools.core.event.DebugAgendaEventListener;
import org.drools.core.event.DebugRuleRuntimeEventListener;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.kie.kogito.drools.core.config.DefaultRuleEventListenerConfig;

@ApplicationScoped
public class RuleEventListenerConfig extends DefaultRuleEventListenerConfig {

    @Inject
    public RuleEventListenerConfig(@ConfigProperty(name = "com.acn.poc.debug.rule", defaultValue = "false") String debugRule,
                                   @ConfigProperty(name = "com.acn.poc.debug.agenda", defaultValue = "false") String debugAgenda,
                                   @ConfigProperty(name = "com.acn.poc.debug.custom", defaultValue = "false") String debugCustom) {
        Log.infof("log startup configuration debugRule '%s' debugAgenda '%s'  debugCustom '%s'", debugRule, debugAgenda, debugCustom);
        if (Boolean.parseBoolean(debugRule)) {
            //write to log info when data is changed from request
            register(new DebugRuleRuntimeEventListener());
        }
        if (Boolean.parseBoolean(debugAgenda)) {
            register(new DebugAgendaEventListener());
        }
        if (Boolean.parseBoolean(debugCustom)) {
            register(new RulesTriggeredEventListener());
        }
    }

}
