/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.cap.telestax.args.cap2;

import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.TimeDurationChargingResult;
import pl.ovoo.ss7.wrapper.cap.args.cap2.Cap2TimeDurationChargingResultWrapper;
import pl.ovoo.ss7.wrapper.cap.args.cap2.Cap2TimeInformationWrapper;

/**
 * OcCap2TimeDurationChargingResultWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxCap2TimeDurationChargingResultWrapper implements Cap2TimeDurationChargingResultWrapper {

    private transient Cap2TimeInformationWrapper timeDurationChargingResult = null;

    private final TimeDurationChargingResult txTimeDurationChargingResult;

    public TxCap2TimeDurationChargingResultWrapper(final TimeDurationChargingResult timeDurationChargingResult) {
        this.txTimeDurationChargingResult = timeDurationChargingResult;
    }

    @Override
    public boolean hasTimeInformation() {
        return txTimeDurationChargingResult.getTimeInformation() != null;
    }

    @Override
    public Cap2TimeInformationWrapper getTimeInformation() {
        if (this.timeDurationChargingResult == null && hasTimeInformation()) {
            this.timeDurationChargingResult = new TxCap2TimeInformationWrapper(
                    txTimeDurationChargingResult.getTimeInformation());
        }
        return this.timeDurationChargingResult;
    }

    @Override
    public boolean getCallActive() {
        return txTimeDurationChargingResult.getLegActive();
    }

    public TimeDurationChargingResult getTxTimeDurationChargingResult() {
        return txTimeDurationChargingResult;
    }

    @Override
    public String toString() {
        return "TxCap2TimeDurationChargingResultWrapper [txTimeDurationChargingResult=" + txTimeDurationChargingResult
                + "]";
    }

}
