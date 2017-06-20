/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.map.telestax.args;

import org.mobicents.protocols.ss7.map.api.primitives.SubscriberIdentity;
import pl.ovoo.ss7.wrapper.map.args.MAPSubscriberIdentityWrapper;

/**
 * TxMAPSubscriberIdentityWrapper
 *
 * @author kacper.mosienski@ovoo.pl
 */
public class TxMAPSubscriberIdentityWrapper implements MAPSubscriberIdentityWrapper{
	
    private final SubscriberIdentity subscriberIdentity;

    public TxMAPSubscriberIdentityWrapper(final SubscriberIdentity subscriberIdentity) {
        this.subscriberIdentity = subscriberIdentity;
    }
    
    public SubscriberIdentity getTxMAPSubscriberIdentity(){
    	return subscriberIdentity;
    }

    @Override
    public String toString() {
        return "TxMAPSubscriberIdentityWrapper [subscriberIdentity=" + subscriberIdentity + "]";
    }
    
}
