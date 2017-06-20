/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.map.telestax.event;

import org.mobicents.slee.resource.map.events.DialogRelease;
import pl.ovoo.ss7.wrapper.map.event.DialogReleaseEventWrapper;

import javax.slee.ActivityContextInterface;

/**
 * TxDialogCloseEventWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxDialogReleaseEventWrapper extends TxMapEventWrapper implements DialogReleaseEventWrapper {

    private final DialogRelease dialogRelease;

    public TxDialogReleaseEventWrapper(final DialogRelease dialogRelease, final ActivityContextInterface aci) {
        super(aci);
        this.dialogRelease = dialogRelease;
    }
    
    @Override
    public long getInvokeId(){
    	return dialogRelease.getWrappedEvent().getInvokeId();
    }
}
