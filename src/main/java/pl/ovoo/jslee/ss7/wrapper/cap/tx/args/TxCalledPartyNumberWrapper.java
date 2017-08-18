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
import org.mobicents.protocols.ss7.cap.api.isup.CalledPartyNumberCap;
import pl.ovoo.jslee.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.jslee.ss7.wrapper.cap.args.CalledPartyNumberWrapper;


/**
 * OcCallingPartyNumberWrapper.
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxCalledPartyNumberWrapper implements CalledPartyNumberWrapper {

	/** The called party number. */
	private final CalledPartyNumberCap calledPartyNumber;

	/**
	 * Instantiates a new tx called party number wrapper.
	 *
	 * @param calledPartyNumber the called party number
	 */
	public TxCalledPartyNumberWrapper(final CalledPartyNumberCap calledPartyNumber) {
		this.calledPartyNumber = calledPartyNumber;
	}

	/* (non-Javadoc)
	 * @see pl.ovoo.jslee.ss7.wrapper.cap.args.CalledPartyNumberWrapper#getAddress()
	 */
	@Override
	public String getAddress() throws Ss7WrapperException {
		try {
			return calledPartyNumber.getCalledPartyNumber().getAddress();
		} catch (CAPException e) {
			throw new Ss7WrapperException(e);
		}
	}

	/* (non-Javadoc)
	 * @see pl.ovoo.jslee.ss7.wrapper.cap.args.CalledPartyNumberWrapper#getNature()
	 */
	@Override
	public Nature getNature() throws Ss7WrapperException {
		try {
			return Nature.valueOf(calledPartyNumber.getCalledPartyNumber().getNatureOfAddressIndicator());
		} catch (CAPException e) {
			throw new Ss7WrapperException(e);
		}
	}

	/* (non-Javadoc)
	 * @see pl.ovoo.jslee.ss7.wrapper.cap.args.CalledPartyNumberWrapper#getNumberingPlan()
	 */
	@Override
	public NumberingPlan getNumberingPlan() throws Ss7WrapperException {
		try {
			return NumberingPlan.valueOf(calledPartyNumber.getCalledPartyNumber().getNumberingPlanIndicator());
		} catch (CAPException e) {
			throw new Ss7WrapperException(e);
		}
	}

	/* (non-Javadoc)
	 * @see pl.ovoo.jslee.ss7.wrapper.cap.args.CalledPartyNumberWrapper#hasAddress()
	 */
	@Override
	public boolean hasAddress() throws Ss7WrapperException {
		try {
			return calledPartyNumber.getCalledPartyNumber() != null;
		} catch (CAPException e) {
			throw new Ss7WrapperException(e);
		}
	}

	/* (non-Javadoc)
	 * @see pl.ovoo.jslee.ss7.wrapper.cap.args.CalledPartyNumberWrapper#hasNature()
	 */
	@Override
	public boolean hasNature() throws Ss7WrapperException {
		try {
			return calledPartyNumber.getCalledPartyNumber() != null;
		} catch (CAPException e) {
			throw new Ss7WrapperException(e);
		}
	}

	/* (non-Javadoc)
	 * @see pl.ovoo.jslee.ss7.wrapper.cap.args.CalledPartyNumberWrapper#hasNumberingPlan()
	 */
	@Override
	public boolean hasNumberingPlan() throws Ss7WrapperException {
		try {
			return calledPartyNumber.getCalledPartyNumber() != null;
		} catch (CAPException e) {
			throw new Ss7WrapperException(e);
		}
	}

	/* (non-Javadoc)
	 * @see pl.ovoo.jslee.ss7.wrapper.cap.args.CalledPartyNumberWrapper#getRoutingToInternalNetworkNumber()
	 */
	@Override
	public RoutingToInternalNetworkNumber getRoutingToInternalNetworkNumber() throws Ss7WrapperException {
		try {
			return RoutingToInternalNetworkNumber
					.valueOf(calledPartyNumber.getCalledPartyNumber().getInternalNetworkNumberIndicator());
		} catch (CAPException e) {
			throw new Ss7WrapperException(e);
		}
	}

	/**
	 * Gets the tx called party number.
	 *
	 * @return the tx called party number
	 */
	public CalledPartyNumberCap getTxCalledPartyNumber() {
		return calledPartyNumber;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TxCalledPartyNumberWrapper [calledPartyNumber=" + calledPartyNumber + "]";
	}

}
