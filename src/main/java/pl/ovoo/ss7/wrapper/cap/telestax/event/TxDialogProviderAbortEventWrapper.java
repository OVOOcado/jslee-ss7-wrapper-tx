/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.cap.telestax.event;

import org.mobicents.slee.resource.cap.events.DialogProviderAbort;
import pl.ovoo.ss7.wrapper.cap.args.PAbortCauseType;
import pl.ovoo.ss7.wrapper.cap.event.DialogProviderAbortEventWrapper;

import javax.slee.ActivityContextInterface;

/**
 * TxDialogProviderAbortEventWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxDialogProviderAbortEventWrapper extends TxEventWrapper implements DialogProviderAbortEventWrapper {

    private final DialogProviderAbort dialogProviderAbortEvent;

    public TxDialogProviderAbortEventWrapper(final DialogProviderAbort dialogProviderAbortEvent, final ActivityContextInterface aci) {
        super(aci, dialogProviderAbortEvent.getWrappedEvent());
        this.dialogProviderAbortEvent = dialogProviderAbortEvent;
    }

    @Override
    public PAbortCauseType getPeerAbortCause() {
        if (dialogProviderAbortEvent.getPAbortCauseType() == null) {
            return null;
        }
        return PAbortCauseType.valueOf(dialogProviderAbortEvent.getPAbortCauseType().getType());

    }
}
