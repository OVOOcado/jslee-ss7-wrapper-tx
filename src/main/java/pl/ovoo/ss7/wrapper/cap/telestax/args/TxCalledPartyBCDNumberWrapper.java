/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.cap.telestax.args;

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
