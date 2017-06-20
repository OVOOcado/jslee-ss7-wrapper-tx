/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.cap.telestax.event;

import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.EstablishTemporaryConnectionRequest;
import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.args.EstablishTemporaryConnectionArgWrapper;
import pl.ovoo.ss7.wrapper.cap.event.EstablishTemporaryConnectionRequestEventWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.TxEstablishTemporaryConnectionArgWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.cap2.TxCap2EstablishTemporaryConnectionArgWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.cap3.TxCap3EstablishTemporaryConnectionArgWrapper;

import javax.slee.ActivityContextInterface;

/**
 * TxEstablishTemporaryConnectionRequestEventWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxEstablishTemporaryConnectionRequestEventWrapper extends TxEventWrapper implements EstablishTemporaryConnectionRequestEventWrapper {

    private final EstablishTemporaryConnectionRequest establishTemporaryConnectionRequest;

    public TxEstablishTemporaryConnectionRequestEventWrapper(final EstablishTemporaryConnectionRequest establishTemporaryConnectionRequest, final ActivityContextInterface aci) {
        super(aci, establishTemporaryConnectionRequest);
        this.establishTemporaryConnectionRequest = establishTemporaryConnectionRequest;
    }

    @Override
    public EstablishTemporaryConnectionArgWrapper getArgument() throws Ss7WrapperException {
        final TxEstablishTemporaryConnectionArgWrapper establishTemporaryConnectionArgWrapper;
        switch (getTxDialog().getApplicationContext()) {
            case CapV1_gsmSSF_to_gsmSCF:
                establishTemporaryConnectionArgWrapper = new TxEstablishTemporaryConnectionArgWrapper();
                break;
            case CapV2_assistGsmSSF_to_gsmSCF:
            case CapV2_gsmSRF_to_gsmSCF:
            case CapV2_gsmSSF_to_gsmSCF:
                establishTemporaryConnectionArgWrapper = new TxCap2EstablishTemporaryConnectionArgWrapper();
                break;
            default:
                establishTemporaryConnectionArgWrapper = new TxCap3EstablishTemporaryConnectionArgWrapper();
        }
        try {
            if (establishTemporaryConnectionRequest.getAssistingSSPIPRoutingAddress()!= null) {
                    establishTemporaryConnectionArgWrapper.setTxAssistingSSPIPRoutingAddress(establishTemporaryConnectionRequest.getAssistingSSPIPRoutingAddress().getGenericNumber());
            }
            if (establishTemporaryConnectionRequest.getCorrelationID()!= null) {
                establishTemporaryConnectionArgWrapper.setTxAssistingDialogCorrelationID(establishTemporaryConnectionRequest.getCorrelationID().getGenericDigits());
            }
            return establishTemporaryConnectionArgWrapper;

        } catch (CAPException e) {
            throw new Ss7WrapperException(e);
        }
    }
}
