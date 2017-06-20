/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.map.telestax.args;

import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.RequestedInfo;
import pl.ovoo.ss7.wrapper.map.args.MAPRequestedInfoWrapper;

/**
 * TxMAPSubscriberIdentityWrapper
 *
 * @author kacper.mosienski@ovoo.pl
 */
public class TxMAPRequestedInfoWrapper implements MAPRequestedInfoWrapper {

    private final RequestedInfo requestedInfo;

    public TxMAPRequestedInfoWrapper(final RequestedInfo requestedInfo) {
        this.requestedInfo = requestedInfo;
    }

    public RequestedInfo getTxRequestedInfo() {
        return requestedInfo;
    }

    @Override
    public String toString() {
        return "TxMAPRequestedInfoWrapper [requestedInfo=" + requestedInfo + "]";
    }

}
