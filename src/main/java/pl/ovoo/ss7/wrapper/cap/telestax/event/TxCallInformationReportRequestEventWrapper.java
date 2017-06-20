/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.cap.telestax.event;

import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.CallInformationReportRequest;
import pl.ovoo.ss7.wrapper.cap.args.CallInformationReportArgWrapper;
import pl.ovoo.ss7.wrapper.cap.event.CallInformationReportRequestEventWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.TxCallInformationReportArgWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.cap2.TxCap2CallInformationReportArgWrapper;

import javax.slee.ActivityContextInterface;

/**
 * TxCallInformationReportRequestEventWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxCallInformationReportRequestEventWrapper extends TxEventWrapper implements CallInformationReportRequestEventWrapper {

    private final CallInformationReportRequest callInformationReportRequestEvent;

    public TxCallInformationReportRequestEventWrapper(final CallInformationReportRequest callInformationReportRequestEvent, final ActivityContextInterface aci) {
        super(aci, callInformationReportRequestEvent);
        this.callInformationReportRequestEvent = callInformationReportRequestEvent;
    }

    @Override
    public CallInformationReportArgWrapper getArgument() {
        final TxCallInformationReportArgWrapper txCallInformationReportArgWrapper;
        switch (getTxDialog().getApplicationContext()) {
            case CapV1_gsmSSF_to_gsmSCF:
                txCallInformationReportArgWrapper = new TxCallInformationReportArgWrapper();
                break;
            case CapV2_assistGsmSSF_to_gsmSCF:
            case CapV2_gsmSRF_to_gsmSCF:
            case CapV2_gsmSSF_to_gsmSCF:
                txCallInformationReportArgWrapper = new TxCap2CallInformationReportArgWrapper();
                break;
            default:
                txCallInformationReportArgWrapper = new TxCap2CallInformationReportArgWrapper();
        }

        txCallInformationReportArgWrapper.setTxRequestedInformation(callInformationReportRequestEvent.getRequestedInformationList());
        if (txCallInformationReportArgWrapper instanceof TxCap2CallInformationReportArgWrapper) {
            ((TxCap2CallInformationReportArgWrapper) txCallInformationReportArgWrapper).setTxLegID(callInformationReportRequestEvent.getLegID());
        }
        return txCallInformationReportArgWrapper;
    }
}
