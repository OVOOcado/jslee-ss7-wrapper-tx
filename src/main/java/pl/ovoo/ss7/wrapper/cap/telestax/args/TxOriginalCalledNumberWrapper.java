/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.cap.telestax.args;

import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.cap.api.isup.OriginalCalledNumberCap;
import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.args.OriginalCalledNumberWrapper;

/**
 * TxOriginalCalledNumberWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxOriginalCalledNumberWrapper implements OriginalCalledNumberWrapper {

	private final OriginalCalledNumberCap originalCalledNumber;

	public TxOriginalCalledNumberWrapper(final OriginalCalledNumberCap originalCalledNumber) {
		this.originalCalledNumber = originalCalledNumber;
	}

	public OriginalCalledNumberCap getTxOriginalCalledNumber() {
		return originalCalledNumber;
	}

	@Override
	public boolean hasAddress() throws Ss7WrapperException {
		try {
			return originalCalledNumber.getOriginalCalledNumber() != null
					&& originalCalledNumber.getOriginalCalledNumber().getAddress() != null;
		} catch (CAPException e) {
			throw new Ss7WrapperException(e);
		}
	}

	@Override
	public boolean hasNature() throws Ss7WrapperException {
		try {
			return originalCalledNumber.getOriginalCalledNumber() != null;
		} catch (CAPException e) {
			throw new Ss7WrapperException(e);
		}
	}

	@Override
	public boolean hasNumberingPlan() throws Ss7WrapperException {
		try {
			return originalCalledNumber.getOriginalCalledNumber() != null;
		} catch (CAPException e) {
			throw new Ss7WrapperException(e);
		}
	}

	@Override
	public String getAddress() throws Ss7WrapperException {
		try {
			if (originalCalledNumber.getOriginalCalledNumber() != null) {
				return originalCalledNumber.getOriginalCalledNumber().getAddress();
			}
		} catch (CAPException e) {
			throw new Ss7WrapperException(e);
		}
		return null;
	}

	@Override
	public Presentation getPresentation() throws Ss7WrapperException {
		try {
			if (originalCalledNumber.getOriginalCalledNumber() != null) {
				return Presentation.valueOf(
						originalCalledNumber.getOriginalCalledNumber().getAddressRepresentationRestrictedIndicator());
			}
			return null;
		} catch (CAPException e) {
			throw new Ss7WrapperException(e);
		}
	}

	@Override
	public Nature getNature() throws Ss7WrapperException {
		try {
			if (originalCalledNumber.getOriginalCalledNumber() != null) {
				return Nature.valueOf(originalCalledNumber.getOriginalCalledNumber().getNatureOfAddressIndicator());
			}
			return null;
		} catch (CAPException e) {
			throw new Ss7WrapperException(e);
		}
	}

	@Override
	public NumberingPlan getNumberingPlan() throws Ss7WrapperException {
		try {
			if (originalCalledNumber.getOriginalCalledNumber() != null) {
				return NumberingPlan
						.valueOf(originalCalledNumber.getOriginalCalledNumber().getNumberingPlanIndicator());
			}
			return null;
		} catch (CAPException e) {
			throw new Ss7WrapperException(e);
		}
	}

	@Override
	public String toString() {
		return "TxOriginalCalledNumberWrapper [originalCalledNumber=" + originalCalledNumber + "]";
	}

}
