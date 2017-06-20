/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.cap.telestax.event;

import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.ContinueRequest;
import pl.ovoo.ss7.wrapper.cap.event.ContinueRequestEventWrapper;

import javax.slee.ActivityContextInterface;

/**
 * TxContinueRequestEventWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxContinueRequestEventWrapper extends TxEventWrapper implements ContinueRequestEventWrapper {

    private final ContinueRequest continueRequest;

    public TxContinueRequestEventWrapper(final ContinueRequest continueRequest, final ActivityContextInterface aci) {
        super(aci, continueRequest);
        this.continueRequest = continueRequest;
    }
}
