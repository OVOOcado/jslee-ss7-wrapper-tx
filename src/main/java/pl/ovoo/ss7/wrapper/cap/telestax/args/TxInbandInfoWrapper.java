/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.cap.telestax.args;

import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.InbandInfo;
import pl.ovoo.ss7.wrapper.cap.args.InbandInfoWrapper;

/**
 * TxInbandInfoWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxInbandInfoWrapper implements InbandInfoWrapper {

	private final InbandInfo inbandInfo;

	public TxInbandInfoWrapper(final InbandInfo inbandInfo) {
		this.inbandInfo = inbandInfo;
	}

	public InbandInfo getTxInbandInfo() {
		return inbandInfo;
	}

	@Override
	public String toString() {
		return "TxInbandInfoWrapper [inbandInfo=" + inbandInfo + "]";
	}

}
