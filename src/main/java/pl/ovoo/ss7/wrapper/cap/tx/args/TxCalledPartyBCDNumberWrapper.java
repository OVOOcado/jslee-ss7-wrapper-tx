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

package pl.ovoo.ss7.wrapper.cap.tx.args;

import org.mobicents.protocols.ss7.cap.api.primitives.CalledPartyBCDNumber;
import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.args.CalledPartyBCDNumberWrapper;

/**
 * OcCallingPartyNumberWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxCalledPartyBCDNumberWrapper implements CalledPartyBCDNumberWrapper {

	private final CalledPartyBCDNumber calledPartyBCDNumber;

	public TxCalledPartyBCDNumberWrapper(final CalledPartyBCDNumber calledPartyBCDNumber) {
		this.calledPartyBCDNumber = calledPartyBCDNumber;
	}

	@Override
	public String getAddress() {
		return calledPartyBCDNumber.getAddress();
	}

	@Override
	public NumberType getNumberType() {
		if (calledPartyBCDNumber.getAddressNature() != null) {
			return NumberType.valueOf(calledPartyBCDNumber.getAddressNature().getIndicator());
		}
		return null;
	}

	@Override
	public NumberingPlan getNumberingPlan() {
		if (calledPartyBCDNumber.getNumberingPlan() != null) {
			return NumberingPlan.valueOf(calledPartyBCDNumber.getNumberingPlan().getIndicator());
		}
		return null;
	}

	@Override
	public boolean hasAddress() throws Ss7WrapperException {
		return calledPartyBCDNumber.getAddress() != null;
	}

	@Override
	public boolean hasNumberType() throws Ss7WrapperException {
		return calledPartyBCDNumber.getAddressNature() != null;
	}

	@Override
	public boolean hasNumberingPlan() throws Ss7WrapperException {
		return calledPartyBCDNumber.getNumberingPlan() != null;
	}

	public CalledPartyBCDNumber getTxCalledPartyBCDNumber() {
		return calledPartyBCDNumber;
	}

	@Override
	public String toString() {
		return "TxCalledPartyBCDNumberWrapper [calledPartyBCDNumber=" + calledPartyBCDNumber + "]";
	}

}
