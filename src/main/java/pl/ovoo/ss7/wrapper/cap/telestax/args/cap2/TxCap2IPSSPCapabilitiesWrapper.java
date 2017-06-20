/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.cap.telestax.args.cap2;

import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.IPSSPCapabilities;
import pl.ovoo.ss7.wrapper.cap.args.cap2.Cap2IPSSPCapabilitiesWrapper;

/**
 * TxCap2IPSSPCapabilitiesWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxCap2IPSSPCapabilitiesWrapper implements Cap2IPSSPCapabilitiesWrapper {

    private final IPSSPCapabilities txIpsspCapabilities;

    public TxCap2IPSSPCapabilitiesWrapper(final IPSSPCapabilities ipsspCapabilities) {
        this.txIpsspCapabilities = ipsspCapabilities;
    }

    public IPSSPCapabilities getTxIpsspCapabilities() {
        return txIpsspCapabilities;
    }

    @Override
    public String toString() {
        return "TxCap2IPSSPCapabilitiesWrapper [txIpsspCapabilities=" + txIpsspCapabilities + "]";
    }

}
