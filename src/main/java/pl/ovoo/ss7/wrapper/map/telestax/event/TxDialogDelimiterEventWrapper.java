/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.map.telestax.event;

import org.mobicents.slee.resource.map.events.DialogDelimiter;
import pl.ovoo.ss7.wrapper.map.event.DialogDelimiterEventWrapper;

import javax.slee.ActivityContextInterface;

/**
 * TxDialogDelimiterEventWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxDialogDelimiterEventWrapper extends TxMapEventWrapper implements DialogDelimiterEventWrapper {

    private final DialogDelimiter dialogDelimiterEvent;

    public TxDialogDelimiterEventWrapper(final DialogDelimiter dialogDelimiterEvent, final ActivityContextInterface aci) {
        super(aci);
        this.dialogDelimiterEvent = dialogDelimiterEvent;
    }
    
    @Override
    public long getInvokeId(){
    	return dialogDelimiterEvent.getWrappedEvent().getInvokeId();
    }
}
