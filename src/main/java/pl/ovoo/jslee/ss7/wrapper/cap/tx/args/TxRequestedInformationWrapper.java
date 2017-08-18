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

import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.RequestedInformation;
import pl.ovoo.jslee.ss7.wrapper.cap.args.RequestedInformationType;
import pl.ovoo.jslee.ss7.wrapper.cap.args.RequestedInformationValueWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.RequestedInformationWrapper;


/**
 * OcRequestedInformationWrapper.
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxRequestedInformationWrapper implements RequestedInformationWrapper {

    /** The requested information value. */
    private transient RequestedInformationValueWrapper requestedInformationValue = null;

    /** The tx requested information. */
    private final RequestedInformation txRequestedInformation;

    /**
     * Instantiates a new tx requested information wrapper.
     *
     * @param requestedInformation the requested information
     */
    public TxRequestedInformationWrapper(final RequestedInformation requestedInformation) {
        this.txRequestedInformation = requestedInformation;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.RequestedInformationWrapper#hasRequestedInformationType()
     */
    @Override
    public boolean hasRequestedInformationType() {
        return txRequestedInformation.getRequestedInformationType() != null;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.RequestedInformationWrapper#getRequestedInformationType()
     */
    @Override
    public RequestedInformationType getRequestedInformationType() {
        if (txRequestedInformation.getRequestedInformationType() != null) {
            return RequestedInformationType.valueOf(txRequestedInformation.getRequestedInformationType().getCode());
        }
        return null;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.RequestedInformationWrapper#hasRequestedInformationValue()
     */
    @Override
    public boolean hasRequestedInformationValue() {
        return true;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.RequestedInformationWrapper#getRequestedInformationValue()
     */
    @Override
    public RequestedInformationValueWrapper getRequestedInformationValue() {
        if (this.requestedInformationValue == null && txRequestedInformation != null)
            this.requestedInformationValue = new TxRequestedInformationValueWrapper(txRequestedInformation);
        return this.requestedInformationValue;
    }

    /**
     * Gets the tx requested information.
     *
     * @return the tx requested information
     */
    public RequestedInformation getTxRequestedInformation() {
        return txRequestedInformation;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "TxRequestedInformationWrapper [txRequestedInformation=" + txRequestedInformation + "]";
    }

}
