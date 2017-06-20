/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.cap.telestax;

import org.mobicents.protocols.ss7.cap.api.CAPProvider;
import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.CAPDialogCircuitSwitchedCall;
import pl.ovoo.ss7.wrapper.cap.Cap3CallCapDialogWrapper;

/**
 * TxCap2CallCapDialogWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxCap3CallCapDialogWrapper extends TxCap2CallCapDialogWrapper implements Cap3CallCapDialogWrapper {

    public TxCap3CallCapDialogWrapper(final CAPDialogCircuitSwitchedCall dialogCircuitSwitchedCall, final CAPProvider capProvider) {
        super(dialogCircuitSwitchedCall, capProvider);
    }

}
