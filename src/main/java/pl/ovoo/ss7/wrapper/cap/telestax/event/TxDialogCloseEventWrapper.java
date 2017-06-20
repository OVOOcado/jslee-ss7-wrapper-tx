/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.cap.telestax.event;

import org.mobicents.slee.resource.cap.events.DialogClose;
import pl.ovoo.ss7.wrapper.cap.event.DialogCloseEventWrapper;

import javax.slee.ActivityContextInterface;

/**
 * TxDialogCloseEventWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxDialogCloseEventWrapper extends TxEventWrapper implements DialogCloseEventWrapper {

    private final DialogClose dialogCloseEvent;

    public TxDialogCloseEventWrapper(final DialogClose dialogCloseEvent, final ActivityContextInterface aci) {
        super(aci, dialogCloseEvent.getWrappedEvent());
        this.dialogCloseEvent = dialogCloseEvent;
    }
}
