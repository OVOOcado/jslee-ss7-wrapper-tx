/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.common.telestax;

import org.mobicents.protocols.ss7.indicator.NatureOfAddress;
import org.mobicents.protocols.ss7.indicator.RoutingIndicator;
import org.mobicents.protocols.ss7.sccp.parameter.GlobalTitle;
import org.mobicents.protocols.ss7.sccp.parameter.ParameterFactory;
import org.mobicents.protocols.ss7.sccp.parameter.SccpAddress;
import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.common.args.CommonArgsFactory;
import pl.ovoo.ss7.wrapper.common.args.GlobalTitleWrapper;
import pl.ovoo.ss7.wrapper.common.args.GlobalTitleWrapper.EncodingScheme;
import pl.ovoo.ss7.wrapper.common.args.GlobalTitleWrapper.GlobalTitleIndicator;
import pl.ovoo.ss7.wrapper.common.args.GlobalTitleWrapper.Nature;
import pl.ovoo.ss7.wrapper.common.args.SccpAddressWrapper;
import pl.ovoo.ss7.wrapper.common.args.SccpAddressWrapper.Type;

/**
 * TxCommonArgsFactory
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxCommonArgsFactory implements CommonArgsFactory {

	//private MAPProvider mapProvider;
	//private MAPContextInterfaceFactory mapContextInterfaceFactory;
    //private CAPProvider capProvider;
    private ParameterFactory parameterFactory;    
    /*public TxCommonArgsFactory(final CAPProvider capProvider) {
        this.capProvider = capProvider;
    }*/

    public TxCommonArgsFactory(final ParameterFactory parameterFactory) {
        this.parameterFactory = parameterFactory;
    }
    
    @Override
    public SccpAddressWrapper createSccpAddress(boolean routeOnPC, GlobalTitleWrapper gt, Integer pc, Integer ssn, Type type) throws Ss7WrapperException {
    	if (routeOnPC) {
    		if (pc == null) {
    			throw new Ss7WrapperException("PC cannot be null when PC routing");
			}
			if (ssn == null) {
				throw new Ss7WrapperException("SSN cannot be null when PC routing");
			}
		} else {
    		if (gt == null) {
				throw new Ss7WrapperException("GT cannot be null when GT routing");

			}
		}

    	RoutingIndicator ri = routeOnPC ? RoutingIndicator.ROUTING_BASED_ON_DPC_AND_SSN : RoutingIndicator.ROUTING_BASED_ON_GLOBAL_TITLE;
    	GlobalTitle txGt = null;
    	if(gt != null){
    		txGt = ((TxGlobalTitleWrapper)gt).getTxGlobalTitle();
    	}
    	SccpAddress sccpAddress = parameterFactory.createSccpAddress(ri, txGt, pc != null ? pc : 0, ssn != null ? ssn : 0);
    	return new TxSccpAddressWrapperImpl(sccpAddress);
    }
    
    @Override
    public GlobalTitleWrapper createGlobalTitle(String address, Integer translationType, GlobalTitleIndicator globalTitleIndicator, pl.ovoo.ss7.wrapper.common.args.GlobalTitleWrapper.NumberingPlan numberingPlan, EncodingScheme encodingScheme, Nature nature) throws Ss7WrapperException {
    	
    	org.mobicents.protocols.ss7.sccp.parameter.EncodingScheme es = null;
    	if(encodingScheme != null){
    		es = parameterFactory.createEncodingScheme(encodingScheme.getValue());
		}
    	
    	GlobalTitle gt = null;
    	
    	switch(globalTitleIndicator){
	    	case GT_0000: gt = null; break;
	    	case GT_0001:
	    		gt = parameterFactory.createGlobalTitle(address, NatureOfAddress.valueOf(nature.getValue()));
	    		break;
	    	case GT_0010:
	    		if (translationType == null) {
	    			throw new Ss7WrapperException(globalTitleIndicator + " requires translationType");
				}
	    		gt = parameterFactory.createGlobalTitle(address, translationType);
	    		break;
	    	case GT_0011:
				if (translationType == null) {
					throw new Ss7WrapperException(globalTitleIndicator + " requires translationType");
				}
	    		gt = parameterFactory.createGlobalTitle(address, translationType, org.mobicents.protocols.ss7.indicator.NumberingPlan.valueOf(numberingPlan.getValue()),es);
	    		break;
	    	case GT_0100:
				if (translationType == null) {
					throw new Ss7WrapperException(globalTitleIndicator + " requires translationType");
				}
	    		gt = parameterFactory.createGlobalTitle(address, translationType, org.mobicents.protocols.ss7.indicator.NumberingPlan.valueOf(numberingPlan.getValue()),es, NatureOfAddress.valueOf(nature.getValue()));
	    		break;
    	}
    	
    	return new TxGlobalTitleWrapper(gt);
    }
}
