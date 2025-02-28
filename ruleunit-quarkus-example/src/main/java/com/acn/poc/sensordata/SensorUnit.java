package com.acn.poc.sensordata;

import com.acn.poc.dto.Signal;
import com.acn.poc.dto.SignalOutput;
import org.drools.ruleunits.api.DataStore;
import org.drools.ruleunits.api.RuleUnitData;

public class SensorUnit implements RuleUnitData {

    private DataStore<SignalOutput> alerts;

    private DataStore<Signal> signals;

    public DataStore<SignalOutput> getAlerts() {
        return this.alerts;
    }

    public void setAlerts(DataStore<SignalOutput> alerts) {
        this.alerts = alerts;
    }

    public DataStore<Signal> getSignals() {
        return this.signals;
    }

    public void setSignals(DataStore<Signal> signals) {
        this.signals = signals;
    }
}
