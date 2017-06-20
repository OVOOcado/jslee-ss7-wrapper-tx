/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.map.telestax.event;

import org.mobicents.protocols.ss7.map.api.service.callhandling.SendRoutingInformationRequest;

import pl.ovoo.ss7.wrapper.common.telestax.TxISDNAddressStringWrapperImpl;
import pl.ovoo.ss7.wrapper.map.args.SendRoutingInfoRequestArgWrapper;
import pl.ovoo.ss7.wrapper.map.event.SendRoutingInfoRequestEventWrapper;
import pl.ovoo.ss7.wrapper.map.telestax.args.TxSendRoutingInfoRequestArgWrapper;

import javax.slee.ActivityContextInterface;

/**
 * TxInsertSubscriberDataRequestEventWrapper
 *
 * @author kacper.mosienski@ovoo.pl
 */
public class TxSendRoutingInfoRequestEventWrapper extends TxMapEventWrapper implements SendRoutingInfoRequestEventWrapper {

	private final SendRoutingInformationRequest sendRoutingInformationRequest;

    public TxSendRoutingInfoRequestEventWrapper(final SendRoutingInformationRequest sendRoutingInformationRequest, final ActivityContextInterface aci) {
        super(aci);
        this.sendRoutingInformationRequest = sendRoutingInformationRequest;
    }

    @Override
    public SendRoutingInfoRequestArgWrapper getArgument() {
        TxSendRoutingInfoRequestArgWrapper sri = new TxSendRoutingInfoRequestArgWrapper();
        sri.setMsisdn(new TxISDNAddressStringWrapperImpl(sendRoutingInformationRequest.getMsisdn()));
    	return sri;
    }
    
    @Override
    public long getInvokeId(){
    	return sendRoutingInformationRequest.getInvokeId();
    }
}
