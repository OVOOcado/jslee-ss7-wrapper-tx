/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.cap.telestax.event;

import org.mobicents.protocols.ss7.cap.api.service.sms.InitialDPSMSRequest;
import pl.ovoo.ss7.wrapper.cap.args.InitialDPSMSArgWrapper;
import pl.ovoo.ss7.wrapper.cap.event.InitialDPSMSRequestEventWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.TxInitialDPSMSArgWrapper;

import javax.slee.ActivityContextInterface;

/**
 * TxInitialDPSMSRequestEventWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxInitialDPSMSRequestEventWrapper extends TxEventWrapper implements InitialDPSMSRequestEventWrapper {

    private final InitialDPSMSRequest initialDPSMSRequest;

    public TxInitialDPSMSRequestEventWrapper(final InitialDPSMSRequest initialDPSMSRequest, final ActivityContextInterface aci) {
        super(aci, initialDPSMSRequest);
        this.initialDPSMSRequest = initialDPSMSRequest;
    }

    @Override
    public InitialDPSMSArgWrapper getArgument() {
        final TxInitialDPSMSArgWrapper txInitialDPSMSArgWrapper = new TxInitialDPSMSArgWrapper();
        
        txInitialDPSMSArgWrapper.setTxCallingPartyNumber(initialDPSMSRequest.getCallingPartyNumber());
        txInitialDPSMSArgWrapper.setTxDestinationSubscriberNumber(initialDPSMSRequest.getDestinationSubscriberNumber());
        txInitialDPSMSArgWrapper.setTxEventTypeSMS(initialDPSMSRequest.getEventTypeSMS());
        if(initialDPSMSRequest.getSmsReferenceNumber() != null){
        	txInitialDPSMSArgWrapper.setTxSmsReferenceNumber(initialDPSMSRequest.getSmsReferenceNumber());
        }
        txInitialDPSMSArgWrapper.setTxLocationInformationMSC(initialDPSMSRequest.getLocationInformationMSC());
        txInitialDPSMSArgWrapper.setTxSmscAddress(initialDPSMSRequest.getSMSCAddress());
        txInitialDPSMSArgWrapper.setTxServiceKey(initialDPSMSRequest.getServiceKey());
        txInitialDPSMSArgWrapper.setTxMscAddress(initialDPSMSRequest.getMscAddress());
        txInitialDPSMSArgWrapper.setTxImsi(initialDPSMSRequest.getImsi());
        txInitialDPSMSArgWrapper.setTxTimeAndTimezone(initialDPSMSRequest.getTimeAndTimezone());
        
        return txInitialDPSMSArgWrapper;
    }
}
