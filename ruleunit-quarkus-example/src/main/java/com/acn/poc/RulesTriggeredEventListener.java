package com.acn.poc;

import io.quarkus.logging.Log;
import org.drools.core.event.DefaultAgendaEventListener;
import org.kie.api.event.rule.AfterMatchFiredEvent;

public class RulesTriggeredEventListener extends DefaultAgendaEventListener {
    @Override
    public void afterMatchFired(AfterMatchFiredEvent event) {
        super.afterMatchFired(event);
        Log.infof("triggered rule %s", event.getMatch().getRule().getName());
    }
}
