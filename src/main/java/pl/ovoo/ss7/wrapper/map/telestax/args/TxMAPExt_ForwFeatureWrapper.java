/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.map.telestax.args;

import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.ExtForwFeature;
import pl.ovoo.ss7.wrapper.map.args.MAPExt_ForwFeatureWrapper;

/**
 * TxMAPExt_ForwFeatureWrapper
 *
 * @author kacper.mosienski@ovoo.pl
 */
public class TxMAPExt_ForwFeatureWrapper extends TxMAPForwardingFeatureWrapper implements MAPExt_ForwFeatureWrapper{
	
	
    public TxMAPExt_ForwFeatureWrapper(final ExtForwFeature extForwFeature) {
        super(extForwFeature);
    }
}
