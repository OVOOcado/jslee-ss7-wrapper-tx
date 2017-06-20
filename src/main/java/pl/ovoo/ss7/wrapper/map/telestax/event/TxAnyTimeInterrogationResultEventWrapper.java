/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.map.telestax.event;

import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.AnyTimeInterrogationResponse;
import pl.ovoo.ss7.wrapper.map.args.AnyTimeInterrogationResultWrapper;
import pl.ovoo.ss7.wrapper.map.args.MAPSubscriberInfoWrapper;
import pl.ovoo.ss7.wrapper.map.args.SubscriberCFInfoWrapper;
import pl.ovoo.ss7.wrapper.map.event.AnyTimeInterrogationResultEventWrapper;
import pl.ovoo.ss7.wrapper.map.telestax.args.TxAnyTimeInterrogationResultWrapper;
import pl.ovoo.ss7.wrapper.map.telestax.args.TxMAPSubscriberInfoWrapper;
import pl.ovoo.ss7.wrapper.map.telestax.args.TxSubscriberCFInfoWrapper;

import javax.slee.ActivityContextInterface;

/**
 * TxAnyTimeInterrogationResultEventWrapper
 *
 * @author kacper.mosienski@ovoo.pl
 */
public class TxAnyTimeInterrogationResultEventWrapper extends TxMapEventWrapper implements AnyTimeInterrogationResultEventWrapper {

    private final AnyTimeInterrogationResponse anyTimeInterrogationResponse;

    public TxAnyTimeInterrogationResultEventWrapper(final AnyTimeInterrogationResponse anyTimeInterrogationResponse, final ActivityContextInterface aci) {
        super(aci);
        this.anyTimeInterrogationResponse = anyTimeInterrogationResponse;
    }

    @Override
    public AnyTimeInterrogationResultWrapper getArgument() {
    	MAPSubscriberInfoWrapper mAPSubscriberInfoWrapper = null;
    	SubscriberCFInfoWrapper subscriberCFInfoWrapper = null;
    	if(anyTimeInterrogationResponse.getSubscriberCFInfo()!= null){
    		subscriberCFInfoWrapper = new TxSubscriberCFInfoWrapper(anyTimeInterrogationResponse.getSubscriberCFInfo());
    	}
    	if(anyTimeInterrogationResponse.getSubscriberInfo()!= null){
    		mAPSubscriberInfoWrapper = new TxMAPSubscriberInfoWrapper(anyTimeInterrogationResponse.getSubscriberInfo());
    	}
        return new TxAnyTimeInterrogationResultWrapper(subscriberCFInfoWrapper, mAPSubscriberInfoWrapper);
    }
    
    @Override
    public long getInvokeId(){
    	return anyTimeInterrogationResponse.getInvokeId();
    }
}
