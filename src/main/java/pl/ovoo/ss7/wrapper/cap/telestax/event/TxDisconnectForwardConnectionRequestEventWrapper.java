/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.cap.telestax.event;

import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.DisconnectForwardConnectionRequest;
import pl.ovoo.ss7.wrapper.cap.event.DisconnectForwardConnectionRequestEventWrapper;

import javax.slee.ActivityContextInterface;

/**
 * TxDisconnectForwardConnectionRequestEventWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxDisconnectForwardConnectionRequestEventWrapper extends TxEventWrapper implements DisconnectForwardConnectionRequestEventWrapper {

    private final DisconnectForwardConnectionRequest disconnectForwardConnectionRequest;

    public TxDisconnectForwardConnectionRequestEventWrapper(final DisconnectForwardConnectionRequest disconnectForwardConnectionRequest, final ActivityContextInterface aci) {
        super(aci, disconnectForwardConnectionRequest);
        this.disconnectForwardConnectionRequest = disconnectForwardConnectionRequest;
    }
}
