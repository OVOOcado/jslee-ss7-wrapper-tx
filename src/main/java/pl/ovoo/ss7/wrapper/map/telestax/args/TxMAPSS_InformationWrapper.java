/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.map.telestax.args;

import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.ExtSSInfo;
import pl.ovoo.ss7.wrapper.map.args.MAPForwardingInfoWrapper;
import pl.ovoo.ss7.wrapper.map.args.MAPSS_InformationWrapper;

/**
 * TxMAPSS_InformationWrapper
 *
 * @author kacper.mosienski@ovoo.pl
 */
public class TxMAPSS_InformationWrapper implements MAPSS_InformationWrapper {

    private final ExtSSInfo extSSInfo;

    public TxMAPSS_InformationWrapper(final ExtSSInfo extSSInfo) {
        this.extSSInfo = extSSInfo;
    }

    @Override
    public MAPForwardingInfoWrapper getForwardingInfo() {
        return new TxMAPForwardingInfoWrapper(extSSInfo.getForwardingInfo());
    }

    public ExtSSInfo getTxExtSSInfo() {
        return extSSInfo;
    }

    @Override
    public String toString() {
        return "TxMAPSS_InformationWrapper [extSSInfo=" + extSSInfo + "]";
    }

}
