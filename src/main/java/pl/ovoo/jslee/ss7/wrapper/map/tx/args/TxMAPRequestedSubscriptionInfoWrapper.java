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

import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.RequestedSubscriptionInfo;
import pl.ovoo.jslee.ss7.wrapper.map.args.MAPRequestedSubscriptionInfoWrapper;


/**
 * TxMAPRequestedSubscriptionInfoWrapper.
 *
 * @author kacper.mosienski@ovoo.pl
 */
public class TxMAPRequestedSubscriptionInfoWrapper implements MAPRequestedSubscriptionInfoWrapper {

    /** The requested subscription info. */
    private final RequestedSubscriptionInfo requestedSubscriptionInfo;

    /**
     * Instantiates a new tx map requested subscription info wrapper.
     *
     * @param requestedSubscriptionInfo the requested subscription info
     */
    public TxMAPRequestedSubscriptionInfoWrapper(final RequestedSubscriptionInfo requestedSubscriptionInfo) {
        this.requestedSubscriptionInfo = requestedSubscriptionInfo;
    }

    /**
     * Gets the tx requested subscription info.
     *
     * @return the tx requested subscription info
     */
    public RequestedSubscriptionInfo getTxRequestedSubscriptionInfo() {
        return requestedSubscriptionInfo;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "TxMAPRequestedSubscriptionInfoWrapper [requestedSubscriptionInfo=" + requestedSubscriptionInfo + "]";
    }

}
