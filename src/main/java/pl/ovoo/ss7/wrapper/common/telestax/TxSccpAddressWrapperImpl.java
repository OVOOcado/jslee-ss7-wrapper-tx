/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.common.telestax;


import org.mobicents.protocols.ss7.indicator.RoutingIndicator;
import org.mobicents.protocols.ss7.sccp.parameter.SccpAddress;
import pl.ovoo.ss7.wrapper.common.args.GlobalTitleWrapper;
import pl.ovoo.ss7.wrapper.common.args.SccpAddressWrapper;

/**
 * TxSccpAddressWrapperImpl
 *
 * @author kacper.mosienski@ovoo.pl
 */
public class TxSccpAddressWrapperImpl implements SccpAddressWrapper {

	private final SccpAddress sccpAddress;

	public TxSccpAddressWrapperImpl(SccpAddress sccpAddress) {
		super();
		this.sccpAddress = sccpAddress;
	}	

	@Override
    public GlobalTitleWrapper getGlobalTitle(){
		if(this.sccpAddress.getGlobalTitle() != null){
			return new TxGlobalTitleWrapper(this.sccpAddress.getGlobalTitle());
		}
		else{
			return null;
		}
	}

	@Override
	public boolean getRouteOnPC() {
		return this.sccpAddress.getAddressIndicator().getRoutingIndicator().equals(RoutingIndicator.ROUTING_BASED_ON_DPC_AND_SSN);
	}

	@Override
	public Integer getSSN() {
		return this.sccpAddress.getSubsystemNumber();
	}

	@Override
	public Integer getPC() {
		return this.sccpAddress.getSignalingPointCode();
	}

	@Override
	public Type getType() {
		return null;
	}

	public SccpAddress getTxSccpAddress() {
		return sccpAddress;
	}
	
	
}
