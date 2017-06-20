/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.cap.telestax.event;

import org.mobicents.protocols.ss7.cap.api.CAPMessage;
import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.AssistRequestInstructionsRequest;
import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.InitialDPRequest;
import org.mobicents.protocols.ss7.cap.api.service.sms.InitialDPSMSRequest;
import pl.ovoo.ss7.wrapper.cap.args.DialogOpenArgWrapper;
import pl.ovoo.ss7.wrapper.cap.event.DialogOpenRequestEventWrapper;
import pl.ovoo.ss7.wrapper.cap.event.EventWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.TxDialogOpenArgWrapper;

import javax.slee.ActivityContextInterface;

/**
 * TxDialogOpenRequestEventWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxDialogOpenRequestEventWrapper extends TxEventWrapper implements DialogOpenRequestEventWrapper {

    private final CAPMessage event;

    public TxDialogOpenRequestEventWrapper(final CAPMessage event, final ActivityContextInterface aci) {
        super(aci, event);
        this.event = event;
    }

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

    @Override
    public DialogOpenArgWrapper getArgument() {
        return new TxDialogOpenArgWrapper(getTxDialog());
    }

}
