/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.cap.telestax.args;

import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.ExtTeleserviceCode;
import pl.ovoo.ss7.wrapper.cap.args.ExtTeleserviceCodeWrapper;

/**
 * TxExtTeleserviceCodeWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxExtTeleserviceCodeWrapper implements ExtTeleserviceCodeWrapper {

	private final ExtTeleserviceCode extTeleserviceCode;

	public TxExtTeleserviceCodeWrapper(final ExtTeleserviceCode extTeleserviceCode) {
		this.extTeleserviceCode = extTeleserviceCode;
	}

	@Override
	public byte[] getData() {
		return extTeleserviceCode.getData();
	}

	@Override
	public String toString() {
		return "TxExtTeleserviceCodeWrapper [extTeleserviceCode=" + extTeleserviceCode + "]";
	}

}
