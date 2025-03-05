package com.acn.poc.sensordata;

import com.acn.poc.grpc.*;
import io.grpc.stub.StreamObserver;
import io.quarkus.grpc.GrpcService;
import io.quarkus.logging.Log;
import jakarta.inject.Inject;
import org.drools.ruleunits.api.RuleUnit;
import org.drools.ruleunits.api.RuleUnitInstance;
import org.drools.ruleunits.impl.datasources.ListDataStore;

@GrpcService
public class SensorServiceImpl extends SensorServiceGrpc.SensorServiceImplBase {

    @Inject
    RuleUnit<SensorUnit> sensorUnitRuleUnit;  // ✅ Iniezione della RuleUnit in Quarkus

    @Override
    public void applyRules(SensorRequest request, StreamObserver<RuleEngineResponse> responseObserver) {
        // Creazione del RuleUnitData
        SensorUnit sensorUnitData = new SensorUnit();

        // Mapping gRPC -> DTO (Usiamo un metodo helper per la conversione)
        request.getSignalsList().stream()
                .forEach(sensorUnitData.getSignals()::add);  // ✅ DataStore inizializzato

        // Creazione della RuleUnitInstance ed esecuzione delle regole
        RuleUnitInstance<SensorUnit> instance = sensorUnitRuleUnit.createInstance(sensorUnitData);
        instance.fire();  // 🔥 Avvia il motore di regole

        // Mapping DTO -> gRPC Response (Usiamo un altro metodo helper per semplificare)
        RuleEngineResponse.Builder responseBuilder = RuleEngineResponse.newBuilder();
        ((ListDataStore) sensorUnitData.getAlerts())
                .forEach( alert -> {
                    SignalOutput finalSignal = (SignalOutput) alert;
                    responseBuilder.addSignals(finalSignal);
                });

        // Invio della risposta
        responseObserver.onNext(responseBuilder.build());
        responseObserver.onCompleted();
    }


    @Override
    public void getSensorData(SensorRequest request, StreamObserver<SensorResponse> responseObserver) {
        if (request.getSignalsCount() > 0) {
            Signal firstSignal = request.getSignals(0);
            String alertMessage = "Alert for device " + firstSignal.getDeviceTag() +
                    " with value: " + firstSignal.getValue();
            SensorResponse response = SensorResponse.newBuilder()
                    .setAlert(alertMessage)
                    .build();
            responseObserver.onNext(response);
        } else {
            SensorResponse response = SensorResponse.newBuilder()
                    .setAlert("No signals provided")
                    .build();
            responseObserver.onNext(response);
        }
        responseObserver.onCompleted();
    }
}