/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.cap.telestax.args;

import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.MessageID;
import pl.ovoo.ss7.wrapper.cap.args.MessageIDWrapper;

/**
 * TxMessageIDWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxMessageIDWrapper implements MessageIDWrapper {

    private final MessageID messageID;

    public TxMessageIDWrapper(final MessageID messageID) {
        this.messageID = messageID;
    }

    public MessageID getTxMessageID() {
        return messageID;
    }

	@Override
	public String toString() {
		return "TxMessageIDWrapper [messageID=" + messageID + "]";
	}
    
}
