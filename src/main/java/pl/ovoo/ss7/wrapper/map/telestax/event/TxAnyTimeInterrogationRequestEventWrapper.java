/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.map.telestax.event;

import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.AnyTimeInterrogationRequest;
import pl.ovoo.ss7.wrapper.map.args.AnyTimeInterrogationArgWrapper;
import pl.ovoo.ss7.wrapper.map.event.AnyTimeInterrogationRequestEventWrapper;
import pl.ovoo.ss7.wrapper.map.telestax.args.TxAnyTimeInterrogationArgWrapper;

import javax.slee.ActivityContextInterface;

/**
 * TxAnyTimeInterrogationResultEventWrapper
 *
 * @author kacper.mosienski@ovoo.pl
 */
public class TxAnyTimeInterrogationRequestEventWrapper extends TxMapEventWrapper implements AnyTimeInterrogationRequestEventWrapper{

    private final AnyTimeInterrogationRequest anyTimeInterrogationRequest;

    public TxAnyTimeInterrogationRequestEventWrapper(final AnyTimeInterrogationRequest anyTimeInterrogationRequest, final ActivityContextInterface aci) {
        super(aci);
        this.anyTimeInterrogationRequest = anyTimeInterrogationRequest;
    }

    @Override
    public AnyTimeInterrogationArgWrapper getArgument() {
    	AnyTimeInterrogationArgWrapper ati = new TxAnyTimeInterrogationArgWrapper(anyTimeInterrogationRequest);
    	return ati;
    }
    
    @Override
    public long getInvokeId(){
    	return anyTimeInterrogationRequest.getInvokeId();
    }
}
