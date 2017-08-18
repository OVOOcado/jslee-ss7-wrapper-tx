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

import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.SubscriberInfo;
import pl.ovoo.jslee.ss7.wrapper.map.args.MAPLocationInformationWrapper;
import pl.ovoo.jslee.ss7.wrapper.map.args.MAPSubscriberInfoWrapper;


/**
 * TxMAPSubscriberInfoWrapper.
 *
 * @author kacper.mosienski@ovoo.pl
 */
public class TxMAPSubscriberInfoWrapper implements MAPSubscriberInfoWrapper {

    /** The subscriber info. */
    private final SubscriberInfo subscriberInfo;

    /**
     * Instantiates a new tx map subscriber info wrapper.
     *
     * @param subscriberInfo the subscriber info
     */
    public TxMAPSubscriberInfoWrapper(final SubscriberInfo subscriberInfo) {
        this.subscriberInfo = subscriberInfo;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.map.args.MAPSubscriberInfoWrapper#hasLocationInformation()
     */
    @Override
    public boolean hasLocationInformation() {
        return subscriberInfo.getLocationInformation() != null;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.map.args.MAPSubscriberInfoWrapper#getLocationInformation()
     */
    @Override
    public MAPLocationInformationWrapper getLocationInformation() {
        if (subscriberInfo.getLocationInformation() != null) {
            return new TxMAPLocationInformationWrapper(subscriberInfo.getLocationInformation());
        }
        return null;
    }

    /**
     * Gets the tx subscriber info.
     *
     * @return the tx subscriber info
     */
    public SubscriberInfo getTxSubscriberInfo() {
        return subscriberInfo;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "TxMAPSubscriberInfoWrapper [subscriberInfo=" + subscriberInfo + "]";
    }

}
