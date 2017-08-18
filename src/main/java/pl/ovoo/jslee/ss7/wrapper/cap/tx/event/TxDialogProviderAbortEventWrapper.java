/*
 * JSLEE SS7 Wrapper Tx
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the JSLEE SS7 Wrapper Tx.
 *
 * JSLEE SS7 Wrapper Tx is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * JSLEE SS7 Wrapper Tx is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package pl.ovoo.jslee.ss7.wrapper.cap.tx.event;

import org.mobicents.slee.resource.cap.events.DialogProviderAbort;
import pl.ovoo.jslee.ss7.wrapper.cap.args.PAbortCauseType;
import pl.ovoo.jslee.ss7.wrapper.cap.event.DialogProviderAbortEventWrapper;

import javax.slee.ActivityContextInterface;


/**
 * TxDialogProviderAbortEventWrapper.
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxDialogProviderAbortEventWrapper extends TxEventWrapper implements DialogProviderAbortEventWrapper {

    /** The dialog provider abort event. */
    private final DialogProviderAbort dialogProviderAbortEvent;

    /**
     * Instantiates a new tx dialog provider abort event wrapper.
     *
     * @param dialogProviderAbortEvent the dialog provider abort event
     * @param aci the aci
     */
    public TxDialogProviderAbortEventWrapper(final DialogProviderAbort dialogProviderAbortEvent, final ActivityContextInterface aci) {
        super(aci, dialogProviderAbortEvent.getWrappedEvent());
        this.dialogProviderAbortEvent = dialogProviderAbortEvent;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.event.DialogProviderAbortEventWrapper#getPeerAbortCause()
     */
    @Override
    public PAbortCauseType getPeerAbortCause() {
        if (dialogProviderAbortEvent.getPAbortCauseType() == null) {
            return null;
        }
        return PAbortCauseType.valueOf(dialogProviderAbortEvent.getPAbortCauseType().getType());

    }
}
