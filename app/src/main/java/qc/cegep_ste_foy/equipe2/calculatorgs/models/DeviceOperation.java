package qc.cegep_ste_foy.equipe2.calculatorgs.models;

/**
 * Created by Vicente on 4/28/2015.
 */
public class DeviceOperation {
    private String deviceId;
    private String operation;

    public DeviceOperation(String deviceId, String operation) {
        this.deviceId = deviceId;
        this.operation = operation;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}
