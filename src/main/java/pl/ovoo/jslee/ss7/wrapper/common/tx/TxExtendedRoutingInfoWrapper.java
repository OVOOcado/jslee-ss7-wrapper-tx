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

package pl.ovoo.jslee.ss7.wrapper.common.tx;

import org.mobicents.protocols.ss7.map.api.service.callhandling.ExtendedRoutingInfo;
import org.mobicents.protocols.ss7.map.api.service.callhandling.RoutingInfo;

import pl.ovoo.jslee.ss7.wrapper.common.args.ExtendedRoutingInfoWrapper;
import pl.ovoo.jslee.ss7.wrapper.common.args.RoutingInfoWrapper;
import pl.ovoo.jslee.ss7.wrapper.common.args.AddressStringWrapper.Nature;
import pl.ovoo.jslee.ss7.wrapper.common.args.AddressStringWrapper.NumberingPlan;


/**
 * Created by karolsimka on 06.06.17.
 */
public class TxExtendedRoutingInfoWrapper implements ExtendedRoutingInfoWrapper {
    
    /** The routing info. */
    private final ExtendedRoutingInfo extendedRoutingInfo;

    /**
     * Instantiates a new tx routing info wrapper.
     *
     * @param routingInfo the routing info
     */
    public TxExtendedRoutingInfoWrapper(final ExtendedRoutingInfo extendedRoutingInfo) {
        this.extendedRoutingInfo = extendedRoutingInfo;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.common.args.RoutingInfoWrapper#getRoamingNumber()
     */
    @Override
    public RoutingInfoWrapper getRoutingInfo() {
        if (extendedRoutingInfo.getRoutingInfo() != null) {
            return new TxRoutingInfoWrapper(extendedRoutingInfo.getRoutingInfo());
        }
        return null;
    }

    /**
     * Gets the tx routing info.
     *
     * @return the tx routing info
     */
    public ExtendedRoutingInfo getTxExtendedRoutingInfo() {
        return extendedRoutingInfo;
    }

	@Override
	public String toString() {
		return "TxExtendedRoutingInfoWrapper [extendedRoutingInfo=" + extendedRoutingInfo + "]";
	}

}
