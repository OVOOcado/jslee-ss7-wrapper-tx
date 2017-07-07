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

package pl.ovoo.ss7.wrapper.cap.telestax.args;

import org.mobicents.protocols.ss7.inap.api.primitives.MiscCallInfo;
import pl.ovoo.ss7.wrapper.cap.args.MiscCallInfoWrapper;

/**
 * OcMiscCallInfoWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxMiscCallInfoWrapper implements MiscCallInfoWrapper {

	private final MiscCallInfo txMiscCallInfo;

	public TxMiscCallInfoWrapper(final MiscCallInfo miscCallInfo) {
		this.txMiscCallInfo = miscCallInfo;
	}

	@Override
	public MessageType getMessageType() {
		if (txMiscCallInfo.getMessageType() != null) {
			return MessageType.valueOf(txMiscCallInfo.getMessageType().getCode());
		}
		return null;
	}

	@Override
	public boolean hasMessageType() {
		return txMiscCallInfo.getMessageType() != null;
	}

	public MiscCallInfo getTxMiscCallInfo() {
		return txMiscCallInfo;
	}

	@Override
	public String toString() {
		return "TxMiscCallInfoWrapper [txMiscCallInfo=" + txMiscCallInfo + "]";
	}

}
