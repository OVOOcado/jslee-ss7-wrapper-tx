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

import org.mobicents.protocols.ss7.cap.api.CAPMessage;
import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.AssistRequestInstructionsRequest;
import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.InitialDPRequest;
import org.mobicents.protocols.ss7.cap.api.service.sms.InitialDPSMSRequest;
import pl.ovoo.jslee.ss7.wrapper.cap.args.DialogOpenArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.event.DialogOpenRequestEventWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.event.EventWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.TxDialogOpenArgWrapper;

import javax.slee.ActivityContextInterface;


/**
 * TxDialogOpenRequestEventWrapper.
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxDialogOpenRequestEventWrapper extends TxEventWrapper implements DialogOpenRequestEventWrapper {

    /** The event. */
    private final CAPMessage event;

    /**
     * Instantiates a new tx dialog open request event wrapper.
     *
     * @param event the event
     * @param aci the aci
     */
    public TxDialogOpenRequestEventWrapper(final CAPMessage event, final ActivityContextInterface aci) {
        super(aci, event);
        this.event = event;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.event.DialogOpenRequestEventWrapper#getComponentEvents()
     */
    @Override
    public EventWrapper[] getComponentEvents() {
        if (event instanceof InitialDPRequest) {
            final EventWrapper[] eventWrappers = {new TxInitialDPRequestEventWrapper((InitialDPRequest)event, getAci())};
            return eventWrappers;
        } else if (event instanceof InitialDPSMSRequest) {
            final EventWrapper[] eventWrappers = {new TxInitialDPSMSRequestEventWrapper((InitialDPSMSRequest)event, getAci())};
            return eventWrappers;
        } else if (event instanceof AssistRequestInstructionsRequest) {
            final EventWrapper[] eventWrappers = {new TxAssistRequestInstructionsRequestEventWrapper((AssistRequestInstructionsRequest)event, getAci())};
            return eventWrappers;
        }
        return null;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.event.DialogOpenRequestEventWrapper#getArgument()
     */
    @Override
    public DialogOpenArgWrapper getArgument() {
        return new TxDialogOpenArgWrapper(getTxDialog());
    }

}
