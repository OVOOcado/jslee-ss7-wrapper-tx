/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.map.telestax.event;

import javax.slee.ActivityContextInterface;

import org.mobicents.slee.resource.map.events.DialogAccept;

import pl.ovoo.ss7.wrapper.map.event.DialogOpenAcceptEventWrapper;

/**
 * TxDialogOpenAcceptEventWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxDialogOpenAcceptEventWrapper extends TxMapEventWrapper implements DialogOpenAcceptEventWrapper {

    private final DialogAccept dialogAccept;

    public TxDialogOpenAcceptEventWrapper(final DialogAccept dialogAccept, final ActivityContextInterface aci) {
        super(aci);
        this.dialogAccept = dialogAccept;
    }
    
    @Override
    public long getInvokeId(){
    	return dialogAccept.getWrappedEvent().getInvokeId();
    }
}
