/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.map.telestax.args;

import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.SubscriberInfo;
import pl.ovoo.ss7.wrapper.map.args.MAPLocationInformationWrapper;
import pl.ovoo.ss7.wrapper.map.args.MAPSubscriberInfoWrapper;

/**
 * TxMAPSubscriberInfoWrapper
 *
 * @author kacper.mosienski@ovoo.pl
 */
public class TxMAPSubscriberInfoWrapper implements MAPSubscriberInfoWrapper {

    private final SubscriberInfo subscriberInfo;

    public TxMAPSubscriberInfoWrapper(final SubscriberInfo subscriberInfo) {
        this.subscriberInfo = subscriberInfo;
    }

    @Override
    public boolean hasLocationInformation() {
        return subscriberInfo.getLocationInformation() != null;
    }

    @Override
    public MAPLocationInformationWrapper getLocationInformation() {
        if (subscriberInfo.getLocationInformation() != null) {
            return new TxMAPLocationInformationWrapper(subscriberInfo.getLocationInformation());
        }
        return null;
    }

    public SubscriberInfo getTxSubscriberInfo() {
        return subscriberInfo;
    }

    @Override
    public String toString() {
        return "TxMAPSubscriberInfoWrapper [subscriberInfo=" + subscriberInfo + "]";
    }

}
