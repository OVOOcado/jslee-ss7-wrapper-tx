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

import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.ExtSSInfo;
import pl.ovoo.jslee.ss7.wrapper.map.args.MAPForwardingInfoWrapper;
import pl.ovoo.jslee.ss7.wrapper.map.args.MAPSS_InformationWrapper;


/**
 * TxMAPSS_InformationWrapper.
 *
 * @author kacper.mosienski@ovoo.pl
 */
public class TxMAPSS_InformationWrapper implements MAPSS_InformationWrapper {

    /** The ext ss info. */
    private final ExtSSInfo extSSInfo;

    /**
     * Instantiates a new tx maps s_ information wrapper.
     *
     * @param extSSInfo the ext ss info
     */
    public TxMAPSS_InformationWrapper(final ExtSSInfo extSSInfo) {
        this.extSSInfo = extSSInfo;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.map.args.MAPSS_InformationWrapper#getForwardingInfo()
     */
    @Override
    public MAPForwardingInfoWrapper getForwardingInfo() {
        return new TxMAPForwardingInfoWrapper(extSSInfo.getForwardingInfo());
    }

    /**
     * Gets the tx ext ss info.
     *
     * @return the tx ext ss info
     */
    public ExtSSInfo getTxExtSSInfo() {
        return extSSInfo;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "TxMAPSS_InformationWrapper [extSSInfo=" + extSSInfo + "]";
    }

}
