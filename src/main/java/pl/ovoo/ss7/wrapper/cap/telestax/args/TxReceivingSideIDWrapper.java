/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.cap.telestax.args;

import org.mobicents.protocols.ss7.cap.api.primitives.ReceivingSideID;
import pl.ovoo.ss7.wrapper.cap.args.LegType;
import pl.ovoo.ss7.wrapper.cap.args.ReceivingSideIDWrapper;

/**
 * TxReceivingSideIDWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxReceivingSideIDWrapper implements ReceivingSideIDWrapper {

	private final ReceivingSideID receivingSideID;

	public TxReceivingSideIDWrapper(final ReceivingSideID receivingSideID) {
		this.receivingSideID = receivingSideID;
	}

	@Override
	public LegType getReceivingSideID() {
		if (receivingSideID.getReceivingSideID() != null) {
			return LegType.valueOf(receivingSideID.getReceivingSideID().getCode());
		}
		return null;
	}

	public ReceivingSideID getTxReceivingSideID() {
		return receivingSideID;
	}

	@Override
	public String toString() {
		return "TxReceivingSideIDWrapper [receivingSideID=" + receivingSideID + "]";
	}

}
