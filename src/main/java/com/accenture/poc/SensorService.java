
package com.accenture.poc;

import io.grpc.stub.StreamObserver;
import sensordata.SensorRequest;
import sensordata.SensorResponse;
import sensordata.SensorServiceGrpc;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SensorService extends SensorServiceGrpc.SensorServiceImplBase {

    @Override
    public void getSensorData(SensorRequest request, StreamObserver<SensorResponse> responseObserver) {
        // Logic to process the sensor data and generate alert
        String alertMessage = "Sensor Alert for: " + request.getSignal().getDeviceTag() + " with value: " + request.getSignal().getValue();
        SensorResponse response = SensorResponse.newBuilder()
                .setAlert(alertMessage)
                .build();

        // Sending the response back to the client
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
