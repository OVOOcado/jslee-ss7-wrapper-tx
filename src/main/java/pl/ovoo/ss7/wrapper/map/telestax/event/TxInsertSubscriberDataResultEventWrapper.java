/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.map.telestax.event;

import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.InsertSubscriberDataResponse;
import pl.ovoo.ss7.wrapper.map.args.InsertSubscriberDataResponseWrapper;
import pl.ovoo.ss7.wrapper.map.event.InsertSubscriberDataResultEventWrapper;
import pl.ovoo.ss7.wrapper.map.telestax.args.TxInsertSubscriberDataResponseWrapper;

import javax.slee.ActivityContextInterface;

/**
 * TxInsertSubscriberDataResultEventWrapper
 *
 * @author kacper.mosienski@ovoo.pl
 */
public class TxInsertSubscriberDataResultEventWrapper extends TxMapEventWrapper implements InsertSubscriberDataResultEventWrapper {

	private final InsertSubscriberDataResponse insertSubscriberDataResponse;

    public TxInsertSubscriberDataResultEventWrapper(final InsertSubscriberDataResponse insertSubscriberDataResponse, final ActivityContextInterface aci) {
        super(aci);
        this.insertSubscriberDataResponse = insertSubscriberDataResponse;
    }

    @Override
    public InsertSubscriberDataResponseWrapper getArgument() {
    	InsertSubscriberDataResponseWrapper isd = new TxInsertSubscriberDataResponseWrapper(insertSubscriberDataResponse);
    	return isd;
    }
    
    @Override
    public long getInvokeId(){
    	return insertSubscriberDataResponse.getInvokeId();
    }
}
