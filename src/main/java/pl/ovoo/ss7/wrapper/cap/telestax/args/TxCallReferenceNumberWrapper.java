/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.cap.telestax.args;

import org.mobicents.protocols.ss7.map.api.service.callhandling.CallReferenceNumber;
import pl.ovoo.ss7.wrapper.cap.args.CallReferenceNumberWrapper;

/**
 * OcCallReferenceNumberWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxCallReferenceNumberWrapper implements CallReferenceNumberWrapper {

	private final CallReferenceNumber callReferenceNumber;

	public TxCallReferenceNumberWrapper(final CallReferenceNumber callReferenceNumber) {
		this.callReferenceNumber = callReferenceNumber;
	}

	@Override
	public byte[] getData() {
		return callReferenceNumber.getData();
	}

	public CallReferenceNumber getTxCallReferenceNumber() {
		return callReferenceNumber;
	}

	@Override
	public String toString() {
		return "TxCallReferenceNumberWrapper [callReferenceNumber=" + callReferenceNumber + "]";
	}

}
