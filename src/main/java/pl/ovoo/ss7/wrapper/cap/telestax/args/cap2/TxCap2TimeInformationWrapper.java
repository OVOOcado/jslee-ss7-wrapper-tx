/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.cap.telestax.args.cap2;

import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.TimeInformation;
import pl.ovoo.ss7.wrapper.cap.args.cap2.Cap2TimeInformationWrapper;

/**
 * TxCap2TimeInformationWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxCap2TimeInformationWrapper implements Cap2TimeInformationWrapper {

    private final TimeInformation timeInformation;

    public TxCap2TimeInformationWrapper(final TimeInformation timeInformation) {
        this.timeInformation = timeInformation;
    }

    @Override
    public boolean isTimeIfNoTariffSwitchChosen() {
        return timeInformation.getTimeIfNoTariffSwitch() != null && timeInformation.getTimeIfTariffSwitch() == null;
    }

    @Override
    public Integer getTimeIfNoTariffSwitch() {
        return timeInformation.getTimeIfNoTariffSwitch();
    }

    public TimeInformation getTxTimeInformation() {
        return timeInformation;
    }

    @Override
    public String toString() {
        return "TxCap2TimeInformationWrapper [timeInformation=" + timeInformation + "]";
    }

}
