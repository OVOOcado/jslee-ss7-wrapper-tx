/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.map.telestax.event;

import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.InsertSubscriberDataRequest;
import pl.ovoo.ss7.wrapper.map.args.InsertSubscriberDataArg_v1Wrapper;
import pl.ovoo.ss7.wrapper.map.event.InsertSubscriberDataRequestEventWrapper;
import pl.ovoo.ss7.wrapper.map.telestax.args.TxInsertSubscriberDataArg_v1Wrapper;

import javax.slee.ActivityContextInterface;

/**
 * TxInsertSubscriberDataRequestEventWrapper
 *
 * @author kacper.mosienski@ovoo.pl
 */
public class TxInsertSubscriberDataRequestEventWrapper extends TxMapEventWrapper implements InsertSubscriberDataRequestEventWrapper {

	private final InsertSubscriberDataRequest insertSubscriberDataRequest;

    public TxInsertSubscriberDataRequestEventWrapper(final InsertSubscriberDataRequest insertSubscriberDataRequest, final ActivityContextInterface aci) {
        super(aci);
        this.insertSubscriberDataRequest = insertSubscriberDataRequest;
    }

    @Override
    public InsertSubscriberDataArg_v1Wrapper getArgument() {
    	InsertSubscriberDataArg_v1Wrapper isd = new TxInsertSubscriberDataArg_v1Wrapper(insertSubscriberDataRequest);
    	return isd;
    }
    
    @Override
    public long getInvokeId(){
    	return insertSubscriberDataRequest.getInvokeId();
    }
}
