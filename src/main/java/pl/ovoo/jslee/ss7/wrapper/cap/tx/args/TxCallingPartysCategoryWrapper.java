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

import org.mobicents.protocols.ss7.inap.api.INAPException;
import org.mobicents.protocols.ss7.inap.api.isup.CallingPartysCategoryInap;
import pl.ovoo.jslee.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.jslee.ss7.wrapper.cap.args.CallingPartysCategoryWrapper;


/**
 * OcCallingPartysCategoryWrapper.
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxCallingPartysCategoryWrapper implements CallingPartysCategoryWrapper {

	/** The calling partys category. */
	private final CallingPartysCategoryInap callingPartysCategory;

	/**
	 * Instantiates a new tx calling partys category wrapper.
	 *
	 * @param callingPartysCategory the calling partys category
	 */
	public TxCallingPartysCategoryWrapper(final CallingPartysCategoryInap callingPartysCategory) {
		this.callingPartysCategory = callingPartysCategory;
	}

	/* (non-Javadoc)
	 * @see pl.ovoo.jslee.ss7.wrapper.cap.args.CallingPartysCategoryWrapper#hasCategory()
	 */
	@Override
	public boolean hasCategory() throws Ss7WrapperException {
		try {
			return callingPartysCategory.getCallingPartyCategory() != null;
		} catch (INAPException e) {
			throw new Ss7WrapperException(e);
		}
	}

	/* (non-Javadoc)
	 * @see pl.ovoo.jslee.ss7.wrapper.cap.args.CallingPartysCategoryWrapper#getCategory()
	 */
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TxCallingPartysCategoryWrapper [callingPartysCategory=" + callingPartysCategory + "]";
	}

}
