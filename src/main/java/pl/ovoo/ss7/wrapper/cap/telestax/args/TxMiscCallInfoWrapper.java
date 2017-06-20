/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
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
