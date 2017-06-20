/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.common.telestax;



import org.mobicents.protocols.ss7.map.api.primitives.AddressString;

import pl.ovoo.ss7.wrapper.common.args.AddressStringWrapper;

// TODO to remove
public class TxAddressStringWrapperImpl implements AddressStringWrapper{

    private final AddressString address;

    public TxAddressStringWrapperImpl(final AddressString address) {
        super();
        this.address = address;
    }
    
	@Override
	public String getAddress() {
		return null;
	}

	@Override
	public Nature getNature() {
		return null;
	}

	@Override
	public NumberingPlan getNumberingPlan() {
		return null;
	}

	@Override
	public boolean hasAddress() {
		return false;
	}

	@Override
	public boolean hasNature() {
		return false;
	}

	@Override
	public boolean hasNumberingPlan() {
		return false;
	}

    public AddressString getTxAddress() {
        return address;
    }
}
