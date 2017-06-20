/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.map.telestax.args;

import java.util.Arrays;

import pl.ovoo.ss7.wrapper.map.args.MAPCallForwardingDataWrapper;
import pl.ovoo.ss7.wrapper.map.args.MAPExt_ForwFeatureWrapper;

/**
 * TxMAPCallForwardingDataWrapper
 *
 * @author kacper.mosienski@ovoo.pl
 */
public class TxMAPCallForwardingDataWrapper implements MAPCallForwardingDataWrapper{
	
    private MAPExt_ForwFeatureWrapper[] mAPExt_ForwFeatureWrappers;

    public TxMAPCallForwardingDataWrapper(final MAPExt_ForwFeatureWrapper[] mAPExt_ForwFeatureWrappers) {
        this.mAPExt_ForwFeatureWrappers = mAPExt_ForwFeatureWrappers;
    }
        
    @Override
    public MAPExt_ForwFeatureWrapper[] getForwardingFeatureList(){
    	return mAPExt_ForwFeatureWrappers;
    }

    @Override
    public String toString() {
        return "TxMAPCallForwardingDataWrapper [mAPExt_ForwFeatureWrappers="
                + Arrays.toString(mAPExt_ForwFeatureWrappers) + "]";
    }
    
}
