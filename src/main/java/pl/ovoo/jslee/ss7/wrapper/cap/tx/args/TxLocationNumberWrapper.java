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
import org.mobicents.protocols.ss7.cap.api.isup.LocationNumberCap;

import pl.ovoo.jslee.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.jslee.ss7.wrapper.cap.args.LocationNumberWrapper;


/**
 * TxLocationNumberWrapper.
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxLocationNumberWrapper implements LocationNumberWrapper {

	/** The location number. */
	private final LocationNumberCap locationNumber;

	/**
	 * Instantiates a new tx location number wrapper.
	 *
	 * @param locationNumber the location number
	 */
	public TxLocationNumberWrapper(final LocationNumberCap locationNumber) {
		this.locationNumber = locationNumber;
	}

	/* (non-Javadoc)
	 * @see pl.ovoo.jslee.ss7.wrapper.cap.args.LocationNumberWrapper#getAddress()
	 */
	@Override
	public String getAddress() throws Ss7WrapperException {
		try {
			return locationNumber.getLocationNumber().getAddress();
		} catch (CAPException e) {
			throw new Ss7WrapperException(e);
		}
	}

	/* (non-Javadoc)
	 * @see pl.ovoo.jslee.ss7.wrapper.cap.args.LocationNumberWrapper#getNature()
	 */
	@Override
	public Nature getNature() throws Ss7WrapperException {
		try {
			return Nature.valueOf(locationNumber.getLocationNumber().getNatureOfAddressIndicator());
		} catch (CAPException e) {
			throw new Ss7WrapperException(e);
		}
	}

	/* (non-Javadoc)
	 * @see pl.ovoo.jslee.ss7.wrapper.cap.args.LocationNumberWrapper#getNumberingPlan()
	 */
	@Override
	public NumberingPlan getNumberingPlan() throws Ss7WrapperException {
		try {
			return NumberingPlan.valueOf(locationNumber.getLocationNumber().getNumberingPlanIndicator());
		} catch (CAPException e) {
			throw new Ss7WrapperException(e);
		}
	}

	/* (non-Javadoc)
	 * @see pl.ovoo.jslee.ss7.wrapper.cap.args.LocationNumberWrapper#hasAddress()
	 */
	@Override
	public boolean hasAddress() throws Ss7WrapperException {
		try {
			return locationNumber.getLocationNumber() != null;
		} catch (CAPException e) {
			throw new Ss7WrapperException(e);
		}
	}

	/* (non-Javadoc)
	 * @see pl.ovoo.jslee.ss7.wrapper.cap.args.LocationNumberWrapper#hasNature()
	 */
	@Override
	public boolean hasNature() throws Ss7WrapperException {
		try {
			return locationNumber.getLocationNumber() != null;
		} catch (CAPException e) {
			throw new Ss7WrapperException(e);
		}
	}

	/* (non-Javadoc)
	 * @see pl.ovoo.jslee.ss7.wrapper.cap.args.LocationNumberWrapper#hasNumberingPlan()
	 */
	@Override
	public boolean hasNumberingPlan() throws Ss7WrapperException {
		try {
			return locationNumber.getLocationNumber() != null;
		} catch (CAPException e) {
			throw new Ss7WrapperException(e);
		}
	}

	/* (non-Javadoc)
	 * @see pl.ovoo.jslee.ss7.wrapper.cap.args.LocationNumberWrapper#getRoutingToInternalNetworkNumber()
	 */
	@Override
	public RoutingToInternalNetworkNumber getRoutingToInternalNetworkNumber() throws Ss7WrapperException {
		try {
			return RoutingToInternalNetworkNumber
					.valueOf(locationNumber.getLocationNumber().getInternalNetworkNumberIndicator());
		} catch (CAPException e) {
			throw new Ss7WrapperException(e);
		}
	}

	/* (non-Javadoc)
	 * @see pl.ovoo.jslee.ss7.wrapper.cap.args.LocationNumberWrapper#getAddressRepresentationRestrictedIndicator()
	 */
	@Override	
	public int getAddressRepresentationRestrictedIndicator() throws Ss7WrapperException{
		try {
			return locationNumber.getLocationNumber().getAddressRepresentationRestrictedIndicator();
		} catch (CAPException e) {
			throw new Ss7WrapperException(e);
		}
	}

	/* (non-Javadoc)
	 * @see pl.ovoo.jslee.ss7.wrapper.cap.args.LocationNumberWrapper#getInternalNetworkNumberIndicator()
	 */
	@Override	
	public int getInternalNetworkNumberIndicator() throws Ss7WrapperException{
		try {
			return locationNumber.getLocationNumber().getInternalNetworkNumberIndicator();
		} catch (CAPException e) {
			throw new Ss7WrapperException(e);
		}
	}

	/* (non-Javadoc)
	 * @see pl.ovoo.jslee.ss7.wrapper.cap.args.LocationNumberWrapper#getScreeningIndicator()
	 */
	@Override	
	public int getScreeningIndicator() throws Ss7WrapperException{
		try {
			return locationNumber.getLocationNumber().getScreeningIndicator();
		} catch (CAPException e) {
			throw new Ss7WrapperException(e);
		}
	}

	/**
	 * Gets the tx location number.
	 *
	 * @return the tx location number
	 */
	public LocationNumberCap getTxLocationNumber() {
		return locationNumber;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TxLocationNumberWrapper [locationNumber=" + locationNumber + "]";
	}

}
