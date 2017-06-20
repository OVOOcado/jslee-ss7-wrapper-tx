/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.cap.telestax.args;

import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.cap.api.isup.BearerCap;
import org.mobicents.protocols.ss7.isup.message.parameter.UserServiceInformation;
import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.args.BearerCapWrapper;
import pl.ovoo.ss7.wrapper.cap.args.ITU_TUserServiceInformationWrapper;

/**
 * TxBearerCapWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxBearerCapWrapper implements BearerCapWrapper {

	private transient ITU_TUserServiceInformationWrapper itu_TUserServiceInformation = null;

	private final BearerCap bearerCap;

	public TxBearerCapWrapper(final BearerCap bearerCap) {
		this.bearerCap = bearerCap;
	}

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

	@Override
	public byte[] getISO_IEC() {
		return bearerCap.getData();
	}

	public BearerCap getTxBearerCap() {
		return bearerCap;
	}

	@Override
	public String toString() {
		return "TxBearerCapWrapper [bearerCap=" + bearerCap + "]";
	}

}
