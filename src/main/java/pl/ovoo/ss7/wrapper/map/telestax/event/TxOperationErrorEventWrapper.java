/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.map.telestax.event;

import org.mobicents.slee.resource.map.events.ErrorComponent;
import org.mobicents.slee.resource.map.events.InvokeTimeout;
import pl.ovoo.ss7.wrapper.map.event.OperationErrorEventWrapper;

import javax.slee.ActivityContextInterface;

/**
 * TxOperationErrorEventWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxOperationErrorEventWrapper extends TxMapEventWrapper implements OperationErrorEventWrapper {

    final ErrorComponent operationErrorEvent;
    final InvokeTimeout invokeTimeout;

    public TxOperationErrorEventWrapper(final ErrorComponent operationErrorEvent, final ActivityContextInterface aci) {
        super(aci);
        this.operationErrorEvent = operationErrorEvent;
        this.invokeTimeout = null;
    }

    public TxOperationErrorEventWrapper(final InvokeTimeout invokeTimeout, final ActivityContextInterface aci) {
        super(aci);
        this.operationErrorEvent = null;
        this.invokeTimeout = invokeTimeout;
    }
    
    @Override
    public long getInvokeId(){
    	return operationErrorEvent.getInvokeId();
    }
}
