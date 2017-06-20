/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.cap.telestax.args;

import org.mobicents.protocols.ss7.inap.api.INAPException;
import org.mobicents.protocols.ss7.inap.api.isup.CallingPartysCategoryInap;
import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.args.CallingPartysCategoryWrapper;

/**
 * OcCallingPartysCategoryWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxCallingPartysCategoryWrapper implements CallingPartysCategoryWrapper {

	private final CallingPartysCategoryInap callingPartysCategory;

	public TxCallingPartysCategoryWrapper(final CallingPartysCategoryInap callingPartysCategory) {
		this.callingPartysCategory = callingPartysCategory;
	}

	@Override
	public boolean hasCategory() throws Ss7WrapperException {
		try {
			return callingPartysCategory.getCallingPartyCategory() != null;
		} catch (INAPException e) {
			throw new Ss7WrapperException(e);
		}
	}

	@Override
	public Category getCategory() throws Ss7WrapperException {
		try {
			if (callingPartysCategory.getCallingPartyCategory() != null) {
				return Category.valueOf(callingPartysCategory.getCallingPartyCategory().getCallingPartyCategory());
			}
		} catch (INAPException e) {
			throw new Ss7WrapperException(e);
		}
		return null;
	}

	@Override
	public String toString() {
		return "TxCallingPartysCategoryWrapper [callingPartysCategory=" + callingPartysCategory + "]";
	}

}
