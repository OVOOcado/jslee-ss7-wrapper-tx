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

import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.ExtForwInfo;
import pl.ovoo.jslee.ss7.wrapper.map.args.MAPForwardingFeatureWrapper;
import pl.ovoo.jslee.ss7.wrapper.map.args.MAPForwardingInfoWrapper;


/**
 * TxMAPForwardingInfoWrapper.
 *
 * @author kacper.mosienski@ovoo.pl
 */
public class TxMAPForwardingInfoWrapper implements MAPForwardingInfoWrapper {

    /** The map forwarding feature wrappers. */
    private transient MAPForwardingFeatureWrapper[] mapForwardingFeatureWrappers = null;

    /** The ext forw info. */
    private final ExtForwInfo extForwInfo;

    /**
     * Instantiates a new tx map forwarding info wrapper.
     *
     * @param extForwInfo the ext forw info
     */
    public TxMAPForwardingInfoWrapper(final ExtForwInfo extForwInfo) {
        this.extForwInfo = extForwInfo;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.map.args.MAPForwardingInfoWrapper#getForwardingFeatureList()
     */
    @Override
    public MAPForwardingFeatureWrapper[] getForwardingFeatureList() {
        if (this.mapForwardingFeatureWrappers == null && extForwInfo.getForwardingFeatureList() != null
                && extForwInfo.getForwardingFeatureList().size() > 0) {
            MAPForwardingFeatureWrapper[] txMAPForwardingFeatures = new MAPForwardingFeatureWrapper[extForwInfo
                    .getForwardingFeatureList().size()];
            for (int i = 0; i < extForwInfo.getForwardingFeatureList().size(); i++) {
                final MAPForwardingFeatureWrapper ocMAPForwardingFeature = new TxMAPForwardingFeatureWrapper(
                        extForwInfo.getForwardingFeatureList().get(i));
                txMAPForwardingFeatures[i] = ocMAPForwardingFeature;
            }
            this.mapForwardingFeatureWrappers = txMAPForwardingFeatures;
        }
        return this.mapForwardingFeatureWrappers;
    }

    /**
     * Gets the tx ext forw info.
     *
     * @return the tx ext forw info
     */
    public ExtForwInfo getTxExtForwInfo() {
        return extForwInfo;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "TxMAPForwardingInfoWrapper [extForwInfo=" + extForwInfo + "]";
    }

}
