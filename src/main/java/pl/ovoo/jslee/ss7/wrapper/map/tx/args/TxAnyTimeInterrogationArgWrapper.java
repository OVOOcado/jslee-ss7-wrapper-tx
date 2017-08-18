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

import org.mobicents.protocols.ss7.map.api.primitives.ISDNAddressString;
import org.mobicents.protocols.ss7.map.api.primitives.SubscriberIdentity;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.AnyTimeInterrogationRequest;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.RequestedInfo;

import pl.ovoo.jslee.ss7.wrapper.common.args.ISDNAddressStringWrapper;
import pl.ovoo.jslee.ss7.wrapper.common.tx.TxISDNAddressStringWrapperImpl;
import pl.ovoo.jslee.ss7.wrapper.map.args.AnyTimeInterrogationArgWrapper;


/**
 * TxAnyTimeInterrogationArgWrapper.
 *
 * @author kacper.mosienski@ovoo.pl
 */
public class TxAnyTimeInterrogationArgWrapper implements AnyTimeInterrogationArgWrapper {

    /** The gsm scf. */
    private transient ISDNAddressStringWrapper gsmScf = null;

    /** The any time interrogation request. */
    private AnyTimeInterrogationRequest anyTimeInterrogationRequest;

    /**
     * Instantiates a new tx any time interrogation arg wrapper.
     *
     * @param anyTimeInterrogationRequest the any time interrogation request
     */
    public TxAnyTimeInterrogationArgWrapper(final AnyTimeInterrogationRequest anyTimeInterrogationRequest) {
        this.anyTimeInterrogationRequest = anyTimeInterrogationRequest;
    }

    /**
     * Gets the tx subscriber identity.
     *
     * @return the tx subscriber identity
     */
    public SubscriberIdentity getTxSubscriberIdentity() {
        return anyTimeInterrogationRequest.getSubscriberIdentity();
    }

    /**
     * Gets the tx requested info.
     *
     * @return the tx requested info
     */
    public RequestedInfo getTxRequestedInfo() {
        return anyTimeInterrogationRequest.getRequestedInfo();
    }

    /**
     * Gets the tx gsm scf address.
     *
     * @return the tx gsm scf address
     */
    public ISDNAddressString getTxGsmScfAddress() {
        return anyTimeInterrogationRequest.getGsmSCFAddress();
    }

    /**
     * Gets the tx any time interrogation request.
     *
     * @return the tx any time interrogation request
     */
    public AnyTimeInterrogationRequest getTxAnyTimeInterrogationRequest() {
        return anyTimeInterrogationRequest;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.map.args.AnyTimeInterrogationArgWrapper#getGsmScf()
     */
    @Override
    public ISDNAddressStringWrapper getGsmScf() {
        if (this.gsmScf == null && anyTimeInterrogationRequest.getGsmSCFAddress() != null) {
            this.gsmScf = new TxISDNAddressStringWrapperImpl(anyTimeInterrogationRequest.getGsmSCFAddress());
        }
        return this.gsmScf;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "TxAnyTimeInterrogationArgWrapper [anyTimeInterrogationRequest=" + anyTimeInterrogationRequest + "]";
    }

}
