/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.cap.telestax.event;

import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.CallInformationRequestRequest;
import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.args.CallInformationRequestArgWrapper;
import pl.ovoo.ss7.wrapper.cap.event.CallInformationRequestRequestEventWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.TxCallInformationRequestArgWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.cap2.TxCap2CallInformationRequestArgWrapper;

import javax.slee.ActivityContextInterface;

/**
 * TxCallInformationRequestRequestEventWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxCallInformationRequestRequestEventWrapper extends TxEventWrapper implements CallInformationRequestRequestEventWrapper {

    private final CallInformationRequestRequest callInformationRequestRequest;

    public TxCallInformationRequestRequestEventWrapper(final CallInformationRequestRequest callInformationRequestRequest, final ActivityContextInterface aci) {
        super(aci, callInformationRequestRequest);
        this.callInformationRequestRequest = callInformationRequestRequest;
    }

    @Override
    public CallInformationRequestArgWrapper getArgument() throws Ss7WrapperException {
        final TxCallInformationRequestArgWrapper txCallInformationRequestArgWrapper;
        switch (getTxDialog().getApplicationContext()) {
            case CapV1_gsmSSF_to_gsmSCF:
                txCallInformationRequestArgWrapper = new TxCallInformationRequestArgWrapper();
                break;
            case CapV2_assistGsmSSF_to_gsmSCF:
            case CapV2_gsmSRF_to_gsmSCF:
            case CapV2_gsmSSF_to_gsmSCF:
                txCallInformationRequestArgWrapper = new TxCap2CallInformationRequestArgWrapper();
                break;
            default:
                txCallInformationRequestArgWrapper = new TxCap2CallInformationRequestArgWrapper();
        }
        txCallInformationRequestArgWrapper.setTxRequestedInformationTypes(callInformationRequestRequest.getRequestedInformationTypeList());
        if (txCallInformationRequestArgWrapper instanceof TxCap2CallInformationRequestArgWrapper) {
            ((TxCap2CallInformationRequestArgWrapper) txCallInformationRequestArgWrapper).setTxLegID(callInformationRequestRequest.getLegID());
        }
        return txCallInformationRequestArgWrapper;
    }
}
