/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.cap.telestax.event;

import org.mobicents.slee.resource.cap.events.DialogRelease;
import pl.ovoo.ss7.wrapper.cap.event.DialogOpenRefuseEventWrapper;

import javax.slee.ActivityContextInterface;

/**
 * TxDialogOpenRefuseEventWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxDialogOpenRefuseEventWrapper extends TxEventWrapper implements DialogOpenRefuseEventWrapper {

    private final DialogRelease dialogRelease;

    public TxDialogOpenRefuseEventWrapper(final DialogRelease dialogRelease, final ActivityContextInterface aci) {
        super(aci, dialogRelease.getWrappedEvent());
        this.dialogRelease = dialogRelease;
    }
}
