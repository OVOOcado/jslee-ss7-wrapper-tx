/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.map.telestax.event;

import org.mobicents.slee.resource.map.events.DialogReject;
import pl.ovoo.ss7.wrapper.map.event.DialogOpenRefuseEventWrapper;

import javax.slee.ActivityContextInterface;

/**
 * TxDialogOpenRefuseEventWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxDialogOpenRefuseEventWrapper extends TxMapEventWrapper implements DialogOpenRefuseEventWrapper {

    private final DialogReject dialogReject;

    public TxDialogOpenRefuseEventWrapper(final DialogReject dialogReject, final ActivityContextInterface aci) {
        super(aci);
        this.dialogReject = dialogReject;
    }
    
    @Override
    public long getInvokeId(){
    	return dialogReject.getWrappedEvent().getInvokeId();
    }
}
