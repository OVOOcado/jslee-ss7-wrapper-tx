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
import org.mobicents.protocols.ss7.cap.api.isup.OriginalCalledNumberCap;
import pl.ovoo.jslee.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.jslee.ss7.wrapper.cap.args.OriginalCalledNumberWrapper;


/**
 * TxOriginalCalledNumberWrapper.
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxOriginalCalledNumberWrapper implements OriginalCalledNumberWrapper {

	/** The original called number. */
	private final OriginalCalledNumberCap originalCalledNumber;

	/**
	 * Instantiates a new tx original called number wrapper.
	 *
	 * @param originalCalledNumber the original called number
	 */
	public TxOriginalCalledNumberWrapper(final OriginalCalledNumberCap originalCalledNumber) {
		this.originalCalledNumber = originalCalledNumber;
	}

	/**
	 * Gets the tx original called number.
	 *
	 * @return the tx original called number
	 */
	public OriginalCalledNumberCap getTxOriginalCalledNumber() {
		return originalCalledNumber;
	}

	/* (non-Javadoc)
	 * @see pl.ovoo.jslee.ss7.wrapper.cap.args.OriginalCalledNumberWrapper#hasAddress()
	 */
	@Override
	public boolean hasAddress() throws Ss7WrapperException {
		try {
			return originalCalledNumber.getOriginalCalledNumber() != null
					&& originalCalledNumber.getOriginalCalledNumber().getAddress() != null;
		} catch (CAPException e) {
			throw new Ss7WrapperException(e);
		}
	}

	/* (non-Javadoc)
	 * @see pl.ovoo.jslee.ss7.wrapper.cap.args.OriginalCalledNumberWrapper#hasNature()
	 */
	@Override
	public boolean hasNature() throws Ss7WrapperException {
		try {
			return originalCalledNumber.getOriginalCalledNumber() != null;
		} catch (CAPException e) {
			throw new Ss7WrapperException(e);
		}
	}

	/* (non-Javadoc)
	 * @see pl.ovoo.jslee.ss7.wrapper.cap.args.OriginalCalledNumberWrapper#hasNumberingPlan()
	 */
	@Override
	public boolean hasNumberingPlan() throws Ss7WrapperException {
		try {
			return originalCalledNumber.getOriginalCalledNumber() != null;
		} catch (CAPException e) {
			throw new Ss7WrapperException(e);
		}
	}

	/* (non-Javadoc)
	 * @see pl.ovoo.jslee.ss7.wrapper.cap.args.OriginalCalledNumberWrapper#getAddress()
	 */
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

	/* (non-Javadoc)
	 * @see pl.ovoo.jslee.ss7.wrapper.cap.args.OriginalCalledNumberWrapper#getPresentation()
	 */
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

	/* (non-Javadoc)
	 * @see pl.ovoo.jslee.ss7.wrapper.cap.args.OriginalCalledNumberWrapper#getNature()
	 */
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

	/* (non-Javadoc)
	 * @see pl.ovoo.jslee.ss7.wrapper.cap.args.OriginalCalledNumberWrapper#getNumberingPlan()
	 */
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TxOriginalCalledNumberWrapper [originalCalledNumber=" + originalCalledNumber + "]";
	}

}
