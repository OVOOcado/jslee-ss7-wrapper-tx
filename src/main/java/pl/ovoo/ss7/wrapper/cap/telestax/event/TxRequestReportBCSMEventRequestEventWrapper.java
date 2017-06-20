/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.cap.telestax.event;

import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.RequestReportBCSMEventRequest;
import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.args.RequestReportBCSMEventArgWrapper;
import pl.ovoo.ss7.wrapper.cap.event.RequestReportBCSMEventRequestEventWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.TxRequestReportBCSMEventArgWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.cap1.TxCap1RequestReportBCSMEventArgWrapper;

import javax.slee.ActivityContextInterface;

/**
 * TxRequestReportBCSMEventRequestEventWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxRequestReportBCSMEventRequestEventWrapper extends TxEventWrapper implements RequestReportBCSMEventRequestEventWrapper {

    private final RequestReportBCSMEventRequest requestReportBCSMEventRequest;

    public TxRequestReportBCSMEventRequestEventWrapper(final RequestReportBCSMEventRequest requestReportBCSMEventRequest, final ActivityContextInterface aci) {
        super(aci, requestReportBCSMEventRequest);
        this.requestReportBCSMEventRequest = requestReportBCSMEventRequest;
    }

    @Override
    public RequestReportBCSMEventArgWrapper getArgument() throws Ss7WrapperException {
        final TxRequestReportBCSMEventArgWrapper requestReportBCSMEventArgWrapper = new TxCap1RequestReportBCSMEventArgWrapper();
        requestReportBCSMEventArgWrapper.setTxBcsmEvents(requestReportBCSMEventRequest.getBCSMEventList());
        return requestReportBCSMEventArgWrapper;
    }
}
