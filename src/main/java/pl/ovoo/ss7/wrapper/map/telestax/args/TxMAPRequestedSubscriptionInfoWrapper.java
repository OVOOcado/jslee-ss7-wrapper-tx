/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.map.telestax.args;

import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.RequestedSubscriptionInfo;
import pl.ovoo.ss7.wrapper.map.args.MAPRequestedSubscriptionInfoWrapper;

/**
 * TxMAPRequestedSubscriptionInfoWrapper
 *
 * @author kacper.mosienski@ovoo.pl
 */
public class TxMAPRequestedSubscriptionInfoWrapper implements MAPRequestedSubscriptionInfoWrapper {

    private final RequestedSubscriptionInfo requestedSubscriptionInfo;

    public TxMAPRequestedSubscriptionInfoWrapper(final RequestedSubscriptionInfo requestedSubscriptionInfo) {
        this.requestedSubscriptionInfo = requestedSubscriptionInfo;
    }

    public RequestedSubscriptionInfo getTxRequestedSubscriptionInfo() {
        return requestedSubscriptionInfo;
    }

    @Override
    public String toString() {
        return "TxMAPRequestedSubscriptionInfoWrapper [requestedSubscriptionInfo=" + requestedSubscriptionInfo + "]";
    }

}
