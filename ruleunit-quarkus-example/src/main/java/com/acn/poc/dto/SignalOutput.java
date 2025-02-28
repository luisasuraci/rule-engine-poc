package com.acn.poc.dto;

public class SignalOutput {

    /**
     * Alert triggered by rule
     */
    private AlertType alert;
    /**
     * The original signal that triggered alert
     */
    private Signal signal;

    public SignalOutput(AlertType alert, Signal signal) {
        this.alert = alert;
        this.signal = signal;
    }

    public AlertType getAlert() {
        return this.alert;
    }

    public void setAlert(AlertType alert) {
        this.alert = alert;
    }

    public Signal getSignal() {
        return this.signal;
    }

    public void setSignal(Signal signal) {
        this.signal = signal;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof SignalOutput)) return false;
        final SignalOutput other = (SignalOutput) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$alert = this.getAlert();
        final Object other$alert = other.getAlert();
        if (this$alert == null ? other$alert != null : !this$alert.equals(other$alert)) return false;
        final Object this$signal = this.getSignal();
        final Object other$signal = other.getSignal();
        if (this$signal == null ? other$signal != null : !this$signal.equals(other$signal)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof SignalOutput;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $alert = this.getAlert();
        result = result * PRIME + ($alert == null ? 43 : $alert.hashCode());
        final Object $signal = this.getSignal();
        result = result * PRIME + ($signal == null ? 43 : $signal.hashCode());
        return result;
    }

    public String toString() {
        return "SignalOutput(alert=" + this.getAlert() + ", signal=" + this.getSignal() + ")";
    }
}
