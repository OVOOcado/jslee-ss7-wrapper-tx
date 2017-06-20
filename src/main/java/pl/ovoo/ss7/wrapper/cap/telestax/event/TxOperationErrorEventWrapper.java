/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.cap.telestax.event;

import org.mobicents.slee.resource.cap.events.ErrorComponent;
import org.mobicents.slee.resource.cap.events.InvokeTimeout;
import pl.ovoo.ss7.wrapper.cap.event.OperationErrorEventWrapper;

import javax.slee.ActivityContextInterface;

/**
 * TxOperationErrorEventWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxOperationErrorEventWrapper extends TxEventWrapper implements OperationErrorEventWrapper {

    final ErrorComponent operationErrorEvent;
    final InvokeTimeout invokeTimeout;

    public TxOperationErrorEventWrapper(final ErrorComponent operationErrorEvent, final ActivityContextInterface aci) {
        super(aci, operationErrorEvent.getWrappedEvent());
        this.operationErrorEvent = operationErrorEvent;
        this.invokeTimeout = null;
    }

    public TxOperationErrorEventWrapper(final InvokeTimeout invokeTimeout, final ActivityContextInterface aci) {
        super(aci, invokeTimeout.getWrappedEvent());
        this.operationErrorEvent = null;
        this.invokeTimeout = invokeTimeout;
    }
}
