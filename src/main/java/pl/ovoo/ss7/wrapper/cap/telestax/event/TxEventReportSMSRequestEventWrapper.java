/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.cap.telestax.event;

import org.mobicents.protocols.ss7.cap.api.service.sms.EventReportSMSRequest;
import pl.ovoo.ss7.wrapper.cap.args.EventReportSMSArgWrapper;
import pl.ovoo.ss7.wrapper.cap.event.EventReportSMSRequestEventWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.TxEventReportSMSArgWrapperImpl;

import javax.slee.ActivityContextInterface;

/**
 * TxEventReportSMSRequestEventWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxEventReportSMSRequestEventWrapper extends TxEventWrapper implements EventReportSMSRequestEventWrapper {

    private final EventReportSMSRequest eventReportSMSRequest;

    public TxEventReportSMSRequestEventWrapper(final EventReportSMSRequest eventReportSMSRequest, final ActivityContextInterface aci) {
        super(aci, eventReportSMSRequest);
        this.eventReportSMSRequest = eventReportSMSRequest;
    }

    @Override
    public EventReportSMSArgWrapper getArgument() {        
        final TxEventReportSMSArgWrapperImpl eventReportSMSArgWrapper = new TxEventReportSMSArgWrapperImpl();
        eventReportSMSArgWrapper.setTxEventSpecificInformationBCSM(eventReportSMSRequest.getEventSpecificInformationSMS());
        eventReportSMSArgWrapper.setTxEventTypeSMS(eventReportSMSRequest.getEventTypeSMS());
        return eventReportSMSArgWrapper;
    }
}
