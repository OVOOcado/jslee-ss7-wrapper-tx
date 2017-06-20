/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.map.telestax.event;

import org.mobicents.slee.resource.map.events.DialogUserAbort;
import pl.ovoo.ss7.wrapper.map.event.DialogUserAbortEventWrapper;

import javax.slee.ActivityContextInterface;

/**
 * TxDialogUserAbortEventWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxDialogUserAbortEventWrapper extends TxMapEventWrapper implements DialogUserAbortEventWrapper {

    private final DialogUserAbort dialogUserAbortEvent;

    public TxDialogUserAbortEventWrapper(final DialogUserAbort dialogUserAbortEvent, final ActivityContextInterface aci) {
        super(aci);
        this.dialogUserAbortEvent = dialogUserAbortEvent;
    }

    @Override
    public String toString() {
        return "TxDialogUserAbortEventWrapper{" +
                "dialogUserAbortEvent=" + dialogUserAbortEvent +
                '}';
    }
    
    @Override
    public Object[] getUserInformation(){
		return new Object [] { this.dialogUserAbortEvent.getUserReason() };
    }
    
    @Override
    public long getInvokeId(){
    	return dialogUserAbortEvent.getWrappedEvent().getInvokeId();
    }
}
