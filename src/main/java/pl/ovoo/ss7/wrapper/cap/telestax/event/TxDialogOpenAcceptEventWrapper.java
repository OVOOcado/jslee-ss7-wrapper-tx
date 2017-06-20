/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.cap.telestax.event;

import org.mobicents.slee.resource.cap.events.DialogAccept;
import pl.ovoo.ss7.wrapper.cap.event.DialogOpenAcceptEventWrapper;

import javax.slee.ActivityContextInterface;

/**
 * TxDialogOpenAcceptEventWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxDialogOpenAcceptEventWrapper extends TxEventWrapper implements DialogOpenAcceptEventWrapper {

    private final DialogAccept dialogAccept;

    public TxDialogOpenAcceptEventWrapper(final DialogAccept dialogAccept, final ActivityContextInterface aci) {
        super(aci, dialogAccept.getWrappedEvent());
        this.dialogAccept = dialogAccept;
    }
}
