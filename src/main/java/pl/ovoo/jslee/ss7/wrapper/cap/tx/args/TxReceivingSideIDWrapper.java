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

import org.mobicents.protocols.ss7.cap.api.primitives.ReceivingSideID;
import pl.ovoo.jslee.ss7.wrapper.cap.args.LegType;
import pl.ovoo.jslee.ss7.wrapper.cap.args.ReceivingSideIDWrapper;


/**
 * TxReceivingSideIDWrapper.
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxReceivingSideIDWrapper implements ReceivingSideIDWrapper {

	/** The receiving side id. */
	private final ReceivingSideID receivingSideID;

	/**
	 * Instantiates a new tx receiving side id wrapper.
	 *
	 * @param receivingSideID the receiving side id
	 */
	public TxReceivingSideIDWrapper(final ReceivingSideID receivingSideID) {
		this.receivingSideID = receivingSideID;
	}

	/* (non-Javadoc)
	 * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ReceivingSideIDWrapper#getReceivingSideID()
	 */
	@Override
	public LegType getReceivingSideID() {
		if (receivingSideID.getReceivingSideID() != null) {
			return LegType.valueOf(receivingSideID.getReceivingSideID().getCode());
		}
		return null;
	}

	/**
	 * Gets the tx receiving side id.
	 *
	 * @return the tx receiving side id
	 */
	public ReceivingSideID getTxReceivingSideID() {
		return receivingSideID;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TxReceivingSideIDWrapper [receivingSideID=" + receivingSideID + "]";
	}

}
