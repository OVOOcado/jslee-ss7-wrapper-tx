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

package pl.ovoo.jslee.ss7.wrapper.map.tx.args;

import org.mobicents.protocols.ss7.map.api.errors.MAPErrorMessage;

import pl.ovoo.jslee.ss7.wrapper.map.args.MAPErrorMessageWrapper;
import pl.ovoo.jslee.ss7.wrapper.map.args.MAPErrorWrapper;


/**
 * TxMAPSubscriberIdentityWrapper.
 *
 * @author kacper.mosienski@ovoo.pl
 */
public class TxMAPErrorWrapper implements MAPErrorWrapper {
    
    /** The map error message wrapper. */
    private MAPErrorMessageWrapper mapErrorMessageWrapper;

    /** The m ap error message. */
    private final MAPErrorMessage mAPErrorMessage;

    /**
     * Instantiates a new tx map error wrapper.
     *
     * @param mAPErrorMessage the m ap error message
     */
    public TxMAPErrorWrapper(final MAPErrorMessage mAPErrorMessage) {
        this.mAPErrorMessage = mAPErrorMessage;
    }

    /**
     * Gets the tx map error message.
     *
     * @return the tx map error message
     */
    public MAPErrorMessage getTxMAPErrorMessage() {
        return mAPErrorMessage;
    }
    
    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.map.args.MAPErrorWrapper#getMapErrorMessage()
     */
    @Override
    public MAPErrorMessageWrapper getMapErrorMessage() {
        if (this.mapErrorMessageWrapper == null && mAPErrorMessage != null){
            this.mapErrorMessageWrapper = new TxMAPErrorMessageWrapper(mAPErrorMessage);
        }
        return this.mapErrorMessageWrapper;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "TxMAPErrorWrapper [mAPErrorMessage=" + mAPErrorMessage + "]";
    }


}
