/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.cap.telestax.event;

import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.EventReportBCSMRequest;
import pl.ovoo.ss7.wrapper.cap.args.EventReportBCSMArgWrapper;
import pl.ovoo.ss7.wrapper.cap.event.EventReportBCSMRequestEventWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.TxEventReportBCSMArgWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.cap1.TxCap1EventReportBCSMArgWrapper;

import javax.slee.ActivityContextInterface;

/**
 * TxEventReportBCSMRequestEventWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxEventReportBCSMRequestEventWrapper extends TxEventWrapper implements EventReportBCSMRequestEventWrapper {

    private final EventReportBCSMRequest ccEventReportBCSMRequestEvent;

    public TxEventReportBCSMRequestEventWrapper(final EventReportBCSMRequest ccEventReportBCSMRequestEvent, final ActivityContextInterface aci) {
        super(aci, ccEventReportBCSMRequestEvent);
        this.ccEventReportBCSMRequestEvent = ccEventReportBCSMRequestEvent;
    }

    @Override
    public EventReportBCSMArgWrapper getArgument() {
        final TxEventReportBCSMArgWrapper eventReportBCSMArgWrapper;
        switch (getTxDialog().getApplicationContext()) {
            case CapV1_gsmSSF_to_gsmSCF:
                eventReportBCSMArgWrapper = new TxCap1EventReportBCSMArgWrapper();
                break;
            case CapV2_assistGsmSSF_to_gsmSCF:
            case CapV2_gsmSRF_to_gsmSCF:
            case CapV2_gsmSSF_to_gsmSCF:
                eventReportBCSMArgWrapper = new TxCap1EventReportBCSMArgWrapper();
                break;
            default:
                eventReportBCSMArgWrapper = new TxCap1EventReportBCSMArgWrapper();
        }
        eventReportBCSMArgWrapper.setTxEventSpecificInformationBCSM(ccEventReportBCSMRequestEvent.getEventSpecificInformationBCSM());
        eventReportBCSMArgWrapper.setTxEventTypeBCSM(ccEventReportBCSMRequestEvent.getEventTypeBCSM());
        eventReportBCSMArgWrapper.setTxLegID(ccEventReportBCSMRequestEvent.getLegID());
        eventReportBCSMArgWrapper.setTxMiscCallInfo(ccEventReportBCSMRequestEvent.getMiscCallInfo());
        return eventReportBCSMArgWrapper;
    }
}
