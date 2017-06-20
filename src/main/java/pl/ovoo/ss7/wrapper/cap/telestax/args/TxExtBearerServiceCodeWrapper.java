/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.cap.telestax.args;

import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.ExtBearerServiceCode;
import pl.ovoo.ss7.wrapper.cap.args.ExtBearerServiceCodeWrapper;

/**
 * TxExtBearerServiceCodeWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxExtBearerServiceCodeWrapper implements ExtBearerServiceCodeWrapper {

	private final ExtBearerServiceCode extBearerServiceCode;

	public TxExtBearerServiceCodeWrapper(final ExtBearerServiceCode extBearerServiceCode) {
		this.extBearerServiceCode = extBearerServiceCode;
	}

	@Override
	public byte[] getData() {
		return extBearerServiceCode.getData();
	}

	@Override
	public String toString() {
		return "TxExtBearerServiceCodeWrapper [extBearerServiceCode=" + extBearerServiceCode + "]";
	}

}
