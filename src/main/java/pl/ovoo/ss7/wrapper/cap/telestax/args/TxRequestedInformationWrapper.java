/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.cap.telestax.args;

import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.RequestedInformation;
import pl.ovoo.ss7.wrapper.cap.args.RequestedInformationType;
import pl.ovoo.ss7.wrapper.cap.args.RequestedInformationValueWrapper;
import pl.ovoo.ss7.wrapper.cap.args.RequestedInformationWrapper;

/**
 * OcRequestedInformationWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxRequestedInformationWrapper implements RequestedInformationWrapper {

    private transient RequestedInformationValueWrapper requestedInformationValue = null;

    private final RequestedInformation txRequestedInformation;

    public TxRequestedInformationWrapper(final RequestedInformation requestedInformation) {
        this.txRequestedInformation = requestedInformation;
    }

    @Override
    public boolean hasRequestedInformationType() {
        return txRequestedInformation.getRequestedInformationType() != null;
    }

    @Override
    public RequestedInformationType getRequestedInformationType() {
        if (txRequestedInformation.getRequestedInformationType() != null) {
            return RequestedInformationType.valueOf(txRequestedInformation.getRequestedInformationType().getCode());
        }
        return null;
    }

    @Override
    public boolean hasRequestedInformationValue() {
        return true;
    }

    @Override
    public RequestedInformationValueWrapper getRequestedInformationValue() {
        if (this.requestedInformationValue == null && txRequestedInformation != null)
            this.requestedInformationValue = new TxRequestedInformationValueWrapper(txRequestedInformation);
        return this.requestedInformationValue;
    }

    public RequestedInformation getTxRequestedInformation() {
        return txRequestedInformation;
    }

    @Override
    public String toString() {
        return "TxRequestedInformationWrapper [txRequestedInformation=" + txRequestedInformation + "]";
    }

}
