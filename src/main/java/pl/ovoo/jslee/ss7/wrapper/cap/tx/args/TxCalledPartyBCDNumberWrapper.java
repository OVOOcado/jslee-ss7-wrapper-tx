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

package pl.ovoo.jslee.ss7.wrapper.cap.tx.args;

import org.mobicents.protocols.ss7.cap.api.primitives.CalledPartyBCDNumber;
import pl.ovoo.jslee.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.jslee.ss7.wrapper.cap.args.CalledPartyBCDNumberWrapper;


/**
 * OcCallingPartyNumberWrapper.
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxCalledPartyBCDNumberWrapper implements CalledPartyBCDNumberWrapper {

	/** The called party bcd number. */
	private final CalledPartyBCDNumber calledPartyBCDNumber;

	/**
	 * Instantiates a new tx called party bcd number wrapper.
	 *
	 * @param calledPartyBCDNumber the called party bcd number
	 */
	public TxCalledPartyBCDNumberWrapper(final CalledPartyBCDNumber calledPartyBCDNumber) {
		this.calledPartyBCDNumber = calledPartyBCDNumber;
	}

	/* (non-Javadoc)
	 * @see pl.ovoo.jslee.ss7.wrapper.cap.args.CalledPartyBCDNumberWrapper#getAddress()
	 */
	@Override
	public String getAddress() {
		return calledPartyBCDNumber.getAddress();
	}

	/* (non-Javadoc)
	 * @see pl.ovoo.jslee.ss7.wrapper.cap.args.CalledPartyBCDNumberWrapper#getNumberType()
	 */
	@Override
	public NumberType getNumberType() {
		if (calledPartyBCDNumber.getAddressNature() != null) {
			return NumberType.valueOf(calledPartyBCDNumber.getAddressNature().getIndicator());
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see pl.ovoo.jslee.ss7.wrapper.cap.args.CalledPartyBCDNumberWrapper#getNumberingPlan()
	 */
	@Override
	public NumberingPlan getNumberingPlan() {
		if (calledPartyBCDNumber.getNumberingPlan() != null) {
			return NumberingPlan.valueOf(calledPartyBCDNumber.getNumberingPlan().getIndicator());
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see pl.ovoo.jslee.ss7.wrapper.cap.args.CalledPartyBCDNumberWrapper#hasAddress()
	 */
	@Override
	public boolean hasAddress() throws Ss7WrapperException {
		return calledPartyBCDNumber.getAddress() != null;
	}

	/* (non-Javadoc)
	 * @see pl.ovoo.jslee.ss7.wrapper.cap.args.CalledPartyBCDNumberWrapper#hasNumberType()
	 */
	@Override
	public boolean hasNumberType() throws Ss7WrapperException {
		return calledPartyBCDNumber.getAddressNature() != null;
	}

	/* (non-Javadoc)
	 * @see pl.ovoo.jslee.ss7.wrapper.cap.args.CalledPartyBCDNumberWrapper#hasNumberingPlan()
	 */
	@Override
	public boolean hasNumberingPlan() throws Ss7WrapperException {
		return calledPartyBCDNumber.getNumberingPlan() != null;
	}

	/**
	 * Gets the tx called party bcd number.
	 *
	 * @return the tx called party bcd number
	 */
	public CalledPartyBCDNumber getTxCalledPartyBCDNumber() {
		return calledPartyBCDNumber;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TxCalledPartyBCDNumberWrapper [calledPartyBCDNumber=" + calledPartyBCDNumber + "]";
	}

}
