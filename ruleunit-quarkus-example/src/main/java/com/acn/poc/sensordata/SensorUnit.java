package com.acn.poc.sensordata;

import com.acn.poc.grpc.Signal;
import com.acn.poc.grpc.SignalOutput;
import org.drools.ruleunits.api.DataSource;
import org.drools.ruleunits.api.DataStore;
import org.drools.ruleunits.api.RuleUnitData;

public class SensorUnit implements RuleUnitData {

    private DataStore<SignalOutput> alerts;

    private DataStore<Signal> signals;

    public SensorUnit() {
        this(DataSource.createStore(), DataSource.createStore());
    }

    public SensorUnit(DataStore<Signal> signals, DataStore<SignalOutput> signalOutput) {
        this.signals = signals;
        this.alerts = signalOutput;
    }

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
