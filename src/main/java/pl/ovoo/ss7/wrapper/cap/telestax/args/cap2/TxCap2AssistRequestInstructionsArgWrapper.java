/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.cap.telestax.args.cap2;

import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.IPSSPCapabilities;
import pl.ovoo.ss7.wrapper.cap.args.cap2.Cap2AssistRequestInstructionsArgWrapper;
import pl.ovoo.ss7.wrapper.cap.args.cap2.Cap2IPSSPCapabilitiesWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.TxAssistRequestInstructionsArgWrapper;

/**
 * TxAssistRequestInstructionsArgWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxCap2AssistRequestInstructionsArgWrapper extends TxAssistRequestInstructionsArgWrapper
        implements Cap2AssistRequestInstructionsArgWrapper {

    private transient Cap2IPSSPCapabilitiesWrapper cap2ipsspCapabilitiesWrapper = null;

    private IPSSPCapabilities txIpsspCapabilities;

    @Override
    public void setIPSSPCapabilitiesWrapper(final Cap2IPSSPCapabilitiesWrapper ipsspCapabilitiesWrapper) {
        if (ipsspCapabilitiesWrapper == null) {
            this.txIpsspCapabilities = null;
            this.cap2ipsspCapabilitiesWrapper = null;
        } else {
            final TxCap2IPSSPCapabilitiesWrapper txCap2IPSSPCapabilitiesWrapper = (TxCap2IPSSPCapabilitiesWrapper) ipsspCapabilitiesWrapper;
            this.txIpsspCapabilities = txCap2IPSSPCapabilitiesWrapper.getTxIpsspCapabilities();
            this.cap2ipsspCapabilitiesWrapper = txCap2IPSSPCapabilitiesWrapper;
        }
    }

    public IPSSPCapabilities getTxIpsspCapabilities() {
        return txIpsspCapabilities;
    }

    public void setTxIpsspCapabilities(final IPSSPCapabilities txIpsspCapabilities) {
        this.txIpsspCapabilities = txIpsspCapabilities;
        this.cap2ipsspCapabilitiesWrapper = null;
    }

    @Override
    public String toString() {
        return "TxCap2AssistRequestInstructionsArgWrapper [txIpsspCapabilities=" + txIpsspCapabilities + "]";
    }

}
