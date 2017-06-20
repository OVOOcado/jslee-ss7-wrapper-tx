/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.cap.telestax.event;

import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.AssistRequestInstructionsRequest;
import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.args.AssistRequestInstructionsArgWrapper;
import pl.ovoo.ss7.wrapper.cap.event.AssistRequestInstructionsRequestEventWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.TxAssistRequestInstructionsArgWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.cap2.TxCap2AssistRequestInstructionsArgWrapper;

import javax.slee.ActivityContextInterface;

/**
 * TxAssistRequestInstructionsRequestEventWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxAssistRequestInstructionsRequestEventWrapper extends TxEventWrapper implements AssistRequestInstructionsRequestEventWrapper {

    private final AssistRequestInstructionsRequest assistRequestInstructionsRequest;

    public TxAssistRequestInstructionsRequestEventWrapper(final AssistRequestInstructionsRequest assistRequestInstructionsRequest, final ActivityContextInterface aci) {
        super(aci, assistRequestInstructionsRequest);
        this.assistRequestInstructionsRequest = assistRequestInstructionsRequest;
    }

    @Override
    public AssistRequestInstructionsArgWrapper getArgument() throws Ss7WrapperException {
        try {
            final TxAssistRequestInstructionsArgWrapper txAssistRequestInstructionsArgWrapper;
            switch (getTxDialog().getApplicationContext()) {
                case CapV1_gsmSSF_to_gsmSCF:
                    txAssistRequestInstructionsArgWrapper = new TxAssistRequestInstructionsArgWrapper();
                    break;
                case CapV2_assistGsmSSF_to_gsmSCF:
                case CapV2_gsmSRF_to_gsmSCF:
                case CapV2_gsmSSF_to_gsmSCF:
                    txAssistRequestInstructionsArgWrapper = new TxCap2AssistRequestInstructionsArgWrapper();
                    break;
                default:
                    txAssistRequestInstructionsArgWrapper = new TxCap2AssistRequestInstructionsArgWrapper();
            }

            if (txAssistRequestInstructionsArgWrapper instanceof TxCap2AssistRequestInstructionsArgWrapper) {
                ((TxCap2AssistRequestInstructionsArgWrapper) txAssistRequestInstructionsArgWrapper).
                        setTxIpsspCapabilities(assistRequestInstructionsRequest.getIPSSPCapabilities());
            }

            if (assistRequestInstructionsRequest.getCorrelationID() != null) {
                txAssistRequestInstructionsArgWrapper.setTxCorrelationID(assistRequestInstructionsRequest.getCorrelationID().getGenericNumber());
            }
            return txAssistRequestInstructionsArgWrapper;
        } catch (CAPException e) {
            throw new Ss7WrapperException(e);
        }

    }
}
