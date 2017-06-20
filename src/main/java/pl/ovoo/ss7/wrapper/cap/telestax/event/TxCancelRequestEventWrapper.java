/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.cap.telestax.event;

import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.CancelRequest;
import pl.ovoo.ss7.wrapper.cap.event.CancelRequestEventWrapper;

import javax.slee.ActivityContextInterface;

/**
 * TxDisconnectForwardConnectionRequestEventWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxCancelRequestEventWrapper extends TxEventWrapper implements CancelRequestEventWrapper {

    private final CancelRequest cancelRequest;

    public TxCancelRequestEventWrapper(final CancelRequest cancelRequest, final ActivityContextInterface aci) {
        super(aci, cancelRequest);
        this.cancelRequest = cancelRequest;
    }
}
