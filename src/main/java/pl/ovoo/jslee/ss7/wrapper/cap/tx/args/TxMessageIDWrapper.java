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

import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.MessageID;
import pl.ovoo.jslee.ss7.wrapper.cap.args.MessageIDWrapper;


/**
 * TxMessageIDWrapper.
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxMessageIDWrapper implements MessageIDWrapper {

    /** The message id. */
    private final MessageID messageID;

    /**
     * Instantiates a new tx message id wrapper.
     *
     * @param messageID the message id
     */
    public TxMessageIDWrapper(final MessageID messageID) {
        this.messageID = messageID;
    }

    /**
     * Gets the tx message id.
     *
     * @return the tx message id
     */
    public MessageID getTxMessageID() {
        return messageID;
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TxMessageIDWrapper [messageID=" + messageID + "]";
	}
    
}
