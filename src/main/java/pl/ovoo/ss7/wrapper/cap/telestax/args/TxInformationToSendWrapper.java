/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.cap.telestax.args;

import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.InformationToSend;
import pl.ovoo.ss7.wrapper.cap.args.InformationToSendWrapper;

/**
 * TxInformationToSendWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxInformationToSendWrapper implements InformationToSendWrapper {

	private final InformationToSend informationToSend;

	public TxInformationToSendWrapper(final InformationToSend informationToSend) {
		this.informationToSend = informationToSend;
	}

	public InformationToSend getTxInformationToSend() {
		return informationToSend;
	}

	@Override
	public String toString() {
		return "TxInformationToSendWrapper [informationToSend=" + informationToSend + "]";
	}

}
