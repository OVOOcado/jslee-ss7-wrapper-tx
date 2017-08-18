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

package pl.ovoo.jslee.ss7.wrapper.common.tx;



import org.mobicents.protocols.ss7.map.api.primitives.AddressString;

import pl.ovoo.jslee.ss7.wrapper.common.args.AddressStringWrapper;


/**
 * The Class TxAddressStringWrapperImpl.
 */
// TODO to remove
public class TxAddressStringWrapperImpl implements AddressStringWrapper{

    /** The address. */
    private final AddressString address;

    /**
     * Instantiates a new tx address string wrapper impl.
     *
     * @param address the address
     */
    public TxAddressStringWrapperImpl(final AddressString address) {
        super();
        this.address = address;
    }
    
	/* (non-Javadoc)
	 * @see pl.ovoo.jslee.ss7.wrapper.common.args.AddressStringWrapper#getAddress()
	 */
	@Override
	public String getAddress() {
		return null;
	}

	/* (non-Javadoc)
	 * @see pl.ovoo.jslee.ss7.wrapper.common.args.AddressStringWrapper#getNature()
	 */
	@Override
	public Nature getNature() {
		return null;
	}

	/* (non-Javadoc)
	 * @see pl.ovoo.jslee.ss7.wrapper.common.args.AddressStringWrapper#getNumberingPlan()
	 */
	@Override
	public NumberingPlan getNumberingPlan() {
		return null;
	}

	/* (non-Javadoc)
	 * @see pl.ovoo.jslee.ss7.wrapper.common.args.AddressStringWrapper#hasAddress()
	 */
	@Override
	public boolean hasAddress() {
		return false;
	}

	/* (non-Javadoc)
	 * @see pl.ovoo.jslee.ss7.wrapper.common.args.AddressStringWrapper#hasNature()
	 */
	@Override
	public boolean hasNature() {
		return false;
	}

	/* (non-Javadoc)
	 * @see pl.ovoo.jslee.ss7.wrapper.common.args.AddressStringWrapper#hasNumberingPlan()
	 */
	@Override
	public boolean hasNumberingPlan() {
		return false;
	}

    /**
     * Gets the tx address.
     *
     * @return the tx address
     */
    public AddressString getTxAddress() {
        return address;
    }
}
