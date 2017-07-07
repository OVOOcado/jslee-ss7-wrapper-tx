/*
 * JSLEE SS7 Wrapper Tx
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the JSLEE SS7 Wrapper Tx.
 *
 * JSLEE SS7 Wrapper Tx is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * JSLEE SS7 Wrapper Tx is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package pl.ovoo.ss7.wrapper.common.tx;


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
