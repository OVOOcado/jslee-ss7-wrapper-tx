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

import org.mobicents.protocols.ss7.map.api.service.callhandling.CallReferenceNumber;
import pl.ovoo.jslee.ss7.wrapper.cap.args.CallReferenceNumberWrapper;


/**
 * OcCallReferenceNumberWrapper.
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxCallReferenceNumberWrapper implements CallReferenceNumberWrapper {

	/** The call reference number. */
	private final CallReferenceNumber callReferenceNumber;

	/**
	 * Instantiates a new tx call reference number wrapper.
	 *
	 * @param callReferenceNumber the call reference number
	 */
	public TxCallReferenceNumberWrapper(final CallReferenceNumber callReferenceNumber) {
		this.callReferenceNumber = callReferenceNumber;
	}

	/* (non-Javadoc)
	 * @see pl.ovoo.jslee.ss7.wrapper.cap.args.CallReferenceNumberWrapper#getData()
	 */
	@Override
	public byte[] getData() {
		return callReferenceNumber.getData();
	}

	/**
	 * Gets the tx call reference number.
	 *
	 * @return the tx call reference number
	 */
	public CallReferenceNumber getTxCallReferenceNumber() {
		return callReferenceNumber;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TxCallReferenceNumberWrapper [callReferenceNumber=" + callReferenceNumber + "]";
	}

}
