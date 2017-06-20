/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.map.telestax.event;

import org.mobicents.slee.resource.map.events.DialogProviderAbort;
import pl.ovoo.ss7.wrapper.cap.args.PAbortCauseType;
import pl.ovoo.ss7.wrapper.map.event.DialogProviderAbortEventWrapper;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.slee.ActivityContextInterface;

/**
 * TxDialogProviderAbortEventWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxDialogProviderAbortEventWrapper extends TxMapEventWrapper implements DialogProviderAbortEventWrapper {

    private final DialogProviderAbort dialogProviderAbortEvent;

    public TxDialogProviderAbortEventWrapper(final DialogProviderAbort dialogProviderAbortEvent, final ActivityContextInterface aci) {
        super(aci);
        this.dialogProviderAbortEvent = dialogProviderAbortEvent;
    }

    @Override
    public PAbortCauseType getPeerAbortCause() {
    	throw  new NotImplementedException();

    }
    
    @Override
    public long getInvokeId(){
    	return dialogProviderAbortEvent.getWrappedEvent().getInvokeId();
    }
}
