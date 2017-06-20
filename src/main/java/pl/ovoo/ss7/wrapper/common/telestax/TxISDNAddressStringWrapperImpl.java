/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.common.telestax;

import org.mobicents.protocols.ss7.map.api.primitives.ISDNAddressString;
import pl.ovoo.ss7.wrapper.common.args.ISDNAddressStringWrapper;

public class TxISDNAddressStringWrapperImpl implements ISDNAddressStringWrapper{

	private final ISDNAddressString address;

	public TxISDNAddressStringWrapperImpl(final ISDNAddressString address) {
		super();
		this.address = address;
	}

	@Override
	public String getAddress() {
		return address.getAddress();
	}

	@Override
	public Nature getNature() {
		if (address.getAddressNature() != null) {
			return Nature.valueOf(address.getAddressNature().getIndicator());
		}
		return null;
	}

	@Override
	public NumberingPlan getNumberingPlan() {
		if (address.getNumberingPlan() != null) {
			return NumberingPlan.valueOf(address.getNumberingPlan().getIndicator());
		}
		return null;
	}

	@Override
	public boolean hasAddress(){
		return address.getAddress() != null;
	}

	@Override
	public boolean hasNature(){
		return address.getAddressNature() != null;
	}

	@Override
	public boolean hasNumberingPlan(){
		return address.getNumberingPlan() != null;
	}

	public ISDNAddressString getTxAddress() {
		return address;
	}
}
