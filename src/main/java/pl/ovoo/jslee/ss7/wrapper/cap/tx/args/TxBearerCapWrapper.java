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
import org.mobicents.protocols.ss7.cap.api.isup.BearerCap;
import org.mobicents.protocols.ss7.isup.message.parameter.UserServiceInformation;
import pl.ovoo.jslee.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.jslee.ss7.wrapper.cap.args.BearerCapWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.ITU_TUserServiceInformationWrapper;


/**
 * TxBearerCapWrapper.
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxBearerCapWrapper implements BearerCapWrapper {

	/** The itu_ t user service information. */
	private transient ITU_TUserServiceInformationWrapper itu_TUserServiceInformation = null;

	/** The bearer cap. */
	private final BearerCap bearerCap;

	/**
	 * Instantiates a new tx bearer cap wrapper.
	 *
	 * @param bearerCap the bearer cap
	 */
	public TxBearerCapWrapper(final BearerCap bearerCap) {
		this.bearerCap = bearerCap;
	}

	/* (non-Javadoc)
	 * @see pl.ovoo.jslee.ss7.wrapper.cap.args.BearerCapWrapper#isITU_TChosen()
	 */
	@Override
	public boolean isITU_TChosen() throws Ss7WrapperException {
		try {
			if (bearerCap.getUserServiceInformation() != null) {
				return UserServiceInformation._CS_CCITT == bearerCap.getUserServiceInformation().getCodingStandart();
			}
			return false;
		} catch (CAPException e) {
			throw new Ss7WrapperException(e);
		}
	}

	/* (non-Javadoc)
	 * @see pl.ovoo.jslee.ss7.wrapper.cap.args.BearerCapWrapper#isISO_IECChosen()
	 */
	@Override
	public boolean isISO_IECChosen() throws Ss7WrapperException {
		try {
			if (bearerCap.getUserServiceInformation() != null) {
				return UserServiceInformation._CS_INTERNATIONAL == bearerCap.getUserServiceInformation()
						.getCodingStandart();
			}
			return false;
		} catch (CAPException e) {
			throw new Ss7WrapperException(e);
		}
	}

	/* (non-Javadoc)
	 * @see pl.ovoo.jslee.ss7.wrapper.cap.args.BearerCapWrapper#getITU_TUserServiceInformation()
	 */
	@Override
	public ITU_TUserServiceInformationWrapper getITU_TUserServiceInformation() throws Ss7WrapperException {
		try {
			if (itu_TUserServiceInformation == null && bearerCap != null) {
				this.itu_TUserServiceInformation = new TxITU_TUserServiceInformationWrapper(
						bearerCap.getUserServiceInformation());
			}
			return this.itu_TUserServiceInformation;
		} catch (CAPException e) {
			throw new Ss7WrapperException(e);
		}
	}

	/* (non-Javadoc)
	 * @see pl.ovoo.jslee.ss7.wrapper.cap.args.BearerCapWrapper#getISO_IEC()
	 */
	@Override
	public byte[] getISO_IEC() {
		return bearerCap.getData();
	}

	/**
	 * Gets the tx bearer cap.
	 *
	 * @return the tx bearer cap
	 */
	public BearerCap getTxBearerCap() {
		return bearerCap;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TxBearerCapWrapper [bearerCap=" + bearerCap + "]";
	}

}
