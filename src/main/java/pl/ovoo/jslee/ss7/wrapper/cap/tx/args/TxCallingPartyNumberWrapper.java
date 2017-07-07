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

import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.cap.api.isup.CallingPartyNumberCap;
import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.args.CallingPartyNumberWrapper;

/**
 * OcCallingPartyNumberWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxCallingPartyNumberWrapper implements CallingPartyNumberWrapper {

	private final CallingPartyNumberCap callingPartyNumber;

	public TxCallingPartyNumberWrapper(final CallingPartyNumberCap callingPartyNumber) {
		this.callingPartyNumber = callingPartyNumber;
	}

	@Override
	public String getAddress() throws Ss7WrapperException {
		try {
			return callingPartyNumber.getCallingPartyNumber().getAddress();
		} catch (CAPException e) {
			throw new Ss7WrapperException(e);
		}
	}

	@Override
	public Nature getNature() throws Ss7WrapperException {
		try {
			if (callingPartyNumber.getCallingPartyNumber() != null) {
				return Nature.valueOf(callingPartyNumber.getCallingPartyNumber().getNatureOfAddressIndicator());
			}
			return null;
		} catch (CAPException e) {
			throw new Ss7WrapperException(e);
		}

	}

	@Override
	public NumberingPlan getNumberingPlan() throws Ss7WrapperException {
		try {
			if (callingPartyNumber.getCallingPartyNumber() != null) {
				return NumberingPlan.valueOf(callingPartyNumber.getCallingPartyNumber().getNumberingPlanIndicator());
			}
			return null;
		} catch (CAPException e) {
			throw new Ss7WrapperException(e);
		}
	}

	@Override
	public Presentation getPresentation() throws Ss7WrapperException {
		try {
			if (callingPartyNumber.getCallingPartyNumber() != null) {
				return Presentation.valueOf(
						callingPartyNumber.getCallingPartyNumber().getAddressRepresentationRestrictedIndicator());
			}
			return null;
		} catch (CAPException e) {
			throw new Ss7WrapperException(e);
		}
	}

	@Override
	public Screening getScreening() throws Ss7WrapperException {
		try {
			if (callingPartyNumber.getCallingPartyNumber() != null) {
				return Screening.valueOf(callingPartyNumber.getCallingPartyNumber().getScreeningIndicator());
			}
			return null;
		} catch (CAPException e) {
			throw new Ss7WrapperException(e);
		}
	}

	@Override
	public boolean hasAddress() throws Ss7WrapperException {
		try {
			return callingPartyNumber.getCallingPartyNumber() != null;
		} catch (CAPException e) {
			throw new Ss7WrapperException(e);
		}
	}

	@Override
	public boolean hasNature() throws Ss7WrapperException {
		try {
			return callingPartyNumber.getCallingPartyNumber() != null;
		} catch (CAPException e) {
			throw new Ss7WrapperException(e);
		}
	}

	@Override
	public boolean hasNumberingPlan() throws Ss7WrapperException {
		try {
			return callingPartyNumber.getCallingPartyNumber() != null;
		} catch (CAPException e) {
			throw new Ss7WrapperException(e);
		}
	}

	@Override
	public boolean hasPresentation() throws Ss7WrapperException {
		try {
			return callingPartyNumber.getCallingPartyNumber() != null;
		} catch (CAPException e) {
			throw new Ss7WrapperException(e);
		}
	}

	@Override
	public boolean hasScreening() throws Ss7WrapperException {
		try {
			return callingPartyNumber.getCallingPartyNumber() != null;
		} catch (CAPException e) {
			throw new Ss7WrapperException(e);
		}
	}

	public CallingPartyNumberCap getTxCallingPartyNumber() {
		return callingPartyNumber;
	}

	@Override
	public String toString() {
		return "TxCallingPartyNumberWrapper [callingPartyNumber=" + callingPartyNumber + "]";
	}

}
