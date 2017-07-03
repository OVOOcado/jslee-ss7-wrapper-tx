/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.map.telestax.args;

import org.mobicents.protocols.ss7.map.api.primitives.ISDNAddressString;
import org.mobicents.protocols.ss7.map.api.primitives.SubscriberIdentity;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.AnyTimeInterrogationRequest;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.RequestedInfo;

import pl.ovoo.ss7.wrapper.cap.args.RequestedInformationWrapper;
import pl.ovoo.ss7.wrapper.common.args.ISDNAddressStringWrapper;
import pl.ovoo.ss7.wrapper.common.telestax.TxISDNAddressStringWrapperImpl;
import pl.ovoo.ss7.wrapper.map.args.AnyTimeInterrogationArgWrapper;

/**
 * TxAnyTimeInterrogationArgWrapper
 *
 * @author kacper.mosienski@ovoo.pl
 */
public class TxAnyTimeInterrogationArgWrapper implements AnyTimeInterrogationArgWrapper {

    private transient ISDNAddressStringWrapper gsmScf = null;

    private AnyTimeInterrogationRequest anyTimeInterrogationRequest;

    public TxAnyTimeInterrogationArgWrapper(final AnyTimeInterrogationRequest anyTimeInterrogationRequest) {
        this.anyTimeInterrogationRequest = anyTimeInterrogationRequest;
    }

    public SubscriberIdentity getTxSubscriberIdentity() {
        return anyTimeInterrogationRequest.getSubscriberIdentity();
    }

    public RequestedInfo getTxRequestedInfo() {
        return anyTimeInterrogationRequest.getRequestedInfo();
    }

    public ISDNAddressString getTxGsmScfAddress() {
        return anyTimeInterrogationRequest.getGsmSCFAddress();
    }

    public AnyTimeInterrogationRequest getTxAnyTimeInterrogationRequest() {
        return anyTimeInterrogationRequest;
    }

    @Override
    public ISDNAddressStringWrapper getGsmScf() {
        if (this.gsmScf == null && anyTimeInterrogationRequest.getGsmSCFAddress() != null) {
            this.gsmScf = new TxISDNAddressStringWrapperImpl(anyTimeInterrogationRequest.getGsmSCFAddress());
        }
        return this.gsmScf;
    }

    @Override
    public String toString() {
        return "TxAnyTimeInterrogationArgWrapper [anyTimeInterrogationRequest=" + anyTimeInterrogationRequest + "]";
    }

}
