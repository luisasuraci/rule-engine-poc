package com.acn.poc.dto;

/**
 * A Single signal inside the telemetry packet message
 */
public class Signal {
    private String automation;
    private String mId;
    private String assistModuleCode;
    private String ioSystem;
    private String systemCode;
    private String hwSl;
    private String deviceTag;
    private String description;
    private String pieceNumber;
    private String unit;
    private String protocol;
    private Float value;

    public Signal() {
    }

    public String getAutomation() {
        return this.automation;
    }

    public void setAutomation(String automation) {
        this.automation = automation;
    }

    public String getMId() {
        return this.mId;
    }

    public void setMId(String mId) {
        this.mId = mId;
    }

    public String getAssistModuleCode() {
        return this.assistModuleCode;
    }

    public void setAssistModuleCode(String assistModuleCode) {
        this.assistModuleCode = assistModuleCode;
    }

    public String getIoSystem() {
        return this.ioSystem;
    }

    public void setIoSystem(String ioSystem) {
        this.ioSystem = ioSystem;
    }

    public String getSystemCode() {
        return this.systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }

    public String getHwSl() {
        return this.hwSl;
    }

    public void setHwSl(String hwSl) {
        this.hwSl = hwSl;
    }

    public String getDeviceTag() {
        return this.deviceTag;
    }

    public void setDeviceTag(String deviceTag) {
        this.deviceTag = deviceTag;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPieceNumber() {
        return this.pieceNumber;
    }

    public void setPieceNumber(String pieceNumber) {
        this.pieceNumber = pieceNumber;
    }

    public String getUnit() {
        return this.unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getProtocol() {
        return this.protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public Float getValue() {
        return this.value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Signal)) return false;
        final Signal other = (Signal) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$automation = this.getAutomation();
        final Object other$automation = other.getAutomation();
        if (this$automation == null ? other$automation != null : !this$automation.equals(other$automation))
            return false;
        final Object this$mId = this.getMId();
        final Object other$mId = other.getMId();
        if (this$mId == null ? other$mId != null : !this$mId.equals(other$mId)) return false;
        final Object this$assistModuleCode = this.getAssistModuleCode();
        final Object other$assistModuleCode = other.getAssistModuleCode();
        if (this$assistModuleCode == null ? other$assistModuleCode != null : !this$assistModuleCode.equals(other$assistModuleCode))
            return false;
        final Object this$ioSystem = this.getIoSystem();
        final Object other$ioSystem = other.getIoSystem();
        if (this$ioSystem == null ? other$ioSystem != null : !this$ioSystem.equals(other$ioSystem)) return false;
        final Object this$systemCode = this.getSystemCode();
        final Object other$systemCode = other.getSystemCode();
        if (this$systemCode == null ? other$systemCode != null : !this$systemCode.equals(other$systemCode))
            return false;
        final Object this$hwSl = this.getHwSl();
        final Object other$hwSl = other.getHwSl();
        if (this$hwSl == null ? other$hwSl != null : !this$hwSl.equals(other$hwSl)) return false;
        final Object this$deviceTag = this.getDeviceTag();
        final Object other$deviceTag = other.getDeviceTag();
        if (this$deviceTag == null ? other$deviceTag != null : !this$deviceTag.equals(other$deviceTag)) return false;
        final Object this$description = this.getDescription();
        final Object other$description = other.getDescription();
        if (this$description == null ? other$description != null : !this$description.equals(other$description))
            return false;
        final Object this$pieceNumber = this.getPieceNumber();
        final Object other$pieceNumber = other.getPieceNumber();
        if (this$pieceNumber == null ? other$pieceNumber != null : !this$pieceNumber.equals(other$pieceNumber))
            return false;
        final Object this$unit = this.getUnit();
        final Object other$unit = other.getUnit();
        if (this$unit == null ? other$unit != null : !this$unit.equals(other$unit)) return false;
        final Object this$protocol = this.getProtocol();
        final Object other$protocol = other.getProtocol();
        if (this$protocol == null ? other$protocol != null : !this$protocol.equals(other$protocol)) return false;
        final Object this$value = this.getValue();
        final Object other$value = other.getValue();
        if (this$value == null ? other$value != null : !this$value.equals(other$value)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Signal;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $automation = this.getAutomation();
        result = result * PRIME + ($automation == null ? 43 : $automation.hashCode());
        final Object $mId = this.getMId();
        result = result * PRIME + ($mId == null ? 43 : $mId.hashCode());
        final Object $assistModuleCode = this.getAssistModuleCode();
        result = result * PRIME + ($assistModuleCode == null ? 43 : $assistModuleCode.hashCode());
        final Object $ioSystem = this.getIoSystem();
        result = result * PRIME + ($ioSystem == null ? 43 : $ioSystem.hashCode());
        final Object $systemCode = this.getSystemCode();
        result = result * PRIME + ($systemCode == null ? 43 : $systemCode.hashCode());
        final Object $hwSl = this.getHwSl();
        result = result * PRIME + ($hwSl == null ? 43 : $hwSl.hashCode());
        final Object $deviceTag = this.getDeviceTag();
        result = result * PRIME + ($deviceTag == null ? 43 : $deviceTag.hashCode());
        final Object $description = this.getDescription();
        result = result * PRIME + ($description == null ? 43 : $description.hashCode());
        final Object $pieceNumber = this.getPieceNumber();
        result = result * PRIME + ($pieceNumber == null ? 43 : $pieceNumber.hashCode());
        final Object $unit = this.getUnit();
        result = result * PRIME + ($unit == null ? 43 : $unit.hashCode());
        final Object $protocol = this.getProtocol();
        result = result * PRIME + ($protocol == null ? 43 : $protocol.hashCode());
        final Object $value = this.getValue();
        result = result * PRIME + ($value == null ? 43 : $value.hashCode());
        return result;
    }

    public String toString() {
        return "Signal(automation=" + this.getAutomation() + ", mId=" + this.getMId() + ", assistModuleCode=" + this.getAssistModuleCode() + ", ioSystem=" + this.getIoSystem() + ", systemCode=" + this.getSystemCode() + ", hwSl=" + this.getHwSl() + ", deviceTag=" + this.getDeviceTag() + ", description=" + this.getDescription() + ", pieceNumber=" + this.getPieceNumber() + ", unit=" + this.getUnit() + ", protocol=" + this.getProtocol() + ", value=" + this.getValue() + ")";
    }
}
