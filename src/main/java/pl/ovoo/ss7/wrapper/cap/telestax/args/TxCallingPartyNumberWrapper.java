/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.cap.telestax.args;

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
