/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.cap.telestax.event;

import org.mobicents.protocols.ss7.cap.api.service.sms.RequestReportSMSEventRequest;
import org.mobicents.protocols.ss7.cap.api.service.sms.primitive.SMSEvent;
import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.args.RequestReportSMSEventArgWrapper;
import pl.ovoo.ss7.wrapper.cap.args.SMSEventWrapper;
import pl.ovoo.ss7.wrapper.cap.event.RequestReportSMSEventRequestEventWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.TxRequestReportSMSEventArgWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.TxSMSEventWrapper;

import javax.slee.ActivityContextInterface;

/**
 * TxRequestReportSMSEventRequestEventWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxRequestReportSMSEventRequestEventWrapper extends TxEventWrapper implements RequestReportSMSEventRequestEventWrapper {

    private final RequestReportSMSEventRequest requestReportSMSEventRequest;

    public TxRequestReportSMSEventRequestEventWrapper(final RequestReportSMSEventRequest requestReportSMSEventRequest, final ActivityContextInterface aci) {
        super(aci, requestReportSMSEventRequest);
        this.requestReportSMSEventRequest = requestReportSMSEventRequest;
    }

    @Override
    public RequestReportSMSEventArgWrapper getArgument() throws Ss7WrapperException {
    	if (requestReportSMSEventRequest.getSMSEvents() == null || requestReportSMSEventRequest.getSMSEvents().isEmpty()) {
            return null;
        } else {
            final SMSEventWrapper[] smsEventWrappers = new SMSEventWrapper[requestReportSMSEventRequest.getSMSEvents().size()];
            int i = 0;
            for (final SMSEvent smsEvent : requestReportSMSEventRequest.getSMSEvents()) {
            	smsEventWrappers[i] = new TxSMSEventWrapper(smsEvent);
                i++;
            }
            return new TxRequestReportSMSEventArgWrapper(smsEventWrappers);
        }
    }
}
