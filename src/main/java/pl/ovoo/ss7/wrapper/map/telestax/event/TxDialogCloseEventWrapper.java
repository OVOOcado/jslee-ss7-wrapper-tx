/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.map.telestax.event;

import org.mobicents.slee.resource.map.events.DialogClose;
import pl.ovoo.ss7.wrapper.map.event.DialogCloseEventWrapper;

import javax.slee.ActivityContextInterface;

/**
 * TxDialogCloseEventWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxDialogCloseEventWrapper extends TxMapEventWrapper implements DialogCloseEventWrapper {

    private final DialogClose dialogClose;

    public TxDialogCloseEventWrapper(final DialogClose dialogClose, final ActivityContextInterface aci) {
        super(aci);
        this.dialogClose = dialogClose;
    }
    
    @Override
    public long getInvokeId(){
    	return dialogClose.getWrappedEvent().getInvokeId();
    }
}
