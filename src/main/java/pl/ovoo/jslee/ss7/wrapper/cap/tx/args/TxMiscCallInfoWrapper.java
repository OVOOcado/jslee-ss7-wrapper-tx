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

import org.mobicents.protocols.ss7.inap.api.primitives.MiscCallInfo;
import pl.ovoo.jslee.ss7.wrapper.cap.args.MiscCallInfoWrapper;


/**
 * OcMiscCallInfoWrapper.
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxMiscCallInfoWrapper implements MiscCallInfoWrapper {

	/** The tx misc call info. */
	private final MiscCallInfo txMiscCallInfo;

	/**
	 * Instantiates a new tx misc call info wrapper.
	 *
	 * @param miscCallInfo the misc call info
	 */
	public TxMiscCallInfoWrapper(final MiscCallInfo miscCallInfo) {
		this.txMiscCallInfo = miscCallInfo;
	}

	/* (non-Javadoc)
	 * @see pl.ovoo.jslee.ss7.wrapper.cap.args.MiscCallInfoWrapper#getMessageType()
	 */
	@Override
	public MessageType getMessageType() {
		if (txMiscCallInfo.getMessageType() != null) {
			return MessageType.valueOf(txMiscCallInfo.getMessageType().getCode());
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see pl.ovoo.jslee.ss7.wrapper.cap.args.MiscCallInfoWrapper#hasMessageType()
	 */
	@Override
	public boolean hasMessageType() {
		return txMiscCallInfo.getMessageType() != null;
	}

	/**
	 * Gets the tx misc call info.
	 *
	 * @return the tx misc call info
	 */
	public MiscCallInfo getTxMiscCallInfo() {
		return txMiscCallInfo;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TxMiscCallInfoWrapper [txMiscCallInfo=" + txMiscCallInfo + "]";
	}

}
