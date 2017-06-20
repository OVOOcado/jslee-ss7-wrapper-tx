/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.cap.telestax.args;

import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.cap.api.isup.CalledPartyNumberCap;
import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.args.CalledPartyNumberWrapper;

/**
 * OcCallingPartyNumberWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxCalledPartyNumberWrapper implements CalledPartyNumberWrapper {

	private final CalledPartyNumberCap calledPartyNumber;

	public TxCalledPartyNumberWrapper(final CalledPartyNumberCap calledPartyNumber) {
		this.calledPartyNumber = calledPartyNumber;
	}

	@Override
	public String getAddress() throws Ss7WrapperException {
		try {
			return calledPartyNumber.getCalledPartyNumber().getAddress();
		} catch (CAPException e) {
			throw new Ss7WrapperException(e);
		}
	}

	@Override
	public Nature getNature() throws Ss7WrapperException {
		try {
			return Nature.valueOf(calledPartyNumber.getCalledPartyNumber().getNatureOfAddressIndicator());
		} catch (CAPException e) {
			throw new Ss7WrapperException(e);
		}
	}

	@Override
	public NumberingPlan getNumberingPlan() throws Ss7WrapperException {
		try {
			return NumberingPlan.valueOf(calledPartyNumber.getCalledPartyNumber().getNumberingPlanIndicator());
		} catch (CAPException e) {
			throw new Ss7WrapperException(e);
		}
	}

	@Override
	public boolean hasAddress() throws Ss7WrapperException {
		try {
			return calledPartyNumber.getCalledPartyNumber() != null;
		} catch (CAPException e) {
			throw new Ss7WrapperException(e);
		}
	}

	@Override
	public boolean hasNature() throws Ss7WrapperException {
		try {
			return calledPartyNumber.getCalledPartyNumber() != null;
		} catch (CAPException e) {
			throw new Ss7WrapperException(e);
		}
	}

	@Override
	public boolean hasNumberingPlan() throws Ss7WrapperException {
		try {
			return calledPartyNumber.getCalledPartyNumber() != null;
		} catch (CAPException e) {
			throw new Ss7WrapperException(e);
		}
	}

	@Override
	public RoutingToInternalNetworkNumber getRoutingToInternalNetworkNumber() throws Ss7WrapperException {
		try {
			return RoutingToInternalNetworkNumber
					.valueOf(calledPartyNumber.getCalledPartyNumber().getInternalNetworkNumberIndicator());
		} catch (CAPException e) {
			throw new Ss7WrapperException(e);
		}
	}

	public CalledPartyNumberCap getTxCalledPartyNumber() {
		return calledPartyNumber;
	}

	@Override
	public String toString() {
		return "TxCalledPartyNumberWrapper [calledPartyNumber=" + calledPartyNumber + "]";
	}

}
